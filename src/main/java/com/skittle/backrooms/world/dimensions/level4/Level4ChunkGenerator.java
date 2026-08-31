package com.skittle.backrooms.world.dimensions.level4;

import com.skittle.backrooms.world.features.BackroomsChunkGenerator;

import net.minecraft.world.World;

public class Level4ChunkGenerator extends BackroomsChunkGenerator
{
	private final World world;
	
	Level4ChunkGenerator(World world)
	{
		this.world = world;
		addStructure("type_a_corridor_a");
		addStructure("type_a_corridor_b");
		addStructure("type_a_corridor_c");
		addStructure("type_a_corridor_d");
		addStructure("type_a_intersection_a");
		addStructure("type_a_union_intersection_b");
		addStructure("type_a_union_intersection_c");
		addStructure("type_a_union_intersection_d");
		addStructure("type_a_union_intersection_e");
		
		addStructure("type_b_corridor_a");
		addStructure("type_b_corridor_b");
		addStructure("type_b_corridor_c");
		addStructure("type_b_corridor_d");
		addStructure("type_b_intersection_a");
		addStructure("type_b_union_intersection_b");
		addStructure("type_b_union_intersection_c");
		addStructure("type_b_union_intersection_d");
		addStructure("type_b_union_intersection_e");
		
		addStructure("type_c_corridor_a");
		addStructure("type_c_corridor_b");
		addStructure("type_c_corridor_c");
		addStructure("type_c_corridor_d");
		addStructure("type_c_intersection_a");
		addStructure("type_c_union_intersection_b");
		addStructure("type_c_union_intersection_c");
		addStructure("type_c_union_intersection_d");
		addStructure("type_c_union_intersection_e");
		
		addStructure("type_d_corridor_a");
		addStructure("type_d_corridor_b");
		addStructure("type_d_corridor_c");
		addStructure("type_d_corridor_d");
		addStructure("type_d_intersection_a");
		addStructure("type_d_union_intersection_b");
		addStructure("type_d_union_intersection_c");
		addStructure("type_d_union_intersection_d");
		addStructure("type_d_union_intersection_e");
		
		addStructure("type_e_corridor_a");
		addStructure("type_e_corridor_b");
		addStructure("type_e_corridor_c");
		addStructure("type_e_corridor_d");
		addStructure("type_e_intersection_a");
		addStructure("type_e_union_intersection_b");
		addStructure("type_e_union_intersection_c");
		addStructure("type_e_union_intersection_d");
		addStructure("type_e_union_intersection_e");
		
		addStructure("type_f_intersection_a");
		
		addStructure("tolevel3_a");
		addStructure("tolevel5_a");
	}

	@Override
	public String getStructureLocationForLevel() {
		return "level4/";
	}
	
	@Override
	public World getWorld() {
		return this.world;
	}
	
}
