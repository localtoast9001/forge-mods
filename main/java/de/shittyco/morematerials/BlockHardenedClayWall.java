/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */
package de.shittyco.morematerials;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * A wall that is made from hardened clay blocks.
 * @author jrowlett
 *
 */
public class BlockHardenedClayWall extends BlockGenericWall {
    /**
     * The registration ID.
     */
    public static final String ID = "hardened_clay_wall";

    /**
     * The unlocalized name.
     */
    public static final String NAME = "hardened_clay_wall";

    /**
     * Initializes a new instance of the HardenedClayWall class.
     */
    public BlockHardenedClayWall() {
        super(Blocks.hardened_clay, 0);
        setBlockName(NAME);
    }

    /**
     * returns a list of blocks with the same ID, but different meta
     * (eg: wood returns 4 blocks).
     * @param item the item for the block.
     * @param creativeTabs the creative tabs.
     * @param subBlocks the list to populate.
     */
    @SideOnly(Side.CLIENT)
    @Override
    public final void getSubBlocks(
        final Item item,
        final CreativeTabs creativeTabs,
        final List subBlocks) {
        subBlocks.add(new ItemStack(item, 1, 0));
    }
}
