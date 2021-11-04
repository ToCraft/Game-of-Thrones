package got.common.world.biome.westeros;

import java.util.Random;

import got.common.database.GOTSpawnList;
import got.common.world.map.GOTWaypoint;
import got.common.world.spawning.*;
import got.common.world.spawning.GOTBiomeSpawnList.SpawnListContainer;
import got.common.world.structure.westeros.arryn.*;
import net.minecraft.world.World;

public class GOTBiomeArrynFlat extends GOTBiomeArryn {
	public GOTBiomeArrynFlat(int i, boolean major) {
		super(i, major);
		clearBiomeVariants();
		decorator.clearVillages();
		decorator.treesPerChunk = -1;
		
        SpawnListContainer[] container0 = new SpawnListContainer[2];
        container0[0] = GOTBiomeSpawnList.entry(GOTSpawnList.ARRYN_CIVILIAN, 10).setSpawnChance(500);
        container0[1] = GOTBiomeSpawnList.entry(GOTSpawnList.ARRYN_MILITARY, 4).setSpawnChance(500);
        this.npcSpawnList.newFactionList(100).add(container0);
        
		SpawnListContainer[] container1 = new SpawnListContainer[1];
		container1[0] = GOTBiomeSpawnList.entry(GOTSpawnList.HILL_TRIBES_MILITARY, 10);
		npcSpawnList.newFactionList(0).add(container1);

		SpawnListContainer[] container2 = new SpawnListContainer[1];
		container2[0] = GOTBiomeSpawnList.entry(GOTSpawnList.WESTERLANDS_CONQUEST, 10);
		npcSpawnList.newFactionList(0).add(container2);

		SpawnListContainer[] container3 = new SpawnListContainer[1];
		container3[0] = GOTBiomeSpawnList.entry(GOTSpawnList.WALKERS_CONQUEST, 10);
		npcSpawnList.newFactionList(0).add(container3);

        SpawnListContainer[] containerLSR = new SpawnListContainer[1];
        containerLSR[0] = GOTBiomeSpawnList.entry(GOTSpawnList.UNRELIABLE, 10).setSpawnChance(500);
        this.npcSpawnList.newFactionList(5).add(containerLSR);
        
		GOTWaypointArrynCastle castle = new GOTWaypointArrynCastle(this, 0.0f);

		castle.affix(GOTWaypoint.Pebble);
		castle.affix(GOTWaypoint.ThePaps);
		castle.affix(GOTWaypoint.ColdwaterBurn);
		castle.affix(GOTWaypoint.Snakewood);
		castle.affix(GOTWaypoint.HeartsHome);
		castle.affix(GOTWaypoint.Strongsong);
		castle.affix(GOTWaypoint.LongbowHall);
		castle.affix(GOTWaypoint.OldAnchor);
		castle.affix(GOTWaypoint.Ninestars);
		castle.affix(GOTWaypoint.IronOak);
		castle.affix(GOTWaypoint.Runestone);
		castle.affix(GOTWaypoint.GreyGlen);
		castle.affix(GOTWaypoint.Redfort);
		castle.affix(GOTWaypoint.GateOfTheMoon, 0, 1);
		castle.affix(GOTWaypoint.WitchIsle, 0, 1);
		castle.affix(GOTWaypoint.Wickenden);
		decorator.addVillage(castle);

		GOTWaypointArrynTown town = new GOTWaypointArrynTown(this, 0.0f);
		town.affix(GOTWaypoint.Sisterton);
		town.affix(GOTWaypoint.Gulltown);
		decorator.addVillage(town);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (GOTSpawner.YohnRoyce.generatesAt(world, i, k)) {
			new GOTSpawner.YohnRoyce(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
		if (GOTSpawner.HarroldHardyng.generatesAt(world, i, k)) {
			new GOTSpawner.HarroldHardyng(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
		if (GOTSpawner.HortonRedfort.generatesAt(world, i, k)) {
			new GOTSpawner.HortonRedfort(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
		if (GOTSpawner.AnyaWaynwood.generatesAt(world, i, k)) {
        	new GOTSpawner.AnyaWaynwood(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
        }
        if (GOTSpawner.BenedarBelmore.generatesAt(world, i, k)) {
        	new GOTSpawner.BenedarBelmore(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
        }
        if (GOTSpawner.GilwoodHunter.generatesAt(world, i, k)) {
        	new GOTSpawner.GilwoodHunter(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
        }
        if (GOTSpawner.SymondTempleton.generatesAt(world, i, k)) {
        	new GOTSpawner.SymondTempleton(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
        }
		if (GOTSpawner.LynCorbray.generatesAt(world, i, k)) {
			new GOTSpawner.LynCorbray(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
		if (GOTSpawner.GeroldGrafton.generatesAt(world, i, k)) {
			new GOTSpawner.GeroldGrafton(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
		if (GOTSpawner.GateOfTheMoon.generatesAt(world, i, k)) {
			new GOTSpawner.GateOfTheMoon(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
	}

	@Override
	public boolean getEnableRiver() {
		return false;
	}
}