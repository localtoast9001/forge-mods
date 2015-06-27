/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */
package de.shittyco.morematerials;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 * A wall made from wattle and daub.
 * @author jrowlett
 *
 */
public class BlockWattleAndDaub extends Block {
    /**
     * The registration ID.
     */
    public static final String ID = "wattle_and_daub";

    /**
     * The non-localized name.
     */
    private static final String NAME = "wattle_and_daub";

    /**
     * The texture name.
     */
    private static final String TEXTURE_NAME = "morematerials:wattle_and_daub";

    /**
     * The block hardness.
     */
    private static final float HARDNESS = 1.5f;

    /**
     * The block resistance.
     */
    private static final float RESISTANCE = 5.0f;

    /**
     * Initializes a new instance of the BlockWattleAndDaub class.
     */
    public BlockWattleAndDaub() {
        super(Material.rock);
        this.setBlockName(NAME);
        this.setStepSound(soundTypeStone);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setBlockTextureName(TEXTURE_NAME);
        this.setHardness(HARDNESS);
        this.setResistance(RESISTANCE);
    }
}
