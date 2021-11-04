package got.common.world.biome.westeros;

import java.util.Random;

import got.common.database.GOTSpawnList;
import got.common.world.map.GOTWaypoint;
import got.common.world.spawning.*;
import got.common.world.spawning.GOTBiomeSpawnList.SpawnListContainer;
import got.common.world.structure.westeros.stormlands.*;
import net.minecraft.world.World;

public class GOTBiomeStormlandsFlat extends GOTBiomeStormlands {
	public GOTBiomeStormlandsFlat(int i, boolean major) {
		super(i, major);
		clearBiomeVariants();
		decorator.clearVillages();
		decorator.treesPerChunk = -1;

		SpawnListContainer[] container0 = new SpawnListContainer[2];
		container0[0] = GOTBiomeSpawnList.entry(GOTSpawnList.STORMLANDS_CIVILIAN, 10).setSpawnChance(500);
		container0[1] = GOTBiomeSpawnList.entry(GOTSpawnList.STORMLANDS_MILITARY, 4).setSpawnChance(500);
		npcSpawnList.newFactionList(100).add(container0);

		SpawnListContainer[] container1 = new SpawnListContainer[1];
		container1[0] = GOTBiomeSpawnList.entry(GOTSpawnList.DRAGONSTONE_CONQUEST, 10);
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

		GOTWaypointStormlandsCastle castle = new GOTWaypointStormlandsCastle(this, 0.0f);
		castle.affix(GOTWaypoint.Nightsong, 0, 1);
		castle.affix(GOTWaypoint.Poddingfield);
		castle.affix(GOTWaypoint.HarvestHall);
		castle.affix(GOTWaypoint.Fawntown);
		castle.affix(GOTWaypoint.Blackhaven, -1, 0);
		castle.affix(GOTWaypoint.DeatsHear);
		castle.affix(GOTWaypoint.Stonehelm);
		castle.affix(GOTWaypoint.BlackHeart);
		castle.affix(GOTWaypoint.SeaworthCastle);
		castle.affix(GOTWaypoint.Amberly);
		castle.affix(GOTWaypoint.RainHouse);
		castle.affix(GOTWaypoint.Mistwood);
		castle.affix(GOTWaypoint.Greenstone);
		castle.affix(GOTWaypoint.TudburyHoll);
		castle.affix(GOTWaypoint.Bronzegate, 1, 0);
		castle.affix(GOTWaypoint.Felwood, 0, 1);
		castle.affix(GOTWaypoint.Grandview);
		castle.affix(GOTWaypoint.HaystackHall);
		castle.affix(GOTWaypoint.Gallowsgrey);
		castle.affix(GOTWaypoint.Parchments);
		castle.affix(GOTWaypoint.BroadArch);
		castle.affix(GOTWaypoint.EvenfallHall);
		castle.affix(GOTWaypoint.StormsEnd);
		decorator.addVillage(castle);

		GOTWaypointStormlandsTown town = new GOTWaypointStormlandsTown(this, 0.0f);
		town.affix(GOTWaypoint.WeepingTown);
		decorator.addVillage(town);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (GOTSpawner.EldonEstermont.generatesAt(world, i, k)) {
			new GOTSpawner.EldonEstermont(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
                if (GOTSpawner.GulianSwann.generatesAt(world, i, k)) {
			new GOTSpawner.GulianSwann(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
                if (GOTSpawner.SelwynTarth.generatesAt(world, i, k)) {
			new GOTSpawner.SelwynTarth(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
		if (GOTSpawner.StormsEnd.generatesAt(world, i, k)) {
			new GOTSpawner.StormsEnd(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
	}

	@Override
	public boolean getEnableRiver() {
		return false;
	}
}