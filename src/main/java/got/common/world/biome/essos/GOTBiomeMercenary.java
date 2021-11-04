package got.common.world.biome.essos;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.*;
import got.common.entity.animal.GOTEntityElephant;
import got.common.world.spawning.*;
import got.common.world.spawning.GOTBiomeSpawnList.SpawnListContainer;
import got.common.world.structure.essos.gold.GOTStructureGoldenCamp;
import net.minecraft.world.biome.BiomeGenBase;

public class GOTBiomeMercenary extends GOTBiomeFreeCities {
	public GOTBiomeMercenary(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityElephant.class, 8, 1, 1));

		SpawnListContainer[] container1 = new SpawnListContainer[1];
		container1[0] = GOTBiomeSpawnList.entry(GOTSpawnList.BRAAVOS_MILITARY, 10);
		npcSpawnList.newFactionList(0).add(container1);

		SpawnListContainer[] container2 = new SpawnListContainer[1];
		container2[0] = GOTBiomeSpawnList.entry(GOTSpawnList.MYR_MILITARY, 10);
		npcSpawnList.newFactionList(0).add(container2);

		SpawnListContainer[] container3 = new SpawnListContainer[1];
		container3[0] = GOTBiomeSpawnList.entry(GOTSpawnList.LYS_MILITARY, 10);
		npcSpawnList.newFactionList(0).add(container3);

		SpawnListContainer[] container4 = new SpawnListContainer[1];
		container4[0] = GOTBiomeSpawnList.entry(GOTSpawnList.TYROSH_MILITARY, 10);
		npcSpawnList.newFactionList(0).add(container4);

		SpawnListContainer[] container5 = new SpawnListContainer[1];
		container5[0] = GOTBiomeSpawnList.entry(GOTSpawnList.VOLANTIS_MILITARY, 10);
		npcSpawnList.newFactionList(0).add(container5);

        SpawnListContainer[] containerLSR = new SpawnListContainer[1];
        containerLSR[0] = GOTBiomeSpawnList.entry(GOTSpawnList.UNRELIABLE, 10).setSpawnChance(500);
        this.npcSpawnList.newFactionList(5).add(containerLSR);

		decorator.addRandomStructure(new GOTStructureGoldenCamp(false), 50);

		invasionSpawns.addInvasion(GOTInvasions.MYR, GOTEventSpawner.EventChance.COMMON);
		invasionSpawns.addInvasion(GOTInvasions.VOLANTIS, GOTEventSpawner.EventChance.COMMON);
		invasionSpawns.addInvasion(GOTInvasions.TYROSH, GOTEventSpawner.EventChance.COMMON);
		invasionSpawns.addInvasion(GOTInvasions.LYS, GOTEventSpawner.EventChance.COMMON);
		invasionSpawns.addInvasion(GOTInvasions.BRAAVOS, GOTEventSpawner.EventChance.COMMON);
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_MERCENARY;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.ESSOS.getSubregion("mercenary");
	}
}
