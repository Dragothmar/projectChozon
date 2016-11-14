package dragothmar.chozon.server;

import dragothmar.chozon.common.CommonProxy;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Dragothmar on 4/20/2016.
 */
public class ServerProxy extends CommonProxy
{

    @Override
    public void preInit(FMLPreInitializationEvent e)
    {

    }

    @Override
    public void init(FMLInitializationEvent e)
    {

    }

    @Override
    public void postInit(FMLPostInitializationEvent e)
    {

    }

    @Override
    public World getWorld()
    {
        throw new UnsupportedOperationException( "Cannot get world as Server");
    }
}
