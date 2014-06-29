package com.stider.riftcraft.client.render;

import net.minecraft.client.model.ModelPig;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.stider.riftcraft.lib.Textures;

public class RenderShadow extends RenderLiving {
	

	public RenderShadow(ModelPig modelpig, float par2)
    {
        super(modelpig, par2);
    }


	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		// TODO Auto-generated method stub
		return Textures.Shadow;
	}

}
