package got.common.entity.animal;

import got.common.entity.essos.legendary.trader.GOTEntityXaroXhoanDaxos;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.potion.*;
import net.minecraft.world.World;

public class GOTEntityManticore extends GOTEntityScorpion {
	public static float HEIGHT = 0.2f;

	public GOTEntityManticore(World world) {
		super(world);
		setSize(1.2f * HEIGHT, 0.9f * HEIGHT);
		tasks.addTask(1, new EntityAIAvoidEntity(this, GOTEntityXaroXhoanDaxos.class, 12.0f, 1.5, 2.0));
	}

	@Override
	public boolean getCanSpawnHere() {
		return super.getCanSpawnHere() && (spawningFromSpawner || posY < 60.0 || rand.nextInt(500) == 0);
	}

	@Override
	public void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1.0);
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.3);
		getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(20.0);
		getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10);
	}

	@Override
	public boolean attackEntityAsMob(Entity entity) {
		if (super.attackEntityAsMob(entity)) {
			int difficulty;
			int duration;
			if (!worldObj.isRemote) {
				setStrikeTime(20);
			}
			if (entity instanceof EntityLivingBase && (duration = (difficulty = worldObj.difficultySetting.getDifficultyId()) * (difficulty + 5) / 2) > 0) {
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.poison.id, duration * 100, 0));
			}
			return true;
		}
		return false;
	}
}