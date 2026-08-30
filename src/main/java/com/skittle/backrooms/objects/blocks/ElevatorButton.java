package com.skittle.backrooms.objects.blocks;

import com.skittle.backrooms.Backrooms;
import com.skittle.backrooms.commands.utils.Teleport;
import com.skittle.backrooms.init.BlockInit;
import com.skittle.backrooms.init.ItemInit;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ElevatorButton extends DirectionalHorizontalWallBlock
{
	private static final AxisAlignedBB BOX_NORTH = new AxisAlignedBB(0.25D, 0.125D, 0.875D, 0.75D, 0.875D, 1.0D);
	private static final AxisAlignedBB BOX_SOUTH = new AxisAlignedBB(0.25D, 0.125D, 0.0D, 0.75D, 0.875D, 0.125D);
	private static final AxisAlignedBB BOX_WEST = new AxisAlignedBB(0.875D, 0.125D, 0.25D, 1.0D, 0.875D, 0.75D);
	private static final AxisAlignedBB BOX_EAST = new AxisAlignedBB(0.0D, 0.125D, 0.25D, 0.125D, 0.875D, 0.75D);
	
	private final int toDimension;
	private final int fromDimension;
	
	private final float posX;
	private float posY;
	private final float posZ;
	
	private final boolean canBeReturned;

	public ElevatorButton(String name, Material material, SoundType soundType, float hardness, float resistance, String harvestLevel, int fromDimension, int toDimension, float posX, float posY, float posZ, boolean canBeReturned)
	{
		super(material);
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Backrooms.BACKROOMS_BUILDING_BLOCKS);
		
		setHardness(hardness);
		setResistance(resistance);
		setHarvestLevel(harvestLevel, 0);
		
		this.toDimension = toDimension;
		this.fromDimension = fromDimension;
		
		this.posX = posX;
		this.posY = posY;
		this.posZ = posZ;
		
		this.canBeReturned = canBeReturned;
		
		setSoundType(soundType);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		boolean cooldown = false;
		
		if (worldIn.isRemote)
		{
			return true;
		}
		
		if (playerIn.dimension == this.fromDimension && !cooldown) {
			cooldown = true;
			teleportProcedure(playerIn, this.toDimension);
		}
			
		if (this.canBeReturned) {
			if (playerIn.dimension == this.toDimension && !cooldown) {
				cooldown = true;
				teleportProcedure(playerIn, this.fromDimension);
			}
		}
			
		return true;
	}
	
	private void teleportProcedure(EntityPlayer player, int dimension)
	{
		if (dimension == 1005) {
			this.posY = 68.0F;
		}
		
		Teleport.teleportToDimension(player, dimension, this.posX, this.posY, this.posZ);
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
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
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}
}
