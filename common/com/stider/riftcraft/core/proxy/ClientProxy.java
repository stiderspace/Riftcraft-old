package com.stider.riftcraft.core.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;

import com.stider.riftcraft.block.ModBlocks;
import com.stider.riftcraft.client.Gui.GuiFurnace;
import com.stider.riftcraft.client.render.RenderBlackhole;
import com.stider.riftcraft.client.render.RenderFurnace;
import com.stider.riftcraft.client.render.tileentity.TileRenderBlackhole;
import com.stider.riftcraft.lib.GuiIds;
import com.stider.riftcraft.lib.RenderIds;
import com.stider.riftcraft.tile.TileEntityBlackhole;
import com.stider.riftcraft.tile.TileEntityFurnace;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class ClientProxy extends CommonProxy {
	
    @SideOnly(Side.CLIENT)
    @Override
    public void initRenderingAndTextures() {

        RenderIds.blackholeRender = RenderingRegistry.getNextAvailableRenderId();
        RenderIds.furnace = RenderingRegistry.getNextAvailableRenderId();
        
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.miniblackhole), new RenderBlackhole());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.furnace), new RenderFurnace());
    
    }
    
    @Override
	public void LoadRenderers()
	{
     super.LoadRenderers();

     ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBlackhole.class, new TileRenderBlackhole());
     ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFurnace.class, new RenderFurnace());
		  
	 
    }
   
	
	@Override
	 public int addArmor(String armor){
	  return RenderingRegistry.addNewArmourRendererPrefix(armor);
	 }
	
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity entity = world.getTileEntity(x, y, z);

        if (entity != null)
        {
            switch (ID)
            {
                
                case GuiIds.FURNACE: return new GuiFurnace(player.inventory, (TileEntityFurnace)entity);
                default: return null; 
                
            }
        }
        return null;
    }
}
