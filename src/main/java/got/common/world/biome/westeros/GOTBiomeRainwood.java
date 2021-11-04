package got.common.world.biome.westeros;

import java.util.Random;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.entity.animal.*;
import got.common.world.biome.variant.GOTBiomeVariant;
import got.common.world.feature.*;
import got.common.world.map.GOTBezierType;
import got.common.world.map.GOTWaypoint.Region;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.feature.WorldGenerator;

public class GOTBiomeRainwood extends GOTBiomeWesteros {
	public static NoiseGeneratorPerlin noiseDirt = new NoiseGeneratorPerlin(new Random(285939985023633003L), 1);
	public static NoiseGeneratorPerlin noiseStone = new NoiseGeneratorPerlin(new Random(4148990259960304L), 1);
	public WorldGenerator boulderGen = new GOTWorldGenBoulder(Blocks.stone, 0, 1, 4);

	public GOTBiomeRainwood(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityBear.class, 4, 1, 4));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityDeer.class, 8, 2, 2));

		clearBiomeVariants();

		decorator.treesPerChunk = 10;
		decorator.flowersPerChunk = 3;
		decorator.doubleFlowersPerChunk = 1;
		decorator.grassPerChunk = 14;
		decorator.doubleGrassPerChunk = 6;

		decorator.addTree(GOTTreeType.OAK, 400);
		decorator.addTree(GOTTreeType.OAK_LARGE, 200);
		decorator.addTree(GOTTreeType.OAK_PARTY, 50);
		decorator.addTree(GOTTreeType.BIRCH, 50);
		decorator.addTree(GOTTreeType.BIRCH_LARGE, 20);
		decorator.addTree(GOTTreeType.BEECH, 50);
		decorator.addTree(GOTTreeType.BEECH_LARGE, 20);
		decorator.addTree(GOTTreeType.CHESTNUT, 200);
		decorator.addTree(GOTTreeType.CHESTNUT_LARGE, 50);
		decorator.addTree(GOTTreeType.DARK_OAK, 500);
		decorator.addTree(GOTTreeType.DARK_OAK_PARTY, 100);
		decorator.addTree(GOTTreeType.FIR, 200);
		decorator.addTree(GOTTreeType.PINE, 200);
		decorator.addTree(GOTTreeType.SPRUCE, 200);
		decorator.addTree(GOTTreeType.LARCH, 200);
		decorator.addTree(GOTTreeType.APPLE, 5);
		decorator.addTree(GOTTreeType.PEAR, 5);
		decorator.addTree(GOTTreeType.PLUM, 5);
	}

	@Override
	public void generateBiomeTerrain(World world, Random random, Block[] blocks, byte[] meta, int i, int k, double stoneNoise, int height, GOTBiomeVariant variant) {
		Block topBlock_pre = topBlock;
		int topBlockMeta_pre = topBlockMeta;
		Block fillerBlock_pre = fillerBlock;
		int fillerBlockMeta_pre = fillerBlockMeta;
		double d1 = noiseDirt.func_151601_a(i * 0.06, k * 0.06);
		double d2 = noiseDirt.func_151601_a(i * 0.4, k * 0.4);
		double d3 = noiseStone.func_151601_a(i * 0.06, k * 0.06);
		if (d3 + noiseStone.func_151601_a(i * 0.4, k * 0.4) > 1.3) {
			topBlock = Blocks.stone;
			topBlockMeta = 0;
			fillerBlock = topBlock;
			fillerBlockMeta = topBlockMeta;
		} else if (d1 + d2 > 0.7) {
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
		return GOTBiomeMusic.WESTEROS.getSubregion("rainwood");
	}

	@Override
	public Region getBiomeWaypoints() {
		return Region.STORMLANDS;
	}

	@Override
	public GOTBezierType getRoadBlock() {
		return GOTBezierType.WESTEROS_PATH;
	}
}
