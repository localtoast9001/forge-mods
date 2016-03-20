/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */
package de.shittyco.morematerials;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

/**
 * Clay walls stained with different colors.
 * @author jrowlett
 *
 */
public class BlockStainedHardenedClayWall extends BlockGenericWall {
    /**
     * base unlocalized name of the block.
     */
    private static final String NAME = "stained_hardened_clay_wall";

    /**
     * The block hardness.
     */
    private static final float HARDNESS = 1.25f;

    /**
     * The block resistance.
     */
    private static final float RESISTANCE = 7.0f;

    /**
     * Color of the clay.
     */
    private int color;

    /**
     * Initializes a new instance of the BlockStainedHardenedClayWall class.
     * @param blockColor the stain color.
     */
    public BlockStainedHardenedClayWall(final int blockColor) {
        super(Blocks.stained_hardened_clay, blockColor);
        this.color = blockColor;
        this.setUnlocalizedName(
                NAME
                + "."
                + ColorUtility.COLOR_NAMES[this.color]);
        this.setHardness(HARDNESS);
        this.setResistance(RESISTANCE);
    }

    /**
     * Gets the ID to use for registration.
     * @return the unique name of the block.
     */
    public final String getId() {
       return ColorUtility.COLOR_IDS[this.color]
           + "_stained_hardened_clay_wall";
    }

    /**
     * Call on init to register the icons for inventory.
     * @param proxy the proxy to register the models.
     */
    public final void registerModels(
        final CommonProxy proxy) {
        String id = this.getId();
        Item itemBlock = GameUtility.getItemFromBlock(id);
        proxy.addModelBakeryVariant(
            itemBlock,
            "morematerials:" + id);
        proxy.registerInventoryModel(
            itemBlock,
            id,
            0);
    }
}
