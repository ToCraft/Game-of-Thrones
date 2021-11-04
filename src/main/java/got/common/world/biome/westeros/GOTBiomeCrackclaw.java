package got.common.world.biome.westeros;

import java.util.Random;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.GOTRegistry;
import got.common.world.biome.variant.GOTBiomeVariant;
import got.common.world.feature.*;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.feature.WorldGenerator;

public class GOTBiomeCrackclaw extends GOTBiomeDragonstone {
	public static NoiseGeneratorPerlin noiseDirt = new NoiseGeneratorPerlin(new Random(285939985023633003L), 1);
	public static NoiseGeneratorPerlin noiseStone = new NoiseGeneratorPerlin(new Random(4148990259960304L), 1);
	public WorldGenerator boulderGen = new GOTWorldGenBoulder(Blocks.stone, 0, 1, 4);
	public WorldGenerator boulderGenCracklaw = new GOTWorldGenBoulder(GOTRegistry.rock, 1, 1, 4);

	public GOTBiomeCrackclaw(int i, boolean major) {
		super(i, major);
		npcSpawnList.clear();
		clearBiomeVariants();
		decorator.clearTrees();
		decorator.treesPerChunk = 10;
		decorator.flowersPerChunk = 3;
		decorator.doubleFlowersPerChunk = 1;
		decorator.grassPerChunk = 12;
		decorator.doubleGrassPerChunk = 4;
		decorator.addTree(GOTTreeType.SPRUCE, 200);
		registerPlainsFlowers();
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (random.nextInt(5) == 0) {
			for (int l = 0; l < 4; ++l) {
				int i1 = i + random.nextInt(16) + 8;
				int k1 = k + random.nextInt(16) + 8;
				if (random.nextBoolean()) {
					boulderGen.generate(world, random, i1, world.getHeightValue(i1, k1), k1);
					continue;
				}
				boulderGenCracklaw.generate(world, random, i1, world.getHeightValue(i1, k1), k1);
			}
		}
	}

	@Override
	public void generateBiomeTerrain(World world, Random random, Block[] blocks, byte[] meta, int i, int k, double stoneNoise, int height, GOTBiomeVariant variant) {
		Block topBlock_pre = topBlock;
		int topBlockMeta_pre = topBlockMeta;
		Block fillerBlock_pre = fillerBlock;
		int fillerBlockMeta_pre = fillerBlockMeta;
		double d1 = noiseDirt.func_151601_a(i * 0.07, k * 0.07);
		double d2 = noiseDirt.func_151601_a(i * 0.3, k * 0.3);
		double d3 = noiseStone.func_151601_a(i * 0.07, k * 0.07);
		if (d3 + noiseStone.func_151601_a(i * 0.3, k * 0.3) > 1.1) {
			topBlock = Blocks.stone;
			topBlockMeta = 0;
			fillerBlock = topBlock;
			fillerBlockMeta = topBlockMeta;
		} else if (d1 + d2 > 0.6) {
			topBlock = Blocks.dirt;
			topBlockMeta = 1;
		}
		super.generateBiomeTerrain(world, random, blocks, meta, i, k, stoneNoise, height, variant);
		topBlock = topBlock_pre;
		topBlockMeta = topBlockMeta_pre;
		fillerBlock = fillerBlock_pre;
		fillerBlockMeta = fillerBlockMeta_pre;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.WESTEROS.getSubregion("cracklaw");
	}
}
