/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */
package de.shittyco.morematerials;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Item for a composite clay mixed with dirt and sand that
 * can be smelted into bricks.
 * @author jrowlett
 *
 */
public class ItemBrickClay extends Item {

    /**
     * ID of the item for the game registry.
     */
    public static final String ID = "brickclay";

    /**
     * unlocalized name of the item.
     */
    private static final String NAME = "brickClay";

    /**
     * Initializes a new instance of the ItemBrickClay class.
     */
    public ItemBrickClay() {
        setUnlocalizedName(NAME);
        setTextureName("morematerials:brickclay");
        setCreativeTab(CreativeTabs.tabMaterials);
    }
}
