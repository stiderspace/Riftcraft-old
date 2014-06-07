package com.stider.riftcraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import com.stider.riftcraft.lib.Models;
import com.stider.riftcraft.lib.Textures;
import com.stider.riftcraft.tile.TileEntityBlackhole;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelBlackhole extends ModelBase
{
    // Declaration
    
    private IModelCustom Blackhole;
    
    
    // Constructor
    
    public ModelBlackhole()
    {
    	Blackhole = AdvancedModelLoader.loadModel(Models.BLACKHOLE);
    }
    
    
    // Main Render Method
    
    public void Render()
    {
    	Blackhole.renderAll();
    }

    
    // Secondary Render Method
    
    public void Render(TileEntityBlackhole tileEntity, double Var1, double Var2, double Var3)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)Var1 + 0.5f, (float)Var2 + 0f, (float)Var3 + 0.5f);
        GL11.glRotatef(270F, 0F, 1F, 0F);
        GL11.glScalef(0.5f, 0.5f, 0.5f);
     
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(Textures.MODEL_BLACKHOLE);
     
        Render();
     
        GL11.glPopMatrix();
    } 
}