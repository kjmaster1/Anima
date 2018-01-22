package com.kjmaster.anima.client.events;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class RenderEvents {


    @SubscribeEvent
    public static void beforeRenderEntity(RenderLivingEvent.Pre event) {
        Entity entity = event.getEntity();
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            String s = TextFormatting.getTextWithoutFormattingCodes(player.getName());
            if (s != null && ("kjmaster1".equals(s))) {
                GlStateManager.pushMatrix();
                GlStateManager.rotate(180.0F - entity.rotationYaw, 0.0F, 1.0F, 0.0F);
                GlStateManager.translate(0.0F, entity.height + 0.1F, 0.0F);
                GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
                GlStateManager.translate(-event.getX(), -event.getY(), -event.getZ());
            }
        }
    }

    @SubscribeEvent
    public static void afterRenderEntity(RenderLivingEvent.Post event) {
        Entity entity = event.getEntity();
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            String s = TextFormatting.getTextWithoutFormattingCodes(player.getName());
            if (s != null && ("kjmaster1".equals(s))) {
                GlStateManager.popMatrix();
            }
        }
    }
}
