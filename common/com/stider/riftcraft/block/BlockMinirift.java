package com.stider.riftcraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.stider.riftcraft.Riftcraft;
import com.stider.riftcraft.lib.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMinirift extends Block {
	
    public BlockMinirift(int id) {
		
		super(Material.iron);
		
		setBlockName(Strings.MINI_RIFT_NAME);
	    setCreativeTab(Riftcraft.tabsRFC);
	    setHardness(5F);
	    setStepSound(Block.soundTypeAnvil);
	    this.setBlockTextureName(Strings.RESOURCE_PREFIX + Strings.MINI_RIFT_NAME);
		
	}
    
    
    @SideOnly(Side.CLIENT)
    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }
	
    @Override
    public int getRenderBlockPass()
    {
        return 0;
    }
    
    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    
}

