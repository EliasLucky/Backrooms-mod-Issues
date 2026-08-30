package com.skittle.backrooms.utils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.function.Predicate;

import net.minecraft.entity.Entity;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

public class Utils
{
	public static float getDefaultXRightLimbRotation(float limbSwing, float swingAmount) {
		return MathHelper.cos((float)(limbSwing + Math.PI)) * swingAmount;
	}
	
	public static float getDefaultXLeftLimbRotation(float limbSwing, float swingAmount) {
		return MathHelper.cos(limbSwing) * swingAmount;
	}
	
	public static float getDefaultHeadYaw(float netYaw) {
		return netYaw * 0.017453292F;
	}
	
	public static float getDefaultHeadPitch(float pitch) {
		return pitch * 0.017453292F;
	}
	
	public static int secondsToTicks(int seconds) {
		return seconds * 20;
	}
	
	public static void playSound(World world, BlockPos blockPos, SoundEvent sound, float volume, float pitch) {
		if (world != null) {
			world.playSound(blockPos.getX(), blockPos.getY(), blockPos.getZ(), sound, null, volume, pitch, false);
		}
	}
	
	public static void sendToPlayersAround(IMessage message, World world, BlockPos blockPos, int range, SimpleNetworkWrapper networkWrapper) {
		networkWrapper.sendToAllAround(message, new NetworkRegistry.TargetPoint(world.provider.getDimension(), blockPos.getX(), blockPos.getY(), blockPos.getZ(), range));
	}
	
	public static <T extends Entity> List<T> getEntitiesInside(World world, Class<T> cls, AxisAlignedBB axisAligned, Predicate<T> condition)
	{
		List<T> entities = world.getEntitiesWithinAABB(cls, axisAligned);
		if (condition != null) {
			entities.removeIf(condition.negate());
		}
		return entities;
	}
	
	public static Field getSecureField(Class owner, int number)
	{
		Field[] fields = owner.getDeclaredFields();
		if (number < fields.length) {
			Field f = fields[number];
			if (f.getType() != owner.getEnclosingClass()) {
				f.setAccessible(true);
				return f;
			}
			return getSecureField(owner.getSuperclass(), number);
		}
		return null;
	}
	
	public static Field getSecureField(Class owningClass, String field)
	{
		Field f = null;
		try
		{
			f = owningClass.getDeclaredField(field);
			f.setAccessible(true);
		}
		catch (NoSuchFieldException e)
		{
			if (owningClass.getSuperclass() != null) {
				return getSecureField(owningClass.getSuperclass(), field);
			}
			System.err.println("Searcher all super classes - field " + field + " not found");
		}
		return f;
	}
	
	public static BlockPos chunkPosToBlockPosition(int chunkX, int chunkZ) {
		int x = (chunkX << 4) + 8;
		int z = (chunkZ << 4) + 8;
		return new BlockPos(x, 63, z);
		//return new BlockPos(chunkX << 4, 61, chunkZ << 4);
	}
	
	public static boolean areChunksGeneratedAroundChunk(int cx, int cz, World world) {
		return (world.isChunkGeneratedAt(cx + 1, cz) &&
				world.isChunkGeneratedAt(cx - 1, cz) &&
				world.isChunkGeneratedAt(cx, cz + 1) &&
				world.isChunkGeneratedAt(cx, cz - 1));
	}
	
	public static boolean areChunksGeneratedAroundChunk(ChunkPos chunkPos, World world) {
		return areChunksGeneratedAroundChunk(chunkPos.x, chunkPos.z, world);
	}
}
