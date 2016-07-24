/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */

package de.shittyco.morematerials;

import net.minecraft.creativetab.CreativeTabs;

/**
 * Stained brick clay that can be smelted into stained bricks.
 * @author jrowlett
 *
 */
public class ItemStainedBrickClay extends ColoredItem {

    /**
     * ID of the item for the registry.
     */
    public static final String ID = "stained_brickclay";

    /**
     * unlocalized name of the item.
     */
    private static final String NAME = "stainedBrickClay";

    /**
     * Initializes a new instance of the ItemStainedBrickClay class.
     */
    public ItemStainedBrickClay() {
        super(NAME, ID);
        setCreativeTab(CreativeTabs.MATERIALS);
    }
}
