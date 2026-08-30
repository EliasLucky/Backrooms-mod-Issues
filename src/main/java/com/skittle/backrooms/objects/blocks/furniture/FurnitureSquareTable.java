package com.skittle.backrooms.objects.blocks.furniture;

import com.skittle.backrooms.Backrooms;
import com.skittle.backrooms.init.BlockInit;
import com.skittle.backrooms.init.ItemInit;
import com.skittle.backrooms.objects.blocks.MultipleBlock;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class FurnitureSquareTable extends MultipleBlock
{
	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		boolean back = (worldIn.getBlockState(pos.south()).getBlock() == this);
		boolean forward = (worldIn.getBlockState(pos.north()).getBlock() == this);
		boolean left = (worldIn.getBlockState(pos.west()).getBlock() == this);
		boolean right = (worldIn.getBlockState(pos.east()).getBlock() == this);
		
		return state.withProperty(BACK, Boolean.valueOf(back)).withProperty(FORWARD, Boolean.valueOf(forward)).withProperty(LEFT, Boolean.valueOf(left)).withProperty(RIGHT, Boolean.valueOf(right));
	}

	public FurnitureSquareTable(String name, Material material) {
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

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
}
