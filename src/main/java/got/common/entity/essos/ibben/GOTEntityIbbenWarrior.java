package got.common.entity.essos.ibben;

import got.common.database.GOTRegistry;
import got.common.entity.ai.GOTEntityAIAttackOnCollide;
import got.common.entity.other.GOTEntityNPC;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class GOTEntityIbbenWarrior extends GOTEntityIbbenMan {
	public GOTEntityIbbenWarrior(World world) {
		super(world);
		canBeMarried = false;
		addTargetTasks(true);
		spawnRidingHorse = false;
	}

	@Override
	public void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0);
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.22);
		getEntityAttribute(npcRangedAccuracy).setBaseValue(0.75);
		getEntityAttribute(horseAttackSpeed).setBaseValue(2.0);
	}

	@Override
	public EntityAIBase createIbbenAttackAI() {
		return new GOTEntityAIAttackOnCollide(this, 1.4, false);
	}

	@Override
	public float getAlignmentBonus() {
		return 2.0f;
	}

	@Override
	public String getSpeechBank(EntityPlayer entityplayer) {
		if (isFriendly(entityplayer)) {
			if (hiredNPCInfo.getHiringPlayer() == entityplayer) {
				return "essos/ibben/warrior/hired";
			}
			return "essos/ibben/warrior/friendly";
		}
		return "essos/ibben/warrior/hostile";
	}

	@Override
	public int getTotalArmorValue() {
		return 20;
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
		if (rand.nextInt(3) == 0) {
			npcItemsInv.setMeleeWeapon(new ItemStack(GOTRegistry.ironBattleaxe));
		}
		if (rand.nextInt(3) == 0) {
			npcItemsInv.setMeleeWeapon(new ItemStack(GOTRegistry.ironPike));
		}
		if (rand.nextInt(3) == 0) {
			npcItemsInv.setMeleeWeapon(new ItemStack(Items.iron_axe));
		}
		if (rand.nextInt(3) == 0) {
			npcItemsInv.setMeleeWeapon(new ItemStack(GOTRegistry.club));
		} else {
			npcItemsInv.setMeleeWeapon(new ItemStack(Items.iron_sword));
		}
		if (rand.nextInt(4) == 0) {
			npcItemsInv.setSpearBackup(npcItemsInv.getMeleeWeapon());
			npcItemsInv.setMeleeWeapon(new ItemStack(GOTRegistry.ironSpear));
		}
		if (rand.nextInt(4) == 0) {
			npcItemsInv.setSpearBackup(npcItemsInv.getMeleeWeapon());
			npcItemsInv.setMeleeWeapon(new ItemStack(GOTRegistry.flintSpear));
		}
		npcItemsInv.setIdleItem(npcItemsInv.getMeleeWeapon());
		npcItemsInv.setIdleItemMounted(npcItemsInv.getMeleeWeaponMounted());
		return data;
	}

	@Override
	public void setupNPCGender() {
		familyInfo.setMale(true);
	}
}
