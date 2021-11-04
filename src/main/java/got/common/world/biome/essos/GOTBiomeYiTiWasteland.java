package got.common.world.biome.essos;

import java.util.Random;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.*;
import got.common.world.biome.GOTBiome;
import got.common.world.map.*;
import got.common.world.map.GOTWaypoint.Region;
import got.common.world.spawning.GOTBiomeSpawnList;
import got.common.world.spawning.GOTBiomeSpawnList.SpawnListContainer;
import got.common.world.structure.essos.legendary.*;
import net.minecraft.world.World;

public class GOTBiomeYiTiWasteland extends GOTBiome {
	public GOTBiomeYiTiWasteland(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.clear();

		SpawnListContainer[] container = new SpawnListContainer[3];
		container[0] = GOTBiomeSpawnList.entry(GOTSpawnList.YITI_MILITARY, 4).setSpawnChance(500);
		container[1] = GOTBiomeSpawnList.entry(GOTSpawnList.YITI_SAMURAI, 2).setSpawnChance(500);
		container[2] = GOTBiomeSpawnList.entry(GOTSpawnList.YITI_BOMBARDIER, 1).setSpawnChance(500);
		npcSpawnList.newFactionList(100).add(container);

		SpawnListContainer[] container1 = new SpawnListContainer[1];
		container1[0] = GOTBiomeSpawnList.entry(GOTSpawnList.JOGOS_MILITARY, 10);
		npcSpawnList.newFactionList(0).add(container1);

		clearBiomeVariants();
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		new GOTStructureFiveFortsWall(false, GOTWaypoint.FiveForts1).generateWithSetRotation(world, random, i, 0, k, 0);
		new GOTStructureFiveFortsWall(false, GOTWaypoint.FiveForts2).generateWithSetRotation(world, random, i, 0, k, 0);
		new GOTStructureFiveFortsWall(false, GOTWaypoint.FiveForts3).generateWithSetRotation(world, random, i, 0, k, 0);
		new GOTStructureFiveFortsWall(false, GOTWaypoint.FiveForts4).generateWithSetRotation(world, random, i, 0, k, 0);
		new GOTStructureFiveFortsWall(false, GOTWaypoint.FiveForts5).generateWithSetRotation(world, random, i, 0, k, 0);

		if (GOTStructureFiveFortsTower.generatesAt1(world, i, k) || GOTStructureFiveFortsTower.generatesAt2(world, i, k) || GOTStructureFiveFortsTower.generatesAt3(world, i, k) || GOTStructureFiveFortsTower.generatesAt4(world, i, k) || GOTStructureFiveFortsTower.generatesAt5(world, i, k)) {
			new GOTStructureFiveFortsTower(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 2);
		}
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_YI_TI_WASTELAND;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.ESSOS.getSubregion("yiTiWasteland");
	}

	@Override
	public Region getBiomeWaypoints() {
		return Region.YITI;
	}

	@Override
	public GOTBezierType getRoadBlock() {
		return GOTBezierType.YITI;
	}
}