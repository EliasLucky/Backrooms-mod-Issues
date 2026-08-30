package com.skittle.backrooms.misc.creativetab;

import com.skittle.backrooms.init.BlockInit;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BkBuildingBlocksTab extends CreativeTabs
{
	public BkBuildingBlocksTab(String label) {
		super(label);
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(Item.getItemFromBlock(BlockInit.CARPET));
	}
}
