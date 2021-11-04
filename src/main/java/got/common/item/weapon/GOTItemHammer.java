package got.common.item.weapon;

import got.common.item.*;
import net.minecraft.item.*;

public class GOTItemHammer extends GOTItemSword implements GOTPotentialValyrianItem {
	public GOTMaterial gotMaterial;

	public GOTItemHammer(GOTMaterial material) {
		this(material.toToolMaterial());
		gotWeaponDamage += 2.0f;
		gotMaterial = material;
	}

	public GOTItemHammer(Item.ToolMaterial material) {
		super(material);
	}

	@Override
	public EnumAction getItemUseAction(ItemStack itemstack) {
		return EnumAction.none;
	}

	@Override
	public GOTMaterial getMaterial() {
		return gotMaterial;
	}
}
