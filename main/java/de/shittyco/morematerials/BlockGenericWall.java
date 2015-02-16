/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */
package de.shittyco.morematerials;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * Customizable Wall block that supports different materials.
 * BlockWall in Minecraft is not extensible.
 * @author jrowlett
 *
 */
public abstract class BlockGenericWall extends BlockWall {
    /**
     * The block on which the wall is based.
     */
    private Block sourceBlock;

    /**
     * metadata on the source block.
     */
    private int sourceMetadata;

    /**
     * Initializes a new instance of the BlockGenericWall.
     * @param source the material the wall is made of.
     * @param sourceMeta the metadata for the source block.
     */
    protected BlockGenericWall(
        final Block source,
        final int sourceMeta) {
        super(source);
        this.sourceBlock = source;
        this.sourceMetadata = sourceMeta;
    }

    /**
     * Gets the block's texture. Args: side, meta
     * @param side the side to render.
     * @param meta the metadata for the block.
     * @return the icon to use.
     */
    @SideOnly(Side.CLIENT)
    @Override
    public final IIcon getIcon(final int side, final int meta) {
        return this.sourceBlock.getIcon(side, this.sourceMetadata);
    }

    /**
     * Return whether an adjacent block can connect to a wall.
     * @param blockAccess the block access interface.
     * @param x world coordinate.
     * @param y world coordinate.
     * @param z world coordinate.
     * @return whether a block can connect to the wall.
     */
    @Override
    public final boolean canConnectWallTo(
        final IBlockAccess blockAccess,
        final int x,
        final int y,
        final int z) {
        Block block = blockAccess.getBlock(
            x,
            y,
            z);

        if (BlockGenericWall.class.isAssignableFrom(block.getClass())
            || block == Blocks.fence_gate) {
            return true;
        }

        if (block.getMaterial().isOpaque()
            && block.renderAsNormalBlock()) {
            return block.getMaterial() != Material.gourd;
        }

        return false;
    }

    /**
     * returns a list of blocks with the same ID, but different meta
     * (eg: wood returns 4 blocks).
     * @param item the item for the block.
     * @param creativeTabs the creative tabs.
     * @param subBlocks the list to populate.
     */
    @SideOnly(Side.CLIENT)
    @Override
    public void getSubBlocks(
        final Item item,
        final CreativeTabs creativeTabs,
        final List subBlocks) {
    }

    /**
     * Determines if a torch can be placed on the top surface of this block.
     * Useful for creating your own block that torches can be on,
     * such as fences.
     *
     * @param world The current world
     * @param x X Position
     * @param y Y Position
     * @param z Z Position
     * @return True to allow the torch to be placed
     */
    @Override
    public final boolean canPlaceTorchOnTop(
        final World world,
        final int x,
        final int y,
        final int z) {
        return true;
    }
}
