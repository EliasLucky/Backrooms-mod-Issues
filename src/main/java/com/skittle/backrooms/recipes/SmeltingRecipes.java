package com.skittle.backrooms.recipes;

import com.skittle.backrooms.init.ItemInit;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SmeltingRecipes 
{
	public static void init()
	{
		GameRegistry.addSmelting(new ItemStack(ItemInit.RAW_ALMOND_WATER), new ItemStack(ItemInit.ALMOND_WATER), 0.5F);
	}
}
