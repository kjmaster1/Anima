package com.kjmaster.anima.common.items;

import com.kjmaster.anima.common.init.IAnimaModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GenericAnimaItem extends Item implements IAnimaModel {

    public GenericAnimaItem(String name, CreativeTabs tab, int stackSize) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(tab);
        setMaxStackSize(stackSize);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        if (getRegistryName() != null) { // check not needed, just here to make IDEA shut up.
            ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(),
                    "inventory"));
        }
    }
}
