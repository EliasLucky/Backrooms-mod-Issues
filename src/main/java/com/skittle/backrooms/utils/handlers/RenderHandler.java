package com.skittle.backrooms.utils.handlers;

import com.skittle.backrooms.entity.EntityDeathmoth;
import com.skittle.backrooms.entity.render.RenderDeathmoth;

import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler
{
	public static void registerEntityRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityDeathmoth.class, manager -> new RenderDeathmoth(manager, 0.5F));
	}
}
