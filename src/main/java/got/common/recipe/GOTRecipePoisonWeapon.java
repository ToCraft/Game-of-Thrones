package got.common.recipe;

import java.util.*;

import got.GOT;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.*;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class GOTRecipePoisonWeapon implements IRecipe {
	public static Map<Item, Item> inputToPoisoned = new HashMap<>();
	public static Map<Item, Item> poisonedToInput = new HashMap<>();
	public Item inputItem;
	public Item resultItem;
	public Object catalystObj;

	public GOTRecipePoisonWeapon(Item item1, Item item2) {
		this(item1, item2, "poison");
		inputToPoisoned.put(item1, item2);
		poisonedToInput.put(item2, item1);
	}

	public GOTRecipePoisonWeapon(Item item1, Item item2, Object cat) {
		inputItem = item1;
		resultItem = item2;
		catalystObj = cat;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting inv) {
		ItemStack weapon = null;
		ItemStack catalyst = null;
		for (int i = 0; i < inv.getSizeInventory(); ++i) {
			ItemStack itemstack = inv.getStackInSlot(i);
			if (itemstack == null) {
				continue;
			}
			if (itemstack.getItem() == inputItem) {
				if (weapon != null) {
					return null;
				}
				weapon = itemstack.copy();
				continue;
			}
			if (matchesCatalyst(itemstack)) {
				if (catalyst != null) {
					return null;
				}
				catalyst = itemstack.copy();
				continue;
			}
			return null;
		}
		if (weapon == null || catalyst == null) {
			return null;
		}
		ItemStack result = new ItemStack(resultItem);
		result.setItemDamage(weapon.getItemDamage());
		if (weapon.hasTagCompound()) {
			NBTTagCompound nbt = (NBTTagCompound) weapon.getTagCompound().copy();
			result.setTagCompound(nbt);
		}
		return result;
	}

	public ItemStack getInputItem() {
		return new ItemStack(inputItem);
	}

	@Override
	public ItemStack getRecipeOutput() {
		return new ItemStack(resultItem);
	}

	@Override
	public int getRecipeSize() {
		return 2;
	}

	@Override
	public boolean matches(InventoryCrafting inv, World world) {
		ItemStack weapon = null;
		ItemStack catalyst = null;
		for (int i = 0; i < inv.getSizeInventory(); ++i) {
			ItemStack itemstack = inv.getStackInSlot(i);
			if (itemstack == null) {
				continue;
			}
			if (itemstack.getItem() == inputItem) {
				if (weapon != null) {
					return false;
				}
				weapon = itemstack;
				continue;
			}
			if (matchesCatalyst(itemstack)) {
				if (catalyst != null) {
					return false;
				}
				catalyst = itemstack;
				continue;
			}
			return false;
		}
		return weapon != null && catalyst != null;
	}

	public boolean matchesCatalyst(ItemStack itemstack) {
		if (catalystObj instanceof String) {
			return GOT.isOreNameEqual(itemstack, (String) catalystObj);
		}
		if (catalystObj instanceof Item) {
			return itemstack.getItem() == (Item) catalystObj;
		}
		if (catalystObj instanceof ItemStack) {
			return GOTRecipe.checkItemEquals((ItemStack) catalystObj, itemstack);
		}
		return false;
	}
}
