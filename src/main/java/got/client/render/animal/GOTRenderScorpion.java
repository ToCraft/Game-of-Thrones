package got.client.render.animal;

import org.lwjgl.opengl.GL11;

import got.client.model.GOTModelScorpion;
import got.common.entity.animal.*;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.*;
import net.minecraft.util.ResourceLocation;

public class GOTRenderScorpion extends RenderLiving {
	public static ResourceLocation jungleTexture = new ResourceLocation("got:mob/animal/scorpion/jungle.png");
	public static ResourceLocation desertTexture = new ResourceLocation("got:mob/animal/scorpion/desert.png");

	public GOTRenderScorpion() {
		super(new GOTModelScorpion(), 1.0f);
		setRenderPassModel(new GOTModelScorpion());
	}

	@Override
	public float getDeathMaxRotation(EntityLivingBase entity) {
		return 180.0f;
	}

	@Override
	public ResourceLocation getEntityTexture(Entity entity) {
		if (entity instanceof GOTEntityDesertScorpion) {
			return desertTexture;
		}
		return jungleTexture;
	}

	@Override
	public float handleRotationFloat(EntityLivingBase entity, float f) {
		float strikeTime = ((GOTEntityScorpion) entity).getStrikeTime();
		if (strikeTime > 0.0f) {
			strikeTime -= f;
		}
		return strikeTime / 20.0f;
	}

	@Override
	public void preRenderCallback(EntityLivingBase entity, float f) {
		float scale = ((GOTEntityScorpion) entity).getScorpionScaleAmount();
		GL11.glScalef(scale, scale, scale);
	}
}
