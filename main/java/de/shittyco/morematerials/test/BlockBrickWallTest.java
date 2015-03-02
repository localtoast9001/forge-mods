/**
 * 
 */
package de.shittyco.morematerials.test;

import static org.junit.Assert.*;

import net.minecraft.block.Block;
import net.minecraft.block.BlockClay;
import net.minecraft.block.BlockWall;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Bootstrap;

import org.junit.Test;

import de.shittyco.morematerials.BlockBrickWall;

/**
 * @author jrowlett
 *
 */
public class BlockBrickWallTest {

    @Test
    public void testBlockState() {
        //Bootstrap.register();
        //BlockBrickWall target = new BlockBrickWall();
        Block inner = new BlockClay();
        Block target = new BlockWall(inner);
        IBlockState blockState = target.getDefaultState();
        String actual = blockState.toString();
        assertEquals("", actual);
    }

}
