/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */

package de.shittyco.morematerials;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

/**
 * A wall that is made from hardened clay blocks.
 * @author jrowlett
 *
 */
public class BlockHardenedClayWall extends BlockGenericWall {
    /**
     * The registration ID.
     */
    public static final String ID = "hardened_clay_wall";

    /**
     * The unlocalized name.
     */
    public static final String NAME = "hardened_clay_wall";

    /**
     * The block hardness.
     */
    private static final float HARDNESS = 1.25f;

    /**
     * The block resistance.
     */
    private static final float RESISTANCE = 7.0f;

    /**
     * Initializes a new instance of the HardenedClayWall class.
     */
    public BlockHardenedClayWall() {
        super(Blocks.HARDENED_CLAY, 0);
        setUnlocalizedName(NAME);
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
        proxy.registerItemVariants(
            itemBlock,
            new ResourceLocation("morematerials:" + ID));
        proxy.registerInventoryModel(
            itemBlock,
            ID,
            0);
    }
}
