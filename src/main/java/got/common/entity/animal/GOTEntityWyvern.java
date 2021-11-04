package got.common.entity.animal;

import java.util.List;

import got.common.database.GOTRegistry;
import got.common.entity.ai.GOTEntityAIAttackOnCollide;
import got.common.entity.other.*;
import got.common.world.biome.sothoryos.GOTBiomeSothoryosHell;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class GOTEntityWyvern extends EntityMob {
	public GOTEntityWyvern(World world) {
		super(world);
		setSize(2.85f, 2.55f);
		getNavigator().setAvoidsWater(true);
		tasks.addTask(0, new EntityAISwimming(this));
		tasks.addTask(1, new GOTEntityAIAttackOnCollide(this, 1.5, false));
		tasks.addTask(2, new EntityAIWander(this, 1.0));
		tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
		tasks.addTask(3, new EntityAIWatchClosest(this, EntityLiving.class, 12.0f));
		tasks.addTask(4, new EntityAILookIdle(this));
		targetTasks.addTask(0, new EntityAIHurtByTarget(this, false));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, GOTEntityNPC.class, 0, true));
	}

	@Override
	public void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100.0);
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25);
		getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0);
	}

	@Override
	public boolean attackEntityAsMob(Entity entity) {
		if (super.attackEntityAsMob(entity)) {
			if (!worldObj.isRemote) {
				setSnapTime(20);
			}
			worldObj.playSoundAtEntity(this, "got:crocodile.snap", getSoundVolume(), getSoundPitch());
			float attackDamage = (float) getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
			float knockbackModifier = 0.25f * attackDamage;
			entity.addVelocity(-MathHelper.sin(rotationYaw * 3.1415927f / 180.0f) * knockbackModifier * 0.5f, knockbackModifier * 0.1, MathHelper.cos(rotationYaw * 3.1415927f / 180.0f) * knockbackModifier * 0.5f);
			return true;
		}
		return false;
	}

	@Override
	public void dropFewItems(boolean flag, int i) {
		super.dropFewItems(flag, i);
		int count = rand.nextInt(3) + rand.nextInt(i + 1);
		block7: for (int j = 0; j < count; ++j) {
			int drop = rand.nextInt(5);
			switch (drop) {
			case 0: {
				dropItem(Items.bone, 1);
				continue block7;
			}
			case 1: {
				dropItem(Items.fish, 1);
				continue block7;
			}
			case 2: {
				dropItem(Items.leather, 1);
				continue block7;
			}
			case 3: {
				dropItem(GOTRegistry.zebraRaw, 1);
				continue block7;
			}
			case 4: {
				dropItem(GOTRegistry.gemsbokHide, 1);
			}
			}
		}
	}

	@Override
	public void entityInit() {
		super.entityInit();
		dataWatcher.addObject(20, 0);
	}

	@Override
	public String getDeathSound() {
		return "got:crocodile.death";
	}

	@Override
	public Item getDropItem() {
		return Items.rotten_flesh;
	}

	@Override
	public String getLivingSound() {
		return "got:crocodile.say";
	}

	@Override
	public ItemStack getPickedResult(MovingObjectPosition target) {
		return new ItemStack(GOTRegistry.spawnEgg, 1, GOTEntityRegistry.getEntityID(this));
	}

	public int getSnapTime() {
		return dataWatcher.getWatchableObjectInt(20);
	}

	@Override
	public boolean isAIEnabled() {
		return true;
	}

	@Override
	public boolean isValidLightLevel() {
		int i = MathHelper.floor_double(posX);
		if (worldObj.getBiomeGenForCoords(i, MathHelper.floor_double(posZ)) instanceof GOTBiomeSothoryosHell) {
			return true;
		}
		return super.isValidLightLevel();
	}

	@Override
	public void moveEntityWithHeading(float f, float f1) {
		if (!worldObj.isRemote && isInWater() && getAttackTarget() != null) {
			moveFlying(f, f1, 0.1f);
		}
		super.moveEntityWithHeading(f, f1);
	}

	@Override
	public void onLivingUpdate() {
		EntityAnimal entityanimal;
		int i;
		List list;
		super.onLivingUpdate();
		if (!worldObj.isRemote && isInWater()) {
			motionY += 0.02;
		}
		if (!worldObj.isRemote && (i = getSnapTime()) > 0) {
			setSnapTime(i - 1);
		}
		if (getAttackTarget() == null && worldObj.rand.nextInt(1000) == 0 && !(list = worldObj.getEntitiesWithinAABB(EntityAnimal.class, boundingBox.expand(12.0, 6.0, 12.0))).isEmpty() && (entityanimal = (EntityAnimal) list.get(rand.nextInt(list.size()))).getAttributeMap().getAttributeInstance(SharedMonsterAttributes.attackDamage) == null) {
			setAttackTarget(entityanimal);
		}
	}

	public void setSnapTime(int i) {
		dataWatcher.updateObject(20, i);
	}
}