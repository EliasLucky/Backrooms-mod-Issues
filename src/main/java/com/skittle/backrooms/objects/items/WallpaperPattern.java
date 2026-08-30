package com.skittle.backrooms.objects.items;

import com.skittle.backrooms.Backrooms;
import com.skittle.backrooms.init.ItemInit;

import net.minecraft.item.Item;

public class WallpaperPattern extends Item
{
	public WallpaperPattern(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Backrooms.BACKROOMS_ITEMS);
		
		setMaxStackSize(16);
		
		ItemInit.ITEMS.add(this);
	}
}
