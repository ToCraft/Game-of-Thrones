package got.common.world.biome.essos;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.*;
import got.common.entity.animal.GOTEntityElephant;
import got.common.world.spawning.GOTEventSpawner;
import got.common.world.structure.essos.lys.GOTStructureLysCity;
import net.minecraft.world.biome.BiomeGenBase;

public class GOTBiomeLys extends GOTBiomeFreeCities {
	public GOTBiomeLys(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityElephant.class, 8, 1, 1));
		decorator.addVillage(new GOTStructureLysCity(this, 1.0f));

		invasionSpawns.addInvasion(GOTInvasions.MYR, GOTEventSpawner.EventChance.COMMON);
		invasionSpawns.addInvasion(GOTInvasions.VOLANTIS, GOTEventSpawner.EventChance.COMMON);
		invasionSpawns.addInvasion(GOTInvasions.TYROSH, GOTEventSpawner.EventChance.COMMON);
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_LYS;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.ESSOS.getSubregion("lys");
	}

}
