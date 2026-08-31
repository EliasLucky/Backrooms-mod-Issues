package com.skittle.backrooms;

public class IntegerColor
{
	public int RGBToInt(int red, int green, int blue) {
		red = (red << 16) & 0x00FF0000;
		green = (green << 8) & 0x0000FF00;
		blue = blue & 0x000000FF;
		
		return 0xFF000000 | red | green | blue;
	}
}
