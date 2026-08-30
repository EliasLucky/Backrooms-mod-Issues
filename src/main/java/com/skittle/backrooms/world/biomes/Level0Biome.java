package com.skittle.backrooms.world.biomes;

import com.skittle.backrooms.init.BlockInit;

import net.minecraft.world.biome.Biome;

public class Level0Biome extends Biome
{
	public Level0Biome()
	{
		super(new BiomeProperties("level0biome").setRainDisabled());
		this.spawnableWaterCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.fillerBlock = BlockInit.TILE.getDefaultState();
	}
}
