package com.skittle.backrooms.world.dimensions.level3;

import com.skittle.backrooms.api.OriginalContexts;
import com.skittle.backrooms.world.features.BackroomsChunkGenerator;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class Level3ChunkGenerator extends BackroomsChunkGenerator
{
	private final World world;
	
	Level3ChunkGenerator(World world)
	{
		this.world = world;
		//addStructure("dark_type_a_corner_a");
		//addStructure("dark_type_a_corner_b");
		//addStructure("dark_type_a_corner_c");
		//addStructure("dark_type_a_corner_d");
		addStructure("dark_type_a_corridor_a");
		addStructure("dark_type_a_corridor_b");
		addStructure("dark_type_a_intersection_a");
		addStructure("dark_type_a_union_intersection_b");
		addStructure("dark_type_a_union_intersection_c");
		addStructure("dark_type_a_union_intersection_d");
		addStructure("dark_type_a_union_intersection_e");
		//addStructure("dark_type_b_corner_a");
		//addStructure("dark_type_b_corner_b");
		//addStructure("dark_type_b_corner_c");
		//addStructure("dark_type_b_corner_d");
		addStructure("dark_type_b_corridor_a");
		addStructure("dark_type_b_corridor_b");
		addStructure("dark_type_b_union_intersection_b");
		addStructure("dark_type_b_union_intersection_c");
		addStructure("dark_type_b_union_intersection_d");
		addStructure("dark_type_b_union_intersection_e");
		//addStructure("dark_type_c_corner_a");
		//addStructure("dark_type_c_corner_b");
		//addStructure("dark_type_c_corner_c");
		//addStructure("dark_type_c_corner_d");
		addStructure("dark_type_c_corridor_a");
		addStructure("dark_type_c_corridor_b");
		addStructure("dark_type_c_intersection_a");
		addStructure("dark_type_c_union_intersection_b");
		addStructure("dark_type_c_union_intersection_c");
		//addStructure("dark_type_d_corner_a");
		//addStructure("dark_type_d_corner_b");
		//addStructure("dark_type_d_corner_c");
		//addStructure("dark_type_d_corner_d");
		addStructure("dark_type_d_corridor_a");
		addStructure("dark_type_d_corridor_b");
		addStructure("dark_type_d_union_intersection_b");
		addStructure("dark_type_d_union_intersection_c");
		addStructure("dark_type_d_union_intersection_d");
		addStructure("dark_type_d_union_intersection_e");
		//addStructure("dark_type_e_corner_a");
		//addStructure("dark_type_e_corner_b");
		//addStructure("dark_type_e_corner_c");
		//addStructure("dark_type_e_corner_d");
		addStructure("dark_type_e_corridor_a");
		addStructure("dark_type_e_corridor_b");
		addStructure("dark_type_e_intersection_a");
		addStructure("dark_type_e_union_intersection_b");
		addStructure("dark_type_e_union_intersection_c");
		addStructure("dark_type_e_union_intersection_d");
		addStructure("dark_type_e_union_intersection_e");
		//addStructure("dark_type_f_corner_a");
		//addStructure("dark_type_f_corner_b");
		//addStructure("dark_type_f_corner_c");
		//addStructure("dark_type_f_corner_d");
		addStructure("dark_type_f_corridor_a");
		addStructure("dark_type_f_corridor_b");
		addStructure("dark_type_f_union_intersection_b");
		addStructure("dark_type_f_union_intersection_c");
		addStructure("dark_type_f_union_intersection_d");
		addStructure("dark_type_f_union_intersection_e");
		addStructure("dark_type_f_union_intersection_d");
		addStructure("dark_type_f_union_intersection_e");
		//addStructure("type_a_corner_a");
		//addStructure("type_a_corner_b");
		//addStructure("type_a_corner_c");
		//addStructure("type_a_corner_d");
		addStructure("type_a_corridor_a");
		addStructure("type_a_corridor_b");
		addStructure("type_a_intersection_a");
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
		addStructure("type_c_union_intersection_b");
		addStructure("type_c_union_intersection_c");
		//addStructure("type_d_corner_a");
		//addStructure("type_d_corner_b");
		//addStructure("type_d_corner_c");
		//addStructure("type_d_corner_d");
		addStructure("type_d_corridor_a");
		addStructure("type_d_corridor_b");
		addStructure("type_d_union_intersection_b");
		addStructure("type_d_union_intersection_c");
		addStructure("type_d_union_intersection_d");
		addStructure("type_d_union_intersection_e");
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
		addStructure("type_f_union_intersection_d");
		addStructure("type_f_union_intersection_e");
		
		addStructure("tolevel4_a");
		addStructure("tolevel4_b");
		addStructure("tolevel5_a");
		addStructure("tolevel5_b");
	}

	@Override
	public ResourceLocation getContextItem() {
		return OriginalContexts.LEVEL3_DIMENSION;
	}

	@Override
	public String getStructureLocationForLevel() {
		return "level3/";
	}
	
	@Override
	public World getWorld() {
		return this.world;
	}
	
}
