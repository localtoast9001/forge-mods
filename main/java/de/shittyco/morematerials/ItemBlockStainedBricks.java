/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */
package de.shittyco.morematerials;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Stained Bricks block class.
 * @author jrowlett
 *
 */
public class ItemBlockStainedBricks extends ItemBlock {

    /**
     * ID to use in the registry.
     */
    public static final String ID = "block_stained_bricks";

    /**
     * Initializes a new instance of the ItemBlockStainedBricks class.
     * @param block the block that this item is for.
     */
    public ItemBlockStainedBricks(final Block block) {
        super(block);
        setHasSubtypes(true);
    }

    /**
     * Gets the metadata for the block from an item damage value.
     * @param damageValue the damage from the item.
     * @return block metadata.
     */
    @Override
    public final int getMetadata(final int damageValue) {
        return damageValue;
    }

    /**
     * Gets the unlocalized name for the block.
     * @param itemStack the stack to get the name for.
     * @return the unlocalized name.
     */
    @Override
    public final String getUnlocalizedName(final ItemStack itemStack) {
        int damage = itemStack.getItemDamage();
        return super.getUnlocalizedName()
            + "."
            + ColorUtility.COLOR_NAMES[damage];
    }
}
