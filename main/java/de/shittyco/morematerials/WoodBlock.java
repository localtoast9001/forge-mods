/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */
package de.shittyco.morematerials;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Base class for blocks that have variants according to
 * species of wood.
 * @author jrowlett
 *
 */
public abstract class WoodBlock extends Block {
    /**
     * The property used for the variant.
     */
    private static final PropertyEnum VARIANT_PROPERTY =
        PropertyEnum.create("variant", WoodMetadata.class);

    /**
     * Gets a block state from metadata.
     * @param meta the metadata or color value.
     * @return a block state with the meta encoded as the variant property.
     */
    @Override
    public final IBlockState getStateFromMeta(final int meta) {
        return addVariant(
            this.getDefaultState(),
            WoodMetadata.fromMetadata(meta));
    }

    /**
     * Gets the metadata value from a block state.
     * @param state the block state.
     * @return the metadata or color value.
     */
    @Override
    public final int getMetaFromState(final IBlockState state) {
        WoodMetadata value =
            (WoodMetadata) state.getValue(VARIANT_PROPERTY);
        return value.ordinal();
    }

    /**
     * Gets the damage for the block's item when dropped.
     * @param state the block's state.
     * @return the metadata or color value.
     */
    @Override
    public final int damageDropped(final IBlockState state) {
        WoodMetadata value =
            (WoodMetadata) state.getValue(VARIANT_PROPERTY);
        return value.ordinal();
    }

    /**
     * Creates a block state.
     * @return a block state with the variant property.
     */
    @Override
    protected final BlockState createBlockState() {
        return new BlockState(this, new IProperty[] {VARIANT_PROPERTY});
    }

    /**
     * Gets the sub blocks.
     * @param item the item that gets dropped.
     * @param tab the creative tab for the item.
     * @param subItems gets populated with sub items.
     */
    @SideOnly(Side.CLIENT)
    public final void getSubBlocks(
        final Item item,
        final CreativeTabs tab,
        final List subItems) {
        for (int ix = 0; ix < WoodUtility.WOOD_TYPE_COUNT; ix++) {
            subItems.add(new ItemStack(item, 1, ix));
        }
    }

    /**
     * Initialize a new instance of the WoodBlock class.
     * @param material the material for the block.
     */
    protected WoodBlock(final Material material) {
        super(material);
        IBlockState state = addVariant(
            this.blockState.getBaseState(),
            WoodMetadata.OAK);
        this.setDefaultState(
            state);
    }

    /**
     * Call on init to register the icons for inventory.
     * @param id the registered name of the block.
     */
    @SideOnly(Side.CLIENT)
    protected final void registerModels(final String id) {
        Item itemBlock = GameUtility.getItemFromBlock(id);
        for (int i = 0; i < WoodUtility.WOOD_TYPE_COUNT; i++) {
            ModelBakery.addVariantName(
                itemBlock,
                "morematerials:" + id + "_" + WoodUtility.WOOD_TYPE_IDS[i]);
            GameUtility.registerInventoryModel(
                itemBlock,
                id + "_" + WoodUtility.WOOD_TYPE_IDS[i],
                i);
        }
    }

    /**
     * Helper to add the variant property to a block state.
     * @param baseState the source block state.
     * @param value the value of the variant property.
     * @return the block state with the variant property.
     */
    private static IBlockState addVariant(
        final IBlockState baseState,
        final WoodMetadata value) {
        return baseState.withProperty(VARIANT_PROPERTY, value);
    }
}
