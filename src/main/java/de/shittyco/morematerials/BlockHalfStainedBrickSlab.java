/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */

package de.shittyco.morematerials;

/**
 * Regular slab of stained bricks.
 * @author jrowlett
 *
 */
public class BlockHalfStainedBrickSlab extends BlockStainedBrickSlab {
    /**
     * Initializes a new instance of the BlockHalfStainedBrickSlab class.
     * @param brickColor the brick color.
     */
    public BlockHalfStainedBrickSlab(final int brickColor) {
        super(brickColor);
    }

    /**
     * Gets whether or not this is double height.
     * @return always false.
     */
    @Override
    public final boolean isDouble() {
        return false;
    }
}
