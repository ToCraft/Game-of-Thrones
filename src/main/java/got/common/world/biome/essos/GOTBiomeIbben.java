package got.common.world.biome.essos;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.*;
import got.common.entity.animal.*;
import got.common.world.biome.GOTBiome;
import got.common.world.map.GOTBezierType;
import got.common.world.map.GOTWaypoint.Region;
import got.common.world.spawning.GOTEventSpawner;
import got.common.world.structure.essos.ibben.GOTStructureIbbenVillage;
import got.common.world.structure.other.GOTStructureBarrow;
import net.minecraft.world.biome.BiomeGenBase;

public class GOTBiomeIbben extends GOTBiome {
	public GOTBiomeIbben(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.clear();
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityDirewolf.class, 8, 2, 2));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityWoolyRhino.class, 8, 2, 2));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityDeer.class, 8, 2, 2));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityMammoth.class, 8, 1, 1));
		
		decorator.addVillage(new GOTStructureIbbenVillage(this, 1.0f));

		setBanditChance(GOTEventSpawner.EventChance.COMMON);
		decorator.addRandomStructure(new GOTStructureBarrow(false), 600);
		
		invasionSpawns.addInvasion(GOTInvasions.IRONBORN, GOTEventSpawner.EventChance.COMMON);
	}

	@Override
	public GOTAchievement getBiomeAchievement() {
		return GOTAchievement.VISIT_IBBEN;
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.ESSOS.getSubregion("ibben");
	}

	@Override
	public Region getBiomeWaypoints() {
		return Region.IBBEN;
	}

	@Override
	public GOTBezierType getRoadBlock() {
		return GOTBezierType.WESTEROS_PATH;
	}
}