package com.djnightmares.voidskills;

import com.djnightmares.voidskills.furnace.BlockPoweredFurnace;
import com.djnightmares.voidskills.proxys.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFurnace;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.Logger;

@Mod(
        modid = Voidskills.MOD_ID,
        name = Voidskills.MOD_NAME,
        version = Voidskills.VERSION,
        dependencies = "required-after:forge@[14.23.5.2855]"
)
public class Voidskills {

    public static final String MOD_ID = "dj-voidskills";
    public static final String MOD_NAME = "VoidSkills";
    public static final String VERSION = "0.0.1";

    @SidedProxy(clientSide = "com.djnightmares.voidskills.proxys.ClientProxy", serverSide = "com.djnightmares.voidskills.proxys.ServerProxy")
    public static CommonProxy proxy;

    public static CreativeTabs creativeTabs = new CreativeTabs("VoidSkills") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.blockPoweredFurnace);
        }
    };

    /**
     * This is the instance of your mod as created by Forge. It will never be null.
     */
    @Mod.Instance(MOD_ID)
    public static Voidskills INSTANCE;
    public static Logger logger;

    /**
     * This is the first initialization event. Register tile entities here.
     * The registry events below will have fired prior to entry to this method.
     */
    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);

    }

    /**
     * This is the second initialization event. Register custom recipes
     */
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }

    /**
     * This is the final initialization event. Register actions from other mods here
     */
    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {

    }

    /**
     * Forge will automatically look up and bind blocks to the fields in this class
     * based on their registry name.
     */
    @GameRegistry.ObjectHolder(MOD_ID)
    public static class Blocks {
      /*
          public static final MySpecialBlock mySpecialBlock = null; // placeholder for special block below
      */
    }

    /**
     * Forge will automatically look up and bind items to the fields in this class
     * based on their registry name.
     */
    @GameRegistry.ObjectHolder(MOD_ID)
    public static class Items {
      /*
          public static final ItemBlock mySpecialBlock = null; // itemblock for the block above
          public static final MySpecialItem mySpecialItem = null; // placeholder for special item below
      */
    }

    /**
     * This is a special class that listens to registry events, to allow creation of mod blocks and items at the proper time.
     */
    @Mod.EventBusSubscriber
    public static class ObjectRegistryHandler {
        /**
         * Listen for the register event for creating custom items
         */
        @SubscribeEvent
        public static void addItems(RegistryEvent.Register<Item> event) {
           /*
             event.getRegistry().register(new ItemBlock(Blocks.myBlock).setRegistryName(MOD_ID, "myBlock"));
             event.getRegistry().register(new MySpecialItem().setRegistryName(MOD_ID, "mySpecialItem"));
            */
        }

        /**
         * Listen for the register event for creating custom blocks
         */
        @SubscribeEvent
        public static void addBlocks(RegistryEvent.Register<Block> event) {
           /*
             event.getRegistry().register(new MySpecialBlock().setRegistryName(MOD_ID, "mySpecialBlock"));
            */
        }
    }
    /* EXAMPLE ITEM AND BLOCK - you probably want these in separate files
    public static class MySpecialItem extends Item {

    }

    public static class MySpecialBlock extends Block {

    }
    */
}
