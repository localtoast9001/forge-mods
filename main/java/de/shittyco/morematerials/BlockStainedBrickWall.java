/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */
package de.shittyco.morematerials;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Different color brick walls.
 * @author jrowlett
 *
 */
public class BlockStainedBrickWall extends BlockGenericWall {
    /**
     * base unlocalized name of the block.
     */
    private static final String NAME = "stainedBrickWall";

    /**
     * color of the bricks.
     */
    private int color;

    /**
     * Initializes a new instance of the BlockStainedBrickWall class.
     * @param block the registered stained bricks block.
     * @param brickColor color of the bricks.
     */
    public BlockStainedBrickWall(
        final BlockStainedBricks block,
        final int brickColor) {
        super(block, brickColor);
        this.color = brickColor;
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
       return BlockStainedBricks.ID
           + "_"
           + ColorUtility.COLOR_NAMES[this.color]
           + "_wall";
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
