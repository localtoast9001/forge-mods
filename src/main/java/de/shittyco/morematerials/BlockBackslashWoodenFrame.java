/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */

package de.shittyco.morematerials;

/**
 * A wattle and daub timber frame with a diagonal timber in the backslash
 * direction.
 * @author jrowlett
 *
 */
public class BlockBackslashWoodenFrame extends BlockBaseWoodenFrame {

    /**
     * ID for the game registry.
     */
    public static final String ID = "backslash_wooden_frame_block";

    /**
     * Unlocalized name.
     */
    private static final String NAME = "backslashWoodenFrame";

    /**
     * Initializes a new instance of the BlockBackslashWoodenFrame class.
     */
    public BlockBackslashWoodenFrame() {
        super(ID, NAME);
    }
}
