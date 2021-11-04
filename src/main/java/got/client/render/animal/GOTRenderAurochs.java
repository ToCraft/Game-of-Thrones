package got.client.render.animal;

import org.lwjgl.opengl.GL11;

import got.client.model.GOTModelBison;
import got.client.render.other.GOTRandomSkins;
import got.common.entity.animal.GOTEntityAurochs;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.*;
import net.minecraft.util.ResourceLocation;

public class GOTRenderAurochs extends RenderLiving {
	public static GOTRandomSkins aurochsSkins;

	public GOTRenderAurochs() {
		super(new GOTModelBison(), 0.5f);
		aurochsSkins = GOTRandomSkins.loadSkinsList("got:mob/animal/aurochs");
	}

	@Override
	public ResourceLocation getEntityTexture(Entity entity) {
		GOTEntityAurochs aurochs = (GOTEntityAurochs) entity;
		ResourceLocation skin = aurochsSkins.getRandomSkin(aurochs);
		return skin;
	}

	@Override
	public void preRenderCallback(EntityLivingBase entity, float f) {
		super.preRenderCallback(entity, f);
		GOTEntityAurochs animal = (GOTEntityAurochs) entity;
		if (animal.isChild()) {
			GL11.glScalef(0.5f, 0.5f, 0.5f);
		} else {
			GL11.glScalef(1.0f, 1.0f, 1.0f);
		}
	}
}
