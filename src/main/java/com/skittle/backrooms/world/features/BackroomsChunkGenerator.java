package com.skittle.backrooms.world.features;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.skittle.backrooms.api.LootContainer;
import com.skittle.backrooms.api.OriginalContexts;
import com.skittle.backrooms.reference.Reference;
import com.skittle.backrooms.utils.Utils;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;

public abstract class BackroomsChunkGenerator implements IChunkGenerator
{
	private ArrayList<ResourceLocation> structureLocations = new ArrayList<>();
	private final ConcurrentLinkedQueue<ChunkPos> delayedGenPositions = new ConcurrentLinkedQueue<>();
	
	public void addStructure(String name) {
		this.structureLocations.add(new ResourceLocation(Reference.MODID, getStructureLocationForLevel()+name));
	}
	
	public String getStructureLocationForLevel() {
		return "";
	}
	
	public World getWorld() {
		return getWorld();
	}
	
	public boolean ignoreEntities() {
		return true;
	}
	
	public ResourceLocation getContextItem() {
		return OriginalContexts.EMPTY_FILLER;
	}
	
	@Override
	public Chunk generateChunk(int x, int z)
	{
		ChunkPrimer chunkPrimer = new ChunkPrimer();
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				chunkPrimer.setBlockState(i, 60, j, Blocks.BEDROCK.getDefaultState());
			}
		}
		
		Chunk chunk = new Chunk(getWorld(), chunkPrimer, x, z);
		
		return chunk;
	}
	
	@Override
	public void populate(int x, int z)
	{
		if (getWorld() instanceof WorldServer)
		{
			WorldServer worldServer = (WorldServer)getWorld();
			HashSet<ChunkPos> toremove = new HashSet<>(this.delayedGenPositions.size());
			for (ChunkPos delayedGenPosition : this.delayedGenPositions) {
				generateRoomStack(worldServer, delayedGenPosition.x, delayedGenPosition.z);
				toremove.add(delayedGenPosition);
			}
			this.delayedGenPositions.removeAll(toremove);
			if (Utils.areChunksGeneratedAroundChunk(x, z, getWorld())) {
				generateRoomStack(worldServer, x, z);
			}
			else {
				this.delayedGenPositions.add(new ChunkPos(x, z));
			}
		}
	}
	
	private void generateRoomStack(WorldServer worldServer, int x, int z)
	{
		BlockPos blockPosf = Utils.chunkPosToBlockPosition(x, z);
		BlockPos blockPos = worldServer.getTopSolidOrLiquidBlock(blockPosf);
		Template templ = getRandomTemplate(worldServer);
		if (templ != null) {
			PlacementSettings placementSettings = new PlacementSettings();
			placementSettings.setIgnoreEntities(ignoreEntities());
			
			TemplateUnwrapper templateUnwrapper = new TemplateUnwrapper(templ);
			List<Template.BlockInfo> blockInfos = templateUnwrapper.getBlockInfoList();
			
			templ.addBlocksToWorld((World)worldServer, blockPos, placementSettings);
			
			for (Template.BlockInfo blockInfo : blockInfos) {
				if (blockInfo.tileentityData != null) {
					BlockPos adjustedPosition = Template.transformedBlockPos(placementSettings, blockInfo.pos).add(blockPos);
					TileEntity tileEntity = worldServer.getTileEntity(adjustedPosition);
					LootContainer.generateRandomItems(tileEntity, getContextItem());
				}
			}
		}
	}
	
	private Template getRandomTemplate(WorldServer worldServer) {
		TemplateManager templateManager = worldServer.getStructureTemplateManager();
		ResourceLocation templatePath = this.structureLocations.get(getWorld().rand.nextInt(this.structureLocations.size()));
		Template template = templateManager.get(worldServer.getMinecraftServer(), templatePath);
		if (template == null) {
			Reference.logger.error(templatePath);
		}
		return template;
		
		//worldServer.checkLightFor(EnumSkyBlock.SKY, pos);
	}
	
	@Override
	public boolean generateStructures(Chunk chunkIn, int x, int z) {
		return false;
	}
	
	@Override
	public List<SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) {
		return Collections.emptyList();
	}
	
	@Override
	public BlockPos getNearestStructurePos(World worldIn, String structureName, BlockPos position, boolean findUnexplored) {
		return null;
	}
	
	@Override
	public void recreateStructures(Chunk chunkIn, int x, int z) {}
	
	@Override
	public boolean isInsideStructure(World worldIn, String structureName, BlockPos pos) {
		return false;
	}
}
