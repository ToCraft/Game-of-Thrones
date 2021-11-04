package got.common.entity.westeros.westerlands;

import got.common.database.*;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class GOTEntityWesterlandsGoldsmith extends GOTEntityWesterlandsMarketTrader {
	public GOTEntityWesterlandsGoldsmith(World world) {
		super(world);
		canBeMarried = false;
	}

	@Override
	public GOTTradeEntries getBuyPool() {
		return GOTTradeEntries.WESTEROS_GOLDSMITH_BUY;
	}

	@Override
	public GOTTradeEntries getSellPool() {
		return GOTTradeEntries.WESTEROS_GOLDSMITH_SELL; 
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		npcItemsInv.setIdleItem(new ItemStack(GOTRegistry.silverRing));
		return data;
	}
}