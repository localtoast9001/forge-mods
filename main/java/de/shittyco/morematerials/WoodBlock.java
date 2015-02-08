/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */
package de.shittyco.morematerials;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Base class for blocks that have variants according to
 * species of wood.
 * @author jrowlett
 *
 */
public abstract class WoodBlock extends Block {
    /**
     * Gets the damage for the item dropped based
     * on the block's metadata.
     * @param metadata the block's metadata.
     * @return the damaged value for the item dropped.
     */
    @Override
    public final int damageDropped(final int metadata) {
        return metadata;
    }

    /**
     * returns a list of blocks with the same ID, but different meta
     * (eg: wood returns 4 blocks).
     * @param item the item that gets dropped.
     * @param tab the creative tab for the item.
     * @param subItems gets populated with sub items.
     */
    @SideOnly(Side.CLIENT)
    @Override
    public final void getSubBlocks(
        final Item item,
        final CreativeTabs tab,
        final List subItems) {
        for (int i = 0; i < WoodUtility.WOOD_TYPE_COUNT; i++) {
            subItems.add(new ItemStack(item, 1, i));
        }
    }

    /**
     * Initialize a new instance of the WoodBlock class.
     * @param material the material for the block.
     */
    protected WoodBlock(final Material material) {
        super(material);
    }
}
