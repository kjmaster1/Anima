package com.kjmaster.anima.common.blocks;

import com.kjmaster.anima.Anima;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockDecanter extends Block {

    public BlockDecanter() {
        super(Material.GLASS);
        setUnlocalizedName("decanter");
        setRegistryName("decanter");
        setCreativeTab(Anima.animaTab);
    }
}
