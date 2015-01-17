/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */
package de.shittyco.morematerials;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.FMLLog;

/**
 * Base class to specialize client vs. server calls in the mod.
 * @author jrowlett
 *
 */
public class CommonProxy {
    /**
     * Initializes a new instance of the CommonProxy class.
     */
    public CommonProxy() {
        FMLLog.fine("Created CommonProxy");
    }

    /**
     * Helper to register an item model for rendering.
     * @param item the item to register.
     * @param id the unique id of the item.
     * @param metadata the item metadata.
     */
    public void registerInventoryModel(
        final Item item,
        final String id,
        final int metadata) {
        FMLLog.fine(
            "Registering inventory model %s for metadata %d. no-op.",
            id,
            metadata);
    }

    /**
     * Helper to add a model variant in the ModelBakery.
     * @param item the main item.
     * @param variantName the variant name.
     */
    public void addModelBakeryVariant(
        final Item item,
        final String variantName) {
        FMLLog.fine(
            "Registering model bakery variant %s for model %s. no-op.",
            variantName,
            item.getUnlocalizedName());
    }
}
