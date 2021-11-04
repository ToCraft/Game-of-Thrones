package got.common.world.biome.westeros;

import java.util.Random;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.*;
import got.common.world.feature.*;
import got.common.world.map.GOTWaypoint.Region;
import got.common.world.spawning.GOTBiomeSpawnList;
import got.common.world.spawning.GOTBiomeSpawnList.SpawnListContainer;
import got.common.world.structure.westeros.wildling.thenn.GOTStructureThennCamp;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class GOTBiomeThenn extends GOTBiomeWesteros {
	public GOTBiomeThenn(int i, boolean major) {
		super(i, major);
		clearBiomeVariants();
		topBlock = Blocks.grass;
		fillerBlock = Blocks.dirt;
		decorator.clearTrees();
		decorator.treesPerChunk = 1;
		decorator.addTree(GOTTreeType.PINE, 20);
		decorator.addRandomStructure(new GOTStructureThennCamp(false), 50);
		SpawnListContainer[] container0 = new SpawnListContainer[2];
		container0[0] = GOTBiomeSpawnList.entry(GOTSpawnList.WILDING_GIANT, 1).setSpawnChance(500);
		container0[1] = GOTBiomeSpawnList.entry(GOTSpawnList.WILDING_THENN, 10).setSpawnChance(500);
		npcSpawnList.newFactionList(100).add(container0);

		SpawnListContainer[] container3 = new SpawnListContainer[1];
		container3[0] = GOTBiomeSpawnList.entry(GOTSpawnList.WALKERS_CONQUEST, 10);
		npcSpawnList.newFactionList(0).add(container3);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		int i1;
		int k1;
		int i12;
		int j1;
		int l;
		super.decorate(world, random, i, k);
		GOTWorldGenStreams lavaGen = new GOTWorldGenStreams(Blocks.flowing_lava);
		for (l = 0; l < 250; ++l) {
			i12 = i + random.nextInt(16) + 8;
			j1 = 40 + random.nextInt(120);
			int k13 = k + random.nextInt(16) + 8;
			lavaGen.generate(world, random, i12, j1, k13);
		}
		if (random.nextInt(1) == 0) {
			i1 = i + random.nextInt(16) + 8;
			k1 = k + random.nextInt(16) + 8;
			j1 = world.getHeightValue(i1, k1);
			new GOTWorldGenVolcanoCrater().generate(world, random, i1, j1, k1);
		}
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_THENN;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.WESTEROS.getSubregion("thenn");
	}

	@Override
	public Region getBiomeWaypoints() {
		return Region.ICE;
	}

	@Override
	public boolean getEnableRiver() {
		return false;
	}
}