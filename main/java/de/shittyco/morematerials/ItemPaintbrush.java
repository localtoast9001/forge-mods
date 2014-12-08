/**
 * 
 */
package de.shittyco.morematerials;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * @author jrowlett
 *
 */
public class ItemPaintbrush extends Item {
	
	public static final String ID = "paintbrush";
	
	private static final String NAME = "paintbrush";

	public ItemPaintbrush()
	{
		setUnlocalizedName(NAME);
		setTextureName("morematerials:paintbrush");
		setMaxStackSize(1);
		setMaxDamage(32);
		setCreativeTab(CreativeTabs.tabTools);
	}
}
