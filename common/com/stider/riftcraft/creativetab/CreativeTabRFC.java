package com.stider.riftcraft.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

import com.stider.riftcraft.block.ModBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class CreativeTabRFC extends CreativeTabs {

	public CreativeTabRFC(int Par1, String Label)
    {
        super(Label);
    }

    
    @SideOnly(Side.CLIENT)
    /**
     * the itemID for the item to be displayed on the tab
     */
    public ItemStack getIconItemStack()
    {
        return new ItemStack(ModBlocks.warpedBlock);
    }
    
   // Setting Name
    
    public String getTranslatedTabLabel()
    {
        return "Utilities Blocks";
    }
}


