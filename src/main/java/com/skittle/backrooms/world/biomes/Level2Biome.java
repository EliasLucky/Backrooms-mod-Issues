package com.skittle.backrooms.world.biomes;

import com.skittle.backrooms.init.BlockInit;

import net.minecraft.world.biome.Biome;

public class Level2Biome extends Biome
{
	public Level2Biome()
	{
		super(new BiomeProperties("level2biome").setRainDisabled());
		this.spawnableWaterCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.fillerBlock = BlockInit.CEMENT.getDefaultState();
	}
}
