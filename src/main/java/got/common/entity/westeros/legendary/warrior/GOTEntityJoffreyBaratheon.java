package got.common.entity.westeros.legendary.warrior;

import got.common.database.*;
import got.common.entity.ai.*;
import got.common.entity.other.*;
import got.common.entity.westeros.GOTEntityWhore;
import got.common.faction.GOTFaction;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class GOTEntityJoffreyBaratheon extends GOTEntityHumanBase {
	public GOTEntityJoffreyBaratheon(World world) {
		super(world);
		canBeMarried = false;
		addTargetTasks();
		setIsLegendaryNPC();
		isRoyalOrder = true;
		setSize(0.6f * 0.9f, 1.8f * 0.9f);
		tasks.addTask(0, new EntityAISwimming(this));
		tasks.addTask(1, new GOTEntityAIHiredRemainStill(this));
		tasks.addTask(2, new GOTEntityAIRangedAttack(this, 1.25, 30, 50, 16.0f));
		tasks.addTask(3, new GOTEntityAIFollowHiringPlayer(this));
		tasks.addTask(4, new EntityAIOpenDoor(this, true));
		tasks.addTask(5, new EntityAIWander(this, 1.0));
		tasks.addTask(6, new GOTEntityAIEat(this, GOTFoods.WESTEROS, 8000));
		tasks.addTask(6, new GOTEntityAIDrink(this, GOTFoods.RICH_DRINK, 8000));
		tasks.addTask(7, new EntityAIWatchClosest2(this, EntityPlayer.class, 8.0f, 0.02f));
		tasks.addTask(7, new EntityAIWatchClosest2(this, GOTEntityNPC.class, 5.0f, 0.02f));
		tasks.addTask(8, new EntityAIWatchClosest(this, EntityLiving.class, 8.0f, 0.02f));
		tasks.addTask(9, new EntityAILookIdle(this));
	}

	public void addTargetTasks() {
		int target = addTargetTasks(true);
		targetTasks.addTask(target + 1, new GOTEntityAINearestAttackableTargetBasic(this, GOTEntityWhore.class, 500, true));
	}

	@Override
	public void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30.0);
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.22);
	}

	@Override
	public void dropFewItems(boolean flag, int i) {
		dropItem(GOTRegistry.joffreyCrossbow, 1);
	}

	@Override
	public float getAlignmentBonus() {
		return 500.0f;
	}

	@Override
	public GOTFaction getFaction() {
		return GOTFaction.CROWNLANDS;
	}

	@Override
	public GOTAchievement getKillAchievement() {
		return GOTAchievement.KILL_THE_KING;
	}

	@Override
	public String getSpeechBank(EntityPlayer entityplayer) {
		if (isFriendly(entityplayer)) {
			return "legendary/joffrey_friendly";
		}
		return "legendary/joffrey_hostile";
	}

	@Override
	public void onAttackModeChange(GOTEntityNPC.AttackMode mode, boolean mounted) {
		if (mode == GOTEntityNPC.AttackMode.IDLE) {
			setCurrentItemOrArmor(0, npcItemsInv.getRangedWeapon());
		} else {
			setCurrentItemOrArmor(0, npcItemsInv.getRangedWeapon());
		}
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		npcItemsInv.setRangedWeapon(new ItemStack(GOTRegistry.joffreyCrossbow));
		npcItemsInv.setIdleItem(npcItemsInv.getRangedWeapon());
		return data;
	}

	@Override
	public void setupNPCGender() {
		familyInfo.setMale(true);
	}
}
