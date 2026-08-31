package com.skittle.backrooms.entity.ai.flying;

import net.minecraft.entity.EntityLiving;
import net.minecraft.pathfinding.PathNavigateFlying;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FlyingNavigator extends PathNavigateFlying
{
	public FlyingNavigator(EntityLiving living, World world) {
		super(living, world);
	}

	@Override
	public boolean canEntityStandOnPos(BlockPos pos) {
		return true;
	}
}
