package com.kjmaster.anima.common.blocks;

import com.kjmaster.anima.Anima;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockGourd extends Block {

    public BlockGourd() {
        super(Material.GLASS);
        setUnlocalizedName("gourd");
        setRegistryName("gourd");
        setCreativeTab(Anima.animaTab);
    }
}
