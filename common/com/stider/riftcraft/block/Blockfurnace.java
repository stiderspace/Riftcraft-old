package com.stider.riftcraft.block;

import java.util.Random;

import javax.swing.Icon;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.stider.riftcraft.Riftcraft;
import com.stider.riftcraft.lib.Reference;
import com.stider.riftcraft.lib.RenderIds;
import com.stider.riftcraft.lib.Strings;
import com.stider.riftcraft.tile.TileEntityFurnace;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Blockfurnace extends BlockContainer
{

    public final boolean isActive;
    private static boolean keepInventory;
    private final Random furnaceRand = new Random();

    protected Blockfurnace(int id, boolean par2)
    {
        super(Material.iron);
        setHardness(5F);
        setStepSound(Block.soundTypeAnvil);
        setBlockName(Strings.FURNACE);
        this.setCreativeTab(Riftcraft.tabsRFC);
        this.isActive = par2;

    }
    

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		
		return new TileEntityFurnace();
	}


    @Override
    public int getRenderType()
    {
        return RenderIds.furnace;

    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    private IIcon[] IconBuffer = new IIcon[1];

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister IconRegister)
    {
        IconBuffer[0] = IconRegister.registerIcon(Reference.MOD_ID + ":" + "furnace");

    }
    @Override
    public IIcon getIcon(int side, int metadata)
    {
        if(side == 0)
        {
            return IconBuffer[0];
        }
        return IconBuffer[0];
    }
    

    public void onBlockAdded(World World, int Par1, int Par2, int Par3)
    {
        super.onBlockAdded(World, Par1, Par2, Par3);
        World.markBlockForUpdate(Par1, Par2, Par3);
    }

    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLiving, ItemStack itemStack)
    {

        int direction = 3;
        int facing = MathHelper.floor_double(entityLiving.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;

        if (facing == 0)
        {
            direction = ForgeDirection.NORTH.ordinal();
        }
        else if (facing == 1)
        {
            direction = ForgeDirection.EAST.ordinal();
        }
        else if (facing == 2)
        {
            direction = ForgeDirection.SOUTH.ordinal();
        }
        else if (facing == 3)
        {
            direction = ForgeDirection.WEST.ordinal();
        }

        world.setBlockMetadataWithNotify(x, y, z, direction, 3);

        if (itemStack.hasDisplayName())
        {
            ((TileEntityFurnace) world.getTileEntity(x, y, z)).setGUIDisplayName(itemStack.getDisplayName());
        }

        ((TileEntityFurnace) world.getTileEntity(x, y, z)).setOrientation(direction);
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitx, float hity, float hitz)
    {
        if (world.isRemote)
        {
            return true;
        }
        else
        {
            TileEntityFurnace tileentityfurnace = (TileEntityFurnace)world.getTileEntity(x, y, z);

           if (tileentityfurnace != null)
           {
              player.openGui(Riftcraft.instance, 0, world, x, y, z);
           
            }

            return true;
        }
    }
    public static void updateFurnaceBlockState(boolean b, World worldObj, int xCoord, int yCoord, int zCoord) 
    {
        int i = worldObj.getBlockMetadata(xCoord, xCoord, xCoord);
        
        TileEntity tileentity = worldObj.getTileEntity(xCoord, yCoord, zCoord);
        keepInventory = true;

        worldObj.setBlockMetadataWithNotify(xCoord, yCoord, xCoord, i, 2);
        
        if (tileentity != null)
        {
            tileentity.validate();
            worldObj.setTileEntity(xCoord, yCoord, zCoord, tileentity);
        }
    }
    

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random random)
    {
        if (this.isActive)
        {
            int direction = world.getBlockMetadata(x, y, z);
            float x1 = (float)x + 1F;
            float y1 = (float)y + random.nextFloat() * 6.0F / 16.0F;
            float z1 = (float)z + 0.5F;
            float f3 = 0.52F;
            float f4 = random.nextFloat() * 0.6F - 0.3F;
                    

            world.spawnParticle("smoke", (double)(x1 - f3), (double)y1, (double)(z1 + f4), 0.0D, 0.0D, 0.0D);
            world.spawnParticle("flame", (double)(x1 - f3), (double)y1, (double)(z1 + f4), 0.0D, 0.0D, 0.0D);

       
        }
    }
    
  
    public boolean hasComparatorInputOverride()
    {
        return true;
    }
    public int getComparatorOverride(World world, int x, int y, int z, int i)
    {
        return Container.calcRedstoneFromInventory((IInventory)world.getTileEntity(x, y, z));
    }
    
    
    public Block idPicked(World world, int x, int y, int z)
    {
        return ModBlocks.furnace;        
    }
    
    public void breakBlock(World par1World, int par2, int par3, int par4, Block par5, int par6)
    {
        if (!keepInventory)
        {
            TileEntityFurnace tileentityfurnace = (TileEntityFurnace)par1World.getTileEntity(par2, par3, par4);

            if (tileentityfurnace != null)
            {
                for (int j1 = 0; j1 < tileentityfurnace.getSizeInventory(); ++j1)
                {
                    ItemStack itemstack = tileentityfurnace.getStackInSlot(j1);

                    if (itemstack != null)
                    {
                        float f = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
                        float f1 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
                        float f2 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;

                        while (itemstack.stackSize > 0)
                        {
                            int k1 = this.furnaceRand.nextInt(21) + 10;

                            if (k1 > itemstack.stackSize)
                            {
                                k1 = itemstack.stackSize;
                            }

                            itemstack.stackSize -= k1;
                            EntityItem entityitem = new EntityItem(par1World, (double)((float)par2 + f), (double)((float)par3 + f1), (double)((float)par4 + f2), new ItemStack(itemstack.getItem(), k1, itemstack.getItemDamage()));

                            if (itemstack.hasTagCompound())
                            {
                                entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
                            }

                            float f3 = 0.05F;
                            entityitem.motionX = (double)((float)this.furnaceRand.nextGaussian() * f3);
                            entityitem.motionY = (double)((float)this.furnaceRand.nextGaussian() * f3 + 0.2F);
                            entityitem.motionZ = (double)((float)this.furnaceRand.nextGaussian() * f3);
                            par1World.spawnEntityInWorld(entityitem);
                        }
                    }
                }

                par1World.func_147453_f(par2, par3, par4, par5);
            }
        }

        super.breakBlock(par1World, par2, par3, par4, par5, par6);
    }
}



