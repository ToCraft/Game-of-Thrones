package got.common.world.biome.westeros;

import java.util.Random;

import got.common.database.GOTSpawnList;
import got.common.world.feature.*;
import got.common.world.map.*;
import got.common.world.spawning.*;
import got.common.world.spawning.GOTBiomeSpawnList.SpawnListContainer;
import got.common.world.structure.westeros.north.*;
import net.minecraft.world.World;

public class GOTBiomeNorthFlat extends GOTBiomeNorth {
	public GOTBiomeNorthFlat(int i, boolean major) {
		super(i, major);
		clearBiomeVariants();
		decorator.clearVillages();
		decorator.treesPerChunk = -1;

		SpawnListContainer[] container0 = new SpawnListContainer[2];
		container0[0] = GOTBiomeSpawnList.entry(GOTSpawnList.NORTH_CIVILIAN, 10).setSpawnChance(500);
		container0[1] = GOTBiomeSpawnList.entry(GOTSpawnList.NORTH_MILITARY, 4).setSpawnChance(500);
		npcSpawnList.newFactionList(100).add(container0);

		SpawnListContainer[] container1 = new SpawnListContainer[1];
		container1[0] = GOTBiomeSpawnList.entry(GOTSpawnList.WESTERLANDS_CONQUEST, 10);
		npcSpawnList.newFactionList(0).add(container1);

		SpawnListContainer[] container2 = new SpawnListContainer[1];
		container2[0] = GOTBiomeSpawnList.entry(GOTSpawnList.IRONBORN_CONQUEST, 10);
		npcSpawnList.newFactionList(0).add(container2);

		SpawnListContainer[] container3 = new SpawnListContainer[1];
		container3[0] = GOTBiomeSpawnList.entry(GOTSpawnList.WALKERS_CONQUEST, 10);
		npcSpawnList.newFactionList(0).add(container3);

		SpawnListContainer[] container4 = new SpawnListContainer[2];
		container4[0] = GOTBiomeSpawnList.entry(GOTSpawnList.WILDING_MILITARY, 10);
		container4[1] = GOTBiomeSpawnList.entry(GOTSpawnList.WILDING_GIANT, 1);
		npcSpawnList.newFactionList(0).add(container4);

        SpawnListContainer[] containerLSR = new SpawnListContainer[1];
        containerLSR[0] = GOTBiomeSpawnList.entry(GOTSpawnList.UNRELIABLE, 10).setSpawnChance(500);
        this.npcSpawnList.newFactionList(5).add(containerLSR);

		GOTWaypointNorthCastle castle = new GOTWaypointNorthCastle(this, 0.0f);
		castle.affix(GOTWaypoint.MormontsKeep);
		castle.affix(GOTWaypoint.DeepwoodMotte);
		castle.affix(GOTWaypoint.Karhold);
		castle.affix(GOTWaypoint.Winterfell, 1);
		castle.affix(GOTWaypoint.LastHearth);
		castle.affix(GOTWaypoint.Dreadfort);
		castle.affix(GOTWaypoint.DeepwoodMotte);
		castle.affix(GOTWaypoint.Hornwood);
		castle.affix(GOTWaypoint.BlackPool);
		castle.affix(GOTWaypoint.RamsGate);
		castle.affix(GOTWaypoint.WidowsWatch);
		castle.affix(GOTWaypoint.OldCastle);
		castle.affix(GOTWaypoint.ServinsCastle, -1, 0);
		castle.affix(GOTWaypoint.Ironrath);
		castle.affix(GOTWaypoint.Highpoint);
		castle.affix(GOTWaypoint.TorhensSquare);
		castle.affix(GOTWaypoint.RisvellsCastle, 0, 1);
		castle.affix(GOTWaypoint.RillwaterCrossing);
		castle.affix(GOTWaypoint.FlintsFinger);
		decorator.addVillage(castle);

		GOTWaypointNorthTown town = new GOTWaypointNorthTown(this, 0.0f);
		town.affix(GOTWaypoint.WhiteHarbour, 1);
		decorator.addVillage(town);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (GOTSpawner.Winterfell.generatesAt(world, i, k)) {
			new GOTSpawner.Winterfell(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
		if (GOTSpawner.Dreadfort.generatesAt(world, i, k)) {
			new GOTSpawner.Dreadfort(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
		if (GOTSpawner.RickardKarstark.generatesAt(world, i, k)) {
			new GOTSpawner.RickardKarstark(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
		if (GOTSpawner.JohnUmber.generatesAt(world, i, k)) {
			new GOTSpawner.JohnUmber(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
                if (GOTSpawner.HelmanTallhart.generatesAt(world, i, k)) {
			new GOTSpawner.HelmanTallhart(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
		if (GOTSpawner.WymanManderly.generatesAt(world, i, k)) {
			new GOTSpawner.WymanManderly(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
		if (GOTFixedStructures.generatesAtMapImageCoords(i, k, GOTWaypoint.Winterfell)) {
			((GOTWorldGenPartyTrees) GOTTreeType.WEIRWOOD.create(false, random)).disableRestrictions().generate(world, random, i + 50, world.getTopSolidOrLiquidBlock(i + 50, k), k);
		}
		if (GOTSpawner.MaegeMormont.generatesAt(world, i, k)) {
			new GOTSpawner.MaegeMormont(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
                if (GOTSpawner.CleyCerwyn.generatesAt(world, i, k)) {
			new GOTSpawner.CleyCerwyn(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
                if (GOTSpawner.RodrikRyswell.generatesAt(world, i, k)) {
			new GOTSpawner.RodrikRyswell(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
	}

	@Override
	public boolean getEnableRiver() {
		return false;
	}
}