package got.common.entity.essos.tyrosh;

import got.common.GOTLevelData;
import got.common.database.*;
import got.common.entity.ai.GOTEntityAIAttackOnCollide;
import got.common.entity.other.GOTUnitTradeable;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class GOTEntityTyroshWarlord extends GOTEntityTyroshWarrior implements GOTUnitTradeable {
	public GOTEntityTyroshWarlord(World world) {
		super(world);
		canBeMarried = false;
		addTargetTasks(false);
		npcCape = GOTCapes.TYROSH;
	}

	@Override
	public void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(25.0);
	}

	@Override
	public boolean canTradeWith(EntityPlayer entityplayer) {
		return GOTLevelData.getData(entityplayer).getAlignment(getFaction()) >= 50.0f && isFriendly(entityplayer);
	}

	@Override
	public EntityAIBase createTyroshAttackAI() {
		return new GOTEntityAIAttackOnCollide(this, 1.4, false);
	}

	@Override
	public float getAlignmentBonus() {
		return 5.0f;
	}

	@Override
	public String getSpeechBank(EntityPlayer entityplayer) {
		if (isFriendly(entityplayer)) {
			if (canTradeWith(entityplayer)) {
				return "essos/tyrosh/warlord/friendly";
			}
			return "essos/tyrosh/warlord/neutral";
		}
		return "essos/tyrosh/warrior/hostile";
	}

	@Override
	public GOTUnitTradeEntries getUnits() {
		return GOTUnitTradeEntries.TYROSH;
	}

	@Override
	public GOTInvasions getWarhorn() {
		return GOTInvasions.TYROSH;
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		npcItemsInv.setMeleeWeapon(new ItemStack(GOTRegistry.essosPolearm));
		npcItemsInv.setIdleItem(npcItemsInv.getMeleeWeapon());
		setCurrentItemOrArmor(4, null);
		return data;
	}

	@Override
	public void onUnitTrade(EntityPlayer entityplayer) {
		GOTLevelData.getData(entityplayer).addAchievement(GOTAchievement.TRADE);
	}
}
