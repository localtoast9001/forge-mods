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
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;
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
    public static final String VERSION = "1.0.20150301.0";

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
     * Initializes tool items.
     */
    private void initTools() {
        paintbrush = new ItemPaintbrush();
        GameRegistry.registerItem(paintbrush, ItemPaintbrush.ID);
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

        GameRegistry.registerItem(brickClay, ItemBrickClay.ID);
        proxy.registerInventoryModel(brickClay, ItemBrickClay.ID, 0);

        GameRegistry.registerItem(stainedBrickClay, ItemStainedBrickClay.ID);
        GameRegistry.registerItem(stainedBrick, ItemStainedBrick.ID);
        stainedBrickClay.registerModels(proxy);
        stainedBrick.registerModels(proxy);

        GameRegistry.registerBlock(
                stainedBrickBlocks,
                ItemBlockStainedBricks.class,
                BlockStainedBricks.ID);
        stainedBrickBlocks.registerModels(proxy);

        brickWall = new BlockBrickWall();
        GameRegistry.registerBlock(
            brickWall,
            BlockBrickWall.ID);
        brickWall.registerModels(proxy);
        addWallRecipe(brickWall, 0, Blocks.brick_block, 0);

        for (int i = 0; i < ColorUtility.COLOR_COUNT; i++) {
            BlockStainedBrickSlab slab = new BlockHalfStainedBrickSlab(i);
            BlockStainedBrickSlab doubleSlab =
                new BlockDoubleStainedBrickSlab(i);
            stainedBrickSlabBlocks[2 * i] = slab;
            stainedBrickSlabBlocks[2 * i + 1] = doubleSlab;
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
            slab.registerModels(proxy);
            doubleSlab.registerModels(proxy);

            BlockStainedBrickStairs stairs = new BlockStainedBrickStairs(
                stainedBrickBlocks,
                i);
            GameRegistry.registerBlock(stairs, stairs.getId());
            stairs.registerModels(proxy);
            addSlabRecipes(slab, 0, stainedBrickBlocks, i);
            addStairsRecipes(stairs, 0, stainedBrickBlocks, i);

            BlockStainedBrickWall wall = new BlockStainedBrickWall(
                stainedBrickBlocks,
                i);
            stainedBrickWallBlocks[i] = wall;
            GameRegistry.registerBlock(wall, wall.getId());
            wall.registerModels(proxy);
            addWallRecipe(wall, 0, stainedBrickBlocks, i);
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
        proxy.registerInventoryModel(daub, ItemDaub.ID, 0);

        woodenFrame = new BlockWoodenFrame();
        GameRegistry.registerBlock(
            woodenFrame,
            ItemBlockWoodenFrame.class,
            BlockWoodenFrame.ID);
        woodenFrame.registerModels(proxy);

        crossWoodenFrame = new BlockCrossWoodenFrame();
        GameRegistry.registerBlock(
            crossWoodenFrame,
            ItemBlockWoodenFrame.class,
            BlockCrossWoodenFrame.ID);
        crossWoodenFrame.registerModels(proxy);

        slashWoodenFrame = new BlockSlashWoodenFrame();
        GameRegistry.registerBlock(
            slashWoodenFrame,
            ItemBlockWoodenFrame.class,
            BlockSlashWoodenFrame.ID);
        slashWoodenFrame.registerModels(proxy);

        backslashWoodenFrame = new BlockBackslashWoodenFrame();
        GameRegistry.registerBlock(
                backslashWoodenFrame,
                ItemBlockWoodenFrame.class,
                BlockBackslashWoodenFrame.ID);
        backslashWoodenFrame.registerModels(proxy);

        ItemStack clayStack = new ItemStack(Items.clay_ball);
        ItemStack dirtStack = new ItemStack(Blocks.dirt);
        ItemStack sandStack = new ItemStack(Blocks.sand);
        ItemStack stickStack = new ItemStack(Items.stick);

        // switched from just wheat to include other fibrous material
        // that could be used that is available early in the game
        // making wooden frames a viable first or second survival
        // house.
        Object[] fiberObjects = new Object[] {
                new ItemStack(Items.wheat),
                new ItemStack(Items.reeds),
                Blocks.sapling,
                new ItemStack(
                    Blocks.tallgrass,
                    1,
                    BlockTallGrass.EnumType.GRASS.getMeta()),
                new ItemStack(
                    Blocks.double_plant,
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
            ItemStack woodStack = new ItemStack(Blocks.planks, 1, i);
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
    }

    /**
     * Initializes roofing blocks.
     */
    private void initRoofing() {
        thatchedRoofing = new BlockThatchedRoofing();
        GameRegistry.registerBlock(
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
        ItemStack wheatStack = new ItemStack(Items.wheat, 1, 0);
        GameRegistry.addShapedRecipe(
            thatchedRoofingStack,
            "  x",
            " xx",
            "xxy",
            'x', wheatStack,
            'y', Blocks.planks);
    }

    /**
     * Initializes hardened clay blocks.
     */
    private void initHardenedClay() {
        hardenedClayWall = new BlockHardenedClayWall();
        GameRegistry.registerBlock(
            hardenedClayWall,
            BlockHardenedClayWall.ID);
        hardenedClayWall.registerModels(proxy);
        this.addWallRecipe(hardenedClayWall, 0, Blocks.hardened_clay, 0);

        stainedHardenedClayWallBlocks =
            new BlockStainedHardenedClayWall[ColorUtility.COLOR_COUNT];
        for (int i = 0; i < ColorUtility.COLOR_COUNT; i++) {
            BlockStainedHardenedClayWall block =
                new BlockStainedHardenedClayWall(i);
            stainedHardenedClayWallBlocks[i] = block;

            GameRegistry.registerBlock(block, block.getId());
            block.registerModels(proxy);

            // NOTE: metadata for stained hardened clay is backwards.
            this.addWallRecipe(
                block,
                0,
                Blocks.stained_hardened_clay,
                ColorUtility.COLOR_COUNT - i - 1);
        }
    }
}
