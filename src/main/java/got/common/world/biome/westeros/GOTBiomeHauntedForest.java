package got.common.world.biome.westeros;

import java.util.Random;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.*;
import got.common.entity.animal.*;
import got.common.world.biome.GOTBiome;
import got.common.world.biome.variant.GOTBiomeVariant;
import got.common.world.feature.*;
import got.common.world.map.*;
import got.common.world.map.GOTWaypoint.Region;
import got.common.world.spawning.*;
import got.common.world.spawning.GOTBiomeSpawnList.SpawnListContainer;
import got.common.world.structure.westeros.legendary.*;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class GOTBiomeHauntedForest extends GOTBiome {
	public GOTBiomeHauntedForest(int i, boolean major) {
		super(i, major);
		topBlock = Blocks.grass;
		fillerBlock = Blocks.snow;
		spawnableCreatureList.clear();
		spawnableWaterCreatureList.clear();
		spawnableCaveCreatureList.clear();
		spawnableGOTAmbientList.clear();
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityDirewolf.class, 8, 2, 2));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityWoolyRhino.class, 8, 2, 2));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityDeer.class, 8, 2, 2));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityMammoth.class, 8, 1, 1));
		this.addBiomeVariant(GOTBiomeVariant.FOREST_WEIRWOOD, 0.2f);
		SpawnListContainer[] container0 = new SpawnListContainer[2];
		container0[0] = GOTBiomeSpawnList.entry(GOTSpawnList.WILDING_GIANT, 1).setSpawnChance(500);
		container0[1] = GOTBiomeSpawnList.entry(GOTSpawnList.WILDING_MILITARY, 10).setSpawnChance(500);
		npcSpawnList.newFactionList(100).add(container0);

		SpawnListContainer[] container2 = new SpawnListContainer[1];
		container2[0] = GOTBiomeSpawnList.entry(GOTSpawnList.WALKERS_MILITARY, 1).setSpawnChance(200);
		npcSpawnList.newFactionList(100).add(container2);

		SpawnListContainer[] container3 = new SpawnListContainer[1];
		container3[0] = GOTBiomeSpawnList.entry(GOTSpawnList.WALKERS_CONQUEST, 10);
		npcSpawnList.newFactionList(0).add(container3);

		SpawnListContainer[] container5 = new SpawnListContainer[1];
		container5[0] = GOTBiomeSpawnList.entry(GOTSpawnList.DRAGONSTONE_CONQUEST, 10);
		npcSpawnList.newFactionList(0).add(container5);

		SpawnListContainer[] container6 = new SpawnListContainer[1];
		container6[0] = GOTBiomeSpawnList.entry(GOTSpawnList.GIFT_GUARDIAN, 10);
		npcSpawnList.newFactionList(0).add(container6);

        SpawnListContainer[] containerLSR = new SpawnListContainer[1];
        containerLSR[0] = GOTBiomeSpawnList.entry(GOTSpawnList.UNRELIABLE, 10).setSpawnChance(500);
        this.npcSpawnList.newFactionList(5).add(containerLSR);

		clearBiomeVariants();
		decorator.clearTrees();
		decorator.treesPerChunk = 10;
		decorator.addTree(GOTTreeType.PINE, 20);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (GOTStructureCrasterKeep.generatesAt(world, i, k)) {
			new GOTStructureCrasterKeep(false).generateWithSetRotation(world, random, i - 10, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
		if (GOTStructureCrasterBarn.generatesAt(world, i, k)) {
			new GOTStructureCrasterBarn(false).generateWithSetRotation(world, random, i + 10, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
		if (GOTSpawner.BenjenStark.generatesAt(world, i, k)) {
			new GOTSpawner.BenjenStark(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
		if (GOTFixedStructures.generatesAtMapImageCoords(i, k, GOTWaypoint.WhiteWood)) {
			((GOTWorldGenPartyTrees) GOTTreeType.WEIRWOOD.create(false, random)).disableRestrictions().generate(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k);
		}
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_HAUNTED_FOREST;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.WESTEROS.getSubregion("hauntedForest");
	}

	@Override
	public Region getBiomeWaypoints() {
		return Region.ICE;
	}

	@Override
	public boolean getEnableRiver() {
		return false;
	}

	@Override
	public GOTBezierType getRoadBlock() {
		return GOTBezierType.WESTEROS_PATH;
	}
}