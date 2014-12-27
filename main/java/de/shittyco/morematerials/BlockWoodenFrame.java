/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */
package de.shittyco.morematerials;

import net.minecraft.block.material.Material;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * A wooden frame filled with wattle and daub.
 * @author jrowlett
 *
 */
public class BlockWoodenFrame extends WoodBlock {

    /**
     * ID for the game registry.
     */
    public static final String ID = "wooden_frame_block";

    /**
     * Unlocalized name.
     */
    private static final String NAME = "woodenFrame";

    /**
     * Hardness value.
     */
    private static final float HARDNESS = 2.0f;

    /**
     * Resistance value.
     */
    private static final float RESISTANCE = 7.5f;

    /**
     * Initializes a new instance of the BlockWoodenFrame class.
     */
    public BlockWoodenFrame() {
        super(Material.wood);
        this.setHardness(HARDNESS);
        this.setResistance(RESISTANCE);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setStepSound(soundTypeWood);
        this.setUnlocalizedName(NAME);
    }

    /**
     * Call on init to register the icons for inventory.
     */
    @SideOnly(Side.CLIENT)
    public final void registerModels() {
        Item itemBlock = GameUtility.getItemFromBlock(ID);
        for (int i = 0; i < WoodUtility.WOOD_TYPE_COUNT; i++) {
            ModelBakery.addVariantName(
                itemBlock,
                "morematerials:" + ID + "_" + WoodUtility.WOOD_TYPE_IDS[i]);
            GameUtility.registerInventoryModel(
                itemBlock,
                ID + "_" + WoodUtility.WOOD_TYPE_IDS[i],
                i);
        }
    }
}
