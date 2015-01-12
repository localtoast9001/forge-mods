/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */
package de.shittyco.morematerials;

import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

/**
 * Thatched Roofing Block.
 * @author jrowlett
 *
 */
public class BlockThatchedRoofing extends BlockRoofing {

    /**
     * ID for registration.
     */
    public static final String ID = "thatched_roofing";

    /**
     * Unlocalized name of the block.
     */
    private static final String NAME = "thatched_roofing";

    /**
     * Initializes a new instance of the BlockThatchedRoofing class.
     */
    public BlockThatchedRoofing() {
        super(Blocks.hay_block.getStateFromMeta(0));
        this.setUnlocalizedName(NAME);
    }

    /**
     * Registers models for display in the inventory.
     */
    public final void registerModels() {
        Item itemBlock = GameUtility.getItemFromBlock(ID);
        ModelBakery.addVariantName(
            itemBlock,
            "morematerials:" + ID);
        GameUtility.registerInventoryModel(
            itemBlock,
            ID,
            0);
    }
}
