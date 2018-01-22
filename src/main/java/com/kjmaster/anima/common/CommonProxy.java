package com.kjmaster.anima.common;

import com.kjmaster.anima.Anima;
import com.kjmaster.anima.common.blocks.tile.TileCastingTable;
import com.kjmaster.anima.common.init.ModBlocks;
import com.kjmaster.anima.common.init.ModFluids;
import com.kjmaster.anima.common.init.ModItems;
import com.kjmaster.anima.common.recipe.CastingTableHandler;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.IFluidBlock;
import net.minecraftforge.fluids.capability.TileFluidHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber()
public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {

    }

    public void init(FMLInitializationEvent event) {}

    public void postInit(FMLPostInitializationEvent event) {}

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        ModBlocks.registerBlocks(event);
        registerTileEntities();
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        ModItems.registerItems(event);
        ModBlocks.registerItems(event);
    }

    public static void registerTileEntities() {
        GameRegistry.registerTileEntity(TileCastingTable.class, Anima.MODID + ":tile_casting_table");
    }
}
