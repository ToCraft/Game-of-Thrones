package got.common.world.biome.essos;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.*;
import got.common.world.biome.variant.GOTBiomeVariant;
import got.common.world.spawning.GOTEventSpawner;
import got.common.world.structure.essos.braavos.GOTStructureBraavosCity;

public class GOTBiomeBraavos extends GOTBiomeFreeCities {
	public GOTBiomeBraavos(int i, boolean major) {
		super(i, major);
		this.addBiomeVariant(GOTBiomeVariant.FIELD_CORN, 0.2f);
		decorator.addVillage(new GOTStructureBraavosCity(this, 1.0f));
		invasionSpawns.addInvasion(GOTInvasions.VOLANTIS, GOTEventSpawner.EventChance.COMMON);
		invasionSpawns.addInvasion(GOTInvasions.PENTOS, GOTEventSpawner.EventChance.COMMON);
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_BRAAVOS;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.ESSOS.getSubregion("braavos");
	}

}
