package com.debug61.galaxyadditions;

import com.debug61.galaxyadditions.core.common.CommonProxy;
import com.debug61.galaxyadditions.core.common.blocks.ModBlocks;
import com.debug61.galaxyadditions.core.common.items.ModItems;
import com.debug61.galaxyadditions.core.common.util.ModCreativeTab;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;

@Mod(modid = Tags.MOD_ID, name = Tags.MOD_NAME, version = Tags.VERSION)
public class HiTechContent {

    public static final String CLIENT_PROXY_CLASS = "com.debug61.htc.core.client.ClientProxy";
    public static final String SERVER_PROXY_CLASS = "com.debug61.htc.core.common.CommonProxy";

    @SidedProxy(serverSide = SERVER_PROXY_CLASS, clientSide = CLIENT_PROXY_CLASS)
    public static CommonProxy proxy;

    public static ModCreativeTab modCreativeTab;

    public static LinkedList<ItemStack> itemList = new LinkedList<>();
    public static LinkedList<Block> blockList = new LinkedList<>();



    public static final Logger LOGGER = LogManager.getLogger(Tags.MOD_NAME);

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        HiTechContent.proxy.preInit(event);
        LOGGER.info("Loaded successfully: {}", Tags.MOD_NAME);
        HiTechContent.modCreativeTab = new ModCreativeTab(CreativeTabs.getNextID(), "htc_items", null);

        ModBlocks.initBlocks();
        ModItems.initItems();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        HiTechContent.proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        HiTechContent.proxy.postInit(event);
    }

    @Mod.EventBusSubscriber(modid = Tags.MOD_ID)
    public static class RegistrationHandler {
        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
            ModBlocks.registerBlocks(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            ModItems.registerItems(event.getRegistry());
        }
    }

}
