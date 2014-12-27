/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */
package de.shittyco.morematerials;

import net.minecraft.util.IStringSerializable;

/**
 * Block state value that maps color to an enum value.
 * @author jrowlett
 *
 */
public enum ColorMetadata implements IStringSerializable {
    /**
     * The color black.
     */
    BLACK(0),

    /**
     * The color red.
     */
    RED(1),

    /**
     * The color green.
     */
    GREEN(2),

    /**
     * The color brown.
     */
    BROWN(3),

    /**
     * The color blue.
     */
    BLUE(4),

    /**
     * The color purple.
     */
    PURPLE(5),

    /**
     * The color cyan.
     */
    CYAN(6),

    /**
     * The color silver or light gray.
     */
    SILVER(7),

    /**
     * The color gray or dark gray.
     */
    GRAY(8),

    /**
     * The color pink.
     */
    PINK(9),

    /**
     * The color lime or light green.
     */
    LIME(10),

    /**
     * The color yellow.
     */
    YELLOW(11),

    /**
     * The color light blue.
     */
    LIGHT_BLUE(12),

    /**
     * The color magenta.
     */
    MAGENTA(13),

    /**
     * The color orange.
     */
    ORANGE(14),

    /**
     * The color white.
     */
    WHITE(15);

    /**
     * The metadata value for the enum.
     */
    private int metadataValue;

    /**
     * Gets the ColorMetadata value from an integer.
     * @param meta the integer value
     * @return the matching enum value.
     */
    public static ColorMetadata fromMetadata(final int meta) {
        return values()[meta];
    }

    /**
     * Gets the name of the value.
     * @return the name of the value.
     */
    @Override
    public String getName() {
        return ColorUtility.COLOR_IDS[this.metadataValue];
    }

    /**
     * Initializes a new instance of the ColorMetadata class.
     * @param value the metadata value.
     */
    private ColorMetadata(final int value) {
        this.metadataValue = value;
    }
}
