package got.common.world.biome.westeros;

import java.util.Random;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.GOTAchievement;
import got.common.entity.animal.*;
import got.common.world.biome.GOTBiome;
import got.common.world.biome.variant.GOTBiomeVariant;
import got.common.world.feature.GOTTreeType;
import got.common.world.map.*;
import got.common.world.map.GOTWaypoint.Region;
import got.common.world.spawning.GOTSpawner;
import got.common.world.structure.westeros.legendary.GOTStructureVictarionCamp;
import got.common.world.structure.westeros.north.*;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class GOTBiomeNeck extends GOTBiome {
	public GOTBiomeNeck(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.clear();
		spawnableWaterCreatureList.clear();
		spawnableGOTAmbientList.clear();
		spawnableGOTAmbientList.add(new BiomeGenBase.SpawnListEntry(GOTEntityMidges.class, 10, 4, 4));
		spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(GOTEntityCrocodile.class, 10, 1, 1));
		spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(GOTEntitySwan.class, 5, 1, 2));

		addBiomeVariantSet(GOTBiomeVariant.SET_SWAMP);

		decorator.sandPerChunk = 0;
		decorator.quagmirePerChunk = 1;
		decorator.treesPerChunk = 0;
		decorator.logsPerChunk = 3;
		decorator.grassPerChunk = 8;
		decorator.doubleGrassPerChunk = 8;
		decorator.canePerChunk = 10;
		decorator.reedPerChunk = 5;

		decorator.clearTrees();
		decorator.addTree(GOTTreeType.WILLOW, 100);

		registerSwampFlowers();

		GOTWaypointNorthCastle castle = new GOTWaypointNorthCastle(this, 0.0f);
		castle.affix(GOTWaypoint.MoatKailin);
		decorator.addVillage(castle);

		GOTWaypointNorthVillage village = new GOTWaypointNorthVillage(this, 0.0f);
		village.affix(GOTWaypoint.GreywaterWatch);
		decorator.addVillage(village);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (GOTSpawner.GreywaterWatch.generatesAt(world, i, k)) {
			new GOTSpawner.GreywaterWatch(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
		if (GOTStructureVictarionCamp.generatesAt(world, i, k)) {
			new GOTStructureVictarionCamp(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_NECK;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.WESTEROS.getSubregion("neck");
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
