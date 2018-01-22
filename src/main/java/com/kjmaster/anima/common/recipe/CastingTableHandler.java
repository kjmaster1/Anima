package com.kjmaster.anima.common.recipe;

import com.kjmaster.anima.common.init.ModBlocks;
import com.kjmaster.anima.common.init.ModItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;

public class CastingTableHandler {

    public static ArrayList<CastingTableRecipe> MAIN_RECIPES = new ArrayList<>();
    public static ArrayList<CastingTableRecipe> ALL_RECIPES = new ArrayList<>();

    public static void init() {

        CastingTableRecipe soulMetalRecipe = new CastingTableRecipe(
                new ItemStack(Items.IRON_INGOT, 1, 0),
                new ItemStack(ModItems.soulMetal, 1, 0),
                1000, 50
        );
        MAIN_RECIPES.add(soulMetalRecipe);
        ALL_RECIPES.add(soulMetalRecipe);

        CastingTableRecipe funnelRecipe = new CastingTableRecipe(
                new ItemStack(ModItems.mold, 1, 0),
                new ItemStack(ModBlocks.funnel, 1, 0),
                200, 40
        );
        MAIN_RECIPES.add(funnelRecipe);
        ALL_RECIPES.add(funnelRecipe);

        CastingTableRecipe splitterRecipe = new CastingTableRecipe(
                new ItemStack(ModItems.mold, 1, 1),
                new ItemStack(ModBlocks.splitter, 1, 0),
                200, 40
        );
        MAIN_RECIPES.add(splitterRecipe);
        ALL_RECIPES.add(splitterRecipe);

        CastingTableRecipe decanterRecipe = new CastingTableRecipe(
                new ItemStack(ModItems.mold, 1, 2),
                new ItemStack(ModBlocks.decanter, 1, 0),
                200, 40
        );
        MAIN_RECIPES.add(decanterRecipe);
        ALL_RECIPES.add(decanterRecipe);

        CastingTableRecipe gourdRecipe = new CastingTableRecipe(
                new ItemStack(ModItems.mold, 1, 3),
                new ItemStack(ModBlocks.gourd, 1, 0),
                200, 40
        );
        MAIN_RECIPES.add(gourdRecipe);
        ALL_RECIPES.add(gourdRecipe);

        CastingTableRecipe spiralRecipe = new CastingTableRecipe(
                new ItemStack(ModItems.mold, 1, 4),
                new ItemStack(ModBlocks.spiral, 1, 0),
                200, 40
        );
        MAIN_RECIPES.add(spiralRecipe);
        ALL_RECIPES.add(spiralRecipe);

    }
}
