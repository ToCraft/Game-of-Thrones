package got.common.entity.essos.myr;

import got.common.database.*;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class GOTEntityMyrLegionary extends GOTEntityMyrWarrior {
	public GOTEntityMyrLegionary(World world) {
		super(world);
		canBeMarried = false;
		spawnRidingHorse = false;
		npcCape = GOTCapes.MYR;
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		npcItemsInv.setMeleeWeapon(new ItemStack(GOTRegistry.essosPike));
		npcItemsInv.setIdleItem(npcItemsInv.getMeleeWeapon());
		setCurrentItemOrArmor(1, new ItemStack(GOTRegistry.myrBoots));
		setCurrentItemOrArmor(2, new ItemStack(GOTRegistry.myrLeggings));
		setCurrentItemOrArmor(3, new ItemStack(GOTRegistry.myrChestplate));
		setCurrentItemOrArmor(4, new ItemStack(GOTRegistry.myrHelmet));
		return data;
	}
}
