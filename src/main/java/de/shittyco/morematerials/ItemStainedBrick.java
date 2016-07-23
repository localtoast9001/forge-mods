/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */

package de.shittyco.morematerials;

import net.minecraft.creativetab.CreativeTabs;

/**
 * Stained brick item.
 * @author jrowlett
 *
 */
public class ItemStainedBrick extends ColoredItem {

    /**
     * ID of the item for the registry.
     */
    public static final String ID = "stained_brick";

    /**
     * unlocalized name of the item.
     */
    private static final String NAME = "stainedBrick";

    /**
     * Initializes a new instance of the ItemStainedBrick class.
     */
    public ItemStainedBrick() {
        super(NAME, ID);
        setCreativeTab(CreativeTabs.tabMaterials);
    }
}
