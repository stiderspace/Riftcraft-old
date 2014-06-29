package com.stider.riftcraft.block;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import com.stider.riftcraft.lib.Strings;

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

        GameRegistry.registerBlock(engine, Strings.RIFT_ENGINE_NAME);
        GameRegistry.registerBlock(minirift, Strings.MINI_RIFT_NAME);
        GameRegistry.registerBlock(upgradeslot, Strings.UPGRADE_SLOT_NAME);
        GameRegistry.registerBlock(miniblackhole, Strings.MINI_BLACKHOLE_NAME);
        GameRegistry.registerBlock(warpedBlock, Strings.WARPEDBLOCK_NAME);
        GameRegistry.registerBlock(stabilizer, Strings.STABILIZER_NAME);
        GameRegistry.registerBlock(dwarfstar, Strings.DWARFSTAR_NAME);
        GameRegistry.registerBlock(furnace, Strings.FURNACE);

        initBlockRecipes();
    }

    private static void initBlockRecipes()
    {

        GameRegistry.addRecipe(new ItemStack(warpedBlock), new Object[] { "iii", "iii", "iii", Character.valueOf('i'), Blocks.glass });

    }
}
