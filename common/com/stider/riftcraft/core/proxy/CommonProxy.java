package com.stider.riftcraft.core.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.stider.riftcraft.container.ContainerFurnace;
import com.stider.riftcraft.lib.GuiIds;
import com.stider.riftcraft.tile.TileEntityFurnace;

import cpw.mods.fml.common.network.IGuiHandler;


public class CommonProxy implements IGuiHandler {
	
		
	public int addArmor(String armor) {
		return 0;
		  
    }

	public void LoadRenderers() {
		
		
	}

	public void initRenderingAndTextures() {
		// TODO Auto-generated method stub
		
	}
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity entity = world.getTileEntity(x, y, z);

        if (entity != null)
        {
            switch (ID)
            {
                case GuiIds.FURNACE: return new ContainerFurnace(player.inventory, (TileEntityFurnace)entity);
                default: return null;   
            }
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        return null;
    }

	

}
