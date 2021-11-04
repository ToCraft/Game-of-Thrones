package got.common.command;

import java.util.List;

import got.common.GOTLevelData;
import net.minecraft.command.*;

public class GOTCommandWaypointCooldown extends CommandBase {
	public static int MAX_COOLDOWN = 86400;

	public List addTabCompletionOptions(ICommandSender sender, String[] args) {
		if (args.length == 1) {
			return GOTCommandWaypointCooldown.getListOfStringsMatchingLastWord(args, "max", "min");
		}
		return null;
	}

	public String getCommandName() {
		return "wpCooldown";
	}

	public String getCommandUsage(ICommandSender sender) {
		return "got.command.wpCooldown.usage";
	}

	public int getRequiredPermissionLevel() {
		return 2;
	}

	public boolean isUsernameIndex(String[] args, int i) {
		return false;
	}

	public void processCommand(ICommandSender sender, String[] args) {
		String function = null;
		int cooldown = -1;
		if (args.length == 1) {
			function = "max";
			cooldown = GOTCommandWaypointCooldown.parseIntBounded(sender, args[0], 0, MAX_COOLDOWN);
		} else if (args.length >= 2) {
			function = args[0];
			cooldown = GOTCommandWaypointCooldown.parseIntBounded(sender, args[1], 0, MAX_COOLDOWN);
		}
		if (function != null && cooldown >= 0) {
			int max = GOTLevelData.getWaypointCooldownMax();
			int min = GOTLevelData.getWaypointCooldownMin();
			if (function.equals("max")) {
				boolean updatedMin = false;
				max = cooldown;
				if (max < min) {
					min = max;
					updatedMin = true;
				}
				GOTLevelData.setWaypointCooldown(max, min);
				GOTCommandWaypointCooldown.func_152373_a(sender, this, "got.command.wpCooldown.setMax", max, GOTLevelData.getHMSTime_Seconds(max));
				if (updatedMin) {
					GOTCommandWaypointCooldown.func_152373_a(sender, (ICommand) this, "got.command.wpCooldown.updateMin", min);
				}
				return;
			}
			if (function.equals("min")) {
				boolean updatedMax = false;
				min = cooldown;
				if (min > max) {
					max = min;
					updatedMax = true;
				}
				GOTLevelData.setWaypointCooldown(max, min);
				GOTCommandWaypointCooldown.func_152373_a(sender, this, "got.command.wpCooldown.setMin", min, GOTLevelData.getHMSTime_Seconds(min));
				if (updatedMax) {
					GOTCommandWaypointCooldown.func_152373_a(sender, (ICommand) this, "got.command.wpCooldown.updateMax", max);
				}
				return;
			}
		}
		throw new WrongUsageException(getCommandUsage(sender));
	}
}
