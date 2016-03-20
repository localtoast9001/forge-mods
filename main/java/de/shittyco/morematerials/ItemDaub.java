/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */
package de.shittyco.morematerials;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

/**
 * Mixture of dirt, sand, clay, and straw used
 * in wattle and daub walls in timber frames.
 * @author jrowlett
 *
 */
public class ItemDaub extends Item {

    /**
     * ID used in the game registry.
     */
    public static final String ID = "daub";

    /**
     * unlocalized name.
     */
    private static final String NAME = "daub";

    /**
     * Initializes a new instance of the ItemDaub class.
     */
    public ItemDaub() {
        setUnlocalizedName(NAME);
        setCreativeTab(CreativeTabs.tabMaterials);
    }

    /**
     * Called whenever this item is equipped and
     * the right mouse button is pressed.
     * @param itemStack the stack in hand.
     * @param world reference to the world.
     * @param entityPlayer the player.
     * @return the modified item stack.
     */
    @Override
    public final ItemStack onItemRightClick(
        final ItemStack itemStack,
        final World world,
        final EntityPlayer entityPlayer) {
        MovingObjectPosition movingobjectposition =
            this.getMovingObjectPositionFromPlayer(world, entityPlayer, true);
        if (movingobjectposition == null) {
            return itemStack;
        }

        if (movingobjectposition.typeOfHit
            == MovingObjectPosition.MovingObjectType.BLOCK) {
            BlockPos targetBlockPos = movingobjectposition.getBlockPos();
            IBlockState targetBlockState = world.getBlockState(targetBlockPos);
            Block targetBlock = targetBlockState.getBlock();
            if (targetBlock instanceof BlockWattlePanel) {
                IBlockState newState
                    = MoreMaterialsMod.getWattleAndDaub().getDefaultState();
                world.setBlockState(targetBlockPos, newState);
                if (!entityPlayer.capabilities.isCreativeMode) {
                    itemStack.stackSize--;
                }
            }
        }

        return itemStack;
    }
}
