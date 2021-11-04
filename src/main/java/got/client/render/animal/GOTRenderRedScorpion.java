package got.client.render.animal;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.*;
import got.client.model.GOTModelScorpion;
import got.common.entity.animal.GOTEntityRedScorpion;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.*;
import net.minecraft.util.ResourceLocation;

@SideOnly(value = Side.CLIENT)
public class GOTRenderRedScorpion extends RenderLiving {
	public GOTRenderRedScorpion() {
		super(new GOTModelScorpion(), 0.5f);
	}

	@Override
	public float getDeathMaxRotation(EntityLivingBase entity) {
		return 180.0f;
	}

	@Override
	public ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("got:mob/animal/redscorp.png");
	}

	@Override
	public float handleRotationFloat(EntityLivingBase entity, float f) {
		float strikeTime = ((GOTEntityRedScorpion) entity).getStrikeTime();
		if (strikeTime > 0.0f) {
			strikeTime -= f;
		}
		return strikeTime / 20.0f;
	}

	@Override
	public void preRenderCallback(EntityLivingBase entity, float f) {
		super.preRenderCallback(entity, f);
		float height = GOTEntityRedScorpion.HEIGHT;
		GL11.glScalef(height, height, height);
	}
}