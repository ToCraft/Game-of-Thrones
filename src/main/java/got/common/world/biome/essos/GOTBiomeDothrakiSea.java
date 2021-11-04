package got.common.world.biome.essos;

import java.util.Random;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.GOTAchievement;
import got.common.entity.animal.*;
import got.common.world.biome.GOTBiome;
import got.common.world.map.*;
import got.common.world.map.GOTWaypoint.Region;
import got.common.world.spawning.GOTSpawner;
import got.common.world.structure.essos.dothraki.GOTStructureDothrakiVillage;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class GOTBiomeDothrakiSea extends GOTBiome {
	public GOTBiomeDothrakiSea(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.clear();
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityLion.class, 4, 2, 4));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityLioness.class, 4, 2, 4));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityGemsbok.class, 8, 4, 8));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityCamel.class, 6, 4, 4));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityHorse.class, 15, 4, 4));

		spawnableGOTAmbientList.clear();
		spawnableGOTAmbientList.add(new BiomeGenBase.SpawnListEntry(GOTEntityButterfly.class, 5, 4, 4));
		spawnableGOTAmbientList.add(new BiomeGenBase.SpawnListEntry(GOTEntityBird.class, 8, 4, 4));
		spawnableGOTAmbientList.add(new BiomeGenBase.SpawnListEntry(GOTEntityDikDik.class, 8, 4, 6));

		decorator.doubleGrassPerChunk = 256;
		decorator.clearTrees();

		GOTStructureDothrakiVillage camp = new GOTStructureDothrakiVillage(this, 0.5f);
		camp.affix(GOTWaypoint.Sathar);
		camp.affix(GOTWaypoint.Kyth);
		camp.affix(GOTWaypoint.Hornoth);
		camp.affix(GOTWaypoint.Rathylar);
		camp.affix(GOTWaypoint.VaesAthjikhari);
		camp.affix(GOTWaypoint.VaesDiaf);
		camp.affix(GOTWaypoint.VaesDothrak);
		camp.affix(GOTWaypoint.VaesEfe);
		camp.affix(GOTWaypoint.VaesGorqoyi);
		camp.affix(GOTWaypoint.VaesGraddakh);
		camp.affix(GOTWaypoint.VaesJini);
		camp.affix(GOTWaypoint.VaesKhadokh);
		camp.affix(GOTWaypoint.VaesKhewo);
		camp.affix(GOTWaypoint.VaesLeisi);
		camp.affix(GOTWaypoint.VaesLeqse);
		camp.affix(GOTWaypoint.VaesMejhah);
		decorator.addVillage(camp);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (GOTSpawner.DaenerysTargaryen.generatesAt(world, i, k)) {
			new GOTSpawner.DaenerysTargaryen(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_DOTHRAKI_SEA;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.ESSOS.getSubregion("dothrakiSea");
	}

	@Override
	public Region getBiomeWaypoints() {
		return Region.DOTHRAKI;
	}

	@Override
	public GOTBezierType getRoadBlock() {
		return GOTBezierType.WESTEROS_PATH;
	}
}