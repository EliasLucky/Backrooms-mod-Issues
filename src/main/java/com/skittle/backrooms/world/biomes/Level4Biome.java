package com.skittle.backrooms.world.biomes;

import com.skittle.backrooms.init.BlockInit;

import net.minecraft.world.biome.Biome;

public class Level4Biome extends Biome
{
	public Level4Biome()
	{
		super(new BiomeProperties("level4biome").setRainDisabled());
		this.spawnableWaterCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.fillerBlock = BlockInit.TILE.getDefaultState();
	}
}
