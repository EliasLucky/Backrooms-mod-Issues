package com.skittle.backrooms.init;

import java.util.ArrayList;
import java.util.List;

import com.skittle.backrooms.objects.items.AlmondWater;
import com.skittle.backrooms.objects.items.MusicDiscItem;
import com.skittle.backrooms.objects.items.RawAlmondWater;
import com.skittle.backrooms.objects.items.WallpaperPattern;
import com.skittle.backrooms.utils.handlers.SoundsHandler;

import net.minecraft.item.Item;

public class ItemInit
{
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static final Item YELLOW_WALLPAPER_PATTERN = new WallpaperPattern("yellow_wallpaper_pattern");
	public static final Item DOTTED_YELLOW_WALLPAPER_PATTERN = new WallpaperPattern("dotted_yellow_wallpaper_pattern");
	public static final Item WHITE_WALLPAPER_PATTERN = new WallpaperPattern("white_wallpaper_pattern");
	public static final Item DOTTED_WHITE_WALLPAPER_PATTERN = new WallpaperPattern("dotted_white_wallpaper_pattern");
	public static final Item RED_WALLPAPER_PATTERN = new WallpaperPattern("red_wallpaper_pattern");
	/*
	public static final Item MUSIC_DISC_ITS_BEEN_SO_LONG = new MusicDiscItem("music_disc_its_been_so_long", SoundsHandler.MUSIC_DISC_ITS_BEEN_SO_LONG);
	public static final Item MUSIC_DISC_OMAE_WA_MOU = new MusicDiscItem("music_disc_omae_wa_mou", SoundsHandler.MUSIC_DISC_OMAE_WA_MOU);
	public static final Item MUSIC_DISC_GLACIAL_CAVERN = new MusicDiscItem("music_disc_glacial_cavern", SoundsHandler.MUSIC_DISC_GLACIAL_CAVERN);
	public static final Item MUSIC_DISC_012 = new MusicDiscItem("music_disc_012", SoundsHandler.MUSIC_DISC_012);
	public static final Item MUSIC_DISC_THOSE_TORN_WALLS = new MusicDiscItem("music_disc_those_torn_walls", SoundsHandler.MUSIC_DISC_THOSE_TORN_WALLS);
	public static final Item MUSIC_DISC_BURGERS_AND_FRIES = new MusicDiscItem("music_disc_burgers_and_fries", SoundsHandler.MUSIC_DISC_BURGERS_AND_FRIES);
	public static final Item MUSIC_DISC_PRETZELS_AND_CHEESE = new MusicDiscItem("music_disc_pretzels_and_cheese", SoundsHandler.MUSIC_DISC_PRETZELS_AND_CHEESE);
	public static final Item MUSIC_DISC_GOOD_NIGHT = new MusicDiscItem("music_disc_good_night", SoundsHandler.MUSIC_DISC_GOOD_NIGHT);
	public static final Item MUSIC_DISC_CRUSH = new MusicDiscItem("music_disc_crush", SoundsHandler.MUSIC_DISC_CRUSH);
	public static final Item MUSIC_DISC_COMFORT_CHAIN = new MusicDiscItem("music_disc_comfort_chain", SoundsHandler.MUSIC_DISC_COMFORT_CHAIN);
	public static final Item MUSIC_DISC_SIX_FORTY_SEVEN = new MusicDiscItem("music_disc_six_forty_seven", SoundsHandler.MUSIC_DISC_SIX_FORTY_SEVEN);
	*/
	
	public static final Item MUSIC_DISC_FNAF = new MusicDiscItem("music_disc_five_nights_at_freddys", SoundsHandler.MUSIC_DISC_FNAF);
	public static final Item MUSIC_DISC_GOOD_NIGHT = new MusicDiscItem("music_disc_good_night", SoundsHandler.MUSIC_DISC_GOOD_NIGHT);
	public static final Item MUSIC_DISC_CRUSH = new MusicDiscItem("music_disc_crush", SoundsHandler.MUSIC_DISC_CRUSH);
	public static final Item MUSIC_DISC_COMFORT_CHAIN = new MusicDiscItem("music_disc_comfort_chain", SoundsHandler.MUSIC_DISC_COMFORT_CHAIN);
	public static final Item MUSIC_DISC_SIX_FORTY_SEVEN = new MusicDiscItem("music_disc_six_forty_seven", SoundsHandler.MUSIC_DISC_SIX_FORTY_SEVEN);
	
	
	public static final Item ALMOND_WATER = new AlmondWater("almond_water", 5);
	public static final Item RAW_ALMOND_WATER = new RawAlmondWater("raw_almond_water", 0);
}
