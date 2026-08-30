package com.skittle.backrooms.objects.blocks;

import com.skittle.backrooms.Backrooms;
import com.skittle.backrooms.init.BlockInit;
import com.skittle.backrooms.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;

public class WoodenBlock extends Block
{
	public WoodenBlock(String name, Material material)
	{
		super(material);

		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Backrooms.BACKROOMS_BUILDING_BLOCKS);
		
		setHardness(2.0F);
		setResistance(2.0F);
		setHarvestLevel("axe", 0);
		
		setSoundType(SoundType.WOOD);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
}
