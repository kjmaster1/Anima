package com.kjmaster.anima.common.init;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class ModRecipes {

    public static void init() {
        GameRegistry.addSmelting(Blocks.SOUL_SAND, new ItemStack(ModItems.soulDust), 0.5F);
        OreDictionary.registerOre("soulsand", Blocks.SOUL_SAND);
        OreDictionary.registerOre("dustSoul", ModItems.soulDust);
        OreDictionary.registerOre("crystalSoul", ModItems.soulCrystal);
        OreDictionary.registerOre("ingotSoul", ModItems.soulMetal);
    }
}
