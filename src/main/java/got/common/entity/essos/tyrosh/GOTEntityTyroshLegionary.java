package got.common.entity.essos.tyrosh;

import got.common.database.*;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class GOTEntityTyroshLegionary extends GOTEntityTyroshWarrior {
	public GOTEntityTyroshLegionary(World world) {
		super(world);
		canBeMarried = false;
		spawnRidingHorse = false;
		npcCape = GOTCapes.TYROSH;
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		npcItemsInv.setMeleeWeapon(new ItemStack(GOTRegistry.essosPike));
		npcItemsInv.setIdleItem(npcItemsInv.getMeleeWeapon());
		setCurrentItemOrArmor(1, new ItemStack(GOTRegistry.tyroshBoots));
		setCurrentItemOrArmor(2, new ItemStack(GOTRegistry.tyroshLeggings));
		setCurrentItemOrArmor(3, new ItemStack(GOTRegistry.tyroshChestplate));
		setCurrentItemOrArmor(4, new ItemStack(GOTRegistry.tyroshHelmet));
		return data;
	}
}
