package got.common.world.biome.ulthos;

import java.util.Random;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.*;
import got.common.world.biome.GOTBiome;
import got.common.world.biome.variant.GOTBiomeVariant;
import got.common.world.feature.GOTTreeType;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class GOTBiomeUlthosMountains extends GOTBiome {
	public GOTBiomeUlthosMountains(int i, boolean major) {
		super(i, major);
		addBiomeVariant(GOTBiomeVariant.FOREST_PINE, 0.2f);
		addBiomeVariantSet(GOTBiomeVariant.SET_MOUNTAINS);
		biomeColors.setGrass(2841381);
		biomeColors.setFoliage(2503461);
		biomeColors.setFog(3302525);
		biomeColors.setFoggy(true);
		biomeColors.setWater(1708838);
		decorator.addTree(GOTTreeType.ULTHOS_OAK_LARGE, 1000);
		decorator.addTree(GOTTreeType.OAK_LARGE, 300);
		decorator.addTree(GOTTreeType.SPRUCE, 200);
		decorator.addTree(GOTTreeType.FIR, 200);
		decorator.addTree(GOTTreeType.PINE, 400);
		decorator.biomeGemFactor = 1.0f;
		decorator.doubleFlowersPerChunk = 0;
		decorator.doubleGrassPerChunk = 1;
		decorator.flowersPerChunk = 1;
		decorator.grassPerChunk = 4;
		decorator.addOre(new WorldGenMinable(GOTRegistry.oreCobalt, 5), 5.0f, 0, 32);
		enableRocky = true;
		npcSpawnList.clear();
		registerMountainsFlowers();
		spawnableCreatureList.clear();
	}

	@Override
	public boolean canSpawnHostilesInDay() {
		return true;
	}

	@Override
	public void generateMountainTerrain(World world, Random random, Block[] blocks, byte[] meta, int i, int k, int xzIndex, int ySize, int height, int rockDepth, GOTBiomeVariant variant) {
		int snowHeight = 150 - rockDepth;
		int stoneHeight = snowHeight - 40;
		for (int j = ySize - 1; j >= stoneHeight; --j) {
			int index = xzIndex * ySize + j;
			Block block = blocks[index];
			if (j >= snowHeight && block == topBlock) {
				blocks[index] = Blocks.snow;
				meta[index] = 0;
			} else if (block == topBlock || block == fillerBlock) {
				blocks[index] = Blocks.stone;
				meta[index] = 0;
			}
			block = blocks[index];
			if (block != Blocks.stone) {
				continue;
			}
			if (random.nextInt(6) == 0) {
				int h = 1 + random.nextInt(6);
				for (int j1 = j; j1 > j - h && j1 > 0; --j1) {
					int indexH = xzIndex * ySize + j1;
					if (blocks[indexH] != Blocks.stone) {
						continue;
					}
					blocks[indexH] = GOTRegistry.rock;
					meta[indexH] = 3;
				}
				continue;
			}
			if (random.nextInt(16) != 0) {
				continue;
			}
			blocks[index] = GOTRegistry.rock;
			meta[index] = 3;
		}
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_ULTHOS_MOUNTAINS;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.ULTHOS.getSubregion("ulthosMountains");
	}
}