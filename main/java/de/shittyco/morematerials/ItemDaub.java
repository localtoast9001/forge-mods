/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */
package de.shittyco.morematerials;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
        setTextureName("morematerials:daub");
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
            Block targetBlock = world.getBlock(
                movingobjectposition.blockX,
                movingobjectposition.blockY,
                movingobjectposition.blockZ);
            if (targetBlock instanceof BlockWattlePanel) {
                world.setBlock(
                    movingobjectposition.blockX,
                    movingobjectposition.blockY,
                    movingobjectposition.blockZ,
                    MoreMaterialsMod.getWattleAndDaub());
                if (!entityPlayer.capabilities.isCreativeMode) {
                    itemStack.stackSize--;
                }
            }
        }

        return itemStack;
    }
}
