package com.skittle.backrooms.entity.ai;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;

public class AINearestTarget<T extends EntityLivingBase> extends EntityAINearestAttackableTarget<T>
{
	public AINearestTarget(EntityCreature creature, Class<T> classTarget, boolean checkSight, boolean onlyNearby, @Nullable Predicate<T> targetSelector) {
		super(creature, classTarget, 0, checkSight, onlyNearby, input -> (input.attackable() && targetSelector.test(input)));
	}
}
