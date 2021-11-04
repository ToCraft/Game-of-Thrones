package got.common.entity.essos.lorath;

import got.common.entity.other.GOTBannerBearer;
import got.common.item.other.GOTItemBanner;
import net.minecraft.world.World;

public class GOTEntityLorathBannerBearer extends GOTEntityLorathWarrior implements GOTBannerBearer {
	public GOTEntityLorathBannerBearer(World world) {
		super(world);
		canBeMarried = false;
	}

	@Override
	public GOTItemBanner.BannerType getBannerType() {
		return GOTItemBanner.BannerType.LORATH;
	}
}
