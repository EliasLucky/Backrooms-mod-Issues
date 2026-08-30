package com.skittle.backrooms.objects.items;

import com.skittle.backrooms.Backrooms;
import com.skittle.backrooms.init.ItemInit;

import net.minecraft.item.ItemRecord;
import net.minecraft.util.SoundEvent;

public class MusicDiscItem extends ItemRecord
{
	public MusicDiscItem(String name, SoundEvent soundIn)
	{
		super(name, soundIn);
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Backrooms.BACKROOMS_ITEMS);
		
		setMaxStackSize(1);
		
		ItemInit.ITEMS.add(this);
	}
}
