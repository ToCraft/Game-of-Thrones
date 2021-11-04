package got.common.world.biome.sothoryos;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.GOTAchievement;
import got.common.entity.animal.GOTEntityWyvern;
import net.minecraft.world.biome.BiomeGenBase;

public class GOTBiomeSothoryosHell extends GOTBiomeSothoryosJungle {

	public GOTBiomeSothoryosHell(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.clear();
		npcSpawnList.clear();
		spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(GOTEntityWyvern.class, 10, 1, 1));
	}

	@Override
	public boolean canSpawnHostilesInDay() {
		return true;
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_SOTHORYOS_HELL;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.SOTHORYOS.getSubregion("sothoryosHell");
	}
}