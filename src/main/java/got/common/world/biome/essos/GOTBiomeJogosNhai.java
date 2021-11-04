package got.common.world.biome.essos;

import java.util.Random;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.*;
import got.common.entity.animal.*;
import got.common.world.biome.GOTBiome;
import got.common.world.map.*;
import got.common.world.map.GOTWaypoint.Region;
import got.common.world.spawning.*;
import got.common.world.spawning.GOTBiomeSpawnList.SpawnListContainer;
import got.common.world.structure.essos.jogos.GOTStructureJogosVillage;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class GOTBiomeJogosNhai extends GOTBiome {
	public GOTBiomeJogosNhai(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.clear();
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityLion.class, 4, 2, 4));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityLioness.class, 4, 2, 4));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityZebra.class, 8, 4, 8));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityGemsbok.class, 8, 4, 8));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityCamel.class, 6, 4, 4));

		spawnableGOTAmbientList.clear();
		spawnableGOTAmbientList.add(new BiomeGenBase.SpawnListEntry(GOTEntityButterfly.class, 5, 4, 4));
		spawnableGOTAmbientList.add(new BiomeGenBase.SpawnListEntry(GOTEntityBird.class, 8, 4, 4));
		spawnableGOTAmbientList.add(new BiomeGenBase.SpawnListEntry(GOTEntityDikDik.class, 8, 4, 6));

		SpawnListContainer[] container1 = new SpawnListContainer[2];
		container1[0] = GOTBiomeSpawnList.entry(GOTSpawnList.YITI_MILITARY, 10);
		container1[1] = GOTBiomeSpawnList.entry(GOTSpawnList.YITI_SAMURAI, 4);
		npcSpawnList.newFactionList(0).add(container1);

		decorator.grassPerChunk = 256;

		decorator.clearTrees();

		invasionSpawns.addInvasion(GOTInvasions.YI_TI, GOTEventSpawner.EventChance.COMMON);

		GOTStructureJogosVillage camp = new GOTStructureJogosVillage(this, 0.5f);
		camp.affix(GOTWaypoint.Kitra);
		decorator.addVillage(camp);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (GOTSpawner.KitraJuvain.generatesAt(world, i, k)) {
			new GOTSpawner.KitraJuvain(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_JOGOS;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.ESSOS.getSubregion("jogosNhai");
	}

	@Override
	public Region getBiomeWaypoints() {
		return Region.JOGOS;
	}

	@Override
	public GOTBezierType getRoadBlock() {
		return GOTBezierType.WESTEROS_PATH;
	}
}