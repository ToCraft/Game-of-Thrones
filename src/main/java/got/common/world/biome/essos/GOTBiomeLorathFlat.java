package got.common.world.biome.essos;

import got.common.database.GOTSpawnList;
import got.common.world.map.GOTWaypoint;
import got.common.world.spawning.GOTBiomeSpawnList;
import got.common.world.spawning.GOTBiomeSpawnList.SpawnListContainer;
import got.common.world.structure.essos.lorath.GOTWaypointLorathTown;

public class GOTBiomeLorathFlat extends GOTBiomeLorath {
	public GOTBiomeLorathFlat(int i, boolean major) {
		super(i, major);
		clearBiomeVariants();
		decorator.clearVillages();
		decorator.treesPerChunk = -1;

		SpawnListContainer[] container0 = new SpawnListContainer[2];
		container0[0] = GOTBiomeSpawnList.entry(GOTSpawnList.LORATH_CIVILIAN, 10).setSpawnChance(500);
		container0[1] = GOTBiomeSpawnList.entry(GOTSpawnList.LORATH_MILITARY, 4).setSpawnChance(500);
		npcSpawnList.newFactionList(100).add(container0);

		SpawnListContainer[] container1 = new SpawnListContainer[1];
		container1[0] = GOTBiomeSpawnList.entry(GOTSpawnList.IBBEN_CONQUEST, 10);
		npcSpawnList.newFactionList(0).add(container1);

        SpawnListContainer[] containerLSR = new SpawnListContainer[1];
        containerLSR[0] = GOTBiomeSpawnList.entry(GOTSpawnList.UNRELIABLE, 10).setSpawnChance(500);
        this.npcSpawnList.newFactionList(5).add(containerLSR);

		GOTWaypointLorathTown town = new GOTWaypointLorathTown(this, 0.0f);
		town.affix(GOTWaypoint.Lorath);
		town.affix(GOTWaypoint.Morosh);
		decorator.addVillage(town);
	}

	@Override
	public boolean getEnableRiver() {
		return false;
	}
}