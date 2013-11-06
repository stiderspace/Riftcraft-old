package com.stider.riftcraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import com.stider.riftcraft.lib.Strings;

public class BlockWarpedBlock extends Block {

	public BlockWarpedBlock(int id){
		
		super(id, Material.rock);
		setUnlocalizedName(Strings.WARPEDBLOCK_NAME);
	    setCreativeTab(CreativeTabs.tabBlock);
	    setHardness(5F);
	    setStepSound(soundStoneFootstep);    
		
	}

}
