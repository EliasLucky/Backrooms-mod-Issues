package com.skittle.backrooms.world.dimensions.level5;

import com.skittle.backrooms.world.dimensions.BackroomsChunkGenerator;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class Level5ChunkGenerator extends BackroomsChunkGenerator
{
	public Level5ChunkGenerator(World world, String structureLocation, ResourceLocation contextItem, boolean ignoreEntities)
	{
		super(world, structureLocation, contextItem, ignoreEntities, 67);
		
		initializeStructures();
	}
	
	private void initializeStructures()
	{
		//DEV NOTE: Some corners was removed
		
		addStructure("type_a_corridor_a");
		addStructure("type_a_corridor_b");
		addStructure("type_a_intersection_a");
		addStructure("type_a_mainhall_a");
		addStructure("type_a_union_intersection_b");
		addStructure("type_a_union_intersection_c");
		addStructure("type_a_union_intersection_d");
		addStructure("type_a_union_intersection_e");
		
		addStructure("type_b_corridor_a");
		addStructure("type_b_corridor_b");
		addStructure("type_b_intersection_a");
		addStructure("type_b_mainhall_a");
		addStructure("type_b_union_intersection_b");
		addStructure("type_b_union_intersection_c");
		addStructure("type_b_union_intersection_d");
		addStructure("type_b_union_intersection_e");
		
		addStructure("type_c_corridor_a");
		addStructure("type_c_corridor_b");
		addStructure("type_c_intersection_a");
		addStructure("type_c_mainhall_a");
		addStructure("type_c_union_intersection_b");
		addStructure("type_c_union_intersection_c");
		addStructure("type_c_union_intersection_d");
		addStructure("type_c_union_intersection_e");
		addStructure("type_d_mainhall_a");
		
		addStructure("type_e_corridor_a");
		addStructure("type_e_corridor_b");
		addStructure("type_e_intersection_a");
		addStructure("type_e_union_intersection_b");
		addStructure("type_e_union_intersection_c");
		addStructure("type_e_union_intersection_d");
		addStructure("type_e_union_intersection_e");
		
		addStructure("type_f_corridor_a");
		addStructure("type_f_corridor_b");
		addStructure("type_f_union_intersection_b");
		addStructure("type_f_union_intersection_c");
		addStructure("type_f_union_intersection_d");
		addStructure("type_f_union_intersection_e");
		
		addStructure("type_g_corridor_a");
		addStructure("type_g_corridor_b");
		
		addStructure("type_e_intersection_a");
		addStructure("type_e_intersection_a");
		
		addStructure("tolevel3_a");
		addStructure("tolevel6_a");
		addStructure("tolevel6_b");
	}
}
