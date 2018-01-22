package com.kjmaster.anima.common.init;

import com.kjmaster.anima.common.blocks.*;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

public class ModBlocks {

    public static final ArrayList<ItemBlock> items = new ArrayList<>();
    public static final ArrayList<Block> blocks = new ArrayList<>();

    public static BlockSoulCrystal soulCrystal = new BlockSoulCrystal();
    public static BlockCastingTable castingTable = new BlockCastingTable();
    public static BlockFunnel funnel = new BlockFunnel();
    public static BlockSplitter splitter = new BlockSplitter();
    public static BlockDecanter decanter = new BlockDecanter();
    public static BlockGourd gourd = new BlockGourd();
    public static BlockSpiral spiral = new BlockSpiral();

    public static void registerBlocks(final RegistryEvent.Register<Block> event) {
        blocks.add(soulCrystal);
        blocks.add(castingTable);
        blocks.add(funnel);
        blocks.add(splitter);
        blocks.add(decanter);
        blocks.add(gourd);
        blocks.add(spiral);
        final IForgeRegistry<Block> registry = event.getRegistry();
        for (final Block block : blocks) {
            registry.register(block);
        }
    }

    public static void registerItems(final RegistryEvent.Register<Item> event) {
        items.add(new ItemBlock(castingTable));
        items.add(new ItemBlock(funnel));
        items.add(new ItemBlock(splitter));
        items.add(new ItemBlock(decanter));
        items.add(new ItemBlock(gourd));
        items.add(new ItemBlock(spiral));
        final IForgeRegistry<Item> registry = event.getRegistry();
        for (final ItemBlock item : items) {
            Block block = item.getBlock();
            registry.register(item.setRegistryName(block.getRegistryName()));
        }
    }

    public static void registerModels() {
        for (Block block : blocks) {
            if (block instanceof IAnimaModel) {
                ((IAnimaModel)block).initModel();
            }
        }
    }
}
