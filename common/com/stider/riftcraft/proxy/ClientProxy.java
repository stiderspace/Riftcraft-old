package com.stider.riftcraft.proxy;

import cpw.mods.fml.client.registry.RenderingRegistry;


public class ClientProxy extends CommonProxy {
	
	@Override
	public void registerRenderThings(){
		
	}
	
	@Override
	 public int addArmor(String armor){
	  return RenderingRegistry.addNewArmourRendererPrefix(armor);
	 }

}
