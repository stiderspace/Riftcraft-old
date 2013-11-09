package com.stider.riftcraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.stider.riftcraft.Riftcraft;
import com.stider.riftcraft.lib.Strings;

public class BlockMinirift extends Block {
	
    public BlockMinirift(int id) {
		
		super(id, Material.iron);
		
		setUnlocalizedName(Strings.MINI_RIFT_NAME);
	    setCreativeTab(Riftcraft.tabsRFC);
	    setHardness(5F);
	    setStepSound(soundAnvilFootstep);
	    this.setTextureName(Strings.RESOURCE_PREFIX + Strings.MINI_RIFT_NAME);
		
	}
    
    
}

