package de.shittyco.morematerials;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;

/**
 * A common base class for items which only have colored variants.
 * @author jrowlett
 *
 */
public abstract class ColoredItem extends Item{

	private IIcon[] icons;
	
	protected ColoredItem(
		String unlocalizedName,
		String baseTextureName)
	{
		this.setHasSubtypes(true);
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(baseTextureName);
	}
	
    /**
     * Gets an icon index based on an item's damage value
     */
    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIconFromDamage(int damage)
    {
        return this.icons[damage];
    }

    /**
     * Returns the unlocalized name of this item. This version accepts an ItemStack so different stacks can have
     * different names based on their damage or NBT.
     */
    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
    	int damage = itemStack.getItemDamage();
        return super.getUnlocalizedName() + "." + ColorUtility.COLOR_NAMES[damage];
    }

    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(Item item, CreativeTabs tabs, List subItems)
    {
        for (int i = 0; i < 16; i++)
        {
            subItems.add(new ItemStack(item, 1, i));
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        this.icons = new IIcon[ColorUtility.COLOR_IDS.length];

        for (int i = 0; i < ColorUtility.COLOR_IDS.length; i++)
        {
            this.icons[i] = iconRegister.registerIcon(
            		this.getIconString() + "_" + ColorUtility.COLOR_IDS[i]);
        }
    }	
}
