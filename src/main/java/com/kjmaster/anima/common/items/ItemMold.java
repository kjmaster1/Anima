package com.kjmaster.anima.common.items;

import com.kjmaster.anima.common.init.IAnimaModel;
import com.kjmaster.anima.common.init.ModItems;
import com.kjmaster.anima.utils.EnumHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ItemMold extends Item implements IAnimaModel {

    public ItemMold() {
        setUnlocalizedName("mold");
        setRegistryName("mold");
        setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        for (int i = 0; i < EnumHandler.MoldTypes.values().length; i++) {
            if (stack.getItemDamage() == i) {
                return super.getUnlocalizedName() + "_" +
                        EnumHandler.MoldTypes.values()[i].getName();
            }
        }
        return super.getUnlocalizedName();
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        for (int i = 0; i < EnumHandler.MoldTypes.values().length; i++) {
            items.add(new ItemStack(this, 1, i));
        }
    }

    @Override
    public void initModel() {
        for (int i = 0; i < EnumHandler.MoldTypes.values().length; i++) {
            ModItems.registerMetaRender(this, i,
                    "mold_" + EnumHandler.MoldTypes.values()[i].getName());
        }
    }
}
