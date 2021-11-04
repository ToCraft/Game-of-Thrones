package got.common.world.biome.essos;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.world.feature.GOTTreeType;

public class GOTBiomeIbbenTaiga extends GOTBiomeIbben {
	public GOTBiomeIbbenTaiga(int i, boolean major) {
		super(i, major);
		decorator.clearTrees();
		decorator.treesPerChunk = 12;
		decorator.addTree(GOTTreeType.IBBEN_PINE, 20);
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.ESSOS.getSubregion("ibbenTaiga");
	}
}