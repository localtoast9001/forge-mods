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

public class ItemStainedBrick extends ColoredItem {

	public static final String ID = "stained_brick";
	
	private static final String NAME = "stainedBrick";
	
	public ItemStainedBrick()
	{
		super(NAME, "morematerials:stainedbrick");
		setCreativeTab(CreativeTabs.tabMaterials);
	}	
}
