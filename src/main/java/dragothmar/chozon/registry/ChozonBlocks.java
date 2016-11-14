package dragothmar.chozon.registry;

import dragothmar.chozon.blocks.ChozonBaseBlock;
import dragothmar.chozon.blocks.ChozonBaseBlockOre;
import dragothmar.chozon.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Dragothmar on 4/26/2016.
 */
public class ChozonBlocks {

    public static Block titanium_ore;
    public static Block titanium_block;

    public static void init()
    {
        titanium_ore = new ChozonBaseBlockOre(MapColor.SILVER).setHardness(25.0f).setResistance(2500.0f).setUnlocalizedName("titanium_ore");
        titanium_ore.setHarvestLevel("pickaxe", 3);
        titanium_block = new ChozonBaseBlock(Material.IRON).setHardness(5.0f).setResistance(30.0f).setUnlocalizedName("titanium_block");
        titanium_block.setHarvestLevel("pickaxe", 3);
    }

    public static void register()
    {
        GameRegistry.register(titanium_ore, new ResourceLocation("chozon:" + titanium_ore.getUnlocalizedName().substring(5)));
        GameRegistry.register(titanium_block, new ResourceLocation("chozon:" + titanium_block.getUnlocalizedName().substring(5)));
    }

    public static void registerRenders()
    {
        registerRender(titanium_ore);
        registerRender(titanium_block);
    }

    public static void registerRender(Block block)
    {
        Item item = Item.getItemFromBlock(block);
        System.out.println("CHECKING REGISTER_RENDER---------------------------------------");
        System.out.println("FAILING BLOCK ITEM: " + block.toString());
        if (item != null)
            System.out.println("FAILING ITEM: " + item.toString());
        else
            System.out.println("NULL: " + item == null);



        System.out.println("CHECKING REGISTER_RENDER---------------------------------------");
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(
                item,
                0,
                new ModelResourceLocation(
                        Reference.MODID + ":" + item.getUnlocalizedName().substring(5),
                        "inventory"
                        )
        );
    }

}
