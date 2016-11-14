package dragothmar.chozon.entity.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

/**
 * Created by Dragothmar on 5/6/2016.
 */
public class EntityEnergyBolt extends EntityThrowable {

    private float explosionPower = 0.25f;
    private double damage = 2.0D;

    public EntityEnergyBolt(World worldIn)
    {
        super(worldIn);
    }

    public EntityEnergyBolt(World worldIn, EntityLivingBase shooter)
    {
        super(worldIn, shooter);

    }

    private EntityEnergyBolt(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }

//    public void onUpdate()
//    {
//
//    }

    public void setDamage(double damage)
    {
        this.damage = damage;
    }

    public double getDamage()
    {
        return this.damage;
    }

    @Override
    protected float getGravityVelocity() {
        return 0.0F;
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if (!this.worldObj.isRemote)
        {
            if (result.entityHit != null)
            {
//                DamageSource.causeIndirectMagicDamage(this, movingObject.entityHit);
//                movingObject.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, movingObject.entityHit), (float)this.damage);
                System.out.println("DAMAGE: Hit " + result.entityHit.toString() + " with damage: " + this.damage);
                result.entityHit.attackEntityFrom(DamageSource.causeIndirectMagicDamage(this, result.entityHit), (float)this.damage);
            }

//            boolean flag = this.worldObj.getGameRules().getBoolean("mobGriefing");
//            this.worldObj.newExplosion(this, this.posX, this.posY, this.posZ, this.explosionPower, false, flag);
            this.setDead();
        }
    }
}
