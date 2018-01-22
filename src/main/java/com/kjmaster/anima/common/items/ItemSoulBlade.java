package com.kjmaster.anima.common.items;

import com.kjmaster.anima.Anima;
import com.kjmaster.anima.common.init.IAnimaModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemSoulBlade extends ItemSword implements IAnimaModel {

    public ItemSoulBlade() {
        super(Anima.soulMaterial);
        setUnlocalizedName("soul_blade");
        setRegistryName("soul_blade");
        setCreativeTab(CreativeTabs.COMBAT);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void initModel() {
        if (getRegistryName() != null) {
            ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(),
                    "inventory"));
        }
    }
}
