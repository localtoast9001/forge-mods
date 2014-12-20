/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */
package de.shittyco.morematerials;

/**
 * Helper class for wood derived items.
 * @author jrowlett
 *
 */
public final class WoodUtility {

    /**
     * Different wood types by index.
     */
    public static final String[] WOOD_TYPE_IDS =  new String[] {
        "oak",
        "spruce",
        "birch",
        "jungle",
        "acacia",
        "big_oak"
        };

    /**
     * Count of types of wood.
     */
    public static final int WOOD_TYPE_COUNT = WOOD_TYPE_IDS.length;

    /**
     * Prevent instantiation of the WoodUtility class.
     */
    private WoodUtility() {
    }
}
