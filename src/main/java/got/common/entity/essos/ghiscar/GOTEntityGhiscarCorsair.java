package got.common.entity.essos.ghiscar;

import got.common.database.*;
import got.common.entity.ai.GOTEntityAIRangedAttack;
import got.common.entity.other.GOTEntityNPC;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class GOTEntityGhiscarCorsair extends GOTEntityGhiscarMan {
	public static ItemStack[] weaponsIron = new ItemStack[] { new ItemStack(GOTRegistry.essosSword), new ItemStack(GOTRegistry.essosSword), new ItemStack(GOTRegistry.essosSword), new ItemStack(GOTRegistry.essosHammer) };

	public GOTEntityGhiscarCorsair(World world) {
		super(world);
		canBeMarried = false;
		addTargetTasks(true);
		spawnRidingHorse = false;
		npcShield = GOTShields.GHISCAR;
	}

	@Override
	public void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(npcRangedAccuracy).setBaseValue(0.75);
	}

	public EntityAIBase createGhiskarRangedAttackAI() {
		return new GOTEntityAIRangedAttack(this, 1.5, 30, 40, 16.0f);
	}

	@Override
	public float getAlignmentBonus() {
		return 2.0f;
	}

	@Override
	public String getSpeechBank(EntityPlayer entityplayer) {
		if (isFriendly(entityplayer)) {
			if (hiredNPCInfo.getHiringPlayer() == entityplayer) {
				return "essos/ghiscar/corsair/hired";
			}
			return "essos/ghiscar/corsair/friendly";
		}
		return "essos/ghiscar/corsair/hostile";
	}

	@Override
	public void onKillEntity(EntityLivingBase entity) {
		super.onKillEntity(entity);
		if (entity instanceof GOTEntityNPC && ((GOTEntityNPC) entity).canDropRares() && rand.nextInt(2) == 0) {
			int coins = getRandomCoinDropAmount();
			if ((coins = (int) (coins * MathHelper.randomFloatClamp(rand, 1.0f, 3.0f))) > 0) {
				entity.dropItem(GOTRegistry.coin, coins);
			}
		}
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		int i = rand.nextInt(weaponsIron.length);
		npcItemsInv.setMeleeWeapon(weaponsIron[i].copy());
		if (rand.nextInt(5) == 0) {
			npcItemsInv.setSpearBackup(npcItemsInv.getMeleeWeapon());
			npcItemsInv.setMeleeWeapon(new ItemStack(GOTRegistry.essosSpear));
		}
		npcItemsInv.setRangedWeapon(new ItemStack(GOTRegistry.essosBow));
		npcItemsInv.setIdleItem(npcItemsInv.getMeleeWeapon());
		setCurrentItemOrArmor(1, new ItemStack(GOTRegistry.ghiscarBoots));
		setCurrentItemOrArmor(2, new ItemStack(GOTRegistry.ghiscarLeggings));
		setCurrentItemOrArmor(3, new ItemStack(GOTRegistry.ghiscarChestplate));
		setCurrentItemOrArmor(4, new ItemStack(GOTRegistry.ghiscarHelmet));
		return data;
	}

	@Override
	public void setupNPCGender() {
		familyInfo.setMale(true);
	}
}
