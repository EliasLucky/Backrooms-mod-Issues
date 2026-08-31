package com.skittle.backrooms.entity.ai.flying;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class EntityFlyHelper extends EntityMoveHelper
{
	public EntityFlyHelper(EntityLiving entitylivingIn) {
		super(entitylivingIn);
	}

	@Override
	public void onUpdateMoveHelper() {
		if (this.action == EntityMoveHelper.Action.MOVE_TO) {
			float movespeed;
			if (this.entity.getAttackTarget() != null) {
				EntityLivingBase target = this.entity.getAttackTarget();
				if (!target.isDead) {
					this.posX = target.posX;
					this.posY = target.posY;
					this.posZ = target.posZ;
				}
			}
			
			double xDistance = this.posX - this.entity.posX;
			double yDistance = this.posY - this.entity.posY;
			double zDistance = this.posZ - this.entity.posZ;
			double d3 = xDistance * xDistance + yDistance * yDistance + zDistance * zDistance;
			if (d3 < 2.5D) {
				this.entity.setMoveVertical(0.0F);
				this.entity.setMoveForward(0.0F);
				return;
			}
			if (this.entity.onGround) {
				movespeed = (float)(this.speed * this.entity.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue());
			}
			else {
				movespeed = (float)(this.speed * this.entity.getEntityAttribute(SharedMonsterAttributes.FLYING_SPEED).getAttributeValue());
			}
			
			float f = (float)(MathHelper.atan2(zDistance, xDistance) * 57.29577951308232D) - 90.0F;
			this.entity.rotationYaw = limitAngle(this.entity.rotationYaw, f, 90.0F);
			double d4 = MathHelper.sqrt(xDistance * xDistance + zDistance * zDistance);
			float f2 = (float)-(MathHelper.atan2(yDistance, d4) * 57.29577951308232D) - 90.0F;
			this.entity.rotationPitch = limitAngle(this.entity.rotationPitch, f2, 90.0F);
			Vec3d direction = (new Vec3d(xDistance, yDistance, zDistance)).normalize().scale(movespeed);
			this.entity.motionX += direction.x;
			this.entity.motionY += direction.y;
			this.entity.motionZ += direction.z;
		}
		else if (this.action == EntityMoveHelper.Action.WAIT) {
			this.entity.setMoveVertical(0.0F);
			this.entity.motionY = 0.0D;
			this.entity.setMoveForward(0.0F);
		}
	}
}
