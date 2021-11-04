package got.common.world.biome.westeros;

import got.common.database.*;
import got.common.world.spawning.GOTBiomeSpawnList;
import got.common.world.spawning.GOTBiomeSpawnList.SpawnListContainer;

public class GOTBiomeCrownlandsTown extends GOTBiomeCrownlandsFlat {
	public GOTBiomeCrownlandsTown(int i, boolean major) {
		super(i, major);
		npcSpawnList.clear();

		SpawnListContainer[] container0 = new SpawnListContainer[2];
		container0[0] = GOTBiomeSpawnList.entry(GOTSpawnList.CROWNLANDS_CIVILIAN, 10).setSpawnChance(500);
		container0[1] = GOTBiomeSpawnList.entry(GOTSpawnList.CROWNLANDS_GUARDIAN, 4).setSpawnChance(500);
		npcSpawnList.newFactionList(67, 0.0f).add(container0);

		SpawnListContainer[] container1 = new SpawnListContainer[1];
		container1[0] = GOTBiomeSpawnList.entry(GOTSpawnList.WESTERLANDS_CONQUEST, 10).setSpawnChance(500);
		npcSpawnList.newFactionList(33, 0.0f).add(container1);

		SpawnListContainer[] container2 = new SpawnListContainer[1];
		container2[0] = GOTBiomeSpawnList.entry(GOTSpawnList.NORTH_CONQUEST, 10);
		npcSpawnList.newFactionList(0).add(container2);

		SpawnListContainer[] container3 = new SpawnListContainer[1];
		container3[0] = GOTBiomeSpawnList.entry(GOTSpawnList.DRAGONSTONE_CONQUEST, 10);
		npcSpawnList.newFactionList(0).add(container3);

		SpawnListContainer[] container4 = new SpawnListContainer[1];
		container4[0] = GOTBiomeSpawnList.entry(GOTSpawnList.IRONBORN_CONQUEST, 10);
		npcSpawnList.newFactionList(0).add(container4);

		SpawnListContainer[] container5 = new SpawnListContainer[1];
		container5[0] = GOTBiomeSpawnList.entry(GOTSpawnList.STORMLANDS_CONQUEST, 10);
		npcSpawnList.newFactionList(0).add(container5);

		SpawnListContainer[] container6 = new SpawnListContainer[1];
		container6[0] = GOTBiomeSpawnList.entry(GOTSpawnList.RIVERLANDS_CONQUEST, 10);
		npcSpawnList.newFactionList(0).add(container6);

		SpawnListContainer[] container7 = new SpawnListContainer[1];
		container7[0] = GOTBiomeSpawnList.entry(GOTSpawnList.WALKERS_CONQUEST, 10);
		npcSpawnList.newFactionList(0).add(container7);

        SpawnListContainer[] containerLSR = new SpawnListContainer[1];
        containerLSR[0] = GOTBiomeSpawnList.entry(GOTSpawnList.UNRELIABLE, 10).setSpawnChance(500);
        this.npcSpawnList.newFactionList(5).add(containerLSR);
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_KINGS_LANDING;
	}
}