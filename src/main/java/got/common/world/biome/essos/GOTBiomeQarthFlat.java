package got.common.world.biome.essos;

import java.util.Random;

import got.common.database.GOTSpawnList;
import got.common.world.map.GOTWaypoint;
import got.common.world.spawning.*;
import got.common.world.spawning.GOTBiomeSpawnList.SpawnListContainer;
import got.common.world.structure.essos.qarth.GOTWaypointQarthTown;
import net.minecraft.world.World;

public class GOTBiomeQarthFlat extends GOTBiomeQarth {
	public GOTBiomeQarthFlat(int i, boolean major) {
		super(i, major);
		clearBiomeVariants();
		decorator.clearVillages();
		decorator.treesPerChunk = -1;

		SpawnListContainer[] container0 = new SpawnListContainer[2];
		container0[0] = GOTBiomeSpawnList.entry(GOTSpawnList.QARTH_CIVILIAN, 10).setSpawnChance(500);
		container0[1] = GOTBiomeSpawnList.entry(GOTSpawnList.QARTH_MILITARY, 4).setSpawnChance(500);
		npcSpawnList.newFactionList(100).add(container0);

        SpawnListContainer[] containerLSR = new SpawnListContainer[1];
        containerLSR[0] = GOTBiomeSpawnList.entry(GOTSpawnList.UNRELIABLE, 10).setSpawnChance(500);
        this.npcSpawnList.newFactionList(5).add(containerLSR);

		GOTWaypointQarthTown town = new GOTWaypointQarthTown(this, 0.0f);
		town.affix(GOTWaypoint.Qarth, 0, 1);
		town.affix(GOTWaypoint.PortYhos, 0, 1);
		town.affix(GOTWaypoint.Qarkash, 0, 0);
		decorator.addVillage(town);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (GOTSpawner.XaroXhoanDaxos.generatesAt(world, i, k)) {
			new GOTSpawner.XaroXhoanDaxos(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
	}

	@Override
	public boolean getEnableRiver() {
		return false;
	}
}