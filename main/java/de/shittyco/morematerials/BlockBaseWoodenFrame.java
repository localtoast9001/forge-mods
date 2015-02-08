/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */
package de.shittyco.morematerials;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;

/**
 * Base class of all wooden frame variants.
 * @author jrowlett
 *
 */
public abstract class BlockBaseWoodenFrame extends WoodBlock {
    /**
     * The blocks registered id or name.
     */
    private final String id;

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
    @SideOnly(Side.CLIENT)
    private IIcon[] sideIcons;

    /**
     * The set of top and bottom icons for each wood type.
     */
    @SideOnly(Side.CLIENT)
    private IIcon[] woodIcons;

    /**
     * Initializes a new instance of the BlockBaseWoodenFrame class.
     * @param registeredBlockId registered name of the block.
     * @param unlocalizedName the base unlocalized name.
     * @param textureName the texture name for the sides.
     */
    protected BlockBaseWoodenFrame(
        final String registeredBlockId,
        final String unlocalizedName,
        final String textureName) {
        super(Material.wood);
        this.id = registeredBlockId;
        this.setHardness(HARDNESS);
        this.setResistance(RESISTANCE);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setStepSound(soundTypeWood);
        this.setBlockName(unlocalizedName);
        this.setBlockTextureName(textureName);
    }

    /**
     * Gets the block's texture. Args: side, meta
     * @param side the side to get the icon for.
     * @param meta the item metadata.
     * @return the icon to use for the side and meta.
     */
    @SideOnly(Side.CLIENT)
    public final IIcon getIcon(final int side, final int meta) {
        // top or bottom.
        if (side == 0 || side == 1) {
            return this.woodIcons[meta];
        }

        return this.sideIcons[meta];
    }

    /**
     * Registers the block icons.
     * @param iconRegister called back to register icons.
     */
    @SideOnly(Side.CLIENT)
    public final void registerBlockIcons(final IIconRegister iconRegister) {
        this.sideIcons = new IIcon[WoodUtility.WOOD_TYPE_COUNT];
        this.woodIcons = new IIcon[WoodUtility.WOOD_TYPE_COUNT];

        for (int i = 0; i < this.sideIcons.length; i++) {
            this.sideIcons[i] = iconRegister.registerIcon(
                this.getTextureName() + "_" + WoodUtility.WOOD_TYPE_IDS[i]);
            this.woodIcons[i] = iconRegister.registerIcon(
                "planks_" + WoodUtility.WOOD_TYPE_IDS[i]);
        }
    }    
}
