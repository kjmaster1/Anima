package com.kjmaster.anima.common.events;

import com.kjmaster.anima.common.init.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.EntitySkeletonHorse;
import net.minecraft.entity.passive.EntityZombieHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

@Mod.EventBusSubscriber
public class EntityEvents {

    @SubscribeEvent
    public static void onLivingEntityDeath(LivingDeathEvent event) {
        if (!(event.getEntity() instanceof EntityPlayer
            && !(event.getEntity() instanceof EntityZombie)
            && !(event.getEntity() instanceof EntityZombieVillager)
            && !(event.getEntity() instanceof EntityZombieHorse)
            && !(event.getEntity() instanceof EntityPigZombie)
            && !(event.getEntity() instanceof EntitySkeleton)
            && !(event.getEntity() instanceof EntityWitherSkeleton)
            && !(event.getEntity() instanceof EntitySkeletonHorse))) {
            if (event.getSource().getTrueSource() instanceof EntityPlayer) {
                EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();
                Entity entity = event.getEntity();
                Item itemInHand = player.getHeldItem(EnumHand.MAIN_HAND).getItem();
                if (itemInHand.equals(ModItems.soulBlade)) {
                    Random rand = player.world.rand;
                    if (rand.nextInt(4) != 0) {
                        InventoryHelper.spawnItemStack(player.world, entity.posX, entity.posY, entity.posZ,
                                new ItemStack(ModItems.soulCrystal));
                    }
                }
            }
        }
    }
}
