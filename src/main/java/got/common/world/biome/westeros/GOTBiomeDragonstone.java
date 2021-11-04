package got.common.world.biome.westeros;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.*;
import got.common.world.map.GOTBezierType;
import got.common.world.map.GOTWaypoint.Region;
import got.common.world.spawning.GOTEventSpawner;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class GOTBiomeDragonstone extends GOTBiomeWesteros {
	public GOTBiomeDragonstone(int i, boolean major) {
		super(i, major);
		clearBiomeVariants();
		decorator.addSoil(new WorldGenMinable(GOTRegistry.obsidianGravel, 32), 20.0f, 0, 64);

		invasionSpawns.addInvasion(GOTInvasions.WESTERLANDS, GOTEventSpawner.EventChance.COMMON);
		invasionSpawns.addInvasion(GOTInvasions.STORMLANDS, GOTEventSpawner.EventChance.COMMON);
		invasionSpawns.addInvasion(GOTInvasions.REACH, GOTEventSpawner.EventChance.COMMON);
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_DRAGONSTONE;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.WESTEROS.getSubregion("dragonstone");
	}

	@Override
	public Region getBiomeWaypoints() {
		return Region.DRANGONSTONE;
	}

	@Override
	public GOTBezierType getRoadBlock() {
		return GOTBezierType.WESTEROS_PATH;
	}
}
