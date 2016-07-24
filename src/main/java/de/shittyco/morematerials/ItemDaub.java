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
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
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
        setCreativeTab(CreativeTabs.MATERIALS);
    }

    /**
     * Called whenever this item is equipped and
     * the right mouse button is pressed.
     * @param itemStackIn the stack in hand.
     * @param world reference to the world.
     * @param entityPlayer the player.
     * @return the modified item stack.
     */
    @Override
    public final ActionResult<ItemStack> onItemRightClick(
        final ItemStack itemStackIn,
        final World world,
        final EntityPlayer entityPlayer,
        EnumHand hand) {
        RayTraceResult movingobjectposition =
            this.rayTrace(world, entityPlayer, true);
        if (movingobjectposition == null) {
            return new ActionResult(EnumActionResult.PASS, itemStackIn);
        }

        if (movingobjectposition.typeOfHit
            == RayTraceResult.Type.BLOCK) {
            BlockPos targetBlockPos = movingobjectposition.getBlockPos();
            IBlockState targetBlockState = world.getBlockState(targetBlockPos);
            Block targetBlock = targetBlockState.getBlock();
            if (targetBlock instanceof BlockWattlePanel) {
                IBlockState newState
                    = MoreMaterialsMod.getWattleAndDaub().getDefaultState();
                world.setBlockState(targetBlockPos, newState);
                if (!entityPlayer.capabilities.isCreativeMode) {
                    itemStackIn.stackSize--;
                }
            }
        }

        return new ActionResult(EnumActionResult.PASS, itemStackIn);
    }
}
