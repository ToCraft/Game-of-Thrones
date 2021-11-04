package got;

import net.minecraft.util.StatCollector;

public class GOTInfo {
	public static String[] description = new String[] { "\u00A76" + StatCollector.translateToLocal("got.gui.authors") + " Hummel009, TIGASA, Monitor, Iliamakar, DAndMaster, JaqenHghar01, beautifulrobloxgirl01, Sword of the Morning " + StatCollector.translateToLocal("got.gui.authors.others") };

	public static String concatenateDescription(int startIndex) {
		StringBuilder s = new StringBuilder();
		for (int i = startIndex = Math.min(startIndex, description.length - 1); i < description.length; ++i) {
			s.append(description[i]).append("\n\n");
		}
		return s.toString();
	}
}