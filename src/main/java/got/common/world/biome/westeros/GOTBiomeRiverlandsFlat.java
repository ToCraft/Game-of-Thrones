package got.common.world.biome.westeros;

import java.util.Random;

import got.common.database.GOTSpawnList;
import got.common.world.map.GOTWaypoint;
import got.common.world.spawning.*;
import got.common.world.spawning.GOTBiomeSpawnList.SpawnListContainer;
import got.common.world.structure.other.GOTStructureTower;
import got.common.world.structure.westeros.legendary.GOTStructureCrossroadsTavern;
import got.common.world.structure.westeros.riverlands.*;
import net.minecraft.world.World;

public class GOTBiomeRiverlandsFlat extends GOTBiomeRiverlands {
	public GOTBiomeRiverlandsFlat(int i, boolean major) {
		super(i, major);
		clearBiomeVariants();
		decorator.clearVillages();
		decorator.treesPerChunk = -1;

		SpawnListContainer[] container0 = new SpawnListContainer[2];
		container0[0] = GOTBiomeSpawnList.entry(GOTSpawnList.RIVERLANDS_CIVILIAN, 10).setSpawnChance(500);
		container0[1] = GOTBiomeSpawnList.entry(GOTSpawnList.RIVERLANDS_MILITARY, 4).setSpawnChance(500);
		npcSpawnList.newFactionList(100).add(container0);

		SpawnListContainer[] container1 = new SpawnListContainer[1];
		container1[0] = GOTBiomeSpawnList.entry(GOTSpawnList.IRONBORN_CONQUEST, 10);
		npcSpawnList.newFactionList(0).add(container1);

		SpawnListContainer[] container3 = new SpawnListContainer[1];
		container3[0] = GOTBiomeSpawnList.entry(GOTSpawnList.WESTERLANDS_CONQUEST, 10);
		npcSpawnList.newFactionList(0).add(container3);

		SpawnListContainer[] container5 = new SpawnListContainer[1];
		container5[0] = GOTBiomeSpawnList.entry(GOTSpawnList.WALKERS_CONQUEST, 10);
		npcSpawnList.newFactionList(0).add(container5);

        SpawnListContainer[] containerLSR = new SpawnListContainer[1];
        containerLSR[0] = GOTBiomeSpawnList.entry(GOTSpawnList.UNRELIABLE, 10).setSpawnChance(500);
        this.npcSpawnList.newFactionList(5).add(containerLSR);

		GOTWaypointRiverlandsVillage village = new GOTWaypointRiverlandsVillage(this, 0.0f);
		village.affix(GOTWaypoint.Sevenstreams);
		village.affix(GOTWaypoint.FairMarket);
		village.affix(GOTWaypoint.Harroway);
		village.affix(GOTWaypoint.Pennytree);
		decorator.addVillage(village);

		GOTWaypointRiverlandsCastle castle = new GOTWaypointRiverlandsCastle(this, 0.0f);
		castle.affix(GOTWaypoint.Seagard, 0, -1);
		castle.affix(GOTWaypoint.Darry, 1, 0);
		castle.affix(GOTWaypoint.AcornHall);
		castle.affix(GOTWaypoint.Atranta);
		castle.affix(GOTWaypoint.WayfarerRest);
		castle.affix(GOTWaypoint.RaventreeHall);
		castle.affix(GOTWaypoint.PinkmaidenCastle);
		castle.affix(GOTWaypoint.Riverrun, -1, 0);
		castle.affix(GOTWaypoint.StoneHedge, 0, 1);
		castle.affix(GOTWaypoint.Maidenpool, 1, 0);
		decorator.addVillage(castle);

		GOTWaypointRiverlandsTown town = new GOTWaypointRiverlandsTown(this, 0.0f);
		town.affix(GOTWaypoint.StoneySept);
		town.affix(GOTWaypoint.Maidenpool, -1, 0, 3);
		town.affix(GOTWaypoint.Saltpans);
		town.affix(GOTWaypoint.Seagard, 0, 1, 2);
		decorator.addVillage(town);

		GOTStructureTower tower = new GOTStructureTower(this, 0.0f);
		tower.affix(GOTWaypoint.TwinsRight, -2, 0, 3);
		tower.affix(GOTWaypoint.TwinsLeft, 1, 0, 1);
		decorator.addVillage(tower);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (GOTSpawner.Riverrun.generatesAt(world, i, k)) {
			new GOTSpawner.Riverrun(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
		if (GOTStructureCrossroadsTavern.generatesAt(world, i, k)) {
			new GOTStructureCrossroadsTavern(false).generateWithSetRotation(world, random, i - 10, world.getTopSolidOrLiquidBlock(i, k), k + 30, 0);
		}
		if (GOTSpawner.WalderFrey.generatesAt(world, i, k)) {
			new GOTSpawner.WalderFrey(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
		if (GOTSpawner.TytosBlackwood.generatesAt(world, i, k)) {
			new GOTSpawner.TytosBlackwood(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
		if (GOTSpawner.JonosBracken.generatesAt(world, i, k)) {
			new GOTSpawner.JonosBracken(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
        if (GOTSpawner.JasonMallister.generatesAt(world, i, k)) {
			new GOTSpawner.JasonMallister(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
        }
         if (GOTSpawner.ClementPiper.generatesAt(world, i, k)) {
			new GOTSpawner.ClementPiper(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
         if (GOTSpawner.WilliamMooton.generatesAt(world, i, k)) {
			new GOTSpawner.WilliamMooton(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
		if (GOTSpawner.TwinsLeft.generatesAt(world, i, k)) {
			new GOTSpawner.TwinsLeft(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
	}

	@Override
	public boolean getEnableRiver() {
		return false;
	}
}