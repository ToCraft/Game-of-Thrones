package got.common.world.biome.westeros;

import java.util.Random;

import got.common.database.GOTSpawnList;
import got.common.world.map.GOTWaypoint;
import got.common.world.spawning.*;
import got.common.world.spawning.GOTBiomeSpawnList.SpawnListContainer;
import got.common.world.structure.westeros.westerlands.*;
import net.minecraft.world.World;

public class GOTBiomeWesterlandsFlat extends GOTBiomeWesterlands {
	public GOTBiomeWesterlandsFlat(int i, boolean major) {
		super(i, major);
		clearBiomeVariants();
		decorator.clearVillages();
		decorator.treesPerChunk = -1;

		SpawnListContainer[] container0 = new SpawnListContainer[2];
		container0[0] = GOTBiomeSpawnList.entry(GOTSpawnList.WESTERLANDS_CIVILIAN, 10).setSpawnChance(500);
		container0[1] = GOTBiomeSpawnList.entry(GOTSpawnList.WESTERLANDS_MILITARY, 4).setSpawnChance(500);
		npcSpawnList.newFactionList(100).add(container0);

		SpawnListContainer[] container1 = new SpawnListContainer[1];
		container1[0] = GOTBiomeSpawnList.entry(GOTSpawnList.NORTH_CONQUEST, 10);
		npcSpawnList.newFactionList(0).add(container1);

		SpawnListContainer[] container2 = new SpawnListContainer[1];
		container2[0] = GOTBiomeSpawnList.entry(GOTSpawnList.DRAGONSTONE_CONQUEST, 10);
		npcSpawnList.newFactionList(0).add(container2);

		SpawnListContainer[] container3 = new SpawnListContainer[1];
		container3[0] = GOTBiomeSpawnList.entry(GOTSpawnList.STORMLANDS_CONQUEST, 10);
		npcSpawnList.newFactionList(0).add(container3);

		SpawnListContainer[] container4 = new SpawnListContainer[1];
		container4[0] = GOTBiomeSpawnList.entry(GOTSpawnList.RIVERLANDS_CONQUEST, 10);
		npcSpawnList.newFactionList(0).add(container4);

		SpawnListContainer[] container5 = new SpawnListContainer[1];
		container5[0] = GOTBiomeSpawnList.entry(GOTSpawnList.WALKERS_CONQUEST, 10);
		npcSpawnList.newFactionList(0).add(container5);

        SpawnListContainer[] containerLSR = new SpawnListContainer[1];
        containerLSR[0] = GOTBiomeSpawnList.entry(GOTSpawnList.UNRELIABLE, 10).setSpawnChance(500);
        this.npcSpawnList.newFactionList(5).add(containerLSR);

		GOTWaypointWesterlandsVillage village = new GOTWaypointWesterlandsVillage(this, 0.0f);
		village.affix(GOTWaypoint.Oxcross);
		decorator.addVillage(village);

		GOTWaypointWesterlandsCastle castle = new GOTWaypointWesterlandsCastle(this, 0.0f);
		castle.affix(GOTWaypoint.Wyndhall);
		castle.affix(GOTWaypoint.Banefort);
		castle.affix(GOTWaypoint.Plumwood);
		castle.affix(GOTWaypoint.Crag);
		castle.affix(GOTWaypoint.Ashemark);
		castle.affix(GOTWaypoint.GoldenTooth, 0, 1);
		castle.affix(GOTWaypoint.Sarsfield, 0, -1);
		castle.affix(GOTWaypoint.Hornvale);
		castle.affix(GOTWaypoint.DeepDen);
		castle.affix(GOTWaypoint.Riverspring);
		castle.affix(GOTWaypoint.Silverhill);
		castle.affix(GOTWaypoint.Greenfield);
		castle.affix(GOTWaypoint.Cornfield);
		castle.affix(GOTWaypoint.Crakehall, -1, 0);
		castle.affix(GOTWaypoint.Faircastle);
		castle.affix(GOTWaypoint.Feastfires);
		castle.affix(GOTWaypoint.Kayce, 1, 0);
		castle.affix(GOTWaypoint.CleganesKeep);
		castle.affix(GOTWaypoint.CasterlyRock, -1, 0);
		decorator.addVillage(castle);

		GOTWaypointWesterlandsTown town = new GOTWaypointWesterlandsTown(this, 0.0f);
		town.affix(GOTWaypoint.Kayce, 3);
		town.affix(GOTWaypoint.Lannisport, -1, 0, 3);
		decorator.addVillage(town);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (GOTSpawner.GregorClegane.generatesAt(world, i, k)) {
			new GOTSpawner.GregorClegane(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
		if (GOTSpawner.AddamMarbrand.generatesAt(world, i, k)) {
			new GOTSpawner.AddamMarbrand(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
		if (GOTSpawner.ForleyPrester.generatesAt(world, i, k)) {
			new GOTSpawner.ForleyPrester(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
		if (GOTSpawner.HarysSwyft.generatesAt(world, i, k)) {
			new GOTSpawner.HarysSwyft(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
		if (GOTSpawner.LeoLefford.generatesAt(world, i, k)) {
			new GOTSpawner.LeoLefford(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
		if (GOTSpawner.LyleCrakehall.generatesAt(world, i, k)) {
			new GOTSpawner.LyleCrakehall(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
		if (GOTSpawner.QuentenBanefort.generatesAt(world, i, k)) {
			new GOTSpawner.QuentenBanefort(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
		if (GOTSpawner.SebastonFarman.generatesAt(world, i, k)) {
			new GOTSpawner.SebastonFarman(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
		if (GOTSpawner.CasterlyRock.generatesAt(world, i, k)) {
			new GOTSpawner.CasterlyRock(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
		if (GOTSpawner.Lannisport.generatesAt(world, i, k)) {
			new GOTSpawner.Lannisport(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
		if (GOTSpawner.TytosBrax.generatesAt(world, i, k)) {
			new GOTSpawner.TytosBrax(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
	}

	@Override
	public boolean getEnableRiver() {
		return false;
	}
}