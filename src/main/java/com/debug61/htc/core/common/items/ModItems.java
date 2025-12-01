package com.debug61.galaxyadditions.core.common.items;

import com.debug61.galaxyadditions.HiTechContent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {
    public static void initItems() {

        ModItems.registerItems();
    }

    public static void registerItem(Item item) {
        String name = item.getTranslationKey().substring(5);
        if(item.getTranslationKey() == null) {
            item.setRegistryName(name);
        }
    }

    public static void registerItems(IForgeRegistry<Item> registry)
    {
        for (ItemStack item : HiTechContent.itemList)
        {
            registry.register(item.getItem());
        }
    }

    public static void registerItems() {
    }
}
