package got.common.item.weapon;

import got.common.database.GOTCreativeTabs;
import got.common.item.*;

public class GOTItemLegendaryHammer extends GOTItemHammer implements GOTPotentialValyrianItem {
	public GOTMaterial gotMaterial;

	public GOTItemLegendaryHammer(GOTMaterial material) {
		super(material);
		setMaxDamage(1500);
		gotWeaponDamage = 12.0f;
		setCreativeTab(GOTCreativeTabs.tabStory);
		gotMaterial = material;
	}

	@Override
	public GOTMaterial getMaterial() {
		return gotMaterial;
	}
}
