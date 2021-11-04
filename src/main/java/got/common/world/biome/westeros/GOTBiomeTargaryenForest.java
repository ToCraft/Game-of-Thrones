package got.common.world.biome.westeros;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.GOTAchievement;
import got.common.entity.animal.*;
import got.common.world.feature.GOTTreeType;
import got.common.world.map.GOTBezierType;
import got.common.world.map.GOTWaypoint.Region;
import net.minecraft.world.biome.BiomeGenBase;

public class GOTBiomeTargaryenForest extends GOTBiomeWesteros {
	public GOTBiomeTargaryenForest(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityWildBoar.class, 30, 2, 6));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityDeer.class, 8, 2, 2));
		clearBiomeVariants();
		decorator.treesPerChunk = 10;
		decorator.clearTrees();
		decorator.addTree(GOTTreeType.ASPEN, 100);
		decorator.flowersPerChunk = 4;
		decorator.doubleFlowersPerChunk = 2;
		decorator.grassPerChunk = 6;
		decorator.doubleGrassPerChunk = 1;
		registerForestFlowers();
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_TARGARYEN_FOREST;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.WESTEROS.getSubregion("targaryenForest");
	}

	@Override
	public Region getBiomeWaypoints() {
		return Region.TARGARYEN;
	}

	@Override
	public GOTBezierType getRoadBlock() {
		return GOTBezierType.WESTEROS_PATH;
	}
}
