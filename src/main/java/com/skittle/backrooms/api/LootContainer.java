package com.skittle.backrooms.api;

import java.util.Collections;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemHandlerHelper;

public interface LootContainer
{
	default boolean canGenerate(ResourceLocation context) {
		return true;
	}
	
	static <LC extends Class<? extends LootContainer>> void registerLoot(LC lootContainer, Loot lootPool) {
		InternalAPI.lootPools.put(lootContainer, lootPool);
	}
	
	static <LC extends Class<? extends LootContainer>> void registerLoot(LC lootContainer, Loot... lootPools) {
		for (Loot lootPool : lootPools) {
			registerLoot(lootContainer, lootPool);
		}
	}
	
	static <IHT extends Class<? extends TileEntity>> void registerLoot2(IHT itemHandlerTile, Loot... lootPools) {
		for (Loot lootPool : lootPools) {
			InternalAPI.otherPools.put(itemHandlerTile, lootPool);
		}
	}
	
	static int generateRandomItems(TileEntity tileEntity, ResourceLocation context)
	{
		int itemGenerated = 0;
		if (tileEntity instanceof LootContainer)
		{
			LootContainer lootContainer = (LootContainer)tileEntity;
			if (lootContainer.canGenerate(context))
			{
				List<Loot> lootPoolSet = InternalAPI.lootPools.get(lootContainer.getClass());
				if (lootPoolSet != null)
				{
					Collections.shuffle(lootPoolSet);
					for (Loot lootPool : lootPoolSet)
					{
						ItemStack result = lootPool.roll(context, tileEntity);
						if (result != null)
						{
							if (tileEntity.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null))
							{
								IItemHandler itemHandler = (IItemHandler)tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
								if (ItemHandlerHelper.insertItem(itemHandler, result, false).getCount() < result.getCount())
								{
									itemGenerated++;
								}
							}
						}
					}
				}
			}
		}
		else if (tileEntity != null && tileEntity.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null))
		{
			if (!MinecraftForge.EVENT_BUS.post(new ItemLootGenerationEvent(tileEntity, context)))
			{
				List<Loot> poolList = InternalAPI.otherPools.get(tileEntity.getClass());
				if (poolList != null)
				{
					Collections.shuffle(poolList);
					IItemHandler itemHandler = (IItemHandler)tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
					for (Loot lootPool : poolList)
					{
						ItemStack res = lootPool.roll(context, tileEntity);
						if (res != null) {
							if (ItemHandlerHelper.insertItem(itemHandler, res, false).getCount() < res.getCount())
							{
								itemGenerated++;
							}
						}
					}
				}
			}
		}
		return itemGenerated;
	}
}
