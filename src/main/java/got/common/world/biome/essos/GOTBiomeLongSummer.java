package got.common.world.biome.essos;

import java.util.Random;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.GOTAchievement;
import got.common.world.biome.GOTBiome;
import got.common.world.feature.GOTWorldGenBoulder;
import got.common.world.map.GOTBezierType;
import got.common.world.map.GOTWaypoint.Region;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class GOTBiomeLongSummer extends GOTBiome {
	public WorldGenerator boulderGen = new GOTWorldGenBoulder(Blocks.stone, 0, 1, 4);

	public GOTBiomeLongSummer(int i, boolean major) {
		super(i, major);
		decorator.clearTrees();
		decorator.treesPerChunk = -1;
		biomeColors.setFoggy(true);
		biomeColors.setFoliage(0x808080);
		biomeColors.setClouds(0x808080);
		biomeColors.setFog(0x808080);
		biomeColors.setWater(0x808080);
		biomeColors.setGrass(11373417);
		biomeColors.setSky(8878434);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (random.nextInt(200) == 0) {
			for (int l = 0; l < 3; ++l) {
				int i1 = i + random.nextInt(16) + 8;
				int k1 = k + random.nextInt(16) + 8;
				boulderGen.generate(world, random, i1, world.getHeightValue(i1, k1), k1);
			}
		}
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_LONG_SUMMER;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.ESSOS.getSubregion("longSummer");
	}

	@Override
	public Region getBiomeWaypoints() {
		return Region.VALYRIA;
	}

	@Override
	public GOTBezierType getRoadBlock() {
		return GOTBezierType.WESTEROS_PATH;
	}
}
