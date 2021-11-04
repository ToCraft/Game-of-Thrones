package got.common.item.weapon;

import got.common.database.GOTCreativeTabs;
import got.common.item.GOTMaterial;

public class GOTItemLegendaryCrossbow extends GOTItemCrossbow {
	public GOTItemLegendaryCrossbow() {
		super(GOTMaterial.STEEL);
		setMaxDamage(1500);
		setCreativeTab(GOTCreativeTabs.tabStory);
	}
}
