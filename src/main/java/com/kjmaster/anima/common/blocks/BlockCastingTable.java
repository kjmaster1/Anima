package com.kjmaster.anima.common.blocks;

import com.kjmaster.anima.Anima;
import com.kjmaster.anima.common.blocks.tile.TileCastingTable;
import com.kjmaster.anima.common.blocks.tile.tesr.CastingTableTESR;
import com.kjmaster.anima.common.init.IAnimaModel;
import com.kjmaster.anima.common.init.ModFluids;
import com.kjmaster.anima.utils.CapabilityUtils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.*;
import net.minecraftforge.fluids.capability.*;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class BlockCastingTable extends Block implements IAnimaModel {

    public BlockCastingTable() {
        super(Material.IRON);
        setUnlocalizedName("casting_table");
        setRegistryName("casting_table");
        setCreativeTab(Anima.animaTab);
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new TileCastingTable();
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        final IFluidHandler fluidHandler = getFluidHandler(worldIn, pos);
        Fluid fluid = null;
        IFluidHandlerItem fluidHandlerItem = null;

        ItemStack stack = playerIn.getHeldItem(hand);
        if (stack.hasCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null)) {
            fluidHandlerItem = stack.getCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null);
            if (fluidHandlerItem != null) {
                IFluidTankProperties[] fluidTankProperties = fluidHandlerItem.getTankProperties();

                for (final  IFluidTankProperties properties : fluidTankProperties) {
                    final FluidStack fluidStack = properties.getContents();
                    if (fluidStack != null) {
                        fluid = fluidStack.getFluid();
                    }
                }
            }
        }

        if (fluidHandler != null && fluidHandlerItem != null &&
                (fluid == null || fluid.equals(ModFluids.MOLTEN_SOUL_CRYSTAL))) {

            FluidUtil.interactWithFluidHandler(playerIn, hand, fluidHandler);

            IFluidTankProperties[] properties = fluidHandler.getTankProperties();

            for (final IFluidTankProperties property : properties) {
                final FluidStack fluidStack = property.getContents();

                if (fluidStack != null && fluid != null) {
                    int amount = fluidStack.amount;
                    String fluidName = fluid.getName();
                    Anima.logger.info("Fluid Amount: " + amount);
                    Anima.logger.info("Fluid Name: " + fluidName);
                }
            }

            return FluidUtil.getFluidHandler(playerIn.getHeldItem(hand)) != null;
        }

        if (!worldIn.isRemote) {
            TileCastingTable te = (TileCastingTable) worldIn.getTileEntity(pos);
            if (te != null && te.getStack().isEmpty()) {
                if (!playerIn.getHeldItem(hand).isEmpty()) {
                    te.setStack(new ItemStack(playerIn.getHeldItem(hand).getItem(), 1, playerIn.getHeldItem(hand).getMetadata()));
                    playerIn.getHeldItem(hand).shrink(1);
                    playerIn.openContainer.detectAndSendChanges();
                }
            } else if (te != null) {
                ItemStack stack1 = te.getStack();
                te.setStack(ItemStack.EMPTY);
                if (!playerIn.inventory.addItemStackToInventory(stack1)) {
                    EntityItem entityItem = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack1);
                    worldIn.spawnEntity(entityItem);
                } else {
                    playerIn.openContainer.detectAndSendChanges();
                }
            }
        }
        return true;
    }

    @Nullable
    private IFluidHandler getFluidHandler(IBlockAccess world, BlockPos pos) {
        return CapabilityUtils.getCapability(world.getTileEntity(pos), CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0,
                new ModelResourceLocation(getRegistryName(), "inventory"));
        ClientRegistry.bindTileEntitySpecialRenderer(TileCastingTable.class, new CastingTableTESR());
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isNormalCube(IBlockState state) {
        return false;
    }
}
