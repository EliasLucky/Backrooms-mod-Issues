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
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class BackroomsDoorBlock extends Block
{
	public BackroomsDoorBlock(String name, Material material, SoundType soundType, float hardness, float resistance, int lightValue)
	{
		super(material);
		
		setUnlocalizedName(name);
		setRegistryName(name);
		
		setHardness(hardness);
		setResistance(resistance);
		
		this.lightValue = lightValue;
		
		setSoundType(soundType);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		if (worldIn.getBlockState(pos) == BlockInit.WHITE_WOODEN_DOOR_BLOCK_BOTTOM.getDefaultState() ||
			worldIn.getBlockState(pos) == BlockInit.WHITE_WOODEN_DOOR_BLOCK_TOP.getDefaultState()) {
			if (playerIn.dimension == 1000 && !playerIn.world.isRemote) {
				Teleport.teleportToDimension(playerIn, -1000, 0.5, 62, 0.5);
				return true;
			}
			if (playerIn.dimension == -1000 && !playerIn.world.isRemote) {
				Teleport.teleportToDimension(playerIn, 1000, 0.5, 62, 0.5);
				return true;
			}
		}
		if (worldIn.getBlockState(pos) == BlockInit.METAL_DOOR_BLOCK_BOTTOM.getDefaultState() ||
			worldIn.getBlockState(pos) == BlockInit.METAL_DOOR_BLOCK_TOP.getDefaultState()) {
			if (playerIn.dimension == 1001 && !playerIn.world.isRemote) {
				Teleport.teleportToDimension(playerIn, 1002, 0.5, 62, 27.5);
				return true;
			}
		}
		if (worldIn.getBlockState(pos) == BlockInit.METAL_MAINTENANCE_DOOR_BLOCK_BOTTOM.getDefaultState() ||
			worldIn.getBlockState(pos) == BlockInit.METAL_MAINTENANCE_DOOR_BLOCK_TOP.getDefaultState()) {
			if (playerIn.dimension == 1000 && !playerIn.world.isRemote) {
				Teleport.teleportToDimension(playerIn, 1001, 5, 62, 5);
				return true;
			}
			if (playerIn.dimension == 1002 && !playerIn.world.isRemote) {
				Teleport.teleportToDimension(playerIn, 1001, 5, 62, 5);
				return true;
			}
		}
		if (worldIn.getBlockState(pos) == BlockInit.METAL_BLACK_DOOR_BLOCK_BOTTOM.getDefaultState() ||
			worldIn.getBlockState(pos) == BlockInit.METAL_BLACK_DOOR_BLOCK_TOP.getDefaultState()) {
			if (playerIn.dimension == 1002 && !playerIn.world.isRemote) {
				Teleport.teleportToDimension(playerIn, 1003, 0.5, 62, 0.5);
				return true;
			}
		}
		if (worldIn.getBlockState(pos) == BlockInit.RUSTY_METAL_DOOR_BLOCK_BOTTOM.getDefaultState() ||
			worldIn.getBlockState(pos) == BlockInit.RUSTY_METAL_DOOR_BLOCK_TOP.getDefaultState()) {
			if (playerIn.dimension == 1005 && !playerIn.world.isRemote) {
				Teleport.teleportToDimension(playerIn, 1006, 0.5, 62, 0.5);
				return true;
			}
		}
		if (worldIn.getBlockState(pos) == BlockInit.OFFICE_WOODEN_DOOR_BLOCK_BOTTOM.getDefaultState() ||
			worldIn.getBlockState(pos) == BlockInit.OFFICE_WOODEN_DOOR_BLOCK_TOP.getDefaultState()) {
			if (playerIn.dimension == 1002 && !playerIn.world.isRemote) {
				Teleport.teleportToDimension(playerIn, 1004, 0.5, 62, 0.5);
				return true;
			}
			if (playerIn.dimension == 1005 && !playerIn.world.isRemote) {
				Teleport.teleportToDimension(playerIn, 1004, 0.5, 62, 0.5);
				return true;
			}
		}
		if (worldIn.getBlockState(pos) == BlockInit.DARK_WOODEN_DOOR_BLOCK_BOTTOM.getDefaultState() ||
			worldIn.getBlockState(pos) == BlockInit.DARK_WOODEN_DOOR_BLOCK_TOP.getDefaultState()) {
			if (playerIn.dimension == 1004 && !playerIn.world.isRemote) {
				Teleport.teleportToDimension(playerIn, 1005, 0.5, 68, 0.5);
				return true;
			}
		}
		
		if (worldIn.getBlockState(pos) == BlockInit.WHITE_METAL_DOOR_BLOCK_BOTTOM.getDefaultState() ||
			worldIn.getBlockState(pos) == BlockInit.WHITE_METAL_DOOR_BLOCK_TOP.getDefaultState()) {
			if (playerIn.dimension == 1006 && !playerIn.world.isRemote) {
				MinecraftServer server = playerIn.getEntityWorld().getMinecraftServer();
				WorldServer worldServer = server.getWorld(0);
				
				BlockPos blockPos = worldServer.getSpawnPoint();
				BlockPos spawnPos = worldServer.getTopSolidOrLiquidBlock(blockPos);
				Teleport.teleportToDimension(playerIn, 0, spawnPos.getX(), spawnPos.getY(), spawnPos.getZ());
				
				return true;
			}
		}
		return false;
	}
}
