package got.common.item.tool;

import got.common.database.GOTCreativeTabs;
import got.common.item.*;
import net.minecraft.item.*;

public class GOTItemHoe extends ItemHoe implements GOTPotentialValyrianItem {
	public GOTMaterial gotMaterial;

	public GOTItemHoe(GOTMaterial material) {
		this(material.toToolMaterial());
		gotMaterial = material;
	}

	public GOTItemHoe(Item.ToolMaterial material) {
		super(material);
		setCreativeTab(GOTCreativeTabs.tabTools);
	}

	@Override
	public GOTMaterial getMaterial() {
		return gotMaterial;
	}
}
