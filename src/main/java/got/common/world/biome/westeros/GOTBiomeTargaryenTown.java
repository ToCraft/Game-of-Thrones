package got.common.world.biome.westeros;

import got.common.database.*;
import got.common.world.spawning.GOTBiomeSpawnList;
import got.common.world.spawning.GOTEventSpawner;
import got.common.world.spawning.GOTBiomeSpawnList.SpawnListContainer;

public class GOTBiomeTargaryenTown extends GOTBiomeTargaryenFlat {
	public GOTBiomeTargaryenTown(int i, boolean major) {
		super(i, major);
		npcSpawnList.clear();

		SpawnListContainer[] container0 = new SpawnListContainer[2];
		container0[0] = GOTBiomeSpawnList.entry(GOTSpawnList.TARGARYEN_CIVILIAN, 10).setSpawnChance(500);
		container0[1] = GOTBiomeSpawnList.entry(GOTSpawnList.TARGARYEN_MILITARY, 4).setSpawnChance(500);
		npcSpawnList.newFactionList(67, 0.0f).add(container0);

		invasionSpawns.addInvasion(GOTInvasions.NORTH, GOTEventSpawner.EventChance.COMMON);
		invasionSpawns.addInvasion(GOTInvasions.RIVERLANDS, GOTEventSpawner.EventChance.COMMON);
		invasionSpawns.addInvasion(GOTInvasions.WESTERLANDS, GOTEventSpawner.EventChance.COMMON);
		invasionSpawns.addInvasion(GOTInvasions.STORMLANDS, GOTEventSpawner.EventChance.COMMON);
		invasionSpawns.addInvasion(GOTInvasions.IRONBORN, GOTEventSpawner.EventChance.COMMON);

        SpawnListContainer[] containerLSR = new SpawnListContainer[1];
        containerLSR[0] = GOTBiomeSpawnList.entry(GOTSpawnList.UNRELIABLE, 10).setSpawnChance(500);
        this.npcSpawnList.newFactionList(5).add(containerLSR);
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_KINGS_LANDING;
	}
}