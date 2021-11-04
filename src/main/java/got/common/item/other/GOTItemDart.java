package got.common.item.other;

import got.common.database.GOTCreativeTabs;
import got.common.dispense.GOTDispenseDart;
import got.common.entity.other.GOTEntityDart;
import net.minecraft.block.BlockDispenser;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.*;
import net.minecraft.world.World;

public class GOTItemDart extends Item {
	public boolean isPoisoned = false;

	public GOTItemDart() {
		setCreativeTab(GOTCreativeTabs.tabCombat);
		BlockDispenser.dispenseBehaviorRegistry.putObject(this, new GOTDispenseDart(this));
	}

	public GOTEntityDart createDart(World world, EntityLivingBase entity, EntityLivingBase target, ItemStack itemstack, float charge, float inaccuracy) {
		GOTEntityDart dart = new GOTEntityDart(world, entity, target, itemstack, charge, inaccuracy);
		return dart;
	}

	public GOTEntityDart createDart(World world, EntityLivingBase entity, ItemStack itemstack, float charge) {
		GOTEntityDart dart = new GOTEntityDart(world, entity, itemstack, charge);
		return dart;
	}

	public GOTEntityDart createDart(World world, ItemStack itemstack, double d, double d1, double d2) {
		GOTEntityDart dart = new GOTEntityDart(world, itemstack, d, d1, d2);
		return dart;
	}

	public GOTItemDart setPoisoned() {
		isPoisoned = true;
		return this;
	}
}
