package got.common.world.biome.westeros;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.entity.animal.GOTEntityMidges;
import got.common.world.feature.GOTTreeType;
import net.minecraft.world.biome.BiomeGenBase;

public class GOTBiomeWetwood extends GOTBiomeWesteros {
	public GOTBiomeWetwood(int i, boolean major) {
		super(i, major);
		spawnableGOTAmbientList.add(new BiomeGenBase.SpawnListEntry(GOTEntityMidges.class, 10, 4, 4));
		clearBiomeVariants();
		decorator.treesPerChunk = 5;
		decorator.clearTrees();
		decorator.addTree(GOTTreeType.WILLOW, 100);
		decorator.flowersPerChunk = 4;
		decorator.doubleFlowersPerChunk = 1;
		decorator.grassPerChunk = 10;
		decorator.doubleGrassPerChunk = 4;
		registerSwampFlowers();
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.WESTEROS.getSubregion("wetwood");
	}
}