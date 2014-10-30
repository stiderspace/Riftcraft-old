package com.stider.riftcraft.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.stider.riftcraft.Riftcraft;
import com.stider.riftcraft.lib.Reference;
import com.stider.riftcraft.lib.RenderIds;
import com.stider.riftcraft.lib.Strings;
import com.stider.riftcraft.tile.TileEntityBlackhole;

public class BlockMiniblackhole extends BlockContainer {


    public BlockMiniblackhole() {
		
		super(Material.iron);
		setBlockName(Strings.MINI_BLACKHOLE_NAME);
	    setCreativeTab(Riftcraft.tabsRFC);
	    setHardness(5F);
	    //setStepSound(soundAnvilFootstep);
	    this.setBlockTextureName(Strings.RESOURCE_PREFIX + Strings.MINI_BLACKHOLE_NAME);
		
	}
    
    private IIcon[] IconBuffer = new IIcon[2];
    
    @Override
    public void registerBlockIcons(IIconRegister p_149651_1_) {
    	   IconBuffer[0] = p_149651_1_.registerIcon(Reference.MOD_ID + ":" + "blackhole side");
           IconBuffer[1] = p_149651_1_.registerIcon(Reference.MOD_ID + ":" + "blackhole");
    }
    
    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    
    @Override
    public int getRenderType() {

        return RenderIds.blackholeRender;
    }
    
    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }


	@Override
	public TileEntity createNewTileEntity(World world, int var1) {
		// TODO Auto-generated method stub
		return new TileEntityBlackhole();
	}
    
	

}


