package com.skittle.backrooms.entity;

import com.skittle.backrooms.entity.ai.flying.AIWanderAvoidWaterFlying;
import com.skittle.backrooms.entity.ai.flying.EntityFlyHelper;
import com.skittle.backrooms.entity.ai.flying.FlyingNavigator;
import com.skittle.backrooms.utils.interfaces.IFlyingEntity;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Blocks;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class FlyingCreature extends BackroomsCreature implements IFlyingEntity
{
	public FlyingCreature(World worldIn) {
		super(worldIn);
		this.moveHelper = new EntityFlyHelper(this);
	}
	
	@Override
	protected void initEntityAI() {
		super.initEntityAI();
		this.tasks.removeTask(this.wandering);
		this.tasks.addTask(4, this.wandering = new AIWanderAvoidWaterFlying(this, 1.0D, 10));
	}
	
	@Override
	public void onEntityUpdate() {
		super.onEntityUpdate();
		setNoGravity(!this.onGround);
	}
	
	@Override
	public boolean isFlying() {
		return (this.world.getBlockState(getPosition().down()) == Blocks.AIR.getDefaultState());
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getAttributeMap().registerAttribute(SharedMonsterAttributes.FLYING_SPEED);
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.1D);
	}
	
	@Override
	protected PathNavigate createNavigator(World worldIn) {
		FlyingNavigator flyingNavigator = new FlyingNavigator(this, worldIn);
		flyingNavigator.setCanEnterDoors(true);
		flyingNavigator.setCanFloat(true);
		flyingNavigator.setCanOpenDoors(false);
		return flyingNavigator;
	}
	
	@Override
	public void fall(float distance, float damageMultiplier) {}
	
	@Override
	protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos) {}
}
