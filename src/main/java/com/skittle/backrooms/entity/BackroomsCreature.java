package com.skittle.backrooms.entity;

import javax.annotation.Nullable;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;

public abstract class BackroomsCreature extends EntityCreature
{
	static final DataParameter<Boolean> HAS_TARGET = EntityDataManager.createKey(BackroomsCreature.class, DataSerializers.BOOLEAN);
	
	protected EntityAIWander wandering;
	protected EntityAIHurtByTarget defense;
	protected EntityAISwimming swimming;
	
	public BackroomsCreature(World worldIn) {
		super(worldIn);
	}
	
	@Override
	protected void initEntityAI() {
		this.tasks.addTask(0, this.swimming = new EntityAISwimming(this));
		this.tasks.addTask(4, this.wandering = new EntityAIWanderAvoidWater(this, 1.0D, 4.0F));
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23D);
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
	}
	
	@Override
	public boolean getCanSpawnHere() {
		//return this.world.getDifficulty() != EnumDifficulty.PEACEFUL && this.isValidLightLevel() && super.getCanSpawnHere();
		return (this.rand.nextInt(100) < getSpawnProbability() && super.getCanSpawnHere());
	}

	protected int getSpawnProbability() {
		return 50;
	}
	
	@Override
	protected boolean canDespawn() {
		return false;
	}
	
	@Override
	protected int getExperiencePoints(EntityPlayer player) {
		return (int)(getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue() + getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).getAttributeValue());
	}
	
	@Override
	public boolean canBeLeashedTo(EntityPlayer player) {
		return (player.isCreative() || (super.canBeLeashedTo(player) && getAttackTarget() == null && getRevengeTarget() == null));
	}
	
	@Override
	protected void handleJumpWater() {
		this.motionY += 0.04D;
	}
	
	@Override
	protected void entityInit() {
		super.entityInit();
		if (registerTargetPresence()) {
			this.dataManager.register(HAS_TARGET, Boolean.valueOf(false));
		}
	}
	
	public boolean hasTarget() {
		return (registerTargetPresence() && (this.dataManager.get(HAS_TARGET)).booleanValue());
	}
	
	@Override
	public void setAttackTarget(@Nullable EntityLivingBase entitylivingbaseIn) {
		super.setAttackTarget(entitylivingbaseIn);
		if (registerTargetPresence()) {
			this.dataManager.set(HAS_TARGET, Boolean.valueOf((entitylivingbaseIn != null)));
		}
	}
	
	protected boolean registerTargetPresence() {
		return true;
	}
}
