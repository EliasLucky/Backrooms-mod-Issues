package com.skittle.backrooms.init;

import com.skittle.backrooms.world.biomes.Level0Biome;
import com.skittle.backrooms.world.biomes.Level1Biome;
import com.skittle.backrooms.world.biomes.Level2Biome;
import com.skittle.backrooms.world.biomes.Level3Biome;
import com.skittle.backrooms.world.biomes.Level4Biome;
import com.skittle.backrooms.world.biomes.Level5Biome;
import com.skittle.backrooms.world.biomes.Level6Biome;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BiomeInit
{
	public static final Biome LEVEL0KEY = new Level0Biome();
	public static final Biome LEVEL1KEY = new Level1Biome();
	public static final Biome LEVEL2KEY = new Level2Biome();
	public static final Biome LEVEL3KEY = new Level3Biome();
	public static final Biome LEVEL4KEY = new Level4Biome();
	public static final Biome LEVEL5KEY = new Level5Biome();
	public static final Biome LEVEL6KEY = new Level6Biome();
	
	
	public static void registerBiomes() {
		InitBiome(LEVEL0KEY, "level0biome");
		InitBiome(LEVEL1KEY, "level1biome");
		InitBiome(LEVEL2KEY, "level2biome");
		InitBiome(LEVEL3KEY, "level3biome");
		InitBiome(LEVEL4KEY, "level4biome");
		InitBiome(LEVEL5KEY, "level5biome");
		InitBiome(LEVEL6KEY, "level6biome");
		BiomeDictionary.addTypes(LEVEL0KEY, new BiomeDictionary.Type[] { BiomeDictionary.Type.VOID, BiomeDictionary.Type.DEAD });
		BiomeDictionary.addTypes(LEVEL1KEY, new BiomeDictionary.Type[] { BiomeDictionary.Type.VOID, BiomeDictionary.Type.DEAD });
		BiomeDictionary.addTypes(LEVEL2KEY, new BiomeDictionary.Type[] { BiomeDictionary.Type.VOID, BiomeDictionary.Type.DEAD });
		BiomeDictionary.addTypes(LEVEL3KEY, new BiomeDictionary.Type[] { BiomeDictionary.Type.VOID, BiomeDictionary.Type.DEAD });
		BiomeDictionary.addTypes(LEVEL4KEY, new BiomeDictionary.Type[] { BiomeDictionary.Type.VOID, BiomeDictionary.Type.DEAD });
		BiomeDictionary.addTypes(LEVEL5KEY, new BiomeDictionary.Type[] { BiomeDictionary.Type.VOID, BiomeDictionary.Type.DEAD });
		BiomeDictionary.addTypes(LEVEL6KEY, new BiomeDictionary.Type[] { BiomeDictionary.Type.VOID, BiomeDictionary.Type.DEAD });
	}
	
	private static Biome InitBiome(Biome biome, String name) {
		biome.setRegistryName(name);
		ForgeRegistries.BIOMES.register(biome);
		return biome;
	}
}
