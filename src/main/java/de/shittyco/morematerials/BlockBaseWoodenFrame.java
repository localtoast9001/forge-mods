/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */
package de.shittyco.morematerials;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 * Base class of all wooden frame variants.
 * @author jrowlett
 *
 */
public abstract class BlockBaseWoodenFrame extends WoodBlock {
    /**
     * The blocks registered id or name.
     */
    private final String id;

    /**
     * Hardness value.
     */
    private static final float HARDNESS = 2.0f;

    /**
     * Resistance value.
     */
    private static final float RESISTANCE = 7.5f;

    /**
     * Initializes a new instance of the BlockBaseWoodenFrame class.
     * @param registeredBlockId registered name of the block.
     * @param unlocalizedName the base unlocalized name.
     */
    protected BlockBaseWoodenFrame(
        final String registeredBlockId,
        final String unlocalizedName) {
        super(Material.wood);
        this.id = registeredBlockId;
        this.setHardness(HARDNESS);
        this.setResistance(RESISTANCE);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setStepSound(SoundType.WOOD);
        this.setUnlocalizedName(unlocalizedName);
    }

    /**
     * Registers models for inventory.
     * @param proxy the proxy for either client or server.
     */
    public final void registerModels(final CommonProxy proxy) {
        super.registerModels(proxy, this.id);
    }
}
