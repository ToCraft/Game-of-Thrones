package got.common.world.biome.essos;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.*;
import got.common.entity.animal.*;
import got.common.entity.essos.asshai.GOTEntityAsshaiAlchemist;
import got.common.entity.essos.qarth.GOTEntityQarthWarlock;
import got.common.world.biome.GOTBiome;
import got.common.world.map.*;
import got.common.world.map.GOTWaypoint.Region;
import got.common.world.spawning.GOTEventSpawner;
import got.common.world.structure.essos.lhazar.GOTStructureLhazarVillage;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.world.biome.BiomeGenBase;

public class GOTBiomeLhazar extends GOTBiome {
	public GOTBiomeLhazar(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.clear();
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityLion.class, 4, 2, 4));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityLioness.class, 4, 2, 4));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityGemsbok.class, 8, 4, 8));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntitySheep.class, 8, 4, 8));

		spawnableGOTAmbientList.clear();
		spawnableGOTAmbientList.add(new BiomeGenBase.SpawnListEntry(GOTEntityButterfly.class, 5, 4, 4));
		spawnableGOTAmbientList.add(new BiomeGenBase.SpawnListEntry(GOTEntityBird.class, 8, 4, 4));
		spawnableGOTAmbientList.add(new BiomeGenBase.SpawnListEntry(GOTEntityDikDik.class, 8, 4, 6));

		decorator.grassPerChunk = 256;

		GOTStructureLhazarVillage village = new GOTStructureLhazarVillage(this, 0.5f);
		village.affix(GOTWaypoint.Hesh);
		village.affix(GOTWaypoint.Lhazosh);
		village.affix(GOTWaypoint.Kosrak);
		decorator.addVillage(village);

		registerTravellingTrader(GOTEntityAsshaiAlchemist.class);
		registerTravellingTrader(GOTEntityQarthWarlock.class);

		invasionSpawns.addInvasion(GOTInvasions.DOTHRAKI, GOTEventSpawner.EventChance.COMMON);

	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_LHAZAR;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.ESSOS.getSubregion("lhazar");
	}

	@Override
	public Region getBiomeWaypoints() {
		return Region.LHAZAR;
	}

	@Override
	public GOTBezierType getRoadBlock() {
		return GOTBezierType.WESTEROS_PATH;
	}
}