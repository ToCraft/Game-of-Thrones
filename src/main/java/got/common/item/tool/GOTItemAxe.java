package got.common.item.tool;

import got.common.database.GOTCreativeTabs;
import got.common.item.*;
import net.minecraft.item.*;

public class GOTItemAxe extends ItemAxe implements GOTPotentialValyrianItem {
	public GOTMaterial gotMaterial;

	public GOTItemAxe(GOTMaterial material) {
		this(material.toToolMaterial());
		gotMaterial = material;
	}

	public GOTItemAxe(Item.ToolMaterial material) {
		super(material);
		setCreativeTab(GOTCreativeTabs.tabTools);
		setHarvestLevel("axe", material.getHarvestLevel());
	}

	@Override
	public GOTMaterial getMaterial() {
		return gotMaterial;
	}
}
