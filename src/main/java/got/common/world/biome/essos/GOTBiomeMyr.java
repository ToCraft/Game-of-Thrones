package got.common.world.biome.essos;

import java.util.Random;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.*;
import got.common.entity.animal.GOTEntityElephant;
import got.common.world.biome.variant.GOTBiomeVariant;
import got.common.world.spawning.GOTEventSpawner;
import got.common.world.spawning.GOTSpawner;
import got.common.world.structure.essos.myr.GOTStructureMyrCity;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class GOTBiomeMyr extends GOTBiomeFreeCities {
	public GOTBiomeMyr(int i, boolean major) {
		super(i, major);
		this.addBiomeVariant(GOTBiomeVariant.FIELD_CORN, 0.2f);
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityElephant.class, 8, 1, 1));

		decorator.addVillage(new GOTStructureMyrCity(this, 1.0f));

		invasionSpawns.addInvasion(GOTInvasions.LYS, GOTEventSpawner.EventChance.COMMON);
		invasionSpawns.addInvasion(GOTInvasions.VOLANTIS, GOTEventSpawner.EventChance.COMMON);
		invasionSpawns.addInvasion(GOTInvasions.TYROSH, GOTEventSpawner.EventChance.COMMON);
		invasionSpawns.addInvasion(GOTInvasions.DOTHRAKI, GOTEventSpawner.EventChance.COMMON);
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_MYR;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.ESSOS.getSubregion("myr");
	}
	
	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (GOTSpawner.HarryStrickland.generatesAt(world, i, k)) {
			new GOTSpawner.HarryStrickland(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
	}
}
