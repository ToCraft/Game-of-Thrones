package got.common.entity.essos.ghiscar;

import got.common.database.*;
import got.common.entity.other.GOTUnitTradeable;
import got.common.item.other.GOTItemRobes;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class GOTEntityGhiscarCaptain extends GOTEntityGhiscarWarlord implements GOTUnitTradeable {
	public static int[] turbanColors = new int[] { 1643539, 6309443, 7014914, 7809314, 5978155 };

	public GOTEntityGhiscarCaptain(World world) {
		super(world);
		canBeMarried = false;
	}

	@Override
	public GOTUnitTradeEntries getUnits() {
		return GOTUnitTradeEntries.GHISCAR_CORSAIR;
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		npcItemsInv.setMeleeWeapon(new ItemStack(GOTRegistry.essosPolearm));
		npcItemsInv.setIdleItem(npcItemsInv.getMeleeWeapon());
		setCurrentItemOrArmor(1, new ItemStack(GOTRegistry.ghiscarBoots));
		setCurrentItemOrArmor(2, new ItemStack(GOTRegistry.ghiscarLeggings));
		setCurrentItemOrArmor(3, new ItemStack(GOTRegistry.ghiscarChestplate));
		ItemStack turban = new ItemStack(GOTRegistry.robesHelmet);
		int robeColor = turbanColors[rand.nextInt(turbanColors.length)];
		GOTItemRobes.setRobesColor(turban, robeColor);
		setCurrentItemOrArmor(4, turban);
		return data;
	}
}
