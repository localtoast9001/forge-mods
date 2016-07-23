/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */

package de.shittyco.morematerials;

/**
 * Double slab of stained bricks.
 * @author jrowlett
 *
 */
public class BlockDoubleStainedBrickSlab extends BlockStainedBrickSlab {
    /**
     * Initializes a new instance of the BlockDoubleStainedBrickSlab class.
     * @param brickColor the brick color.
     */
    public BlockDoubleStainedBrickSlab(final int brickColor) {
        super(brickColor);
    }

    /**
     * Gets whether or not this is a double stacked slab.
     * @return always true.
     */
    @Override
    public final boolean isDouble() {
        return true;
    }
}
