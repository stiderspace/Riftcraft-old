package com.stider.riftcraft.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.stider.riftcraft.Riftcraft;
import com.stider.riftcraft.lib.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemRadiationHelm extends ItemArmor {

public ItemRadiationHelm(int id , ArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
		
		super(par2EnumArmorMaterial, par3, par4);
		this.setCreativeTab(Riftcraft.tabsRFC);
		this.setUnlocalizedName(Strings.RADIATION_HELMET);
		//this.setTextureName(Strings.RESOURCE_PREFIX + Strings.RIFT_PLATE);
		


	}
		
	
	
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1RegisterIcon) {
		this.itemIcon = par1RegisterIcon.registerIcon(Strings.RESOURCE_PREFIX + Strings.RADIATION_HELMET);
	
	}
	@SideOnly(Side.CLIENT)
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer) {
		return Strings.RESOURCE_PREFIX + Strings.RIFTSUIT_LOACTION_1;
	}
	
		
}
 