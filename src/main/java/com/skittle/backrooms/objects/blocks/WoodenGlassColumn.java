package com.skittle.backrooms.objects.blocks;

import com.skittle.backrooms.Backrooms;
import com.skittle.backrooms.init.BlockInit;
import com.skittle.backrooms.init.ItemInit;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WoodenGlassColumn extends ColumnBlock
{
	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		boolean bottom = (worldIn.getBlockState(pos.up()).getBlock() == this);
		boolean middle = ((worldIn.getBlockState(pos).getBlock() == this) &&
						  (worldIn.getBlockState(pos.up()).getBlock() == this) &&
						  (worldIn.getBlockState(pos.down()).getBlock() == this));
		boolean top = (worldIn.getBlockState(pos.down()).getBlock() == this);
		
		return state.withProperty(LOWER, Boolean.valueOf(bottom)).withProperty(MIDDLE, Boolean.valueOf(middle)).withProperty(UPPER, Boolean.valueOf(top));
	}

	public WoodenGlassColumn(String name, Material material, int lightVal, boolean hasCreativeTab) {
		super(material);
		
		setUnlocalizedName(name);
		setRegistryName(name);
		
		if (hasCreativeTab) {
			setCreativeTab(Backrooms.BACKROOMS_BUILDING_BLOCKS);
		}
		
		setHardness(3.0F);
		setResistance(3.0F);
		
		lightValue = lightVal;
		
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

	@SideOnly(Side.CLIENT)
	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}
	
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}
}
