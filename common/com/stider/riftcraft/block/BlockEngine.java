package com.stider.riftcraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.stider.riftcraft.Riftcraft;
import com.stider.riftcraft.lib.Strings;

public class BlockEngine extends Block {
	
public BlockEngine(int id) {
		
		super(id, Material.iron);
		
		setUnlocalizedName(Strings.RIFT_ENGINE_NAME);
	    setCreativeTab(Riftcraft.tabsRFC);
	    setHardness(5F);
	    setStepSound(soundAnvilFootstep);
	    this.setTextureName(Strings.RESOURCE_PREFIX + Strings.RIFT_ENGINE_NAME);
		
	}

}
