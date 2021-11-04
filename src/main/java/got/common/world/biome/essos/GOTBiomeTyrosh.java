package got.common.world.biome.essos;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.*;
import got.common.entity.animal.GOTEntityElephant;
import got.common.world.spawning.GOTEventSpawner;
import got.common.world.structure.essos.tyrosh.GOTStructureTyroshCity;
import net.minecraft.world.biome.BiomeGenBase;

public class GOTBiomeTyrosh extends GOTBiomeFreeCities {
	public GOTBiomeTyrosh(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityElephant.class, 8, 1, 1));
		decorator.addVillage(new GOTStructureTyroshCity(this, 1.0f));

		invasionSpawns.addInvasion(GOTInvasions.MYR, GOTEventSpawner.EventChance.COMMON);
		invasionSpawns.addInvasion(GOTInvasions.VOLANTIS, GOTEventSpawner.EventChance.COMMON);
		invasionSpawns.addInvasion(GOTInvasions.LYS, GOTEventSpawner.EventChance.COMMON);
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_TYROSH;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.ESSOS.getSubregion("tyrosh");
	}
}