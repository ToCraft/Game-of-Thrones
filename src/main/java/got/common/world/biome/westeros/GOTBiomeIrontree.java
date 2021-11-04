package got.common.world.biome.westeros;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.GOTAchievement;
import got.common.world.feature.GOTTreeType;
import got.common.world.map.GOTWaypoint.Region;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.world.biome.BiomeGenBase;

public class GOTBiomeIrontree extends GOTBiomeWesterosForest {
	public GOTBiomeIrontree(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityWolf.class, 30, 4, 8));
		clearBiomeVariants();
		decorator.clearTrees();
		decorator.addTree(GOTTreeType.REDWOOD, 1);
		decorator.addTree(GOTTreeType.REDWOOD_2, 1);
		decorator.addTree(GOTTreeType.REDWOOD_3, 1);
		decorator.addTree(GOTTreeType.REDWOOD_4, 1);
		decorator.addTree(GOTTreeType.REDWOOD_5, 1);
		decorator.treesPerChunk = 10;
		decorator.flowersPerChunk = 4;
		decorator.doubleFlowersPerChunk = 1;
		decorator.grassPerChunk = 10;
		decorator.doubleGrassPerChunk = 4;
		registerForestFlowers();
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_IRONTREE;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.WESTEROS.getSubregion("irontree");
	}

	@Override
	public Region getBiomeWaypoints() {
		return Region.NORTH;
	}
}