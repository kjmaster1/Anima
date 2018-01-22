package com.kjmaster.anima.common.blocks.tile;

import com.kjmaster.anima.common.recipe.CastingTableHandler;
import com.kjmaster.anima.common.recipe.CastingTableRecipe;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.util.ITickable;
import net.minecraftforge.fluids.capability.TileFluidHandler;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class TileCastingTable extends TileFluidHandler implements ITickable {

    private ItemStack stack = ItemStack.EMPTY;
    private int processTime;
    private boolean hadValidFluidAmount = false;

    public ItemStack getStack() {
        return stack;
    }

    public void setStack(ItemStack stack) {
        this.stack = stack;
        markDirty();
        if (world != null) {
            IBlockState state = world.getBlockState(pos);
            world.notifyBlockUpdate(pos, state, state, 3);
        }
    }

    private List<CastingTableRecipe> getRecipesForInput(ItemStack input) {
        List<CastingTableRecipe> validRecipes = new ArrayList<>();
        if (!input.isEmpty()) {
            for (CastingTableRecipe recipe : CastingTableHandler.ALL_RECIPES) {
                if (!recipe.input.isEmpty() && recipe.input.isItemEqual(input) &&
                        (tank.getFluidAmount() >= recipe.moltenSoulCrystalAmount || hadValidFluidAmount)) {
                    validRecipes.add(recipe);
                    hadValidFluidAmount = true;
                }
            }
        }
        return validRecipes;
    }

    @Override
    public void update() {
        if (!this.world.isRemote) {
            List<CastingTableRecipe> recipes = getRecipesForInput(getStack());
            if (!recipes.isEmpty()) {
                for (CastingTableRecipe recipe : recipes) {
                    this.processTime++;
                    boolean done = this.processTime >= recipe.time;

                    tank.drain(recipe.moltenSoulCrystalAmount / recipe.time, true);

                    if (done) {
                        this.setStack(recipe.output);
                        this.processTime = 0;
                        this.hadValidFluidAmount = false;
                        break;
                    }
                }
            } else {
                this.processTime = 0;
                this.hadValidFluidAmount = false;
            }
        }
    }

    @Override
    public NBTTagCompound getUpdateTag() {
        return writeToNBT(new NBTTagCompound());
    }

    @Nullable
    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        NBTTagCompound nbtTagCompound = new NBTTagCompound();
        this.writeToNBT(nbtTagCompound);
        return new SPacketUpdateTileEntity(pos, 1, nbtTagCompound);
    }

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
        this.readFromNBT(pkt.getNbtCompound());
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        if (tag.hasKey("item")) {
            stack = new ItemStack(tag.getCompoundTag("item"));
        } else {
            stack = ItemStack.EMPTY;
        }
        if (tag.hasKey("processTimeTag")) {
            NBTTagCompound tagCompound = tag.getCompoundTag("processTimeTag");
            processTime = tagCompound.getInteger("processTime");
        }
        if (tag.hasKey("validFluidTag")) {
            NBTTagCompound tagCompound = tag.getCompoundTag("validFluidTag");
            hadValidFluidAmount = tagCompound.getBoolean("validFluid");
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);
        if (!stack.isEmpty()) {
            NBTTagCompound tagCompound = new NBTTagCompound();
            stack.writeToNBT(tagCompound);
            tag.setTag("item", tagCompound);
        }
        if (processTime != 0) {
            NBTTagCompound tagCompound = new NBTTagCompound();
            tagCompound.setInteger("processTime", processTime);
            tag.setTag("processTimeTag", tagCompound);
        }
        NBTTagCompound tagCompound = new NBTTagCompound();
        tagCompound.setBoolean("validFluid", hadValidFluidAmount);
        tag.setTag("validFluidTag", tagCompound);
        return tag;
    }
}
