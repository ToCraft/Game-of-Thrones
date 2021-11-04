package got.common.world.biome.essos;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.*;
import got.common.world.biome.GOTBiome;
import got.common.world.feature.GOTTreeType;
import got.common.world.map.GOTWaypoint;
import got.common.world.map.GOTWaypoint.Region;
import got.common.world.spawning.GOTBiomeSpawnList;
import got.common.world.spawning.GOTBiomeSpawnList.SpawnListContainer;
import got.common.world.structure.other.GOTStructureRuinsBig;

public class GOTBiomeMossovy extends GOTBiome {
	public GOTBiomeMossovy(int i, boolean major) {
		super(i, major);
		decorator.clearTrees();
		decorator.treesPerChunk = 1;
		decorator.addTree(GOTTreeType.PINE, 20);

		SpawnListContainer[] container = new SpawnListContainer[1];
		container[0] = GOTBiomeSpawnList.entry(GOTSpawnList.MOSSOVY_WITCHER, 1).setSpawnChance(500);
		npcSpawnList.newFactionList(100).add(container);

		SpawnListContainer[] container1 = new SpawnListContainer[1];
		container1[0] = GOTBiomeSpawnList.entry(GOTSpawnList.MOSSOVY_WEREWOLF, 1).setSpawnChance(300);
		npcSpawnList.newFactionList(100).add(container1);

		GOTStructureRuinsBig colossal = new GOTStructureRuinsBig(this, 0.0f);
		colossal.affix(GOTWaypoint.Kadar);
		decorator.addVillage(colossal);
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_MOSSOVY;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.ESSOS.getSubregion("mossovy");
	}

	@Override
	public Region getBiomeWaypoints() {
		return Region.MOSSOVY;
	}
}