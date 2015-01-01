/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */
package de.shittyco.morematerials;

/**
 * A wooden frame filled with wattle and daub.
 * @author jrowlett
 *
 */
public class BlockWoodenFrame extends BlockBaseWoodenFrame {

    /**
     * ID for the game registry.
     */
    public static final String ID = "wooden_frame_block";

    /**
     * Unlocalized name.
     */
    private static final String NAME = "woodenFrame";

    /**
     * Initializes a new instance of the BlockWoodenFrame class.
     */
    public BlockWoodenFrame() {
        super(ID, NAME);
    }
}
