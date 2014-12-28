/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */
package de.shittyco.morematerials;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Stained brick stairs.
 * @author jrowlett
 *
 */
public class BlockStainedBrickStairs extends BlockStairs {

    /**
     * base unlocalized name of the block.
     */
    private static final String NAME = "stainedBrickStairs";

    /**
     * Color of the bricks to use.
     */
    private int color;

    /**
     * Initializes a new instance of the BlockStainedBrickStairs class.
     * @param block the stained bricks block.
     * @param brickColor the color metadata.
     */
    public BlockStainedBrickStairs(
        final BlockStainedBricks block,
        final int brickColor) {
        super(getBlockState(block, brickColor));
        this.color = brickColor;
        this.setUnlocalizedName(
            NAME
            + "."
            + ColorUtility.COLOR_NAMES[this.color]);
        this.useNeighborBrightness = true;
    }

    /**
     * Gets the ID to use for registration.
     * @return the unique name of the block.
     */
    public final String getId() {
       return BlockStainedBricks.ID
           + "_"
           + ColorUtility.COLOR_IDS[this.color]
           + "_stairs";
    }

    /**
     * Call on init to register the icons for inventory.
     */
    @SideOnly(Side.CLIENT)
    public final void registerModels() {
        Item itemBlock = GameUtility.getItemFromBlock(
            this.getId());
        ModelBakery.addVariantName(
            itemBlock,
            "morematerials:" + this.getId());
        GameUtility.registerInventoryModel(
            itemBlock,
            this.getId(),
            0);
    }

    /**
     * Helper to get the block state from the brick color.
     * @param block the source block.
     * @param brickColor the brick color.
     * @return the block state interface.
     */
    private static IBlockState getBlockState(
        final BlockStainedBricks block,
        final int brickColor) {
        return block.getStateFromMeta(brickColor);
    }
}
