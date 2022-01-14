package tocraft.got.relations;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.client.config.IConfigElement;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

public class RelConfig {
	public static Configuration config;
	public static List<String> allCategories;
	public static String CATEGORY_GAMEPLAY;
	public static String CATEGORY_GUI;
	public static String CATEGORY_ENVIRONMENT;
	public static String CATEGORY_MISC;
	
	public static boolean changeAlignmentForEnemies = true;
	public static float AlignmentForEnemies = 0;
	public static float AlignmentForNeutral = 50;
	public static float AlignmentForFriends = 150;
	public static float AlignmentForAllies = 250;
	public static float AlignmentForPledgeFaction = 500;
	
	static {
		allCategories = new ArrayList<>();
		CATEGORY_GAMEPLAY = RelConfig.getCategory("1_gameplay");
		CATEGORY_GUI = RelConfig.getCategory("2_gui");
		CATEGORY_ENVIRONMENT = RelConfig.getCategory("3_environment");
		CATEGORY_MISC = RelConfig.getCategory("4_misc");
	}
	
	public static String getCategory(String category) {
		allCategories.add(category);
		return category;
	}

	public static List<IConfigElement> getConfigElements() {
		ArrayList<IConfigElement> list = new ArrayList<>();
		for (String category : allCategories) {
			list.addAll(new ConfigElement(config.getCategory(category)).getChildElements());
		}
		return list;
	}
	
	public static void load() {
		changeAlignmentForEnemies = config.get(CATEGORY_GAMEPLAY, "change the Alignment for new Enemies", changeAlignmentForEnemies).getBoolean();
		AlignmentForEnemies = config.getFloat("The alignment you get towards new enemies", CATEGORY_GAMEPLAY, AlignmentForEnemies, -10000, 0, "the default Alignment towards new Enemies.");
		AlignmentForNeutral = config.getFloat("The minimum Alignment for new neutral Factions", CATEGORY_GAMEPLAY, AlignmentForNeutral, 0, 10000, "the default minimum Alignment for new neutral Factions.");
		AlignmentForFriends = config.getFloat("The minimum Alignment for new Friends", CATEGORY_GAMEPLAY, AlignmentForFriends, 0, 10000, "the default minimum Alignment for new Friends.");
		AlignmentForAllies = config.getFloat("The minimum Alignment for new Allies", CATEGORY_GAMEPLAY, AlignmentForAllies, 0, 10000, "the default minimum Alignment for new Allies.");
		AlignmentForPledgeFaction = config.getFloat("The minimum Alignment for your pledged faction.", CATEGORY_GAMEPLAY, AlignmentForPledgeFaction, 0, 10000, "the default minimum Alignment for the pledge Faction.");
		
		if (config.hasChanged()) {
			config.save();
		}
	}
	
	public static void setupAndLoad(FMLPreInitializationEvent event) {
		config = new Configuration(new File("config", "Relations.cfg"));
		RelConfig.load();
	}
}
