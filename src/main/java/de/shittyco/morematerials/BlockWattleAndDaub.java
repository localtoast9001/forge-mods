/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */

package de.shittyco.morematerials;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

/**
 * A wall made from wattle and daub.
 * @author jrowlett
 *
 */
public class BlockWattleAndDaub extends Block {
    /**
     * The registration ID.
     */
    public static final String ID = "wattle_and_daub";

    /**
     * The non-localized name.
     */
    private static final String NAME = "wattle_and_daub";

    /**
     * The block hardness.
     */
    private static final float HARDNESS = 1.5f;

    /**
     * The block resistance.
     */
    private static final float RESISTANCE = 5.0f;

    /**
     * Initializes a new instance of the BlockWattleAndDaub class.
     */
    public BlockWattleAndDaub() {
        super(Material.ROCK);
        this.setUnlocalizedName(NAME);
        this.setSoundType(SoundType.STONE);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
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
