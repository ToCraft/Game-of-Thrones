package got.common.world.biome.westeros;

import java.util.Random;

import got.common.database.GOTSpawnList;
import got.common.world.map.GOTWaypoint;
import got.common.world.spawning.*;
import got.common.world.spawning.GOTBiomeSpawnList.SpawnListContainer;
import got.common.world.structure.westeros.dorne.*;
import net.minecraft.world.World;

public class GOTBiomeDorneFlat extends GOTBiomeDorne {
	public GOTBiomeDorneFlat(int i, boolean major) {
		super(i, major);
		clearBiomeVariants();
		decorator.clearVillages();
		decorator.treesPerChunk = -1;

		SpawnListContainer[] container0 = new SpawnListContainer[2];
		container0[0] = GOTBiomeSpawnList.entry(GOTSpawnList.DORNE_CIVILIAN, 10).setSpawnChance(500);
		container0[1] = GOTBiomeSpawnList.entry(GOTSpawnList.DORNE_MILITARY, 4).setSpawnChance(500);
		npcSpawnList.newFactionList(100).add(container0);

		SpawnListContainer[] container1 = new SpawnListContainer[1];
		container1[0] = GOTBiomeSpawnList.entry(GOTSpawnList.WESTERLANDS_CONQUEST, 10);
		npcSpawnList.newFactionList(0).add(container1);

		SpawnListContainer[] container3 = new SpawnListContainer[1];
		container3[0] = GOTBiomeSpawnList.entry(GOTSpawnList.WALKERS_CONQUEST, 10);
		npcSpawnList.newFactionList(0).add(container3);

        SpawnListContainer[] containerLSR = new SpawnListContainer[1];
        containerLSR[0] = GOTBiomeSpawnList.entry(GOTSpawnList.UNRELIABLE, 10).setSpawnChance(500);
        this.npcSpawnList.newFactionList(5).add(containerLSR);

		GOTWaypointDorneCastle castle = new GOTWaypointDorneCastle(this, 0.0f);
		castle.affix(GOTWaypoint.Starfall, 0, -1);
		castle.affix(GOTWaypoint.HighHermitage);
		castle.affix(GOTWaypoint.Blackmont);
		castle.affix(GOTWaypoint.Kingsgrave, -1, 0);
		castle.affix(GOTWaypoint.SkyReach, 0, 1);
		castle.affix(GOTWaypoint.Yronwood, 1, 0);
		castle.affix(GOTWaypoint.Wyl, 0, -1);
		castle.affix(GOTWaypoint.Vaith);
		castle.affix(GOTWaypoint.Saltshore);
		castle.affix(GOTWaypoint.Godsgrace);
		castle.affix(GOTWaypoint.Tor);
		castle.affix(GOTWaypoint.Hellholt);
		castle.affix(GOTWaypoint.GhostHill);
		castle.affix(GOTWaypoint.Spottswood);
		castle.affix(GOTWaypoint.WaterGardens);
		castle.affix(GOTWaypoint.Lemonwood);
		decorator.addVillage(castle);

		GOTWaypointDorneTown town = new GOTWaypointDorneTown(this, 0.0f);
		town.affix(GOTWaypoint.GhastonGrey);
		town.affix(GOTWaypoint.Sunspear);
		town.affix(GOTWaypoint.PlankyTown);
		decorator.addVillage(town);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (GOTSpawner.Sunspear.generatesAt(world, i, k)) {
			new GOTSpawner.Sunspear(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
		if (GOTSpawner.GeroldDayne.generatesAt(world, i, k)) {
			new GOTSpawner.GeroldDayne(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
		if (GOTSpawner.BericDayne.generatesAt(world, i, k)) {
			new GOTSpawner.BericDayne(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
		if (GOTSpawner.AndersYronwood.generatesAt(world, i, k)) {
			new GOTSpawner.AndersYronwood(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
		if (GOTSpawner.QuentynMartell.generatesAt(world, i, k)) {
			new GOTSpawner.QuentynMartell(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
		if (GOTSpawner.FranklynFowler.generatesAt(world, i, k)) {
        	new GOTSpawner.FranklynFowler(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
        }
        if (GOTSpawner.HarmenUller.generatesAt(world, i, k)) {
			new GOTSpawner.HarmenUller(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
	}

	@Override
	public boolean getEnableRiver() {
		return false;
	}
}