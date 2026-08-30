package com.skittle.backrooms.objects.blocks;

import java.util.Random;

import com.skittle.backrooms.Backrooms;
import com.skittle.backrooms.init.BlockInit;
import com.skittle.backrooms.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class Light extends Block
{
	boolean canSilkHarvest;
	
	public Light(String name, Material material, SoundType soundType, float hardness, float resistance, int lightVal, boolean canSilkHarvest)
	{
		super(material);
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Backrooms.BACKROOMS_BUILDING_BLOCKS);
		
		setHardness(hardness);
		setResistance(resistance);
		
		lightValue = lightVal;
		this.canSilkHarvest = canSilkHarvest;
		
		setSoundType(soundType);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		if (canSilkHarvest) {
			return Items.REDSTONE;
		}
		
		return Item.getItemFromBlock(this);
	}
	
	@Override
	protected boolean canSilkHarvest() {
		return canSilkHarvest;
	}
}
