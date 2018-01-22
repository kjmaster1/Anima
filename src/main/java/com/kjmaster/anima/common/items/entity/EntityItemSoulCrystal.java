package com.kjmaster.anima.common.items.entity;

import com.kjmaster.anima.common.init.ModFluids;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityItemSoulCrystal extends EntityItem {

    public EntityItemSoulCrystal(World worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
        setPickupDelay(40);
        this.isImmuneToFire = true;
    }

    public EntityItemSoulCrystal(World worldIn, double x, double y, double z, ItemStack stack) {
        super(worldIn, x, y, z, stack);
        setPickupDelay(40);
        this.isImmuneToFire = true;
    }

    @Override
    protected void setOnFireFromLava() {
        BlockPos pos = this.getPosition();
        world.setBlockState(pos.offset(EnumFacing.DOWN), ModFluids.MOLTEN_SOUL_CRYSTAL.getBlock().getDefaultState());
        this.setDead();
    }

    @Override
    public void setPickupDelay(int ticks) {
        super.setPickupDelay(ticks);
    }

    @Override
    public void setDefaultPickupDelay() {
        super.setDefaultPickupDelay();
    }

    @Override
    public boolean cannotPickup() {
        return super.cannotPickup();
    }
}
