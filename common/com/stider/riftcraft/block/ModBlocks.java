package com.stider.riftcraft.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import com.stider.riftcraft.lib.BlockIds;
import com.stider.riftcraft.lib.Strings;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	public static Block warpedBlock;
	
	public static void init(){
		
		 
		 warpedBlock = new BlockWarpedBlock(BlockIds.WARPEDBLOCK_DEFAULT);
		
		GameRegistry.registerBlock(warpedBlock, Strings.WARPEDBLOCK_NAME);
	    
		
		initBlockRecipes();
	    }

	    private static void initBlockRecipes() {

	        GameRegistry.addRecipe(new ItemStack(warpedBlock), new Object[] { "iii", "iii", "iii", Character.valueOf('i'), Block.glass });
	       
	    }
}
