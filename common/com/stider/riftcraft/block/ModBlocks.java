package com.stider.riftcraft.block;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.stider.riftcraft.util.RegisterHelper;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks
{

    public static Block warpedBlock;
    public static Block stabilizer;
    public static Block dwarfstar;
    public static Block engine;
    public static Block upgradeslot;
    public static Block minirift;
    public static Block miniblackhole;
    public static Block furnace;
    public static Block riftLocator;
    public static Block blockRift;

    public static void init()
    {
        warpedBlock = new BlockWarpedBlock();
        stabilizer = new BlockStabilizer();
        engine = new BlockEngine();
        upgradeslot = new BlockUpgradeslot();
        minirift = new BlockMinirift();
        miniblackhole = new BlockMiniblackhole();
        dwarfstar = new BlockDwarfstar();
        furnace = new Blockfurnace(true);
        riftLocator = new riftlocator();
        blockRift = new BlockRift();
        
        //Register Blocks

        RegisterHelper.registerBlock(engine);
        RegisterHelper.registerBlock(minirift);
        RegisterHelper.registerBlock(upgradeslot);
        RegisterHelper.registerBlock(miniblackhole);
        RegisterHelper.registerBlock(warpedBlock);
        RegisterHelper.registerBlock(stabilizer);
        RegisterHelper.registerBlock(dwarfstar);
        RegisterHelper.registerBlock(furnace);
        RegisterHelper.registerBlock(riftLocator);
        
        RegisterHelper.registerBlock(blockRift);

        initBlockRecipes();
    }

    private static void initBlockRecipes()
    {

        GameRegistry.addRecipe(new ItemStack(warpedBlock), new Object[] { "iii", "iii", "iii", Character.valueOf('i'), Items.saddle });

    }
}
