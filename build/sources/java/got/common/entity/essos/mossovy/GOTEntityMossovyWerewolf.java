package got.common.entity.essos.mossovy;

import got.common.database.*;
import got.common.entity.ai.GOTEntityAIAttackOnCollide;
import got.common.entity.other.GOTEntityNPC;
import got.common.entity.westeros.gift.GOTEntityGiftMan;
import got.common.faction.GOTFaction;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class GOTEntityMossovyWerewolf extends GOTEntityNPC {
	public GOTEntityMossovyWerewolf(World world) {
		super(world);
		canBeMarried = false;
		setSize(0.6f, 1.8f);
		getNavigator().setAvoidsWater(true);
		getNavigator().setBreakDoors(true);
		getNavigator().setCanSwim(false);
		addTargetTasks(true);
		tasks.addTask(0, new GOTEntityAIAttackOnCollide(this, 1.4, true));
		tasks.addTask(2, new EntityAIWander(this, 1.0));
		tasks.addTask(3, new EntityAIWatchClosest2(this, EntityPlayer.class, 8.0f, 0.02f));
		tasks.addTask(4, new EntityAIWatchClosest2(this, GOTEntityNPC.class, 5.0f, 0.02f));
		spawnsInDarkness = true;
	}

	@Override
	public void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100.0);
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23);
		getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(30.0);
		getEntityAttribute(npcAttackDamage).setBaseValue(5.0);
	}

	@Override
	public boolean attackEntityFrom(DamageSource damagesource, float f) {
		ItemStack itemstack;
		Entity entity = damagesource.getEntity();
		if (entity instanceof EntityLivingBase && entity == damagesource.getSourceOfDamage() && (itemstack = ((EntityLivingBase) entity).getHeldItem()) != null && (itemstack.getItem() == GOTRegistry.mossovySword || itemstack.getItem() == GOTRegistry.mossovyDagger)) {
			return super.attackEntityFrom(damagesource, 100.0f);
		}
		if (damagesource.getEntity() instanceof GOTEntityGiftMan) {
			return super.attackEntityFrom(damagesource, 100.0f);
		}
		return super.attackEntityFrom(damagesource, f);
	}

	@Override
	public float getAlignmentBonus() {
		return 10.0f;
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
		return GOTFaction.HOSTILE;
	}

	@Override
	public GOTAchievement getKillAchievement() {
		return GOTAchievement.KILL_WEREWOLF;
	}
}
