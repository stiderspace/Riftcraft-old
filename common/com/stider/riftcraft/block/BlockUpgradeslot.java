package com.stider.riftcraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.stider.riftcraft.Riftcraft;
import com.stider.riftcraft.lib.Strings;

public class BlockUpgradeslot extends Block {

	
	public BlockUpgradeslot(int id) {
		
		super(Material.iron);
		
		setBlockName(Strings.UPGRADE_SLOT_NAME);
	    setCreativeTab(Riftcraft.tabsRFC);
	    setHardness(5F);
	    setStepSound(Block.soundTypeAnvil);
	    this.setBlockTextureName(Strings.RESOURCE_PREFIX + Strings.UPGRADE_SLOT_NAME);
		
	}

}
