/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */
package de.shittyco.morematerials;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 * A slab or double slab of stained bricks of a certain color.
 * @author jrowlett
 *
 */
public class BlockStainedBrickSlab extends BlockSlab {
    /**
     * The ID for the registry.
     */
    private static final String ID = "stained_bricks_slab";

    /**
     * The unlocalized name.
     */
    private static final String NAME = "stainedBricksSlab";

    /**
     * Hardness value for the material.
     */
    private static final float HARDNESS = 2.0f;

    /**
     * Resistance value for the material.
     */
    private static final float RESISTANCE = 10.0f;

    /**
     * Color - normally stored in metadata, but slabs need the meta.
     */
    private int color;

    /**
     * Initializes a new instance of the BlockStainedBrickSlab class.
     * @param stacked set to true if stacked double.
     * @param brickColor the color of the stain from 0-15.
     */
    public BlockStainedBrickSlab(
        final boolean stacked,
        final int brickColor) {
        super(stacked, Material.rock);
        this.color = brickColor;
        this.useNeighborBrightness = !stacked;
        setHardness(HARDNESS);
        setResistance(RESISTANCE);
        setStepSound(soundTypePiston);
        setBlockName(NAME + '_' + ColorUtility.COLOR_NAMES[this.color]);
        if (!stacked) {
            setCreativeTab(CreativeTabs.tabBlock);
        }

        setBlockTextureName(
            "morematerials:stainedbricks_"
            + ColorUtility.COLOR_IDS[this.color]);
    }

    /**
     * Gets the ID for the game registry.
     * @return the unique id for the registry.
     */
    public final String getId() {
        String result = "";
        if (this.isStacked()) {
            result = "double_";
        }

        return result + ID + '_' + ColorUtility.COLOR_IDS[this.color];
    }

    /**
     * Gets the unlocalized name based on metadata/damage.
     * @param metadata block metadata.
     * @return the unlocalized name.
     */
    @Override
    public final String func_150002_b(final int metadata) {
        return this.getUnlocalizedName();
    }

    /**
     * Helper to get if the slab is stacked.
     * @return true if stacked.
     */
    protected final boolean isStacked() {
        return this.field_150004_a;
    }
}
