package got.common.world.biome.essos;

import java.util.Random;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.*;
import got.common.entity.animal.*;
import got.common.entity.essos.asshai.GOTEntityAsshaiAlchemist;
import got.common.entity.essos.qarth.GOTEntityQarthWarlock;
import got.common.entity.other.GOTEntityEssosBandit;
import got.common.world.biome.GOTBiome;
import got.common.world.biome.variant.GOTBiomeVariant;
import got.common.world.feature.*;
import got.common.world.map.GOTBezierType;
import got.common.world.map.GOTWaypoint.Region;
import got.common.world.spawning.*;
import got.common.world.structure.essos.ghiscar.GOTStructureGhiscarCity;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.feature.*;

public class GOTBiomeGhiscar extends GOTBiome {
	public static NoiseGeneratorPerlin noiseDirt = new NoiseGeneratorPerlin(new Random(3869098386927266L), 1);
	public static NoiseGeneratorPerlin noiseSand = new NoiseGeneratorPerlin(new Random(92726978206783582L), 1);
	public WorldGenerator boulderGen = new GOTWorldGenBoulder(Blocks.stone, 0, 1, 2);

	public GOTBiomeGhiscar(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.clear();
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityLion.class, 4, 2, 4));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityLioness.class, 4, 2, 4));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityGiraffe.class, 4, 4, 6));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityZebra.class, 8, 4, 8));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityRhino.class, 8, 4, 4));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityGemsbok.class, 8, 4, 8));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityCamel.class, 6, 4, 4));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityHorse.class, 10, 4, 4));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityElephant.class, 8, 1, 1));

		spawnableGOTAmbientList.clear();
		spawnableGOTAmbientList.add(new BiomeGenBase.SpawnListEntry(GOTEntityButterfly.class, 5, 4, 4));
		spawnableGOTAmbientList.add(new BiomeGenBase.SpawnListEntry(GOTEntityBird.class, 8, 4, 4));
		spawnableGOTAmbientList.add(new BiomeGenBase.SpawnListEntry(GOTEntityDikDik.class, 8, 4, 6));

		this.addBiomeVariant(GOTBiomeVariant.FLOWERS);
		this.addBiomeVariant(GOTBiomeVariant.FOREST);
		this.addBiomeVariant(GOTBiomeVariant.FOREST_LIGHT);
		this.addBiomeVariant(GOTBiomeVariant.STEPPE);
		this.addBiomeVariant(GOTBiomeVariant.STEPPE_BARREN);
		this.addBiomeVariant(GOTBiomeVariant.HILLS);
		this.addBiomeVariant(GOTBiomeVariant.HILLS_FOREST);
		this.addBiomeVariant(GOTBiomeVariant.SHRUBLAND_OAK);
		this.addBiomeVariant(GOTBiomeVariant.ORCHARD_ORANGE, 0.2f);
		this.addBiomeVariant(GOTBiomeVariant.ORCHARD_LEMON, 0.2f);
		this.addBiomeVariant(GOTBiomeVariant.ORCHARD_LIME, 0.2f);
		this.addBiomeVariant(GOTBiomeVariant.ORCHARD_OLIVE, 0.2f);
		this.addBiomeVariant(GOTBiomeVariant.ORCHARD_ALMOND, 0.2f);
		this.addBiomeVariant(GOTBiomeVariant.ORCHARD_PLUM, 0.2f);
		this.addBiomeVariant(GOTBiomeVariant.ORCHARD_DATE, 0.2f);
		this.addBiomeVariant(GOTBiomeVariant.SCRUBLAND_SAND);
		this.addBiomeVariant(GOTBiomeVariant.HILLS_SCRUBLAND_SAND);

		decorator.addOre(new WorldGenMinable(Blocks.lapis_ore, 6), 1.0f, 0, 48);

		decorator.grassPerChunk = 8;
		decorator.doubleGrassPerChunk = 1;
		decorator.flowersPerChunk = 3;
		decorator.cactiPerChunk = 1;

		decorator.addTree(GOTTreeType.OAK_DESERT, 1000);
		decorator.addTree(GOTTreeType.CEDAR, 250);
		decorator.addTree(GOTTreeType.LEMON, 5);
		decorator.addTree(GOTTreeType.ORANGE, 5);
		decorator.addTree(GOTTreeType.LIME, 5);
		decorator.addTree(GOTTreeType.OLIVE, 5);
		decorator.addTree(GOTTreeType.OLIVE_LARGE, 5);
		decorator.addTree(GOTTreeType.ALMOND, 5);
		decorator.addTree(GOTTreeType.PLUM, 5);

		registerEssosFlowers();

		setBanditChance(GOTEventSpawner.EventChance.BANDIT_COMMON);
		setBanditEntityClass(GOTEntityEssosBandit.class);

		registerTravellingTrader(GOTEntityAsshaiAlchemist.class);
		registerTravellingTrader(GOTEntityQarthWarlock.class);

		decorator.addVillage(new GOTStructureGhiscarCity(this, 1.0f));
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (random.nextInt(12) == 0) {
			int boulders = 1 + random.nextInt(4);
			for (int l = 0; l < boulders; ++l) {
				int i1 = i + random.nextInt(16) + 8;
				int k1 = k + random.nextInt(16) + 8;
				boulderGen.generate(world, random, i1, world.getHeightValue(i1, k1), k1);
			}
		}
		if (GOTSpawner.Yunkai.generatesAt(world, i, k)) {
			new GOTSpawner.Yunkai(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
		if (GOTSpawner.HizdahrZoLoraq.generatesAt(world, i, k)) {
			new GOTSpawner.HizdahrZoLoraq(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
	}

	@Override
	public void generateBiomeTerrain(World world, Random random, Block[] blocks, byte[] meta, int i, int k, double stoneNoise, int height, GOTBiomeVariant variant) {
		Block topBlock_pre = topBlock;
		int topBlockMeta_pre = topBlockMeta;
		Block fillerBlock_pre = fillerBlock;
		int fillerBlockMeta_pre = fillerBlockMeta;
		double d1 = noiseDirt.func_151601_a(i * 0.09, k * 0.09);
		double d2 = noiseDirt.func_151601_a(i * 0.4, k * 0.4);
		double d3 = noiseSand.func_151601_a(i * 0.09, k * 0.09);
		if (d3 + noiseSand.func_151601_a(i * 0.4, k * 0.4) > 0.6) {
			topBlock = Blocks.sand;
			topBlockMeta = 0;
			fillerBlock = topBlock;
			fillerBlockMeta = topBlockMeta;
		} else if (d1 + d2 > 0.2) {
			topBlock = Blocks.dirt;
			topBlockMeta = 1;
			fillerBlock = topBlock;
			fillerBlockMeta = topBlockMeta;
		}
		super.generateBiomeTerrain(world, random, blocks, meta, i, k, stoneNoise, height, variant);
		topBlock = topBlock_pre;
		topBlockMeta = topBlockMeta_pre;
		fillerBlock = fillerBlock_pre;
		fillerBlockMeta = fillerBlockMeta_pre;
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_GHISCAR;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.ESSOS.getSubregion("ghiscar");
	}

	@Override
	public Region getBiomeWaypoints() {
		return Region.GHISCAR;
	}

	@Override
	public GOTBiome.GrassBlockAndMeta getRandomGrass(Random random) {
		if (random.nextBoolean()) {
			return new GOTBiome.GrassBlockAndMeta(GOTRegistry.aridGrass, 0);
		}
		return super.getRandomGrass(random);
	}

	@Override
	public GOTBezierType getRoadBlock() {
		return GOTBezierType.ESSOS_PATH;
	}
}
