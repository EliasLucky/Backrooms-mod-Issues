package com.skittle.backrooms.objects.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.skittle.backrooms.Backrooms;
import com.skittle.backrooms.init.BlockInit;
import com.skittle.backrooms.init.ItemInit;
import com.skittle.backrooms.utils.handlers.SoundsHandler;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Wallpaper extends Block
{
	public Wallpaper(String name, Material material)
	{
		super(material);
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Backrooms.BACKROOMS_BUILDING_BLOCKS);
		
		setHardness(3.0F);
		setResistance(3.0F);
		setHarvestLevel("axe", 0);
		
		setSoundType(SoundType.WOOD);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		ItemStack itemStack = playerIn.getHeldItem(hand);
		
		if (itemStack.getItem() instanceof net.minecraft.item.ItemShears || itemStack.getItem() instanceof net.minecraft.item.ItemAxe)
		{
			if (!worldIn.isRemote)
			{
				itemStack.damageItem(1, playerIn);
				ItemStack normal_yellow = new ItemStack(ItemInit.YELLOW_WALLPAPER_PATTERN, worldIn.rand.nextInt(4) + 1);
				ItemStack dotted_yellow = new ItemStack(ItemInit.DOTTED_YELLOW_WALLPAPER_PATTERN, worldIn.rand.nextInt(4) + 1);
				ItemStack normal_white = new ItemStack(ItemInit.WHITE_WALLPAPER_PATTERN, worldIn.rand.nextInt(4) + 1);
				ItemStack dotted_white = new ItemStack(ItemInit.DOTTED_WHITE_WALLPAPER_PATTERN, worldIn.rand.nextInt(4) + 1);
				ItemStack red = new ItemStack(ItemInit.RED_WALLPAPER_PATTERN, worldIn.rand.nextInt(4) + 1);
				if (worldIn.getBlockState(pos) == BlockInit.WHITE_WALLPAPER.getDefaultState()) {
					worldIn.setBlockState(pos, getWallpaperFromList(BlockInit.TORN_WHITE_WALLPAPER_1.getDefaultState(), BlockInit.TORN_WHITE_WALLPAPER_2.getDefaultState(), BlockInit.TORN_WHITE_WALLPAPER_3.getDefaultState(), BlockInit.TORN_WHITE_WALLPAPER_4.getDefaultState()));
					spawnItemStack(worldIn, pos, normal_white);
				}
				if (worldIn.getBlockState(pos) == BlockInit.DOTTED_WHITE_WALLPAPER.getDefaultState()) {
					worldIn.setBlockState(pos, getWallpaperFromList(BlockInit.TORN_DOTTED_WHITE_WALLPAPER_1.getDefaultState(), BlockInit.TORN_DOTTED_WHITE_WALLPAPER_2.getDefaultState(), BlockInit.TORN_DOTTED_WHITE_WALLPAPER_3.getDefaultState(), BlockInit.TORN_DOTTED_WHITE_WALLPAPER_4.getDefaultState()));
					spawnItemStack(worldIn, pos, dotted_white);
				}
				if (worldIn.getBlockState(pos) == BlockInit.YELLOW_WALLPAPER.getDefaultState()) {
					worldIn.setBlockState(pos, getWallpaperFromList(BlockInit.TORN_YELLOW_WALLPAPER_1.getDefaultState(), BlockInit.TORN_YELLOW_WALLPAPER_2.getDefaultState(), BlockInit.TORN_YELLOW_WALLPAPER_3.getDefaultState(), BlockInit.TORN_YELLOW_WALLPAPER_4.getDefaultState()));
					spawnItemStack(worldIn, pos, normal_yellow);
				}
				if (worldIn.getBlockState(pos) == BlockInit.DOTTED_YELLOW_WALLPAPER.getDefaultState()) {
					worldIn.setBlockState(pos, getWallpaperFromList(BlockInit.TORN_DOTTED_YELLOW_WALLPAPER_1.getDefaultState(), BlockInit.TORN_DOTTED_YELLOW_WALLPAPER_2.getDefaultState(), BlockInit.TORN_DOTTED_YELLOW_WALLPAPER_3.getDefaultState(), BlockInit.TORN_DOTTED_YELLOW_WALLPAPER_4.getDefaultState()));
					spawnItemStack(worldIn, pos, dotted_yellow);
				}
				if (worldIn.getBlockState(pos) == BlockInit.RED_WALLPAPER.getDefaultState()) {
					worldIn.setBlockState(pos, Blocks.PLANKS.getDefaultState());
					spawnItemStack(worldIn, pos, red);
				}
				
				worldIn.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundsHandler.WALLPAPER_TEAR, SoundCategory.BLOCKS, 1.0F, 1.0F);
			}
			
			return true;
		}
		else
		{
			return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
		}
	}
	
	private IBlockState getWallpaperFromList(IBlockState... blocks) {
		List<IBlockState> list = new ArrayList<>();
		Random rand = new Random();
		
		for (IBlockState i : blocks) {
			list.add(i);
		}
		return list.get(rand.nextInt(list.size()));
	}
	
	private static void spawnItemStack(World world, BlockPos pos, ItemStack stack)
	{
		if (!world.isRemote && !stack.isEmpty())
		{
			double d0 = (double)(world.rand.nextFloat() * 0.5F) + 0.25D;
            double d1 = (double)(world.rand.nextFloat() * 0.5F) + 0.25D;
            double d2 = (double)(world.rand.nextFloat() * 0.5F) + 0.25D;
            EntityItem entityItem = new EntityItem(world, (double)pos.getX() + d0, (double)pos.getY() + d1, (double)pos.getZ() + d2, stack);
            entityItem.setDefaultPickupDelay();
            world.spawnEntity(entityItem);
		}
	}
}
