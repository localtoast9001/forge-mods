/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */
package de.shittyco.morematerials;

import net.minecraft.item.Item;

/**
 * Different color brick walls.
 * @author jrowlett
 *
 */
public class BlockStainedBrickWall extends BlockGenericWall {
    /**
     * base unlocalized name of the block.
     */
    private static final String NAME = "stainedBrickWall";

    /**
     * Block hardness.
     */
    private static final float HARDNESS = 2.0f;

    /**
     * block resistance.
     */
    private static final float RESISTANCE = 10.0f;

    /**
     * color of the bricks.
     */
    private int color;

    /**
     * Initializes a new instance of the BlockStainedBrickWall class.
     * @param block the registered stained bricks block.
     * @param brickColor color of the bricks.
     */
    public BlockStainedBrickWall(
        final BlockStainedBricks block,
        final int brickColor) {
        super(block, brickColor);
        this.color = brickColor;
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
       return BlockStainedBricks.ID
           + "_"
           + ColorUtility.COLOR_IDS[this.color]
           + "_wall";
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
