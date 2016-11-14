package dragothmar.chozon.core;

import dragothmar.chozon.registry.ChozonBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by Dragothmar on 4/27/2016.
 */
public class CreativeTab  extends CreativeTabs
{
    public static CreativeTab instance = null;

    private CreativeTab()
    {
        super("chozon");
        this.setBackgroundImageName("chozon.png");
    }

    static void init()
    {
        if (instance == null)
            instance = new CreativeTab();
    }

    @Override
    public Item getTabIconItem() {
        return Item.getItemFromBlock(ChozonBlocks.titanium_ore);
    }
}
