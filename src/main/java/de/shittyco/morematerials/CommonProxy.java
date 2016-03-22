/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */

package de.shittyco.morematerials;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

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
     * Helper to add model variants to the ModelBakery.
     * @param item the main item.
     * @param names the variant names.
     */
    public abstract void registerItemVariants(
        final Item item, 
        final ResourceLocation... names);
}
