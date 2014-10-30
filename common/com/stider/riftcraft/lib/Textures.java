package com.stider.riftcraft.lib;

import com.stider.riftcraft.core.helper.ResourceLocationHelper;

import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;

public class Textures {
	
	 // Base file paths
    public static final String MODEL_SHEET_LOCATION = "textures/models/";
    public static final String ARMOR_SHEET_LOCATION = "textures/armor/";
    public static final String GUI_SHEET_LOCATION = "textures/gui/";
    public static final String EFFECTS_LOCATION = "textures/effects/";

    // Item/Block sprite sheets
    public static final ResourceLocation VANILLA_BLOCK_TEXTURE_SHEET = TextureMap.locationBlocksTexture;
    public static final ResourceLocation VANILLA_ITEM_TEXTURE_SHEET = TextureMap.locationItemsTexture;
    
    
    // Model textures
    public static final ResourceLocation MODEL_BLACKHOLE = ResourceLocationHelper.getResourceLocation(MODEL_SHEET_LOCATION + "blackhole.png");
    public static final ResourceLocation MODEL_FURNACE = ResourceLocationHelper.getResourceLocation(MODEL_SHEET_LOCATION + "furnace.png");
 
    // GUI textures
    public static final ResourceLocation GUI_FURNACE = ResourceLocationHelper.getResourceLocation(GUI_SHEET_LOCATION + "furnace.png");
   
    //entity texture
	public static final ResourceLocation Shadow = ResourceLocationHelper.getResourceLocation(MODEL_SHEET_LOCATION + "shadow.png");
	
	//Tesselator textures
	public static final ResourceLocation Rift = ResourceLocationHelper.getResourceLocation(MODEL_SHEET_LOCATION + "Rift.png");
	public static final ResourceLocation Rift1 = ResourceLocationHelper.getResourceLocation(MODEL_SHEET_LOCATION + "Rift1.png");
	public static final ResourceLocation Rift2 = ResourceLocationHelper.getResourceLocation(MODEL_SHEET_LOCATION + "Rift2.png");
	public static final ResourceLocation Rift3 = ResourceLocationHelper.getResourceLocation(MODEL_SHEET_LOCATION + "Rift3.png");
	public static final ResourceLocation Rift4 = ResourceLocationHelper.getResourceLocation(MODEL_SHEET_LOCATION + "Rift4.png");
	public static final ResourceLocation Rift5 = ResourceLocationHelper.getResourceLocation(MODEL_SHEET_LOCATION + "Rift5.png");
	public static final ResourceLocation Rift6 = ResourceLocationHelper.getResourceLocation(MODEL_SHEET_LOCATION + "Rift6.png");
	public static final ResourceLocation Rift7 = ResourceLocationHelper.getResourceLocation(MODEL_SHEET_LOCATION + "Rift7.png");
	public static final ResourceLocation Rift8 = ResourceLocationHelper.getResourceLocation(MODEL_SHEET_LOCATION + "Rift8.png");
    
	//armor
	public static final ResourceLocation RIFT_SUIT1 = ResourceLocationHelper.getResourceLocation(ARMOR_SHEET_LOCATION + "riftplate_layer_1.png");
	public static final ResourceLocation RIFT_SUIT2 = ResourceLocationHelper.getResourceLocation(ARMOR_SHEET_LOCATION + "riftplate_layer_2.png");
}

