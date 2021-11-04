package got.common.world.biome.essos;

import java.util.Random;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.*;
import got.common.entity.animal.*;
import got.common.world.biome.GOTBiome;
import got.common.world.biome.variant.GOTBiomeVariant;
import got.common.world.feature.*;
import got.common.world.map.GOTWaypoint.Region;
import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.*;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class GOTBiomeMossovyTundra extends GOTBiome {
	public static NoiseGeneratorPerlin noiseDirt = new NoiseGeneratorPerlin(new Random(47684796930956L), 1);
	public static NoiseGeneratorPerlin noiseStone = new NoiseGeneratorPerlin(new Random(8894086030764L), 1);
	public static NoiseGeneratorPerlin noiseSnow = new NoiseGeneratorPerlin(new Random(2490309256000602L), 1);
	public WorldGenerator boulderGen = new GOTWorldGenBoulder(Blocks.stone, 0, 1, 3);

	public GOTBiomeMossovyTundra(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.clear();
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityWolf.class, 10, 4, 8));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityDeer.class, 8, 2, 2));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityBear.class, 10, 1, 4));

		spawnableGOTAmbientList.clear();
		this.addBiomeVariant(GOTBiomeVariant.STEPPE);
		this.addBiomeVariant(GOTBiomeVariant.STEPPE_BARREN);
		this.addBiomeVariant(GOTBiomeVariant.HILLS);
		this.addBiomeVariant(GOTBiomeVariant.DEADFOREST_OAK);
		this.addBiomeVariant(GOTBiomeVariant.DEADFOREST_SPRUCE);
		this.addBiomeVariant(GOTBiomeVariant.DEADFOREST_OAK_SPRUCE);

		decorator.treesPerChunk = 0;
		decorator.flowersPerChunk = 2;
		decorator.grassPerChunk = 4;
		decorator.doubleGrassPerChunk = 1;

		decorator.addTree(GOTTreeType.SPRUCE_THIN, 100);
		decorator.addTree(GOTTreeType.SPRUCE_DEAD, 100);
		decorator.addTree(GOTTreeType.PINE, 100);
		decorator.addTree(GOTTreeType.FIR, 100);
		registerTaigaFlowers();
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (random.nextInt(2) == 0) {
			int i1 = i + random.nextInt(16) + 8;
			int k1 = k + random.nextInt(16) + 8;
			int j1 = world.getHeightValue(i1, k1);
			int bushes = 4 + random.nextInt(20);
			for (int l = 0; l < bushes; ++l) {
				int i2 = i1 + MathHelper.getRandomIntegerInRange(random, -4, 4);
				int k2 = k1 + MathHelper.getRandomIntegerInRange(random, -4, 4);
				int j2 = j1 + MathHelper.getRandomIntegerInRange(random, -1, 1);
				Block below = world.getBlock(i2, j2 - 1, k2);
				Block block = world.getBlock(i2, j2, k2);
				if (!below.canSustainPlant((IBlockAccess) world, i2, j2 - 1, k2, ForgeDirection.UP, (IPlantable) Blocks.sapling) || block.getMaterial().isLiquid() || !block.isReplaceable(world, i2, j2, k2)) {
					continue;
				}
				Block leafBlock = Blocks.leaves;
				int leafMeta = 1;
				if (random.nextInt(3) == 0) {
					leafBlock = GOTRegistry.leaves3;
					leafMeta = 0;
				} else if (random.nextInt(3) == 0) {
					leafBlock = GOTRegistry.leaves2;
					leafMeta = 1;
				}
				world.setBlock(i2, j2, k2, leafBlock, leafMeta | 4, 2);
			}
		}
		if (random.nextInt(40) == 0) {
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
		double d1 = noiseDirt.func_151601_a(i * 0.07, k * 0.07);
		double d2 = noiseDirt.func_151601_a(i * 0.3, k * 0.3);
		double d3 = noiseStone.func_151601_a(i * 0.07, k * 0.07);
		if (d3 + noiseStone.func_151601_a(i * 0.3, k * 0.3) > 1.2) {
			topBlock = Blocks.stone;
			topBlockMeta = 0;
			fillerBlock = topBlock;
			fillerBlockMeta = topBlockMeta;
		} else if (d1 + d2 > 0.8) {
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
		return GOTAchievement.VISIT_MOSSOVY_TUNDRA;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.ESSOS.getSubregion("mossovyTundra");
	}

	@Override
	public Region getBiomeWaypoints() {
		return Region.MOSSOVY;
	}

	public static boolean isTundraSnowy(int i, int k) {
		double d1 = noiseSnow.func_151601_a(i * 0.002, k * 0.002);
		double d2 = noiseSnow.func_151601_a(i * 0.05, k * 0.05);
		double d3 = noiseSnow.func_151601_a(i * 0.3, k * 0.3);
		return d1 + (d2 *= 0.3) + (d3 *= 0.3) > 0.8;
	}
}