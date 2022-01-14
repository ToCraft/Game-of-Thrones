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

		decorator.affix(new GOTStructureTargaryenCity(this, 1.0f));

		GOTStructureTargaryenCity village = new GOTStructureTargaryenCity(this, 0.0f);
		village.affix(GOTWaypoint.Briarwhite);
		decorator.affix(village);

		GOTStructureTargaryenCity castle = new GOTStructureTargaryenCity(this, 0.0f).setIsCastle();
		castle.affix(GOTWaypoint.Antlers);
		castle.affix(GOTWaypoint.Stokeworth);
		castle.affix(GOTWaypoint.DyreDen);
		castle.affix(GOTWaypoint.Brownhollow);
		castle.affix(GOTWaypoint.RooksRest, 0, -1);
		castle.affix(GOTWaypoint.Rosby, 0, -1);
		castle.affix(GOTWaypoint.Hayford, -1, 0);
		decorator.affix(castle);

		GOTStructureTargaryenCity town = new GOTStructureTargaryenCity(this, 0.0f).setIsTown();
		town.affix(GOTWaypoint.Duskendale, -2, 0, 3);
		decorator.affix(town);

		GOTStructureRuins ruins = new GOTStructureRuins(this, 0.0f);
		ruins.affix(GOTWaypoint.HollardCastle);
		ruins.affix(GOTWaypoint.Whispers);
		decorator.affix(ruins);

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
		return GOTBezierType.PATH_DIRTY;
	}
}