package com.skittle.backrooms.entity.ai.flying;

import javax.annotation.Nullable;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class AIWanderAvoidWaterFlying extends EntityAIWanderAvoidWater
{
	protected Vec3d moveto;

	public AIWanderAvoidWaterFlying(EntityCreature creature, double speedMultiplayer, int weight) {
		super(creature, speedMultiplayer, 0.0F);
		setExecutionChance(weight);
	}
	
	@Override
	public boolean shouldExecute() {
		if (this.entity.getRNG().nextInt(this.executionChance) != 0) {
			return false;
		}
		this.moveto = getPosition();
		return (this.moveto != null);
	}
	
	@Nullable
	@Override
	protected Vec3d getPosition() {
		double range = this.entity.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).getAttributeValue();
		Vec3d vec3d = RandomPositionGenerator.findRandomTarget(this.entity, (int)range, (int)range / 2);
		if (vec3d != null) {
			BlockPos target = new BlockPos(vec3d.x, vec3d.y, vec3d.z);
			BlockPos current = this.entity.getPosition();
			BlockPos ground = this.entity.world.getTopSolidOrLiquidBlock(current);
			BlockPos diff = target.subtract(ground);
			if (diff.getY() > 16) {
				return new Vec3d(current.getX(), (ground.getY() + this.entity.world.rand.nextInt(8) + 8), current.getZ());
			}
		}
		return vec3d;
	}
	
	@Override
	public void updateTask() {
		if (this.moveto != null) {
			double distance = this.entity.getDistance(this.moveto.x, this.moveto.y, this.moveto.z);
			if (distance > 3.0D) {
				this.entity.getMoveHelper().setMoveTo(this.moveto.x, this.moveto.y, this.moveto.z, this.speed);
				if (this.entity.onGround) {
					this.entity.getJumpHelper().setJumping();
				}
			}
			else {
				this.moveto = null;
				(this.entity.getMoveHelper()).action = EntityMoveHelper.Action.WAIT;
			}
		}
	}
}
