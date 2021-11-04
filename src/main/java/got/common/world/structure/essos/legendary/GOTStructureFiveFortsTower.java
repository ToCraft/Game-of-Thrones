package got.common.world.structure.essos.legendary;

import java.util.Random;

import got.common.world.map.GOTFixedStructures;
import got.common.world.structure.other.GOTStructureBase;
import net.minecraft.world.World;

public class GOTStructureFiveFortsTower extends GOTStructureBase {
	public GOTStructureFiveFortsTower(boolean flag) {
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
		loadStrScan("five_forts_tower");
		generateStrScan(world, random, 0, 0, 0);
		return true;
	}

	public static boolean generatesAt1(World world, int i, int k) {
		return GOTFixedStructures.generatesAtMapImageCoords(i, k, 3778, 1920);
	}

	public static boolean generatesAt2(World world, int i, int k) {
		return GOTFixedStructures.generatesAtMapImageCoords(i, k, 3786, 1931);
	}

	public static boolean generatesAt3(World world, int i, int k) {
		return GOTFixedStructures.generatesAtMapImageCoords(i, k, 3800, 1941);
	}

	public static boolean generatesAt4(World world, int i, int k) {
		return GOTFixedStructures.generatesAtMapImageCoords(i, k, 3817, 1943);
	}

	public static boolean generatesAt5(World world, int i, int k) {
		return GOTFixedStructures.generatesAtMapImageCoords(i, k, 3832, 1939);
	}
}