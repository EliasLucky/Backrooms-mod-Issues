package com.skittle.backrooms.api;

import com.google.common.collect.ArrayListMultimap;

import net.minecraft.tileentity.TileEntity;

public final class InternalAPI
{
	public static final ArrayListMultimap<Class<? extends LootContainer>, Loot> lootPools = ArrayListMultimap.create(5, 10);
	public static final ArrayListMultimap<Class<? extends TileEntity>, Loot> otherPools = ArrayListMultimap.create();
	
}
