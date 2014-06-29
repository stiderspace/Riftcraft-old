package com.stider.riftcraft.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
<<<<<<< HEAD
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
=======
>>>>>>> origin/master

import com.stider.riftcraft.Riftcraft;
import com.stider.riftcraft.item.ModItems;
import com.stider.riftcraft.lib.Strings;

public class BlockWarpedBlock extends Block {

	public BlockWarpedBlock(int id){
		
<<<<<<< HEAD
		super(Material.rock);
		setBlockName(Strings.WARPEDBLOCK_NAME);
=======
		super(id, Material.rock);
		setUnlocalizedName(Strings.WARPEDBLOCK_NAME);
>>>>>>> origin/master
	    setCreativeTab(Riftcraft.tabsRFC);
	    setHardness(5F);
	    setStepSound(Block.soundTypeAnvil);
	    this.setBlockTextureName(Strings.RESOURCE_PREFIX + Strings.WARPEDBLOCK_NAME);
	    
	  
		
	}
	
	
	public Item idDropped(int par1, Random par2Random, int par3)
    {
        int item = par2Random.nextInt(100);
        
        if(item <= 50 && item >= 10)
        {
        	return ModItems.warpedmater;
        }
		 
        else if(item <= 10)
        {
        	return Item.getItemFromBlock(Blocks.cobblestone);
        }
        
        else if(item <= 100 && item >= 50)
        {
        	return Item.getItemFromBlock(Blocks.cobblestone);
        }
		return null;
    	
        
    }
	
	

	
}
  
