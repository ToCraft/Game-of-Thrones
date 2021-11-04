package got.common.world.biome.westeros;

import got.common.database.GOTInvasions;
import got.common.database.GOTSpawnList;
import got.common.world.map.GOTWaypoint;
import got.common.world.spawning.GOTBiomeSpawnList;
import got.common.world.spawning.GOTEventSpawner;
import got.common.world.spawning.GOTBiomeSpawnList.SpawnListContainer;
import got.common.world.structure.westeros.targaryen.*;
import got.common.world.structure.westeros.targaryen.red.GOTStructureRedCastle;
import got.common.world.structure.westeros.legendary.GOTStructureKingsLandingTargaryen;

public class GOTBiomeTargaryenFlat extends GOTBiomeTargaryen {
	public GOTBiomeTargaryenFlat(int i, boolean major) {
		super(i, major);
		clearBiomeVariants();
		decorator.clearVillages();
		decorator.treesPerChunk = -1;

		SpawnListContainer[] container0 = new SpawnListContainer[2];
		container0[0] = GOTBiomeSpawnList.entry(GOTSpawnList.TARGARYEN_CIVILIAN, 10).setSpawnChance(500);
		container0[1] = GOTBiomeSpawnList.entry(GOTSpawnList.TARGARYEN_MILITARY, 4).setSpawnChance(500);
		npcSpawnList.newFactionList(67, 0.0f).add(container0);

		invasionSpawns.addInvasion(GOTInvasions.NORTH, GOTEventSpawner.EventChance.COMMON);
		invasionSpawns.addInvasion(GOTInvasions.RIVERLANDS, GOTEventSpawner.EventChance.COMMON);
		invasionSpawns.addInvasion(GOTInvasions.WESTERLANDS, GOTEventSpawner.EventChance.COMMON);
		invasionSpawns.addInvasion(GOTInvasions.STORMLANDS, GOTEventSpawner.EventChance.COMMON);
		invasionSpawns.addInvasion(GOTInvasions.IRONBORN, GOTEventSpawner.EventChance.COMMON);
		invasionSpawns.addInvasion(GOTInvasions.REACH, GOTEventSpawner.EventChance.COMMON);

        SpawnListContainer[] containerLSR = new SpawnListContainer[1];
        containerLSR[0] = GOTBiomeSpawnList.entry(GOTSpawnList.UNRELIABLE, 10).setSpawnChance(500);
        this.npcSpawnList.newFactionList(5).add(containerLSR);

		GOTWaypointTargaryenVillage village = new GOTWaypointTargaryenVillage(this, 0.0f);
		village.affix(GOTWaypoint.Briarwhite);
		decorator.addVillage(village);

		GOTWaypointTargaryenCastle castle = new GOTWaypointTargaryenCastle(this, 0.0f);
		castle.affix(GOTWaypoint.Antlers);
		castle.affix(GOTWaypoint.Stokeworth);
		castle.affix(GOTWaypoint.DyreDen);
		castle.affix(GOTWaypoint.Brownhollow);
		castle.affix(GOTWaypoint.RooksRest, 0, -1);
		castle.affix(GOTWaypoint.Rosby, 0, -1);
		castle.affix(GOTWaypoint.Hayford, -1, 0);
		
		castle.affix(GOTWaypoint.Dragonstone);
		castle.affix(GOTWaypoint.HighTide);
		castle.affix(GOTWaypoint.Driftmark);
		castle.affix(GOTWaypoint.SharpPoint);
		castle.affix(GOTWaypoint.Stonedance);
		castle.affix(GOTWaypoint.SweetportSound);
		castle.affix(GOTWaypoint.ClawIsle);
		decorator.addVillage(castle);

		GOTWaypointTargaryenTown town = new GOTWaypointTargaryenTown(this, 0.0f);
		town.affix(GOTWaypoint.Duskendale, -2, 0, 3);
		decorator.addVillage(town);

		GOTStructureKingsLandingTargaryen kl = new GOTStructureKingsLandingTargaryen(this, 0.0f);
		kl.affix(GOTWaypoint.KingsLanding, 1, 0, 3);
		decorator.addVillage(kl);

		GOTStructureRedCastle rc = new GOTStructureRedCastle(this, 0.0f);
		rc.affix(GOTWaypoint.KingsLanding, 2, 0, 1);
		decorator.addVillage(rc);
	}

	@Override
	public boolean getEnableRiver() {
		return false;
	}
}