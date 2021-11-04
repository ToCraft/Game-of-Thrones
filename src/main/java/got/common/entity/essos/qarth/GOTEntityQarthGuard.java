package got.common.entity.essos.qarth;

import got.common.database.*;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class GOTEntityQarthGuard extends GOTEntityQarthWarrior {
	public GOTEntityQarthGuard(World world) {
		super(world);
		canBeMarried = false;
		spawnRidingHorse = false;
		npcCape = GOTCapes.QARTH;
		addTargetTasks(false);
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		npcItemsInv.setMeleeWeapon(new ItemStack(GOTRegistry.essosPike));
		npcItemsInv.setIdleItem(npcItemsInv.getMeleeWeapon());
		setCurrentItemOrArmor(1, new ItemStack(GOTRegistry.qarthBoots));
		setCurrentItemOrArmor(2, new ItemStack(GOTRegistry.qarthLeggings));
		setCurrentItemOrArmor(3, new ItemStack(GOTRegistry.qarthChestplate));
		setCurrentItemOrArmor(4, new ItemStack(GOTRegistry.qarthHelmet));
		return data;
	}
}
