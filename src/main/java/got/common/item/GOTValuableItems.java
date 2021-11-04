package got.common.item;

import java.util.*;

import got.common.item.other.*;
import got.common.recipe.GOTRecipe;
import net.minecraft.item.*;

public class GOTValuableItems {
	public static List<ItemStack> toolMaterials = new ArrayList<>();
	public static boolean initTools = false;

	public static boolean canMagpieSteal(ItemStack itemstack) {
		GOTValuableItems.registerToolMaterials();
		Item item = itemstack.getItem();
		if (item instanceof GOTItemCoin || item instanceof GOTItemRing || item instanceof GOTItemGem) {
			return true;
		}
		for (ItemStack listItem : toolMaterials) {
			if (!GOTRecipe.checkItemEquals(listItem, itemstack)) {
				continue;
			}
			return true;
		}
		return false;
	}

	public static List<ItemStack> getToolMaterials() {
		GOTValuableItems.registerToolMaterials();
		return toolMaterials;
	}

	public static void registerToolMaterials() {
		if (!initTools) {
			toolMaterials.clear();
			for (Item.ToolMaterial material : Item.ToolMaterial.values()) {
				ItemStack repair;
				if (material.getHarvestLevel() < 2 || (repair = material.getRepairItemStack()) == null) {
					continue;
				}
				toolMaterials.add(repair.copy());
			}
			initTools = true;
		}
	}
}
