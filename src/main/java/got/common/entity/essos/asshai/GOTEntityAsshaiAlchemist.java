package got.common.entity.essos.asshai;

import got.common.GOTLevelData;
import got.common.database.*;
import got.common.entity.other.*;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class GOTEntityAsshaiAlchemist extends GOTEntityAsshaiMan implements GOTTravellingTrader {
	public GOTEntityAsshaiAlchemist(World world) {
		super(world);
		canBeMarried = false;
		npcCape = GOTCapes.ASSHAI;
	}

	@Override
	public boolean canTradeWith(EntityPlayer entityplayer) {
		return isFriendly(entityplayer);
	}

	@Override
	public GOTEntityNPC createTravellingEscort() {
		return null;
	}

	@Override
	public GOTTradeEntries getBuyPool() {
		return GOTTradeEntries.ASSHAI_BUY;
	}

	@Override
	public String getDepartureSpeech() {
		return "westeros/scrap/departure";
	}

	@Override
	public String getNPCName() {
		return familyInfo.getName();
	}

	@Override
	public GOTTradeEntries getSellPool() {
		return GOTTradeEntries.BOMZH_SELL;
	}

	@Override
	public void onPlayerTrade(EntityPlayer entityplayer, GOTTradeEntries.TradeType type, ItemStack itemstack) {
		GOTLevelData.getData(entityplayer).addAchievement(GOTAchievement.TRADE);
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		npcItemsInv.setMeleeWeapon(new ItemStack(GOTRegistry.skullStaff));
		npcItemsInv.setIdleItem(npcItemsInv.getMeleeWeapon());
		return data;
	}

	@Override
	public void setupNPCGender() {
		familyInfo.setMale(true);
	}
}
