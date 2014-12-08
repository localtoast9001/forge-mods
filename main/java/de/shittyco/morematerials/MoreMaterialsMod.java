/**
 * @author jrowlett
 */
package de.shittyco.morematerials;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * @author jrowlett
 *
 */
@Mod(modid = MoreMaterialsMod.MODID, version = MoreMaterialsMod.VERSION)
public class MoreMaterialsMod
{
    public static final String MODID = "morematerials";
    public static final String VERSION = "1.0";
    
    public static ItemBrickClay BRICKCLAY;
    public static ItemPaintbrush PAINTBRUSH;
    public static ItemStainedBrickClay STAINED_BRICKCLAY;
    public static ItemStainedBrick STAINED_BRICK;
    public static BlockStainedBricks STAINED_BRICK_BLOCK;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	BRICKCLAY = new ItemBrickClay();
    	PAINTBRUSH = new ItemPaintbrush();
    	STAINED_BRICKCLAY = new ItemStainedBrickClay();
    	STAINED_BRICK = new ItemStainedBrick();
    	STAINED_BRICK_BLOCK = new BlockStainedBricks();
    	
    	GameRegistry.registerItem(PAINTBRUSH, ItemPaintbrush.ID);
    	GameRegistry.registerItem(BRICKCLAY, ItemBrickClay.ID);
    	GameRegistry.registerItem(STAINED_BRICKCLAY, ItemStainedBrickClay.ID);
    	GameRegistry.registerItem(STAINED_BRICK, ItemStainedBrick.ID);
    	
    	GameRegistry.registerBlock(
    		STAINED_BRICK_BLOCK, 
    		ItemBlockStainedBricks.class,
    		BlockStainedBricks.ID);

    	ItemStack clayStack = new ItemStack(Items.clay_ball);
    	ItemStack dirtStack = new ItemStack(Blocks.dirt);
    	ItemStack sandStack = new ItemStack(Blocks.sand);
    	ItemStack woolStack = new ItemStack(Blocks.wool);
    	ItemStack stickStack = new ItemStack(Items.stick);
    	GameRegistry.addRecipe(
    			new ItemStack(BRICKCLAY, 8), 
    			"xy", "zx", 'x', clayStack, 'y', dirtStack, 'z', sandStack);
    	GameRegistry.addRecipe(
    			new ItemStack(PAINTBRUSH),
    			"x ", "y ", 'x', woolStack, 'y', stickStack);
    	GameRegistry.addSmelting(
    			BRICKCLAY, 
    			new ItemStack(Items.brick), 
    			0.1f);
    	for(int i=0; i < 16; i++)
    	{
    		ItemStack dye = new ItemStack(Items.dye, 1, i);
    		ItemStack brickClay = new ItemStack(BRICKCLAY, 1);
    		GameRegistry.addRecipe(
    			new ItemStack(STAINED_BRICKCLAY, 8, i),
    			"xxx", "xyx", "xxx", 'x', brickClay, 'y', dye);
    		
    		ItemStack stainedBrick = new ItemStack(STAINED_BRICK, 1, i);
    		ItemStack stainedBrickClay = new ItemStack(STAINED_BRICKCLAY, 1, i);
    		GameRegistry.addSmelting(
    				stainedBrickClay, 
    				stainedBrick, 
    				0.1f);
    		
    		ItemStack stainedBrickBlock = new ItemStack(STAINED_BRICK_BLOCK, 1, i);
    		GameRegistry.addRecipe(
    			stainedBrickBlock,
    			"xx", "xx", 'x', stainedBrick);
    	}
    }
}
