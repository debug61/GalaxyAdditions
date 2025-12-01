package com.debug61.galaxyadditions.core.common.blocks;

import com.debug61.galaxyadditions.HiTechContent;
import com.debug61.galaxyadditions.Tags;
import com.debug61.galaxyadditions.core.common.items.ModItemBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks {

    public static Block advFruitPress;

    public static final Material machine = new Material(MapColor.IRON);

    public static void initBlocks() {
        ModBlocks.advFruitPress = new BlockAdvFruitPress("advfruitpress");

        ModBlocks.registerBlocks();
    }

    private static void setHarvestLevel(Block block, String toolClass, int level) {
        block.setHarvestLevel(toolClass, level);
    }

    public static void setHarvestLevels() {
        setHarvestLevel(ModBlocks.advFruitPress, "pickaxe", 4);
    }

    public static void register(String modid, Block block, Class<? extends ItemBlock> itemClass, Object... itemArgs) {
        String key = block.getTranslationKey().substring(5);
        ResourceLocation resourceLocation = new ResourceLocation(modid, key);
        if (block.getRegistryName() == null) {
            block.setRegistryName(resourceLocation);
        }
    }

    private static void registerBlock(Block block, Class<? extends ItemBlock> itemClass) {
        register(Tags.MOD_ID, block, itemClass);
    }

    public static void registerBlocks(IForgeRegistry<Block> registry) {
        for (Block block : HiTechContent.blockList) {
            registry.register(block);
        }
    }

    public static void registerBlocks() {
        registerBlock(ModBlocks.advFruitPress, ModItemBlocks.class);
    }
}
