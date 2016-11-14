package dragothmar.chozon.common;

import net.minecraft.world.World;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


/**
 * Created by Dragothmar on 4/20/2016.
 */
public abstract class CommonProxy
{
    @SidedProxy(serverSide = "dragothmar.chozon.server.ServerProxy", clientSide = "dragothmar.chozon.client.ClientProxy")
    public static CommonProxy proxy;

    public abstract void preInit(FMLPreInitializationEvent e);

    public abstract void init(FMLInitializationEvent e);

    public abstract void postInit(FMLPostInitializationEvent e);

    public abstract World getWorld();

}
