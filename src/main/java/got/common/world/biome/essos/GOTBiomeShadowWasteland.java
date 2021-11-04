package got.common.world.biome.essos;

import java.util.Random;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.*;
import got.common.world.biome.GOTBiome;
import got.common.world.biome.variant.GOTBiomeVariant;
import got.common.world.feature.*;
import got.common.world.map.GOTBezierType;
import got.common.world.map.GOTWaypoint.Region;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.feature.WorldGenerator;

public class GOTBiomeShadowWasteland extends GOTBiome {
	public NoiseGeneratorPerlin noiseDirt = new NoiseGeneratorPerlin(new Random(42956029606L), 1);
	public NoiseGeneratorPerlin noiseGravel = new NoiseGeneratorPerlin(new Random(7185609602367L), 1);
	public NoiseGeneratorPerlin noiseMordorGravel = new NoiseGeneratorPerlin(new Random(12480634985056L), 1);
	public WorldGenerator boulderGen = new GOTWorldGenBoulder(Blocks.stone, 0, 1, 2);

	public GOTBiomeShadowWasteland(int i, boolean major) {
		super(i, major);
		topBlock = GOTRegistry.asshaiDirt;
		topBlockMeta = 0;
		fillerBlock = GOTRegistry.asshaiDirt;
		fillerBlockMeta = 0;

		spawnableCreatureList.clear();
		spawnableWaterCreatureList.clear();
		spawnableGOTAmbientList.clear();

		decorator.treesPerChunk = -1;
		decorator.flowersPerChunk = -1;
		decorator.grassPerChunk = -1;

		decorator.addTree(GOTTreeType.CHARRED, 1000);
		biomeColors.setSky(5657394);
		biomeColors.setClouds(10525542);
		biomeColors.setFog(4210724);
		biomeColors.setWater(1316367);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (random.nextInt(24) == 0) {
			int boulders = 1 + random.nextInt(4);
			for (int l = 0; l < boulders; ++l) {
				int i1 = i + random.nextInt(16) + 8;
				int k1 = k + random.nextInt(16) + 8;
				boulderGen.generate(world, random, i1, world.getHeightValue(i1, k1), k1);
			}
		}
	}

	@Override
	public void generateBiomeTerrain(World world, Random random, Block[] blocks, byte[] meta, int i, int k, double stoneNoise, int height, GOTBiomeVariant variant) {
		Block topBlock_pre = topBlock;
		int topBlockMeta_pre = topBlockMeta;
		Block fillerBlock_pre = fillerBlock;
		int fillerBlockMeta_pre = fillerBlockMeta;
		double d1 = noiseDirt.func_151601_a(i * 0.09, k * 0.09);
		double d2 = noiseDirt.func_151601_a(i * 0.6, k * 0.6);
		double d3 = noiseGravel.func_151601_a(i * 0.09, k * 0.09);
		double d4 = noiseGravel.func_151601_a(i * 0.6, k * 0.6);
		double d5 = noiseMordorGravel.func_151601_a(i * 0.09, k * 0.09);
		if (d5 + noiseMordorGravel.func_151601_a(i * 0.6, k * 0.6) > 0.5) {
			topBlock = GOTRegistry.basaltGravel;
			topBlockMeta = 0;
		} else if (d3 + d4 > 0.6) {
			topBlock = Blocks.gravel;
			topBlockMeta = 0;
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
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_SHADOW_WASTELAND;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.ESSOS.getSubregion("shadowWasteland");
	}

	@Override
	public Region getBiomeWaypoints() {
		return Region.ASSHAI;
	}

	@Override
	public boolean getEnableRiver() {
		return false;
	}

	@Override
	public GOTBezierType getRoadBlock() {
		return GOTBezierType.YITI;
	}
}
