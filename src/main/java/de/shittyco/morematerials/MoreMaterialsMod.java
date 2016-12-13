/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */

package de.shittyco.morematerials;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

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
    public static final String VERSION = "1.10.2-1.9.20160723.0";

    /**
     * Gets created by FML to specialize client vs. server calls.
     */
    @SidedProxy(
        clientSide = "de.shittyco.morematerials.ClientProxy",
        serverSide = "de.shittyco.morematerials.ServerProxy")
    public static CommonProxy proxy;

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
     * Stained brick walls for registration.
     */
    private static BlockStainedBrickWall[] stainedBrickWallBlocks;

    /**
     * Brick wall block for registration.
     */
    private static BlockBrickWall brickWall;

    /**
     * Stained hardened clay wall blocks.
     */
    private static BlockStainedHardenedClayWall[] stainedHardenedClayWallBlocks;

    /**
     * The daub item.
     */
    private static ItemDaub daub;

    /**
     * The wattle panel block.
     */
    private static BlockWattlePanel wattlePanel;

    /**
     * The wattle and daub block.
     */
    private static BlockWattleAndDaub wattleAndDaub;

    /**
     * Static wooden frame block for registration.
     */
    private static BlockWoodenFrame woodenFrame;

    /**
     * Static cross wooden frame block for registration.
     */
    private static BlockCrossWoodenFrame crossWoodenFrame;

    /**
     * Static slash wooden frame block for registration.
     */
    private static BlockSlashWoodenFrame slashWoodenFrame;

    /**
     * Static backslash wooden frame for registration.
     */
    private static BlockBackslashWoodenFrame backslashWoodenFrame;

    /**
     * Thatched roofing block for registration.
     */
    private static BlockThatchedRoofing thatchedRoofing;

    /**
     * Hardened class wall block for registration.
     */
    private static BlockHardenedClayWall hardenedClayWall;

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
     * Wall quantity in crafting.
     */
    private static final int WALL_QUANTITY = 6;

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
     * Thatched roof quantity for crafting.
     */
    private static final int THATCHED_ROOF_QUANTITY = 3;

    /**
     * Crafting quantity for wattle panel.
     */
    private static final int WATTLE_PANEL_QUANTITY = 8;

    /**
     * Gets the wattle and daub block.
     * @return the block.
     */
    public static BlockWattleAndDaub getWattleAndDaub() {
        return wattleAndDaub;
    }

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
        this.initRoofing();
        this.initHardenedClay();
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
     * Adds wall recipes for a block.
     * @param result result block
     * @param resultMetadata result metadata or 0.
     * @param source source block
     * @param sourceMetadata source metadata or 0.
     */
    private static void addWallRecipe(
        final BlockGenericWall result,
        final int resultMetadata,
        final Block source,
        final int sourceMetadata) {
        ItemStack resultStack = new ItemStack(
            result,
            WALL_QUANTITY,
            resultMetadata);
        ItemStack sourceStack = new ItemStack(
            source,
            1,
            sourceMetadata);
        GameRegistry.addRecipe(
            resultStack,
            "xxx", "xxx", "   ",
            'x', sourceStack);
        GameRegistry.addRecipe(
            resultStack,
            "   ", "xxx", "xxx",
            'x', sourceStack);
    }

    /**
     * Registers the item and sets its registry name.
     * @param item The item to register.
     * @param itemId The registry name for the item.
     */
    private void registerItem(
        Item item,
        String itemId) {
        item.setRegistryName(new ResourceLocation(MODID, itemId));
        GameRegistry.register(item);
    }

    /**
     * Sets the block's registry name and registers it.
     * @param block The block to register.
     * @param blockId The id of the block.
     */
    private void registerBlock(
        Block block,
        String blockId) {
        this.registerBlock(block, new ItemBlock(block), blockId);
    }

    private void registerBlock(
        Block block,
        ItemBlock itemBlock,
        String blockId) {
        ResourceLocation registryName = new ResourceLocation(MODID, blockId);
        block.setRegistryName(registryName);
        itemBlock.setRegistryName(registryName);
        GameRegistry.register(block);
        GameRegistry.register(itemBlock);
    }

    /**
     * Initializes tool items.
     */
    private void initTools() {
        paintbrush = new ItemPaintbrush();
        this.registerItem(paintbrush, ItemPaintbrush.ID);
        proxy.registerInventoryModel(paintbrush, ItemPaintbrush.ID, 0);
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
        stainedBrickWallBlocks =
                new BlockStainedBrickWall[ColorUtility.COLOR_COUNT];

        this.registerItem(brickClay, ItemBrickClay.ID);
        proxy.registerInventoryModel(brickClay, ItemBrickClay.ID, 0);

        this.registerItem(stainedBrickClay, ItemStainedBrickClay.ID);
        this.registerItem(stainedBrick, ItemStainedBrick.ID);
        stainedBrickClay.registerModels(proxy);
        stainedBrick.registerModels(proxy);

        this.registerBlock(
            stainedBrickBlocks,
            new ItemBlockStainedBricks(stainedBrickBlocks),
            BlockStainedBricks.ID);
        stainedBrickBlocks.registerModels(proxy);

        brickWall = new BlockBrickWall();
        this.registerBlock(
            brickWall,
            BlockBrickWall.ID);
        brickWall.registerModels(proxy);
        addWallRecipe(brickWall, 0, Blocks.BRICK_BLOCK, 0);

        for (int i = 0; i < ColorUtility.COLOR_COUNT; i++) {
            BlockHalfStainedBrickSlab slab = new BlockHalfStainedBrickSlab(i);
            BlockDoubleStainedBrickSlab doubleSlab =
                new BlockDoubleStainedBrickSlab(i);
            stainedBrickSlabBlocks[2 * i] = slab;
            stainedBrickSlabBlocks[2 * i + 1] = doubleSlab;
            this.registerBlock(
                slab,
                new ItemBlockStainedBrickSlab(
                    slab,
                    slab,
                    doubleSlab,
                    false),
                slab.getId());
            this.registerBlock(
                doubleSlab,
                new ItemBlockStainedBrickSlab(
                    doubleSlab,
                    slab,
                    doubleSlab,
                    true),
                doubleSlab.getId());
            slab.registerModels(proxy);
            doubleSlab.registerModels(proxy);

            BlockStainedBrickStairs stairs = new BlockStainedBrickStairs(
                stainedBrickBlocks,
                i);
            this.registerBlock(stairs, stairs.getId());
            stairs.registerModels(proxy);
            addSlabRecipes(slab, 0, stainedBrickBlocks, i);
            addStairsRecipes(stairs, 0, stainedBrickBlocks, i);

            BlockStainedBrickWall wall = new BlockStainedBrickWall(
                stainedBrickBlocks,
                i);
            stainedBrickWallBlocks[i] = wall;
            this.registerBlock(wall, wall.getId());
            wall.registerModels(proxy);
            addWallRecipe(wall, 0, stainedBrickBlocks, i);
        }

        ItemStack clayStack = new ItemStack(Items.CLAY_BALL);
        ItemStack dirtStack = new ItemStack(Blocks.DIRT);
        ItemStack sandStack = new ItemStack(Blocks.SAND);
        ItemStack woolStack = new ItemStack(Blocks.WOOL);
        ItemStack stickStack = new ItemStack(Items.STICK);
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
            new ItemStack(Items.BRICK),
            SMELTINGXP);
        for (int i = 0; i < ColorUtility.COLOR_COUNT; i++) {
            ItemStack dye = new ItemStack(Items.DYE, 1, i);
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
        this.registerItem(daub, ItemDaub.ID);
        proxy.registerInventoryModel(daub, ItemDaub.ID, 0);

        wattlePanel = new BlockWattlePanel();
        this.registerBlock(
            wattlePanel,
            BlockWattlePanel.ID);
        wattlePanel.registerModels(proxy);

        wattleAndDaub = new BlockWattleAndDaub();
        this.registerBlock(
            wattleAndDaub,
            BlockWattleAndDaub.ID);
        wattleAndDaub.registerModels(proxy);

        woodenFrame = new BlockWoodenFrame();
        this.registerBlock(
            woodenFrame,
            new ItemBlockWoodenFrame(woodenFrame),
            BlockWoodenFrame.ID);
        woodenFrame.registerModels(proxy);

        crossWoodenFrame = new BlockCrossWoodenFrame();
        this.registerBlock(
            crossWoodenFrame,
            new ItemBlockWoodenFrame(crossWoodenFrame),
            BlockCrossWoodenFrame.ID);
        crossWoodenFrame.registerModels(proxy);

        slashWoodenFrame = new BlockSlashWoodenFrame();
        this.registerBlock(
            slashWoodenFrame,
            new ItemBlockWoodenFrame(slashWoodenFrame),
            BlockSlashWoodenFrame.ID);
        slashWoodenFrame.registerModels(proxy);

        backslashWoodenFrame = new BlockBackslashWoodenFrame();
        this.registerBlock(
            backslashWoodenFrame,
            new ItemBlockWoodenFrame(backslashWoodenFrame),
            BlockBackslashWoodenFrame.ID);
        backslashWoodenFrame.registerModels(proxy);

        this.initWattleAndDaubRecipes();
    }

    /**
     * Initializes recipes that use wattle and daub.
     */
    private void initWattleAndDaubRecipes() {
        ItemStack clayStack = new ItemStack(Items.CLAY_BALL);
        ItemStack dirtStack = new ItemStack(Blocks.DIRT);
        ItemStack sandStack = new ItemStack(Blocks.SAND);
        ItemStack stickStack = new ItemStack(Items.STICK);

        // switched from just wheat to include other fibrous material
        // that could be used that is available early in the game
        // making wooden frames a viable first or second survival
        // house.
        Object[] fiberObjects = new Object[] {
            new ItemStack(Items.WHEAT),
            new ItemStack(Items.REEDS),
            Blocks.SAPLING,
            new ItemStack(
                Blocks.TALLGRASS,
                1,
                BlockTallGrass.EnumType.GRASS.getMeta()),
            new ItemStack(
                Blocks.DOUBLE_PLANT,
                1,
                BlockDoublePlant.EnumPlantType.GRASS.getMeta())
            };

        ItemStack daubStack = new ItemStack(daub, DAUB_QUANTITY);
        ItemStack singleDaubStack = new ItemStack(daub);
        for (Object fiberObject : fiberObjects) {
            GameRegistry.addRecipe(
                daubStack,
                "wx",
                "yz",
                'w', clayStack,
                'x', dirtStack,
                'y', sandStack,
                'z', fiberObject);
        }

        for (int i = 0; i < WoodUtility.WOOD_TYPE_COUNT; i++) {
            ItemStack woodenFrameStack = new ItemStack(
                woodenFrame,
                WOODEN_FRAME_QUANTITY,
                i);
            ItemStack woodStack = new ItemStack(Blocks.PLANKS, 1, i);
            GameRegistry.addRecipe(
                woodenFrameStack,
                "xyx",
                "yzy",
                "xyx",
                'x', stickStack,
                'y', woodStack,
                'z', singleDaubStack);

            ItemStack sourceWoodenFrameStack = new ItemStack(
                woodenFrame,
                1,
                i);
            ItemStack crossWoodenFrameStack = new ItemStack(
                crossWoodenFrame,
                1,
                i);
            GameRegistry.addRecipe(
                crossWoodenFrameStack,
                "x x",
                " y ",
                "x x",
                'x', stickStack,
                'y', sourceWoodenFrameStack);

            ItemStack slashWoodenFrameStack = new ItemStack(
                slashWoodenFrame,
                1,
                i);
            GameRegistry.addRecipe(
                slashWoodenFrameStack,
                "  x",
                " x ",
                "y  ",
                'x', stickStack,
                'y', sourceWoodenFrameStack);
            ItemStack backslashWoodenFrameStack = new ItemStack(
                backslashWoodenFrame,
                1,
                i);
            GameRegistry.addRecipe(
                backslashWoodenFrameStack,
                "y  ",
                " x ",
                "  x",
                'x', stickStack,
                'y', sourceWoodenFrameStack);
        }

        // The wattle panel is a window of sticks.
        // If 6 glass blocks make 16 window panes then
        // 6 wood blocks make 16 wattle panels, and
        // 2 wood blocks make 4 sticks, then
        // 6 sticks make 8 wattle panels.
        GameRegistry.addRecipe(
            new ItemStack(wattlePanel, WATTLE_PANEL_QUANTITY),
            "   ",
            "xxx",
            "xxx",
            'x', stickStack);

        // allow wattle and daub to be crafted.
        GameRegistry.addShapelessRecipe(
            new ItemStack(wattleAndDaub),
            new ItemStack(wattlePanel),
            new ItemStack(daub));
    }

    /**
     * Initializes roofing blocks.
     */
    private void initRoofing() {
        thatchedRoofing = new BlockThatchedRoofing();
        this.registerBlock(
            thatchedRoofing,
            BlockThatchedRoofing.ID);
        thatchedRoofing.registerModels(proxy);

        ItemStack thatchedRoofingStack = new ItemStack(
            thatchedRoofing,
            THATCHED_ROOF_QUANTITY,
            0);

        // switched from hay to wheat because it takes too long
        // to get enough wheat to make hay blocks and then too long
        // to produce enough wheat to make a decent sized roof.
        // A player will be tempted to use stairs or wood for the
        // roof.
        ItemStack wheatStack = new ItemStack(Items.WHEAT, 1, 0);
        GameRegistry.addShapedRecipe(
            thatchedRoofingStack,
            "  x",
            " xx",
            "xxy",
            'x', wheatStack,
            'y', Blocks.PLANKS);
    }

    /**
     * Initializes hardened clay blocks.
     */
    private void initHardenedClay() {
        hardenedClayWall = new BlockHardenedClayWall();
        this.registerBlock(
            hardenedClayWall,
            BlockHardenedClayWall.ID);
        hardenedClayWall.registerModels(proxy);
        this.addWallRecipe(hardenedClayWall, 0, Blocks.HARDENED_CLAY, 0);

        stainedHardenedClayWallBlocks =
            new BlockStainedHardenedClayWall[ColorUtility.COLOR_COUNT];
        for (int i = 0; i < ColorUtility.COLOR_COUNT; i++) {
            BlockStainedHardenedClayWall block =
                new BlockStainedHardenedClayWall(i);
            stainedHardenedClayWallBlocks[i] = block;

            this.registerBlock(block, block.getId());
            block.registerModels(proxy);

            // NOTE: metadata for stained hardened clay is backwards.
            this.addWallRecipe(
                block,
                0,
                Blocks.STAINED_HARDENED_CLAY,
                ColorUtility.COLOR_COUNT - i - 1);
        }
    }
}
