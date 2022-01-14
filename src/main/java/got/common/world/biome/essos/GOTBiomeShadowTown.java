package got.common.world.biome.essos;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.*;
import got.common.world.biome.GOTBiome;
import got.common.world.map.GOTWaypoint;
import got.common.world.spawning.*;
import got.common.world.spawning.GOTBiomeSpawnList.SpawnListContainer;
import got.common.world.structure.essos.asshai.GOTStructureAsshaiCity;

public class GOTBiomeShadowTown extends GOTBiomeShadowLand {
	public GOTBiomeShadowTown(int i, boolean major) {
		super(i, major);
		decorator.flowersPerChunk = 0;

		SpawnListContainer[] c0 = new SpawnListContainer[1];
		c0[0] = GOTBiomeSpawnList.entry(GOTSpawnList.ASSHAI_MILITARY, 10).setSpawnChance(GOTBiome.SPAWN);
		npcSpawnList.newFactionList(10).add(c0);

		GOTStructureAsshaiCity town = new GOTStructureAsshaiCity(this, 0.0f);
		town.affix(GOTWaypoint.Asshai, 2);
		decorator.affix(town);
		setUnreliableChance(GOTEventSpawner.EventChance.NEVER);
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_ASSHAI;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.ESSOS.getSubregion("shadowTown");
	}

}
