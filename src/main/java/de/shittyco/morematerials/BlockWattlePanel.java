/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */
package de.shittyco.morematerials;

import net.minecraft.block.BlockPane;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

/**
 * A wattle panel that can have daub spread over it to form
 * a wattle and daub wall.
 * @author jrowlett
 *
 */
public class BlockWattlePanel extends BlockPane {
    /**
     * The registration ID.
     */
    public static final String ID = "block_wattle_panel";

    /**
     * The unlocalized name.
     */
    private static final String NAME = "wattle_panel";

    /**
     * The block hardness.
     */
    private static final float HARDNESS = 0.4F;

    /**
     * The block resistance.
     */
    private static final float RESISTANCE = 2.0F;

    /**
     * Initializes a new instance of the BlockWattlePanel class.
     */
    public BlockWattlePanel() {
        super(Material.wood, true);
        this.setHardness(HARDNESS);
        this.setResistance(RESISTANCE);
        this.setStepSound(SoundType.WOOD);
        this.setUnlocalizedName(NAME);
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
