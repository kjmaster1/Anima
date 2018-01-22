package com.kjmaster.anima;

import com.kjmaster.anima.common.CommonProxy;
import com.kjmaster.anima.common.init.ModRecipes;
import com.kjmaster.anima.common.recipe.CastingTableHandler;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = Anima.MODID, version = Anima.VERSION, name = Anima.MODNAME)
public class Anima
{
    public static final String MODID = "anima";
    public static final String MODNAME = "Anima";
    public static final String VERSION = "1.0.0";

    public static Item.ToolMaterial soulMaterial = EnumHelper.addToolMaterial("SOUL",2,
            200, 7.0F, 1.0F, 18);

    @SidedProxy(clientSide = "com.kjmaster.anima.client.ClientProxy", serverSide = "com.kjmaster.anima.common.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static Anima instance;

    static {
        FluidRegistry.enableUniversalBucket();
    }

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
        ModRecipes.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
        CastingTableHandler.init();
    }
}