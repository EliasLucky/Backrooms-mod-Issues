package com.skittle.backrooms.proxy;

import com.skittle.backrooms.events.ClientEvents;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy
{
	public void registerItemRenderer(Item item, int meta, String id) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}
	
	@Override
	public void preLoad() {
		super.preLoad();
		MinecraftForge.EVENT_BUS.register(new ClientEvents());
	}
}
