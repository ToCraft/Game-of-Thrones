package got.common.world.structure.westeros.legendary;

import java.util.Random;

import got.common.database.GOTRegistry;
import got.common.entity.other.GOTEntityNPC;
import got.common.entity.westeros.ironborn.GOTEntityIronbornSoldier;
import got.common.entity.westeros.legendary.warrior.GOTEntityVictarionGreyjoy;
import got.common.world.map.*;
import got.common.world.structure.other.*;
import got.common.world.structure.westeros.ironborn.GOTStructureIronbornTent;
import net.minecraft.world.World;

public class GOTStructureVictarionCamp extends GOTStructureCampBase {
	public GOTStructureVictarionCamp(boolean flag) {
		super(flag);
	}

	@Override
	public GOTStructureBase createTent(boolean flag, Random random) {
		return new GOTStructureIronbornTent(false);
	}

	@Override
	public boolean generateFarm() {
		return false;
	}

	@Override
	public GOTEntityNPC getCampCaptain(World world, Random random) {
		return new GOTEntityVictarionGreyjoy(world);
	}

	@Override
	public void placeNPCRespawner(World world, Random random, int i, int j, int k) {
		for (int l = 0; l < 20; ++l) {
			spawnNPCAndSetHome(new GOTEntityIronbornSoldier(world), world, 0, 1, 0, 16);
		}
	}

	@Override
	public void setupRandomBlocks(Random random) {
		super.setupRandomBlocks(random);
		tableBlock = GOTRegistry.commandTable;
	}

	public static boolean generatesAt(World world, int i, int k) {
		return GOTFixedStructures.generatesAtMapImageCoords(i, k, GOTWaypoint.VictarionLanding);
	}
}