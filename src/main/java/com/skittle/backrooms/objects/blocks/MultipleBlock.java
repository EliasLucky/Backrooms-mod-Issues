package com.skittle.backrooms.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class MultipleBlock extends Block
{
	public static final PropertyBool BACK = PropertyBool.create("back");
	public static final PropertyBool FORWARD = PropertyBool.create("forward");
	public static final PropertyBool LEFT = PropertyBool.create("left");
	public static final PropertyBool RIGHT = PropertyBool.create("right");
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { BACK, FORWARD, LEFT, RIGHT });
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState();
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		return 0;
	}
	
	public MultipleBlock(Material material)
	{
		super(material);
		this.setDefaultState(this.blockState.getBaseState().withProperty(BACK, Boolean.valueOf(false)).withProperty(FORWARD, Boolean.valueOf(false)).withProperty(LEFT, Boolean.valueOf(false)).withProperty(RIGHT, Boolean.valueOf(false)));
	}
	
	@Override
	public boolean isSideSolid(IBlockState base_state, IBlockAccess world, BlockPos pos, EnumFacing side) {
		return (side == EnumFacing.UP);
	}
}
