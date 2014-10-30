package com.stider.riftcraft.util;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Conf {
	
	public static boolean isModActive;
	
	public static void loadConfiguration(FMLPreInitializationEvent event) {
		Configuration conf = new Configuration(
				event.getSuggestedConfigurationFile());
		conf.load();
		
		isModActive = conf.get(Configuration.CATEGORY_GENERAL, "isModActive", true, "If This Is True, This Mod Is Active").getBoolean(true);
		
		if (conf.hasChanged()) {
			conf.save();
		}
	}
}
