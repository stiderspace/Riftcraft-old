package com.stider.riftcraft.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

import com.stider.riftcraft.tile.TileEntityFurnace;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerFurnace extends Container
{

    private TileEntityFurnace furnace;
    public int lastBurntime;
    public int lastItemBurntime;
    public int lastCooktime;

    public ContainerFurnace(InventoryPlayer InventoryPlayer, TileEntityFurnace tileentityfurnace)
    {
        lastCooktime = 0;
        lastBurntime = 0;
        lastItemBurntime = 0;

        furnace = tileentityfurnace;

        addSlotToContainer(new Slot(tileentityfurnace, 0, 56, 17));
        addSlotToContainer(new Slot(tileentityfurnace, 1, 56, 53));
        addSlotToContainer(new SlotFurnace(InventoryPlayer.player, tileentityfurnace, 2, 116, 35));

        int Var1;

        for (Var1 = 0; Var1 < 3; ++Var1)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(InventoryPlayer, j + Var1 * 9 + 9, 8 + j * 18, 84 + Var1 * 18));
            }
        }

        for (Var1 = 0; Var1 < 9; ++Var1)
        {
            this.addSlotToContainer(new Slot(InventoryPlayer, Var1, 8 + Var1 * 18, 142));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityplayer)
    {

        return this.furnace.isUseableByPlayer(entityplayer);
    }

    public void addCraftingToCrafters(ICrafting icrafting)
    {
        super.addCraftingToCrafters(icrafting);
        icrafting.sendProgressBarUpdate(this, 0, this.furnace.cookTime);
        icrafting.sendProgressBarUpdate(this, 1, this.furnace.burnTime);
        icrafting.sendProgressBarUpdate(this, 2, this.furnace.currentItemBurnTime);

    }

    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); i++)
        {
            ICrafting icrafting = (ICrafting) this.crafters.get(i);
            if (this.lastCooktime != this.furnace.cookTime)
            {
                icrafting.sendProgressBarUpdate(this, 0, this.furnace.cookTime);
            }
            if (this.lastBurntime != this.furnace.burnTime)
            {
                icrafting.sendProgressBarUpdate(this, 1, this.furnace.burnTime);
            }
            if (this.lastItemBurntime != this.furnace.currentItemBurnTime)
            {
                icrafting.sendProgressBarUpdate(this, 2, this.furnace.currentItemBurnTime);
            }
        }
        this.lastCooktime = this.furnace.cookTime;
        this.lastBurntime = this.furnace.burnTime;
        this.lastItemBurntime = this.furnace.currentItemBurnTime;
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int slot, int newValue)
    {
        if (slot == 0)this.furnace.cookTime = newValue;
        if (slot == 1)this.furnace.burnTime = newValue;
        if (slot == 2)this.furnace.currentItemBurnTime = newValue;
    }

    public ItemStack transferStackInSlot(EntityPlayer player, int clickedslot)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot) this.inventorySlots.get(clickedslot);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (clickedslot == 2)
            {
                if (!this.mergeItemStack(itemstack1, 3, 39, true))
                {
                    return null;

                }
                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (clickedslot != 1 && clickedslot != 0)
            {
                if (FurnaceRecipes.smelting().getSmeltingResult(itemstack1) != null)
                {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false))
                    {
                        return null;
                    }
                }
                else if (TileEntityFurnace.isItemFuel(itemstack1))
                {
                    if (!this.mergeItemStack(itemstack1, 1, 2, false))
                    {
                        return null;
                    }
                }
                else if (clickedslot >= 3 && clickedslot < 30)
                {
                    if (this.mergeItemStack(itemstack1, 30, 39, false))
                    {
                        return null;
                    }
                }
                else if (clickedslot >= 30 && clickedslot < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 3, 39, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack) null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(player, itemstack1);
        }

        return itemstack;
    }
}
