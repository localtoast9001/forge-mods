/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */
package de.shittyco.morematerials;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Mixture of dirt, sand, clay, and straw used
 * in wattle and daub walls in timber frames.
 * @author jrowlett
 *
 */
public class ItemDaub extends Item {

    /**
     * ID used in the game registry.
     */
    public static final String ID = "daub";

    /**
     * unlocalized name.
     */
    private static final String NAME = "daub";

    /**
     * Initializes a new instance of the ItemDaub class.
     */
    public ItemDaub() {
        setUnlocalizedName(NAME);
        // setTextureName("morematerials:daub");
        setCreativeTab(CreativeTabs.tabMaterials);
    }
}
