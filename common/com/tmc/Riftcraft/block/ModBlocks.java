package com.tmc.Riftcraft.block;

import net.minecraft.block.Block;

import com.tmc.Riftcraft.lib.BlockIds;
import com.tmc.Riftcraft.lib.Strings;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	public static Block warpedBlock;
	
	public static void Init() {
		warpedBlock = new BlockWarpedBlock(BlockIds.WARPEDBLOCK);
		
		
		GameRegistry.registerBlock(warpedBlock, Strings.WARPEDBLOCK_NAME);
		
	}

}
