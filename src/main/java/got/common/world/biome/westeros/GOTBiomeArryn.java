package got.common.world.biome.westeros;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.*;
import got.common.world.map.*;
import got.common.world.map.GOTWaypoint.Region;
import got.common.world.spawning.GOTEventSpawner;
import got.common.world.structure.other.GOTStructureTower;
import got.common.world.structure.westeros.arryn.GOTStructureArrynCity;

public class GOTBiomeArryn extends GOTBiomeWesteros {
	public GOTBiomeArryn(int i, boolean major) {
		super(i, major);

		decorator.addVillage(new GOTStructureArrynCity(this, 1.0f));

		GOTStructureTower towerGen = new GOTStructureTower(this, 0.0f);
		towerGen.affix(GOTWaypoint.BaelishKeep);
		decorator.addVillage(towerGen);

		invasionSpawns.addInvasion(GOTInvasions.WESTERLANDS, GOTEventSpawner.EventChance.COMMON);
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_ARRYN;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.WESTEROS.getSubregion("arryn");
	}

	@Override
	public Region getBiomeWaypoints() {
		return Region.ARRYN;
	}

	@Override
	public GOTBezierType getRoadBlock() {
		return GOTBezierType.WESTEROS_PATH;
	}
}
