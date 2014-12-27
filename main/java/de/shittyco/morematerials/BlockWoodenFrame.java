/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */
package de.shittyco.morematerials;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 * A wooden frame filled with wattle and daub.
 * @author jrowlett
 *
 */
public class BlockWoodenFrame extends Block {

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
     * The set of side icons for each wood type.
     */
    /*@SideOnly(Side.CLIENT)
    private IIcon[] sideIcons;*/

    /**
     * The set of top and bottom icons for each wood type.
     */
    /*@SideOnly(Side.CLIENT)
    private IIcon[] woodIcons;*/

    /**
     * Initializes a new instance of the BlockWoodenFrame class.
     */
    public BlockWoodenFrame() {
        super(Material.wood);
        this.setHardness(HARDNESS);
        this.setResistance(RESISTANCE);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setStepSound(soundTypeWood);
        //this.setBlockName(NAME);
        //this.setBlockTextureName("morematerials:woodenframe");
    }

    /**
     * Gets the block's texture. Args: side, meta
     * @param side the side to get the icon for.
     * @param meta the item metadata.
     * @return the icon to use for the side and meta.
     */
    /*@SideOnly(Side.CLIENT)
    public final IIcon getIcon(final int side, final int meta) {
        // top or bottom.
        if (side == 0 || side == 1) {
            return this.woodIcons[meta];
        }

        return this.sideIcons[meta];
    }*/

    /**
     * Gets the damage for the item dropped based
     * on the block's metadata.
     * @param metadata the block's metadata.
     * @return the damaged value for the item dropped.
     */
    /*@Override
    public final int damageDropped(final int metadata) {
        return metadata;
    }*/

    /**
     * returns a list of blocks with the same ID, but different meta
     * (eg: wood returns 4 blocks).
     * @param item the item that gets dropped.
     * @param tab the creative tab for the item.
     * @param subItems gets populated with sub items.
     */
    /*@SideOnly(Side.CLIENT)
    @Override
    public final void getSubBlocks(
        final Item item,
        final CreativeTabs tab,
        final List subItems) {
        for (int i = 0; i < WoodUtility.WOOD_TYPE_COUNT; i++) {
            subItems.add(new ItemStack(item, 1, i));
        }
    }*/

    /**
     * Registers the block icons.
     * @param iconRegister called back to register icons.
     */
    /*@SideOnly(Side.CLIENT)
    public final void registerBlockIcons(final IIconRegister iconRegister) {
        this.sideIcons = new IIcon[WoodUtility.WOOD_TYPE_COUNT];
        this.woodIcons = new IIcon[WoodUtility.WOOD_TYPE_COUNT];

        for (int i = 0; i < this.sideIcons.length; i++) {
            this.sideIcons[i] = iconRegister.registerIcon(
                this.getTextureName() + "_" + WoodUtility.WOOD_TYPE_IDS[i]);
            this.woodIcons[i] = iconRegister.registerIcon(
                "planks_" + WoodUtility.WOOD_TYPE_IDS[i]);
        }
    }*/
}
