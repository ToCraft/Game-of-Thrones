package got.common.entity.essos.ghiscar;

import got.common.database.GOTRegistry;
import net.minecraft.entity.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class GOTEntityGhiscarGuard extends GOTEntityGhiscarLevyman {
	public GOTEntityGhiscarGuard(World world) {
		super(world);
		canBeMarried = false;
		spawnRidingHorse = false;
		npcShield = null;
		spawnsInDarkness = false;
		addTargetTasks(false);
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
			return "essos/ghiscar/guard/neutral";
		}
		return "essos/ghiscar/guard/hostile";
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		npcItemsInv.setMeleeWeapon(new ItemStack(GOTRegistry.essosPike));
		npcItemsInv.setIdleItem(npcItemsInv.getMeleeWeapon());
		setCurrentItemOrArmor(1, new ItemStack(GOTRegistry.gemsbokBoots));
		setCurrentItemOrArmor(2, new ItemStack(GOTRegistry.gemsbokLeggings));
		setCurrentItemOrArmor(3, new ItemStack(GOTRegistry.gemsbokChestplate));
		setCurrentItemOrArmor(4, new ItemStack(GOTRegistry.gemsbokHelmet));
		return data;
	}

	@Override
	public void setupNPCGender() {
		familyInfo.setMale(true);
	}
}
