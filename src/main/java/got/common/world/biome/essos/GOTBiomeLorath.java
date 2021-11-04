package got.common.world.biome.essos;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.*;
import got.common.world.spawning.GOTEventSpawner;
import got.common.world.structure.essos.lorath.GOTStructureLorathCity;

public class GOTBiomeLorath extends GOTBiomeFreeCities {
	public GOTBiomeLorath(int i, boolean major) {
		super(i, major);
		decorator.addVillage(new GOTStructureLorathCity(this, 1.0f));
		invasionSpawns.addInvasion(GOTInvasions.IBBEN, GOTEventSpawner.EventChance.COMMON);
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_LORATH;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.ESSOS.getSubregion("lorath");
	}

}
