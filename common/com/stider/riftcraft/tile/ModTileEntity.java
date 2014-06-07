package com.stider.riftcraft.tile;

import com.stider.riftcraft.lib.Strings;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModTileEntity
{
    public static void init()
    {
        GameRegistry.registerTileEntity(TileEntityFurnace.class, Strings.TILE_FURNACE);

    }
}
