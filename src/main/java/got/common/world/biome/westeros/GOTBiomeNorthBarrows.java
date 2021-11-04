package got.common.world.biome.westeros;

import java.util.Random;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.GOTAchievement;
import got.common.world.biome.variant.GOTBiomeVariant;
import got.common.world.map.*;
import got.common.world.map.GOTWaypoint.Region;
import got.common.world.spawning.GOTSpawner;
import got.common.world.structure.other.GOTStructureBarrow;
import got.common.world.structure.westeros.north.*;
import net.minecraft.world.World;

public class GOTBiomeNorthBarrows extends GOTBiomeNorth {
	public GOTBiomeNorthBarrows(int i, boolean major) {
		super(i, major);
		clearBiomeVariants();
		this.addBiomeVariant(GOTBiomeVariant.DENSEFOREST_BIRCH);
		this.addBiomeVariant(GOTBiomeVariant.DENSEFOREST_OAK);
		this.addBiomeVariant(GOTBiomeVariant.FLOWERS);
		this.addBiomeVariant(GOTBiomeVariant.FOREST);
		this.addBiomeVariant(GOTBiomeVariant.FOREST_ASPEN, 0.2f);
		this.addBiomeVariant(GOTBiomeVariant.FOREST_BEECH, 0.2f);
		this.addBiomeVariant(GOTBiomeVariant.FOREST_BIRCH, 0.2f);
		this.addBiomeVariant(GOTBiomeVariant.FOREST_LIGHT);
		this.addBiomeVariant(GOTBiomeVariant.FOREST_MAPLE, 0.2f);
		this.addBiomeVariant(GOTBiomeVariant.HILLS);
		this.addBiomeVariant(GOTBiomeVariant.HILLS_FOREST);
		this.addBiomeVariant(GOTBiomeVariant.HILLS_SCRUBLAND, 1.0f);
		this.addBiomeVariant(GOTBiomeVariant.SCRUBLAND, 1.0f);
		this.addBiomeVariant(GOTBiomeVariant.STEPPE);
		decorator.addRandomStructure(new GOTStructureBarrow(false), 20);

		GOTWaypointNorthCastle castle = new GOTWaypointNorthCastle(this, 0.0f);
		castle.affix(GOTWaypoint.Goldgrass, 0, 1);
		decorator.addVillage(castle);

		GOTWaypointNorthTown town = new GOTWaypointNorthTown(this, 0.0f);
		town.affix(GOTWaypoint.Barrowtown, 0, 1, 2);
		decorator.addVillage(town);
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_NORTH_BARROWS;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.WESTEROS.getSubregion("northBarrows");
	}

    public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (GOTSpawner.BarbreyDustin.generatesAt(world, i, k)) {
			new GOTSpawner.BarbreyDustin(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
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
