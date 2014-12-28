/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */
package de.shittyco.morematerials;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import net.minecraft.block.material.Material;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Stained Brick Blocks.
 * @author jrowlett
 *
 */
public class BlockStainedBricks extends ColoredBlock {

    /**
     * The ID for the registry.
     */
    public static final String ID = "stained_bricks_block";

    /**
     * The unlocalized name.
     */
    private static final String NAME = "stainedBricks";

    /**
     * Hardness value for the material.
     */
    private static final float HARDNESS = 2.0f;

    /**
     * Resistance value for the material.
     */
    private static final float RESISTANCE = 10.0f;

    /**
     * Initializes a new instance of the BlockStainedBricks class.
     */
    public BlockStainedBricks() {
        super(Material.rock);
        setHardness(HARDNESS);
        setResistance(RESISTANCE);
        setStepSound(soundTypePiston);
        setUnlocalizedName(NAME);
        setCreativeTab(CreativeTabs.tabBlock);
    }

    /**
     * Call on init to register the icons for inventory.
     */
    @SideOnly(Side.CLIENT)
    public final void registerModels() {
        Item itemBlock = GameUtility.getItemFromBlock(ID);
        for (int i = 0; i < ColorUtility.COLOR_COUNT; i++) {
            GameUtility.registerInventoryModel(
                itemBlock,
                ID + "_" + ColorUtility.COLOR_IDS[i],
                i);
            ModelBakery.addVariantName(
                itemBlock,
                "morematerials:" + ID + "_" + ColorUtility.COLOR_IDS[i]);
        }
    }
}
