package com.skittle.backrooms.init;

import javax.annotation.Nullable;

import com.skittle.backrooms.Backrooms;
import com.skittle.backrooms.entity.EntityDeathmoth;
import com.skittle.backrooms.reference.Reference;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit 
{
	public static void registerEntities()
	{
		int entityindex = 0;
		registerEntity("deathmoth", EntityDeathmoth.class, entityindex++, EntityLiving.SpawnPlacementType.IN_AIR, Reference.BROWN, Reference.BLACK);
	}
	
	private static void registerEntity(String name, Class<? extends Entity> entity, int index, @Nullable EntityLiving.SpawnPlacementType placementType, int shellColor, int spotColor) {
		ResourceLocation resourceLocation = new ResourceLocation(Reference.MODID, name);
		
		EntityRegistry.registerModEntity(resourceLocation, entity, name, index, Backrooms.instance, 50, 1, true);
		EntityRegistry.registerEgg(resourceLocation, shellColor, spotColor);
		if (placementType != null) {
			EntitySpawnPlacementRegistry.setPlacementType(entity, placementType);
		}
	}
}
