package got.common.world.biome.essos;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.*;
import got.common.entity.animal.GOTEntityElephant;
import got.common.world.biome.variant.GOTBiomeVariant;
import got.common.world.spawning.GOTEventSpawner;
import got.common.world.structure.essos.volantis.GOTStructureVolantisCity;
import net.minecraft.world.biome.BiomeGenBase;

public class GOTBiomeVolantis extends GOTBiomeFreeCities {
	public GOTBiomeVolantis(int i, boolean major) {
		super(i, major);
		this.addBiomeVariant(GOTBiomeVariant.FIELD_CORN, 0.2f);
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityElephant.class, 8, 1, 1));

		decorator.addVillage(new GOTStructureVolantisCity(this, 1.0f));

		invasionSpawns.addInvasion(GOTInvasions.BRAAVOS, GOTEventSpawner.EventChance.COMMON);
		invasionSpawns.addInvasion(GOTInvasions.TYROSH, GOTEventSpawner.EventChance.COMMON);
		invasionSpawns.addInvasion(GOTInvasions.LYS, GOTEventSpawner.EventChance.COMMON);
		invasionSpawns.addInvasion(GOTInvasions.MYR, GOTEventSpawner.EventChance.COMMON);
		invasionSpawns.addInvasion(GOTInvasions.NORVOS, GOTEventSpawner.EventChance.COMMON);
		invasionSpawns.addInvasion(GOTInvasions.DOTHRAKI, GOTEventSpawner.EventChance.COMMON);
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_VOLANTIS;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.ESSOS.getSubregion("volantis");
	}
}