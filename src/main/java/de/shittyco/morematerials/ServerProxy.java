/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */
package de.shittyco.morematerials;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.FMLLog;

/**
 * Proxy that gets instantiated on the server only.
 * @author jrowlett
 *
 */
public class ServerProxy extends CommonProxy {
    /**
     * Initializes a new instance of the ServerProxy class.
     */
    public ServerProxy() {
        super();
        FMLLog.fine("Created ServerProxy");
    }

    /**
     * Helper to register an item model for rendering.
     * @param item the item to register.
     * @param id the unique id of the item.
     * @param metadata the item metadata.
     */
    @Override
    public final void registerInventoryModel(
        final Item item,
        final String id,
        final int metadata) {
        FMLLog.fine(
            "Registering inventory model %s for metadata %d. no-op.",
            id,
            metadata);
    }

    /**
     * Helper to add model variants to the ModelBakery.
     * @param item the main item.
     * @param names the variant names.
     */
    @Override
    public final void registerItemVariants(
        final Item item, 
        final ResourceLocation... names) {
        for (ResourceLocation variantName : names) {
            FMLLog.fine(
                "Registering model bakery variant %s for model %s. no-op.",
                variantName,
                item.getUnlocalizedName());
        }
    }
}
