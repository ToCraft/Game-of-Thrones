package got.common.world.biome.essos;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.*;
import got.common.world.biome.variant.GOTBiomeVariant;
import got.common.world.spawning.GOTEventSpawner;
import got.common.world.structure.essos.pentos.GOTStructurePentosCity;

public class GOTBiomePentos extends GOTBiomeFreeCities {
	public GOTBiomePentos(int i, boolean major) {
		super(i, major);
		this.addBiomeVariant(GOTBiomeVariant.FIELD_CORN, 0.2f);
		decorator.addVillage(new GOTStructurePentosCity(this, 1.0f));

		invasionSpawns.addInvasion(GOTInvasions.BRAAVOS, GOTEventSpawner.EventChance.COMMON);
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_PENTOS;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.ESSOS.getSubregion("pentos");
	}
}