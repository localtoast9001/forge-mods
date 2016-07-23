/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */

package de.shittyco.morematerials;

import net.minecraft.util.IStringSerializable;

/**
 * Block state property type for Wood species.
 * @author jrowlett
 *
 */
public enum WoodMetadata implements IStringSerializable {
    /**
     * The oak wood type.
     */
    OAK(0),

    /**
     * The spruce wood type.
     */
    SPRUCE(1),

    /**
     * The birch wood type.
     */
    BIRCH(2),

    /**
     * The jungle wood type.
     */
    JUNGLE(3),

    /**
     * The acacia wood type.
     */
    ACACIA(4),

    /**
     * The big or dark oak type.
     */
    BIG_OAK(5);

    /**
     * metadata / damage value for the type of wood.
     */
    private int metadataValue;

    /**
     * Gets the WoodMetadata value from an integer.
     * @param meta the integer value
     * @return the matching enum value.
     */
    public static WoodMetadata fromMetadata(final int meta) {
        return values()[meta];
    }

    /**
     * Gets the name of the value.
     * @return the name of the value.
     */
    @Override
    public final String getName() {
        return WoodUtility.WOOD_TYPE_IDS[this.metadataValue];
    }

    /**
     * Initializes a new instance of the WoodMetadata class.
     * @param value the metadata value.
     */
    private WoodMetadata(final int value) {
        this.metadataValue = value;
    }
}
