package got.common.command;

import java.util.List;

import got.common.GOTLevelData;
import net.minecraft.command.*;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;

public class GOTCommandPledgeCooldown extends CommandBase {
	public List addTabCompletionOptions(ICommandSender sender, String[] args) {
		if (args.length == 2) {
			return GOTCommandPledgeCooldown.getListOfStringsMatchingLastWord(args, MinecraftServer.getServer().getAllUsernames());
		}
		return null;
	}

	public String getCommandName() {
		return "pledgeCooldown";
	}

	public String getCommandUsage(ICommandSender sender) {
		return "got.command.pledgeCooldown.usage";
	}

	public int getRequiredPermissionLevel() {
		return 2;
	}

	public boolean isUsernameIndex(String[] args, int i) {
		return i == 1;
	}

	public void processCommand(ICommandSender sender, String[] args) {
		if (args.length >= 1) {
			EntityPlayerMP entityplayer;
			int cd = GOTCommandPledgeCooldown.parseIntBounded(sender, args[0], 0, 10000000);
			if (args.length >= 2) {
				entityplayer = GOTCommandPledgeCooldown.getPlayer(sender, args[1]);
			} else {
				entityplayer = GOTCommandPledgeCooldown.getCommandSenderAsPlayer(sender);
				if (entityplayer == null) {
					throw new PlayerNotFoundException();
				}
			}
			GOTLevelData.getData(entityplayer).setPledgeBreakCooldown(cd);
			GOTCommandPledgeCooldown.func_152373_a(sender, this, "got.command.pledgeCooldown.set", entityplayer.getCommandSenderName(), cd, GOTLevelData.getHMSTime_Ticks(cd));
			return;
		}
		throw new WrongUsageException(getCommandUsage(sender));
	}
}
