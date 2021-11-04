package got.common.item.weapon;

import got.common.item.*;
import net.minecraft.item.Item;

public class GOTItemPolearmLong extends GOTItemPolearm implements GOTPotentialValyrianItem {
	public GOTMaterial gotMaterial;

	public GOTItemPolearmLong(GOTMaterial material) {
		this(material.toToolMaterial());
		gotMaterial = material;
	}

	public GOTItemPolearmLong(Item.ToolMaterial material) {
		super(material);
	}

	@Override
	public GOTMaterial getMaterial() {
		return gotMaterial;
	}
}
