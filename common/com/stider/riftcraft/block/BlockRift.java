package com.stider.riftcraft.block;

import java.util.List;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.stider.riftcraft.Riftcraft;
import com.stider.riftcraft.tile.TileBlockRift;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockRift extends BlockContainer {

	protected BlockRift() {
		super(Material.portal);
		this.setCreativeTab(Riftcraft.tabsRFC);
		this.setBlockName("BlockRift");
		this.setLightLevel(50.0F);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileBlockRift();
	}

	@SideOnly(Side.CLIENT)
	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public int getRenderBlockPass() {
		return -1;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {

		if (entity.ridingEntity == null && entity.riddenByEntity == null && !world.isRemote) {
			entity.travelToDimension(1);
		}
	}

	public void setBlockBoundsBasedOnState(IBlockAccess Access, int par2, int par3, int par4) {
		float f = 0.0625f;
		this.setBlockBounds(-1.0F, 0.0F, 0.0F, 2.0F, 3.0f, 1.0F);
	}

	public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB aabb, List list, Entity entity) {
       

        this.setBlockBounds(-1.0F, 0.0F, 0.0F, 2.0F, 3.0f, 1.0F);
    }
	

}
