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

public class FluorescentWallLight extends ColumnWallBlock
{
	static final AxisAlignedBB BOX_NORTH = new AxisAlignedBB(0.440D, 1.0D, 0.8770D, 0.560D, 0.0D, 1.0D);
	static final AxisAlignedBB BOX_SOUTH = new AxisAlignedBB(0.440D, 1.0D, 0.0D, 0.560D, 0.0D, 0.1250D);
	static final AxisAlignedBB BOX_WEST = new AxisAlignedBB(0.8770D, 1.0D, 0.440D, 1.0D, 0.0D, 0.560);
	static final AxisAlignedBB BOX_EAST = new AxisAlignedBB(0.0D, 1.0D, 0.440D, 0.1250D, 0.0D, 0.560);
	
	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		boolean bottom = (worldIn.getBlockState(pos.up()).getBlock() == this);
		boolean middle = ((worldIn.getBlockState(pos).getBlock() == this) &&
						  (worldIn.getBlockState(pos.up()).getBlock() == this) &&
						  (worldIn.getBlockState(pos.down()).getBlock() == this));
		boolean top = (worldIn.getBlockState(pos.down()).getBlock() == this);
		
		return state.withProperty(LOWER, Boolean.valueOf(bottom)).withProperty(MIDDLE, Boolean.valueOf(middle)).withProperty(UPPER, Boolean.valueOf(top));
	}
	
	public FluorescentWallLight(String name, Material material, SoundType soundType, float hardness, float resistance, int lightVal)
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
		switch ((EnumFacing)state.getValue(FACING))
        {
            case EAST:
                return BOX_EAST;
            case WEST:
                return BOX_WEST;
            case SOUTH:
                return BOX_SOUTH;
            case NORTH:
                return BOX_NORTH;
            default:
                return BOX_SOUTH;
        }
	}
	
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
	{
		return BlockFaceShape.UNDEFINED;
	}
}
