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
 * Brick wall block.
 * @author jrowlett
 *
 */
public class BlockBrickWall extends BlockGenericWall {
    /**
     * ID for registry.
     */
    public static final String ID = "brick_wall";

    /**
     * Unlocalized name.
     */
    private static final String NAME = "brick_wall";

    /**
     * Initializes a new instance of the BlockBrickWall class.
     */
    public BlockBrickWall() {
        super(Blocks.brick_block, 0);
        this.setBlockName(NAME);
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
