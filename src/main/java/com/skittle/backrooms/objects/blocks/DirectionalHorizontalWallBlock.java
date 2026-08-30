package com.skittle.backrooms.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DirectionalHorizontalWallBlock extends DirectionalHorizontalBlock
{	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { FACING });
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		EnumFacing enumFacing = EnumFacing.getFront(meta);
		
		if (enumFacing.getAxis() == EnumFacing.Axis.Y) {
			enumFacing = EnumFacing.NORTH;
		}
		
		return this.getDefaultState().withProperty(FACING, enumFacing);
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		return ((EnumFacing)state.getValue(FACING)).getIndex();
	}

	public DirectionalHorizontalWallBlock(Material materialIn) {
		super(materialIn);
	}

	@Override
	public boolean canPlaceBlockOnSide(World worldIn, BlockPos pos, EnumFacing side)
	{
		if (this.canAttachTo(worldIn, pos.west(), side))
        {
            return true;
        }
        else if (this.canAttachTo(worldIn, pos.east(), side))
        {
            return true;
        }
        else if (this.canAttachTo(worldIn, pos.north(), side))
        {
            return true;
        }
        else
        {
            return this.canAttachTo(worldIn, pos.south(), side);
        }
	}
	
	private boolean canAttachTo(World world, BlockPos pos, EnumFacing enumFacing)
	{
		IBlockState blockState = world.getBlockState(pos);
		boolean flag = isExceptBlockForAttachWithPiston(blockState.getBlock());
		return !flag && blockState.getBlockFaceShape(world, pos, enumFacing) == BlockFaceShape.SOLID && !blockState.canProvidePower();
	}
	
	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
		if (facing.getAxis().isHorizontal() && this.canAttachTo(world, pos.offset(facing.getOpposite()), facing))
		{
			return this.getDefaultState().withProperty(FACING, facing);
		}
		else
		{
			for (EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL)
			{
				if (this.canAttachTo(world, pos.offset(enumfacing.getOpposite()), enumfacing))
				{
					return this.getDefaultState().withProperty(FACING, enumfacing);
				}
			}
			return this.getDefaultState();
		}
	}
	
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
	{
		EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);
		
		if (!this.canAttachTo(worldIn, pos.offset(enumfacing.getOpposite()), enumfacing))
		{
			this.dropBlockAsItem(worldIn, pos, state, 0);
			worldIn.setBlockToAir(pos);
		}
		
		super.neighborChanged(state, worldIn, pos, blockIn, fromPos);
	}
}
