package got.common.world.biome.westeros;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.*;
import got.common.world.biome.variant.GOTBiomeVariant;
import got.common.world.map.*;
import got.common.world.map.GOTWaypoint.Region;
import got.common.world.spawning.GOTEventSpawner;
import got.common.world.structure.other.GOTStructureRuins;
import got.common.world.structure.westeros.stormlands.GOTStructureStormlandsCity;

public class GOTBiomeStormlands extends GOTBiomeWesteros {
	public GOTBiomeStormlands(int i, boolean major) {
		super(i, major);
		this.addBiomeVariant(GOTBiomeVariant.FIELD_CORN, 0.2f);
		decorator.addVillage(new GOTStructureStormlandsCity(this, 1.0f));

		invasionSpawns.addInvasion(GOTInvasions.WESTERLANDS, GOTEventSpawner.EventChance.COMMON);
		invasionSpawns.addInvasion(GOTInvasions.DRAGONSTONE, GOTEventSpawner.EventChance.COMMON);

		GOTStructureRuins ruinsGen = new GOTStructureRuins(this, 0.0f);
		ruinsGen.affix(GOTWaypoint.Summerhall);
		ruinsGen.affix(GOTWaypoint.TowerOfJoy);
		decorator.addVillage(ruinsGen);
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_STORMLANDS;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.WESTEROS.getSubregion("stormlands");
	}

	@Override
	public Region getBiomeWaypoints() {
		return Region.STORMLANDS;
	}

	@Override
	public GOTBezierType getRoadBlock() {
		return GOTBezierType.WESTEROS_PATH;
	}
}
