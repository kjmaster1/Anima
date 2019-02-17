package com.kjmaster.anima.common.blocks;

import com.kjmaster.anima.Anima;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockFunnel extends Block {

    public BlockFunnel() {
        super(Material.GLASS);
        setUnlocalizedName("funnel");
        setRegistryName("funnel");
        setCreativeTab(Anima.animaTab);
    }
}
