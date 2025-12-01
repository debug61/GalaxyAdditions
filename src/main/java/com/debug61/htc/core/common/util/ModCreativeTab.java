package com.debug61.galaxyadditions.core.common.util;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

public class ModCreativeTab extends CreativeTabs {

    private ItemStack itemIcon;
    public ModCreativeTab(int index, String label, ItemStack itemIcon) {
        super(index, label);
        this.itemIcon = itemIcon;
    }

    @Nonnull
    @Override
    @SideOnly(Side.CLIENT)
    public ItemStack createIcon() {
        return this.itemIcon;
    }

    public void setItemIcon(ItemStack itemIcon) {
        this.itemIcon = itemIcon;
    }

    @Nonnull
    @Override
    @SideOnly(Side.CLIENT)
    public String getTranslationKey() {
        return "item_group." + this.getTabLabel();
    }

    @Override
    public void displayAllRelevantItems(NonNullList<ItemStack> list) {
        super.displayAllRelevantItems(list);
    }
}
