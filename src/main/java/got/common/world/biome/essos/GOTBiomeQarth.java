package got.common.world.biome.essos;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.GOTAchievement;
import got.common.entity.animal.GOTEntityManticore;
import got.common.world.map.GOTWaypoint.Region;
import got.common.world.structure.essos.qarth.GOTStructureQarthCity;
import net.minecraft.world.biome.BiomeGenBase;

public class GOTBiomeQarth extends GOTBiomeFreeCities {
	public GOTBiomeQarth(int i, boolean major) {
		super(i, major);
		spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(GOTEntityManticore.class, 10, 4, 4));
		decorator.addVillage(new GOTStructureQarthCity(this, 1.0f));
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_QARTH;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.ESSOS.getSubregion("qarth");
	}

	@Override
	public Region getBiomeWaypoints() {
		return Region.QARTH;
	}
}