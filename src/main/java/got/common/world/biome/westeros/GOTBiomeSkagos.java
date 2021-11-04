package got.common.world.biome.westeros;

import java.util.Random;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.*;
import got.common.entity.animal.*;
import got.common.world.biome.GOTBiome;
import got.common.world.biome.variant.GOTBiomeVariant;
import got.common.world.feature.*;
import got.common.world.map.GOTWaypoint.Region;
import got.common.world.spawning.GOTBiomeSpawnList;
import got.common.world.spawning.GOTBiomeSpawnList.SpawnListContainer;
import got.common.world.structure.westeros.north.hillmen.GOTStructureNorthHillmanCamp;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class GOTBiomeSkagos extends GOTBiome {
	public WorldGenerator boulderGen = new GOTWorldGenBoulder(Blocks.stone, 0, 1, 6);

	public GOTBiomeSkagos(int i, boolean major) {
		super(i, major);
		decorator.treesPerChunk = 1;
		decorator.flowersPerChunk = 0;
		decorator.doubleFlowersPerChunk = 0;
		decorator.grassPerChunk = 10;
		decorator.doubleGrassPerChunk = 6;
		decorator.addTree(GOTTreeType.OAK_DEAD, 2000);
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityWoolyRhino.class, 8, 2, 2));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityBear.class, 10, 1, 4));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityDeer.class, 8, 2, 2));
		decorator.addRandomStructure(new GOTStructureNorthHillmanCamp(false), 50);

		SpawnListContainer[] container0 = new SpawnListContainer[1];
		container0[0] = GOTBiomeSpawnList.entry(GOTSpawnList.NORTH_HILLMEN, 10).setSpawnChance(500);
		npcSpawnList.newFactionList(100).add(container0);

		SpawnListContainer[] container3 = new SpawnListContainer[1];
		container3[0] = GOTBiomeSpawnList.entry(GOTSpawnList.WALKERS_CONQUEST, 10);
		npcSpawnList.newFactionList(0).add(container3);

		SpawnListContainer[] container2 = new SpawnListContainer[2];
		container2[0] = GOTBiomeSpawnList.entry(GOTSpawnList.WILDING_MILITARY, 4);
		container2[1] = GOTBiomeSpawnList.entry(GOTSpawnList.WILDING_GIANT, 1);
		npcSpawnList.newFactionList(0).add(container2);

        SpawnListContainer[] containerLSR = new SpawnListContainer[1];
        containerLSR[0] = GOTBiomeSpawnList.entry(GOTSpawnList.UNRELIABLE, 10).setSpawnChance(500);
        this.npcSpawnList.newFactionList(5).add(containerLSR);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (random.nextInt(4) == 0) {
			for (int l = 0; l < 3; ++l) {
				int i1 = i + random.nextInt(16) + 8;
				int k1 = k + random.nextInt(16) + 8;
				boulderGen.generate(world, random, i1, world.getHeightValue(i1, k1), k1);
			}
		}
	}

	@Override
	public void generateMountainTerrain(World world, Random random, Block[] blocks, byte[] meta, int i, int k, int xzIndex, int ySize, int height, int rockDepth, GOTBiomeVariant variant) {
		int stoneHeight = 90 - rockDepth;
		for (int j = ySize - 1; j >= stoneHeight; --j) {
			int index = xzIndex * ySize + j;
			Block block = blocks[index];
			if (block != topBlock && block != fillerBlock) {
				continue;
			}
			blocks[index] = Blocks.stone;
			meta[index] = 0;
		}
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_SKAGOS;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.WESTEROS.getSubregion("skagos");
	}

	@Override
	public Region getBiomeWaypoints() {
		return Region.NORTH;
	}
}
