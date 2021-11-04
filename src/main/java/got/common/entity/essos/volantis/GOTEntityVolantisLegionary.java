package got.common.entity.essos.volantis;

import got.common.database.*;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class GOTEntityVolantisLegionary extends GOTEntityVolantisWarrior {
	public GOTEntityVolantisLegionary(World world) {
		super(world);
		canBeMarried = false;
		spawnRidingHorse = false;
		npcCape = GOTCapes.VOLANTIS;
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		npcItemsInv.setMeleeWeapon(new ItemStack(GOTRegistry.essosPike));
		npcItemsInv.setIdleItem(npcItemsInv.getMeleeWeapon());
		setCurrentItemOrArmor(1, new ItemStack(GOTRegistry.volantisBoots));
		setCurrentItemOrArmor(2, new ItemStack(GOTRegistry.volantisLeggings));
		setCurrentItemOrArmor(3, new ItemStack(GOTRegistry.volantisChestplate));
		setCurrentItemOrArmor(4, new ItemStack(GOTRegistry.volantisHelmet));
		return data;
	}
}
