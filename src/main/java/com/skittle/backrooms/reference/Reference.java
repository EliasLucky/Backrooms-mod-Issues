package com.skittle.backrooms.reference;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

public class Reference
{
	public static Logger logger = LogManager.getLogger("The Backrooms Ultimate Edition");
	
	public static final String MODID = "backrooms";
	public static final String NAME = "The Backrooms Ultimate Edition";
	public static final String VERSION = "0.1.6";
	public static final String ACCEPTED_MINECRAFT_VERSION = "1.12.2, 1.12.1";
	
	public static final String CLIENT = "com.skittle.backrooms.proxy.ClientProxy";
	public static final String COMMON = "com.skittle.backrooms.proxy.CommonProxy";

	public static SimpleNetworkWrapper NETWORK = new SimpleNetworkWrapper(MODID);
}
