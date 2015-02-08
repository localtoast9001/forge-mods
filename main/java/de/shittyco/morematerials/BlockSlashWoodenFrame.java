/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */
package de.shittyco.morematerials;

/**
 * Wattle and Daub timber frame with a diagonal timber in the slash
 * direction.
 * @author jrowlett
 *
 */
public class BlockSlashWoodenFrame extends BlockBaseWoodenFrame {

    /**
     * ID for the game registry.
     */
    public static final String ID = "slash_wooden_frame_block";

    /**
     * Unlocalized name.
     */
    private static final String NAME = "slashWoodenFrame";
    
    /**
     * Texture name.
     */
    private static final String TEXTURE_NAME = "morematerials:slash_woodenframe";

    /**
     * Initializes a new instance of the BlockSlashWoodenFrame class.
     */
    public BlockSlashWoodenFrame() {
        super(ID, NAME, TEXTURE_NAME);
    }
}
