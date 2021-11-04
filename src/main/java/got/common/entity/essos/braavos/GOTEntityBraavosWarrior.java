package got.common.entity.essos.braavos;

import got.common.database.*;
import got.common.item.other.GOTItemRobes;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class GOTEntityBraavosWarrior extends GOTEntityBraavosMan {
	public static ItemStack[] weaponsIron = new ItemStack[] { new ItemStack(GOTRegistry.essosSword), new ItemStack(GOTRegistry.essosSword), new ItemStack(GOTRegistry.essosSword), new ItemStack(GOTRegistry.essosHammer) };
	public static int[] turbanColors = new int[] { 1643539, 6309443, 7014914, 7809314, 5978155 };

	public GOTEntityBraavosWarrior(World world) {
		super(world);
		canBeMarried = false;
		addTargetTasks(true);
		spawnRidingHorse = false;
		npcShield = GOTShields.BRAAVOS;
	}

	@Override
	public void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(npcRangedAccuracy).setBaseValue(0.75);
	}

	@Override
	public float getAlignmentBonus() {
		return 2.0f;
	}

	@Override
	public String getSpeechBank(EntityPlayer entityplayer) {
		if (isFriendly(entityplayer)) {
			if (hiredNPCInfo.getHiringPlayer() == entityplayer) {
				return "essos/braavos/warrior/hired";
			}
			return "essos/braavos/warrior/friendly";
		}
		return "essos/braavos/warrior/hostile";
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		int i = rand.nextInt(weaponsIron.length);
		npcItemsInv.setMeleeWeapon(weaponsIron[i].copy());
		if (rand.nextInt(5) == 0) {
			npcItemsInv.setSpearBackup(npcItemsInv.getMeleeWeapon());
			npcItemsInv.setMeleeWeapon(new ItemStack(GOTRegistry.essosSpear));
		}
		npcItemsInv.setIdleItem(npcItemsInv.getMeleeWeapon());
		setCurrentItemOrArmor(1, new ItemStack(GOTRegistry.braavosBoots));
		setCurrentItemOrArmor(2, new ItemStack(GOTRegistry.braavosLeggings));
		setCurrentItemOrArmor(3, new ItemStack(GOTRegistry.braavosChestplate));
		ItemStack turban = new ItemStack(GOTRegistry.robesHelmet);
		int robeColor = turbanColors[rand.nextInt(turbanColors.length)];
		GOTItemRobes.setRobesColor(turban, robeColor);
		setCurrentItemOrArmor(4, turban);
		return data;
	}

	@Override
	public void setupNPCGender() {
		familyInfo.setMale(true);
	}
}
