package com.stider.riftcraft.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

public class ChatMessage {
public static void sendMessage(String message, EntityPlayer player){
	player.addChatComponentMessage(new ChatComponentText(message));
}
}
