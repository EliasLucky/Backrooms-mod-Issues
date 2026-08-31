package com.skittle.backrooms.reference;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.skittle.backrooms.IntegerColor;

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
	
	//Integer Colors\\
		public static final int WHITE = new IntegerColor().RGBToInt(255, 255, 255);
		public static final int BLACK = new IntegerColor().RGBToInt(0, 0, 0);
		public static final int RED = new IntegerColor().RGBToInt(255, 0, 0);
		public static final int DARK_RED = new IntegerColor().RGBToInt(139, 0, 0);
		public static final int LIGHT_YELLOW = new IntegerColor().RGBToInt(255, 255, 102);
		public static final int YELLOW = new IntegerColor().RGBToInt(255, 255, 0);
		public static final int DARK_YELLOW = new IntegerColor().RGBToInt(204, 204, 0);
		public static final int GOLD = new IntegerColor().RGBToInt(255, 215, 0);
		public static final int ORANGE = new IntegerColor().RGBToInt(255, 165, 0);
		public static final int DARK_ORANGE = new IntegerColor().RGBToInt(255, 140, 0);
		public static final int LIME = new IntegerColor().RGBToInt(0, 255, 0);
		public static final int GREEN = new IntegerColor().RGBToInt(0, 128, 0);
		public static final int DARK_GREEN = new IntegerColor().RGBToInt(0, 100, 0);
		public static final int LIGHT_BLUE = new IntegerColor().RGBToInt(135, 206, 250);
		public static final int BLUE = new IntegerColor().RGBToInt(0, 0, 255);
		public static final int DARK_BLUE = new IntegerColor().RGBToInt(0, 0, 139);
		public static final int CYAN = new IntegerColor().RGBToInt(0, 255, 255);
		public static final int DARK_CYAN = new IntegerColor().RGBToInt(0, 139, 139);
		public static final int MAGENTA = new IntegerColor().RGBToInt(155, 0, 255);
		public static final int VIOLET = new IntegerColor().RGBToInt(138, 43, 266);
		public static final int PURPLE = new IntegerColor().RGBToInt(128, 0, 128);
		public static final int PINK = new IntegerColor().RGBToInt(255, 192, 203);
		public static final int LIGHT_GRAY = new IntegerColor().RGBToInt(211, 211, 211);
		public static final int SILVER = new IntegerColor().RGBToInt(192, 192, 192);
		public static final int GRAY = new IntegerColor().RGBToInt(169, 169, 169);
		public static final int DARK_GRAY = new IntegerColor().RGBToInt(128, 128, 128);
		public static final int BEIGE = new IntegerColor().RGBToInt(159, 144, 105);
		public static final int BROWN = new IntegerColor().RGBToInt(115, 93, 71);
}
