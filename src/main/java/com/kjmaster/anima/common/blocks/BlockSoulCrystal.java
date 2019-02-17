package com.kjmaster.anima.common.blocks;

import com.kjmaster.anima.Anima;
import com.kjmaster.anima.common.init.ModItems;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class BlockSoulCrystal extends BlockCrops {

    public BlockSoulCrystal() {
        setUnlocalizedName("soul_crystal_block");
        setRegistryName("soul_crystal_block");
        setCreativeTab(Anima.animaTab);
    }

    @Override
    protected Item getSeed() {
        return ModItems.soulCrystal;
    }

    @Override
    protected Item getCrop() {
        return ModItems.soulCrystal;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        return true;
    }
}
