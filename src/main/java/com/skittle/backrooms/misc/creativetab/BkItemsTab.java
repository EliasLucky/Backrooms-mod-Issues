package com.skittle.backrooms.misc.creativetab;

import com.skittle.backrooms.init.ItemInit;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class BkItemsTab extends CreativeTabs
{
	public BkItemsTab(String label) {
		super(label);
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ItemInit.YELLOW_WALLPAPER_PATTERN);
	}
}
