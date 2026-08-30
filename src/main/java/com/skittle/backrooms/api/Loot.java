package com.skittle.backrooms.api;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.apache.commons.lang3.RandomUtils;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

public class Loot
{
	protected ItemStack loot;
	protected int chance;
	
	protected int minCount;
	protected int maxCount;
	
	protected int meta;
	
	protected Predicate<ResourceLocation> context;
	protected Predicate<TileEntity> tileEntityPredicate;
	protected Consumer<ItemStack> itemOperations;
	
	public Loot(Item loot, int chance, int minCount, int maxCount, Predicate<ResourceLocation> context, Predicate<TileEntity> containerPredicate)
	{
		this(loot, chance, minCount, maxCount, 0, context, containerPredicate, null);
	}
	
	public Loot(Item loot, int chance, int minCount, int maxCount, Predicate<ResourceLocation> context)
	{
		this(loot, chance, minCount, maxCount, 0, context, null, null);
	}
	
	public Loot(Block loot, int chance, int minCount, int maxCount, int meta, Predicate<ResourceLocation> context, Predicate<TileEntity> containerPredicate)
	{
		this(Item.getItemFromBlock(loot), chance, minCount, maxCount, meta, context, containerPredicate, null);
	}
	
	public Loot(Item loot, int chance, int minCount, int maxCount, int meta, Predicate<ResourceLocation> context, Predicate<TileEntity> containerPredicate, Consumer<ItemStack> itemOperations)
	{
		assert loot != null : "Item is null";
		this.loot = new ItemStack(loot, 1, meta);
		this.chance = MathHelper.clamp(chance, 1, 100);
		this.minCount = MathHelper.clamp(minCount, 1, 64);
		this.maxCount = MathHelper.clamp(maxCount, 1, 64);
		this.meta = MathHelper.clamp(meta, 0, 15);
		this.context = context;
		this.tileEntityPredicate = containerPredicate;
		this.itemOperations = itemOperations;
	}
	
	public Loot(Item item, Consumer<ItemStack> operation, int chance, int minCount, int maxCount, Predicate<ResourceLocation> context)
	{
		this(item, chance, minCount, maxCount, 0, context, null, operation);
	}
	
	public Loot(Item loot, int chance, int minCount, int maxCount, int meta, Predicate<ResourceLocation> context)
	{
		this(loot, chance, minCount, maxCount, context);
	}
	
	public Loot(Block block, int chance, int minCount, int maxCount, Predicate<ResourceLocation> context, Predicate<TileEntity> containerPredicate)
	{
		this(Item.getItemFromBlock(block), chance, minCount, maxCount, context, containerPredicate);
	}
	
	public Loot(ItemStack stack, int chance, int minCount, int maxCount, Predicate<ResourceLocation> context)
	{
		this(stack.getItem(), chance, minCount, maxCount, context);
	}
	
	public ItemStack roll(ResourceLocation context, TileEntity target)
	{
		Random rand = new Random();
		boolean success = (this.context.test(context) && (this.tileEntityPredicate == null || this.tileEntityPredicate.test(target)) && this.chance > rand.nextInt(100));
		if (success)
		{
			ItemStack stack = new ItemStack(this.loot.getItem(), 1, this.loot.getItemDamage());
			int count = RandomUtils.nextInt(this.minCount, this.maxCount);
			count = MathHelper.clamp(count, 1, stack.getMaxStackSize());
			stack.setCount(count);
			stack.setTagCompound(this.loot.getTagCompound());
		
			if (this.itemOperations != null) {
				this.itemOperations.accept(stack);
			}
			return stack;
		}
		return null;
	}
}
