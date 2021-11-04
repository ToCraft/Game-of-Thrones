package got.common.world.biome.westeros;

import java.util.Random;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.GOTAchievement;
import got.common.entity.animal.GOTEntitySnowBear;
import got.common.world.biome.GOTBiome;
import got.common.world.map.GOTBezierType;
import got.common.world.map.GOTWaypoint.Region;
import got.common.world.structure.westeros.legendary.*;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class GOTBiomeFarNorthSnowy extends GOTBiome {
	public GOTBiomeFarNorthSnowy(int i, boolean major) {
		super(i, major);
		clearBiomeVariants();
		topBlock = Blocks.snow;
		fillerBlock = Blocks.snow;
		spawnableCreatureList.clear();
		spawnableWaterCreatureList.clear();
		spawnableCaveCreatureList.clear();
		spawnableGOTAmbientList.clear();
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntitySnowBear.class, 8, 1, 1));
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (GOTStructureHardhome.generatesAt(world, i, k)) {
			new GOTStructureHardhome(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
		if (GOTStructureNightKing.generatesAt(world, i, k)) {
			new GOTStructureNightKing(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_FAR_NORTH;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.WESTEROS.getSubregion("farNorthSnowy");
	}

	@Override
	public Region getBiomeWaypoints() {
		return Region.ICE;
	}

	@Override
	public boolean getEnableRiver() {
		return false;
	}

	@Override
	public GOTBezierType getRoadBlock() {
		return GOTBezierType.WESTEROS_PATH;
	}
}