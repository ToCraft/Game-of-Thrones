package got.common.item.weapon;

import got.common.item.*;
import net.minecraft.item.Item;

public class GOTItemPike extends GOTItemPolearmLong implements GOTPotentialValyrianItem {
	public GOTMaterial gotMaterial;

	public GOTItemPike(GOTMaterial material) {
		this(material.toToolMaterial());
		gotMaterial = material;
	}

	public GOTItemPike(Item.ToolMaterial material) {
		super(material);
	}

	@Override
	public GOTMaterial getMaterial() {
		return gotMaterial;
	}
}
