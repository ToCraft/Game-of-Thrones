package got.common.world.biome.essos;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.GOTSpawnList;
import got.common.world.map.GOTWaypoint;
import got.common.world.spawning.GOTBiomeSpawnList;
import got.common.world.spawning.GOTBiomeSpawnList.SpawnListContainer;
import got.common.world.structure.essos.ghiscar.*;
import got.common.world.structure.essos.legendary.GOTStructurePyramidMeereen;

public class GOTBiomeMeereen extends GOTBiomeGhiscar {
	public GOTBiomeMeereen(int i, boolean major) {
		super(i, major);
		clearBiomeVariants();
		decorator.clearVillages();
		decorator.treesPerChunk = -1;

		SpawnListContainer[] container0 = new SpawnListContainer[3];
		container0[0] = GOTBiomeSpawnList.entry(GOTSpawnList.GHISCAR_CIVILIAN, 10).setSpawnChance(500);
		container0[1] = GOTBiomeSpawnList.entry(GOTSpawnList.GHISCAR_HARPY, 4).setSpawnChance(500);
		container0[2] = GOTBiomeSpawnList.entry(GOTSpawnList.GHISCAR_MILITARY, 4).setSpawnChance(500);
		npcSpawnList.newFactionList(100).add(container0);

        SpawnListContainer[] containerLSR = new SpawnListContainer[1];
        containerLSR[0] = GOTBiomeSpawnList.entry(GOTSpawnList.UNRELIABLE, 10).setSpawnChance(500);
        this.npcSpawnList.newFactionList(5).add(containerLSR);

		GOTWaypointGhiscarTown town = new GOTWaypointGhiscarTown(this, 0.0f);
		town.affix(GOTWaypoint.Meereen, 0, -1, 2);
		decorator.addVillage(town);

		GOTStructurePyramidMeereen pyramid = new GOTStructurePyramidMeereen(this, 0.0f);
		pyramid.affix(GOTWaypoint.Meereen, 0, -2, 0);
		decorator.addVillage(pyramid);

		decorator.addRandomStructure(new GOTStructureGhiscarFightingPit(false), 50);
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.ESSOS.getSubregion("meereen");
	}
}