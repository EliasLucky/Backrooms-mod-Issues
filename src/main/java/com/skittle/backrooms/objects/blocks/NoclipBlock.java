package com.skittle.backrooms.objects.blocks;

import com.skittle.backrooms.commands.utils.Teleport;
import com.skittle.backrooms.init.BlockInit;
import com.skittle.backrooms.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class NoclipBlock extends Block
{
	public NoclipBlock(String name, Material material, SoundType soundType, float hardness, float resistance, String harvestLevel)
	{
		super(material);
		
		setUnlocalizedName(name);
		setRegistryName(name);
		
		setHardness(hardness);
		setResistance(resistance);
		setHarvestLevel(harvestLevel, 0);
		
		setSoundType(soundType);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		if (worldIn.getBlockState(pos) == BlockInit.BOTTOM_DOTTED_YELLOW_WALLPAPER_WRONG.getDefaultState() ||
			worldIn.getBlockState(pos) == BlockInit.BOTTOM_YELLOW_WALLPAPER_WRONG.getDefaultState() ||
			worldIn.getBlockState(pos) == BlockInit.DOTTED_YELLOW_WALLPAPER_WRONG.getDefaultState() ||
			worldIn.getBlockState(pos) == BlockInit.YELLOW_WALLPAPER_WRONG.getDefaultState()) {
			if (playerIn.dimension == 1000 && !playerIn.world.isRemote) {
				Teleport.teleportToDimension(playerIn, 1001, 0.5, 62, 0.5);
				return true;
			}
		}
		return false;
	}
}
