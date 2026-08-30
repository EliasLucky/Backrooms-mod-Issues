package com.skittle.backrooms.utils.handlers;

import com.skittle.backrooms.init.BlockInit;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BuzzHandler
{
	public static void buzzCheckingAndRunning(EntityPlayer player, World world, Minecraft mc)
	{
		BlockPos playerPos = player.getPosition();
		BlockPos posOfLight = null;
		
		int numOfLight = 0;
		int radius = 5;
		
		double x;
		for (x = (playerPos.getX() - radius); x <= (playerPos.getX() + radius); x++) {
			double y;
			for (y = (playerPos.getY() - radius); y <= (playerPos.getY() + radius); y++) {
				double z;
				for (z = (playerPos.getZ() - radius); z <= (playerPos.getZ() + radius); z++) {
					BlockPos pos = new BlockPos(x, y, z);
					if (world.getBlockState(pos) == BlockInit.LIGHT_ON.getDefaultState()) {
						numOfLight++;
						if (numOfLight == 1) {
							posOfLight = pos;
						}
					}
				}
			}
		}
		
		if (player.dimension == 1000) {
			SoundEvent buzz = SoundsHandler.HUMM_BUZZ;
			
			if (numOfLight > 1) {
				world.playSound(player, posOfLight, buzz, SoundCategory.BLOCKS, 0.1F, 1.0F);
			}
			else if (numOfLight == 1 && posOfLight != null) {
				world.playSound(player, posOfLight, buzz, SoundCategory.BLOCKS, 0.1F, 1.0F);
			}
		}
	}
}
