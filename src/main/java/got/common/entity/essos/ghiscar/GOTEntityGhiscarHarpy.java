package got.common.entity.essos.ghiscar;

import got.common.database.GOTRegistry;
import got.common.entity.ai.GOTEntityAINearestAttackableTargetPatriot;
import net.minecraft.entity.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class GOTEntityGhiscarHarpy extends GOTEntityGhiscarLevyman {
	public GOTEntityGhiscarHarpy(World world) {
		super(world);
		canBeMarried = false;
		spawnRidingHorse = false;
		npcShield = null;
		spawnsInDarkness = true;
		this.addTargetTasks(true, GOTEntityAINearestAttackableTargetPatriot.class);
	}

	@Override
	public void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.22);
		getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0);
		getEntityAttribute(npcAttackDamage).setBaseValue(40.0);
	}

	@Override
	public boolean attackEntityFrom(DamageSource damagesource, float f) {
		f = (float) (f * 0.5);
		return super.attackEntityFrom(damagesource, f);
	}

	@Override
	public String getSpeechBank(EntityPlayer entityplayer) {
		if (isFriendly(entityplayer)) {
			return "essos/ghiscar/harpy/neutral";
		}
		return "essos/ghiscar/harpy/hostile";
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		npcItemsInv.setMeleeWeapon(new ItemStack(GOTRegistry.essosDaggerPoisoned));
		npcItemsInv.setIdleItem(npcItemsInv.getMeleeWeapon());
		setCurrentItemOrArmor(4, new ItemStack(GOTRegistry.harpy));
		return data;
	}

	@Override
	public void setupNPCGender() {
		familyInfo.setMale(true);
	}
}
