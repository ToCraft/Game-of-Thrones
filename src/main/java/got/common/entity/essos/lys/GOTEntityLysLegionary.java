package got.common.entity.essos.lys;

import got.common.database.*;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class GOTEntityLysLegionary extends GOTEntityLysWarrior {
	public GOTEntityLysLegionary(World world) {
		super(world);
		canBeMarried = false;
		spawnRidingHorse = false;
		npcCape = GOTCapes.LYS;
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		npcItemsInv.setMeleeWeapon(new ItemStack(GOTRegistry.essosPike));
		npcItemsInv.setIdleItem(npcItemsInv.getMeleeWeapon());
		setCurrentItemOrArmor(1, new ItemStack(GOTRegistry.lysBoots));
		setCurrentItemOrArmor(2, new ItemStack(GOTRegistry.lysLeggings));
		setCurrentItemOrArmor(3, new ItemStack(GOTRegistry.lysChestplate));
		setCurrentItemOrArmor(4, new ItemStack(GOTRegistry.lysHelmet));
		return data;
	}
}
