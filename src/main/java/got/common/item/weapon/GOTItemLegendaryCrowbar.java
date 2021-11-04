package got.common.item.weapon;

import got.common.item.GOTMaterial;

public class GOTItemLegendaryCrowbar extends GOTItemSword {
	public GOTItemLegendaryCrowbar() {
		super(GOTMaterial.STEEL);
		setMaxDamage(1500);
		gotWeaponDamage = 999.0f;
		setCreativeTab(null);
	}
}