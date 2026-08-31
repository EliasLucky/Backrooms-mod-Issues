package com.skittle.backrooms.entity.ai;

import javax.annotation.Nonnull;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.MathHelper;

public class AIMeleeAttack extends EntityAIAttackMelee
{
	protected DamageSource damageSource;
	protected float damage;
	protected boolean canDamageThroughBlocks;

	public AIMeleeAttack(EntityCreature creature, double speedIn, boolean useLongMemory, float fallback_damage_) {
		super(creature, speedIn, useLongMemory);
		this.damage = fallback_damage_;
		this.damageSource = DamageSource.causeMobDamage(this.attacker);
	}

	public AIMeleeAttack(EntityCreature creature, double speedFactor, boolean longMemory) {
		this(creature, speedFactor, longMemory, false);
	}
	
	public AIMeleeAttack(EntityCreature creature, double speedFactor, boolean longMemory, boolean canDamageThroughBlocks) {
		this(creature, speedFactor, longMemory, 1.0F);
		this.canDamageThroughBlocks = canDamageThroughBlocks;
	}
	
	@Override
	public void updateTask() {
		if (this.attacker.getAttackTarget() != null) {
			if (this.canDamageThroughBlocks || this.attacker.canEntityBeSeen(this.attacker.getAttackTarget())) {
				super.updateTask();
			}
		}
		this.attackTick = Math.max(this.attackTick - 1, 0);
	}
	
	@Override
	protected double getAttackReachSqr(EntityLivingBase attackTarget) {
		return super.getAttackReachSqr(attackTarget);
	}
	
	@Override
	protected void checkAndPerformAttack(@Nonnull EntityLivingBase target, double distance) {
		double d0 = getAttackReachSqr(target);
		d0 = MathHelper.clamp(d0, 3.0D, 16.0D);
		if (distance <= d0 && this.attackTick <= 0) {
			float f;
			this.attackTick = 20;
			this.attacker.swingArm(EnumHand.MAIN_HAND);
			if (this.attacker.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null) {
				float attack = (float)this.attacker.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue();
				if (attack > 0.0F) {
					f = attack;
				}
				else {
					f = this.damage;
				}
			}
			else {
				f = this.damage;
			}
			boolean flag = target.attackEntityFrom(this.damageSource, f);
			this.attacker.attackEntityAsMob(target);
			if (flag) {
				target.knockBack(this.attacker, 0.5F, MathHelper.sin(this.attacker.rotationYaw * 0.017453292F), -MathHelper.cos(this.attacker.rotationYaw * 0.017453292F));
				this.attacker.motionX *= 0.06D;
				this.attacker.motionZ *= 0.06D;
			}
		}
	}
	
	public AIMeleeAttack setDamageSource(EntityDamageSource damageSource) {
		this.damageSource = (DamageSource)damageSource;
		return this;
	}
}
