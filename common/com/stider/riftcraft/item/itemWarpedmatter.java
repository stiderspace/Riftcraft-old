package com.stider.riftcraft.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

import com.stider.riftcraft.Riftcraft;
import com.stider.riftcraft.lib.Strings;
import com.stider.riftcraft.util.ChatMessage;

public class ItemWarpedmatter extends Item {

	public ItemWarpedmatter() {
		super();

		maxStackSize = 16;
		setCreativeTab(Riftcraft.tabsRFC);
		setUnlocalizedName(Strings.WARPED_MATTER);
		this.setTextureName(Strings.RESOURCE_PREFIX + Strings.WARPED_MATTER);

	}

	public boolean onItemUse(ItemStack ItemStack, EntityPlayer entityPlayer,
			World World, int par4, int par5, int par6, int par7, float par8,
			float par9, float par10) {

		int RandomNumber = World.rand.nextInt(200);
		if (World.isRemote) {
			ChatMessage.sendMessage("Your number is: " + RandomNumber,
					entityPlayer);
		}
		return true;

	}
}
