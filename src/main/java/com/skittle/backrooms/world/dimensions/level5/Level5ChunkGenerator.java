package com.skittle.backrooms.world.dimensions.level5;

import com.skittle.backrooms.world.features.BackroomsChunkGenerator;

import net.minecraft.world.World;

public class Level5ChunkGenerator extends BackroomsChunkGenerator
{
	private final World world;
	
	Level5ChunkGenerator(World world)
	{
		this.world = world;
		//addStructure("type_a_corner_a");
		//addStructure("type_a_corner_b");
		//addStructure("type_a_corner_c");
		//addStructure("type_a_corner_d");
		addStructure("type_a_corridor_a");
		addStructure("type_a_corridor_b");
		addStructure("type_a_intersection_a");
		addStructure("type_a_mainhall_a");
		addStructure("type_a_union_intersection_b");
		addStructure("type_a_union_intersection_c");
		addStructure("type_a_union_intersection_d");
		addStructure("type_a_union_intersection_e");
		//addStructure("type_b_corner_a");
		//addStructure("type_b_corner_b");
		//addStructure("type_b_corner_c");
		//addStructure("type_b_corner_d");
		addStructure("type_b_corridor_a");
		addStructure("type_b_corridor_b");
		addStructure("type_b_intersection_a");
		addStructure("type_b_mainhall_a");
		addStructure("type_b_union_intersection_b");
		addStructure("type_b_union_intersection_c");
		addStructure("type_b_union_intersection_d");
		addStructure("type_b_union_intersection_e");
		//addStructure("type_c_corner_a");
		//addStructure("type_c_corner_b");
		//addStructure("type_c_corner_c");
		//addStructure("type_c_corner_d");
		addStructure("type_c_corridor_a");
		addStructure("type_c_corridor_b");
		addStructure("type_c_intersection_a");
		addStructure("type_c_mainhall_a");
		addStructure("type_c_union_intersection_b");
		addStructure("type_c_union_intersection_c");
		addStructure("type_c_union_intersection_d");
		addStructure("type_c_union_intersection_e");
		addStructure("type_d_mainhall_a");
		
		//addStructure("type_e_corner_a");
		//addStructure("type_e_corner_b");
		//addStructure("type_e_corner_c");
		//addStructure("type_e_corner_d");
		addStructure("type_e_corridor_a");
		addStructure("type_e_corridor_b");
		addStructure("type_e_intersection_a");
		addStructure("type_e_union_intersection_b");
		addStructure("type_e_union_intersection_c");
		addStructure("type_e_union_intersection_d");
		addStructure("type_e_union_intersection_e");
		
		//addStructure("type_f_corner_a");
		//addStructure("type_f_corner_b");
		//addStructure("type_f_corner_c");
		//addStructure("type_f_corner_d");
		addStructure("type_f_corridor_a");
		addStructure("type_f_corridor_b");
		addStructure("type_f_union_intersection_b");
		addStructure("type_f_union_intersection_c");
		addStructure("type_f_union_intersection_d");
		addStructure("type_f_union_intersection_e");
		
		//addStructure("type_g_corner_a");
		//addStructure("type_g_corner_b");
		//addStructure("type_g_corner_c");
		//addStructure("type_g_corner_d");
		addStructure("type_g_corridor_a");
		addStructure("type_g_corridor_b");
		
		addStructure("type_e_intersection_a");
		addStructure("type_e_intersection_a");
		
		
		addStructure("tolevel3_a");
		addStructure("tolevel6_a");
		addStructure("tolevel6_b");
		//addStructure("tolevel3_b");
		//addStructure("tolevel3_c");
		//addStructure("type_a_intersection_a");
	}

	@Override
	public String getStructureLocationForLevel() {
		return "level5/";
	}
	
	@Override
	public World getWorld() {
		return this.world;
	}
	
	@Override
	public boolean ignoreEntities() {
		return false;
	}
}
