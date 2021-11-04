package got.common.entity.westeros.gift;

import got.common.database.*;
import got.common.entity.ai.*;
import got.common.entity.animal.GOTEntityHorse;
import got.common.entity.other.*;
import got.common.faction.GOTFaction;
import got.common.quest.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class GOTEntityGiftMan extends GOTEntityHumanBase implements IPickpocketable {
	public GOTEntityGiftMan(World world) {
		super(world);
		canBeMarried = true;
		setSize(0.6f, 1.8f);
		getNavigator().setAvoidsWater(true);
		getNavigator().setBreakDoors(true);
		tasks.addTask(0, new EntityAISwimming(this));
		tasks.addTask(1, new GOTEntityAIHiredRemainStill(this));
		tasks.addTask(2, createGiftAttackAI());
		tasks.addTask(3, new GOTEntityAIFollowHiringPlayer(this));
		tasks.addTask(4, new EntityAIOpenDoor(this, true));
		tasks.addTask(5, new EntityAIWander(this, 1.0));
		tasks.addTask(6, new GOTEntityAIEat(this, getDunedainFoods(), 8000));
		tasks.addTask(6, new GOTEntityAIDrink(this, getDunedainDrinks(), 8000));
		tasks.addTask(7, new EntityAIWatchClosest2(this, EntityPlayer.class, 8.0f, 0.02f));
		tasks.addTask(7, new EntityAIWatchClosest2(this, GOTEntityNPC.class, 5.0f, 0.02f));
		tasks.addTask(8, new EntityAIWatchClosest(this, EntityLiving.class, 8.0f, 0.02f));
		tasks.addTask(9, new EntityAILookIdle(this));
		addTargetTasks(false);
	}

	@Override
	public void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0);
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.22);
	}

	public EntityAIBase createGiftAttackAI() {
		return new EntityAIPanic(this, 1.2);
	}

	@Override
	public GOTMiniQuest createMiniQuest() {
		return GOTMiniQuestFactory.WESTEROS.createQuest(this);
	}

	@Override
	public GOTNPCMount createMountToRide() {
		GOTEntityHorse horse = (GOTEntityHorse) super.createMountToRide();
		horse.setMountArmor(new ItemStack(GOTRegistry.ironHorseArmor));
		return horse;
	}

	public void dropDunedainItems(boolean flag, int i) {
		if (rand.nextInt(6) == 0) {
			dropChestContents(GOTChestContents.WESTEROS, 1, 2 + i);
		}
	}

	@Override
	public void dropFewItems(boolean flag, int i) {
		super.dropFewItems(flag, i);
		int bones = rand.nextInt(2) + rand.nextInt(i + 1);
		for (int l = 0; l < bones; ++l) {
			dropItem(Items.bone, 1);
		}
		dropDunedainItems(flag, i);
	}

	@Override
	public float getAlignmentBonus() {
		return 1.0f;
	}

	@Override
	public GOTMiniQuestFactory getBountyHelpSpeechDir() {
		return GOTMiniQuestFactory.WESTEROS;
	}

	public GOTFoods getDunedainDrinks() {
		return GOTFoods.WESTEROS_DRINK;
	}

	public GOTFoods getDunedainFoods() {
		return GOTFoods.WESTEROS;
	}

	@Override
	public GOTFaction getFaction() {
		return GOTFaction.NIGHT_WATCH;
	}

	@Override
	public String getNPCName() {
		return familyInfo.getName();
	}

	@Override
	public String getSpeechBank(EntityPlayer entityplayer) {
		if (isDrunkard()) {
			return "special/drunkard";
		}
		if (isFriendly(entityplayer)) {
			return "westeros/gift/man/friendly";
		}
		return "westeros/gift/man/hostile";
	}

	@Override
	public void onAttackModeChange(GOTEntityNPC.AttackMode mode, boolean mounted) {
		if (mode == GOTEntityNPC.AttackMode.IDLE) {
			setCurrentItemOrArmor(0, npcItemsInv.getIdleItem());
		} else {
			setCurrentItemOrArmor(0, npcItemsInv.getMeleeWeapon());
		}
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		npcItemsInv.setMeleeWeapon(null);
		npcItemsInv.setIdleItem(null);
		return data;
	}

	@Override
	public void setupNPCGender() {
		familyInfo.setMale(rand.nextBoolean());
	}

	@Override
	public void setupNPCName() {
		familyInfo.setName(GOTNames.getWesterosName(rand, familyInfo.isMale()));
	}
}
