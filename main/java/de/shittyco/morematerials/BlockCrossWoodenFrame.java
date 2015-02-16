/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */
package de.shittyco.morematerials;

/**
 * A wattle and daub wooden frame with cross timbers.
 * @author jrowlett
 *
 */
public class BlockCrossWoodenFrame extends BlockBaseWoodenFrame {

    /**
     * ID for the game registry.
     */
    public static final String ID = "cross_wooden_frame_block";

    /**
     * Unlocalized name.
     */
    private static final String NAME = "crossWoodenFrame";

    /**
     * Texture name.
     */
    private static final String TEXTURE_NAME =
        "morematerials:cross_woodenframe";

    /**
     * Initializes a new instance of the BlockCrossWoodenFrame class.
     */
    public BlockCrossWoodenFrame() {
        super(ID, NAME, TEXTURE_NAME);
    }
}
