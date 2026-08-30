package com.skittle.backrooms.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ColumnWallBlock extends Block
{
	public static PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	
	public static final PropertyBool LOWER = PropertyBool.create("lower");
	public static final PropertyBool MIDDLE = PropertyBool.create("middle");
	public static final PropertyBool UPPER = PropertyBool.create("upper");
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer((Block)this, new IProperty[] { (IProperty)FACING, LOWER, MIDDLE, UPPER });
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
		return ((EnumFacing)state.getValue((IProperty)FACING)).getIndex();
	}
	
	public ColumnWallBlock(Material material)
	{
		super(material);
		setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.SOUTH).withProperty(LOWER, Boolean.valueOf(false)).withProperty(MIDDLE, Boolean.valueOf(false)).withProperty(UPPER, Boolean.valueOf(false)));
		//setCreativeTab(Backrooms.BACKROOMS_BUILDING_BLOCKS);
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
	
	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot) {
		return state.withProperty((IProperty)FACING, rot.rotate((EnumFacing)state.getValue((IProperty)FACING)));
	}
	
	@Override
	public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
		return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING)));
	}
}
