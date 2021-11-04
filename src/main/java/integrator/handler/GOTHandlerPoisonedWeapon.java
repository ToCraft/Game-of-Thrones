package integrator.handler;

import java.lang.reflect.Field;
import java.util.List;

import codechicken.nei.*;
import codechicken.nei.recipe.ShapelessRecipeHandler;
import got.common.database.GOTRegistry;
import got.common.recipe.GOTRecipePoisonWeapon;
import net.minecraft.item.*;
import net.minecraft.item.crafting.*;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class GOTHandlerPoisonedWeapon extends ShapelessRecipeHandler {
	public ShapelessRecipeHandler.CachedShapelessRecipe getPoisonRecipe(GOTRecipePoisonWeapon rec) {
		try {
			Field inputItem = rec.getClass().getDeclaredField("inputItem");
			Field resultItem = rec.getClass().getDeclaredField("resultItem");
			inputItem.setAccessible(true);
			resultItem.setAccessible(true);
			return forgeShapelessRecipe(new ShapelessOreRecipe(new ItemStack((Item) resultItem.get(rec)), inputItem.get(rec), GOTRegistry.bottlePoison));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void loadCraftingRecipes(ItemStack result) {
		List<IRecipe> allrecipes = CraftingManager.getInstance().getRecipeList();
		for (IRecipe irecipe : allrecipes) {
			ShapelessRecipeHandler.CachedShapelessRecipe recipe = null;
			if (!(irecipe instanceof GOTRecipePoisonWeapon)) {
				continue;
			}
			try {
				GOTRecipePoisonWeapon rec = (GOTRecipePoisonWeapon) irecipe;
				Field inputItem = rec.getClass().getDeclaredField("inputItem");
				Field resultItem = rec.getClass().getDeclaredField("resultItem");
				inputItem.setAccessible(true);
				resultItem.setAccessible(true);
				if (NEIServerUtils.areStacksSameTypeCrafting(new ItemStack((Item) resultItem.get(rec)), result)) {
					recipe = getPoisonRecipe((GOTRecipePoisonWeapon) irecipe);
				}
				if (recipe == null) {
					continue;
				}
				arecipes.add(recipe);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void loadCraftingRecipes(String outputId, Object... results) {
		this.loadCraftingRecipes((ItemStack) results[0]);
	}

	@Override
	public void loadUsageRecipes(ItemStack ingredient) {
		List<IRecipe> allrecipes = CraftingManager.getInstance().getRecipeList();
		for (IRecipe irecipe : allrecipes) {
			Object recipe = null;
			if (!(irecipe instanceof GOTRecipePoisonWeapon)) {
				continue;
			}
			try {
				GOTRecipePoisonWeapon rec = (GOTRecipePoisonWeapon) irecipe;
				Field inputItem = rec.getClass().getDeclaredField("inputItem");
				Field resultItem = rec.getClass().getDeclaredField("resultItem");
				inputItem.setAccessible(true);
				resultItem.setAccessible(true);
				ShapelessRecipeHandler.CachedShapelessRecipe csr = getPoisonRecipe((GOTRecipePoisonWeapon) irecipe);
				if (csr == null) {
					continue;
				}
				for (PositionedStack element : csr.getIngredients()) {
					if (!NEIServerUtils.areStacksSameType(element.item, ingredient) || arecipes.contains(recipe)) {
						continue;
					}
					csr.setIngredientPermutation(csr.ingredients, ingredient);
					arecipes.add(csr);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void loadUsageRecipes(String outputId, Object... results) {
		this.loadUsageRecipes((ItemStack) results[0]);
	}
}
