package com.skittle.backrooms.world.chunk;

import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;

public class BackroomsChunk extends Chunk
{
	private String identifier;

	public BackroomsChunk(World worldIn, ChunkPrimer primer, int x, int z, String identifier) {
		super(worldIn, primer, x, z);
		
		this.identifier = identifier;
	}
	
	public String getIdentifier() {
		return this.identifier;
	}
}
