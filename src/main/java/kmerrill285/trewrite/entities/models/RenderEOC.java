package kmerrill285.trewrite.entities.models;

import org.lwjgl.opengl.GL11;

import com.mojang.blaze3d.platform.GlStateManager;

import kmerrill285.trewrite.entities.monsters.EntityEyeOfCthulhu;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderEOC extends MobRenderer<EntityEyeOfCthulhu, ModelEOC>
{
    private ResourceLocation eyeTexture = new ResourceLocation("trewrite:textures/entity/eyes/eye_of_cthulhu.png");
    private ResourceLocation eyeTexture2 = new ResourceLocation("trewrite:textures/entity/eyes/eye_of_cthulhu_2.png");
    
    public RenderEOC(EntityRendererManager renderManagerIn)
    {
    	
        super(renderManagerIn, new ModelEOC(), 4.0f);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity>) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doe
     */
    public void doRender(EntityEyeOfCthulhu entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
//    	BossStatus.setBossStatus(entity, true);
        this.shadowSize = 0.25F;

        super.doRender(entity, x, y-4, z, entityYaw, partialTicks);
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityEyeOfCthulhu entitylivingbaseIn, float partialTickTime)
    {
        float f = 8;
        
        double radp = Math.toRadians(entitylivingbaseIn.rotationPitch);
        GlStateManager.translated(0, -Math.sin(radp)*2, Math.sin(radp)*5.5);
        GlStateManager.rotated(entitylivingbaseIn.rotationPitch, 1, 0, 0);
        GlStateManager.translated(0, Math.sin(radp)*2-1, Math.sin(radp)*3);
        GlStateManager.scalef(f, f, f);

    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityEyeOfCthulhu entity)
    {
    	if (entity.transformedRotation < (360 * 5) / 2.0f)
    		return eyeTexture;
    	else
    		return eyeTexture2;
    }
}
