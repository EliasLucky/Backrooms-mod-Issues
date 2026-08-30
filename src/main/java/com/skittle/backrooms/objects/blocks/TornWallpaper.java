package com.skittle.backrooms.objects.blocks;

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
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TornWallpaper extends Block
{
	public TornWallpaper(String name, Material material)
	{
		super(material);
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Backrooms.BACKROOMS_BUILDING_BLOCKS);
		
		setHardness(2.0F);
		setResistance(2.0F);
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
				if (worldIn.getBlockState(pos) == BlockInit.TORN_YELLOW_WALLPAPER_1.getDefaultState()) {
					worldIn.setBlockState(pos, BlockInit.TORN_YELLOW_WALLPAPER_2.getDefaultState());
					tearWallpaper(worldIn, 3, pos, ItemInit.YELLOW_WALLPAPER_PATTERN);
				}
				else if (worldIn.getBlockState(pos) == BlockInit.TORN_YELLOW_WALLPAPER_2.getDefaultState()) {
					worldIn.setBlockState(pos, BlockInit.TORN_YELLOW_WALLPAPER_3.getDefaultState());
					tearWallpaper(worldIn, 2, pos, ItemInit.YELLOW_WALLPAPER_PATTERN);
				}
				else if (worldIn.getBlockState(pos) == BlockInit.TORN_YELLOW_WALLPAPER_3.getDefaultState()) {
					worldIn.setBlockState(pos, BlockInit.TORN_YELLOW_WALLPAPER_4.getDefaultState());
					tearWallpaper(worldIn, 1, pos, ItemInit.YELLOW_WALLPAPER_PATTERN);
				}
				
				if (worldIn.getBlockState(pos) == BlockInit.TORN_DOTTED_YELLOW_WALLPAPER_1.getDefaultState()) {
					worldIn.setBlockState(pos, BlockInit.TORN_DOTTED_YELLOW_WALLPAPER_2.getDefaultState());
					tearWallpaper(worldIn, 3, pos, ItemInit.DOTTED_YELLOW_WALLPAPER_PATTERN);
				}
				else if (worldIn.getBlockState(pos) == BlockInit.TORN_DOTTED_YELLOW_WALLPAPER_2.getDefaultState()) {
					worldIn.setBlockState(pos, BlockInit.TORN_DOTTED_YELLOW_WALLPAPER_3.getDefaultState());
					tearWallpaper(worldIn, 2, pos, ItemInit.DOTTED_YELLOW_WALLPAPER_PATTERN);
				}
				else if (worldIn.getBlockState(pos) == BlockInit.TORN_DOTTED_YELLOW_WALLPAPER_3.getDefaultState()) {
					worldIn.setBlockState(pos, BlockInit.TORN_DOTTED_YELLOW_WALLPAPER_4.getDefaultState());
					tearWallpaper(worldIn, 1, pos, ItemInit.DOTTED_YELLOW_WALLPAPER_PATTERN);
				}
				
				if (worldIn.getBlockState(pos) == BlockInit.TORN_WHITE_WALLPAPER_1.getDefaultState()) {
					worldIn.setBlockState(pos, BlockInit.TORN_WHITE_WALLPAPER_2.getDefaultState());
					tearWallpaper(worldIn, 3, pos, ItemInit.WHITE_WALLPAPER_PATTERN);
				}
				else if (worldIn.getBlockState(pos) == BlockInit.TORN_WHITE_WALLPAPER_2.getDefaultState()) {
					worldIn.setBlockState(pos, BlockInit.TORN_WHITE_WALLPAPER_3.getDefaultState());
					tearWallpaper(worldIn, 2, pos, ItemInit.WHITE_WALLPAPER_PATTERN);
				}
				else if (worldIn.getBlockState(pos) == BlockInit.TORN_WHITE_WALLPAPER_3.getDefaultState()) {
					worldIn.setBlockState(pos, BlockInit.TORN_WHITE_WALLPAPER_4.getDefaultState());
					tearWallpaper(worldIn, 1, pos, ItemInit.WHITE_WALLPAPER_PATTERN);
				}
				
				if (worldIn.getBlockState(pos) == BlockInit.TORN_DOTTED_WHITE_WALLPAPER_1.getDefaultState()) {
					worldIn.setBlockState(pos, BlockInit.TORN_DOTTED_WHITE_WALLPAPER_2.getDefaultState());
					tearWallpaper(worldIn, 3, pos, ItemInit.DOTTED_WHITE_WALLPAPER_PATTERN);
				}
				else if (worldIn.getBlockState(pos) == BlockInit.TORN_DOTTED_WHITE_WALLPAPER_2.getDefaultState()) {
					worldIn.setBlockState(pos, BlockInit.TORN_DOTTED_WHITE_WALLPAPER_3.getDefaultState());
					tearWallpaper(worldIn, 2, pos, ItemInit.DOTTED_WHITE_WALLPAPER_PATTERN);
				}
				else if (worldIn.getBlockState(pos) == BlockInit.TORN_DOTTED_WHITE_WALLPAPER_3.getDefaultState()) {
					worldIn.setBlockState(pos, BlockInit.TORN_DOTTED_WHITE_WALLPAPER_4.getDefaultState());
					tearWallpaper(worldIn, 1, pos, ItemInit.DOTTED_WHITE_WALLPAPER_PATTERN);
				}
			}
			return true;
		}
		else if (itemStack.getItem() instanceof com.skittle.backrooms.objects.items.WallpaperPattern)
		{
			if (!worldIn.isRemote)
			{
				if (itemStack.getItem() == ItemInit.YELLOW_WALLPAPER_PATTERN)
				{
					if (worldIn.getBlockState(pos) == BlockInit.TORN_YELLOW_WALLPAPER_4.getDefaultState()) {
						worldIn.setBlockState(pos, BlockInit.TORN_YELLOW_WALLPAPER_3.getDefaultState());
						decrease(playerIn, itemStack, 1);
					}
					else if (worldIn.getBlockState(pos) == BlockInit.TORN_YELLOW_WALLPAPER_3.getDefaultState()) {
						worldIn.setBlockState(pos, BlockInit.TORN_YELLOW_WALLPAPER_2.getDefaultState());
						decrease(playerIn, itemStack, 1);
					}
					else if (worldIn.getBlockState(pos) == BlockInit.TORN_YELLOW_WALLPAPER_2.getDefaultState()) {
						worldIn.setBlockState(pos, BlockInit.TORN_YELLOW_WALLPAPER_1.getDefaultState());
						decrease(playerIn, itemStack, 1);
					}
					else if (worldIn.getBlockState(pos) == BlockInit.TORN_YELLOW_WALLPAPER_1.getDefaultState()) {
						worldIn.setBlockState(pos, BlockInit.YELLOW_WALLPAPER.getDefaultState());
						decrease(playerIn, itemStack, 1);
					}
				}
				
				if (itemStack.getItem() == ItemInit.DOTTED_YELLOW_WALLPAPER_PATTERN)
				{
					if (worldIn.getBlockState(pos) == BlockInit.TORN_DOTTED_YELLOW_WALLPAPER_4.getDefaultState()) {
						worldIn.setBlockState(pos, BlockInit.TORN_DOTTED_YELLOW_WALLPAPER_3.getDefaultState());
						decrease(playerIn, itemStack, 1);
					}
					else if (worldIn.getBlockState(pos) == BlockInit.TORN_DOTTED_YELLOW_WALLPAPER_3.getDefaultState()) {
						worldIn.setBlockState(pos, BlockInit.TORN_DOTTED_YELLOW_WALLPAPER_2.getDefaultState());
						decrease(playerIn, itemStack, 1);
					}
					else if (worldIn.getBlockState(pos) == BlockInit.TORN_DOTTED_YELLOW_WALLPAPER_2.getDefaultState()) {
						worldIn.setBlockState(pos, BlockInit.TORN_DOTTED_YELLOW_WALLPAPER_1.getDefaultState());
						decrease(playerIn, itemStack, 1);
					}
					else if (worldIn.getBlockState(pos) == BlockInit.TORN_DOTTED_YELLOW_WALLPAPER_1.getDefaultState()) {
						worldIn.setBlockState(pos, BlockInit.DOTTED_YELLOW_WALLPAPER.getDefaultState());
						decrease(playerIn, itemStack, 1);
					}
				}
				
				if (itemStack.getItem() == ItemInit.WHITE_WALLPAPER_PATTERN)
				{
					if (worldIn.getBlockState(pos) == BlockInit.TORN_WHITE_WALLPAPER_4.getDefaultState()) {
						worldIn.setBlockState(pos, BlockInit.TORN_WHITE_WALLPAPER_3.getDefaultState());
						decrease(playerIn, itemStack, 1);
					}
					else if (worldIn.getBlockState(pos) == BlockInit.TORN_WHITE_WALLPAPER_3.getDefaultState()) {
						worldIn.setBlockState(pos, BlockInit.TORN_WHITE_WALLPAPER_2.getDefaultState());
						decrease(playerIn, itemStack, 1);
					}
					else if (worldIn.getBlockState(pos) == BlockInit.TORN_WHITE_WALLPAPER_2.getDefaultState()) {
						worldIn.setBlockState(pos, BlockInit.TORN_WHITE_WALLPAPER_1.getDefaultState());
						decrease(playerIn, itemStack, 1);
					}
					else if (worldIn.getBlockState(pos) == BlockInit.TORN_WHITE_WALLPAPER_1.getDefaultState()) {
						worldIn.setBlockState(pos, BlockInit.WHITE_WALLPAPER.getDefaultState());
						decrease(playerIn, itemStack, 1);
					}
				}
				
				if (itemStack.getItem() == ItemInit.DOTTED_WHITE_WALLPAPER_PATTERN)
				{
					if (worldIn.getBlockState(pos) == BlockInit.TORN_DOTTED_WHITE_WALLPAPER_4.getDefaultState()) {
						worldIn.setBlockState(pos, BlockInit.TORN_DOTTED_WHITE_WALLPAPER_3.getDefaultState());
						decrease(playerIn, itemStack, 1);
					}
					else if (worldIn.getBlockState(pos) == BlockInit.TORN_DOTTED_WHITE_WALLPAPER_3.getDefaultState()) {
						worldIn.setBlockState(pos, BlockInit.TORN_DOTTED_WHITE_WALLPAPER_2.getDefaultState());
						decrease(playerIn, itemStack, 1);
					}
					else if (worldIn.getBlockState(pos) == BlockInit.TORN_DOTTED_WHITE_WALLPAPER_2.getDefaultState()) {
						worldIn.setBlockState(pos, BlockInit.TORN_DOTTED_WHITE_WALLPAPER_1.getDefaultState());
						decrease(playerIn, itemStack, 1);
					}
					else if (worldIn.getBlockState(pos) == BlockInit.TORN_DOTTED_WHITE_WALLPAPER_1.getDefaultState()) {
						worldIn.setBlockState(pos, BlockInit.DOTTED_WHITE_WALLPAPER.getDefaultState());
						decrease(playerIn, itemStack, 1);
					}
				}
			}
			
			return true;
		}
		else
		{
			return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
		}
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(Blocks.PLANKS);
	}
	
	@Override
	protected boolean canSilkHarvest() {
		return true;
	}
	
	private void decrease(EntityPlayer player, ItemStack stack, int amount) {
		if (!player.isCreative()) {
			stack.shrink(amount);
		}
	}
	
	private static void tearWallpaper(World world, int level, BlockPos pos, Item item)
	{
		ItemStack itemStack = new ItemStack(item, level);
		spawnItemStack(world, pos, itemStack);
		world.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundsHandler.WALLPAPER_TEAR, SoundCategory.BLOCKS, 1.0F, 1.0F);
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
