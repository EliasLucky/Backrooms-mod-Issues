package com.skittle.backrooms.objects.blocks;

import com.skittle.backrooms.Backrooms;
import com.skittle.backrooms.init.BlockInit;
import com.skittle.backrooms.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class CementBricksPillar extends MultipleBlock
{
	boolean checkDoors;

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return state.withProperty(BACK, canBlockConnectTo(worldIn, pos, EnumFacing.SOUTH))
					.withProperty(FORWARD, canBlockConnectTo(worldIn, pos, EnumFacing.NORTH))
					.withProperty(LEFT, canBlockConnectTo(worldIn, pos, EnumFacing.WEST))
					.withProperty(RIGHT, canBlockConnectTo(worldIn, pos, EnumFacing.EAST));
	}
	
	public CementBricksPillar(String name, Material material, boolean checkDoors) {
		super(material);

		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Backrooms.BACKROOMS_BUILDING_BLOCKS);
		
		setHardness(4.0F);
		setResistance(5.0F);
		setHarvestLevel("pickaxe", 0);
		
		this.checkDoors = checkDoors;
		
		setSoundType(SoundType.STONE);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	private boolean canConnectTo(IBlockAccess world, BlockPos pos, EnumFacing facing)
	{
		IBlockState blockState = world.getBlockState(pos);
		BlockFaceShape blockFaceShape = blockState.getBlockFaceShape(world, pos, facing);
		
		if (this.checkDoors)
		{
			Block block = blockState.getBlock();
			return blockFaceShape == BlockFaceShape.SOLID || block instanceof BackroomsDoor || block instanceof net.minecraft.block.BlockDoor;
		}
		
		return blockFaceShape == BlockFaceShape.SOLID;
	}
	
	private boolean canBlockConnectTo(IBlockAccess world, BlockPos pos, EnumFacing facing)
	{
		BlockPos other = pos.offset(facing);
		return canConnectTo(world, other, facing.getOpposite());
	}
}
