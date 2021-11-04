package got.client.render.npc;

import org.lwjgl.opengl.GL11;

import got.client.model.GOTModelHuman;
import got.client.render.other.*;
import got.common.entity.other.GOTEntityNPC;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.*;
import net.minecraft.util.ResourceLocation;

public class GOTRenderFactionNPCLayered extends GOTRenderBiped {
	public String path;
	public float size;
	public ModelBiped model = new GOTModelHuman(0.6f, false);

	public GOTRenderFactionNPCLayered(String texture) {
		super(new GOTModelHuman(), 0.5f);
		path = texture;
		size = 1.0f;
	}

	public GOTRenderFactionNPCLayered(String texture, float height) {
		super(new GOTModelHuman(), 0.5f);
		path = texture;
		size = height;
	}

	@Override
	public ResourceLocation getEntityTexture(Entity entity) {
		GOTEntityNPC mob = (GOTEntityNPC) entity;
		boolean child = mob.isChild();
		if (mob.familyInfo.isMale()) {
			if (child) {
				return GOTRandomSkins.loadSkinsList("got:mob/" + path + "/malechild").getRandomSkin(mob);
			}
			return GOTRandomSkins.loadSkinsList("got:mob/" + path + "/male").getRandomSkin(mob);
		}
		if (child) {
			return GOTRandomSkins.loadSkinsList("got:mob/" + path + "/femalechild").getRandomSkin(mob);
		}
		return GOTRandomSkins.loadSkinsList("got:mob/" + path + "/female").getRandomSkin(mob);
	}

	public ResourceLocation getSecondLayerTexture() {
		return new ResourceLocation("got:mob/" + path + "/outfit.png");
	}

	@Override
	public void preRenderCallback(EntityLivingBase entity, float f) {
		super.preRenderCallback(entity, f);
		GL11.glScalef(size, size, size);
	}

	@Override
	public int shouldRenderPass(EntityLiving entity, int pass, float f) {
		GOTEntityNPC legend = (GOTEntityNPC) entity;
		if (pass == 0 && legend.getEquipmentInSlot(4) == null) {
			setRenderPassModel(model);
			bindTexture(getSecondLayerTexture());
			return 1;
		}
		if (pass == 1 && legend.getEquipmentInSlot(3) == null) {
			setRenderPassModel(model);
			bindTexture(getSecondLayerTexture());
			return 1;
		}
		return super.shouldRenderPass(legend, pass, f);
	}
}