package got.common.world.biome.westeros;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.*;
import got.common.world.map.*;
import got.common.world.map.GOTWaypoint.Region;
import got.common.world.spawning.GOTEventSpawner;
import got.common.world.structure.other.GOTStructureRuins;
import got.common.world.structure.westeros.targaryen.GOTStructureTargaryenCity;

public class GOTBiomeTargaryen extends GOTBiomeWesteros {
	public GOTBiomeTargaryen(int i, boolean major) {
		super(i, major);
		invasionSpawns.addInvasion(GOTInvasions.NORTH, GOTEventSpawner.EventChance.COMMON);
		invasionSpawns.addInvasion(GOTInvasions.RIVERLANDS, GOTEventSpawner.EventChance.COMMON);
		invasionSpawns.addInvasion(GOTInvasions.WESTERLANDS, GOTEventSpawner.EventChance.COMMON);
		invasionSpawns.addInvasion(GOTInvasions.STORMLANDS, GOTEventSpawner.EventChance.COMMON);
		invasionSpawns.addInvasion(GOTInvasions.IRONBORN, GOTEventSpawner.EventChance.COMMON);
		invasionSpawns.addInvasion(GOTInvasions.REACH, GOTEventSpawner.EventChance.COMMON);

		decorator.addVillage(new GOTStructureTargaryenCity(this, 1.0f));

		GOTStructureRuins ruinsGen = new GOTStructureRuins(this, 0.0f);
		ruinsGen.affix(GOTWaypoint.HollardCastle);
		ruinsGen.affix(GOTWaypoint.Whispers);
		decorator.addVillage(ruinsGen);
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_TARGARYEN;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.WESTEROS.getSubregion("targaryen");
	}

	@Override
	public Region getBiomeWaypoints() {
		return Region.TARGARYEN;
	}

	@Override
	public GOTBezierType getRoadBlock() {
		return GOTBezierType.WESTEROS_PATH;
	}
}