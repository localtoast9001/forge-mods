/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */

package de.shittyco.morematerials;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.FMLLog;

/**
 * Client-specific calls needed by the mod.
 * @author jrowlett
 *
 */
public class ClientProxy extends CommonProxy {
    /**
     * Initializes a new instance of the ClientProxy class.
     */
    public ClientProxy() {
        super();
        FMLLog.fine("Created ClientProxy");
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
            "Registering inventory for item %s and metadata %d",
            id,
            metadata);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(
                item,
                metadata,
                new ModelResourceLocation(
                    "morematerials:" + id,
                    "inventory"));
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
                "Registering variant %s for item %s.",
                variantName,
                item.getUnlocalizedName());
        }
        
        ModelBakery.registerItemVariants(item, names);
    }
}
