package com.stider.riftcraft.util;

import java.lang.reflect.Field;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

import com.stider.riftcraft.block.ModBlocks;
import com.stider.riftcraft.item.ModItems;
import com.stider.riftcraft.lib.Reference;

import cpw.mods.fml.common.registry.GameRegistry;

public class RegisterHelper {
	
    public static void registerBlock(Block block) {
        GameRegistry.registerBlock(block, Reference.MOD_ID + "_" + block.getUnlocalizedName().substring(5));
    }
    
    public static void registerItem(Item item) {
        GameRegistry.registerItem(item, Reference.MOD_ID + "_" + item.getUnlocalizedName().substring(5));
    }
    
    /**
	 * Registers A Block With FML
	 * 
	 * @param Class
	 * @param Field
	 * @param Block
	 *            Class
	 */
    public static void registerBlock(Field field,
			Class<? extends Block> blocky) {
		Block block = null;
		try {
			block = blocky.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		GameRegistry.registerBlock(block,
				block.getUnlocalizedName().substring(5));
		try {
			field.set(ModBlocks.class, block);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Registers A Item With FML
	 * 
	 * @param Class
	 * @param Field
	 * @param Block
	 *            Class
	 */
	public static void registerItem(Field field,
			Class<? extends Item> itemy) {
		Item item = null;
		try {
			item = itemy.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
		try {
			field.set(ModItems.class, item);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}