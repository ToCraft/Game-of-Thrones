package got.common.world.biome.essos;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.GOTAchievement;
import got.common.world.biome.variant.GOTBiomeVariant;
import got.common.world.structure.essos.qohor.GOTStructureQohorCity;

public class GOTBiomeQohor extends GOTBiomeFreeCities {
	public GOTBiomeQohor(int i, boolean major) {
		super(i, major);
		this.addBiomeVariant(GOTBiomeVariant.FIELD_CORN, 0.2f);
		decorator.addVillage(new GOTStructureQohorCity(this, 1.0f));
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_QOHOR;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.ESSOS.getSubregion("qohor");
	}

}
