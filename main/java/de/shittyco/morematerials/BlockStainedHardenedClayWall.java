/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */
package de.shittyco.morematerials;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Clay walls stained with different colors.
 * @author jrowlett
 *
 */
public class BlockStainedHardenedClayWall extends BlockGenericWall {
    /**
     * base unlocalized name of the block.
     */
    private static final String NAME = "stained_hardened_clay_wall";

    /**
     * Color of the clay.
     */
    private int color;

    /**
     * Initializes a new instance of the BlockStainedHardenedClayWall class.
     * @param blockColor the stain color.
     */
    public BlockStainedHardenedClayWall(final int blockColor) {
        // color metadata is backwards.
        super(
            Blocks.stained_hardened_clay,
            ColorUtility.COLOR_COUNT - blockColor - 1);
        this.color = blockColor;
        this.setBlockName(
                NAME
                + "."
                + ColorUtility.COLOR_NAMES[this.color]);
    }

    /**
     * Gets the ID to use for registration.
     * @return the unique name of the block.
     */
    public final String getId() {
       return ColorUtility.COLOR_IDS[this.color]
           + "_stained_hardened_clay_wall";
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
