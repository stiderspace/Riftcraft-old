package com.stider.riftcraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.stider.riftcraft.Riftcraft;
import com.stider.riftcraft.lib.Strings;

public class BlockEngine extends Block {
	
public BlockEngine() {
		
		super(Material.iron);
		
		setBlockName(Strings.RIFT_ENGINE_NAME);
	    setCreativeTab(Riftcraft.tabsRFC);
	    setHardness(5F);
	    setStepSound(soundTypeAnvil);
	    this.setBlockTextureName(Strings.RESOURCE_PREFIX + Strings.RIFT_ENGINE_NAME);
		
	}

}
