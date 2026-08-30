package com.skittle.backrooms.utils.handlers;

import com.skittle.backrooms.reference.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class SoundsHandler
{
	public static SoundEvent WALLPAPER_TEAR, HUMM_BUZZ;
	public static SoundEvent MUSIC_DISC_FNAF, MUSIC_DISC_GOOD_NIGHT, MUSIC_DISC_CRUSH, MUSIC_DISC_COMFORT_CHAIN, MUSIC_DISC_SIX_FORTY_SEVEN;;
	//public static SoundEvent MUSIC_DISC_ITS_BEEN_SO_LONG, MUSIC_DISC_OMAE_WA_MOU, MUSIC_DISC_GLACIAL_CAVERN, MUSIC_DISC_012, MUSIC_DISC_THOSE_TORN_WALLS, MUSIC_DISC_BURGERS_AND_FRIES, MUSIC_DISC_PRETZELS_AND_CHEESE, MUSIC_DISC_GOOD_NIGHT, MUSIC_DISC_CRUSH, MUSIC_DISC_COMFORT_CHAIN, MUSIC_DISC_SIX_FORTY_SEVEN;

	public static void registerSoundEvents()
	{
		WALLPAPER_TEAR = registerSoundEvent("tear");
		HUMM_BUZZ = registerSoundEvent("humm_buzz");
		
		MUSIC_DISC_FNAF = registerSoundEvent("music_disc.five_nights_at_freddys");
		MUSIC_DISC_GOOD_NIGHT = registerSoundEvent("music_disc.good_night");
		MUSIC_DISC_CRUSH = registerSoundEvent("music_disc.crush");
		MUSIC_DISC_COMFORT_CHAIN = registerSoundEvent("music_disc.comfort_chain");
		MUSIC_DISC_SIX_FORTY_SEVEN = registerSoundEvent("music_disc.six_forty_seven");
		
		/*
		MUSIC_DISC_ITS_BEEN_SO_LONG = registerSoundEvent("music_disc.its_been_so_long");
		MUSIC_DISC_OMAE_WA_MOU = registerSoundEvent("music_disc.omae_wa_mou");
		MUSIC_DISC_GLACIAL_CAVERN = registerSoundEvent("music_disc.glacial_cavern");
		MUSIC_DISC_012 = registerSoundEvent("music_disc.012");
		MUSIC_DISC_THOSE_TORN_WALLS = registerSoundEvent("music_disc.those_torn_walls");
		MUSIC_DISC_BURGERS_AND_FRIES = registerSoundEvent("music_disc.burgers_and_fries");
		MUSIC_DISC_PRETZELS_AND_CHEESE = registerSoundEvent("music_disc.pretzels_and_cheese");
		MUSIC_DISC_GOOD_NIGHT = registerSoundEvent("music_disc.good_night");
		MUSIC_DISC_CRUSH = registerSoundEvent("music_disc.crush");
		MUSIC_DISC_COMFORT_CHAIN = registerSoundEvent("music_disc.comfort_chain");
		MUSIC_DISC_SIX_FORTY_SEVEN = registerSoundEvent("music_disc.six_forty_seven");
		*/
		
	}
	
	private static SoundEvent registerSoundEvent(String name)
	{
		ResourceLocation location = new ResourceLocation(Reference.MODID, name);
		SoundEvent event = new SoundEvent(location);
		event.setRegistryName(name);
		ForgeRegistries.SOUND_EVENTS.register(event);
		return event;
	}
}
