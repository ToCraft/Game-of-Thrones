package got.common.entity.westeros.ironborn;

import got.common.database.*;
import got.common.entity.ai.GOTEntityAIRangedAttack;
import got.common.entity.other.GOTEntityNPC;
import got.common.quest.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class GOTEntityIronbornCorsair extends GOTEntityIronbornMan {
	public static ItemStack[] weaponsIron = new ItemStack[] { new ItemStack(GOTRegistry.westerosSword), new ItemStack(GOTRegistry.westerosPike), new ItemStack(GOTRegistry.westerosHammer), new ItemStack(GOTRegistry.westerosDagger) };

	public GOTEntityIronbornCorsair(World world) {
		super(world);
		canBeMarried = false;
		addTargetTasks(true);
		spawnRidingHorse = false;
		npcShield = GOTShields.IRONBORN;
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
	public GOTMiniQuest createMiniQuest() {
		return null;
	}

	@Override
	public float getAlignmentBonus() {
		return 2.0f;
	}

	@Override
	public GOTMiniQuestFactory getBountyHelpSpeechDir() {
		return null;
	}

	@Override
	public String getSpeechBank(EntityPlayer entityplayer) {
		if (isFriendly(entityplayer)) {
			if (hiredNPCInfo.getHiringPlayer() == entityplayer) {
				return "westeros/ironborn/soldier/hired";
			}
			return "westeros/ironborn/soldier/friendly";
		}
		return "westeros/ironborn/soldier/hostile";
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
			npcItemsInv.setMeleeWeapon(new ItemStack(GOTRegistry.westerosPike));
		}
		npcItemsInv.setRangedWeapon(new ItemStack(GOTRegistry.westerosBow));
		npcItemsInv.setIdleItem(npcItemsInv.getMeleeWeapon());
		setCurrentItemOrArmor(1, new ItemStack(GOTRegistry.ironbornBoots));
		setCurrentItemOrArmor(2, new ItemStack(GOTRegistry.ironbornLeggings));
		setCurrentItemOrArmor(3, new ItemStack(GOTRegistry.ironbornChestplate));
		setCurrentItemOrArmor(4, new ItemStack(GOTRegistry.ironbornHelmet));
		return data;
	}

	@Override
	public void setupNPCGender() {
		familyInfo.setMale(true);
	}
}
