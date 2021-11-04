package got.common.world.structure.westeros.legendary;

import java.util.Random;

import got.common.entity.westeros.legendary.warrior.GOTEntityNightKing;
import got.common.world.map.GOTFixedStructures;
import got.common.world.structure.other.GOTStructureBase;
import net.minecraft.world.World;

public class GOTStructureNightKing extends GOTStructureBase {
	public GOTStructureNightKing(boolean flag) {
		super(flag);
	}

	@Override
	public boolean generateWithSetRotation(World world, Random random, int i, int j, int k, int rotation) {
		this.setOriginAndRotation(world, i, j, k, rotation, 0);
		setupRandomBlocks(random);
		for (int loopX = -3; loopX <= 1; ++loopX) {
			for (int loopZ = -3; loopZ <= 1; ++loopZ) {
				for (int loopY = 1; loopY <= 5; ++loopY) {
					setAir(world, loopX, loopY, loopZ);
				}
			}
		}
		loadStrScan("night_king");
		spawnNPCAndSetHome(new GOTEntityNightKing(world), world, 0, 10, 0, 10000);
		generateStrScan(world, random, 0, 0, 0);
		return true;
	}

	public static boolean generatesAt(World world, int i, int k) {
		return GOTFixedStructures.generatesAtMapImageCoords(i, k, 613, 314);
	}
}