package got.common.world.biome.westeros;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.GOTAchievement;
import got.common.entity.animal.*;
import got.common.world.feature.GOTTreeType;
import got.common.world.map.GOTBezierType;
import got.common.world.map.GOTWaypoint.Region;
import net.minecraft.world.biome.BiomeGenBase;

public class GOTBiomeWhisperingWood extends GOTBiomeWesteros {
	public GOTBiomeWhisperingWood(int i, boolean major) {
		super(i, major);
		decorator.clearTrees();
		decorator.addTree(GOTTreeType.FIR, 1000);
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityWildBoar.class, 10, 2, 6));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityDeer.class, 20, 4, 6));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityBear.class, 10, 1, 4));
		clearBiomeVariants();
		decorator.treesPerChunk = 10;
		decorator.flowersPerChunk = 4;
		decorator.doubleFlowersPerChunk = 2;
		decorator.grassPerChunk = 6;
		decorator.doubleGrassPerChunk = 1;
		registerForestFlowers();
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_WHISPERING_WOOD;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.WESTEROS.getSubregion("whisperingWood");
	}

	@Override
	public Region getBiomeWaypoints() {
		return Region.RIVERLANDS;
	}

	@Override
	public GOTBezierType getRoadBlock() {
		return GOTBezierType.WESTEROS_PATH;
	}
}
