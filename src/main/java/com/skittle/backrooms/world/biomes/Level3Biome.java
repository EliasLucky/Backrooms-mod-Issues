package com.skittle.backrooms.world.biomes;

import com.skittle.backrooms.init.BlockInit;

import net.minecraft.world.biome.Biome;

public class Level3Biome extends Biome
{
	public Level3Biome()
	{
		super(new BiomeProperties("level3biome").setRainDisabled());
		this.spawnableWaterCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.fillerBlock = BlockInit.STONE_CHECKERED.getDefaultState();
	}
}
