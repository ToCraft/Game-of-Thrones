package got.common.world.biome.essos;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.*;
import got.common.entity.animal.*;
import got.common.world.biome.GOTBiome;
import got.common.world.feature.GOTTreeType;
import got.common.world.map.GOTBezierType;
import got.common.world.spawning.GOTBiomeSpawnList;
import got.common.world.spawning.GOTBiomeSpawnList.SpawnListContainer;
import net.minecraft.world.biome.BiomeGenBase;

public class GOTBiomeIfekevronForest extends GOTBiome {
	public GOTBiomeIfekevronForest(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.clear();
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityFlamingo.class, 10, 4, 4));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityElephant.class, 8, 1, 1));

		spawnableGOTAmbientList.clear();
		spawnableGOTAmbientList.add(new BiomeGenBase.SpawnListEntry(GOTEntityBird.class, 10, 4, 4));
		spawnableGOTAmbientList.add(new BiomeGenBase.SpawnListEntry(GOTEntityButterfly.class, 10, 4, 4));

		SpawnListContainer[] container = new SpawnListContainer[1];
		container[0] = GOTBiomeSpawnList.entry(GOTSpawnList.IFEKEVRON, 1).setSpawnChance(100);
		npcSpawnList.newFactionList(100).add(container);

		decorator.clearTrees();
		decorator.addTree(GOTTreeType.TROPICAL, 1);

		decorator.treesPerChunk = 6;
		decorator.flowersPerChunk = 4;
		decorator.doubleFlowersPerChunk = 1;
		decorator.grassPerChunk = 10;
		decorator.doubleGrassPerChunk = 4;

		registerForestFlowers();

	}

	@Override
	public boolean canSpawnHostilesInDay() {
		return true;
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_IFEKEVRON;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.ESSOS.getSubregion("ifekevronForest");
	}

	@Override
	public GOTBezierType getRoadBlock() {
		return GOTBezierType.WESTEROS_PATH;
	}
}