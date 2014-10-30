package com.stider.riftcraft.client.render;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.stider.riftcraft.lib.Reference;
import com.stider.riftcraft.lib.Strings;
import com.stider.riftcraft.lib.Textures;

public class RenderRift extends TileEntitySpecialRenderer {
	
	private int width = 1024;
	private int height = 1024;
	
	private float pixel = 1F/16F;
	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float f) {
		GL11.glPushMatrix();
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glPushMatrix();
				GL11.glTranslatef((float) x, (float) y, (float) z);
				
				Tessellator tesselator = Tessellator.instance;
				this.bindTexture(Textures.Rift1);
				
				tesselator.startDrawingQuads();
					tesselator.setColorRGBA_F(1, 1, 1, 1f);
				
					tesselator.addVertexWithUV(2, 3, .5, 0, 0);
					tesselator.addVertexWithUV(3, 0, .5, 0, 1);
					tesselator.addVertexWithUV(-1, 0, .5, 1, 1);
					tesselator.addVertexWithUV(0, 3, .5, 1, 0);
					
					tesselator.addVertexWithUV(-1, 0, .5, 1, 1);
					tesselator.addVertexWithUV(3, 0, .5, 0, 1);
					tesselator.addVertexWithUV(2, 3, .5, 0, 0);
					tesselator.addVertexWithUV(0, 3, .5, 1, 0);
				
				tesselator.draw();
				
			GL11.glPopMatrix();
			
			GL11.glPushMatrix();
				GL11.glTranslatef((float) x, (float) y, (float) z);
						
				this.bindTexture(Textures.Rift2);
			
				tesselator.startDrawingQuads();
					tesselator.setColorRGBA_F(10, 10, 10, 0.75f);
			
					tesselator.addVertexWithUV(2, 3, .5, 0, 0);
					tesselator.addVertexWithUV(3, 0, .5, 0, 1);
					tesselator.addVertexWithUV(-1, 0, .5, 1, 1);
					tesselator.addVertexWithUV(0, 3, .5, 1, 0);
				
					tesselator.addVertexWithUV(-1, 0, .5, 1, 1);
					tesselator.addVertexWithUV(3, 0, .5, 0, 1);
					tesselator.addVertexWithUV(2, 3, .5, 0, 0);
					tesselator.addVertexWithUV(0, 3, .5, 1, 0);
			
				tesselator.draw();
				GL11.glRotatef(20, 0, 1, 0);
				
				GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

}
