package com.kjmaster.anima.common.blocks;

import com.kjmaster.anima.Anima;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockSplitter extends Block {

    public BlockSplitter() {
        super(Material.GLASS);
        setUnlocalizedName("splitter");
        setRegistryName("splitter");
        setCreativeTab(Anima.animaTab);
    }
}
