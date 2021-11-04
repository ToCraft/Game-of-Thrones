package got.common.item.tool;

import got.common.database.GOTCreativeTabs;
import got.common.item.*;
import net.minecraft.item.*;

public class GOTItemPickaxe extends ItemPickaxe implements GOTPotentialValyrianItem {
	public GOTMaterial gotMaterial;

	public GOTItemPickaxe(GOTMaterial material) {
		this(material.toToolMaterial());
		gotMaterial = material;
	}

	public GOTItemPickaxe(Item.ToolMaterial material) {
		super(material);
		setCreativeTab(GOTCreativeTabs.tabTools);
	}

	@Override
	public GOTMaterial getMaterial() {
		return gotMaterial;
	}
}
