package got.common.world.biome.essos;

import java.util.Random;

import got.common.database.GOTSpawnList;
import got.common.world.map.GOTWaypoint;
import got.common.world.spawning.*;
import got.common.world.spawning.GOTBiomeSpawnList.SpawnListContainer;
import got.common.world.structure.essos.volantis.GOTWaypointVolantisTown;
import net.minecraft.world.World;

public class GOTBiomeVolantisFlat extends GOTBiomeVolantis {
	public GOTBiomeVolantisFlat(int i, boolean major) {
		super(i, major);
		clearBiomeVariants();
		decorator.clearVillages();
		decorator.treesPerChunk = -1;

		SpawnListContainer[] container0 = new SpawnListContainer[2];
		container0[0] = GOTBiomeSpawnList.entry(GOTSpawnList.VOLANTIS_CIVILIAN, 10).setSpawnChance(500);
		container0[1] = GOTBiomeSpawnList.entry(GOTSpawnList.VOLANTIS_MILITARY, 4).setSpawnChance(500);
		npcSpawnList.newFactionList(100).add(container0);

		SpawnListContainer[] container1 = new SpawnListContainer[1];
		container1[0] = GOTBiomeSpawnList.entry(GOTSpawnList.BRAAVOS_MILITARY, 10);
		npcSpawnList.newFactionList(0).add(container1);

		SpawnListContainer[] container2 = new SpawnListContainer[1];
		container2[0] = GOTBiomeSpawnList.entry(GOTSpawnList.MYR_MILITARY, 10);
		npcSpawnList.newFactionList(0).add(container2);

		SpawnListContainer[] container3 = new SpawnListContainer[1];
		container3[0] = GOTBiomeSpawnList.entry(GOTSpawnList.LYS_MILITARY, 10);
		npcSpawnList.newFactionList(0).add(container3);

		SpawnListContainer[] container4 = new SpawnListContainer[1];
		container4[0] = GOTBiomeSpawnList.entry(GOTSpawnList.TYROSH_MILITARY, 10);
		npcSpawnList.newFactionList(0).add(container4);

		SpawnListContainer[] container5 = new SpawnListContainer[1];
		container5[0] = GOTBiomeSpawnList.entry(GOTSpawnList.NORVOS_MILITARY, 10);
		npcSpawnList.newFactionList(0).add(container5);

        SpawnListContainer[] containerLSR = new SpawnListContainer[1];
        containerLSR[0] = GOTBiomeSpawnList.entry(GOTSpawnList.UNRELIABLE, 10).setSpawnChance(500);
        this.npcSpawnList.newFactionList(5).add(containerLSR);

		GOTWaypointVolantisTown town = new GOTWaypointVolantisTown(this, 0.0f);
		town.affix(GOTWaypoint.Mantarys, 0, -1, 2);
		town.affix(GOTWaypoint.LittleValyria, 0, 1);
		town.affix(GOTWaypoint.Volantis, -1, 0, 1);
		town.affix(GOTWaypoint.VolonTherys, 0, 1);
		town.affix(GOTWaypoint.Valysar, -1, 0, 1);
		town.affix(GOTWaypoint.Selhorys, -1, 0, 1);
		town.affix(GOTWaypoint.Elyria);
		town.affix(GOTWaypoint.Tolos);
		decorator.addVillage(town);
	}
	
	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (GOTSpawner.Moqorro.generatesAt(world, i, k)) {
			new GOTSpawner.Moqorro(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
	}

	@Override
	public boolean getEnableRiver() {
		return false;
	}
}