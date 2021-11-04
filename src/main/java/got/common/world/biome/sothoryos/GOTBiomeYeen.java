package got.common.world.biome.sothoryos;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.*;
import got.common.entity.animal.GOTEntityJungleScorpion;
import got.common.world.biome.GOTBiome;
import got.common.world.map.*;
import got.common.world.map.GOTWaypoint.Region;
import got.common.world.structure.other.GOTStructureRuinsBig;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

public class GOTBiomeYeen extends GOTBiome {
	public GOTBiomeYeen(int i, boolean major) {
		super(i, major);
		topBlock = GOTRegistry.obsidianGravel;
		fillerBlock = Blocks.obsidian;

		spawnableCreatureList.clear();
		spawnableGOTAmbientList.clear();
		spawnableMonsterList.clear();
		spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(GOTEntityJungleScorpion.class, 30, 4, 4));

		biomeColors.setSky(0);
		biomeColors.setClouds(0);
		biomeColors.setFog(0);
		biomeColors.setWater(0);

		GOTStructureRuinsBig colossal = new GOTStructureRuinsBig(this, 0.0f);
		colossal.affix(GOTWaypoint.Yeen);
		decorator.addVillage(colossal);
	}

	@Override
	public boolean canSpawnHostilesInDay() {
		return true;
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_YEEN;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.SOTHORYOS.getSubregion("yeen");
	}

	@Override
	public Region getBiomeWaypoints() {
		return Region.SOTHORYOS;
	}

	@Override
	public GOTBezierType getRoadBlock() {
		return GOTBezierType.SOTHORYOS;
	}
}