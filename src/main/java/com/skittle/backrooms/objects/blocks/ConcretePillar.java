package com.skittle.backrooms.objects.blocks;

import com.skittle.backrooms.Backrooms;
import com.skittle.backrooms.init.BlockInit;
import com.skittle.backrooms.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class ConcretePillar extends MultipleBlock
{
	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		boolean back = canBlockConnectTo(worldIn, pos, EnumFacing.SOUTH);
		boolean forward = canBlockConnectTo(worldIn, pos, EnumFacing.NORTH);
		boolean left = canBlockConnectTo(worldIn, pos, EnumFacing.WEST);
		boolean right = canBlockConnectTo(worldIn, pos, EnumFacing.EAST);
		
		return state.withProperty(BACK, Boolean.valueOf(back)).withProperty(FORWARD, Boolean.valueOf(forward)).withProperty(LEFT, Boolean.valueOf(left)).withProperty(RIGHT, Boolean.valueOf(right));
	}

	public ConcretePillar(String name, Material materialIn)
	{
		super(materialIn);

		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Backrooms.BACKROOMS_BUILDING_BLOCKS);
		
		setHardness(4.0F);
		setResistance(5.0F);
		setHarvestLevel("pickaxe", 0);
		
		setSoundType(SoundType.STONE);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	private boolean canConnectTo(IBlockAccess world, BlockPos pos, EnumFacing facing)
	{
		IBlockState blockState = world.getBlockState(pos);
		Block block = blockState.getBlock();
		
		return block == this || block == BlockInit.GRAY_CONCRETE;
	}
	
	private boolean canBlockConnectTo(IBlockAccess world, BlockPos pos, EnumFacing facing)
	{
		BlockPos other = pos.offset(facing);
		return canConnectTo(world, other, facing.getOpposite());
	}
}
