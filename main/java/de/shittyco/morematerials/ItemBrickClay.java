package de.shittyco.morematerials;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Item for a composite clay mixed with dirt and sand that
 * can be smelted into bricks.
 * @author jrowlett
 *
 */
public class ItemBrickClay extends Item {
	
	public static final String ID = "brickclay";

	private static final String NAME = "brickClay";
		
	public ItemBrickClay()
	{
		setUnlocalizedName(NAME);
		setTextureName("morematerials:brickclay");
		setCreativeTab(CreativeTabs.tabMaterials);
	}	
}
