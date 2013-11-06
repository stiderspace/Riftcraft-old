package com.stider.riftcraft.item;

import net.minecraft.item.Item;
import net.minecraft.src.ModLoader;

import com.stider.riftcraft.lib.ItemIds;
import com.stider.riftcraft.lib.Strings;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems {
	//Define item	
	public static Item riftPlate;
	
	
	
	public static void init(){
		riftPlate = new ItemRiftPlate(ItemIds.RIFT_PLATE_DEFAULT, Material.riftArmor, ModLoader.addArmor("rift"), 1);
		
		GameRegistry.registerItem(riftPlate, Strings.RIFT_PLATE);
		
	}
	
	
	

}
