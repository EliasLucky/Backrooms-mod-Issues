package com.skittle.backrooms.world.biomes;

import com.skittle.backrooms.init.BlockInit;

import net.minecraft.world.biome.Biome;

public class Level1Biome extends Biome
{
	public Level1Biome()
	{
		super(new BiomeProperties("level1biome").setRainDisabled());
		this.spawnableWaterCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.fillerBlock = BlockInit.GRAY_CONCRETE.getDefaultState();
	}
}
