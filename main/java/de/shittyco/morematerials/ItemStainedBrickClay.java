package de.shittyco.morematerials;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemStainedBrickClay extends ColoredItem {	
	public static final String ID = "stained_brickclay";
	
	private static final String NAME = "stainedBrickClay";
		
	public ItemStainedBrickClay()
	{
		super(NAME, "morematerials:stainedbrickclay");
		setCreativeTab(CreativeTabs.tabMaterials);
	}
}
