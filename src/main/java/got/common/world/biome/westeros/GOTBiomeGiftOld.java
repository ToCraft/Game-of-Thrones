package got.common.world.biome.westeros;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.*;
import got.common.world.biome.GOTBiome;
import got.common.world.fixed.*;
import got.common.world.map.*;
import got.common.world.map.GOTWaypoint.Region;
import got.common.world.spawning.*;
import got.common.world.spawning.GOTBiomeSpawnList.SpawnListContainer;
import got.common.world.structure.westeros.gift.GOTStructureGiftVillage;

public class GOTBiomeGiftOld extends GOTBiomeWesteros {
	public GOTBiomeGiftOld(int i, boolean major) {
		super(i, major);
		clearBiomeVariants();
		spawnableCreatureList.clear();
		decorator.treesPerChunk = -1;

		SpawnListContainer[] c0 = new SpawnListContainer[1];
		c0[0] = GOTBiomeSpawnList.entry(GOTSpawnList.GIFT_GUARDIAN, 10).setSpawnChance(GOTBiome.SPAWN);
		npcSpawnList.newFactionList(10).add(c0);

		SpawnListContainer[] c3 = new SpawnListContainer[1];
		c3[0] = GOTBiomeSpawnList.entry(GOTSpawnList.WALKERS_CONQUEST, 10).setSpawnChance(GOTBiome.CONQUEST_SPAWN);
		npcSpawnList.newFactionList(0).add(c3);

		SpawnListContainer[] c2 = new SpawnListContainer[2];
		c2[0] = GOTBiomeSpawnList.entry(GOTSpawnList.WILDING_MILITARY, 10).setSpawnChance(GOTBiome.CONQUEST_SPAWN);
		c2[1] = GOTBiomeSpawnList.entry(GOTSpawnList.WILDING_GIANT, 1).setSpawnChance(GOTBiome.CONQUEST_SPAWN);
		npcSpawnList.newFactionList(0).add(c2);

		GOTStructureGiftVillage village = new GOTStructureGiftVillage(this, 0.0f);
		village.affix(GOTWaypoint.Moletown);
		decorator.affix(village);

		GOTStructureCastleBlack castle1 = new GOTStructureCastleBlack(this, 0.0f);
		castle1.affix(GOTWaypoint.CastleBlack);
		decorator.affix(castle1);

		GOTStructureShadowTower castle2 = new GOTStructureShadowTower(this, 0.0f);
		castle2.affix(GOTWaypoint.ShadowTower);
		decorator.affix(castle2);

		GOTStructureEastWatch castle3 = new GOTStructureEastWatch(this, 0.0f);
		castle3.affix(GOTWaypoint.EastWatch);
		decorator.affix(castle3);

		GOTStructureWallGate gate = new GOTStructureWallGate(this, 0.0f);
		gate.affix(GOTWaypoint.CastleBlack, 0, -1);
		decorator.affix(gate);

		invasionSpawns.addInvasion(GOTInvasions.THENN, GOTEventSpawner.EventChance.RARE);
		invasionSpawns.addInvasion(GOTInvasions.WILDLING, GOTEventSpawner.EventChance.UNCOMMON);
		invasionSpawns.addInvasion(GOTInvasions.GIANT, GOTEventSpawner.EventChance.RARE);
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_GIFT_OLD;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.WESTEROS.getSubregion("giftOld");
	}

	@Override
	public Region getBiomeWaypoints() {
		return Region.NORTH;
	}

	@Override
	public GOTBezierType getRoadBlock() {
		return GOTBezierType.PATH_DIRTY;
	}

	@Override
	public int getWallTop() {
		return 150;
	}
}