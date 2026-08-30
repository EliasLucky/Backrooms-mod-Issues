package com.skittle.backrooms.world.dimensions.level3;

import com.skittle.backrooms.world.dimensions.BackroomsChunkGenerator;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class Level3ChunkGenerator extends BackroomsChunkGenerator
{
	public Level3ChunkGenerator(World world, String structureLocation, ResourceLocation contextItem, boolean ignoreEntities)
	{
		super(world, structureLocation, contextItem, ignoreEntities, 67);
		
		initializeStructures();
	}

	private void initializeStructures()
	{
		addStructure("dark_type_a_corridor_a");
		addStructure("dark_type_a_corridor_b");
		addStructure("dark_type_a_intersection_a");
		addStructure("dark_type_a_union_intersection_b");
		addStructure("dark_type_a_union_intersection_c");
		addStructure("dark_type_a_union_intersection_d");
		addStructure("dark_type_a_union_intersection_e");
		
		addStructure("dark_type_b_corridor_a");
		addStructure("dark_type_b_corridor_b");
		addStructure("dark_type_b_union_intersection_b");
		addStructure("dark_type_b_union_intersection_c");
		addStructure("dark_type_b_union_intersection_d");
		addStructure("dark_type_b_union_intersection_e");
		
		addStructure("dark_type_c_corridor_a");
		addStructure("dark_type_c_corridor_b");
		addStructure("dark_type_c_intersection_a");
		addStructure("dark_type_c_union_intersection_b");
		addStructure("dark_type_c_union_intersection_c");
		
		addStructure("dark_type_d_corridor_a");
		addStructure("dark_type_d_corridor_b");
		addStructure("dark_type_d_union_intersection_b");
		addStructure("dark_type_d_union_intersection_c");
		addStructure("dark_type_d_union_intersection_d");
		addStructure("dark_type_d_union_intersection_e");
		
		addStructure("dark_type_e_corridor_a");
		addStructure("dark_type_e_corridor_b");
		addStructure("dark_type_e_intersection_a");
		addStructure("dark_type_e_union_intersection_b");
		addStructure("dark_type_e_union_intersection_c");
		addStructure("dark_type_e_union_intersection_d");
		addStructure("dark_type_e_union_intersection_e");
		
		addStructure("dark_type_f_corridor_a");
		addStructure("dark_type_f_corridor_b");
		addStructure("dark_type_f_union_intersection_b");
		addStructure("dark_type_f_union_intersection_c");
		addStructure("dark_type_f_union_intersection_d");
		addStructure("dark_type_f_union_intersection_e");
		addStructure("dark_type_f_union_intersection_d");
		addStructure("dark_type_f_union_intersection_e");
		
		addStructure("type_a_corridor_a");
		addStructure("type_a_corridor_b");
		addStructure("type_a_intersection_a");
		addStructure("type_a_union_intersection_b");
		addStructure("type_a_union_intersection_c");
		addStructure("type_a_union_intersection_d");
		addStructure("type_a_union_intersection_e");
		
		addStructure("type_b_corridor_a");
		addStructure("type_b_corridor_b");
		addStructure("type_b_union_intersection_b");
		addStructure("type_b_union_intersection_c");
		addStructure("type_b_union_intersection_d");
		addStructure("type_b_union_intersection_e");
		
		addStructure("type_c_corridor_a");
		addStructure("type_c_corridor_b");
		addStructure("type_c_intersection_a");
		addStructure("type_c_union_intersection_b");
		addStructure("type_c_union_intersection_c");
		
		addStructure("type_d_corridor_a");
		addStructure("type_d_corridor_b");
		addStructure("type_d_union_intersection_b");
		addStructure("type_d_union_intersection_c");
		addStructure("type_d_union_intersection_d");
		addStructure("type_d_union_intersection_e");
		
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
		addStructure("type_f_union_intersection_d");
		addStructure("type_f_union_intersection_e");
		
		addStructure("tolevel4_a");
		addStructure("tolevel4_b");
		addStructure("tolevel5_a");
		addStructure("tolevel5_b");
	}
}
