package got.common.world.biome.essos;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.GOTAchievement;
import got.common.world.biome.GOTBiome;
import got.common.world.biome.variant.GOTBiomeVariant;
import got.common.world.feature.GOTTreeType;
import got.common.world.map.GOTBezierType;
import got.common.world.map.GOTWaypoint.Region;

public class GOTBiomeQohorForest extends GOTBiome {
	public GOTBiomeQohorForest(int i, boolean major) {
		super(i, major);
		spawnableWaterCreatureList.clear();
		spawnableCaveCreatureList.clear();
		spawnableGOTAmbientList.clear();

		this.addBiomeVariant(GOTBiomeVariant.FLOWERS);
		this.addBiomeVariant(GOTBiomeVariant.FOREST_LIGHT, 2.0f);
		this.addBiomeVariant(GOTBiomeVariant.HILLS);
		this.addBiomeVariant(GOTBiomeVariant.HILLS_FOREST);

		decorator.treesPerChunk = 10;
		decorator.clearTrees();
		decorator.addTree(GOTTreeType.CATALPA, 20);
		enablePodzol = false;
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_QOHOR_FOREST;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.ESSOS.getSubregion("qohorForest");
	}

	@Override
	public Region getBiomeWaypoints() {
		return Region.FREE;
	}

	@Override
	public GOTBezierType getRoadBlock() {
		return GOTBezierType.ESSOS_PATH;
	}
}
