package got.common.world.biome.essos;

import java.util.Random;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.GOTSpawnList;
import got.common.world.map.GOTWaypoint;
import got.common.world.spawning.*;
import got.common.world.spawning.GOTBiomeSpawnList.SpawnListContainer;
import got.common.world.structure.essos.ghiscar.*;
import got.common.world.structure.essos.legendary.GOTStructurePyramidYunkaiAstapor;
import net.minecraft.world.World;

public class GOTBiomeAstapor extends GOTBiomeGhiscar {
	public GOTBiomeAstapor(int i, boolean major) {
		super(i, major);
		clearBiomeVariants();
		decorator.clearVillages();
		decorator.treesPerChunk = -1;

		SpawnListContainer[] container0 = new SpawnListContainer[3];
		container0[0] = GOTBiomeSpawnList.entry(GOTSpawnList.GHISCAR_CIVILIAN, 10).setSpawnChance(500);
		container0[1] = GOTBiomeSpawnList.entry(GOTSpawnList.GHISCAR_UNSULLIED, 4).setSpawnChance(500);
		container0[2] = GOTBiomeSpawnList.entry(GOTSpawnList.GHISCAR_MILITARY, 4).setSpawnChance(500);
		npcSpawnList.newFactionList(100).add(container0);

        SpawnListContainer[] containerLSR = new SpawnListContainer[1];
        containerLSR[0] = GOTBiomeSpawnList.entry(GOTSpawnList.UNRELIABLE, 10).setSpawnChance(500);
        this.npcSpawnList.newFactionList(5).add(containerLSR);

		GOTWaypointGhiscarTown town = new GOTWaypointGhiscarTown(this, 0.0f);
		town.affix(GOTWaypoint.Astapor, -1, 0, 1);
		decorator.addVillage(town);

		GOTStructurePyramidYunkaiAstapor pyramid = new GOTStructurePyramidYunkaiAstapor(this, 0.0f);
		pyramid.affix(GOTWaypoint.Astapor, -2, 0);
		decorator.addVillage(pyramid);

		decorator.addRandomStructure(new GOTStructureGhiscarFightingPit(false), 50);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (GOTSpawner.Astapor.generatesAt(world, i, k)) {
			new GOTSpawner.Astapor(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.ESSOS.getSubregion("astapor");
	}
}