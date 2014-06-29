package com.stider.riftcraft.block;

import net.minecraft.block.Block;
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

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMiniblackhole extends BlockContainer {


    public BlockMiniblackhole(int id) {
		
		super(Material.iron);
		
		setBlockName(Strings.MINI_BLACKHOLE_NAME);
	    setCreativeTab(Riftcraft.tabsRFC);
	    setHardness(5F);
	    setStepSound(Block.soundTypeAnvil);
	    this.setBlockTextureName(Strings.RESOURCE_PREFIX + Strings.MINI_BLACKHOLE_NAME);
		
	}
    
    private IIcon[] IconBuffer = new IIcon[2];
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister IconRegister)
    {
        IconBuffer[0] = IconRegister.registerIcon(Reference.MOD_ID + ":" + "blackhole side");
        IconBuffer[1] = IconRegister.registerIcon(Reference.MOD_ID + ":" + "blackhole");
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
	public TileEntity createNewTileEntity(World var1, int var2) {

		return new TileEntityBlackhole();
	}
    

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

}


