package com.stider.riftcraft.item;

import net.minecraft.item.Item;

import com.stider.riftcraft.Riftcraft;
import com.stider.riftcraft.lib.Reference;
import com.stider.riftcraft.lib.Strings;
import com.stider.riftcraft.util.RegisterHelper;

public class ModItems {
	
	
	//Define item	
	public static Item radiationhelm;
	public static Item riftPlate;
	public static Item riftLegs;
	public static Item riftBoots;
	public static Item blackHole;
	public static Item rift;
	public static Item warpedmater;
	

	
	public static void init(){
		
		int renderArmor = Riftcraft.proxy.addArmor(Reference.MOD_ID + ":" + Strings.RIFTSUIT);
		
		radiationhelm = new ItemRadiationHelm(Material.riftArmor, renderArmor, 0);
		riftPlate = new ItemRiftPlate(Material.riftArmor, renderArmor, 1);
		riftLegs = new ItemrRiftLegs(Material.riftArmor, renderArmor, 2);
		riftBoots = new ItemRiftBoots(Material.riftArmor, renderArmor, 3);
		blackHole = new ItemblackHole();
		warpedmater = new ItemWarpedmatter();
		rift = new itemRift();
	
		registerItems();
		
	}
	
	private static void registerItems()
    {
        RegisterHelper.registerItem(blackHole);
        RegisterHelper.registerItem(riftPlate);
        RegisterHelper.registerItem(radiationhelm);
        RegisterHelper.registerItem(riftLegs);
        RegisterHelper.registerItem(riftBoots);
        RegisterHelper.registerItem(rift);
        RegisterHelper.registerItem(warpedmater);
        
    }

}
