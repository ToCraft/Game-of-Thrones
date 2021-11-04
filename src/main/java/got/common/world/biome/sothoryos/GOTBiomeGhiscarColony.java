package got.common.world.biome.sothoryos;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.*;
import got.common.entity.animal.*;
import got.common.entity.other.GOTEntityEssosBandit;
import got.common.world.biome.GOTBiome;
import got.common.world.feature.GOTTreeType;
import got.common.world.map.*;
import got.common.world.map.GOTWaypoint.Region;
import got.common.world.spawning.*;
import got.common.world.spawning.GOTBiomeSpawnList.SpawnListContainer;
import got.common.world.structure.essos.ghiscar.GOTWaypointGhiscarColony;
import net.minecraft.world.biome.BiomeGenBase;

public class GOTBiomeGhiscarColony extends GOTBiome {
	public GOTBiomeGhiscarColony(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.clear();
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityFlamingo.class, 10, 4, 4));
		spawnableGOTAmbientList.clear();
		spawnableGOTAmbientList.add(new BiomeGenBase.SpawnListEntry(GOTEntityBird.class, 10, 4, 4));
		spawnableGOTAmbientList.add(new BiomeGenBase.SpawnListEntry(GOTEntityButterfly.class, 15, 4, 4));
		spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(GOTEntityCrocodile.class, 10, 4, 4));

		decorator.clearTrees();
		decorator.addTree(GOTTreeType.JUNGLE, 1000);
		decorator.addTree(GOTTreeType.JUNGLE_LARGE, 500);
		decorator.addTree(GOTTreeType.MAHOGANY, 500);
		decorator.addTree(GOTTreeType.JUNGLE_SHRUB, 1000);
		decorator.addTree(GOTTreeType.MANGO, 20);
		decorator.addTree(GOTTreeType.BANANA, 50);

		decorator.treesPerChunk = 1;
        
		SpawnListContainer[] container0 = new SpawnListContainer[1];
		container0[0] = GOTBiomeSpawnList.entry(GOTSpawnList.GHISCAR_CORSAIR, 10).setSpawnChance(500);
		npcSpawnList.newFactionList(100).add(container0);

        SpawnListContainer[] containerLSR = new SpawnListContainer[1];
        containerLSR[0] = GOTBiomeSpawnList.entry(GOTSpawnList.UNRELIABLE, 10).setSpawnChance(500);
        this.npcSpawnList.newFactionList(5).add(containerLSR);
		
		setBanditChance(GOTEventSpawner.EventChance.BANDIT_COMMON);
		setBanditEntityClass(GOTEntityEssosBandit.class);

		GOTWaypointGhiscarColony colony = new GOTWaypointGhiscarColony(this, 0.0f);
		colony.affix(GOTWaypoint.BarterBeach);
		colony.affix(GOTWaypoint.Gogossos);
		colony.affix(GOTWaypoint.Zamettar, 2);
		colony.affix(GOTWaypoint.Gorosh);
		decorator.addVillage(colony);
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_GHISCAR_COLONY;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.SOTHORYOS.getSubregion("ghiscarColony");
	}

	@Override
	public Region getBiomeWaypoints() {
		return Region.SOTHORYOS;
	}

	@Override
	public GOTBezierType getRoadBlock() {
		return GOTBezierType.SOTHORYOS;
	}
}