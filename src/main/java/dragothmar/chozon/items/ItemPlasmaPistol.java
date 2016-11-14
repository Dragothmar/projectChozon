package dragothmar.chozon.items;

import dragothmar.chozon.entity.projectile.EntityEnergyBolt;
import dragothmar.chozon.util.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.network.ForgeMessage;

/**
 * Created by Dragothmar on 5/4/2016.
 */
public class ItemPlasmaPistol extends ChozonBaseItem
{
    public static final String[] plasmaPistolChargeIconNameArray = new String[] {"plasma_pistol_charged_0", "plasma_pistol_charged_1", "plasma_pistol_charged_2", "plasma_pistol_charged_3"};

    public ItemPlasmaPistol()
    {
        this.maxStackSize = 1;
//        this.setCreativeTab(CreativeTab.instance);

    }

    /**
     * Called when the player stops using an Item (stops holding the right mouse button).
     */
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityPlayer playerIn, int timeLeft)
    {
        int i = this.getMaxItemUseDuration(stack) - timeLeft;
//        net.minecraftforge.event.entity.player.ArrowLooseEvent event = new net.minecraftforge.event.entity.player.ArrowLooseEvent(playerIn, stack, i);
//        if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event)) return;

//        double damageRatio = event.charge / 30.0D;
//
//        if (damageRatio > 1.0D)
//        {
//            damageRatio = 1.0D;
//        }
//        i = event.charge;
//        float f = (float) i / 20.0F;
//        f = (f * f + f * 2.0F) / 3.0F;
//
//        if ((double) f < 0.1D) {
//            return;
//        }
//
//        if (f > 1.0F) {
//            f = 1.0F;
//        }
//        EntitySnowball entitySnowball = new EntitySnowball(worldIn, playerIn);

//        Vec3 playerLookVec = playerIn.getLookVec();

//        double d1 = playerLookVec.xCoord;
//        double d2 = playerLookVec.yCoord;
//        double d3 = playerLookVec.zCoord;

        EntityEnergyBolt entityEnergyBolt = new EntityEnergyBolt(worldIn, playerIn);

//        entityEnergyBolt.setDamage(entityEnergyBolt.getDamage() * getDamageMultiplier(event.getCharge()));

        entityEnergyBolt.setFire(10);
//        entitySmallFireball.posZ = (double)(MathHelper.sin(entitySmallFireball.rotationYaw / 180.0F * (float)Math.PI) * 0.16F);

//        entitySmallFireball.posY = playerIn.posY + (double)playerIn.getEyeHeight() - 0.10000000149011612D;

//        if (f == 1.0F) {
//            entityarrow.setIsCritical(true);
//        }
//
//        int j = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, stack);
//
//        if (j > 0) {
//            entityarrow.setDamage(entityarrow.getDamage() + (double) j * 0.5D + 0.5D);
//        }
//
//        int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, stack);
//
//        if (k > 0) {
//            entityarrow.setKnockbackStrength(k);
//        }
//
//        if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, stack) > 0) {
//            entityarrow.setFire(100);
//        }
//
//        stack.damageItem(1, playerIn);
//        worldIn.playSoundAtEntity(playerIn, "random.fizz", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + 1.0f * 0.5F);

//        Use this for playing sounds
//        worldIn.playSound();

//        playerIn.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);

        if (!worldIn.isRemote) {
            worldIn.spawnEntityInWorld(entityEnergyBolt); //entitySnowball);
        }

    }

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack stack)
    {
        return 72000;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
//        net.minecraftforge.event.entity.player.ArrowNockEvent event = new net.minecraftforge.event.entity.player.ArrowNockEvent(playerIn, itemStackIn);
//        if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event)) return event.getResult();
//
//        playerIn.setItemInUse(itemStackIn, this.getMaxItemUseDuration(itemStackIn));

        return itemStackIn;
    }

    private float getDamageMultiplier(int charge)
    {
//        float damageRatio = charge / 30.0F;

        if (charge >= 30)
            return 1.0f;
        else if (charge > 20)
            return 0.75f;
        else if (charge > 10)
            return 0.5f;
        else if (charge > 0)
            return 0.25f;
        else
            return 0.0f;
    }

//    @Override
//    public ModelResourceLocation getModel(ItemStack stack, EntityPlayer player, int useRemaining) {
//        ModelResourceLocation modelResourceLocation = null;
//        int index = -1;
////        System.out.println("ITEMPLASMAPISTOL: useRemaining: " + useRemaining);
//        if (player.getItemInUse() != null)
//        {
//            int resourceBreakPoint = stack.getMaxItemUseDuration() - player.getItemInUseCount();
//            if( resourceBreakPoint >= 30 )
//            {
//                index = 3;
//            }
//            else if( resourceBreakPoint > 20)
//            {
//                index = 2;
//            }
//            else if( resourceBreakPoint > 10)
//            {
//                index = 1;
//            }
//            else if ( resourceBreakPoint > 0)
//            {
//                index = 0;
//            }
//        }
////        System.out.println("ITEMPLASMAPISTOL: Item in use: " + player.getItemInUseCount());
//
////        System.out.println("ITEMPLASMAPISTOL: This is a test!\n useRemaining: " + useRemaining + "\nStack item duration: " + stack.getMaxItemUseDuration() + "\nItem in use: " + player.getItemInUseCount());
//        if (index >= 0)
//            modelResourceLocation = new ModelResourceLocation(Reference.MODID + ":" + plasmaPistolChargeIconNameArray[index], "inventory");
//        return modelResourceLocation;
//    }

    //    /**
//     * returns the action that specifies what animation to play when the items is being used
//     */
//    public EnumAction getItemUseAction(ItemStack stack)
//    {
//        return EnumAction.BOW;
//    }
//
//    /**
//     * Called when the player finishes using this Item (E.g. finishes eating.). Not called when the player stops using
//     * the Item before the action is complete.
//     */
//    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityPlayer playerIn)
//    {
//        return stack;
//    }
}
