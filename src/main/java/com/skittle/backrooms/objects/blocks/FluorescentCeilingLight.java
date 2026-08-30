package com.skittle.backrooms.objects.blocks;

import javax.annotation.Nullable;

import com.skittle.backrooms.Backrooms;
import com.skittle.backrooms.init.BlockInit;
import com.skittle.backrooms.init.ItemInit;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class FluorescentCeilingLight extends DirectionalHorizontalCeilingBlock
{
	static final AxisAlignedBB BOX = new AxisAlignedBB(0.0D, 1.0D, 0.0D, 1.0D, 0.875D, 1.0D);
	
	public FluorescentCeilingLight(String name, Material material, SoundType soundType, float hardness, float resistance, int lightVal)
	{
		super(material);
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Backrooms.BACKROOMS_BUILDING_BLOCKS);
		
		setHardness(hardness);
		setResistance(resistance);
		setHarvestLevel("pickaxe", 0);
		
		lightValue = lightVal;
		
		setSoundType(soundType);
		
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
	
	@Nullable
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return null;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return BOX;
	}
	
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
	{
		return BlockFaceShape.UNDEFINED;
	}
}
