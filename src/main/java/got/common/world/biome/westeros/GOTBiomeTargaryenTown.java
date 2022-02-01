package got.common.world.biome.westeros;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.*;
import got.common.world.biome.GOTBiome;
import got.common.world.map.GOTBezierType;
import got.common.world.map.GOTWaypoint;
import got.common.world.spawning.GOTBiomeSpawnList;
import got.common.world.spawning.GOTEventSpawner;
import got.common.world.spawning.GOTBiomeSpawnList.SpawnListContainer;
import got.common.world.structure.westeros.targaryen.*;
import got.common.world.structure.westeros.targaryen.red.*;

public class GOTBiomeTargaryenTown extends GOTBiomeWesteros {
	public GOTBiomeTargaryenTown(int i, boolean major) {
		super(i, major);
		npcSpawnList.clear();
		decorator.clearVillages();
		decorator.clearRandomStructures();

		SpawnListContainer[] c0 = new SpawnListContainer[2];
		c0[0] = GOTBiomeSpawnList.entry(GOTSpawnList.TARGARYEN_CIVILIAN, 10).setSpawnChance(GOTBiome.SPAWN);
		c0[1] = GOTBiomeSpawnList.entry(GOTSpawnList.TARGARYEN_MILITARY, 4).setSpawnChance(GOTBiome.SPAWN);
		npcSpawnList.newFactionList(6).add(c0);

		invasionSpawns.addInvasion(GOTInvasions.NORTH, GOTEventSpawner.EventChance.COMMON);
		invasionSpawns.addInvasion(GOTInvasions.RIVERLANDS, GOTEventSpawner.EventChance.COMMON);
		invasionSpawns.addInvasion(GOTInvasions.WESTERLANDS, GOTEventSpawner.EventChance.COMMON);
		invasionSpawns.addInvasion(GOTInvasions.STORMLANDS, GOTEventSpawner.EventChance.COMMON);
		invasionSpawns.addInvasion(GOTInvasions.IRONBORN, GOTEventSpawner.EventChance.COMMON);

        SpawnListContainer[] containerLSR = new SpawnListContainer[1];
        containerLSR[0] = GOTBiomeSpawnList.entry(GOTSpawnList.UNRELIABLE, 10).setSpawnChance(500);
        this.npcSpawnList.newFactionList(5).add(containerLSR);

		GOTStructureTargaryenCity castle = new GOTStructureTargaryenCity(this, 0.0f).setIsCastle();
		castle.affix(GOTWaypoint.Dragonstone);
		castle.affix(GOTWaypoint.HighTide);
		castle.affix(GOTWaypoint.Driftmark);
		castle.affix(GOTWaypoint.SharpPoint);
		castle.affix(GOTWaypoint.Stonedance);
		castle.affix(GOTWaypoint.SweetportSound);
		castle.affix(GOTWaypoint.ClawIsle);
		decorator.affix(castle);

		GOTStructureTargaryenCity town = new GOTStructureTargaryenCity(this, 0.0f).setIsTown();
		town.affix(GOTWaypoint.Hull);
		decorator.affix(town);

		GOTStructureTargaryenCity capital = new GOTStructureTargaryenCity(this, 0.0f).setIsCapital();
		capital.affix(GOTWaypoint.KingsLanding, 1, 0, 1);
		decorator.affix(capital);

		GOTWaypointRedCastle rc = new GOTWaypointRedCastle(this, 0.0f);
		rc.affix(GOTWaypoint.KingsLanding, 2, 0, 1);
		decorator.affix(rc);
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_KINGS_LANDING;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.WESTEROS.getSubregion("targaryenTown");
	}

	@Override
	public boolean getEnableRiver() {
		return false;
	}

	@Override
	public GOTBezierType getRoadBlock() {
		return GOTBezierType.PAVING;
	}

	@Override
	public boolean hasDomesticAnimals() {
		return true;
	}
}