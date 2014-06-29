package com.stider.riftcraft.tile;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
<<<<<<< HEAD
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
=======
>>>>>>> origin/master
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
<<<<<<< HEAD
import net.minecraftforge.common.util.ForgeDirection;
=======
import net.minecraftforge.common.ForgeDirection;
>>>>>>> origin/master

import com.stider.riftcraft.block.Blockfurnace;

import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntityFurnace extends TileEntity implements ISidedInventory
{
    protected ForgeDirection orientation;
    private String LocalizedName;
    private ItemStack[] slots = new ItemStack[3];

    private static final int[] slots_top = new int[] { 0 };
    private static final int[] slots_bottom = new int[] { 2, 1 };
    private static final int[] slots_sides = new int[] { 1 };

    public int FurnaceSpeed = 100;
    public int burnTime;
    public int currentItemBurnTime;
    public int cookTime;

    @Override
    public int getSizeInventory()
    {
        return slots.length;
    }

<<<<<<< HEAD
=======
    @Override
>>>>>>> origin/master
    public String getInvName()
    {
        return this.isInvNameLocalized() ? LocalizedName : "container.furnace";

    }

    public TileEntityFurnace()
    {

        orientation = ForgeDirection.SOUTH;

    }

    public void setGUIDisplayName(String displayName)
    {
        LocalizedName = displayName;

    }

    public ForgeDirection getOrientation()
    {

        return orientation;
    }

    public void setOrientation(ForgeDirection orientation)
    {

        this.orientation = orientation;
    }

    public void setOrientation(int orientation)
    {

        this.orientation = ForgeDirection.getOrientation(orientation);
    }

<<<<<<< HEAD
=======
    @Override
>>>>>>> origin/master
    public boolean isInvNameLocalized()
    {
        return LocalizedName != null && LocalizedName.length() > 0;
    }

    @Override
    public ItemStack getStackInSlot(int i)
    {
        return this.slots[i];
    }

    @Override
    public ItemStack decrStackSize(int i, int j)
    {
        if (this.slots[i] != null)
        {
            ItemStack itemstack;
            if (this.slots[i].stackSize <= j)
            {
                itemstack = this.slots[i];
                this.slots[i] = null;
                return itemstack;
            }
            else
            {
                itemstack = this.slots[i].splitStack(j);
                if (this.slots[i].stackSize == 0)
                {
                    this.slots[i] = null;
                }
                return itemstack;

            }
        }
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int i)
    {
        if (this.slots[i] != null)
        {
            ItemStack itemstack = this.slots[i];
            return itemstack;
        }
        return null;
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack itemstack)
    {
        this.slots[i] = itemstack;
        if (itemstack != null && itemstack.stackSize > this.getInventoryStackLimit())
        {
            itemstack.stackSize = this.getInventoryStackLimit();
        }

    }

    @Override
    public int getInventoryStackLimit()
    {

        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityplayer)
    {
<<<<<<< HEAD
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : entityplayer.getDistanceSq((double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D, (double) this.zCoord + 0.5D) <= 64.0D;
=======
        return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : entityplayer.getDistanceSq((double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D, (double) this.zCoord + 0.5D) <= 64.0D;
>>>>>>> origin/master
    }

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemstack)
    {

        return i == 2 ? false : i == 1 ? isItemFuel(itemstack) : true;
    }

    public static boolean isItemFuel(ItemStack itemstack)
    {
        return getItemBurnTime(itemstack) > 0;
    }

    @Override
    public void updateEntity()
    {
        boolean flag1 = this.burnTime > 0;
        boolean flag2 = false;
        

        if (this.burnTime > 0)
        {
            this.burnTime--;
        }
        if (!worldObj.isRemote)
        {
            if (this.burnTime == 0 && this.canSmelt())
            {
                currentItemBurnTime = this.burnTime = getItemBurnTime(slots[1]);

                if (this.burnTime > 0)
                {
                    flag2 = true;
                    if (this.slots[1] != null)
                    {
                        this.slots[1].stackSize--;

                        if (this.slots[1].stackSize == 0)
                        {
<<<<<<< HEAD
                            this.slots[1] = this.slots[1].getItem().getContainerItem(slots[1]);
=======
                            this.slots[1] = this.slots[1].getItem().getContainerItemStack(slots[1]);
>>>>>>> origin/master

                        }
                    }
                }
            }
            if (this.isBurning() && this.canSmelt())
            {
                this.cookTime++;
                if (this.cookTime == this.FurnaceSpeed)
                {
                    this.cookTime = 0;
                    this.smeltItem();
                    flag2 = true;

                }
            }
            else
                this.cookTime = 0;

            if (flag1 != this.burnTime > 0)
            {
                flag2 = true;
                Blockfurnace.updateFurnaceBlockState(this.burnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }
        }
        if (flag2)
        {
<<<<<<< HEAD
            this.markDirty();
=======
            this.onInventoryChanged();
>>>>>>> origin/master
        }

    }

    private void smeltItem()
    {
        if (this.canSmelt())
        {
            ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.slots[0]);
            if (this.slots[2] == null)
            {
                this.slots[2] = itemstack.copy();
            } else if (this.slots[2].isItemEqual(itemstack))
            {
                this.slots[2].stackSize += itemstack.stackSize;
            }
            this.slots[0].stackSize--;

            if (this.slots[0].stackSize <= 0)
            {
                this.slots[0] = null;
            }
        }

    }

    private boolean canSmelt()
    {
        if (this.slots[0] == null)
        {
            return false;
        }
        else
        {
            ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.slots[0]);
            if (itemstack == null)
                return false;
            if (this.slots[2] == null)
                return true;
            if (!this.slots[2].isItemEqual(itemstack))
                return false;
            int result = slots[2].stackSize + itemstack.stackSize;
            return (result <= getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
        }
    }

    public boolean isBurning()
    {

        return this.burnTime > 0;
    }

<<<<<<< HEAD
    public static int getItemBurnTime(ItemStack p_145952_0_)
    {
        if (p_145952_0_ == null)
        {
            return 0;
        }
        else
        {
            Item item = p_145952_0_.getItem();

            if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air)
            {
                Block block = Block.getBlockFromItem(item);

                if (block == Blocks.wooden_slab)
                {
                    return 150;
                }

                if (block.getMaterial() == Material.wood)
                {
                    return 300;
                }

                if (block == Blocks.coal_block)
                {
                    return 16000;
                }
            }

            if (item instanceof ItemTool && ((ItemTool)item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemSword && ((ItemSword)item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemHoe && ((ItemHoe)item).getToolMaterialName().equals("WOOD")) return 200;
            if (item == Items.stick) return 100;
            if (item == Items.coal) return 1600;
            if (item == Items.lava_bucket) return 20000;
            if (item == Item.getItemFromBlock(Blocks.sapling)) return 100;
            if (item == Items.blaze_rod) return 2400;
            return GameRegistry.getFuelValue(p_145952_0_);
        }
    }
    
=======
    public static int getItemBurnTime(ItemStack par0ItemStack)
    {
        if (par0ItemStack == null)
            return 0;
        else
        {
            int i = par0ItemStack.getItem().itemID;
            Item item = par0ItemStack.getItem();

            if (par0ItemStack.getItem() instanceof ItemBlock && Block.blocksList[i] != null)
            {
                Block block = Block.blocksList[i];

                if (block == Block.woodSingleSlab)
                    return 150;

                if (block.blockMaterial == Material.wood)
                    return 300;

                if (block == Block.coalBlock)
                    return 16000;
            }

            if (item instanceof ItemTool && ((ItemTool) item).getToolMaterialName().equals("WOOD"))
                return 200;
            if (item instanceof ItemSword && ((ItemSword) item).getToolMaterialName().equals("WOOD"))
                return 200;
            if (item instanceof ItemHoe && ((ItemHoe) item).getMaterialName().equals("WOOD"))
                return 200;
            if (i == Item.stick.itemID)
                return 100;
            if (i == Item.coal.itemID)
                return 1600;
            if (i == Item.bucketLava.itemID)
                return 20000;
            if (i == Block.sapling.blockID)
                return 100;
            if (i == Item.blazeRod.itemID)
                return 2400;
            return GameRegistry.getFuelValue(par0ItemStack);
        }
    }

>>>>>>> origin/master
    @Override
    public int[] getAccessibleSlotsFromSide(int var1)
    {

        return var1 == 0 ? slots_bottom : var1 == 1 ? slots_top : slots_sides;
    }

    @Override
    public boolean canInsertItem(int i, ItemStack itemstack, int j)
    {

        return this.isItemValidForSlot(i, itemstack);
    }

    @Override
    public boolean canExtractItem(int i, ItemStack itemstack, int j)
    {

<<<<<<< HEAD
        return j != 0 || i != 1 || itemstack.getItem() == Items.bucket;
=======
        return j != 0 || i != 1 || itemstack.itemID == Item.bucketEmpty.itemID;
    }

    @Override
    public void openChest()
    {
    }

    @Override
    public void closeChest()
    {
>>>>>>> origin/master
    }

    public int getItemBurnTimeRemainingScaled(int i)
    {
        if (this.currentItemBurnTime == 0)
        {
            this.currentItemBurnTime = this.FurnaceSpeed;
        }
        return this.burnTime * i / this.currentItemBurnTime;
    }

    public int getCookProgressScaled(int i)
    {
        return this.cookTime * i / this.FurnaceSpeed;
    }
    
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
<<<<<<< HEAD
        NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Items", 10);
=======
        NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Items");
>>>>>>> origin/master
        this.slots = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
<<<<<<< HEAD
        	NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
=======
            NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.tagAt(i);
>>>>>>> origin/master
            byte b0 = nbttagcompound1.getByte("Slot");

            if (b0 >= 0 && b0 < this.slots.length)
            {
                this.slots[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }

        this.burnTime = par1NBTTagCompound.getShort("BurnTime");
        this.cookTime = par1NBTTagCompound.getShort("CookTime");
        this.currentItemBurnTime = getItemBurnTime(this.slots[1]);

        if (par1NBTTagCompound.hasKey("CustomName"))
        {
            this.LocalizedName = par1NBTTagCompound.getString("CustomName");
        }
    }

    /**
     * Writes a tile entity to NBT.
     */
    public void writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);
        nbt.setShort("BurnTime", (short)this.burnTime);
        nbt.setShort("CookTime", (short)this.cookTime);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.slots.length; i++)
        {
            if (this.slots[i] != null)
            {
                NBTTagCompound nbttagcompound = new NBTTagCompound();
                nbttagcompound.setByte("Slot", (byte)i);
                this.slots[i].writeToNBT(nbttagcompound);
                nbttaglist.appendTag(nbttagcompound);
            }
        }

        nbt.setTag("Items", nbttaglist);

        if (this.isInvNameLocalized())
        {
            nbt.setString("CustomName", this.LocalizedName);
        }
    }
<<<<<<< HEAD


	@Override
	public boolean hasCustomInventoryName() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void openInventory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeInventory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getInventoryName() {
		// TODO Auto-generated method stub
		return null;
	}
=======
>>>>>>> origin/master
    
    
    

}
