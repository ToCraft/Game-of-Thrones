package got.common.entity.essos.jogos;

import got.common.database.*;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class GOTEntityJogosShaman extends GOTEntityJogosMarketTrader {
	public GOTEntityJogosShaman(World world) {
		super(world);
		canBeMarried = false;
	}

	@Override
	public GOTTradeEntries getBuyPool() {
		return GOTTradeEntries.ESSOS_FARMER_BUY;
	}

	@Override
	public GOTTradeEntries getSellPool() {
		return GOTTradeEntries.ESSOS_FARMER_SELL;
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		npcItemsInv.setIdleItem(new ItemStack(GOTRegistry.mugMead));
		return data;
	}

	@Override
	public void setupNPCGender() {
		familyInfo.setMale(false);
	}
}
