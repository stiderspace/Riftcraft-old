package com.stider.riftcraft.client.render;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.opengl.GL11;

import com.stider.riftcraft.client.model.Modelfurnace;
import com.stider.riftcraft.lib.Textures;
import com.stider.riftcraft.tile.TileEntityFurnace;

import cpw.mods.fml.client.FMLClientHandler;

public class RenderFurnace extends TileEntitySpecialRenderer implements IItemRenderer
{

    private Modelfurnace Model;

    public RenderFurnace()
    {
        this.Model = new Modelfurnace();
    }

    @Override
    public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f)
    {
        TileEntityFurnace tileEntityFurnace = (TileEntityFurnace) tileentity;
        ForgeDirection direction = null;

        if (tileEntityFurnace.getWorldObj() != null) {
            direction = ForgeDirection.getOrientation(tileEntityFurnace.getBlockMetadata());
        }

        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        short angle = 0;

        if (direction != null) {
            if (direction == ForgeDirection.SOUTH) {
                angle = 180;
            }
            else if (direction == ForgeDirection.NORTH) {
                angle = 0;
            }
            else if (direction == ForgeDirection.WEST) {
                angle = 90;
            }
            else if (direction == ForgeDirection.EAST) {
                angle = -90;
            }
        }
        GL11.glRotatef(angle, 0F, 1F, 0F);
        GL11.glRotatef(180, 0F, 0F, 1F);
        this.bindTexture(Textures.MODEL_FURNACE);
        GL11.glPushMatrix();
        this.Model.render(null, 0, 0, 0, 0, 0, 0.0625F);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type)
    {

        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
    {

        return true;
    }

    @Override
    public void renderItem(ItemRenderType ItemRenderType, ItemStack ItemStack, Object... data)
    {
        switch (ItemRenderType)
        {
            case ENTITY:
            {
                Render(0f, 0f, 0f, 0.5f, ItemRenderType);
                return;
            }
            case EQUIPPED:
            {
                Render(0.5F, 0F, .5F, 0.5F, ItemRenderType);
                return;
            }
            case EQUIPPED_FIRST_PERSON:
            {
                Render(0.5F, -0.5F, 0.5F, 0.5F, ItemRenderType);
                return;
            }
            case INVENTORY:
            {
                Render(0f, -1f, 0f, 0.5f, ItemRenderType);
                return;
            }
            default:
                return;
        }

    }

    private void Render(float Var1, float Var2, float Var3, float Scale, ItemRenderType ItemRenderType)
    {
        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);

        GL11.glTranslatef(Var1, Var2, Var3);
        GL11.glScalef(Scale, Scale, Scale);
        GL11.glRotatef(0F, 0F, 0F, 0F);

        if (ItemRenderType == ItemRenderType.EQUIPPED_FIRST_PERSON)
        {
            GL11.glRotatef(-90F, 0F, 1F, 0F);
        }

        if (ItemRenderType == ItemRenderType.EQUIPPED)
        {
            GL11.glRotatef(180F, 0F, 1F, 0F);
        }

        FMLClientHandler.instance().getClient().renderEngine.bindTexture(Textures.MODEL_FURNACE);

        Model.render(null, 0.125F, 0, 0, 0, 0, 0.125F);

        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
    }
}
