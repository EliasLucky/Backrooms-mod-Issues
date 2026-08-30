package com.skittle.backrooms.events;

import com.skittle.backrooms.commands.utils.Teleport;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class CommonEvents
{
	@SubscribeEvent
	public static void onPlayerDamages(LivingHurtEvent event)
	{
		if (event.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)event.getEntity();
			double teleportChance = 0.01D; //Made config later.
			
			if (event.getSource() == DamageSource.IN_WALL) {
				if (player.dimension == 0 &&!player.world.isRemote) {
					if (player.world.rand.nextDouble() < teleportChance) {
						Teleport.teleportToDimension((EntityPlayer)player, 1000, 5, 62, 5);
					}
				}
			}
		}
	}
}
