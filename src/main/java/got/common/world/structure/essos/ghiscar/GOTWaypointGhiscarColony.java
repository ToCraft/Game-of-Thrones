package got.common.world.structure.essos.ghiscar;

import java.util.Random;

import got.common.entity.essos.ghiscar.GOTEntityGhiscarCorsair;
import got.common.entity.other.GOTEntityNPCRespawner;
import got.common.world.biome.GOTBiome;
import got.common.world.map.GOTBezierType;
import got.common.world.structure.essos.common.*;
import got.common.world.structure.other.*;
import net.minecraft.world.World;

public class GOTWaypointGhiscarColony extends GOTVillageGen {
	public GOTWaypointGhiscarColony(GOTBiome biome, float f) {
		super(biome);
		gridScale = 14;
		gridRandomDisplace = 1;
		spawnChance = f;
		villageChunkSize = 5;
	}

	@Override
	public GOTVillageGen.AbstractInstance createVillageInstance(World world, int i, int k, Random random, GOTLocationInfo loc) {
		return new Instance(this, world, i, k, random, loc);
	}

	public class Instance extends GOTVillageGen.AbstractInstance {
		public VillageType villageType;

		public Instance(GOTWaypointGhiscarColony village, World world, int i, int k, Random random, GOTLocationInfo loc) {
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
					spawner.setCheckRanges(60, -12, 12, 16);
					spawner.setSpawnRanges(24, -6, 6, 40);
					spawner.setBlockEnemySpawnRange(60);
				}
			}, 0, 0, 0);
			for (int i1 : new int[] { -25, 25 }) {
				for (int k1 : new int[] { -25, 25 }) {
					this.addStructure(new GOTStructureNPCRespawner(false) {

						@Override
						public void setupRespawner(GOTEntityNPCRespawner spawner) {
							Instance.this.setWarriorSpawnClasses(spawner);
							spawner.setCheckRanges(35, -12, 12, 16);
							spawner.setSpawnRanges(15, -6, 6, 40);
							spawner.setBlockEnemySpawnRange(35);
						}
					}, i1, k1, 0);
				}
			}
			placeChampionRespawner();
			this.addStructure(getFortress(random), 0, -15, 0, true);
			this.addStructure(getBarracks(random), -33, -8, 0, true);
			this.addStructure(getBarracks(random), 32, -8, 0, true);
			this.addStructure(getTower(random), -43, -36, 2, true);
			this.addStructure(getTower(random), 43, -36, 2, true);
			this.addStructure(getTower(random), -43, 36, 0, true);
			this.addStructure(getTower(random), 43, 36, 0, true);
			for (l = 0; l <= 2; ++l) {
				i = 10 + l * 11;
				k = -28;
				r = 2;
				this.addStructure(getRandomFarm(random), i, k, r);
				this.addStructure(getRandomFarm(random), -i, k, r);
			}
			this.addStructure(getTraining(random), 0, 27, 0, true);
			this.addStructure(getStables(random), -29, 33, 3, true);
			this.addStructure(getStables(random), 29, 37, 1, true);
			this.addStructure(getFortGate(random), 0, -47, 0, true);
			for (l = 0; l <= 9; ++l) {
				i = 8 + l * 4;
				k = -46;
				r = 0;
				if (l % 2 == 0) {
				}
				this.addStructure(getFortWallLong(random), -i, k, r, true);
				this.addStructure(getFortWallLong(random), i, k, r, true);
			}
			for (l = -11; l <= 11; ++l) {
				i = l * 4;
				k = 46;
				r = 2;
				if (l % 2 == 0) {
				}
				this.addStructure(getFortWallLong(random), i, k, r, true);
			}
			for (l = -10; l <= 10; ++l) {
				i = -50;
				k = l * 4;
				r = 3;
				if (l % 2 == 0) {
					this.addStructure(getFortWallLong(random), i, k, r, true);
				} else {
					this.addStructure(getFortWallLong(random), i, k, r, true);
				}
				r = 1;
				if (l % 2 == 0) {
				}
				this.addStructure(getFortWallLong(random), -i, k, r, true);
			}
			this.addStructure(getFortCorner(random), -50, -46, 0, true);
			this.addStructure(getFortCorner(random), 50, -46, 1, true);
			this.addStructure(getFortCorner(random), -50, 46, 3, true);
			this.addStructure(getFortCorner(random), 50, 46, 2, true);
		}

		public GOTStructureBase getBarracks(Random random) {
			return new GOTStructureGhiscarBarracks(false);
		}

		public GOTStructureBase getBazaar(Random random) {
			return new GOTStructureGhiscarBazaar(false);
		}

		public GOTStructureBase getFlowers(Random random) {
			return new GOTStructureEssosTownFlowers(false);
		}

		public GOTStructureBase getFortCorner(Random random) {
			return new GOTStructureEssosFortCorner(false);
		}

		public GOTStructureBase getFortGate(Random random) {
			return new GOTStructureGhiscarFortGate(false);
		}

		public GOTStructureBase getFortress(Random random) {
			return new GOTStructureGhiscarFortress(false);
		}

		public GOTStructureBase getFortWallLong(Random random) {
			return new GOTStructureEssosFortWall.Long(false);
		}

		public GOTStructureBase getFortWallShort(Random random) {
			return new GOTStructureEssosFortWall.Short(false);
		}

		public GOTStructureBase getHouse(Random random) {
			return new GOTStructureGhiscarHouse(false);
		}

		public GOTStructureBase getLamp(Random random) {
			return new GOTStructureEssosLamp(false);
		}

		public GOTStructureBase getMansion(Random random) {
			return new GOTStructureGhiscarMansion(false);
		}

		@Override
		public GOTBezierType getPath(Random random, int i, int k) {
			return null;
		}

		public GOTStructureBase getRandomFarm(Random random) {
			if (random.nextBoolean()) {
				return new GOTStructureGhiscarFarm(false);
			}
			return new GOTStructureGhiscarPasture(false);
		}

		public GOTStructureBase getRandomHouse(Random random) {
			if (random.nextInt(6) == 0) {
				return new GOTStructureGhiscarSmithy(false);
			}
			if (random.nextInt(6) == 0) {
				return new GOTStructureGhiscarStables(false);
			}
			return new GOTStructureGhiscarHouse(false);
		}

		public GOTStructureBase getSmithy(Random random) {
			return new GOTStructureGhiscarSmithy(false);
		}

		public GOTStructureBase getStables(Random random) {
			return new GOTStructureGhiscarStables(false);
		}

		public GOTStructureBase getStatue(Random random) {
			return new GOTStructureEssosStatue(false);
		}

		public GOTStructureBase getTavern(Random random) {
			return new GOTStructureGhiscarTavern(false);
		}

		public GOTStructureBase getTower(Random random) {
			return new GOTStructureGhiscarTower(false);
		}

		public GOTStructureGhiscarTownGate getTownGate(Random random) {
			return new GOTStructureGhiscarTownGate(false);
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

		public GOTStructureBase getTraining(Random random) {
			return new GOTStructureGhiscarTraining(false);
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

		public void placeChampionRespawner() {
			this.addStructure(new GOTStructureNPCRespawner(false) {

				@Override
				public void setupRespawner(GOTEntityNPCRespawner spawner) {
					spawner.setSpawnClass(GOTEntityGhiscarCorsair.class);
					spawner.setCheckRanges(60, -12, 12, 4);
					spawner.setSpawnRanges(24, -6, 6, 32);
				}
			}, 0, 0, 0);
		}

		public void setCivilianSpawnClass(GOTEntityNPCRespawner spawner) {
			spawner.setSpawnClass(GOTEntityGhiscarCorsair.class);
		}

		@Override
		public void setupVillageProperties(Random random) {
			villageType = VillageType.TOWN;
		}

		public void setWarriorSpawnClasses(GOTEntityNPCRespawner spawner) {
			spawner.setSpawnClasses(GOTEntityGhiscarCorsair.class, GOTEntityGhiscarCorsair.class);
		}

	}

	public enum VillageType {
		TOWN;

	}

}
