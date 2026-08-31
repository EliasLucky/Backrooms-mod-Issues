package com.skittle.backrooms.world.dimensions.level2;

import com.skittle.backrooms.api.OriginalContexts;
import com.skittle.backrooms.world.features.BackroomsChunkGenerator;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class Level2ChunkGenerator extends BackroomsChunkGenerator
{
	private final World world;
	
	Level2ChunkGenerator(World world)
	{
		this.world = world;
		addStructure("dark_hallway_a");
		addStructure("dark_hallway_b");
		addStructure("dark_hallway_c");
		addStructure("dark_hallway_d");
		addStructure("dark_hallway_e");
		addStructure("dark_hallway_f");
		addStructure("dark_hallway_g");
		addStructure("dark_hallway_h");
		addStructure("dark_hallway_i");
		addStructure("dark_hallway_j");
		addStructure("dark_hallway_k");
		addStructure("dark_hallway_l");
		addStructure("dark_hallway_m");
		addStructure("dark_hallway_n");
		addStructure("dark_hallway_o");
		addStructure("dark_hallway_p");
		addStructure("dark_hallway_q");
		addStructure("dark_hallway_r");
		addStructure("hallway_a");
		addStructure("hallway_b");
		addStructure("hallway_c");
		addStructure("hallway_d");
		addStructure("hallway_e");
		addStructure("hallway_f");
		addStructure("hallway_g");
		addStructure("hallway_h");
		addStructure("hallway_i");
		addStructure("hallway_j");
		addStructure("hallway_k");
		addStructure("hallway_l");
		addStructure("hallway_m");
		addStructure("hallway_n");
		addStructure("hallway_o");
		addStructure("hallway_p");
		addStructure("hallway_q");
		addStructure("hallway_r");
		
		addStructure("chest_dark_hallway_a");
		addStructure("chest_dark_hallway_c");
		addStructure("chest_dark_hallway_d");
		addStructure("chest_dark_hallway_e");
		addStructure("chest_hallway_a");
		addStructure("chest_hallway_c");
		addStructure("chest_hallway_d");
		addStructure("chest_hallway_e");
		
		addStructure("tolevel1_hallway_g");
		addStructure("tolevel3_dark_hallway_k");
		addStructure("tolevel4_hallway_m");
	}
	
	@Override
	public ResourceLocation getContextItem() {
		return OriginalContexts.LEVEL2_DIMENSION;
	}

	@Override
	public String getStructureLocationForLevel() {
		return "level2/";
	}
	
	@Override
	public World getWorld() {
		return this.world;
	}
	
}
