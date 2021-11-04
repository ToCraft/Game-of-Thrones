package got.common.item;

import java.util.*;

import got.common.database.GOTRegistry;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class GOTMaterial {
	public static float[] protectionBase = new float[] { 0.14f, 0.4f, 0.32f, 0.14f };
	public static float maxProtection = 25.0f;
	public static List<GOTMaterial> allGOTMaterials = new ArrayList<>();
	public static ToolMaterial LOG = EnumHelper.addToolMaterial("LOG", 0, 59, 2.0F, 0.0F, 15);
	public static ToolMaterial ROCK = EnumHelper.addToolMaterial("ROCK", 1, 131, 4.0F, 1.0F, 5);
	public static ToolMaterial STEEL = EnumHelper.addToolMaterial("STEEL_ARMOR", 2, 250, 6.0F, 2.0F, 14);

	public static GOTMaterial ANONYMOUS = new GOTMaterial("ANONYMOUS").setUses(150).setDamage(0f).setProtection(0f).setSpeed(0f).setHarvestLevel(0).setEnchantability(0);
	public static GOTMaterial ARRYN = new GOTMaterial("ARRYN").setUses(300).setDamage(2.5f).setProtection(0.5f).setSpeed(2.0f).setHarvestLevel(6).setEnchantability(10);
	public static GOTMaterial ARRYNGUARD = new GOTMaterial("ARRYNGUARD").setUses(500).setDamage(3.0f).setProtection(0.6f).setHarvestLevel(2).setSpeed(6.0f).setEnchantability(10);
	public static GOTMaterial ASSHAI = new GOTMaterial("ASSHAI").setUses(300).setDamage(2.5f).setProtection(0.5f).setSpeed(2.0f).setHarvestLevel(6).setEnchantability(10);
	public static GOTMaterial BLACKFYRE = new GOTMaterial("BLACKFYRE").setUses(500).setDamage(3.0f).setProtection(0.6f).setHarvestLevel(2).setSpeed(6.0f).setEnchantability(10);
	public static GOTMaterial BONE = new GOTMaterial("BONE").setUses(150).setDamage(0.0f).setProtection(0.3f).setHarvestLevel(0).setSpeed(0.0f).setEnchantability(10);
	public static GOTMaterial BRAAVOS = new GOTMaterial("BRAAVOS").setUses(300).setDamage(2.5f).setProtection(0.5f).setSpeed(2.0f).setHarvestLevel(6).setEnchantability(10);
	public static GOTMaterial BRONZE = new GOTMaterial("BRONZE").setUses(230).setDamage(1.5f).setProtection(0.5f).setHarvestLevel(2).setSpeed(5.0f).setEnchantability(10);
	public static GOTMaterial COBALT = new GOTMaterial("COBALT").setUses(800).setDamage(3.0f).setProtection(0.7f).setHarvestLevel(4).setSpeed(8.5f).setEnchantability(10);
	public static GOTMaterial COSMETIC = new GOTMaterial("COSMETIC").setUndamageable().setUses(0).setDamage(0.0f).setProtection(0.0f).setEnchantability(0);
	public static GOTMaterial CROWNLANDS = new GOTMaterial("CROWNLANDS").setUses(300).setDamage(2.5f).setProtection(0.5f).setSpeed(2.0f).setHarvestLevel(6).setEnchantability(10);
	public static GOTMaterial DORNE = new GOTMaterial("DORNE").setUses(300).setDamage(2.5f).setProtection(0.5f).setSpeed(2.0f).setHarvestLevel(6).setEnchantability(10);
	public static GOTMaterial DOTHRAKI = new GOTMaterial("DOTHRAKI").setUses(300).setDamage(2.5f).setProtection(0.5f).setHarvestLevel(2).setSpeed(6.0f).setEnchantability(10);
	public static GOTMaterial DRAGONSTONE = new GOTMaterial("DRAGONSTONE").setUses(300).setDamage(2.5f).setProtection(0.5f).setSpeed(2.0f).setHarvestLevel(6).setEnchantability(10);
	public static GOTMaterial FLINT = new GOTMaterial("FLINT").setUses(300).setDamage(2.5f).setProtection(0.5f).setSpeed(2.0f).setHarvestLevel(6).setEnchantability(10);
	public static GOTMaterial FUR = new GOTMaterial("FUR").setUses(180).setDamage(0.0f).setProtection(0.4f).setHarvestLevel(0).setSpeed(0.0f).setEnchantability(8);
	public static GOTMaterial GEMSBOK = new GOTMaterial("GEMSBOK").setUses(180).setDamage(0.0f).setProtection(0.4f).setHarvestLevel(0).setSpeed(0.0f).setEnchantability(10);
	public static GOTMaterial GHISCAR = new GOTMaterial("GHISCAR").setUses(300).setDamage(2.5f).setProtection(0.5f).setSpeed(2.0f).setHarvestLevel(6).setEnchantability(10);
	public static GOTMaterial GIFT = new GOTMaterial("GIFT").setUses(350).setDamage(2.5f).setProtection(0.48f).setHarvestLevel(2).setSpeed(6.0f).setEnchantability(12);
	public static GOTMaterial GOLDENCOMPANY = new GOTMaterial("GOLDENCOMPANY").setUses(450).setDamage(2.5f).setProtection(0.6f).setHarvestLevel(2).setSpeed(6.0f).setEnchantability(10);
	public static GOTMaterial HAND = new GOTMaterial("HAND").setUses(500).setDamage(3.0f).setProtection(0.6f).setHarvestLevel(2).setSpeed(6.0f).setEnchantability(10);
	public static GOTMaterial HELMET = new GOTMaterial("HELMET").setUses(500).setDamage(3.0f).setProtection(0.6f).setHarvestLevel(2).setSpeed(6.0f).setEnchantability(10);
	public static GOTMaterial HILLMEN = new GOTMaterial("HILLMEN").setUses(250).setDamage(2.0f).setProtection(0.5f).setHarvestLevel(2).setSpeed(6.0f).setEnchantability(8);
	public static GOTMaterial ICE = new GOTMaterial("ICE").setUses(500).setDamage(3.0f).setProtection(0.7f).setHarvestLevel(2).setSpeed(6.0f).setEnchantability(5).setManFlesh();
	public static GOTMaterial IRONBORN = new GOTMaterial("IRONBORN").setUses(300).setDamage(2.5f).setProtection(0.5f).setSpeed(2.0f).setHarvestLevel(6).setEnchantability(10);
	public static GOTMaterial JACKET = new GOTMaterial("JACKET").setUses(150).setDamage(0.0f).setProtection(0.4f).setHarvestLevel(0).setSpeed(0.0f).setEnchantability(10);
	public static GOTMaterial KAFTAN = new GOTMaterial("KAFTAN").setUndamageable().setUses(0).setDamage(0.0f).setProtection(0.0f).setEnchantability(0);
	public static GOTMaterial KINGSGUARD = new GOTMaterial("KINGSGUARD").setUses(500).setDamage(3.0f).setProtection(0.6f).setHarvestLevel(2).setSpeed(6.0f).setEnchantability(10);
	public static GOTMaterial LHAZAR = new GOTMaterial("LHAZAR").setUses(250).setDamage(2.0f).setProtection(0.48f).setHarvestLevel(2).setSpeed(6.0f).setEnchantability(10);
	public static GOTMaterial LHAZAR_LION = new GOTMaterial("LHAZAR_LION").setUses(300).setDamage(0.0f).setProtection(0.4f).setHarvestLevel(0).setSpeed(0.0f).setEnchantability(8);
	public static GOTMaterial LORATH = new GOTMaterial("LORATH").setUses(300).setDamage(2.5f).setProtection(0.5f).setSpeed(2.0f).setHarvestLevel(6).setEnchantability(10);
	public static GOTMaterial LYS = new GOTMaterial("LYS").setUses(300).setDamage(2.5f).setProtection(0.5f).setSpeed(2.0f).setHarvestLevel(6).setEnchantability(10);
	public static GOTMaterial NORTHGUARD = new GOTMaterial("NORTHGUARD").setUses(300).setDamage(2.5f).setProtection(0.5f).setSpeed(2.0f).setHarvestLevel(6).setEnchantability(10);
	public static GOTMaterial MOSSOVY = new GOTMaterial("MOSSOVY").setUses(550).setDamage(3.0f).setProtection(0.7f).setHarvestLevel(2).setSpeed(6.0f).setEnchantability(5).setManFlesh();
	public static GOTMaterial MYR = new GOTMaterial("MYR").setUses(300).setDamage(2.5f).setProtection(0.5f).setSpeed(2.0f).setHarvestLevel(6).setEnchantability(10);
	public static GOTMaterial NORTH = new GOTMaterial("NORTH").setUses(300).setDamage(2.5f).setProtection(0.5f).setSpeed(2.0f).setHarvestLevel(6).setEnchantability(10);
	public static GOTMaterial NORVOS = new GOTMaterial("NORVOS").setUses(300).setDamage(2.5f).setProtection(0.5f).setSpeed(2.0f).setHarvestLevel(6).setEnchantability(10);
	public static GOTMaterial PENTOS = new GOTMaterial("PENTOS").setUses(300).setDamage(2.5f).setProtection(0.5f).setSpeed(2.0f).setHarvestLevel(6).setEnchantability(10);
	public static GOTMaterial QARTH = new GOTMaterial("QARTH").setUses(300).setDamage(2.5f).setProtection(0.5f).setSpeed(2.0f).setHarvestLevel(6).setEnchantability(10);
	public static GOTMaterial QOHOR = new GOTMaterial("QOHOR").setUses(300).setDamage(2.5f).setProtection(0.5f).setSpeed(2.0f).setHarvestLevel(6).setEnchantability(10);
	public static GOTMaterial REACH = new GOTMaterial("REACH").setUses(300).setDamage(2.5f).setProtection(0.5f).setSpeed(2.0f).setHarvestLevel(6).setEnchantability(10);
	public static GOTMaterial REACHGUARD = new GOTMaterial("REACHGUARD").setUses(500).setDamage(3.0f).setProtection(0.6f).setHarvestLevel(2).setSpeed(6.0f).setEnchantability(10);
	public static GOTMaterial REDKING = new GOTMaterial("REDKING").setUses(500).setDamage(3.0f).setProtection(0.6f).setHarvestLevel(2).setSpeed(6.0f).setEnchantability(10);
	public static GOTMaterial RENLY = new GOTMaterial("RENLY").setUses(300).setDamage(2.5f).setProtection(0.5f).setSpeed(2.0f).setHarvestLevel(6).setEnchantability(10);
	public static GOTMaterial RIVERLANDS = new GOTMaterial("RIVERLANDS").setUses(300).setDamage(2.5f).setProtection(0.5f).setSpeed(2.0f).setHarvestLevel(6).setEnchantability(10);
	public static GOTMaterial ROBES = new GOTMaterial("ROBES").setUndamageable().setUses(0).setDamage(0.0f).setProtection(0.0f).setEnchantability(0);
	public static GOTMaterial ROYCE = new GOTMaterial("ROYCE").setUses(500).setDamage(3.0f).setProtection(0.6f).setHarvestLevel(2).setSpeed(6.0f).setEnchantability(10);
	public static GOTMaterial SILVER = new GOTMaterial("SILVER").setUses(500).setDamage(3.0f).setProtection(0.6f).setHarvestLevel(2).setSpeed(6.0f).setEnchantability(10);
	public static GOTMaterial SOTHORYOS = new GOTMaterial("SOTHORYOS").setUses(300).setDamage(2.5f).setProtection(0.5f).setHarvestLevel(3).setSpeed(8.0f).setEnchantability(10);
	public static GOTMaterial SOTHORYOS_GOLD = new GOTMaterial("SOTHORYOS_GOLD").setUses(400).setDamage(0.0f).setProtection(0.6f).setHarvestLevel(0).setSpeed(0.0f).setEnchantability(10);
	public static GOTMaterial STORMLANDS = new GOTMaterial("STORMLANDS").setUses(300).setDamage(2.5f).setProtection(0.5f).setSpeed(2.0f).setHarvestLevel(6).setEnchantability(10);
	public static GOTMaterial SUMMER = new GOTMaterial("SUMMER").setUses(250).setDamage(2.0f).setProtection(0.5f).setHarvestLevel(2).setSpeed(6.0f).setEnchantability(8);
	public static GOTMaterial TARGARYEN = new GOTMaterial("TARGARYEN").setUses(450).setDamage(2.5f).setProtection(0.6f).setHarvestLevel(2).setSpeed(6.0f).setEnchantability(10);
	public static GOTMaterial TYROSH = new GOTMaterial("TYROSH").setUses(300).setDamage(2.5f).setProtection(0.5f).setSpeed(2.0f).setHarvestLevel(6).setEnchantability(10);
	public static GOTMaterial UNSULLIED = new GOTMaterial("UNSULLIED").setUses(500).setDamage(3.0f).setProtection(0.6f).setHarvestLevel(2).setSpeed(6.0f).setEnchantability(10);
	public static GOTMaterial VALYRIAN = new GOTMaterial("VALYRIAN").setUses(2400).setDamage(5.0f).setProtection(0.8f).setHarvestLevel(4).setSpeed(9.0f).setEnchantability(8);
	public static GOTMaterial VOLANTIS = new GOTMaterial("VOLANTIS").setUses(300).setDamage(2.5f).setProtection(0.5f).setSpeed(2.0f).setHarvestLevel(6).setEnchantability(10);
	public static GOTMaterial WESTERLANDS = new GOTMaterial("WESTERLANDS").setUses(300).setDamage(2.5f).setProtection(0.5f).setSpeed(2.0f).setHarvestLevel(6).setEnchantability(10);
	public static GOTMaterial WESTERLANDSGUARD = new GOTMaterial("WESTERLANDSGUARD").setUses(500).setDamage(3.0f).setProtection(0.6f).setHarvestLevel(2).setSpeed(6.0f).setEnchantability(10);
	public static GOTMaterial WESTKING = new GOTMaterial("WESTKING").setUses(500).setDamage(3.0f).setProtection(0.6f).setHarvestLevel(2).setSpeed(6.0f).setEnchantability(10);
	public static GOTMaterial WILDLING = new GOTMaterial("WILDLING").setUses(350).setDamage(2.5f).setProtection(0.6f).setHarvestLevel(2).setSpeed(6.0f).setEnchantability(8).setManFlesh();
	public static GOTMaterial YITI = new GOTMaterial("YITI").setUses(400).setDamage(2.5f).setProtection(0.5f).setHarvestLevel(2).setSpeed(6.0f).setEnchantability(10);
	public static GOTMaterial YITI_SAMURAI = new GOTMaterial("YITI_SAMURAI").setUses(450).setDamage(2.5f).setProtection(0.6f).setHarvestLevel(2).setSpeed(6.0f).setEnchantability(10);
	public String materialName;

	public boolean undamageable = false;
	public int uses;
	public float damage;
	public int[] protection;
	public int harvestLevel;
	public float speed;
	public int enchantability;
	public boolean canHarvestManFlesh = false;
	public Item.ToolMaterial toolMaterial;
	public ItemArmor.ArmorMaterial armorMaterial;

	public GOTMaterial(String name) {
		materialName = "GOT_" + name;
		allGOTMaterials.add(this);
	}

	public boolean canHarvestManFlesh() {
		return canHarvestManFlesh;
	}

	public boolean isDamageable() {
		return !undamageable;
	}

	public void setCraftingItem(Item item) {
		setCraftingItems(item, item);
	}

	public void setCraftingItems(Item toolItem, Item armorItem) {
		toToolMaterial().setRepairItem(new ItemStack(toolItem));
		toArmorMaterial().customCraftingMaterial = armorItem;
	}

	public GOTMaterial setDamage(float f) {
		damage = f;
		return this;
	}

	public GOTMaterial setEnchantability(int i) {
		enchantability = i;
		return this;
	}

	public GOTMaterial setHarvestLevel(int i) {
		harvestLevel = i;
		return this;
	}

	public GOTMaterial setManFlesh() {
		canHarvestManFlesh = true;
		return this;
	}

	public GOTMaterial setProtection(float f) {
		protection = new int[protectionBase.length];
		for (int i = 0; i < protection.length; ++i) {
			protection[i] = Math.round(protectionBase[i] * f * maxProtection);
		}
		return this;
	}

	public GOTMaterial setSpeed(float f) {
		speed = f;
		return this;
	}

	public GOTMaterial setUndamageable() {
		undamageable = true;
		return this;
	}

	public GOTMaterial setUses(int i) {
		uses = i;
		return this;
	}

	public ItemArmor.ArmorMaterial toArmorMaterial() {
		if (armorMaterial == null) {
			armorMaterial = EnumHelper.addArmorMaterial(materialName, Math.round(uses * 0.06f), protection, enchantability);
		}
		return armorMaterial;
	}

	public Item.ToolMaterial toToolMaterial() {
		if (toolMaterial == null) {
			toolMaterial = EnumHelper.addToolMaterial(materialName, harvestLevel, uses, speed, damage, enchantability);
		}
		return toolMaterial;
	}

	public static ItemArmor.ArmorMaterial getArmorMaterialByName(String name) {
		return ItemArmor.ArmorMaterial.valueOf(name);
	}

	public static Item.ToolMaterial getToolMaterialByName(String name) {
		return Item.ToolMaterial.valueOf(name);
	}

	public static void onInit() {
		LOG.setRepairItem(new ItemStack(Blocks.planks));
		ROCK.setRepairItem(new ItemStack(Blocks.stone));
		ARRYN.setCraftingItem(Items.iron_ingot);
		ARRYNGUARD.setCraftingItem(Items.iron_ingot);
		ASSHAI.setCraftingItem(Items.iron_ingot);
		BLACKFYRE.setCraftingItem(Items.iron_ingot);
		BRAAVOS.setCraftingItem(Items.iron_ingot);
		BRONZE.setCraftingItem(GOTRegistry.bronzeIngot);
		COBALT.setCraftingItem(GOTRegistry.alloySteelIgnot);
		CROWNLANDS.setCraftingItem(Items.iron_ingot);
		DORNE.setCraftingItem(Items.iron_ingot);
		DOTHRAKI.setCraftingItem(Items.iron_ingot);
		DRAGONSTONE.setCraftingItem(Items.iron_ingot);
		FLINT.setCraftingItem(Items.flint);
		FUR.setCraftingItem(GOTRegistry.fur);
		GEMSBOK.setCraftingItem(GOTRegistry.gemsbokHide);
		GHISCAR.setCraftingItem(Items.iron_ingot);
		GIFT.setCraftingItems(Items.iron_ingot, Items.leather);
		GOLDENCOMPANY.setCraftingItem(Items.iron_ingot);
		HAND.setCraftingItem(Items.gold_ingot);
		HELMET.setCraftingItem(Items.iron_ingot);
		HILLMEN.setCraftingItem(Items.iron_ingot);
		STEEL.setRepairItem(new ItemStack(Items.iron_ingot));
		ICE.setCraftingItem(Item.getItemFromBlock(Blocks.ice));
		IRONBORN.setCraftingItem(Items.iron_ingot);
		JACKET.setCraftingItem(Items.leather);
		KINGSGUARD.setCraftingItem(Items.iron_ingot);
		LHAZAR.setCraftingItem(GOTRegistry.gemsbokHide);
		LHAZAR_LION.setCraftingItem(GOTRegistry.lionFur);
		LORATH.setCraftingItem(Items.iron_ingot);
		LYS.setCraftingItem(Items.iron_ingot);
		NORTHGUARD.setCraftingItem(Items.iron_ingot);
		MOSSOVY.setCraftingItem(Items.iron_ingot);
		MYR.setCraftingItem(Items.iron_ingot);
		NORTH.setCraftingItem(Items.iron_ingot);
		NORVOS.setCraftingItem(Items.iron_ingot);
		PENTOS.setCraftingItem(Items.iron_ingot);
		QARTH.setCraftingItem(Items.iron_ingot);
		QOHOR.setCraftingItem(Items.iron_ingot);
		REACH.setCraftingItem(Items.iron_ingot);
		REACHGUARD.setCraftingItem(Items.iron_ingot);
		REDKING.setCraftingItem(Items.iron_ingot);
		RIVERLANDS.setCraftingItem(Items.iron_ingot);
		ROYCE.setCraftingItem(GOTRegistry.bronzeIngot);
		SILVER.setCraftingItem(GOTRegistry.silverIngot);
		SOTHORYOS.setCraftingItems(GOTRegistry.obsidianShard, GOTRegistry.bronzeIngot);
		SOTHORYOS_GOLD.setCraftingItem(Items.gold_ingot);
		STORMLANDS.setCraftingItem(Items.iron_ingot);
		SUMMER.setCraftingItem(GOTRegistry.bronzeIngot);
		TARGARYEN.setCraftingItem(Items.iron_ingot);
		TYROSH.setCraftingItem(Items.iron_ingot);
		UNSULLIED.setCraftingItem(Items.iron_ingot);
		VALYRIAN.setCraftingItems(GOTRegistry.valyrianIngot, GOTRegistry.valyrianMail);
		VOLANTIS.setCraftingItem(Items.iron_ingot);
		WESTERLANDS.setCraftingItem(Items.iron_ingot);
		WESTERLANDSGUARD.setCraftingItem(Items.iron_ingot);
		WESTKING.setCraftingItem(Items.iron_ingot);
		WILDLING.setCraftingItem(Items.iron_ingot);
		YITI.setCraftingItem(Items.iron_ingot);
		YITI_SAMURAI.setCraftingItem(GOTRegistry.yitiSteelIngot);
		ANONYMOUS.setCraftingItem(Items.paper);
		RENLY.setCraftingItem(Items.iron_ingot);
	}
}
