package got.common.world.biome.westeros;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.*;
import got.common.world.map.*;
import got.common.world.map.GOTWaypoint.Region;
import got.common.world.spawning.*;
import got.common.world.spawning.GOTBiomeSpawnList.SpawnListContainer;
import got.common.world.structure.westeros.gift.GOTStructureGiftVillage;

public class GOTBiomeGiftNew extends GOTBiomeWesteros {
	public GOTBiomeGiftNew(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.clear();
		spawnableWaterCreatureList.clear();
		spawnableCaveCreatureList.clear();
		spawnableGOTAmbientList.clear();
		clearBiomeVariants();
		SpawnListContainer[] container0 = new SpawnListContainer[1];
		container0[0] = GOTBiomeSpawnList.entry(GOTSpawnList.GIFT_CIVILIAN, 10).setSpawnChance(500);
		npcSpawnList.newFactionList(100).add(container0);

		SpawnListContainer[] container3 = new SpawnListContainer[1];
		container3[0] = GOTBiomeSpawnList.entry(GOTSpawnList.WALKERS_CONQUEST, 10);
		npcSpawnList.newFactionList(0).add(container3);

		SpawnListContainer[] container2 = new SpawnListContainer[2];
		container2[0] = GOTBiomeSpawnList.entry(GOTSpawnList.WILDING_MILITARY, 10);
		container2[1] = GOTBiomeSpawnList.entry(GOTSpawnList.WILDING_GIANT, 1);
		npcSpawnList.newFactionList(0).add(container2);

        SpawnListContainer[] containerLSR = new SpawnListContainer[1];
        containerLSR[0] = GOTBiomeSpawnList.entry(GOTSpawnList.UNRELIABLE, 10).setSpawnChance(500);
        this.npcSpawnList.newFactionList(5).add(containerLSR);

		GOTStructureGiftVillage village = new GOTStructureGiftVillage(this, 0.0f);
		village.affix(GOTWaypoint.Queenscrown);
		decorator.addVillage(village);
		invasionSpawns.addInvasion(GOTInvasions.THENN, GOTEventSpawner.EventChance.COMMON);
		invasionSpawns.addInvasion(GOTInvasions.WILDLING, GOTEventSpawner.EventChance.COMMON);
		invasionSpawns.addInvasion(GOTInvasions.GIANT, GOTEventSpawner.EventChance.RARE);
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_GIFT_NEW;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.WESTEROS.getSubregion("giftNew");
	}

	@Override
	public Region getBiomeWaypoints() {
		return Region.NORTH;
	}

	@Override
	public GOTBezierType getRoadBlock() {
		return GOTBezierType.WESTEROS_PATH;
	}

}
