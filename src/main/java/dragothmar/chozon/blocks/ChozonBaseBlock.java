package dragothmar.chozon.blocks;


import dragothmar.chozon.core.CreativeTab;
import dragothmar.chozon.registry.ChozonBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

/**
 * Created by Dragothmar on 4/26/2016.
 */
public class ChozonBaseBlock extends Block {


    public ChozonBaseBlock(Material materialIn) {
        this(materialIn, materialIn.getMaterialMapColor());
        this.setHardness(2.0f);
        this.setLightOpacity(255);
        this.setHarvestLevel("pickaxe", 0);
        this.setCreativeTab(CreativeTab.instance);
    }

    protected ChozonBaseBlock(Material materialIn, MapColor mapColor) {
        super(materialIn, mapColor);

        if (materialIn == Material.GLASS)
        {
            this.setSoundType(SoundType.GLASS);
        }
        else if (materialIn == Material.ROCK)
        {
            this.setSoundType(SoundType.STONE);
        }
        else if (materialIn == Material.WOOD)
        {
            this.setSoundType(SoundType.WOOD);
        }
        else
        {
            this.setSoundType(SoundType.METAL);
        }
    }


    @Override
    public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon) {
        return this == ChozonBlocks.titanium_block;
    }

}
