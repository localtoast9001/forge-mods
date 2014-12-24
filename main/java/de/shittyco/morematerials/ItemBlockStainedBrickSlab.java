/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */
package de.shittyco.morematerials;

import net.minecraft.block.Block;
import net.minecraft.item.ItemSlab;

/**
 * Wrapper around ItemSlab to allow init from GameRegistry.
 * @author jrowlett
 *
 */
public class ItemBlockStainedBrickSlab extends ItemSlab {
    /**
     * Initializes a new instance of the ItemBlockStainedBrickSlab class.
     * @param block the block behind the item.
     * @param slab the half height slab.
     * @param doubleSlab the full height slab.
     * @param stacked whether or not the block is the stacked version.
     */
    public ItemBlockStainedBrickSlab(
        final Block block,
        final BlockStainedBrickSlab slab,
        final BlockStainedBrickSlab doubleSlab,
        final Boolean stacked) {
        super(block, slab, doubleSlab, stacked);
    }
}
