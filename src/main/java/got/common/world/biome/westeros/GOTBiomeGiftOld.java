package got.common.world.biome.westeros;

import java.util.Random;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.*;
import got.common.world.map.*;
import got.common.world.map.GOTWaypoint.Region;
import got.common.world.spawning.*;
import got.common.world.spawning.GOTBiomeSpawnList.SpawnListContainer;
import got.common.world.structure.westeros.gift.GOTStructureGiftVillage;
import got.common.world.structure.westeros.legendary.*;
import net.minecraft.world.World;

public class GOTBiomeGiftOld extends GOTBiomeWesteros {
	public GOTBiomeGiftOld(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.clear();
		spawnableWaterCreatureList.clear();
		spawnableCaveCreatureList.clear();
		spawnableGOTAmbientList.clear();
		clearBiomeVariants();
		SpawnListContainer[] container0 = new SpawnListContainer[1];
		container0[0] = GOTBiomeSpawnList.entry(GOTSpawnList.GIFT_GUARDIAN, 10).setSpawnChance(500);
		npcSpawnList.newFactionList(100).add(container0);

		SpawnListContainer[] container3 = new SpawnListContainer[1];
		container3[0] = GOTBiomeSpawnList.entry(GOTSpawnList.WALKERS_CONQUEST, 10);
		npcSpawnList.newFactionList(0).add(container3);

		SpawnListContainer[] container2 = new SpawnListContainer[2];
		container2[0] = GOTBiomeSpawnList.entry(GOTSpawnList.WILDING_MILITARY, 10);
		container2[1] = GOTBiomeSpawnList.entry(GOTSpawnList.WILDING_GIANT, 1);
		npcSpawnList.newFactionList(0).add(container2);

        SpawnListContainer[] containerLSR = new SpawnListContainer[1];
        containerLSR[0] = GOTBiomeSpawnList.entry(GOTSpawnList.UNRELIABLE, 10).setSpawnChance(500);
        this.npcSpawnList.newFactionList(5).add(containerLSR);

		GOTStructureGiftVillage village = new GOTStructureGiftVillage(this, 0.0f);
		village.affix(GOTWaypoint.Muletown);
		decorator.addVillage(village);
		invasionSpawns.addInvasion(GOTInvasions.THENN, GOTEventSpawner.EventChance.COMMON);
		invasionSpawns.addInvasion(GOTInvasions.WILDLING, GOTEventSpawner.EventChance.COMMON);
		invasionSpawns.addInvasion(GOTInvasions.GIANT, GOTEventSpawner.EventChance.RARE);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (GOTStructureCastleBlack.generatesAt(world, i, k)) {
			new GOTStructureCastleBlack(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k - 50, 0);
		}
		if (GOTStructureEastWatch.generatesAt(world, i, k)) {
			new GOTStructureEastWatch(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k + 30, 0);
		}
		if (GOTStructureShadowTower.generatesAt(world, i, k)) {
			new GOTStructureShadowTower(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k + 30, 0);
		}
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_GIFT_OLD;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.WESTEROS.getSubregion("giftOld");
	}

	@Override
	public Region getBiomeWaypoints() {
		return Region.NORTH;
	}

	@Override
	public GOTBezierType getRoadBlock() {
		return GOTBezierType.WESTEROS_PATH;
	}
}
