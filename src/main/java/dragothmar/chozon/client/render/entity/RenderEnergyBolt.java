package dragothmar.chozon.client.render.entity;

import dragothmar.chozon.entity.projectile.EntityEnergyBolt;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by Dragothmar on 5/9/2016.
 */
public class RenderEnergyBolt extends Render<EntityEnergyBolt>
{

    private static final ResourceLocation energyBoltTextures = new ResourceLocation("chozon:textures/entity/energy_bolt.png");

    public RenderEnergyBolt(RenderManager renderManager) {
        super(renderManager);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityEnergyBolt entity) {
        return energyBoltTextures;
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity>) and this method has signature public void func_76986_a(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doe
     */
    public void doRender(EntityEnergyBolt entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        this.bindEntityTexture(entity);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)x, (float)y, (float)z);
        GlStateManager.rotate(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * partialTicks - 90.0F, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * partialTicks, 0.0F, 0.0F, 1.0F);
        Tessellator tessellator = Tessellator.getInstance();
        //WorldRenderer worldrenderer = tessellator.getWorldRenderer();
//        int i = 0;
//        float f = 0.0F;
//        float f1 = 0.5F;
//        float f2 = (float)(0 + i * 10) / 32.0F;
//        float f3 = (float)(5 + i * 10) / 32.0F;
//        float f4 = 0.0F;
//        float f5 = 0.15625F;
//        float f6 = (float)(5 + i * 10) / 32.0F;
//        float f7 = (float)(10 + i * 10) / 32.0F;
//        float f8 = 0.05625F;


        float boltF = 0.0f;
        float boltF1 = 1.0f;
        float boltF2 = 5.0f/16.0f;
        float boltScale = 5.0f/160.0f;          // arrow default 9/160
        GlStateManager.enableRescaleNormal();


        GlStateManager.rotate(45.0F, 1.0F, 0.0F, 0.0F);
        GlStateManager.scale(boltScale, boltScale, boltScale);
        GlStateManager.translate(-4.0F, 0.0F, 0.0F);
//        GL11.glNormal3f(f8, 0.0F, 0.0F);                                                // Light for current drawing

//        worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
//        worldrenderer.pos(-7.0D, -2.0D, -2.0D).tex((double)f4, (double)f6).endVertex();
//        worldrenderer.pos(-7.0D, -2.0D, 2.0D).tex((double)f5, (double)f6).endVertex();
//        worldrenderer.pos(-7.0D, 2.0D, 2.0D).tex((double)f5, (double)f7).endVertex();
//        worldrenderer.pos(-7.0D, 2.0D, -2.0D).tex((double)f4, (double)f7).endVertex();
//        tessellator.draw();
//        GL11.glNormal3f(-f8, 0.0F, 0.0F);
//        worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
//        worldrenderer.pos(-7.0D, 2.0D, -2.0D).tex((double)f4, (double)f6).endVertex();
//        worldrenderer.pos(-7.0D, 2.0D, 2.0D).tex((double)f5, (double)f6).endVertex();
//        worldrenderer.pos(-7.0D, -2.0D, 2.0D).tex((double)f5, (double)f7).endVertex();
//        worldrenderer.pos(-7.0D, -2.0D, -2.0D).tex((double)f4, (double)f7).endVertex();
//        tessellator.draw();

        for (int j = 0; j < 4; ++j)
        {
            GlStateManager.rotate(90.0F, 1.0F, 0.0F, 0.0F);
            GL11.glNormal3f(0.0F, 0.0F, boltScale);
//            worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
//            worldrenderer.pos(-8.0D, -2.0D, 0.0D).tex((double)boltF, (double)boltF).endVertex();
//            worldrenderer.pos(8.0D, -2.0D, 0.0D).tex((double)boltF1, (double)boltF).endVertex();
//            worldrenderer.pos(8.0D, 2.0D, 0.0D).tex((double)boltF1, (double)boltF2).endVertex();
//            worldrenderer.pos(-8.0D, 2.0D, 0.0D).tex((double)boltF, (double)boltF2).endVertex();
            tessellator.draw();
        }

        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

}
