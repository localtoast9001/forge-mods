/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */
package de.shittyco.morematerials;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStairs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Mod that adds more building materials to the game.
 * @author jrowlett
 *
 */
@Mod(modid = MoreMaterialsMod.MODID, version = MoreMaterialsMod.VERSION)
public class MoreMaterialsMod {

    /**
     * Mod ID.
     */
    public static final String MODID = "morematerials";

    /**
     * Mod Version.
     */
    public static final String VERSION = "1.0";

    /**
     * Static brick clay item for registration.
     */
    private static ItemBrickClay brickClay;

    /**
     * Static paintbrush item for registration.
     */
    private static ItemPaintbrush paintbrush;

    /**
     * Static stained brick clay item for registration.
     */
    private static ItemStainedBrickClay stainedBrickClay;

    /**
     * Static stained brick for registration.
     */
    private static ItemStainedBrick stainedBrick;

    /**
     * Static stained bricks block for registration.
     */
    private static BlockStainedBricks stainedBrickBlocks;

    /**
     * Stained brick slabs for registration.
     */
    private static BlockStainedBrickSlab[] stainedBrickSlabBlocks;

    /**
     * Item blocks for the stained brick slabs.
     */
    private static ItemSlab[] stainedBrickSlabItemBlocks;

    /**
     * The daub item.
     */
    private static ItemDaub daub;

    /**
     * Static wooden frame block for registration.
     */
    private static BlockWoodenFrame woodenFrame;

    /**
     * XP gained by smelting.
     */
    private static final float SMELTINGXP = 0.1f;

    /**
     * Stairs quantity in crafting.
     */
    private static final int STAIRS_QUANTITY = 4;

    /**
     * Slab quantity in crafting.
     */
    private static final int SLAB_QUANTITY = 6;

    /**
     * Brick quantity for crafting.
     */
    private static final int BRICK_QUANTITY = 8;

    /**
     * Daub quantity for crafting.
     */
    private static final int DAUB_QUANTITY = 5;

    /**
     * Wooden frame quantity for crafting.
     */
    private static final int WOODEN_FRAME_QUANTITY = 8;

    /**
     * Pre-initialization event handler.
     * @param event information provided by the mod loader.
     */
    @EventHandler
    public void preInit(final FMLPreInitializationEvent event) {
    }

    /**
     * Initialization event handler.
     * @param event information provided by the mod loader.
     */
    @EventHandler
    public final void init(final FMLInitializationEvent event) {
        this.initTools();
        this.initBricks();
        this.initWattleAndDaub();
    }

    /**
     * Adds the slab recipes to the registry.
     * @param result the result stack.
     * @param resultMetadata result metadata or 0.
     * @param source source block.
     * @param sourceMetadata source metadata or 0.
     */
    private static void addSlabRecipes(
        final BlockSlab result,
        final int resultMetadata,
        final Block source,
        final int sourceMetadata) {
        ItemStack resultStack = new ItemStack(
            result,
            SLAB_QUANTITY,
            resultMetadata);
        ItemStack sourceStack = new ItemStack(source, 1, sourceMetadata);
        GameRegistry.addRecipe(
            resultStack,
            "xxx", "   ", "   ",
            'x', sourceStack);
        GameRegistry.addRecipe(
            resultStack,
            "   ", "xxx", "   ",
            'x', sourceStack);
        GameRegistry.addRecipe(
            resultStack,
            "   ", "   ", "xxx",
            'x', sourceStack);
    }

    /**
     * Adds stairs recipes for a block.
     * @param result result block
     * @param resultMetadata result metadata or 0.
     * @param source source block
     * @param sourceMetadata source metadata or 0.
     */
    private static void addStairsRecipes(
        final BlockStairs result,
        final int resultMetadata,
        final Block source,
        final int sourceMetadata) {
        ItemStack resultStack = new ItemStack(
            result,
            STAIRS_QUANTITY,
            resultMetadata);
        ItemStack sourceStack = new ItemStack(
            source,
            1,
            sourceMetadata);
        GameRegistry.addRecipe(
            resultStack,
            "x  ", "xx ", "xxx",
            'x', sourceStack);
        GameRegistry.addRecipe(
            resultStack,
            "  x", " xx", "xxx",
            'x', sourceStack);
    }

    /**
     * Initializes tool items.
     */
    private void initTools() {
        paintbrush = new ItemPaintbrush();
        GameRegistry.registerItem(paintbrush, ItemPaintbrush.ID);
    }

    /**
     * Initializes brick related items and blocks.
     */
    private void initBricks() {
        brickClay = new ItemBrickClay();
        stainedBrickClay = new ItemStainedBrickClay();
        stainedBrick = new ItemStainedBrick();
        stainedBrickBlocks = new BlockStainedBricks();
        stainedBrickSlabBlocks =
            new BlockStainedBrickSlab[2 * ColorUtility.COLOR_COUNT];
        stainedBrickSlabItemBlocks =
            new ItemSlab[2 * ColorUtility.COLOR_COUNT];

        GameRegistry.registerItem(brickClay, ItemBrickClay.ID);
        GameRegistry.registerItem(stainedBrickClay, ItemStainedBrickClay.ID);
        GameRegistry.registerItem(stainedBrick, ItemStainedBrick.ID);

        GameRegistry.registerBlock(
                stainedBrickBlocks,
                ItemBlockStainedBricks.class,
                BlockStainedBricks.ID);

        for (int i = 0; i < ColorUtility.COLOR_COUNT; i++) {
            BlockStainedBrickSlab slab = new BlockStainedBrickSlab(false, i);
            BlockStainedBrickSlab doubleSlab =
                new BlockStainedBrickSlab(true, i);
            ItemSlab itemSlab = new ItemSlab(slab, slab, doubleSlab, false);
            ItemSlab itemDoubleSlab =
                new ItemSlab(doubleSlab, slab, doubleSlab, true);
            stainedBrickSlabBlocks[2 * i] = slab;
            stainedBrickSlabBlocks[2 * i + 1] = doubleSlab;
            stainedBrickSlabItemBlocks[2 * i] = itemSlab;
            stainedBrickSlabItemBlocks[2 * i + 1] = itemDoubleSlab;
            GameRegistry.registerBlock(
                slab,
                ItemBlockStainedBrickSlab.class,
                slab.getId(),
                slab,
                doubleSlab,
                false);
            GameRegistry.registerBlock(
                doubleSlab,
                ItemBlockStainedBrickSlab.class,
                doubleSlab.getId(),
                slab,
                doubleSlab,
                true);

            BlockStainedBrickStairs stairs = new BlockStainedBrickStairs(
                stainedBrickBlocks,
                i);
            GameRegistry.registerBlock(stairs, stairs.getId());
            addSlabRecipes(slab, 0, stainedBrickBlocks, i);
            addStairsRecipes(stairs, 0, stainedBrickBlocks, i);
        }

        ItemStack clayStack = new ItemStack(Items.clay_ball);
        ItemStack dirtStack = new ItemStack(Blocks.dirt);
        ItemStack sandStack = new ItemStack(Blocks.sand);
        ItemStack woolStack = new ItemStack(Blocks.wool);
        ItemStack stickStack = new ItemStack(Items.stick);
        GameRegistry.addRecipe(
            new ItemStack(brickClay, BRICK_QUANTITY),
            "xy", "zx",
            'x', clayStack,
            'y', dirtStack,
            'z', sandStack);
        GameRegistry.addRecipe(
            new ItemStack(paintbrush),
            "x ", "y ", 'x', woolStack, 'y', stickStack);
        GameRegistry.addSmelting(
            brickClay,
            new ItemStack(Items.brick),
            SMELTINGXP);
        for (int i = 0; i < ColorUtility.COLOR_COUNT; i++) {
            ItemStack dye = new ItemStack(Items.dye, 1, i);
            ItemStack brickClayStack = new ItemStack(brickClay, 1);
            GameRegistry.addRecipe(
                new ItemStack(stainedBrickClay, BRICK_QUANTITY, i),
                "xxx", "xyx", "xxx", 'x', brickClayStack, 'y', dye);

            ItemStack stainedBrickStack = new ItemStack(stainedBrick, 1, i);
            ItemStack stainedBrickClayStack = new ItemStack(
                stainedBrickClay,
                1,
                i);
            GameRegistry.addSmelting(
                stainedBrickClayStack,
                stainedBrickStack,
                SMELTINGXP);

            ItemStack stainedBrickBlock = new ItemStack(
                stainedBrickBlocks,
                1,
                i);
            GameRegistry.addRecipe(
                stainedBrickBlock,
                "xx", "xx", 'x', stainedBrickStack);
        }
    }

    /**
     * Inits wattle and daub items and blocks.
     */
    private void initWattleAndDaub() {
        daub = new ItemDaub();
        GameRegistry.registerItem(daub, ItemDaub.ID);

        woodenFrame = new BlockWoodenFrame();
        GameRegistry.registerBlock(
            woodenFrame,
            ItemBlockWoodenFrame.class,
            BlockWoodenFrame.ID);

        ItemStack clayStack = new ItemStack(Items.clay_ball);
        ItemStack dirtStack = new ItemStack(Blocks.dirt);
        ItemStack sandStack = new ItemStack(Blocks.sand);
        ItemStack strawStack = new ItemStack(Items.wheat);
        ItemStack stickStack = new ItemStack(Items.stick);

        ItemStack daubStack = new ItemStack(daub, DAUB_QUANTITY);
        ItemStack singleDaubStack = new ItemStack(daub);
        GameRegistry.addRecipe(
            daubStack,
            "wx",
            "yz",
            'w', clayStack,
            'x', dirtStack,
            'y', sandStack,
            'z', strawStack);

        for (int i = 0; i < WoodUtility.WOOD_TYPE_COUNT; i++) {
            ItemStack woodenFrameStack = new ItemStack(
                woodenFrame,
                WOODEN_FRAME_QUANTITY,
                i);
            ItemStack woodStack = new ItemStack(Blocks.planks, 1, i);
            GameRegistry.addRecipe(
                woodenFrameStack,
                "xyx",
                "yzy",
                "xyx",
                'x', stickStack,
                'y', woodStack,
                'z', singleDaubStack);
        }
    }
}
