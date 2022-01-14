package got.common.network;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.*;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.Entity;

public class GOTPacketHandler {
	public static SimpleNetworkWrapper networkWrapper = NetworkRegistry.INSTANCE.newSimpleChannel("got_");
	public static int id = 0;
	public static boolean dedicatedServer;

	public GOTPacketHandler() {
		networkWrapper.registerMessage(GOTPacketAchievement.Handler.class, GOTPacketAchievement.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketAchievementRemove.Handler.class, GOTPacketAchievementRemove.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketAlignment.Handler.class, GOTPacketAlignment.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketAlignmentBonus.Handler.class, GOTPacketAlignmentBonus.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketAlignmentSee.Handler.class, GOTPacketAlignmentSee.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketAnvilEngraveOwner.Handler.class, GOTPacketAnvilEngraveOwner.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketAnvilReforge.Handler.class, GOTPacketAnvilReforge.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketAnvilRename.Handler.class, GOTPacketAnvilRename.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketBannerData.Handler.class, GOTPacketBannerData.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketBannerRequestInvalidName.Handler.class, GOTPacketBannerRequestInvalidName.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketBannerValidate.Handler.class, GOTPacketBannerValidate.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketBiomeVariantsUnwatch.Handler.class, GOTPacketBiomeVariantsUnwatch.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketBiomeVariantsWatch.Handler.class, GOTPacketBiomeVariantsWatch.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketBlockFX.Handler.class, GOTPacketBlockFX.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketBrandingIron.Handler.class, GOTPacketBrandingIron.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketBrewingButton.Handler.class, GOTPacketBrewingButton.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketBrokenPledge.Handler.class, GOTPacketBrokenPledge.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketBuyUnit.Handler.class, GOTPacketBuyUnit.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketCWPProtectionMessage.Handler.class, GOTPacketCWPProtectionMessage.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketCWPSharedHide.Handler.class, GOTPacketCWPSharedHide.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketCWPSharedHideClient.Handler.class, GOTPacketCWPSharedHideClient.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketCWPSharedUnlockClient.Handler.class, GOTPacketCWPSharedUnlockClient.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketCancelItemHighlight.Handler.class, GOTPacketCancelItemHighlight.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketCape.Handler.class, GOTPacketCape.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketCargocart.Handler.class, GOTPacketCargocart.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketCargocartControl.Handler.class, GOTPacketCargocartControl.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketCargocartUpdate.Handler.class, GOTPacketCargocartUpdate.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketCheckMenuPrompt.Handler.class, GOTPacketCheckMenuPrompt.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketClientInfo.Handler.class, GOTPacketClientInfo.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketClientMQEvent.Handler.class, GOTPacketClientMQEvent.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketClientsideGUI.Handler.class, GOTPacketClientsideGUI.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketCoinExchange.Handler.class, GOTPacketCoinExchange.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketConquestGrid.Handler.class, GOTPacketConquestGrid.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketConquestGridRequest.Handler.class, GOTPacketConquestGridRequest.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketConquestNotification.Handler.class, GOTPacketConquestNotification.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketCreateCWP.Handler.class, GOTPacketCreateCWP.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketCreateCWPClient.Handler.class, GOTPacketCreateCWPClient.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketDate.Handler.class, GOTPacketDate.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketDeleteCWP.Handler.class, GOTPacketDeleteCWP.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketDeleteCWPClient.Handler.class, GOTPacketDeleteCWPClient.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketDeleteMiniquest.Handler.class, GOTPacketDeleteMiniquest.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketDragonControl.Handler.class, GOTPacketDragonControl.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketEditBanner.Handler.class, GOTPacketEditBanner.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketEditNPCRespawner.Handler.class, GOTPacketEditNPCRespawner.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketEditSign.Handler.class, GOTPacketEditSign.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketEnableAlignmentZones.Handler.class, GOTPacketEnableAlignmentZones.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketEntityUUID.Handler.class, GOTPacketEntityUUID.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketEnvironmentOverlay.Handler.class, GOTPacketEnvironmentOverlay.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketFTBounceClient.Handler.class, GOTPacketFTBounceClient.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketFTBounceServer.Handler.class, GOTPacketFTBounceServer.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketFTCooldown.Handler.class, GOTPacketFTCooldown.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketFTScreen.Handler.class, GOTPacketFTScreen.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketFTTimer.Handler.class, GOTPacketFTTimer.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketFactionData.Handler.class, GOTPacketFactionData.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketFactionRelations.Handler.class, GOTPacketFactionRelations.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketFamilyInfo.Handler.class, GOTPacketFamilyInfo.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketFastTravel.Handler.class, GOTPacketFastTravel.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketFellowship.Handler.class, GOTPacketFellowship.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketFellowshipCreate.Handler.class, GOTPacketFellowshipCreate.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketFellowshipDisband.Handler.class, GOTPacketFellowshipDisband.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketFellowshipDoPlayer.Handler.class, GOTPacketFellowshipDoPlayer.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketFellowshipLeave.Handler.class, GOTPacketFellowshipLeave.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketFellowshipNotification.Handler.class, GOTPacketFellowshipNotification.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketFellowshipPartialUpdate.AddMember.Handler.class, GOTPacketFellowshipPartialUpdate.AddMember.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketFellowshipPartialUpdate.ChangeIcon.Handler.class, GOTPacketFellowshipPartialUpdate.ChangeIcon.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketFellowshipPartialUpdate.RemoveAdmin.Handler.class, GOTPacketFellowshipPartialUpdate.RemoveAdmin.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketFellowshipPartialUpdate.RemoveMember.Handler.class, GOTPacketFellowshipPartialUpdate.RemoveMember.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketFellowshipPartialUpdate.Rename.Handler.class, GOTPacketFellowshipPartialUpdate.Rename.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketFellowshipPartialUpdate.SetAdmin.Handler.class, GOTPacketFellowshipPartialUpdate.SetAdmin.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketFellowshipPartialUpdate.SetOwner.Handler.class, GOTPacketFellowshipPartialUpdate.SetOwner.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketFellowshipPartialUpdate.ToggleHiredFriendlyFire.Handler.class, GOTPacketFellowshipPartialUpdate.ToggleHiredFriendlyFire.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketFellowshipPartialUpdate.TogglePvp.Handler.class, GOTPacketFellowshipPartialUpdate.TogglePvp.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketFellowshipPartialUpdate.ToggleShowMap.Handler.class, GOTPacketFellowshipPartialUpdate.ToggleShowMap.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketFellowshipPartialUpdate.UpdatePlayerTitle.Handler.class, GOTPacketFellowshipPartialUpdate.UpdatePlayerTitle.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketFellowshipRemove.Handler.class, GOTPacketFellowshipRemove.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketFellowshipRename.Handler.class, GOTPacketFellowshipRename.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketFellowshipRespondInvite.Handler.class, GOTPacketFellowshipRespondInvite.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketFellowshipSetIcon.Handler.class, GOTPacketFellowshipSetIcon.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketFellowshipToggle.Handler.class, GOTPacketFellowshipToggle.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketGrappleAttach.Handler.class, GOTPacketGrappleAttach.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketGrappleAttachPos.Handler.class, GOTPacketGrappleAttachPos.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketGrappleClick.Handler.class, GOTPacketGrappleClick.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketGrappleEnd.Handler.class, GOTPacketGrappleEnd.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketHiredGui.Handler.class, GOTPacketHiredGui.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketHiredInfo.Handler.class, GOTPacketHiredInfo.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketHiredUnitCommand.Handler.class, GOTPacketHiredUnitCommand.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketHiredUnitDismiss.Handler.class, GOTPacketHiredUnitDismiss.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketHiredUnitInteract.Handler.class, GOTPacketHiredUnitInteract.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketHornSelect.Handler.class, GOTPacketHornSelect.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketInvasionWatch.Handler.class, GOTPacketInvasionWatch.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketIsOpRequest.Handler.class, GOTPacketIsOpRequest.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketIsOpResponse.Handler.class, GOTPacketIsOpResponse.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketItemSquadron.Handler.class, GOTPacketItemSquadron.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketLocationFX.Handler.class, GOTPacketLocationFX.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketLogin.Handler.class, GOTPacketLogin.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketLoginPlayerData.Handler.class, GOTPacketLoginPlayerData.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketMapTp.Handler.class, GOTPacketMapTp.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketMenuPrompt.Handler.class, GOTPacketMenuPrompt.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketMercenaryInteract.Handler.class, GOTPacketMercenaryInteract.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketMessage.Handler.class, GOTPacketMessage.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketMiniquest.Handler.class, GOTPacketMiniquest.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketMiniquestOffer.Handler.class, GOTPacketMiniquestOffer.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketMiniquestOfferClose.Handler.class, GOTPacketMiniquestOfferClose.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketMiniquestRemove.Handler.class, GOTPacketMiniquestRemove.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketMiniquestTrack.Handler.class, GOTPacketMiniquestTrack.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketMiniquestTrackClient.Handler.class, GOTPacketMiniquestTrackClient.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketMoneyChange.Handler.class, GOTPacketMoneyChange.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketMoneyGet.Handler.class, GOTPacketMoneyGet.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketMoneyGive.Handler.class, GOTPacketMoneyGive.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketMountControl.Handler.class, GOTPacketMountControl.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketMountControlServerEnforce.Handler.class, GOTPacketMountControlServerEnforce.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketMountOpenInv.Handler.class, GOTPacketMountOpenInv.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketNPCCombatStance.Handler.class, GOTPacketNPCCombatStance.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketNPCFX.Handler.class, GOTPacketNPCFX.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketNPCIsEating.Handler.class, GOTPacketNPCIsEating.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketNPCIsOfferingQuest.Handler.class, GOTPacketNPCIsOfferingQuest.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketNPCRespawner.Handler.class, GOTPacketNPCRespawner.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketNPCSpeech.Handler.class, GOTPacketNPCSpeech.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketNPCSquadron.Handler.class, GOTPacketNPCSquadron.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketOpenSignEditor.Handler.class, GOTPacketOpenSignEditor.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketOptions.Handler.class, GOTPacketOptions.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketPlayerMovement.Handler.class, GOTPacketPlayerMovement.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketPledge.Handler.class, GOTPacketPledge.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketPledgeSet.Handler.class, GOTPacketPledgeSet.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketPortalPos.Handler.class, GOTPacketPortalPos.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketRenameCWP.Handler.class, GOTPacketRenameCWP.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketRenameCWPClient.Handler.class, GOTPacketRenameCWPClient.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketRenamePouch.Handler.class, GOTPacketRenamePouch.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketSealCracker.Handler.class, GOTPacketSealCracker.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketSelectCape.Handler.class, GOTPacketSelectCape.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketSelectShield.Handler.class, GOTPacketSelectShield.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketSelectTitle.Handler.class, GOTPacketSelectTitle.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketSell.Handler.class, GOTPacketSell.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketSetOption.Handler.class, GOTPacketSetOption.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketSetPlayerRotation.Handler.class, GOTPacketSetPlayerRotation.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketShareCWP.Handler.class, GOTPacketShareCWP.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketShareCWPClient.Handler.class, GOTPacketShareCWPClient.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketShield.Handler.class, GOTPacketShield.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketStopItemUse.Handler.class, GOTPacketStopItemUse.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketTitle.Handler.class, GOTPacketTitle.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketTraderInfo.Handler.class, GOTPacketTraderInfo.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketTraderInteract.Handler.class, GOTPacketTraderInteract.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketUnitTraderInteract.Handler.class, GOTPacketUnitTraderInteract.class, id++, Side.SERVER);
		networkWrapper.registerMessage(GOTPacketUpdatePlayerLocations.Handler.class, GOTPacketUpdatePlayerLocations.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketUpdateViewingFaction.Handler.class, GOTPacketUpdateViewingFaction.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketWaypointRegion.Handler.class, GOTPacketWaypointRegion.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketWaypointUseCount.Handler.class, GOTPacketWaypointUseCount.class, id++, Side.CLIENT);
		networkWrapper.registerMessage(GOTPacketWeaponFX.Handler.class, GOTPacketWeaponFX.class, id++, Side.CLIENT);
	}

	public static NetworkRegistry.TargetPoint nearEntity(Entity entity, double range) {
		return new NetworkRegistry.TargetPoint(entity.dimension, entity.posX, entity.boundingBox.minY, entity.posZ, range);
	}

	public static void sendToServer(IMessage message) {
		networkWrapper.sendToServer(message);
	}
}