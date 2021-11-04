package got.common.world.biome.westeros;

import java.util.Random;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.*;
import got.common.world.feature.GOTWorldGenBoulder;
import got.common.world.map.*;
import got.common.world.map.GOTWaypoint.Region;
import got.common.world.spawning.GOTSpawner;
import got.common.world.structure.other.GOTStructureRuins;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class GOTBiomeIronborn extends GOTBiomeWesteros {
	public WorldGenerator boulderGen = new GOTWorldGenBoulder(GOTRegistry.rock, 1, 1, 4);

	public GOTBiomeIronborn(int i, boolean major) {
		super(i, major);

		GOTStructureRuins ruinsGen = new GOTStructureRuins(this, 0.0f);
		ruinsGen.affix(GOTWaypoint.GreyironCastle);
		ruinsGen.affix(GOTWaypoint.HoareKeep);
		ruinsGen.affix(GOTWaypoint.HoareCastle);
		decorator.addVillage(ruinsGen);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (random.nextInt(32) == 0) {
			for (int l = 0; l < 3; ++l) {
				int i1 = i + random.nextInt(16) + 8;
				int k1 = k + random.nextInt(16) + 8;
				boulderGen.generate(world, random, i1, world.getHeightValue(i1, k1), k1);
			}
		}
		if (GOTSpawner.AeronGreyjoy.generatesAt(world, i, k)) {
			new GOTSpawner.AeronGreyjoy(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_IRONBORN;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.WESTEROS.getSubregion("ironborn");
	}

	@Override
	public Region getBiomeWaypoints() {
		return Region.IRONBORN;
	}

	@Override
	public GOTBezierType getRoadBlock() {
		return GOTBezierType.WESTEROS_PATH;
	}
}
