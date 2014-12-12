/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */
package de.shittyco.morematerials;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

/**
 * A common base class for items which only have colored variants.
 * @author jrowlett
 *
 */
public abstract class ColoredItem extends Item {

    /**
     * the icons for each sub item.
     */
    private IIcon[] icons;

    /**
     * Initializes a new instance of the ColoredItem class.
     * @param unlocalizedName the unlocalized name to use.
     * @param baseTextureName the base texture name.
     */
    protected ColoredItem(
        final String unlocalizedName,
        final String baseTextureName) {
        this.setHasSubtypes(true);
        this.setUnlocalizedName(unlocalizedName);
        this.setTextureName(baseTextureName);
    }

    /**
     * Gets an icon index based on an item's damage value.
     * @param damage from the item stack.
     * @return the icon to render.
     */
    @SideOnly(Side.CLIENT)
    @Override
    public final IIcon getIconFromDamage(final int damage) {
        return this.icons[damage];
    }

    /**
     * Returns the unlocalized name of this item.
     * This version accepts an ItemStack so different stacks can have
     * different names based on their damage or NBT.
     * @param itemStack the item stack to use to determine the name.
     * @return unlocalized name string.
     */
    @Override
    public final String getUnlocalizedName(final ItemStack itemStack) {
        int damage = itemStack.getItemDamage();
        return super.getUnlocalizedName()
            + "."
            + ColorUtility.COLOR_NAMES[damage];
    }

    /**
     * returns a list of items with the same ID, but different meta
     * (eg: dye returns 16 items).
     * @param item the item to return.
     * @param tabs unused.
     * @param subItems gets populated with the item stack for each sub item.
     */
    @SideOnly(Side.CLIENT)
    @Override
    public final void getSubItems(
        final Item item,
        final CreativeTabs tabs,
        final List subItems) {
        for (int i = 0; i < ColorUtility.COLOR_COUNT; i++) {
            subItems.add(new ItemStack(item, 1, i));
        }
    }

    /**
     * registers the icons for the different sub types.
     * @param iconRegister the object that gets called to register the icons.
     */
    @SideOnly(Side.CLIENT)
    public final void registerIcons(final IIconRegister iconRegister) {
        this.icons = new IIcon[ColorUtility.COLOR_IDS.length];

        for (int i = 0; i < ColorUtility.COLOR_IDS.length; i++) {
            this.icons[i] = iconRegister.registerIcon(
                this.getIconString() + "_" + ColorUtility.COLOR_IDS[i]);
        }
    }
}
