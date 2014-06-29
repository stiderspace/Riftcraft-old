package com.stider.riftcraft.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;

import com.stider.riftcraft.Riftcraft;
import com.stider.riftcraft.lib.Strings;

public class itemRift extends Item {

	public itemRift(int id) {
	
		maxStackSize = 1;
		setCreativeTab(Riftcraft.tabsRFC);
		setUnlocalizedName(Strings.RIFT_NAME);
		this.setTextureName(Strings.RESOURCE_PREFIX + Strings.BLACK_HOLE);
		
		
		
	}
	public ItemStack onItemRightClick(ItemStack ItemStack, World World, EntityPlayer EntityPlayer)
	  {
	    NBTTagCompound tag = EntityPlayer.getEntityData();
	    if (EntityPlayer.dimension == 1) {
	      return ItemStack;
	    }
	    if ((EntityPlayer instanceof EntityPlayerMP))
	    {
	      EntityPlayerMP var4 = (EntityPlayerMP)EntityPlayer;
	      if (!World.isRemote)
	      {
	        tag.setFloat("prevX", var4.getPlayerCoordinates().posX);
	        tag.setFloat("prevY", var4.getPlayerCoordinates().posY);
	        tag.setFloat("prevZ", var4.getPlayerCoordinates().posZ);
	        tag.setInteger("prevDim", var4.dimension);
	        if (EntityPlayer.dimension == 1) {
	          return ItemStack;
	        }
	        if ((EntityPlayer.dimension != 0) && (EntityPlayer.dimension != 1)) {
	          var4.travelToDimension(0);
	        }
	        ChunkCoordinates chunkCoordinates = EntityPlayer.getBedLocation();
	        if (chunkCoordinates == null)
	        {
	          int var5 = World.getWorldInfo().getSpawnX();
	          int var6 = World.getWorldInfo().getSpawnY();
	          int var7 = World.getWorldInfo().getSpawnZ();
	          ChunkCoordinates var9 = new ChunkCoordinates(var5, var6, var7);
	          EntityPlayerMP.verifyRespawnCoordinates(EntityPlayer.worldObj, var9, true);
	          var4.setPositionAndUpdate(var5, var6 + 3, var7);
	        }
	        else
	        {
	          ChunkCoordinates var9 = EntityPlayerMP.verifyRespawnCoordinates(EntityPlayer.worldObj, chunkCoordinates, true);
	          int var10 = var9.posX;
	          int var11 = var9.posY;
	          int var12 = var9.posZ;
	          var4.setPositionAndUpdate(var10 + 0.5, var11, var12 + 0.5);
	        }
	      }
	    }
	    --ItemStack.stackSize;
	    return ItemStack;
	    
	  }
	
	
}


