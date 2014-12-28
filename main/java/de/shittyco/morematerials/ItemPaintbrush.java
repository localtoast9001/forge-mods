/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */
package de.shittyco.morematerials;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Paint brush tool.
 * @author jrowlett
 *
 */
public class ItemPaintbrush extends Item {

    /**
     * ID of the item for the game registry.
     */
    public static final String ID = "paintbrush";

    /**
     * Unlocalized name.
     */
    private static final String NAME = "paintbrush";

    /**
     * Maximum stack size.
     */
    private static final int MAXSTACKSIZE = 1;

    /**
     * Maximum damage.
     */
    private static final int MAXDAMAGE = 32;

    /**
     * Initializes a new instance of the Paintbrush class.
     */
    public ItemPaintbrush() {
        setUnlocalizedName(NAME);
        setMaxStackSize(MAXSTACKSIZE);
        setMaxDamage(MAXDAMAGE);
        setCreativeTab(CreativeTabs.tabTools);
    }
}
