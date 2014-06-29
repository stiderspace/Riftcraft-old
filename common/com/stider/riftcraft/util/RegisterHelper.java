package com.stider.riftcraft.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

import com.stider.riftcraft.lib.Reference;

import cpw.mods.fml.common.registry.GameRegistry;

public class RegisterHelper {
	
	public static void registerItem(Item item)
    {
        GameRegistry.registerItem(item, Reference.MOD_ID + "_" + item.getUnlocalizedName().substring(5));
    }
	
	public static void registerBlock(Block block)
    {
        GameRegistry.registerBlock(block, Reference.MOD_ID + "_" + block.getUnlocalizedName().substring(5));
    }

}
