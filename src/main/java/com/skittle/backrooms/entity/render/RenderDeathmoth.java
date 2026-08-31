package com.skittle.backrooms.entity.render;

import com.skittle.backrooms.entity.EntityDeathmoth;
import com.skittle.backrooms.entity.model.ModelDeathmoth;
import com.skittle.backrooms.reference.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderDeathmoth extends RenderLiving<EntityDeathmoth>
{
	public static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID, "textures/entity/deathmoth.png");
	
	public RenderDeathmoth(RenderManager manager, float shadowSize) {
		super(manager, new ModelDeathmoth(), shadowSize);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityDeathmoth entity) {
		return TEXTURE;
	}
}
