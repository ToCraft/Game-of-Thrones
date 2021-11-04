package got.common.world.biome.essos;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;

public class GOTBiomeMossovyForest extends GOTBiomeMossovy {
	public GOTBiomeMossovyForest(int i, boolean major) {
		super(i, major);
		decorator.treesPerChunk = 12;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.ESSOS.getSubregion("mossovyForest");
	}
}