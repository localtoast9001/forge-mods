/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */
package de.shittyco.morematerials;

import net.minecraft.item.Item;

/**
 * Base class to specialize client vs. server calls in the mod.
 * @author jrowlett
 *
 */
public abstract class CommonProxy {
    /**
     * Initializes a new instance of the CommonProxy class.
     */
    protected CommonProxy() {
    }

    /**
     * Helper to register an item model for rendering.
     * @param item the item to register.
     * @param id the unique id of the item.
     * @param metadata the item metadata.
     */
    public abstract void registerInventoryModel(
        final Item item,
        final String id,
        final int metadata);

    /**
     * Helper to add a model variant in the ModelBakery.
     * @param item the main item.
     * @param variantName the variant name.
     */
    public abstract void addModelBakeryVariant(
        final Item item,
        final String variantName);
}
