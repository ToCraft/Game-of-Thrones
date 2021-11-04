package got.common.entity.other;

import net.minecraft.entity.player.EntityPlayer;

public interface GOTTravellingTrader extends GOTTradeable {
	GOTEntityNPC createTravellingEscort();

	String getDepartureSpeech();

	void startTraderVisiting(EntityPlayer var1);
}
