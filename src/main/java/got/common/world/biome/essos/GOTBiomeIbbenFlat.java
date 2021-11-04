package got.common.world.biome.essos;

import got.common.database.GOTSpawnList;
import got.common.world.map.GOTWaypoint;
import got.common.world.spawning.GOTBiomeSpawnList;
import got.common.world.spawning.GOTBiomeSpawnList.SpawnListContainer;
import got.common.world.structure.essos.ibben.GOTStructureIbbenVillage;

public class GOTBiomeIbbenFlat extends GOTBiomeIbben {
	public GOTBiomeIbbenFlat(int i, boolean major) {
		super(i, major);
		clearBiomeVariants();
		decorator.clearVillages();
		decorator.treesPerChunk = -1;

		SpawnListContainer[] container0 = new SpawnListContainer[2];
		container0[0] = GOTBiomeSpawnList.entry(GOTSpawnList.IBBEN_CIVILIAN, 10).setSpawnChance(500);
		container0[1] = GOTBiomeSpawnList.entry(GOTSpawnList.IBBEN_CONQUEST, 4).setSpawnChance(500);
		npcSpawnList.newFactionList(100).add(container0);

		SpawnListContainer[] container2 = new SpawnListContainer[1];
		container2[0] = GOTBiomeSpawnList.entry(GOTSpawnList.IRONBORN_CONQUEST, 10);
		npcSpawnList.newFactionList(0).add(container2);

        SpawnListContainer[] containerLSR = new SpawnListContainer[1];
        containerLSR[0] = GOTBiomeSpawnList.entry(GOTSpawnList.UNRELIABLE, 10).setSpawnChance(500);
        this.npcSpawnList.newFactionList(5).add(containerLSR);

		GOTStructureIbbenVillage village = new GOTStructureIbbenVillage(this, 0.0f);
		village.affix(GOTWaypoint.IbNor);
		village.affix(GOTWaypoint.PortOfIbben);
		village.affix(GOTWaypoint.IbSar);
		decorator.addVillage(village);
	}

	@Override
	public boolean getEnableRiver() {
		return false;
	}
}