package dragothmar.chozon;

//import dragothmar.chozon.registry.ChozonItems;
import dragothmar.chozon.registry.*;
import dragothmar.chozon.common.CommonProxy;
import dragothmar.chozon.client.ClientProxy;
import dragothmar.chozon.server.ServerProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Dragothmar on 4/20/2016.
 */
@Mod(modid = Chozon.MODID, version = Chozon.VERSION, name = Chozon.MOD_NAME)
public class Chozon
{
    public static final String MODID = "chozon";
    public static final String MOD_NAME = "Project Chozon";
    public static final String VERSION = "${version}";

    @Mod.Instance(MODID)
    public static Chozon instance = new Chozon();
//    @Nonnull
//    private static final Chozon INSTANCE = new Chozon();


//    @Nonnull
//    @Mod.InstanceFactory
//    public static Chozon instance()
//    {
//        return INSTANCE;
//    }

//    @EventHandler
//    public void preInit(final FMLPreInitializationEvent event)
//    {
//        // Read configs
//        CreativeTab.registry();
//        // Create blocks/items
//        RegisterBootstrap.register();   // register blocks/items
//        // Register
//        CommonProxy.proxy.preInit(event);
//    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        //CreativeTab.init();
        RegisterBootstrap.register();
        CommonProxy.proxy.preInit(event);
        System.out.println("DIRT BLOCK PRE >> "+ Blocks.DIRT.getUnlocalizedName());

    }

    @Mod.EventHandler
    public void init(final FMLInitializationEvent event)
    {
        // Build data structures
        // Add crafting recipes
        // Register new handlers
        CommonProxy.proxy.init(event); // register block/item renderers
        System.out.println("DIRT BLOCK INIT >> "+ Blocks.DIRT.getUnlocalizedName());
    }

    @EventHandler
    public void postinit(final FMLPostInitializationEvent event)
    {
        // Communicate with other mods
        // Adjust setup
        System.out.println("DIRT BLOCK POST >> "+ Blocks.DIRT.getUnlocalizedName());
    }

    public static CreativeTabs creativeTab = new CreativeTabs(MODID)
    {
        @Override
        public Item getTabIconItem()
        {
            return null;
        }
        @Override
        public ItemStack getIconItemStack()
        {
            return new ItemStack(ChozonItems.titanium);
        }
    };
}
