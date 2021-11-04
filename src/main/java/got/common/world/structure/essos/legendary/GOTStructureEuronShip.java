package got.common.world.structure.essos.legendary;

import java.util.Random;

import got.common.entity.westeros.ironborn.GOTEntityIronbornCorsair;
import got.common.entity.westeros.legendary.warrior.GOTEntityEuronGreyjoy;
import got.common.world.map.GOTFixedStructures;
import got.common.world.structure.westeros.ironborn.GOTStructureIronbornBase;
import net.minecraft.world.World;

public class GOTStructureEuronShip extends GOTStructureIronbornBase {
	public GOTStructureEuronShip(boolean flag) {
		super(flag);
	}

	@Override
	public boolean generateWithSetRotation(World world, Random random, int i, int j, int k, int rotation) {
		this.setOriginAndRotation(world, i, j, k, rotation, 5, -1);
		setupRandomBlocks(random);
		loadStrScan("euron_ship");
		generateStrScan(world, random, 20, 1, -58);
		for (int l = 0; l < 10; ++l) {
			spawnLegendaryNPC(new GOTEntityIronbornCorsair(world), world, 0, 1, 0);
		}
		spawnLegendaryNPC(new GOTEntityEuronGreyjoy(world), world, 3, 23, 0);
		return true;
	}

	public static boolean generatesAt(World world, int i, int k) {
		return GOTFixedStructures.generatesAtMapImageCoords(i, k, 3065, 3065);
	}
}