package com.skittle.backrooms.world.dimensions.level1;

import com.skittle.backrooms.api.OriginalContexts;
import com.skittle.backrooms.world.features.BackroomsChunkGenerator;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class Level1ChunkGenerator extends BackroomsChunkGenerator
{
	private final World world;
	
	Level1ChunkGenerator(World world)
	{
		this.world = world;
		addStructure("type_a_corridor_a");
		addStructure("type_a_corridor_b");
		addStructure("type_a_intersection_a");
		addStructure("type_a_union_intersection_b");
		addStructure("type_a_union_intersection_c");
		addStructure("type_a_union_intersection_d");
		addStructure("type_a_union_intersection_e");
		
		addStructure("type_b_corridor_a");
		addStructure("type_b_corridor_b");
		addStructure("type_b_intersection_a");
		addStructure("type_b_union_intersection_b");
		addStructure("type_b_union_intersection_c");
		addStructure("type_b_union_intersection_d");
		addStructure("type_b_union_intersection_e");
		
		addStructure("type_c_corridor_a");
		addStructure("type_c_corridor_b");
		addStructure("type_c_intersection_a");
		addStructure("type_c_union_intersection_b");
		addStructure("type_c_union_intersection_c");
		addStructure("type_c_union_intersection_d");
		addStructure("type_c_union_intersection_e");
		
		addStructure("type_d_intersection_a");
		addStructure("type_d_intersection_b");
		addStructure("type_d_intersection_c");
		addStructure("type_d_intersection_d");
		addStructure("type_d_intersection_e");
		addStructure("type_d_intersection_f");
		addStructure("type_d_intersection_g");
		addStructure("type_d_intersection_h");
		
		addStructure("type_e_intersection_a");
		addStructure("type_e_intersection_b");
		addStructure("type_e_intersection_c");
		addStructure("type_e_intersection_d");
		addStructure("type_e_intersection_e");
		addStructure("type_e_intersection_f");
		addStructure("type_e_intersection_g");
		addStructure("type_e_intersection_h");
		
		addStructure("type_f_intersection_a");
		addStructure("type_f_intersection_b");
		addStructure("type_f_intersection_c");
		addStructure("type_f_intersection_d");
		addStructure("type_f_intersection_e");
		addStructure("type_f_intersection_f");
		addStructure("type_f_intersection_g");
		addStructure("type_f_intersection_h");
		
		addStructure("tolevel2_a");
	}
	
	@Override
	public ResourceLocation getContextItem() {
		return OriginalContexts.LEVEL1_DIMENSION;
	}

	@Override
	public String getStructureLocationForLevel() {
		return "level1/";
	}
	
	@Override
	public World getWorld() {
		return this.world;
	}
}
