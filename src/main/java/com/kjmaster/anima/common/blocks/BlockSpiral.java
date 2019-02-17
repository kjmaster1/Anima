package com.kjmaster.anima.common.blocks;

import com.kjmaster.anima.Anima;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockSpiral extends Block {

    public BlockSpiral() {
        super(Material.GLASS);
        setUnlocalizedName("spiral");
        setRegistryName("spiral");
        setCreativeTab(Anima.animaTab);
    }
}
