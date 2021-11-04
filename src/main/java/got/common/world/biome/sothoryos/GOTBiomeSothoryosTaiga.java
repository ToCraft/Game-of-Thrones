package got.common.world.biome.sothoryos;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.GOTAchievement;
import got.common.entity.animal.GOTEntityMammoth;
import got.common.world.biome.GOTBiome;
import got.common.world.feature.GOTTreeType;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

public class GOTBiomeSothoryosTaiga extends GOTBiome {
	public GOTBiomeSothoryosTaiga(int i, boolean major) {
		super(i, major);
		topBlock = Blocks.grass;
		fillerBlock = Blocks.snow;
		spawnableCreatureList.clear();
		spawnableWaterCreatureList.clear();
		spawnableCaveCreatureList.clear();
		spawnableGOTAmbientList.clear();
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityMammoth.class, 8, 1, 1));
		clearBiomeVariants();
		decorator.clearTrees();
		decorator.treesPerChunk = 10;
		decorator.addTree(GOTTreeType.PINE, 20);
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_SOTHORYOS_TAIGA;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.SOTHORYOS.getSubregion("taiga");
	}

	@Override
	public boolean getEnableRiver() {
		return false;
	}
}