package got.common.entity.essos.braavos;

import got.common.database.*;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class GOTEntityBraavosLegionary extends GOTEntityBraavosWarrior {
	public GOTEntityBraavosLegionary(World world) {
		super(world);
		canBeMarried = false;
		spawnRidingHorse = false;
		npcCape = GOTCapes.BRAAVOS;
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		npcItemsInv.setMeleeWeapon(new ItemStack(GOTRegistry.essosPike));
		npcItemsInv.setIdleItem(npcItemsInv.getMeleeWeapon());
		setCurrentItemOrArmor(1, new ItemStack(GOTRegistry.braavosBoots));
		setCurrentItemOrArmor(2, new ItemStack(GOTRegistry.braavosLeggings));
		setCurrentItemOrArmor(3, new ItemStack(GOTRegistry.braavosChestplate));
		setCurrentItemOrArmor(4, new ItemStack(GOTRegistry.braavosHelmet));
		return data;
	}
}
