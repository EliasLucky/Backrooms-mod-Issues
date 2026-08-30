package com.skittle.backrooms.world.features;

import java.util.ArrayList;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

public class LightUpdateCheck
{
	private World world;
	private World worldServer;
	
	private ArrayList<BlockPos> serverProcesses = new ArrayList<>();
	public ArrayList<BlockPos> clientProcesses = new ArrayList<>();
	
	public LightUpdateCheck(World world, World worldServer) {
		this.world = world;
		this.worldServer = worldServer;
	}
	
	public void addClientProcess(BlockPos pos) {
		this.clientProcesses.add(pos);
	}
	
	public void addServerProcess(BlockPos pos) {
		this.serverProcesses.add(pos);
	}
	
	public void runClient()
	{
		for (int i = this.clientProcesses.size() - 1; i >= 0; i--)
		{
			if (this.clientProcesses.get(i) != null)
			{
				this.world.checkLightFor(EnumSkyBlock.SKY, this.clientProcesses.get(i));
			}
			this.clientProcesses.remove(i);
		}
	}
	
	public void runServer()
	{
		for (int i = this.serverProcesses.size() - 1; i >= 0; i--)
		{
			if (this.serverProcesses.get(i) != null)
			{
				this.worldServer.checkLightFor(EnumSkyBlock.SKY, this.serverProcesses.get(i));
			}
			this.serverProcesses.remove(i);
		}
	}
}
