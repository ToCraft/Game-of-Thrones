package got.common.world.biome.essos;

import java.util.Random;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.entity.animal.*;
import got.common.world.biome.GOTBiome;
import got.common.world.feature.*;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.feature.WorldGenerator;

public class GOTBiomeEssosForest extends GOTBiome {
	public static NoiseGeneratorPerlin populatedNoise = new NoiseGeneratorPerlin(new Random(100L), 1);
	public WorldGenerator boulderGen = new GOTWorldGenBoulder(Blocks.stone, 0, 1, 3);

	public GOTBiomeEssosForest(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.clear();
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityLion.class, 4, 2, 4));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityLioness.class, 4, 2, 4));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityGiraffe.class, 4, 4, 6));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityZebra.class, 8, 4, 8));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityRhino.class, 8, 4, 4));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityGemsbok.class, 8, 4, 8));

		spawnableGOTAmbientList.clear();
		spawnableGOTAmbientList.add(new BiomeGenBase.SpawnListEntry(GOTEntityButterfly.class, 5, 4, 4));
		spawnableGOTAmbientList.add(new BiomeGenBase.SpawnListEntry(GOTEntityBird.class, 8, 4, 4));
		spawnableGOTAmbientList.add(new BiomeGenBase.SpawnListEntry(GOTEntityDikDik.class, 8, 4, 6));

		decorator.addTree(GOTTreeType.CEDAR, 600);
		decorator.addTree(GOTTreeType.CEDAR_LARGE, 150);
		decorator.addTree(GOTTreeType.ACACIA, 50);
		decorator.addTree(GOTTreeType.CYPRESS, 400);
		decorator.addTree(GOTTreeType.CYPRESS_LARGE, 50);
		decorator.addTree(GOTTreeType.PALM, 100);
		decorator.addTree(GOTTreeType.BAOBAB, 20);

		registerEssosFlowers();

		decorator.treesPerChunk = 10;
		decorator.flowersPerChunk = 4;
		decorator.doubleFlowersPerChunk = 1;
		decorator.grassPerChunk = 10;
		decorator.doubleGrassPerChunk = 4;
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (random.nextInt(32) == 0) {
			int boulders = 1 + random.nextInt(4);
			for (int l = 0; l < boulders; ++l) {
				int i1 = i + random.nextInt(16) + 8;
				int k1 = k + random.nextInt(16) + 8;
				boulderGen.generate(world, random, i1, world.getHeightValue(i1, k1), k1);
			}
		}
		if (random.nextInt(6) == 0) {
			int i1 = i + random.nextInt(16) + 8;
			int j1 = random.nextInt(128);
			int k1 = k + random.nextInt(16) + 8;
			new GOTWorldGenYams().generate(world, random, i1, j1, k1);
		}
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.ESSOS.getSubregion("essosForest");
	}
}