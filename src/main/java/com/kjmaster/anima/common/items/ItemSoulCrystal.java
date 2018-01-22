package com.kjmaster.anima.common.items;

import com.kjmaster.anima.common.init.IAnimaModel;
import com.kjmaster.anima.common.init.ModBlocks;
import com.kjmaster.anima.common.items.entity.EntityItemSoulCrystal;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class ItemSoulCrystal extends ItemSeeds implements IAnimaModel {

    public ItemSoulCrystal() {
        super(ModBlocks.soulCrystal, Blocks.SOUL_SAND);
        setUnlocalizedName("soul_crystal_item");
        setRegistryName("soul_crystal_item");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void initModel() {
        if (getRegistryName() != null) { // check not needed, just here to make IDEA shut up.
            ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(),
                    "inventory"));
        }
    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
        return EnumPlantType.Nether;
    }

    @Override
    public boolean hasCustomEntity(ItemStack stack) {
        return true;
    }

    @Nullable
    @Override
    public Entity createEntity(World world, Entity location, ItemStack itemstack) {
        EntityItem entityItem = new EntityItemSoulCrystal(world, location.posX, location.posY, location.posZ, itemstack);
        entityItem.motionX = location.motionX;
        entityItem.motionY = location.motionY;
        entityItem.motionZ = location.motionZ;
        return entityItem;
    }
}
