package got.common.entity.westeros.reach;

import got.common.database.*;
import got.common.item.other.GOTItemLeatherHat;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class GOTEntityReachFishmonger extends GOTEntityReachMarketTrader {
	public GOTEntityReachFishmonger(World world) {
		super(world);
		canBeMarried = false;
	}

	@Override
	public GOTTradeEntries getBuyPool() {
		return GOTTradeEntries.COMMON_FISHMONGER_BUY;
	}

	@Override
	public GOTTradeEntries getSellPool() {
		return GOTTradeEntries.COMMON_FISHMONGER_SELL;
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		npcItemsInv.setIdleItem(new ItemStack(Items.fishing_rod));
		ItemStack hat = new ItemStack(GOTRegistry.leatherHat);
		GOTItemLeatherHat.setHatColor(hat, 9013900);
		setCurrentItemOrArmor(4, hat);
		return data;
	}
}
