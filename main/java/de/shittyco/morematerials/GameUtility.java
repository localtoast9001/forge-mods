/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */
package de.shittyco.morematerials;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

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
    	Item item,
    	String id,
    	int metadata) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(
            	item,
            	metadata,
            	new ModelResourceLocation(
            		"morematerials:" + id,
            		"inventory"));
    }

	/**
	 * Prevents an instance of the GameUtility class from
	 * being instantiated.
	 */
	private GameUtility() {
		
	}
}
