/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */
package de.shittyco.morematerials;

import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;

/**
 * A wattle panel that can have daub spread over it to form
 * a wattle and daub wall.
 * @author jrowlett
 *
 */
public class BlockWattlePanel extends BlockPane {
    /**
     * The registration ID.
     */
    public static final String ID = "block_wattle_panel";

    /**
     * The unlocalized name.
     */
    private static final String NAME = "wattle_panel";

    /**
     * The inventory icon.
     */
    private static final String INVENTORY_ICON = "morematerials:wattle";

    /**
     * The block texture.
     */
    private static final String TEXTURE = "morematerials:wattle";

    /**
     * The block hardness.
     */
    private static final float HARDNESS = 0.4F;

    /**
     * The block resistance.
     */
    private static final float RESISTANCE = 2.0F;

    /**
     * Initializes a new instance of the BlockWattlePanel class.
     */
    public BlockWattlePanel() {
        super(INVENTORY_ICON, TEXTURE, Material.wood, true);
        this.setHardness(HARDNESS);
        this.setResistance(RESISTANCE);
        this.setStepSound(soundTypeWood);
        this.setBlockName(NAME);
    }
}
