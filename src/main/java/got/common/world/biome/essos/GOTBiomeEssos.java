package got.common.world.biome.essos;

import java.util.Random;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.entity.animal.*;
import got.common.entity.essos.asshai.GOTEntityAsshaiAlchemist;
import got.common.entity.essos.qarth.GOTEntityQarthWarlock;
import got.common.entity.other.GOTEntityEssosBandit;
import got.common.world.biome.GOTBiome;
import got.common.world.feature.*;
import got.common.world.map.GOTBezierType;
import got.common.world.map.GOTWaypoint.Region;
import got.common.world.spawning.GOTEventSpawner;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.*;

public class GOTBiomeEssos extends GOTBiome {
	public WorldGenerator boulderGen = new GOTWorldGenBoulder(Blocks.stone, 0, 1, 4);

	public GOTBiomeEssos(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.clear();
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityLion.class, 4, 2, 4));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityLioness.class, 4, 2, 4));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityGiraffe.class, 4, 4, 6));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityZebra.class, 8, 4, 8));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityRhino.class, 8, 4, 4));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityGemsbok.class, 8, 4, 8));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityCamel.class, 6, 4, 4));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GOTEntityHorse.class, 15, 4, 4));

		spawnableGOTAmbientList.clear();
		spawnableGOTAmbientList.add(new BiomeGenBase.SpawnListEntry(GOTEntityButterfly.class, 5, 4, 4));
		spawnableGOTAmbientList.add(new BiomeGenBase.SpawnListEntry(GOTEntityBird.class, 8, 4, 4));
		spawnableGOTAmbientList.add(new BiomeGenBase.SpawnListEntry(GOTEntityDikDik.class, 8, 4, 6));

		decorator.addOre(new WorldGenMinable(Blocks.lapis_ore, 6), 1.0f, 0, 48);

		decorator.grassPerChunk = 10;
		decorator.doubleGrassPerChunk = 2;
		decorator.flowersPerChunk = 3;
		decorator.doubleFlowersPerChunk = 1;
		decorator.cactiPerChunk = 1;

		decorator.addTree(GOTTreeType.CEDAR, 800);
		decorator.addTree(GOTTreeType.OAK_DESERT, 500);
		decorator.addTree(GOTTreeType.DATE_PALM, 50);
		decorator.addTree(GOTTreeType.CYPRESS, 400);
		decorator.addTree(GOTTreeType.CYPRESS_LARGE, 50);
		decorator.addTree(GOTTreeType.PALM, 100);
		decorator.addTree(GOTTreeType.LEMON, 5);
		decorator.addTree(GOTTreeType.ORANGE, 5);
		decorator.addTree(GOTTreeType.LIME, 5);
		decorator.addTree(GOTTreeType.OLIVE, 5);
		decorator.addTree(GOTTreeType.OLIVE_LARGE, 10);
		decorator.addTree(GOTTreeType.ALMOND, 5);
		decorator.addTree(GOTTreeType.PLUM, 5);

		registerEssosFlowers();

		setBanditChance(GOTEventSpawner.EventChance.BANDIT_COMMON);
		setBanditEntityClass(GOTEntityEssosBandit.class);

		registerTravellingTrader(GOTEntityAsshaiAlchemist.class);
		registerTravellingTrader(GOTEntityQarthWarlock.class);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (random.nextInt(200) == 0) {
			for (int l = 0; l < 3; ++l) {
				int i1 = i + random.nextInt(16) + 8;
				int k1 = k + random.nextInt(16) + 8;
				boulderGen.generate(world, random, i1, world.getHeightValue(i1, k1), k1);
			}
		}
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.ESSOS.getSubregion("unhabited");
	}

	@Override
	public Region getBiomeWaypoints() {
		return null;
	}

	@Override
	public GOTBezierType getRoadBlock() {
		return GOTBezierType.WESTEROS_PATH;
	}

	@Override
	public GOTBezierType getWallBlock() {
		return GOTBezierType.WOOD;
	}
}
