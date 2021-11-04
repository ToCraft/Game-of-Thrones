package got.common.entity.essos.mossovy;

import got.common.GOTLevelData;
import got.common.database.*;
import got.common.entity.ai.*;
import got.common.entity.other.*;
import got.common.faction.GOTFaction;
import got.common.quest.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class GOTEntityMossovyWitcher extends GOTEntityHumanBase implements GOTMercenary {
	public EntityAIBase rangedAttackAI = createMossovyRangedAI();
	public EntityAIBase meleeAttackAI;

	public GOTEntityMossovyWitcher(World world) {
		super(world);
		canBeMarried = false;
		addTargetTasks(true);
		spawnRidingHorse = false;
		npcShield = null;
		npcCape = null;
		setSize(0.6f, 1.8f);
		getNavigator().setAvoidsWater(true);
		getNavigator().setBreakDoors(true);
		tasks.addTask(0, new EntityAISwimming(this));
		tasks.addTask(1, new GOTEntityAIHiredRemainStill(this));
		tasks.addTask(2, createMossovyAttackAI());
		tasks.addTask(3, new GOTEntityAIFollowHiringPlayer(this));
		tasks.addTask(4, new EntityAIOpenDoor(this, true));
		tasks.addTask(5, new EntityAIWander(this, 1.0));
		tasks.addTask(7, new EntityAIWatchClosest2(this, EntityPlayer.class, 8.0f, 0.02f));
		tasks.addTask(7, new EntityAIWatchClosest2(this, GOTEntityNPC.class, 5.0f, 0.02f));
		tasks.addTask(8, new EntityAIWatchClosest(this, EntityLiving.class, 8.0f, 0.02f));
		tasks.addTask(9, new EntityAILookIdle(this));
	}

	@Override
	public void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100.0);
		getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(20.0);
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.22);
		getEntityAttribute(npcRangedAccuracy).setBaseValue(1.0);
	}

	@Override
	public boolean canTradeWith(EntityPlayer entityplayer) {
		return GOTLevelData.getData(entityplayer).getAlignment(getFaction()) >= 0.0f && isFriendly(entityplayer);
	}

	@Override
	public GOTMiniQuest createMiniQuest() {
		return GOTMiniQuestFactory.ESSOS.createQuest(this);
	}

	public EntityAIBase createMossovyAttackAI() {
		meleeAttackAI = new GOTEntityAIAttackOnCollide(this, 1.4, true);
		return meleeAttackAI;
	}

	public EntityAIBase createMossovyRangedAI() {
		return new GOTEntityAIRangedAttack(this, 1.25, 20, 40, 20.0f);
	}

	@Override
	public void dropFewItems(boolean flag, int i) {
		super.dropFewItems(flag, i);
		dropItem(GOTRegistry.mossovySword, 1);
	}

	@Override
	public float getAlignmentBonus() {
		return 2.0f;
	}

	@Override
	public GOTMiniQuestFactory getBountyHelpSpeechDir() {
		return GOTMiniQuestFactory.ESSOS;
	}

	@Override
	public boolean getCanSpawnHere() {
		if (super.getCanSpawnHere()) {
			if (liftSpawnRestrictions) {
				return true;
			}
			int i = MathHelper.floor_double(posX);
			int j = MathHelper.floor_double(boundingBox.minY);
			int k = MathHelper.floor_double(posZ);
			if (j > 62 && worldObj.getBlock(i, j - 1, k) == worldObj.getBiomeGenForCoords(i, k).topBlock) {
				return true;
			}
		}
		return false;
	}

	@Override
	public GOTFaction getFaction() {
		return GOTFaction.MOSSOVY;
	}

	@Override
	public GOTFaction getHiringFaction() {
		return GOTFaction.MOSSOVY;
	}

	@Override
	public GOTAchievement getKillAchievement() {
		return GOTAchievement.KILL_WITCHER;
	}

	@Override
	public float getMercAlignmentRequired() {
		return 10.0f;
	}

	@Override
	public int getMercBaseCost() {
		return 50;
	}

	@Override
	public String getSpeechBank(EntityPlayer entityplayer) {
		if (isFriendly(entityplayer)) {
			return "essos/mossovy/friendly";
		}
		return "essos/mossovy/hostile";
	}

	@Override
	public void onAttackModeChange(GOTEntityNPC.AttackMode mode, boolean mounted) {
		if (mode == GOTEntityNPC.AttackMode.IDLE) {
			tasks.removeTask(meleeAttackAI);
			tasks.removeTask(rangedAttackAI);
			setCurrentItemOrArmor(0, npcItemsInv.getMeleeWeapon());
		}
		if (mode == GOTEntityNPC.AttackMode.MELEE) {
			tasks.removeTask(meleeAttackAI);
			tasks.removeTask(rangedAttackAI);
			tasks.addTask(2, meleeAttackAI);
			setCurrentItemOrArmor(0, npcItemsInv.getMeleeWeapon());
		}
		if (mode == GOTEntityNPC.AttackMode.RANGED) {
			tasks.removeTask(meleeAttackAI);
			tasks.removeTask(rangedAttackAI);
			tasks.addTask(2, rangedAttackAI);
			setCurrentItemOrArmor(0, npcItemsInv.getRangedWeapon());
		}
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		npcItemsInv.setMeleeWeapon(new ItemStack(GOTRegistry.mossovySword));
		npcItemsInv.setRangedWeapon(new ItemStack(GOTRegistry.ironCrossbow));
		setCurrentItemOrArmor(1, new ItemStack(GOTRegistry.mossovyBoots));
		setCurrentItemOrArmor(2, new ItemStack(GOTRegistry.mossovyLeggings));
		setCurrentItemOrArmor(3, new ItemStack(GOTRegistry.mossovyChestplate));
		setCurrentItemOrArmor(4, null);
		return data;
	}

	@Override
	public void onUnitTrade(EntityPlayer entityplayer) {
		GOTLevelData.getData(entityplayer).addAchievement(GOTAchievement.TRADE);
	}

	@Override
	public void setupNPCGender() {
		familyInfo.setMale(true);
	}

	@Override
	public void setupNPCName() {
		familyInfo.setName(GOTNames.getEssosName(rand, familyInfo.isMale()));
	}
}
