package got.common.world.biome.westeros;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.*;
import got.common.world.map.*;
import got.common.world.map.GOTWaypoint.Region;
import got.common.world.spawning.GOTEventSpawner;
import got.common.world.structure.other.GOTStructureRuins;
import got.common.world.structure.westeros.westerlands.GOTStructureWesterlandsCity;

public class GOTBiomeWesterlands extends GOTBiomeWesteros {

	public GOTBiomeWesterlands(int i, boolean major) {
		super(i, major);
		decorator.addVillage(new GOTStructureWesterlandsCity(this, 1.0f));

		invasionSpawns.addInvasion(GOTInvasions.DRAGONSTONE, GOTEventSpawner.EventChance.COMMON);
		invasionSpawns.addInvasion(GOTInvasions.STORMLANDS, GOTEventSpawner.EventChance.COMMON);
		invasionSpawns.addInvasion(GOTInvasions.RIVERLANDS, GOTEventSpawner.EventChance.COMMON);
		invasionSpawns.addInvasion(GOTInvasions.NORTH, GOTEventSpawner.EventChance.COMMON);

		GOTStructureRuins ruins = new GOTStructureRuins(this, 0.0f);
		ruins.affix(GOTWaypoint.TarbeckHall);
		ruins.affix(GOTWaypoint.Castamere);
		ruins.affix(GOTWaypoint.Goldenhill);
		decorator.addVillage(ruins);
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_WESTERLANDS;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.WESTEROS.getSubregion("westerlands");
	}

	@Override
	public Region getBiomeWaypoints() {
		return Region.WESTERLANDS;
	}

	@Override
	public GOTBezierType getRoadBlock() {
		return GOTBezierType.WESTEROS_PATH;
	}
}
