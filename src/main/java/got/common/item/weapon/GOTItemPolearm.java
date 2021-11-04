package got.common.item.weapon;

import got.common.item.*;
import net.minecraft.item.*;

public class GOTItemPolearm extends GOTItemSword implements GOTPotentialValyrianItem {
	public GOTMaterial gotMaterial;

	public GOTItemPolearm(GOTMaterial material) {
		this(material.toToolMaterial());
		gotMaterial = material;
	}

	public GOTItemPolearm(Item.ToolMaterial material) {
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
