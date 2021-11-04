package got.common.world.biome.westeros;

import java.util.Random;

import got.common.database.*;
import got.common.world.biome.variant.GOTBiomeVariant;
import got.common.world.spawning.*;
import got.common.world.spawning.GOTBiomeSpawnList.SpawnListContainer;
import got.common.world.structure.westeros.hillmen.*;
import net.minecraft.block.Block;
import net.minecraft.world.World;

public class GOTBiomeArrynMountainsFoothills extends GOTBiomeArrynMountains {
	public GOTBiomeArrynMountainsFoothills(int i, boolean major) {
		super(i, major);
		clearBiomeVariants();
		addBiomeVariant(GOTBiomeVariant.FOREST_LARCH, 0.3f);
		addBiomeVariant(GOTBiomeVariant.FOREST_PINE, 0.3f);
		addBiomeVariant(GOTBiomeVariant.FOREST_ASPEN, 0.3f);
		SpawnListContainer[] container0 = new SpawnListContainer[2];
		container0[0] = GOTBiomeSpawnList.entry(GOTSpawnList.HILL_TRIBES_CIVILIAN, 10).setSpawnChance(500);
		container0[1] = GOTBiomeSpawnList.entry(GOTSpawnList.HILL_TRIBES_MILITARY, 4).setSpawnChance(500);
		npcSpawnList.newFactionList(100).add(container0);

		SpawnListContainer[] container1 = new SpawnListContainer[1];
		container1[0] = GOTBiomeSpawnList.entry(GOTSpawnList.ARRYN_MILITARY, 10);
		npcSpawnList.newFactionList(0).add(container1);

		SpawnListContainer[] container3 = new SpawnListContainer[1];
		container3[0] = GOTBiomeSpawnList.entry(GOTSpawnList.WALKERS_CONQUEST, 10);
		npcSpawnList.newFactionList(0).add(container3);

		decorator.addRandomStructure(new GOTStructureHillmanHouse(false), 25);
		decorator.addRandomStructure(new GOTStructureHillmanTavern(false), 100);
		decorator.addRandomStructure(new GOTStructureHillmanHillFort(false), 150);

		setBanditChance(GOTEventSpawner.EventChance.BANDIT_COMMON);

		invasionSpawns.addInvasion(GOTInvasions.ARRYN, GOTEventSpawner.EventChance.COMMON);
	}

	@Override
	public void generateMountainTerrain(World world, Random random, Block[] blocks, byte[] meta, int i, int k, int xzIndex, int ySize, int height, int rockDepth, GOTBiomeVariant variant) {
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_HILL_TRIBES;
	}
}
