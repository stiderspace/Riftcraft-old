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
 
    // Model textures
    public static final ResourceLocation GUI_FURNACE = ResourceLocationHelper.getResourceLocation(GUI_SHEET_LOCATION + "furnace.png");
	public static final ResourceLocation Shadow = ResourceLocationHelper.getResourceLocation(MODEL_SHEET_LOCATION + "shadow.png");;
    
}

