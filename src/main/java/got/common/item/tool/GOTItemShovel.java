package got.common.item.tool;

import got.common.database.GOTCreativeTabs;
import got.common.item.*;
import net.minecraft.item.*;

public class GOTItemShovel extends ItemSpade implements GOTPotentialValyrianItem {
	public GOTMaterial gotMaterial;

	public GOTItemShovel(GOTMaterial material) {
		this(material.toToolMaterial());
		gotMaterial = material;
	}

	public GOTItemShovel(Item.ToolMaterial material) {
		super(material);
		setCreativeTab(GOTCreativeTabs.tabTools);
	}

	@Override
	public GOTMaterial getMaterial() {
		return gotMaterial;
	}
}
