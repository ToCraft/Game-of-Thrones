package got.common.world.biome.westeros;

import java.util.Random;

import got.common.entity.animal.*;
import got.common.world.map.GOTWaypoint.Region;
import got.common.world.spawning.GOTSpawner;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class GOTBiomeRiverlandsForest extends GOTBiomeRiverlands {
	public GOTBiomeRiverlandsForest(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityBear.class, 10, 1, 4));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityDeer.class, 8, 2, 2));
		clearBiomeVariants();
		decorator.treesPerChunk = 10;
		decorator.flowersPerChunk = 4;
		decorator.doubleFlowersPerChunk = 1;
		decorator.grassPerChunk = 10;
		decorator.doubleGrassPerChunk = 4;
		registerForestFlowers();
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (GOTSpawner.BericDondarrion.generatesAt(world, i, k)) {
			new GOTSpawner.BericDondarrion(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
	}

	@Override
	public Region getBiomeWaypoints() {
		return Region.RIVERLANDS;
	}
}
