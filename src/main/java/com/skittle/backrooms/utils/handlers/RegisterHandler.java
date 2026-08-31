package com.skittle.backrooms.utils.handlers;

import com.skittle.backrooms.Backrooms;
import com.skittle.backrooms.commands.DimensionTeleport;
import com.skittle.backrooms.init.BiomeInit;
import com.skittle.backrooms.init.BlockInit;
import com.skittle.backrooms.init.DimensionInit;
import com.skittle.backrooms.init.EntityInit;
import com.skittle.backrooms.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class RegisterHandler
{
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));
	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event)
	{
		for(Item item : ItemInit.ITEMS) {
			Backrooms.proxy.registerItemRenderer(item, 0, "inventory");
		}
		for(Block block : BlockInit.BLOCKS) {
			Backrooms.proxy.registerItemRenderer(Item.getItemFromBlock(block), 0, "inventory");
		}
	}
	
	public static void preInitRegistries() {
		SoundsHandler.registerSoundEvents();
		EntityInit.registerEntities();
		RenderHandler.registerEntityRenders();
		
		EnumHelper.addArt("Cherry", "Cherry", 16, 16, 0, 16);
		EnumHelper.addArt("Thing", "Thing", 16, 16, 16, 16);
		EnumHelper.addArt("Forest", "Forest", 32, 32, 0, 160);
		EnumHelper.addArt("River", "River", 32, 32, 32, 160);
		EnumHelper.addArt("Coast", "Coast", 32, 32, 64, 160);
		EnumHelper.addArt("Clouds", "Clouds", 32, 32, 96, 160);
		EnumHelper.addArt("Ships", "Ships", 64, 48, 192, 160);
		EnumHelper.addArt("House", "House", 64, 48, 192, 208);
		
		Backrooms.proxy.preLoad();
	}
	
	public static void postInitRegistries() {
		BiomeInit.registerBiomes();
		DimensionInit.registerDimensions();
	}
	
	public static void serverRegistries(FMLServerStartingEvent event) {
		event.registerServerCommand(new DimensionTeleport());
	}
}
