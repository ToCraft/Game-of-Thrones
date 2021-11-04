package got.common.world.biome.westeros;

import java.util.Random;

import got.common.database.GOTSpawnList;
import got.common.world.map.GOTWaypoint;
import got.common.world.spawning.*;
import got.common.world.spawning.GOTBiomeSpawnList.SpawnListContainer;
import got.common.world.structure.other.GOTStructureTower;
import got.common.world.structure.westeros.ironborn.*;
import net.minecraft.world.World;

public class GOTBiomeIronbornFlat extends GOTBiomeIronborn {
	public GOTBiomeIronbornFlat(int i, boolean major) {
		super(i, major);
		clearBiomeVariants();
		decorator.clearVillages();
		decorator.treesPerChunk = -1;

		SpawnListContainer[] container0 = new SpawnListContainer[2];
		container0[0] = GOTBiomeSpawnList.entry(GOTSpawnList.IRONBORN_CIVILIAN, 10).setSpawnChance(500);
		container0[1] = GOTBiomeSpawnList.entry(GOTSpawnList.IRONBORN_MILITARY, 4).setSpawnChance(500);
		npcSpawnList.newFactionList(100).add(container0);

		SpawnListContainer[] container1 = new SpawnListContainer[1];
		container1[0] = GOTBiomeSpawnList.entry(GOTSpawnList.NORTH_CONQUEST, 10);
		npcSpawnList.newFactionList(0).add(container1);

        SpawnListContainer[] containerLSR = new SpawnListContainer[1];
        containerLSR[0] = GOTBiomeSpawnList.entry(GOTSpawnList.UNRELIABLE, 10).setSpawnChance(500);
        this.npcSpawnList.newFactionList(5).add(containerLSR);

		GOTWaypointIronbornVillage village = new GOTWaypointIronbornVillage(this, 0.0f);
		village.affix(GOTWaypoint.Pebbleton);
		decorator.addVillage(village);

		GOTWaypointIronbornCastle castle = new GOTWaypointIronbornCastle(this, 0.0f);
		castle.affix(GOTWaypoint.Blacktyde);
		castle.affix(GOTWaypoint.Volmark);
		castle.affix(GOTWaypoint.LonelyLight);
		castle.affix(GOTWaypoint.CrowSpikeKeep);
		castle.affix(GOTWaypoint.Downdelving);
		castle.affix(GOTWaypoint.CorpseLake);
		castle.affix(GOTWaypoint.SparrCastle);
		castle.affix(GOTWaypoint.Sunderly);
		castle.affix(GOTWaypoint.Saltcliffe);
		castle.affix(GOTWaypoint.SealskinPoint);
		castle.affix(GOTWaypoint.Orkwood);
		castle.affix(GOTWaypoint.DrummCastle);
		castle.affix(GOTWaypoint.Stonehouse);
		castle.affix(GOTWaypoint.GreyGarden);
		castle.affix(GOTWaypoint.TenTowers);
		castle.affix(GOTWaypoint.HarlawHall);
		castle.affix(GOTWaypoint.HarridanHill);
		castle.affix(GOTWaypoint.StonetreeCastle);
		castle.affix(GOTWaypoint.IronHolt);
		castle.affix(GOTWaypoint.Pyke);
		castle.affix(GOTWaypoint.Blackhaven);
		castle.affix(GOTWaypoint.TawneyCastle);
		castle.affix(GOTWaypoint.Shatterstone);
		castle.affix(GOTWaypoint.MyreCastle);
		decorator.addVillage(castle);

		GOTStructureTower towerGen = new GOTStructureTower(this, 0.0f);
		towerGen.affix(GOTWaypoint.TowerOfGlimmering);
		decorator.addVillage(towerGen);

		GOTWaypointIronbornTown town = new GOTWaypointIronbornTown(this, 0.0f);
		town.affix(GOTWaypoint.Lordsport);
		town.affix(GOTWaypoint.RedHaven);
		decorator.addVillage(town);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (GOTSpawner.BalonGreyjoy.generatesAt(world, i, k)) {
			new GOTSpawner.BalonGreyjoy(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
		if (GOTSpawner.DunstanDrumm.generatesAt(world, i, k)) {
			new GOTSpawner.DunstanDrumm(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
                if (GOTSpawner.AndrikTheUnsmilling.generatesAt(world, i, k)) {
			new GOTSpawner.AndrikTheUnsmilling(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
                if (GOTSpawner.BaelorBlacktyde.generatesAt(world, i, k)) {
			new GOTSpawner.BaelorBlacktyde(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
                if (GOTSpawner.ErikIronmaker.generatesAt(world, i, k)) {
			new GOTSpawner.ErikIronmaker(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
                if (GOTSpawner.GylbertFarwynd.generatesAt(world, i, k)) {
			new GOTSpawner.GylbertFarwynd(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
                if (GOTSpawner.MaronVolmark.generatesAt(world, i, k)) {
			new GOTSpawner.MaronVolmark(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
		if (GOTSpawner.HarrasHarlaw.generatesAt(world, i, k)) {
			new GOTSpawner.HarrasHarlaw(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
		if (GOTSpawner.RodrikHarlaw.generatesAt(world, i, k)) {
			new GOTSpawner.RodrikHarlaw(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
		if (GOTSpawner.Dagmer.generatesAt(world, i, k)) {
			new GOTSpawner.Dagmer(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
	}

	@Override
	public boolean getEnableRiver() {
		return false;
	}
}