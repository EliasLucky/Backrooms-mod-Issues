package com.skittle.backrooms.init;

import com.skittle.backrooms.world.dimensions.level0.Level0Provider;
import com.skittle.backrooms.world.dimensions.level0_2.Level0_2Provider;
import com.skittle.backrooms.world.dimensions.level1.Level1Provider;
import com.skittle.backrooms.world.dimensions.level2.Level2Provider;
import com.skittle.backrooms.world.dimensions.level3.Level3Provider;
import com.skittle.backrooms.world.dimensions.level4.Level4Provider;
import com.skittle.backrooms.world.dimensions.level5.Level5Provider;
import com.skittle.backrooms.world.dimensions.level6.Level6Provider;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class DimensionInit
{
	public static final DimensionType LEVEL0 = DimensionType.register("level0", "_level0", 1000, Level0Provider.class, false);
	public static final DimensionType LEVEL0_2 = DimensionType.register("level0.2", "_level0.2", -1000, Level0_2Provider.class, false);
	public static final DimensionType LEVEL1 = DimensionType.register("level1", "_level1", 1001, Level1Provider.class, false);
	public static final DimensionType LEVEL2 = DimensionType.register("level2", "_level2", 1002, Level2Provider.class, false);
	public static final DimensionType LEVEL3 = DimensionType.register("level3", "_level3", 1003, Level3Provider.class, false);
	public static final DimensionType LEVEL4 = DimensionType.register("level4", "_level4", 1004, Level4Provider.class, false);
	public static final DimensionType LEVEL5 = DimensionType.register("level5", "_level5", 1005, Level5Provider.class, false);
	public static final DimensionType LEVEL6 = DimensionType.register("level6", "_level6", 1006, Level6Provider.class, false);
	
	public static void registerDimensions()
	{
		DimensionManager.registerDimension(1000, LEVEL0);
		DimensionManager.registerDimension(-1000, LEVEL0_2);
		DimensionManager.registerDimension(1001, LEVEL1);
		DimensionManager.registerDimension(1002, LEVEL2);
		DimensionManager.registerDimension(1003, LEVEL3);
		DimensionManager.registerDimension(1004, LEVEL4);
		DimensionManager.registerDimension(1005, LEVEL5);
		DimensionManager.registerDimension(1006, LEVEL6);
	}
}
