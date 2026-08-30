package com.skittle.backrooms;

import com.skittle.backrooms.misc.creativetab.BkBuildingBlocksTab;
import com.skittle.backrooms.misc.creativetab.BkItemsTab;
import com.skittle.backrooms.proxy.CommonProxy;
import com.skittle.backrooms.recipes.SmeltingRecipes;
import com.skittle.backrooms.reference.Reference;
import com.skittle.backrooms.utils.handlers.RegisterHandler;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.SidedProxy;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_MINECRAFT_VERSION)
public class Backrooms
{
	@Instance
	public static Backrooms instance;
	
	@SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.COMMON)
	public static CommonProxy proxy;
	
	public static final CreativeTabs BACKROOMS_BUILDING_BLOCKS = new BkBuildingBlocksTab("backrooms_building_blocks");
	public static final CreativeTabs BACKROOMS_ITEMS = new BkItemsTab("backrooms_items");

	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) { RegisterHandler.preInitRegistries(); SmeltingRecipes.init(); };
	
	@EventHandler
	public static void init(FMLInitializationEvent event) {
		Backrooms.proxy.load();
		System.out.println("The Backrooms Ultimate Edition Mod. Only play this mod if you got it from CurseForge. Author: Skittle-man a.k.a Elias Lucky, discord - Skittle-man#4320");
	};
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) { RegisterHandler.postInitRegistries(); };
	
	@EventHandler
	public static void serverInit(FMLServerStartingEvent event) { RegisterHandler.serverRegistries(event); };
}
