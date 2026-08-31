package com.skittle.backrooms.entity;

import com.google.common.base.Predicate;
import com.skittle.backrooms.entity.ai.AIMeleeAttack;
import com.skittle.backrooms.entity.ai.AINearestTarget;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.world.World;

public class EntityDeathmoth extends FlyingCreature
{
	public EntityDeathmoth(World worldIn) {
		super(worldIn);
	}
	
	@Override
	protected void entityInit() {
		super.entityInit();
	}
	
	@Override
	protected void initEntityAI() {
		super.initEntityAI();
		this.tasks.addTask(1, new AIMeleeAttack(this, 2.0D, true));
		Predicate<EntityLivingBase> targets = input -> (input instanceof net.minecraft.entity.player.EntityPlayer);
		this.targetTasks.addTask(5, new AINearestTarget<>(this, EntityLivingBase.class, true, false, targets));
		this.targetTasks.addTask(6, new EntityAIHurtByTarget(this, false, new Class[0]));
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(0.02D);
		getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
	}
}
