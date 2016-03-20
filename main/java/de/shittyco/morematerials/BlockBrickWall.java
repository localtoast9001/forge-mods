/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */
package de.shittyco.morematerials;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

/**
 * Brick wall block.
 * @author jrowlett
 *
 */
public class BlockBrickWall extends BlockGenericWall {
    /**
     * ID for registry.
     */
    public static final String ID = "brick_wall";

    /**
     * Unlocalized name.
     */
    private static final String NAME = "brick_wall";

    /**
     * Block hardness.
     */
    private static final float HARDNESS = 2.0f;

    /**
     * block resistance.
     */
    private static final float RESISTANCE = 10.0f;

    /**
     * Initializes a new instance of the BlockBrickWall class.
     */
    public BlockBrickWall() {
        super(Blocks.brick_block, 0);
        this.setUnlocalizedName(NAME);
        this.setHardness(HARDNESS);
        this.setResistance(RESISTANCE);
    }

    /**
     * Call on init to register the icons for inventory.
     * @param proxy the proxy to register the models.
     */
    public final void registerModels(
        final CommonProxy proxy) {
        Item itemBlock = GameUtility.getItemFromBlock(ID);
        proxy.addModelBakeryVariant(
            itemBlock,
            "morematerials:" + ID);
        proxy.registerInventoryModel(
            itemBlock,
            ID,
            0);
    }
}
