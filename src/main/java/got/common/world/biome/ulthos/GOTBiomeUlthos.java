package got.common.world.biome.ulthos;

import java.util.Random;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.*;
import got.common.entity.animal.*;
import got.common.world.biome.GOTBiome;
import got.common.world.feature.GOTTreeType;
import got.common.world.map.GOTWaypoint;
import got.common.world.map.GOTWaypoint.Region;
import got.common.world.spawning.*;
import got.common.world.spawning.GOTBiomeSpawnList.SpawnListContainer;
import got.common.world.structure.other.GOTStructureRuinsBig;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class GOTBiomeUlthos extends GOTBiome {
	public GOTBiomeUlthos(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.clear();
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityDeer.class, 8, 2, 2));

		spawnableGOTAmbientList.clear();
		spawnableGOTAmbientList.add(new BiomeGenBase.SpawnListEntry(GOTEntityButterfly.class, 10, 4, 4));
		spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(GOTEntityGorcrow.class, 5, 1, 2));

		SpawnListContainer[] container = new SpawnListContainer[1];
		container[0] = GOTBiomeSpawnList.entry(GOTSpawnList.ULTHOS, 10);
		npcSpawnList.newFactionList(100).add(container);

		registerForestFlowers();

		decorator.treesPerChunk = 8;
		decorator.grassPerChunk = 12;
		decorator.doubleGrassPerChunk = 6;

		decorator.addTree(GOTTreeType.ULTHOS_OAK_LARGE, 1000);
		decorator.addTree(GOTTreeType.OAK_LARGE, 300);
		decorator.addTree(GOTTreeType.SPRUCE, 200);
		decorator.addTree(GOTTreeType.FIR, 200);
		decorator.addTree(GOTTreeType.PINE, 400);

		GOTStructureRuinsBig colossal = new GOTStructureRuinsBig(this, 0.0f);
		colossal.affix(GOTWaypoint.Ulos);
		decorator.addVillage(colossal);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (GOTSpawner.Hummel009.generatesAt(world, i, k)) {
			new GOTSpawner.Hummel009(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_ULTHOS;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.ULTHOS.getSubregion("ulthos");
	}

	@Override
	public Region getBiomeWaypoints() {
		return Region.ULTHOS;
	}
}
