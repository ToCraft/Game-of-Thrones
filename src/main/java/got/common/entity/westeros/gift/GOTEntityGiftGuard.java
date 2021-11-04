package got.common.entity.westeros.gift;

import got.common.database.*;
import got.common.entity.other.GOTEntityNPC;
import got.common.entity.westeros.legendary.warrior.GOTEntityAlliserThorne;
import got.common.entity.westeros.north.GOTEntityNorthLevyman;
import got.common.faction.GOTFaction;
import got.common.quest.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class GOTEntityGiftGuard extends GOTEntityNorthLevyman {
	public GOTEntityGiftGuard(World world) {
		super(world);
		canBeMarried = false;
		tasks.addTask(1, new EntityAIAvoidEntity(this, GOTEntityAlliserThorne.class, 5.0f, 1.0, 1.0));
		spawnRidingHorse = false;
		npcCape = GOTCapes.NIGHT;
		isImmuneToFrost = true;
	}

	@Override
	public void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30.0);
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.22);
	}

	@Override
	public GOTMiniQuest createMiniQuest() {
		return GOTMiniQuestFactory.WESTEROS.createQuest(this);
	}

	@Override
	public float getAlignmentBonus() {
		return 2.0f;
	}

	@Override
	public GOTMiniQuestFactory getBountyHelpSpeechDir() {
		return GOTMiniQuestFactory.WESTEROS;
	}

	@Override
	public GOTFaction getFaction() {
		return GOTFaction.NIGHT_WATCH;
	}

	@Override
	public GOTAchievement getKillAchievement() {
		return GOTAchievement.KILL_NIGHT_WATCH_GUARD;
	}

	@Override
	public String getSpeechBank(EntityPlayer entityplayer) {
		if (isFriendly(entityplayer)) {
			if (hiredNPCInfo.getHiringPlayer() == entityplayer) {
				return "westeros/gift/guard/hired";
			}
			return "westeros/gift/guard/friendly";
		}
		return "westeros/gift/guard/hostile";
	}

	@Override
	public void onAttackModeChange(GOTEntityNPC.AttackMode mode, boolean mounted) {
		if (mode == GOTEntityNPC.AttackMode.IDLE) {
			if (mounted) {
				setCurrentItemOrArmor(0, npcItemsInv.getIdleItemMounted());
			} else {
				setCurrentItemOrArmor(0, npcItemsInv.getIdleItem());
			}
		} else if (mounted) {
			setCurrentItemOrArmor(0, npcItemsInv.getMeleeWeaponMounted());
		} else {
			setCurrentItemOrArmor(0, npcItemsInv.getMeleeWeapon());
		}
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		setCurrentItemOrArmor(1, new ItemStack(GOTRegistry.giftBoots));
		setCurrentItemOrArmor(2, new ItemStack(GOTRegistry.giftLeggings));
		setCurrentItemOrArmor(3, new ItemStack(GOTRegistry.giftChestplate));
		setCurrentItemOrArmor(4, new ItemStack(GOTRegistry.giftHelmet));
		npcItemsInv.setIdleItem(npcItemsInv.getMeleeWeapon());
		npcItemsInv.setIdleItemMounted(npcItemsInv.getMeleeWeaponMounted());
		return data;
	}

	@Override
	public void setupNPCName() {
		familyInfo.setName(GOTNames.getWesterosName(rand, familyInfo.isMale()));
	}
}
