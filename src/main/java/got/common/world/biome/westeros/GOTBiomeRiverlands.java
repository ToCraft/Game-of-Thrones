package got.common.world.biome.westeros;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.*;
import got.common.world.map.*;
import got.common.world.map.GOTWaypoint.Region;
import got.common.world.spawning.GOTEventSpawner;
import got.common.world.structure.other.*;
import got.common.world.structure.westeros.riverlands.GOTStructureRiverlandsCity;

public class GOTBiomeRiverlands extends GOTBiomeWesteros {
	public GOTBiomeRiverlands(int i, boolean major) {
		super(i, major);
		decorator.addVillage(new GOTStructureRiverlandsCity(this, 1.0f));

		invasionSpawns.addInvasion(GOTInvasions.WESTERLANDS, GOTEventSpawner.EventChance.COMMON);
		invasionSpawns.addInvasion(GOTInvasions.IRONBORN, GOTEventSpawner.EventChance.COMMON);

		GOTStructureRuins ruins = new GOTStructureRuins(this, 0.0f);
		ruins.affix(GOTWaypoint.OldStones);
		ruins.affix(GOTWaypoint.WhiteWalls);
		ruins.affix(GOTWaypoint.HoggHall);
		decorator.addVillage(ruins);

		GOTStructureRuinsBig colossal = new GOTStructureRuinsBig(this, 0.0f);
		colossal.affix(GOTWaypoint.Harrenhal);
		decorator.addVillage(colossal);
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_RIVERLANDS;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.WESTEROS.getSubregion("riverlands");
	}

	@Override
	public Region getBiomeWaypoints() {
		return Region.RIVERLANDS;
	}

	@Override
	public GOTBezierType getRoadBlock() {
		return GOTBezierType.WESTEROS_PATH;
	}

}
