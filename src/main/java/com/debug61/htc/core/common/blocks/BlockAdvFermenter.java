package com.debug61.galaxyadditions.core.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockAdvFermenter extends Block {

    public BlockAdvFermenter(Material materialIn) {
        super(Material.IRON);
        setRegistryName("fermenter");
        setTranslationKey("fermenter");
        setHardness(3.0F);
        setHarvestLevel("pickaxe", 1);
    }
}
