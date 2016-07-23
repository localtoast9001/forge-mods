/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */

package de.shittyco.morematerials;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

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
        setStepSound(SoundType.STONE);
        setUnlocalizedName(NAME);
        setCreativeTab(CreativeTabs.tabBlock);
    }

    /**
     * Call on init to register the icons for inventory.
     * @param proxy the proxy to register the models.
     */
    public final void registerModels(final CommonProxy proxy) {
        Item itemBlock = GameUtility.getItemFromBlock(ID);
        ResourceLocation[] names = new ResourceLocation[ColorUtility.COLOR_COUNT];
        for (int i = 0; i < ColorUtility.COLOR_COUNT; i++) {
            proxy.registerInventoryModel(
                itemBlock,
                ID + "_" + ColorUtility.COLOR_IDS[i],
                i);
            String name = 
                "morematerials:" + ID + "_" + ColorUtility.COLOR_IDS[i];
            names[i] = new ResourceLocation(name);
        }
        
        proxy.registerItemVariants(itemBlock, names);
    }
}
