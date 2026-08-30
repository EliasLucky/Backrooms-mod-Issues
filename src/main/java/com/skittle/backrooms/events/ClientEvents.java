package com.skittle.backrooms.events;

import com.skittle.backrooms.utils.handlers.BuzzHandler;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class ClientEvents
{
	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		EntityPlayer player = event.player;
		Minecraft mc = Minecraft.getMinecraft();
		
		if (!mc.isGamePaused()) {
			BuzzHandler.buzzCheckingAndRunning(player, player.world, mc);
		}
	}
}
