package got.common.world.biome.westeros;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.entity.animal.*;
import got.common.world.biome.variant.GOTBiomeVariant;
import got.common.world.feature.GOTTreeType;
import got.common.world.map.GOTWaypoint.Region;
import net.minecraft.world.biome.BiomeGenBase;

public class GOTBiomeNorthForest extends GOTBiomeNorth {
	public GOTBiomeNorthForest(int i, boolean major) {
		super(i, major);
		clearBiomeVariants();
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityBear.class, 10, 1, 4));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityDeer.class, 8, 2, 2));

		decorator.treesPerChunk = 10;
		decorator.flowersPerChunk = 4;
		decorator.doubleFlowersPerChunk = 1;
		decorator.grassPerChunk = 10;
		decorator.doubleGrassPerChunk = 4;
		this.addBiomeVariant(GOTBiomeVariant.FOREST_WEIRWOOD, 0.2f);

		decorator.clearTrees();
		decorator.addTree(GOTTreeType.SPRUCE, 400);
		decorator.addTree(GOTTreeType.SPRUCE_THIN, 400);
		decorator.addTree(GOTTreeType.LARCH, 300);
		decorator.addTree(GOTTreeType.SPRUCE_MEGA, 100);
		decorator.addTree(GOTTreeType.SPRUCE_MEGA_THIN, 20);
		decorator.addTree(GOTTreeType.FIR, 500);
		decorator.addTree(GOTTreeType.PINE, 500);

		registerForestFlowers();
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.WESTEROS.getSubregion("northForest");
	}

	@Override
	public Region getBiomeWaypoints() {
		return Region.NORTH;
	}
}