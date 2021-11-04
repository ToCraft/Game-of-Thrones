package got.common.world.biome.essos;

import got.common.database.GOTSpawnList;
import got.common.world.map.GOTWaypoint;
import got.common.world.spawning.GOTBiomeSpawnList;
import got.common.world.spawning.GOTBiomeSpawnList.SpawnListContainer;
import got.common.world.structure.essos.qohor.GOTWaypointQohorTown;

public class GOTBiomeQohorFlat extends GOTBiomeQohor {
	public GOTBiomeQohorFlat(int i, boolean major) {
		super(i, major);
		clearBiomeVariants();
		decorator.clearVillages();
		decorator.treesPerChunk = -1;

		SpawnListContainer[] container0 = new SpawnListContainer[2];
		container0[0] = GOTBiomeSpawnList.entry(GOTSpawnList.QOHOR_CIVILIAN, 10).setSpawnChance(500);
		container0[1] = GOTBiomeSpawnList.entry(GOTSpawnList.QOHOR_MILITARY, 4).setSpawnChance(500);
		npcSpawnList.newFactionList(100).add(container0);

        SpawnListContainer[] containerLSR = new SpawnListContainer[1];
        containerLSR[0] = GOTBiomeSpawnList.entry(GOTSpawnList.UNRELIABLE, 10).setSpawnChance(500);
        this.npcSpawnList.newFactionList(5).add(containerLSR);

		GOTWaypointQohorTown town = new GOTWaypointQohorTown(this, 0.0f);
		town.affix(GOTWaypoint.Qohor, 0, -1, 2);
		decorator.addVillage(town);
	}

	@Override
	public boolean getEnableRiver() {
		return false;
	}
}