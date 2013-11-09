package com.stider.riftcraft.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import com.stider.riftcraft.item.ModItems;
import com.stider.riftcraft.lib.Strings;

public class BlockWarpedBlock extends Block {

	public BlockWarpedBlock(int id){
		
		super(id, Material.rock);
		setUnlocalizedName(Strings.WARPEDBLOCK_NAME);
	    setCreativeTab(CreativeTabs.tabBlock);
	    setHardness(5F);
	    setStepSound(soundStoneFootstep);
	    this.setTextureName(Strings.RESOURCE_PREFIX + Strings.WARPEDBLOCK_NAME);
	    
	  
		
	}
	
	
	public int idDropped(int par1, Random par2Random, int par3)
    {
        int item = par2Random.nextInt(3);
        
        if(item+10 <= 50)
        {
        	return ModItems.warpedmater.itemID;
        }
		 
        else if(item <= 10)
        {
        	return Block.stone.blockID;
        }
        
        else if(item+50 <= 100)
        {
        	return Block.dirt.blockID;
        }
		return 0;
    	
        
    }
	

	
}
  
