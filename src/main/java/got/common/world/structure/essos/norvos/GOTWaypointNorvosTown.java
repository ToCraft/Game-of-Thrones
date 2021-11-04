package got.common.world.structure.essos.norvos;

import java.util.Random;

import got.common.entity.essos.norvos.*;
import got.common.entity.other.GOTEntityNPCRespawner;
import got.common.world.biome.GOTBiome;
import got.common.world.map.GOTBezierType;
import got.common.world.structure.essos.common.*;
import got.common.world.structure.other.*;
import net.minecraft.world.World;

public class GOTWaypointNorvosTown extends GOTVillageGen {
	public GOTWaypointNorvosTown(GOTBiome biome, float f) {
		super(biome);
		gridScale = 14;
		gridRandomDisplace = 1;
		spawnChance = f;
		villageChunkSize = 25;
	}

	@Override
	public GOTVillageGen.AbstractInstance createVillageInstance(World world, int i, int k, Random random, GOTLocationInfo loc) {
		return new Instance(this, world, i, k, random, loc);
	}

	public class Instance extends GOTVillageGen.AbstractInstance {
		public VillageType villageType;

		public Instance(GOTWaypointNorvosTown village, World world, int i, int k, Random random, GOTLocationInfo loc) {
			super(village, world, i, k, random, loc);
		}

		@Override
		public void addVillageStructures(Random random) {
			int k;
			int i;
			int r;
			int l;
			this.addStructure(new GOTStructureNPCRespawner(false) {

				@Override
				public void setupRespawner(GOTEntityNPCRespawner spawner) {
					Instance.this.setCivilianSpawnClass(spawner);
					spawner.setCheckRanges(80, -12, 12, 100);
					spawner.setSpawnRanges(40, -6, 6, 64);
					spawner.setBlockEnemySpawnRange(60);
				}
			}, 0, 0, 0);
			for (int i1 : new int[] { -30, 30 }) {
				for (int k1 : new int[] { -30, 30 }) {
					this.addStructure(new GOTStructureNPCRespawner(false) {

						@Override
						public void setupRespawner(GOTEntityNPCRespawner spawner) {
							Instance.this.setWarriorSpawnClasses(spawner);
							spawner.setCheckRanges(40, -12, 12, 16);
							spawner.setSpawnRanges(20, -6, 6, 64);
							spawner.setBlockEnemySpawnRange(60);
						}
					}, i1, k1, 0);
				}
			}
			this.addStructure(getBazaar(random), 1, -2, 0, true);
			this.addStructure(getLamp(random), 15, -2, 0, true);
			this.addStructure(getLamp(random), -13, -2, 0, true);
			this.addStructure(getLamp(random), 15, 18, 0, true);
			this.addStructure(getLamp(random), -13, 18, 0, true);
			this.addStructure(getWell(random), -16, 12, 1, true);
			this.addStructure(getWell(random), -16, 4, 1, true);
			this.addStructure(getFlowers(random), 18, 13, 3, true);
			this.addStructure(getFlowers(random), 18, 3, 3, true);
			for (l = 0; l <= 3; ++l) {
				i = -41 + l * 19;
				k = -7;
				r = 2;
				this.addStructure(getMansion(random), i, k, r, true);
				this.addStructure(getLamp(random), i + 6, k - 1, r, true);
				i = 24 - l * 19;
				k = 23;
				r = 0;
				this.addStructure(getMansion(random), i, k, r, true);
				this.addStructure(getLamp(random), i - 6, k + 1, r, true);
			}
			this.addStructure(getSmithy(random), -25, 9, 1, true);
			this.addStructure(getHouse(random), -25, 18, 1, true);
			this.addStructure(getHouse(random), -25, -2, 1, true);
			this.addStructure(getTree(random), -45, 8, 1, true);
			this.addStructure(getHouse(random), -50, 18, 3, true);
			this.addStructure(getHouse(random), -50, -2, 3, true);
			this.addStructure(getWell(random), -51, -14, 2, true);
			this.addStructure(getTree(random), -46, -29, 2, true);
			this.addStructure(getFlowers(random), -42, -32, 3, true);
			this.addStructure(getTree(random), -50, 30, 0, true);
			for (l = -3; l <= 3; ++l) {
				i = -56;
				k = -2 + l * 10;
				r = 1;
				this.addStructure(getHouse(random), i, k, r, true);
			}
			this.addStructure(getStatue(random), 26, 8, 3, true);
			this.addStructure(getHouse(random), 26, 18, 3, true);
			this.addStructure(getHouse(random), 26, -2, 3, true);
			for (l = -3; l <= 2; ++l) {
				i = 52;
				k = 8 + l * 10;
				r = 1;
				this.addStructure(getHouse(random), i, k, r, true);
			}
			this.addStructure(getSmithy(random), 41, -33, 3, true);
			for (l = -2; l <= 2; ++l) {
				i = 65;
				k = 3 + l * 14;
				r = 2;
				this.addStructure(getHouse(random), i, k, r, true);
			}
			this.addStructure(getWell(random), 57, -19, 2, true);
			this.addStructure(getLamp(random), 57, -16, 2, true);
			this.addStructure(getLamp(random), 57, -8, 2, true);
			this.addStructure(getTree(random), 57, 1, 2, true);
			this.addStructure(getLamp(random), 57, 4, 2, true);
			this.addStructure(getLamp(random), 57, 12, 2, true);
			this.addStructure(getTree(random), 57, 21, 2, true);
			this.addStructure(getLamp(random), 57, 24, 2, true);
			this.addStructure(getLamp(random), 57, 32, 2, true);
			for (l = 0; l <= 3; ++l) {
				i = 41 + l * 8;
				k = 34;
				r = 0;
				this.addStructure(getFlowers(random), i, k, r, true);
			}
			this.addStructure(getTree(random), 34, 25, 0, true);
			this.addStructure(getStables(random), -20, -30, 1, true);
			this.addStructure(getTavern(random), 17, -32, 1, true);
			this.addStructure(getLamp(random), 19, -28, 1, true);
			this.addStructure(getLamp(random), 19, -36, 1, true);
			this.addStructure(getLamp(random), -16, -32, 3, true);
			this.addStructure(getFlowers(random), 25, -32, 3, true);
			this.addStructure(getTree(random), 34, -29, 2, true);
			this.addStructure(getLamp(random), 34, -26, 2, true);
			this.addStructure(getLamp(random), 34, -18, 2, true);
			this.addStructure(getTree(random), 34, -9, 2, true);
		}

		public GOTStructureBase getBazaar(Random random) {
			return new GOTStructureNorvosBazaar(false);
		}

		public GOTStructureBase getFlowers(Random random) {
			return new GOTStructureEssosTownFlowers(false);
		}

		public GOTStructureBase getHouse(Random random) {
			return new GOTStructureNorvosHouse(false);
		}

		public GOTStructureBase getLamp(Random random) {
			return new GOTStructureEssosLamp(false);
		}

		public GOTStructureBase getMansion(Random random) {
			return new GOTStructureNorvosMansion(false);
		}

		@Override
		public GOTBezierType getPath(Random random, int i, int k) {
			return null;
		}

		public GOTStructureBase getRandomFarm(Random random) {
			if (random.nextBoolean()) {
				return new GOTStructureNorvosFarm(false);
			}
			return new GOTStructureNorvosPasture(false);
		}

		public GOTStructureBase getRandomHouse(Random random) {
			if (random.nextInt(6) == 0) {
				return new GOTStructureNorvosSmithy(false);
			}
			if (random.nextInt(6) == 0) {
				return new GOTStructureNorvosStables(false);
			}
			return new GOTStructureNorvosHouse(false);
		}

		public GOTStructureBase getSmithy(Random random) {
			return new GOTStructureNorvosSmithy(false);
		}

		public GOTStructureBase getStables(Random random) {
			return new GOTStructureNorvosStables(false);
		}

		public GOTStructureBase getStatue(Random random) {
			return new GOTStructureEssosStatue(false);
		}

		public GOTStructureBase getTavern(Random random) {
			return new GOTStructureNorvosTavern(false);
		}

		public GOTStructureBase getTower(Random random) {
			return new GOTStructureNorvosTower(false);
		}

		public GOTStructureNorvosTownGate getTownGate(Random random) {
			return new GOTStructureNorvosTownGate(false);
		}

		public GOTStructureBase getTownWallCorner(Random random) {
			return new GOTStructureEssosTownCorner(false);
		}

		public GOTStructureBase getTownWallExtra(Random random) {
			return new GOTStructureEssosTownWall.Extra(false);
		}

		public GOTStructureBase getTownWallLong(Random random) {
			return new GOTStructureEssosTownWall.Long(false);
		}

		public GOTStructureBase getTownWallShort(Random random) {
			return new GOTStructureEssosTownWall.Short(false);
		}

		public GOTStructureBase getTownWallSideMid(Random random) {
			return new GOTStructureEssosTownWall.SideMid(false);
		}

		public GOTStructureBase getTree(Random random) {
			return new GOTStructureEssosTownTree(false);
		}

		public GOTStructureBase getWell(Random random) {
			return new GOTStructureEssosWell(false);
		}

		@Override
		public boolean isFlat() {
			return false;
		}

		@Override
		public boolean isVillageSurface(World world, int i, int j, int k) {
			return false;
		}

		public void setCivilianSpawnClass(GOTEntityNPCRespawner spawner) {
			spawner.setSpawnClass(GOTEntityNorvosMan.class);
		}

		@Override
		public void setupVillageProperties(Random random) {
			villageType = VillageType.TOWN;
		}

		public void setWarriorSpawnClasses(GOTEntityNPCRespawner spawner) {
			spawner.setSpawnClasses(GOTEntityNorvosWarrior.class, GOTEntityNorvosArcher.class);
		}

	}

	public enum VillageType {
		TOWN;

	}

}
