package tocraft.got.relations;

import java.util.List;

import got.common.GOTLevelData;
import got.common.GOTPlayerData;
import got.common.faction.GOTFaction;
import got.common.faction.GOTFactionRelations;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class RelCommand extends CommandBase {	
	@Override
	public List addTabCompletionOptions(ICommandSender sender, String[] args) {
		if (args.length == 1) {
			List<String> list = GOTFaction.getPlayableAlignmentFactionNames();
			return CommandBase.getListOfStringsMatchingLastWord(args, list.toArray(new String[0]));
		}
		if (args.length == 2) {
			List<String> list = GOTFactionRelations.Relation.listRelationNames();
			return CommandBase.getListOfStringsMatchingLastWord(args, list.toArray(new String[0]));
		}
		return null;
	}
	@Override
	public boolean canCommandSenderUseCommand(ICommandSender sender) {
		if (sender instanceof EntityPlayer) {
			return true;
		}
		return super.canCommandSenderUseCommand(sender);
	}

	@Override
	public String getCommandName() {
		return "relation";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "gotrelations.command.relation.usage";
	}

	@Override
	public int getRequiredPermissionLevel() {
		return 0;
	}

	@Override
	public boolean isUsernameIndex(String[] args, int i) {
		return false;
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) {
		GOTFaction pledgeFac;
		EntityPlayerMP entityplayer = CommandBase.getCommandSenderAsPlayer(sender);
		GOTPlayerData playerData = GOTLevelData.getData(entityplayer);
		pledgeFac = playerData.getPledgeFaction();
		if (args.length >= 1) {
				if (args.length >= 2) {
					GOTFaction fac = GOTFaction.forName(args[0]);
					float pledgeFacAlignment = GOTLevelData.getData(entityplayer).getAlignment(pledgeFac);
					float facAlignment = GOTLevelData.getData(entityplayer).getAlignment(fac);
					if (pledgeFac == null) {
						throw new WrongUsageException("got.command.alignment.noFaction", args[0]);
					}
					if (fac == null) {
						throw new WrongUsageException("got.command.alignment.noFaction", args[0]);
					}
					GOTFactionRelations.Relation relation = GOTFactionRelations.Relation.forName(args[1]);
					if (relation == null) {
						throw new WrongUsageException("got.command.facRelations.noRelation", args[1]);
					}
					if (relation == GOTFactionRelations.Relation.NEUTRAL) {
						if (facAlignment < RelConfig.AlignmentForNeutral) {
							throw new WrongUsageException("got.command.alignment.tooLow");
						}
					}
					if (relation == GOTFactionRelations.Relation.FRIEND) {
						if (facAlignment < RelConfig.AlignmentForFriends) {
							throw new WrongUsageException("got.command.alignment.tooLow");
						}
					}
					if (relation == GOTFactionRelations.Relation.ALLY) {
						if (pledgeFacAlignment < RelConfig.AlignmentForAllies) {
							throw new WrongUsageException("got.command.alignment.tooLow");
						}
						if (facAlignment < RelConfig.AlignmentForAllies) {
							throw new WrongUsageException("got.command.alignment.tooLow");
						}
					}
					else if (pledgeFacAlignment < RelConfig.AlignmentForPledgeFaction) {
						throw new WrongUsageException("got.command.alignment.tooLow");
					}
					try {
						GOTFactionRelations.overrideRelations(pledgeFac, fac, relation);
						CommandBase.func_152373_a(sender, this, "got.command.facRelations.set", pledgeFac.factionName(), fac.factionName(), relation.getDisplayName());
						if (relation == GOTFactionRelations.Relation.ENEMY || relation == GOTFactionRelations.Relation.MORTAL_ENEMY) {
							if (RelConfig.changeAlignmentForEnemies) {
								if (facAlignment > 0) {
									float AlignmentForEnemies = RelConfig.AlignmentForEnemies;
									GOTLevelData.getData(entityplayer).setAlignmentFromCommand(fac, AlignmentForEnemies);
									CommandBase.func_152373_a(sender, this, "got.command.alignment.set", entityplayer.getCommandSenderName(), fac.factionName(), Float.valueOf(AlignmentForEnemies));
								}
							}
						}
						return;
					} catch (IllegalArgumentException e) {
						throw new WrongUsageException("got.command.facRelations.error", e.getMessage());
					}
				}
			}
		throw new WrongUsageException(getCommandUsage(sender));
	}
}
