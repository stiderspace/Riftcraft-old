package com.stider.riftcraft.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.stider.riftcraft.Riftcraft;
import com.stider.riftcraft.item.ModItems;
import com.stider.riftcraft.lib.Strings;

public class BlockWarpedBlock extends Block {

	public BlockWarpedBlock(int id){
		
		super(id, Material.rock);
		setUnlocalizedName(Strings.WARPEDBLOCK_NAME);
	    setCreativeTab(Riftcraft.tabsRFC);
	    setHardness(5F);
	    setStepSound(soundStoneFootstep);
	    this.setTextureName(Strings.RESOURCE_PREFIX + Strings.WARPEDBLOCK_NAME);
	    
	  
		
	}
	
	
	public int idDropped(int par1, Random par2Random, int par3)
    {
        int item = par2Random.nextInt(100);
        
        if(item <= 50 && item >= 10)
        {
        	return ModItems.warpedmater.itemID;
        }
		 
        else if(item <= 10)
        {
        	return Block.stone.blockID;
        }
        
        else if(item <= 100 && item >= 50)
        {
        	return Block.dirt.blockID;
        }
		return 0;
    	
        
    }
	
	

	
}
  
