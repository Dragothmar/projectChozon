package dragothmar.chozon.registry;

import dragothmar.chozon.items.ChozonBaseItem;
import dragothmar.chozon.items.ItemPlasmaPistol;
import dragothmar.chozon.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Dragothmar on 4/27/2016.
 */
public class ChozonItems
{

    public static Item titanium;
    public static ItemPlasmaPistol plasmaPistol;

    public static void init()
    {
        titanium = new ChozonBaseItem().setUnlocalizedName("titanium");
//        plasmaPistol = new ItemPlasmaPistol().setUnlocalizedName("plasma_pistol");
        plasmaPistol = (ItemPlasmaPistol)new ItemPlasmaPistol().setUnlocalizedName("plasma_pistol");
    }

    public static void register()
    {
        GameRegistry.register(titanium, new ResourceLocation("chozon:" + titanium.getUnlocalizedName().substring(5)));
        GameRegistry.register(plasmaPistol, new ResourceLocation("chozon:" + plasmaPistol.getUnlocalizedName().substring(5)));
    }

    public static void registerRenders()
    {
        registerRender(titanium);
        registerRender(plasmaPistol);
    }

    public static void registerRender(Item item)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(
                item,
                0,
                new ModelResourceLocation(
                        Reference.MODID + ":" + item.getUnlocalizedName().substring(5),
                        "inventory"
                )
        );
    }

    public static void registerPlasmaPistolItemVariants()
    {
        ModelBakery.registerItemVariants(plasmaPistol, new ResourceLocation(Reference.MODID + ":plasma_pistol"));
        for( int stage = 0; stage < 4; stage++ )
        {
            ModelBakery.registerItemVariants(plasmaPistol, new ResourceLocation(Reference.MODID + ":" + plasmaPistol.plasmaPistolChargeIconNameArray[stage]));
        }
    }
}
