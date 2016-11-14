package dragothmar.chozon.blocks;

import dragothmar.chozon.core.CreativeTab;
import dragothmar.chozon.registry.ChozonBlocks;
import dragothmar.chozon.registry.ChozonItems;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by Dragothmar on 4/26/2016.
 */
public class ChozonBaseBlockOre extends ChozonBaseBlock {


    public ChozonBaseBlockOre()
    {
        this(Material.ROCK.getMaterialMapColor());
    }

    public ChozonBaseBlockOre(MapColor mapColor) {
        super(Material.ROCK, mapColor);
        this.setHardness(1.0f);
        this.setHarvestLevel("pickaxe", 1);
        this.setCreativeTab(CreativeTab.instance);
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return this == ChozonBlocks.titanium_ore ? ChozonItems.titanium : Item.getItemFromBlock(this);
    }

    /**
     * Get the quantity dropped based on the given fortune level
     */
    public int quantityDroppedWithBonus(int fortune, Random random)
    {
        if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped(this.getBlockState().getValidStates().iterator().next(), random, fortune))
        {
            int i = random.nextInt(fortune + 2) - 1;

            if (i < 0)
            {
                i = 0;
            }

            return this.quantityDropped(random) * (i + 1);
        }
        else
        {
            return this.quantityDropped(random);
        }
    }


    @Override
    public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
        Random rand = world instanceof World ? ((World)world).rand : new Random();
        if (this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this))
        {
            int i = 0;

            if (this == ChozonBlocks.titanium_ore)
            {
                i = MathHelper.getRandomIntegerInRange(rand, 7, 9);
            }

            return i;
        }
        return 0;
    }
}
