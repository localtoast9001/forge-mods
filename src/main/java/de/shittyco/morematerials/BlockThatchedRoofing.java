/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */

package de.shittyco.morematerials;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

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
     * @param proxy the proxy to register the models.
     */
    public final void registerModels(final CommonProxy proxy) {
        Item itemBlock = GameUtility.getItemFromBlock(ID);
        proxy.registerItemVariants(
            itemBlock,
            new ResourceLocation("morematerials:" + ID));
        proxy.registerInventoryModel(
            itemBlock,
            ID,
            0);
    }
}
