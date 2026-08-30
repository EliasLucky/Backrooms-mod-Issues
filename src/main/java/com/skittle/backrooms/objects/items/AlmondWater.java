package com.skittle.backrooms.objects.items;

import com.skittle.backrooms.Backrooms;
import com.skittle.backrooms.init.ItemInit;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class AlmondWater extends ItemFood
{
	public AlmondWater(String name, int amount)
	{
		super(amount, false);
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Backrooms.BACKROOMS_ITEMS);
		
		setMaxStackSize(1);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.DRINK;
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
		super.onItemUseFinish(stack, worldIn, entityLiving);
		entityLiving.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 150, 5, false, false));
		return new ItemStack(Items.GLASS_BOTTLE);
	}
}
