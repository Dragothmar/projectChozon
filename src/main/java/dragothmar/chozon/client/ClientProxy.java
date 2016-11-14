package dragothmar.chozon.client;

import dragothmar.chozon.client.render.entity.RenderEnergyBolt;
import dragothmar.chozon.entity.projectile.EntityEnergyBolt;
import dragothmar.chozon.registry.ChozonBlocks;
import dragothmar.chozon.registry.ChozonItems;
import dragothmar.chozon.server.ServerProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Dragothmar on 4/20/2016.
 */
public class ClientProxy extends ServerProxy {

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
        RenderingRegistry.registerEntityRenderingHandler(EntityEnergyBolt.class, new IRenderFactory<EntityEnergyBolt>() {
            @Override
            public Render<? super EntityEnergyBolt> createRenderFor(RenderManager manager) {
                return new RenderEnergyBolt(manager);
            }
        });
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);

//        ChozonBlocks.registerRenders();
        //ChozonItems.registerPlasmaPistolItemVariants();
        ChozonItems.registerRenders();
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }

    @Override
    public World getWorld()
    {
        if (FMLCommonHandler.instance().getEffectiveSide().isClient())
        {
            return Minecraft.getMinecraft().theWorld;
        }
        else
        {
            return super.getWorld();
        }
    }

}
