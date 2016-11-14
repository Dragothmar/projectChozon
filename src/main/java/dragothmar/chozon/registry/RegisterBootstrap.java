package dragothmar.chozon.registry;

/**
 * Created by Dragothmar on 4/26/2016.
 */
public class RegisterBootstrap
{

    private static boolean alreadyRegistered = false;


    /**
     * Returns if registration is finished or not.
     * @return
     */
    public static boolean isRegistered()
    {
        return alreadyRegistered;
    }

    /**
     * Used to register custom dispenser functionality
     */
    @SuppressWarnings("unused")
    static void registerDispenserBehaviors() {}

    /**
     * Register blocks, items, etc...
     */
    public static void register()
    {
        if (!alreadyRegistered)
        {
            alreadyRegistered = true;
//            ChozonBlocks.init();
//            ChozonBlocks.register();
            ChozonItems.init();
            ChozonItems.register();
//            ChozonEntities.init();
        }
    }

}
