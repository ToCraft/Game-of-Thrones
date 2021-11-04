package got.common.world.biome.westeros;

import java.util.Random;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.*;
import got.common.entity.animal.*;
import got.common.world.biome.GOTBiome;
import got.common.world.feature.*;
import got.common.world.map.GOTBezierType;
import got.common.world.map.GOTWaypoint.Region;
import got.common.world.spawning.GOTBiomeSpawnList;
import got.common.world.spawning.GOTBiomeSpawnList.SpawnListContainer;
import got.common.world.structure.westeros.north.hillmen.GOTStructureNorthHillmanCamp;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class GOTBiomeNorthWild extends GOTBiome {
	public WorldGenerator boulderGen = new GOTWorldGenBoulder(Blocks.stone, 0, 1, 3);

	public GOTBiomeNorthWild(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityWolf.class, 8, 4, 8));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityBear.class, 10, 1, 4));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityDeer.class, 8, 2, 2));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityWoolyRhino.class, 8, 2, 2));
		decorator.treesPerChunk = 7;
		decorator.grassPerChunk = 6;
		decorator.doubleGrassPerChunk = 1;
		decorator.addTree(GOTTreeType.SPRUCE, 500);
		decorator.addTree(GOTTreeType.OAK_TALL, 200);
		decorator.addTree(GOTTreeType.OAK_LARGE, 20);
		decorator.addTree(GOTTreeType.CHESTNUT, 50);
		decorator.addTree(GOTTreeType.CHESTNUT_LARGE, 10);
		decorator.addTree(GOTTreeType.FIR, 500);
		decorator.addTree(GOTTreeType.PINE, 500);
		registerForestFlowers();
		decorator.addRandomStructure(new GOTStructureNorthHillmanCamp(false), 50);

		SpawnListContainer[] container0 = new SpawnListContainer[1];
		container0[0] = GOTBiomeSpawnList.entry(GOTSpawnList.NORTH_HILLMEN, 10).setSpawnChance(500);
		npcSpawnList.newFactionList(100).add(container0);

		SpawnListContainer[] container3 = new SpawnListContainer[1];
		container3[0] = GOTBiomeSpawnList.entry(GOTSpawnList.WALKERS_CONQUEST, 10);
		npcSpawnList.newFactionList(0).add(container3);

		SpawnListContainer[] container2 = new SpawnListContainer[2];
		container2[0] = GOTBiomeSpawnList.entry(GOTSpawnList.WILDING_MILITARY, 10);
		container2[1] = GOTBiomeSpawnList.entry(GOTSpawnList.WILDING_GIANT, 1);
		npcSpawnList.newFactionList(0).add(container2);

        SpawnListContainer[] containerLSR = new SpawnListContainer[1];
        containerLSR[0] = GOTBiomeSpawnList.entry(GOTSpawnList.UNRELIABLE, 10).setSpawnChance(500);
        this.npcSpawnList.newFactionList(5).add(containerLSR);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		int k1;
		int i1;
		super.decorate(world, random, i, k);
		if (random.nextInt(8) == 0) {
			for (int l = 0; l < 4; ++l) {
				i1 = i + random.nextInt(16) + 8;
				k1 = k + random.nextInt(16) + 8;
				boulderGen.generate(world, random, i1, world.getHeightValue(i1, k1), k1);
			}
		}
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_NORTH_WILD;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.WESTEROS.getSubregion("northWild");
	}

	@Override
	public Region getBiomeWaypoints() {
		return Region.NORTH;
	}

	@Override
	public GOTBezierType getRoadBlock() {
		return GOTBezierType.WESTEROS_PATH;
	}
}
