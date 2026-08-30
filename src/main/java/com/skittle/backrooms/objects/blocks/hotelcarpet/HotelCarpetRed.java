package com.skittle.backrooms.objects.blocks.hotelcarpet;

import com.skittle.backrooms.Backrooms;
import com.skittle.backrooms.init.BlockInit;
import com.skittle.backrooms.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class HotelCarpetRed extends Block
{
	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	public static final PropertyEnum<HotelCarpetRed.EnumShape> SHAPE = PropertyEnum.<HotelCarpetRed.EnumShape>create("shape", HotelCarpetRed.EnumShape.class);
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { FACING, SHAPE });
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		IBlockState blockState = this.getDefaultState().withProperty(FACING, EnumFacing.getFront(5 - (meta & 3)));
		return blockState;
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		int i = 0;
		i = i | 5 - ((EnumFacing)state.getValue(FACING)).getIndex();
		return i;
	}
	
	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return state.withProperty(SHAPE, getCarpetShape(state, worldIn, pos));
	}
	
	private static HotelCarpetRed.EnumShape getCarpetShape(IBlockState state, IBlockAccess world, BlockPos pos)
	{
		EnumFacing enumFacing = (EnumFacing)state.getValue(FACING);
		IBlockState blockState = world.getBlockState(pos.offset(enumFacing));
		
		if (isBlockCarpet(blockState))
		{
			EnumFacing enumFacing1 = (EnumFacing)blockState.getValue(FACING);
			
			if (enumFacing1.getAxis() != ((EnumFacing)state.getValue(FACING)).getAxis() && isDifferentCarpet(state, world, pos, enumFacing1.getOpposite()))
			{
				if (enumFacing1 == enumFacing.rotateYCCW())
				{
					return HotelCarpetRed.EnumShape.OUTER_LEFT;
				}
				
				return HotelCarpetRed.EnumShape.OUTER_RIGHT;
			}
		}
		
		IBlockState blockState1 = world.getBlockState(pos.offset(enumFacing.getOpposite()));
		
		if (isBlockCarpet(blockState1))
		{
			EnumFacing enumFacing2 = (EnumFacing)blockState1.getValue(FACING);
			
			if (enumFacing2.getAxis() != ((EnumFacing)state.getValue(FACING)).getAxis() && isDifferentCarpet(state, world, pos, enumFacing2))
			{
				if (enumFacing2 == enumFacing.rotateYCCW())
				{
					return HotelCarpetRed.EnumShape.INNER_LEFT;
				}
				
				return HotelCarpetRed.EnumShape.INNER_RIGHT;
			}
		}
		
		return HotelCarpetRed.EnumShape.STRAIGHT;
	}
	
	private static boolean isDifferentCarpet(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing facing) {
		IBlockState blockState = world.getBlockState(pos.offset(facing));
		return !isBlockCarpet(blockState) || blockState.getValue(FACING) != state.getValue(FACING);
	}
	
	private static boolean isBlockCarpet(IBlockState state) {
		return state.getBlock() instanceof HotelCarpetRed;
	}
	
	public HotelCarpetRed(String name, Material material)
	{
		super(material);
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Backrooms.BACKROOMS_BUILDING_BLOCKS);
		
		setHardness(1.0F);
		setResistance(2.0F);
		
		setSoundType(SoundType.CLOTH);
		
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(SHAPE, HotelCarpetRed.EnumShape.STRAIGHT));
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
		IBlockState blockState = super.getStateForPlacement(world, pos, facing, hitX, hitY, hitZ, meta, placer);
		blockState = blockState.withProperty(FACING, placer.getHorizontalFacing()).withProperty(SHAPE, HotelCarpetRed.EnumShape.STRAIGHT);
		return blockState;
	}
	
	@SuppressWarnings("incomplete-switch")
	@Override
	public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
		EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);
        HotelCarpetRed.EnumShape blockcarpet$enumshape = (HotelCarpetRed.EnumShape)state.getValue(SHAPE);

        switch (mirrorIn)
        {
            case LEFT_RIGHT:

                if (enumfacing.getAxis() == EnumFacing.Axis.Z)
                {
                    switch (blockcarpet$enumshape)
                    {
                        case OUTER_LEFT:
                            return state.withRotation(Rotation.CLOCKWISE_180).withProperty(SHAPE, HotelCarpetRed.EnumShape.OUTER_RIGHT);
                        case OUTER_RIGHT:
                            return state.withRotation(Rotation.CLOCKWISE_180).withProperty(SHAPE, HotelCarpetRed.EnumShape.OUTER_LEFT);
                        case INNER_RIGHT:
                            return state.withRotation(Rotation.CLOCKWISE_180).withProperty(SHAPE, HotelCarpetRed.EnumShape.INNER_LEFT);
                        case INNER_LEFT:
                            return state.withRotation(Rotation.CLOCKWISE_180).withProperty(SHAPE, HotelCarpetRed.EnumShape.INNER_RIGHT);
                        default:
                            return state.withRotation(Rotation.CLOCKWISE_180);
                    }
                }

                break;
            case FRONT_BACK:

                if (enumfacing.getAxis() == EnumFacing.Axis.X)
                {
                    switch (blockcarpet$enumshape)
                    {
                        case OUTER_LEFT:
                            return state.withRotation(Rotation.CLOCKWISE_180).withProperty(SHAPE, HotelCarpetRed.EnumShape.OUTER_RIGHT);
                        case OUTER_RIGHT:
                            return state.withRotation(Rotation.CLOCKWISE_180).withProperty(SHAPE, HotelCarpetRed.EnumShape.OUTER_LEFT);
                        case INNER_RIGHT:
                            return state.withRotation(Rotation.CLOCKWISE_180).withProperty(SHAPE, HotelCarpetRed.EnumShape.INNER_RIGHT);
                        case INNER_LEFT:
                            return state.withRotation(Rotation.CLOCKWISE_180).withProperty(SHAPE, HotelCarpetRed.EnumShape.INNER_LEFT);
                        case STRAIGHT:
                            return state.withRotation(Rotation.CLOCKWISE_180);
                    }
                }
        }

        return super.withMirror(state, mirrorIn);
    
	}
	
	public static enum EnumShape implements IStringSerializable
	{
		STRAIGHT("straight"),
		INNER_LEFT("inner_left"),
		INNER_RIGHT("inner_right"),
		OUTER_LEFT("outer_left"),
		OUTER_RIGHT("outer_right");
		
		private final String name;
		
		private EnumShape(String name) {
			this.name = name;
		}
		
		public String toString() {
			return this.name;
		}

		@Override
		public String getName() {
			return this.name;
		}
		
	}
}
