package com.stider.riftcraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.stider.riftcraft.Riftcraft;
import com.stider.riftcraft.lib.Strings;

public class BlockStabilizer extends Block {

	public BlockStabilizer(int id) {
		
		super(Material.iron);
		
		setBlockName(Strings.STABILIZER_NAME);
	    setCreativeTab(Riftcraft.tabsRFC);
	    setHardness(5F);
	    setStepSound(Block.soundTypeAnvil);
	    this.setBlockTextureName(Strings.RESOURCE_PREFIX + Strings.STABILIZER_NAME);
		
	
		
	}

}
