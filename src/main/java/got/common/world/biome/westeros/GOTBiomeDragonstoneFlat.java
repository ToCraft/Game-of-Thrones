package got.common.world.biome.westeros;

import java.util.Random;

import got.common.database.GOTSpawnList;
import got.common.world.map.GOTWaypoint;
import got.common.world.spawning.*;
import got.common.world.spawning.GOTBiomeSpawnList.SpawnListContainer;
import got.common.world.structure.westeros.dragonstone.*;
import net.minecraft.world.World;

public class GOTBiomeDragonstoneFlat extends GOTBiomeDragonstone {
	public GOTBiomeDragonstoneFlat(int i, boolean major) {
		super(i, major);
		clearBiomeVariants();
		decorator.clearVillages();
		decorator.treesPerChunk = -1;

		SpawnListContainer[] container0 = new SpawnListContainer[2];
		container0[0] = GOTBiomeSpawnList.entry(GOTSpawnList.DRAGONSTONE_CIVILIAN, 10).setSpawnChance(500);
		container0[1] = GOTBiomeSpawnList.entry(GOTSpawnList.DRAGONSTONE_MILITARY, 4).setSpawnChance(500);
		npcSpawnList.newFactionList(100).add(container0);

		SpawnListContainer[] container1 = new SpawnListContainer[1];
		container1[0] = GOTBiomeSpawnList.entry(GOTSpawnList.WESTERLANDS_CONQUEST, 10);
		npcSpawnList.newFactionList(0).add(container1);

		SpawnListContainer[] container2 = new SpawnListContainer[1];
		container2[0] = GOTBiomeSpawnList.entry(GOTSpawnList.STORMLANDS_CONQUEST, 10);
		npcSpawnList.newFactionList(0).add(container2);

		SpawnListContainer[] container3 = new SpawnListContainer[1];
		container3[0] = GOTBiomeSpawnList.entry(GOTSpawnList.REACH_CONQUEST, 10);
		npcSpawnList.newFactionList(0).add(container3);

        SpawnListContainer[] containerLSR = new SpawnListContainer[1];
        containerLSR[0] = GOTBiomeSpawnList.entry(GOTSpawnList.UNRELIABLE, 10).setSpawnChance(500);
        this.npcSpawnList.newFactionList(5).add(containerLSR);

		GOTWaypointDragonstoneCastle castle = new GOTWaypointDragonstoneCastle(this, 0.0f);
		castle.affix(GOTWaypoint.Dragonstone);
		castle.affix(GOTWaypoint.HighTide);
		castle.affix(GOTWaypoint.Driftmark);
		castle.affix(GOTWaypoint.SharpPoint);
		castle.affix(GOTWaypoint.Stonedance);
		castle.affix(GOTWaypoint.SweetportSound);
		castle.affix(GOTWaypoint.ClawIsle);
		decorator.addVillage(castle);

		GOTWaypointDragonstoneTown town = new GOTWaypointDragonstoneTown(this, 0.0f);
		town.affix(GOTWaypoint.Hull);
		decorator.addVillage(town);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (GOTSpawner.Dragonstone.generatesAt(world, i, k)) {
			new GOTSpawner.Dragonstone(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
		if (GOTSpawner.Driftmark.generatesAt(world, i, k)) {
			new GOTSpawner.Driftmark(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
		if (GOTSpawner.ArdrianCeltigar.generatesAt(world, i, k)) {
			new GOTSpawner.ArdrianCeltigar(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
	}

	@Override
	public boolean getEnableRiver() {
		return false;
	}
}