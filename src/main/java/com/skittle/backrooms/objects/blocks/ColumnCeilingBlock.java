package com.skittle.backrooms.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ColumnCeilingBlock extends Block
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
		return this.getDefaultState().withProperty((IProperty)FACING, EnumFacing.getFront(meta));
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		return ((EnumFacing)state.getValue((IProperty)FACING)).getIndex();
	}
	
	public ColumnCeilingBlock(Material material)
	{
		super(material);
		setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.SOUTH).withProperty(LOWER, Boolean.valueOf(false)).withProperty(MIDDLE, Boolean.valueOf(false)).withProperty(UPPER, Boolean.valueOf(false)));
		//setCreativeTab(Backrooms.BACKROOMS_BUILDING_BLOCKS);
	}
	
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		return super.canPlaceBlockAt(worldIn, pos) ? this.canBlockStay(worldIn, pos) : false;
	}
	
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		if (!this.canBlockStay(worldIn, pos)) {
			this.dropBlockAsItem(worldIn, pos, state, 0);
			worldIn.setBlockToAir(pos);
		}
	}
	
	private boolean canBlockStay(World world, BlockPos pos) {
		return world.getBlockState(pos.up()).getMaterial().isSolid();
	}
	
	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
		return this.getDefaultState().withProperty((IProperty)FACING, placer.getHorizontalFacing().getOpposite());
	}
	
	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot) {
		return state.withProperty((IProperty)FACING, rot.rotate((EnumFacing)state.getValue((IProperty)FACING)));
	}
}
