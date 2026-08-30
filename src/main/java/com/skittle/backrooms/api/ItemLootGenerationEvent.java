package com.skittle.backrooms.api;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.eventhandler.Event;

public class ItemLootGenerationEvent extends Event
{
	private TileEntity tileEntity;
	private ResourceLocation resourceLocation;
	
	public ItemLootGenerationEvent(TileEntity target, ResourceLocation context)
	{
		this.tileEntity = target;
		this.resourceLocation = context;
	}
	
	public boolean isCancelable() {
		return true;
	}
	
	public ResourceLocation getContext() {
		return this.resourceLocation;
	}
	
	public TileEntity getTarget() {
		return this.tileEntity;
	}
}
