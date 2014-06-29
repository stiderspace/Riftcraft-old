package com.stider.riftcraft.client.Gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;

import com.stider.riftcraft.container.ContainerFurnace;
import com.stider.riftcraft.lib.Textures;
import com.stider.riftcraft.tile.TileEntityFurnace;

public class GuiFurnace extends GuiContainer
{
    public TileEntityFurnace furnace;

    public GuiFurnace(InventoryPlayer inventoryPlayer, TileEntityFurnace entity)
    {
        super(new ContainerFurnace(inventoryPlayer, entity));
        this.furnace = entity;

        this.xSize = 176;
        this.ySize = 166;

    }
    
    public boolean doesGuiPauseGame()
    {
        return false;
    }

    public void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        String name = this.furnace.isInvNameLocalized() ? this.furnace.getInvName() : I18n.getString(this.furnace.getInvName());
        
        this.fontRenderer.drawString(name, this.xSize/2 - this.fontRenderer.getStringWidth(name)/2, 6, 4210752);
        this.fontRenderer.drawString(I18n.getString("container.inventory"), 8, this.ySize -94, 4210752);

    }

    @Override
    public void drawGuiContainerBackgroundLayer(float f, int i, int j)
    {
        GL11.glColor4f(1F, 1F, 1F, 1F);
        
        Minecraft.getMinecraft().getTextureManager().bindTexture(Textures.GUI_FURNACE);
        
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
        
        if(this.furnace.isBurning())
        {
            int k = this.furnace.getItemBurnTimeRemainingScaled(12);
            drawTexturedModalRect(guiLeft + 56, guiTop + 36 + 12 - k, 176, 12 - k, 14, k + 2);
        }
        int k = this.furnace.getCookProgressScaled(24);
        drawTexturedModalRect(guiLeft + 79, guiTop + 34, 176, 14, k + 1, 16);

    }

}
