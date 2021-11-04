package got.common.world.biome.sothoryos;

import java.util.Random;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.*;
import got.common.world.biome.GOTBiome;
import got.common.world.biome.variant.GOTBiomeVariant;
import got.common.world.feature.GOTWorldGenBoulder;
import got.common.world.map.GOTBezierType;
import got.common.world.map.GOTWaypoint.Region;
import got.common.world.spawning.GOTBiomeSpawnList;
import got.common.world.spawning.GOTBiomeSpawnList.SpawnListContainer;
import got.common.world.structure.sothoryos.sothoryos.GOTStructureSothoryosVillage;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class GOTBiomeSothoryosBushland extends GOTBiome {
	public WorldGenerator boulderGen = new GOTWorldGenBoulder(Blocks.stone, 0, 1, 3);

	public GOTBiomeSothoryosBushland(int i, boolean major) {
		super(i, major);
		this.addBiomeVariant(GOTBiomeVariant.FLOWERS);
		this.addBiomeVariant(GOTBiomeVariant.FOREST);
		this.addBiomeVariant(GOTBiomeVariant.FOREST_LIGHT);
		this.addBiomeVariant(GOTBiomeVariant.STEPPE);
		this.addBiomeVariant(GOTBiomeVariant.STEPPE_BARREN);
		this.addBiomeVariant(GOTBiomeVariant.HILLS);
		this.addBiomeVariant(GOTBiomeVariant.HILLS_FOREST);
		this.addBiomeVariant(GOTBiomeVariant.DEADFOREST_OAK);
		this.addBiomeVariant(GOTBiomeVariant.SHRUBLAND_OAK);

		decorator.treesPerChunk = 0;
		decorator.logsPerChunk = 1;
		decorator.grassPerChunk = 16;
		decorator.doubleGrassPerChunk = 10;

		SpawnListContainer[] container = new SpawnListContainer[2];
		container[0] = GOTBiomeSpawnList.entry(GOTSpawnList.SOTHORYOS_CIVILIAN, 10).setSpawnChance(1000);
		container[1] = GOTBiomeSpawnList.entry(GOTSpawnList.SOTHORYOS_MILITARY, 4).setSpawnChance(1000);
		npcSpawnList.newFactionList(100).add(container);

		decorator.addVillage(new GOTStructureSothoryosVillage(this, 0.5f));
	}

	@Override
	public boolean canSpawnHostilesInDay() {
		return true;
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		int i1;
		int k1;
		int l;
		super.decorate(world, random, i, k);
		if (random.nextInt(32) == 0) {
			int boulders = 1 + random.nextInt(4);
			for (l = 0; l < boulders; ++l) {
				i1 = i + random.nextInt(16) + 8;
				k1 = k + random.nextInt(16) + 8;
				boulderGen.generate(world, random, i1, world.getHeightValue(i1, k1), k1);
			}
		}
		if (random.nextInt(16) == 0) {
			int termites = 1 + random.nextInt(4);
			for (l = 0; l < termites; ++l) {
				i1 = i + random.nextInt(16) + 8;
				k1 = k + random.nextInt(16) + 8;
				int j1 = world.getHeightValue(i1, k1);
				new GOTWorldGenBoulder(GOTRegistry.termiteMound, 0, 1, 4).generate(world, random, i1, j1, k1);
				for (int x = 0; x < 5; ++x) {
					int k2;
					int j2;
					int i2 = i1 - random.nextInt(5) + random.nextInt(5);
					if (!world.getBlock(i2, (j2 = world.getHeightValue(i2, k2 = k1 - random.nextInt(5) + random.nextInt(5))) - 1, k1).isOpaqueCube()) {
						continue;
					}
					int j3 = j2 + random.nextInt(4);
					for (int j4 = j2; j4 <= j3; ++j4) {
						world.setBlock(i2, j4, k2, GOTRegistry.termiteMound);
						world.getBlock(i2, j4 - 1, k2).onPlantGrow(world, i2, j4 - 1, k2, i2, j4 - 1, k2);
					}
				}
			}
		}
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_SOTHORYOS_BUSHLAND;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.SOTHORYOS.getSubregion("sothoryosBushland");
	}

	@Override
	public Region getBiomeWaypoints() {
		return Region.SOTHORYOS;
	}

	@Override
	public GOTBezierType getRoadBlock() {
		return GOTBezierType.SOTHORYOS;
	}
}
