package com.stider.riftcraft.client.render.tileentity;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import com.stider.riftcraft.client.model.ModelBlackhole;
import com.stider.riftcraft.tile.TileEntityBlackhole;

public class TileRenderBlackhole extends TileEntitySpecialRenderer
{
    private ModelBlackhole Model = new ModelBlackhole();
    
    @Override
    public void renderTileEntityAt(TileEntity TileEntity, double Par1, double Par2, double Par3, float Tick)
    {
        Model.Render((TileEntityBlackhole)TileEntity, Par1, Par2, Par3);
    }
}
