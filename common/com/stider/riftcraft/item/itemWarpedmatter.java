package com.stider.riftcraft.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.stider.riftcraft.Riftcraft;
import com.stider.riftcraft.lib.Strings;

public class itemWarpedmatter extends Item {

	public itemWarpedmatter(int par1) {
		super(par1);
		
		
		maxStackSize = 1;
		setCreativeTab(Riftcraft.tabsRFC);
		setUnlocalizedName(Strings.WARPED_MATTER);
		this.setTextureName(Strings.RESOURCE_PREFIX + Strings.WARPED_MATTER);
		
		
	}

	
	 public boolean onItemUse(ItemStack ItemStack, EntityPlayer EntityPlayer, World World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	    {
		 	
		 int RandomNumber = World.rand.nextInt(20);
		 if(World.isRemote)
		 {
			 EntityPlayer.addChatMessage("Your number is: " + RandomNumber);
		 }
			return true;
		 
	    }
}
