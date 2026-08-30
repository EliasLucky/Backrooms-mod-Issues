package com.skittle.backrooms.world.dimensions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.skittle.backrooms.api.LootContainer;
import com.skittle.backrooms.api.OriginalContexts;
import com.skittle.backrooms.reference.Reference;
import com.skittle.backrooms.utils.Utils;
import com.skittle.backrooms.world.features.TemplateUnwrapper;

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
	private final ArrayList<ResourceLocation> structurePaths = new ArrayList<>();
	private final ConcurrentLinkedQueue<ChunkPos> delayedGenPositions = new ConcurrentLinkedQueue<>();
	
//	private static final HashMap<Chunk, Chunk> savedConnectedEntrances = new HashMap<Chunk, Chunk>();
//	private static final HashMap<Integer, Chunk> savedEntrances = new HashMap<Integer, Chunk>();

	
	
	private final World world;
	private final ResourceLocation contextItem;
	private final String structureLocation;
	
	private final int ceilingBarrierPosition;
	
	private final boolean ignoreEntities;
	
	public BackroomsChunkGenerator(World world, String structureLocation, ResourceLocation contextItem, boolean ignoreEntities, int ceilingBarrierPosition)
	{
		this.world = world;
		this.structureLocation = structureLocation;
		this.contextItem = contextItem;
		this.ignoreEntities = ignoreEntities;
		
		this.ceilingBarrierPosition = ceilingBarrierPosition;
	}
	
	public BackroomsChunkGenerator(World world, String structureLocation, boolean ignoreEntities, int ceilingBarrierPosition)
	{
		this.world = world;
		this.structureLocation = structureLocation;
		this.contextItem = OriginalContexts.EMPTY_FILLER;
		this.ignoreEntities = ignoreEntities;
		
		this.ceilingBarrierPosition = ceilingBarrierPosition;
	}
	
	public BackroomsChunkGenerator(World world, String structureLocation, int ceilingBarrierPosition)
	{
		this.world = world;
		this.structureLocation = structureLocation;
		this.contextItem = OriginalContexts.EMPTY_FILLER;
		this.ignoreEntities = true;
		
		this.ceilingBarrierPosition = ceilingBarrierPosition;
	}
	
	@Override
	public Chunk generateChunk(int x, int z)
	{
		ChunkPrimer chunkPrimer = new ChunkPrimer();
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				chunkPrimer.setBlockState(i, 60, j, Blocks.BEDROCK.getDefaultState());
				chunkPrimer.setBlockState(i, ceilingBarrierPosition, j, Blocks.BEDROCK.getDefaultState());
			}
		}

		ResourceLocation templatePath = this.structurePaths.get(world.rand.nextInt(this.structurePaths.size()));
		
		if (templatePath.getResourcePath().contains("")) 
		
		Chunk chunk = new Chunk(this.world, chunkPrimer, x, z);
		
//		BlockPos structurePos = new BlockPos(x * 16, 61, z * 16);
////		
//		ResourceLocation templatePath = this.structureLocations.get(world.rand.nextInt(this.structureLocations.size()));
//////		
//		Template template = world.getSaveHandler().getStructureTemplateManager().getTemplate(world.getMinecraftServer(), templatePath);
////		template.addBlocksToWorldChunk(world, structurePos, new PlacementSettings());
////		template.addBlocksToWorld(world, structurePos, new PlacementSettings(), 0);
		
		return chunk;
	}
	
	@Override
	public void populate(int x, int z)
	{
//		if (getWorld() instanceof WorldServer)
//		{
//			WorldServer worldServer = (WorldServer)getWorld();
//			HashSet<ChunkPos> toremove = new HashSet<>(this.delayedGenPositions.size());
//			for (ChunkPos delayedGenPosition : this.delayedGenPositions) {
//				generateRoomStack(worldServer, delayedGenPosition.x, delayedGenPosition.z);
//				toremove.add(delayedGenPosition);
//			}
//			this.delayedGenPositions.removeAll(toremove);
//			if (Utils.areChunksGeneratedAroundChunk(x, z, getWorld())) {
//				generateRoomStack(worldServer, x, z);
//			}
//			else {
//				this.delayedGenPositions.add(new ChunkPos(x, z));
//			}
//		}
	}
	
//	private void generateRoomStack(WorldServer worldServer, int x, int z)
//	{
//		BlockPos blockPosf = Utils.chunkPosToBlockPosition(x, z);
//		BlockPos blockPos = worldServer.getTopSolidOrLiquidBlock(blockPosf);
//		Template templ = getRandomTemplate(worldServer);
//		if (templ != null) {
//			PlacementSettings placementSettings = new PlacementSettings();
//			placementSettings.setIgnoreEntities(this.ignoreEntities);
//			
//			TemplateUnwrapper templateUnwrapper = new TemplateUnwrapper(templ);
//			List<Template.BlockInfo> blockInfos = templateUnwrapper.getBlockInfoList();
//			
//			templ.addBlocksToWorld((World)worldServer, blockPos, placementSettings);
//			
//			for (Template.BlockInfo blockInfo : blockInfos) {
//				if (blockInfo.tileentityData != null) {
//					BlockPos adjustedPosition = Template.transformedBlockPos(placementSettings, blockInfo.pos).add(blockPos);
//					TileEntity tileEntity = worldServer.getTileEntity(adjustedPosition);
//					LootContainer.generateRandomItems(tileEntity, contextItem);
//				}
//			}
//		}
//	}
//	
//	private Template getRandomTemplate(WorldServer worldServer) {
//		TemplateManager templateManager = worldServer.getStructureTemplateManager();
//		ResourceLocation templatePath = this.structureLocations.get(this.world.rand.nextInt(this.structureLocations.size()));
//		Template template = templateManager.get(worldServer.getMinecraftServer(), templatePath);
//		if (template == null) {
//			Reference.logger.error(templatePath);
//		}
//		return template;
//		
//		//worldServer.checkLightFor(EnumSkyBlock.SKY, pos);
//	}
	
	protected void addStructure(String name) {
		this.structureLocations.add(new ResourceLocation(Reference.MODID, this.structureLocation+name));
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
