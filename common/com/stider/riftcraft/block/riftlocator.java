package com.stider.riftcraft.block;

import com.stider.riftcraft.Riftcraft;
import com.stider.riftcraft.lib.Strings;
import com.stider.riftcraft.tile.TileEntityBlackhole;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class riftlocator extends BlockContainer {

	protected riftlocator() {
		super(Material.iron);
		setCreativeTab(Riftcraft.tabsRFC);
		setHardness(5F);
		this.setBlockTextureName(Strings.RESOURCE_PREFIX + Strings.MINI_BLACKHOLE_NAME);
	
	}

	@Override
	public TileEntity createNewTileEntity(World world, int var1) {
		
		return new TileEntityBlackhole();
	}

}
