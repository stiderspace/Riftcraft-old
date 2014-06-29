package com.stider.riftcraft;

import net.minecraft.creativetab.CreativeTabs;

import com.stider.riftcraft.block.ModBlocks;
import com.stider.riftcraft.core.proxy.CommonProxy;
import com.stider.riftcraft.creativetab.CreativeTabRFC;
import com.stider.riftcraft.entity.ModEntity;
import com.stider.riftcraft.item.ModItems;
import com.stider.riftcraft.lib.Reference;
import com.stider.riftcraft.tile.ModTileEntity;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;


@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION_NUMBER)

public class Riftcraft {
	
	@Instance(Reference.MOD_ID)
	public static Riftcraft instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static CreativeTabs tabsRFC = new CreativeTabRFC(CreativeTabs.getNextID(), Reference.MOD_ID);

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
      
    	ModBlocks.init();
    	ModEntity.init();
    	
    	ModItems.init();
    	ModTileEntity.init();
    	

    }
    	

    @EventHandler
    public void load(FMLInitializationEvent event) {
    	
    	proxy.LoadRenderers();
    	
    	proxy.initRenderingAndTextures();
    	
    	NetworkRegistry.INSTANCE.registerGuiHandler(this, proxy);
       
    	
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        
    }
}
