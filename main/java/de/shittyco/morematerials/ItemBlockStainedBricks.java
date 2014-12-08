package de.shittyco.morematerials;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockStainedBricks extends ItemBlock {
	
	public static final String ID = "block_stained_bricks";
	
	public ItemBlockStainedBricks(Block block) {
		super(block);
		setHasSubtypes(true);
	}

	@Override
	public int getMetadata (int damageValue) 
	{
		return damageValue;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
    	int damage = itemStack.getItemDamage();
        return super.getUnlocalizedName() + "." + ColorUtility.COLOR_NAMES[damage];
	}	
}
