package com.skittle.backrooms.proxy;

import org.apache.commons.lang3.ArrayUtils;

import com.skittle.backrooms.api.Loot;
import com.skittle.backrooms.api.LootContainer;
import com.skittle.backrooms.api.OriginalContexts;
import com.skittle.backrooms.init.ItemInit;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityChest;

public class CommonProxy
{
	public void registerItemRenderer(Item item, int meta, String id) {}
	
	public void preLoad() {}
	
	public void load()
	{
		Loot almondWaterLvl1 = new Loot(ItemInit.ALMOND_WATER, 4, 1, 1, OriginalContexts.LEVEL1_DIMENSION::equals);
		Loot ironAxe = new Loot(Items.IRON_AXE, 3, 1, 1, OriginalContexts.LEVEL1_DIMENSION::equals);
		Loot paper = new Loot(Items.PAPER, 3, 1, 1, OriginalContexts.LEVEL1_DIMENSION::equals);
		Loot fleshLvl1 = new Loot(Items.ROTTEN_FLESH, 2, 1, 1, OriginalContexts.LEVEL1_DIMENSION::equals);
		
		Loot rawAlmondWaterLvl2 = new Loot(ItemInit.RAW_ALMOND_WATER, 3, 1, 1, OriginalContexts.LEVEL2_DIMENSION::equals);
		Loot ironIngotLvl2 = new Loot(Items.IRON_INGOT, 3, 1, 1, OriginalContexts.LEVEL2_DIMENSION::equals);
		Loot redstoneDust = new Loot(Items.REDSTONE, 2, 1, 1, OriginalContexts.LEVEL2_DIMENSION::equals);
		
		Loot rawAlmondWaterLvl3 = new Loot(ItemInit.RAW_ALMOND_WATER, 3, 1, 1, OriginalContexts.LEVEL3_DIMENSION::equals);
		Loot almondWaterLvl3 = new Loot(ItemInit.ALMOND_WATER, 2, 1, 1, OriginalContexts.LEVEL3_DIMENSION::equals);
		Loot fleshLvl3 = new Loot(Items.ROTTEN_FLESH, 2, 1, 1, OriginalContexts.LEVEL3_DIMENSION::equals);
		Loot ironIngotLvl3 = new Loot(Items.IRON_INGOT, 3, 1, 1, OriginalContexts.LEVEL3_DIMENSION::equals);
		
		Loot almondWaterLvl5 = new Loot(ItemInit.ALMOND_WATER, 2, 1, 1, OriginalContexts.LEVEL5_DIMENSION::equals);
		
		
		Loot discGoodNight = new Loot(ItemInit.MUSIC_DISC_GOOD_NIGHT, 5, 1, 1, OriginalContexts.LEVEL1_DIMENSION::equals);
		Loot discCrush = new Loot(ItemInit.MUSIC_DISC_CRUSH, 5, 1, 1, OriginalContexts.LEVEL1_DIMENSION::equals);
		Loot discSixFortySeven = new Loot(ItemInit.MUSIC_DISC_SIX_FORTY_SEVEN, 5, 1, 1, OriginalContexts.LEVEL2_DIMENSION::equals);
		Loot discComfortChain = new Loot(ItemInit.MUSIC_DISC_GOOD_NIGHT, 5, 1, 1, OriginalContexts.LEVEL3_DIMENSION::equals);
		Loot discFNAF = new Loot(ItemInit.MUSIC_DISC_FNAF, 5, 1, 1, OriginalContexts.LEVEL5_DIMENSION::equals);
		
		Loot[] level1Loot = (Loot[])ArrayUtils.toArray((Object[])new Loot[] {
			almondWaterLvl1, ironAxe, paper, fleshLvl1, discGoodNight, discCrush
		});
		
		Loot[] level2Loot = (Loot[])ArrayUtils.toArray((Object[])new Loot[] {
			ironIngotLvl2, redstoneDust, rawAlmondWaterLvl2, discSixFortySeven
		});
		
		Loot[] level3Loot = (Loot[])ArrayUtils.toArray((Object[])new Loot[] {
			rawAlmondWaterLvl3, almondWaterLvl3, fleshLvl3, ironIngotLvl3, discComfortChain
		});
		
		Loot[] level5Loot = (Loot[])ArrayUtils.toArray((Object[])new Loot[] {
			almondWaterLvl5, discFNAF
		});
		
		LootContainer.registerLoot2(TileEntityChest.class, level1Loot);
		LootContainer.registerLoot2(TileEntityChest.class, level2Loot);
		LootContainer.registerLoot2(TileEntityChest.class, level3Loot);
		LootContainer.registerLoot2(TileEntityChest.class, level5Loot);
		
		/*
		Loot yellowWallpaperPattern = new Loot(ItemInit.YELLOW_WALLPAPER_PATTERN, 4, 1, 3, OriginalContexts.LEVEL1_DIMENSION::equals);
		Loot whiteWallpaperPattern = new Loot(ItemInit.WHITE_WALLPAPER_PATTERN, 4, 1, 3, OriginalContexts.LEVEL1_DIMENSION::equals);
		Loot yellowDottedWallpaperPattern = new Loot(ItemInit.DOTTED_YELLOW_WALLPAPER_PATTERN, 4, 1, 3, OriginalContexts.LEVEL1_DIMENSION::equals);
		Loot whiteDottedWallpaperPattern = new Loot(ItemInit.DOTTED_WHITE_WALLPAPER_PATTERN, 4, 1, 3, OriginalContexts.LEVEL1_DIMENSION::equals);
		Loot almondWaterPattern = new Loot(ItemInit.ALMOND_WATER, 4, 1, 3, OriginalContexts.LEVEL1_DIMENSION::equals);
		
		Loot[] level1Loot = (Loot[])ArrayUtils.toArray((Object[])new Loot[] {
				yellowWallpaperPattern, whiteWallpaperPattern, yellowDottedWallpaperPattern,
				whiteDottedWallpaperPattern, almondWaterPattern
		});
		
		LootContainer.registerLoot2(TileEntityChest.class, level1Loot);*/
	}
}