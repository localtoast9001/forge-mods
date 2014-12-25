/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */
package de.shittyco.morematerials;

import java.util.List;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
//import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
//import net.minecraft.util.IIcon;

/**
 * Stained Brick Blocks.
 * @author jrowlett
 *
 */
public class BlockStainedBricks extends Block {

    /**
     * The ID for the registry.
     */
    public static final String ID = "stained_bricks_block";

    /**
     * The unlocalized name.
     */
    private static final String NAME = "stainedBricks";

    /**
     * Hardness value for the material.
     */
    private static final float HARDNESS = 2.0f;

    /**
     * Resistance value for the material.
     */
    private static final float RESISTANCE = 10.0f;

    /**
     * The set of icons for each color.
     */
    //@SideOnly(Side.CLIENT)
    //private IIcon[] icons;

    /**
     * Initializes a new instance of the BlockStainedBricks class.
     */
    public BlockStainedBricks() {
        super(Material.rock);
        setHardness(HARDNESS);
        setResistance(RESISTANCE);
        setStepSound(soundTypePiston);
        //setBlockName(NAME);
        setCreativeTab(CreativeTabs.tabBlock);
        //setBlockTextureName("morematerials:stainedbricks");
    }

    /**
     * Gets the block's texture. Args: side, meta
     * @param side the side to get the icon for.
     * @param meta the item metadata.
     * @return the icon to use for the side and meta.
     */
    /*@SideOnly(Side.CLIENT)
    public final IIcon getIcon(final int side, final int meta) {
        return this.icons[meta];
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
        for (int ix = 0; ix < ColorUtility.COLOR_COUNT; ix++) {
            subItems.add(new ItemStack(item, 1, ix));
        }
    }

    /**
     * Registers the block icons.
     * @param iconRegister called back to register icons.
     */
    /*@SideOnly(Side.CLIENT)
    public final void registerBlockIcons(final IIconRegister iconRegister) {
        this.icons = new IIcon[ColorUtility.COLOR_IDS.length];

        for (int i = 0; i < this.icons.length; i++) {
            this.icons[i] = iconRegister.registerIcon(
                this.getTextureName() + "_" + ColorUtility.COLOR_IDS[i]);
        }
    }*/
}
