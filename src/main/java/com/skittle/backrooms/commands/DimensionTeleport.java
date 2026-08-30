package com.skittle.backrooms.commands;

import java.util.List;

import com.google.common.collect.Lists;
import com.skittle.backrooms.commands.utils.Teleport;
import com.skittle.backrooms.reference.Reference;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;

public class DimensionTeleport extends CommandBase
{
	private final List<String> aliases = Lists.newArrayList(Reference.MODID, "tp", "tplvl", "tplevel", "teleportlevel");

	@Override
	public String getName() {
		return "tplevel";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "/tplevel <player> <level>";
	}
	
	@Override
	public List<String> getAliases() {
		return aliases;
	}
	
	@Override
	public int getRequiredPermissionLevel() {
		return 2;
	}
	
	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
		return true;
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
	{
		if (args.length < 2) {
			throw new WrongUsageException(getUsage(sender), new Object[0]);
		}
		
		EntityPlayer entityplayer = getPlayer(server, sender, args[0]);
		
		if (entityplayer instanceof EntityPlayer) {
			if ("0".equals(args[1])) {
				Teleport.teleportToDimension((EntityPlayer)entityplayer, 1000, 0.5, 62, 0.5);
			}
			else if ("0.2".equals(args[1])) {
				Teleport.teleportToDimension((EntityPlayer)entityplayer, -1000, 0.5, 62, 0.5);
			}
			else if ("1".equals(args[1])) {
				Teleport.teleportToDimension((EntityPlayer)entityplayer, 1001, 0.5, 62, 0.5);
			}
			else if ("2".equals(args[1])) {
				Teleport.teleportToDimension((EntityPlayer)entityplayer, 1002, 0.5, 62, 27.5);
			}
			else if ("3".equals(args[1])) {
				Teleport.teleportToDimension((EntityPlayer)entityplayer, 1003, 0.5, 62, 0.5);
			}
			else if ("4".equals(args[1])) {
				Teleport.teleportToDimension((EntityPlayer)entityplayer, 1004, 0.5, 62, 0.5);
			}
			else if ("5".equals(args[1])) {
				Teleport.teleportToDimension((EntityPlayer)entityplayer, 1005, 0.5, 68, 0.5);
			}
			else if ("6".equals(args[1])) {
				Teleport.teleportToDimension((EntityPlayer)entityplayer, 1006, 0.5, 62, 0.5);
			}
		}
	}
	
	@Override
	public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos targetPos)
	{
		if (args.length == 1) {
			return getListOfStringsMatchingLastWord(args, server.getOnlinePlayerNames());
		}
		return super.getTabCompletions(server, sender, args, targetPos);
	}
}
