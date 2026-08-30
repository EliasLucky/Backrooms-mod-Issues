package com.skittle.backrooms.world.dimensions.level2;

import com.skittle.backrooms.api.OriginalContexts;
import com.skittle.backrooms.init.BiomeInit;
import com.skittle.backrooms.init.DimensionInit;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.IChunkGenerator;

public class Level2Provider extends WorldProvider
{
	@Override
	public DimensionType getDimensionType() {
		return DimensionInit.LEVEL2;
	}

	@Override
	public IChunkGenerator createChunkGenerator() {
		return new Level2ChunkGenerator(this.world, "level2/", OriginalContexts.LEVEL2_DIMENSION, true);
	}
	
	@Override
	public boolean canRespawnHere() {
		return false;
	}
	
	@Override
	public boolean isSurfaceWorld() {
		return false;
	}
	
	@Override
	public boolean canMineBlock(EntityPlayer player, BlockPos pos) {
		return false;
	}
	
	@Override
	protected void init() {
		this.hasSkyLight = false;
		this.biomeProvider = (BiomeProvider)new BiomeProviderSingle(BiomeInit.LEVEL2KEY);
	}
	
	@Override
	public float calculateCelestialAngle(long worldTime, float partialTicks) {
		return 0.5F;
	}
	
	@Override
	public boolean canDoRainSnowIce(Chunk chunk) {
		return false;
	}
	
	@Override
	public float getSunBrightnessFactor(float par1) {
		return 0.5F;
	}
	
	@Override
	public String getSaveFolder() {
		return "LEVEL2";
	}
}
