/**
 * Copyright (C) Jon Rowlett. All rights reserved.
 */
package de.shittyco.morematerials;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;

/**
 * Base class for all roofing blocks.
 * @author jrowlett
 *
 */
public abstract class BlockRoofing extends BlockStairs {

    /**
     * Initializes a new instance of the BlockRoofing class.
     * @param blockState block state information from its cube form.
     */
    protected BlockRoofing(final IBlockState blockState) {
        super(blockState);
        this.useNeighborBrightness = true;
    }
}
