package com.kjmaster.anima.common.recipe;

import net.minecraft.item.ItemStack;

public class CastingTableRecipe {

    public ItemStack input;
    public ItemStack output;

    public int moltenSoulCrystalAmount;
    public int time;

    public CastingTableRecipe(ItemStack input, ItemStack output, int moltenSoulCrystalAmount, int time) {
        this.input = input;
        this.output = output;
        this.moltenSoulCrystalAmount = moltenSoulCrystalAmount;
        this.time = time;
    }
}
