package got.common.entity.essos.yiti;

import got.common.GOTLevelData;
import got.common.database.*;
import got.common.entity.ai.GOTEntityAIAttackOnCollide;
import got.common.entity.other.GOTUnitTradeable;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class GOTEntityYiTiShogune extends GOTEntityYiTiSamurai implements GOTUnitTradeable {
	public GOTEntityYiTiShogune(World world) {
		super(world);
		canBeMarried = false;
		addTargetTasks(false);
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
	public EntityAIBase createYiTiAttackAI() {
		return new GOTEntityAIAttackOnCollide(this, 1.4, true);
	}

	@Override
	public float getAlignmentBonus() {
		return 5.0f;
	}

	@Override
	public String getSpeechBank(EntityPlayer entityplayer) {
		if (isFriendly(entityplayer)) {
			if (canTradeWith(entityplayer)) {
				return "essos/yiti/warlord/friendly";
			}
			return "essos/yiti/warlord/neutral";
		}
		return "essos/yiti/warrior/hostile";
	}

	@Override
	public GOTUnitTradeEntries getUnits() {
		return GOTUnitTradeEntries.YITI;
	}

	@Override
	public GOTInvasions getWarhorn() {
		return null;
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		npcItemsInv.setMeleeWeapon(new ItemStack(GOTRegistry.yitiSword));
		npcItemsInv.setIdleItem(npcItemsInv.getMeleeWeapon());
		setCurrentItemOrArmor(1, new ItemStack(GOTRegistry.yitiBootsGold));
		setCurrentItemOrArmor(2, new ItemStack(GOTRegistry.yitiLeggingsSamurai));
		setCurrentItemOrArmor(3, new ItemStack(GOTRegistry.yitiChestplateSamurai));
		setCurrentItemOrArmor(4, new ItemStack(GOTRegistry.yitiHelmetShogune));
		return data;
	}

	@Override
	public void onUnitTrade(EntityPlayer entityplayer) {
		GOTLevelData.getData(entityplayer).addAchievement(GOTAchievement.TRADE);
	}
}
