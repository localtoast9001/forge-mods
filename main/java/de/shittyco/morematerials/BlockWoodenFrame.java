/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */
package de.shittyco.morematerials;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

/**
 * A wooden frame filled with wattle and daub.
 * @author jrowlett
 *
 */
public class BlockWoodenFrame extends BlockBaseWoodenFrame {
    /**
     * ID for the game registry.
     */
    public static final String ID = "wooden_frame_block";

    /**
     * Unlocalized name.
     */
    private static final String NAME = "woodenFrame";
    
    /**
     * Texture Name.
     */
    private static final String TEXTURE_NAME = "morematerials:woodenframe";

    /**
     * Initializes a new instance of the BlockWoodenFrame class.
     */
    public BlockWoodenFrame() {
        super(ID, NAME, TEXTURE_NAME);
    }
}
