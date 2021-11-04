package got.common.world.biome.westeros;

import java.util.Random;

import got.client.sound.GOTBiomeMusic;
import got.client.sound.GOTBiomeMusic.MusicRegion;
import got.common.database.GOTRegistry;
import got.common.world.map.*;
import got.common.world.map.GOTWaypoint.Region;
import got.common.world.spawning.GOTSpawner;
import got.common.world.structure.westeros.ironborn.GOTWaypointIronbornCastle;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class GOTBiomeIronbornHills extends GOTBiomeIronborn {
	public GOTBiomeIronbornHills(int i, boolean major) {
		super(i, major);
		decorator.clearOres();
		decorator.addOre(new WorldGenMinable(Blocks.iron_ore, 8), 8.0f, 0, 255);
		decorator.addOre(new WorldGenMinable(GOTRegistry.oreTin, 8), 8.0f, 0, 255);
		decorator.addOre(new WorldGenMinable(GOTRegistry.oreCopper, 8), 8.0f, 0, 255);
		decorator.addOre(new WorldGenMinable(GOTRegistry.oreCobalt, 5), 5.0f, 0, 32);

		GOTWaypointIronbornCastle castle = new GOTWaypointIronbornCastle(this, 0.0f);
		castle.affix(GOTWaypoint.Hammerhorn);
		decorator.addVillage(castle);
	}

	@Override
	public MusicRegion getBiomeMusic() {
		return GOTBiomeMusic.WESTEROS.getSubregion("ironbornHills");
	}

    public void decorate(World world, Random random, int i, int k) {
    	super.decorate(world, random, i, k);
		if (GOTSpawner.GoroldGoodbrother.generatesAt(world, i, k)) {
			new GOTSpawner.GoroldGoodbrother(false).generateWithSetRotation(world, random, i, world.getTopSolidOrLiquidBlock(i, k), k, 0);
		}
    }

	@Override
	public Region getBiomeWaypoints() {
		return Region.IRONBORN;
	}

	@Override
	public GOTBezierType getRoadBlock() {
		return GOTBezierType.WESTEROS_PATH;
	}
}
