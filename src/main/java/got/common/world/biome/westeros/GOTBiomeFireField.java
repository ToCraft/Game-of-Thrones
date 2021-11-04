package got.common.world.biome.westeros;

import java.util.Random;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.*;
import got.common.world.map.*;
import got.common.world.spawning.*;
import got.common.world.spawning.GOTBiomeSpawnList.SpawnListContainer;
import got.common.world.structure.westeros.reach.GOTWaypointReachCastle;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.*;

public class GOTBiomeFireField extends GOTBiomeReach {
	public GOTBiomeFireField(int i, boolean major) {
		super(i, major);
		decorator.treesPerChunk = 0;
		decorator.flowersPerChunk = 20;
		decorator.doubleFlowersPerChunk = 12;
		decorator.grassPerChunk = 8;
		decorator.doubleGrassPerChunk = 3;
		registerPlainsFlowers();
		addFlower(Blocks.red_flower, 0, 80);
		decorator.clearVillages();
		npcSpawnList.clear();
		SpawnListContainer[] container0 = new SpawnListContainer[2];
		container0[0] = GOTBiomeSpawnList.entry(GOTSpawnList.REACH_CIVILIAN, 10).setSpawnChance(500);
		container0[1] = GOTBiomeSpawnList.entry(GOTSpawnList.REACH_MILITARY, 4).setSpawnChance(500);
		npcSpawnList.newFactionList(100).add(container0);

		SpawnListContainer[] container1 = new SpawnListContainer[1];
		container1[0] = GOTBiomeSpawnList.entry(GOTSpawnList.DRAGONSTONE_CONQUEST, 10);
		npcSpawnList.newFactionList(0).add(container1);

		SpawnListContainer[] container2 = new SpawnListContainer[1];
		container2[0] = GOTBiomeSpawnList.entry(GOTSpawnList.DORNE_CONQUEST, 10);
		npcSpawnList.newFactionList(0).add(container2);

		SpawnListContainer[] container3 = new SpawnListContainer[1];
		container3[0] = GOTBiomeSpawnList.entry(GOTSpawnList.WALKERS_CONQUEST, 10);
		npcSpawnList.newFactionList(0).add(container3);

		GOTWaypointReachCastle castle = new GOTWaypointReachCastle(this, 0.0f);
		castle.affix(GOTWaypoint.Highgarden, 0, -1);
		decorator.addVillage(castle);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (GOTSpawner.Highgarden.generatesAt(world, i, k)) {
			new GOTSpawner.Highgarden(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_FIRE_FIELD;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.WESTEROS.getSubregion("fireField");
	}

	@Override
	public WorldGenerator getRandomWorldGenForDoubleFlower(Random random) {
		if (random.nextInt(5) > 0) {
			WorldGenDoublePlant doubleFlowerGen = new WorldGenDoublePlant();
			doubleFlowerGen.func_150548_a(4);
			return doubleFlowerGen;
		}
		return super.getRandomWorldGenForDoubleFlower(random);
	}

	@Override
	public GOTBezierType getRoadBlock() {
		return GOTBezierType.WESTEROS;
	}
}