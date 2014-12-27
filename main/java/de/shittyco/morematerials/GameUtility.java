/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */
package de.shittyco.morematerials;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Common Game related utility methods.
 * @author jrowlett
 *
 */
public final class GameUtility {

    /**
     * Helper to register an item model for rendering.
     * @param item the item to register.
     * @param id the unique id of the item.
     * @param metadata the item metadata.
     */
    public static void registerInventoryModel(
        final Item item,
        final String id,
        final int metadata) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(
                item,
                metadata,
                new ModelResourceLocation(
                    "morematerials:" + id,
                    "inventory"));
    }

    /**
     * Helper to get an item from its block.
     * @param name the id of the block.
     * @return the matching item.
     */
    public static Item getItemFromBlock(final String name) {
        return GameRegistry.findItem("morematerials", name);
    }

    /**
     * Prevents an instance of the GameUtility class from
     * being instantiated.
     */
    private GameUtility() {
    }
}
