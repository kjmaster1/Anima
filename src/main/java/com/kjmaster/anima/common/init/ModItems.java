package com.kjmaster.anima.common.init;

import com.kjmaster.anima.Anima;
import com.kjmaster.anima.common.items.GenericAnimaItem;
import com.kjmaster.anima.common.items.ItemMold;
import com.kjmaster.anima.common.items.ItemSoulBlade;
import com.kjmaster.anima.common.items.ItemSoulCrystal;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {

    public static ItemSoulBlade soulBlade = new ItemSoulBlade();
    public static ItemSoulCrystal soulCrystal = new ItemSoulCrystal();
    public static GenericAnimaItem soulDust = new GenericAnimaItem("soul_dust", CreativeTabs.MISC,64);
    public static GenericAnimaItem soulMetal = new GenericAnimaItem("soul_metal", CreativeTabs.MISC,64);
    public static ItemMold mold = new ItemMold();

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        final Item[] items = {
                soulBlade,
                soulCrystal,
                soulDust,
                soulMetal,
                mold,
        };
        for (Item item : items) {
            if (item instanceof IAnimaModel) {
                ((IAnimaModel)item).initModel();
            }
        }
    }

    public static void registerItems(final RegistryEvent.Register<Item> event) {
        final Item[] items = {
                soulBlade,
                soulCrystal,
                soulDust,
                soulMetal,
                mold,
        };
        final IForgeRegistry<Item> registry = event.getRegistry();
        for (final Item item : items) {
            registry.register(item);
        }
    }

    @SideOnly(Side.CLIENT)
    public static void registerMetaRender(Item item, int meta, String fileName) {
        ModelLoader.setCustomModelResourceLocation(item, meta,
                new ModelResourceLocation(
                        new ResourceLocation(Anima.MODID, fileName), "inventory"
                ));
    }
}
