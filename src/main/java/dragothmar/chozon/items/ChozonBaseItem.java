package dragothmar.chozon.items;

import dragothmar.chozon.Chozon;
import dragothmar.chozon.core.CreativeTab;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by Dragothmar on 4/27/2016.
 */
public class ChozonBaseItem extends Item {

    public ChozonBaseItem() {
        super();
        this.setNoRepair();
        this.setCreativeTab(Chozon.creativeTab);
    }

    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return false;
    }
}
