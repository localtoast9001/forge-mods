/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */

package de.shittyco.morematerials;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

/**
 * A common base class for items which only have colored variants.
 * @author jrowlett
 *
 */
public abstract class ColoredItem extends Item {

    /**
     * the base model name for each sub item.
     */
    private String modelName;

    /**
     * Initializes a new instance of the ColoredItem class.
     * @param unlocalizedName the unlocalized name to use.
     * @param baseModelName the base model name.
     */
    protected ColoredItem(
        final String unlocalizedName,
        final String baseModelName) {
        this.setHasSubtypes(true);
        this.setUnlocalizedName(unlocalizedName);
        this.modelName = baseModelName;
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
        final NonNullList<ItemStack> subItems) {
        for (int i = 0; i < ColorUtility.COLOR_COUNT; i++) {
            subItems.add(new ItemStack(item, 1, i));
        }
    }

    /**
     * Call on init to register the icons for inventory.
     * @param proxy the proxy to register the models.
     */
    public final void registerModels(final CommonProxy proxy) {
        ResourceLocation[] names = new ResourceLocation[ColorUtility.COLOR_COUNT];
        for (int i = 0; i < ColorUtility.COLOR_COUNT; i++) {
            String variantName = "morematerials:"
                + this.modelName
                + "_"
                + ColorUtility.COLOR_IDS[i];
            names[i] = new ResourceLocation(variantName);
            proxy.registerInventoryModel(
                this,
                this.modelName + "_" + ColorUtility.COLOR_IDS[i],
                i);
        }
        
        proxy.registerItemVariants(this, names);
    }
}
