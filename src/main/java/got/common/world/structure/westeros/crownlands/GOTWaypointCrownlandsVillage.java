package got.common.world.structure.westeros.crownlands;

import java.util.Random;

import got.common.entity.other.GOTEntityNPCRespawner;
import got.common.entity.westeros.crownlands.GOTEntityCrownlandsMan;
import got.common.entity.westeros.westerlands.GOTEntityWesterlandsSoldier;
import got.common.world.biome.GOTBiome;
import got.common.world.map.GOTBezierType;
import got.common.world.structure.other.*;
import got.common.world.structure.westeros.common.*;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class GOTWaypointCrownlandsVillage extends GOTVillageGen {
	public GOTWaypointCrownlandsVillage(GOTBiome biome, float f) {
		super(biome);
		gridScale = 16;
		gridRandomDisplace = 2;
		spawnChance = f;
		villageChunkSize = 25;
	}

	@Override
	public GOTVillageGen.AbstractInstance createVillageInstance(World world, int i, int k, Random random, GOTLocationInfo loc) {
		return new Instance(this, world, i, k, random, loc);
	}

	public class Instance extends GOTVillageGen.AbstractInstance {
		public VillageType villageType;

		public Instance(GOTWaypointCrownlandsVillage village, World world, int i, int k, Random random, GOTLocationInfo loc) {
			super(village, world, i, k, random, loc);
		}

		@Override
		public void addStructure(GOTStructureBase structure, int x, int z, int r, boolean force) {
			super.addStructure(structure, x, z, r, force);
		}

		@Override
		public void addVillageStructures(Random random) {
			this.addStructure(new GOTStructureWesterosWell(false), 0, -4, 0, true);
			this.addStructure(new GOTStructureNPCRespawner(false) {

				@Override
				public void setupRespawner(GOTEntityNPCRespawner spawner) {
					spawner.setSpawnClass(GOTEntityCrownlandsMan.class);
					spawner.setCheckRanges(40, -12, 12, 40);
					spawner.setSpawnRanges(20, -6, 6, 64);
					spawner.setBlockEnemySpawnRange(60);
				}
			}, 0, 0, 0);
			this.addStructure(new GOTStructureNPCRespawner(false) {

				@Override
				public void setupRespawner(GOTEntityNPCRespawner spawner) {
					spawner.setSpawnClass(GOTEntityWesterlandsSoldier.class);
					spawner.setCheckRanges(40, -12, 12, 16);
					spawner.setSpawnRanges(20, -6, 6, 64);
					spawner.setBlockEnemySpawnRange(60);
				}
			}, 0, 0, 0);
			this.addStructure(new GOTStructureCrownlandsCottage(false), -21, 0, 1);
			this.addStructure(new GOTStructureCrownlandsCottage(false), 0, -21, 2);
			this.addStructure(new GOTStructureCrownlandsCottage(false), 21, 0, 3);
			this.addStructure(new GOTStructureCrownlandsTavern(false), 0, 21, 0);
			if (random.nextBoolean()) {
				if (random.nextInt(3) == 0) {
					this.addStructure(GOTStructureCrownlandsMarketStall.getRandomStall(random, false), -9, -12, 1);
				}
				if (random.nextInt(3) == 0) {
					this.addStructure(GOTStructureCrownlandsMarketStall.getRandomStall(random, false), 9, -12, 3);
				}
				if (random.nextInt(3) == 0) {
					this.addStructure(GOTStructureCrownlandsMarketStall.getRandomStall(random, false), -9, 12, 1);
				}
				if (random.nextInt(3) == 0) {
					this.addStructure(GOTStructureCrownlandsMarketStall.getRandomStall(random, false), 9, 12, 3);
				}
			}
			int houses = 20;
			float frac = 1.0f / houses;
			float turn = 0.0f;
			while (turn < 1.0f) {
				int k;
				int l;
				int i;
				float turnR = (float) Math.toRadians((turn += frac) * 360.0f);
				float sin = MathHelper.sin(turnR);
				float cos = MathHelper.cos(turnR);
				int r = 0;
				float turn8 = turn * 8.0f;
				if (turn8 >= 1.0f && turn8 < 3.0f) {
					r = 0;
				} else if (turn8 >= 3.0f && turn8 < 5.0f) {
					r = 1;
				} else if (turn8 >= 5.0f && turn8 < 7.0f) {
					r = 2;
				} else if (turn8 >= 7.0f || turn8 < 1.0f) {
					r = 3;
				}
				if (random.nextBoolean()) {
					l = 61;
					i = Math.round(l * cos);
					k = Math.round(l * sin);
					this.addStructure(getRandomHouse(random), i, k, r);
					continue;
				}
				if (random.nextInt(3) == 0) {
					continue;
				}
				l = 65;
				i = Math.round(l * cos);
				k = Math.round(l * sin);
				this.addStructure(new GOTStructureHayBales(false), i, k, r);
			}
			int signPos = Math.round(50.0f * MathHelper.cos((float) Math.toRadians(45.0)));
			int signDisp = Math.round(7.0f * MathHelper.cos((float) Math.toRadians(45.0)));
			this.addStructure(new GOTStructureWesterosVillageSign(false), -signPos, -signPos + signDisp, 1);
			this.addStructure(new GOTStructureWesterosVillageSign(false), signPos, -signPos + signDisp, 3);
			this.addStructure(new GOTStructureWesterosVillageSign(false), -signPos, signPos - signDisp, 1);
			this.addStructure(new GOTStructureWesterosVillageSign(false), signPos, signPos - signDisp, 3);
			int farmX = 38;
			int farmZ = 17;
			int farmSize = 6;
			if (random.nextBoolean()) {
				this.addStructure(getRandomFarm(random), -farmX + farmSize, -farmZ, 1);
			}
			if (random.nextBoolean()) {
				this.addStructure(getRandomFarm(random), -farmZ + farmSize, -farmX, 1);
			}
			if (random.nextBoolean()) {
				this.addStructure(getRandomFarm(random), farmX - farmSize, -farmZ, 3);
			}
			if (random.nextBoolean()) {
				this.addStructure(getRandomFarm(random), farmZ - farmSize, -farmX, 3);
			}
			if (random.nextBoolean()) {
				this.addStructure(getRandomFarm(random), -farmX + farmSize, farmZ, 1);
			}
			if (random.nextBoolean()) {
				this.addStructure(getRandomFarm(random), farmX - farmSize, farmZ, 3);
			}
		}

		@Override
		public GOTBezierType getPath(Random random, int i, int k) {
			int i1 = Math.abs(i);
			int k1 = Math.abs(k);
			if (villageType == VillageType.VILLAGE) {
				int dSq = i * i + k * k;
				int imn = 20 + random.nextInt(4);
				if (dSq < imn * imn) {
					return GOTBezierType.WESTEROS_PATH;
				}
				int omn = 53 - random.nextInt(4);
				int omx = 60 + random.nextInt(4);
				if (dSq > omn * omn && dSq < omx * omx) {
					return GOTBezierType.WESTEROS_PATH;
				}
				if (dSq < 2809 && Math.abs(i1 - k1) <= 2 + random.nextInt(4)) {
					return GOTBezierType.WESTEROS_PATH;
				}
			}
			return null;
		}

		public GOTStructureBase getRandomFarm(Random random) {
			if (random.nextBoolean()) {
				if (random.nextBoolean()) {
					return new GOTStructureCrownlandsVillageFarm.Animals(false);
				}
				return new GOTStructureCrownlandsVillageFarm.Crops(false);
			}
			return new GOTStructureCrownlandsVillageFarm.Tree(false);
		}

		public GOTStructureBase getRandomHouse(Random random) {
			if (random.nextInt(5) == 0) {
				int i = random.nextInt(3);
				switch (i) {
				case 0:
					return new GOTStructureCrownlandsStables(false);
				case 1:
					return new GOTStructureCrownlandsSmithy(false);
				case 2:
					return new GOTStructureCrownlandsBarn(false);
				default:
					break;
				}
			}
			return new GOTStructureCrownlandsHouse(false);
		}

		@Override
		public boolean isFlat() {
			return false;
		}

		@Override
		public boolean isVillageSurface(World world, int i, int j, int k) {
			return false;
		}

		@Override
		public void setupVillageProperties(Random random) {
			villageType = VillageType.VILLAGE;
		}
	}

	public enum VillageType {
		VILLAGE;
	}
}