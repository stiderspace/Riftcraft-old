package com.stider.riftcraft.item;

import net.minecraft.item.Item;

import com.stider.riftcraft.Riftcraft;
import com.stider.riftcraft.lib.ItemIds;
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
	
	int renderArmor = Riftcraft.proxy.addArmor(Strings.RIFTSUIT);
	
	public static void init(){
		
		
		
		int renderArmor = Riftcraft.proxy.addArmor(Strings.RIFTSUIT);
		
		radiationhelm = new ItemRadiationHelm(ItemIds.RADIATION_HELM_DEFAULT, Material.riftArmor, renderArmor, 0);
		riftPlate = new ItemRiftPlate(ItemIds.RIFT_PLATE_DEFAULT, Material.riftArmor, renderArmor, 1);
		riftLegs = new ItemrRiftLegs(ItemIds.RIFT_LEGS_DEFAULT, Material.riftArmor, renderArmor, 2);
		riftBoots = new ItemRiftBoots(ItemIds.RIFT_BOOTS_DEFAULT, Material.riftArmor, renderArmor, 3);
		blackHole = new ItemblackHole(ItemIds.BLACK_HOLE_DEFAULT);
		warpedmater = new itemWarpedmatter(ItemIds.WARPED_MATTER_DEFAULT);
		rift = new itemRift(ItemIds.RIFT_DEFAULT);
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
