package com.stider.riftcraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class Modelfurnace extends ModelBase
{
  //fields
	public ModelRenderer rightface;
    public ModelRenderer leftface;
    public ModelRenderer backface;
    public ModelRenderer doorLeft;
    public ModelRenderer doorRight;
    public ModelRenderer frontface;
    public ModelRenderer bottomFace;
    public ModelRenderer topFace;
  
  public Modelfurnace()
  {
    textureWidth = 128;
    textureHeight = 32;
    
      rightface = new ModelRenderer(this, 30, 0);
      rightface.addBox(0F, 0F, 0F, 1, 16, 16);
      rightface.setRotationPoint(-8F, 8F, -8F);
      rightface.setTextureSize(128, 32);
      rightface.mirror = true;
      setRotation(rightface, 0F, 0F, 0F);
      leftface = new ModelRenderer(this, 30, 0);
      leftface.addBox(0F, 0F, 0F, 1, 16, 16);
      leftface.setRotationPoint(7F, 8F, -8F);
      leftface.setTextureSize(128, 32);
      leftface.mirror = true;
      setRotation(leftface, 0F, 0F, 0F);
      backface = new ModelRenderer(this, 30, 0);
      backface.addBox(0F, 0F, 0F, 16, 16, 1);
      backface.setRotationPoint(-8F, 8F, 7F);
      backface.setTextureSize(128, 32);
      backface.mirror = true;
      setRotation(backface, 0F, 0F, 0F);
      doorLeft = new ModelRenderer(this, 0, 10);
      doorLeft.addBox(-8F, 0F, 0F, 8, 9, 1);
      doorLeft.setRotationPoint(8F, 9F, -8F);
      doorLeft.setTextureSize(128, 32);
      doorLeft.mirror = true;
      setRotation(doorLeft, 0F, 0F, 0F);
      doorRight = new ModelRenderer(this, 0, 10);
      doorRight.addBox(0F, 0F, 0F, 8, 9, 1);
      doorRight.setRotationPoint(-8F, 9F, -8F);
      doorRight.setTextureSize(128, 32);
      doorRight.mirror = true;
      setRotation(doorRight, 0F, 0F, 0F);
      frontface = new ModelRenderer(this, 30, 0);
      frontface.addBox(0F, 0F, 0F, 16, 2, 1);
      frontface.setRotationPoint(-8F, 18F, -8F);
      frontface.setTextureSize(128, 32);
      frontface.mirror = true;
      setRotation(frontface, 0F, 0F, 0F);
      bottomFace = new ModelRenderer(this, 64, 0);
      bottomFace.addBox(0F, 0F, 0F, 16, 4, 16);
      bottomFace.setRotationPoint(-8F, 20F, -8F);
      bottomFace.setTextureSize(128, 32);
      bottomFace.mirror = true;
      setRotation(bottomFace, 0F, 0F, 0F);
      topFace = new ModelRenderer(this, 64, 0);
      topFace.addBox(0F, 0F, 0F, 16, 1, 16);
      topFace.setRotationPoint(-8F, 8F, -8F);
      topFace.setTextureSize(128, 32);
      topFace.mirror = true;
      setRotation(topFace, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    rightface.render(f5);
    leftface.render(f5);
    backface.render(f5);
    doorLeft.render(f5);
    doorRight.render(f5);
    frontface.render(f5);
    bottomFace.render(f5);
    topFace.render(f5);
  }
  
  public void renderModel(float f)
  {
	  
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
