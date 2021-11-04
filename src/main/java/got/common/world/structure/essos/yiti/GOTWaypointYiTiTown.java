package got.common.world.structure.essos.yiti;

import java.util.Random;

import got.common.entity.essos.yiti.*;
import got.common.entity.other.GOTEntityNPCRespawner;
import got.common.world.biome.GOTBiome;
import got.common.world.map.GOTBezierType;
import got.common.world.structure.other.*;
import net.minecraft.world.World;

public class GOTWaypointYiTiTown extends GOTVillageGen {
	public GOTWaypointYiTiTown(GOTBiome biome, float f) {
		super(biome);
		gridScale = 14;
		gridRandomDisplace = 1;
		spawnChance = f;
		villageChunkSize = 6;
	}

	@Override
	public GOTVillageGen.AbstractInstance createVillageInstance(World world, int i, int k, Random random, GOTLocationInfo loc) {
		return new Instance(this, world, i, k, random, loc);
	}

	public class Instance extends GOTVillageGen.AbstractInstance {
		public VillageType villageType;

		public Instance(GOTWaypointYiTiTown village, World world, int i, int k, Random random, GOTLocationInfo loc) {
			super(village, world, i, k, random, loc);
		}

		@Override
		public void addVillageStructures(Random random) {
			int marketZ;
			this.addStructure(new GOTStructureNPCRespawner(false) {

				@Override
				public void setupRespawner(GOTEntityNPCRespawner spawner) {
					spawner.setSpawnClass(GOTEntityYiTiMan.class);
					spawner.setCheckRanges(80, -12, 12, 100);
					spawner.setSpawnRanges(60, -6, 6, 64);
					spawner.setBlockEnemySpawnRange(60);
				}
			}, 0, 0, 0);
			int spawnerX = 60;
			for (int i1 : new int[] { -spawnerX, spawnerX }) {
				for (int k1 : new int[] { -spawnerX, spawnerX }) {
					this.addStructure(new GOTStructureNPCRespawner(false) {

						@Override
						public void setupRespawner(GOTEntityNPCRespawner spawner) {
							spawner.setSpawnClasses(GOTEntityYiTiWarrior.class, GOTEntityYiTiArcher.class);
							spawner.setCheckRanges(50, -12, 12, 16);
							spawner.setSpawnRanges(20, -6, 6, 64);
							spawner.setBlockEnemySpawnRange(60);
						}
					}, i1, k1, 0);
				}
			}
			if (random.nextBoolean()) {
				this.addStructure(new GOTStructureYiTiGarden(false), 0, 10, 2, true);
			} else {
				this.addStructure(new GOTStructureYiTiStatue(false), 0, 6, 2, true);
			}
			int mansionX = 12;
			int mansionZ = 20;
			this.addStructure(new GOTStructureYiTiLargeTownHouse(false), -mansionX, -mansionZ, 2, true);
			this.addStructure(new GOTStructureYiTiLargeTownHouse(false), mansionX, -mansionZ, 2, true);
			this.addStructure(new GOTStructureYiTiLargeTownHouse(false), -mansionX, mansionZ, 0, true);
			this.addStructure(new GOTStructureYiTiLargeTownHouse(false), mansionX, mansionZ, 0, true);
			this.addStructure(new GOTStructureYiTiLargeTownHouse(false), -mansionZ, -mansionX, 1, true);
			this.addStructure(new GOTStructureYiTiLargeTownHouse(false), -mansionZ, mansionX, 1, true);
			this.addStructure(new GOTStructureYiTiLargeTownHouse(false), mansionZ, -mansionX, 3, true);
			this.addStructure(new GOTStructureYiTiLargeTownHouse(false), mansionZ, mansionX, 3, true);
			for (int l = 0; l <= 3; ++l) {
				int houseX = 10 + 14 * l;
				int houseZ1 = 58;
				int houseZ2 = 68;
				if (l <= 2) {
					if (l >= 1 && l <= 2) {
						if (l == 1) {
							this.addStructure(new GOTStructureYiTiTavernTown(false), -houseX - 7, -houseZ1, 0, true);
						}
					} else {
						this.addStructure(new GOTStructureYiTiTownHouse(false), -houseX, -houseZ1, 0, true);
					}
					this.addStructure(new GOTStructureYiTiTownHouse(false), houseX, -houseZ1, 0, true);
					if (l >= 1) {
						this.addStructure(new GOTStructureYiTiTownHouse(false), -houseX, houseZ1, 2, true);
						this.addStructure(new GOTStructureYiTiTownHouse(false), houseX, houseZ1, 2, true);
					}
					this.addStructure(new GOTStructureYiTiTownHouse(false), -houseZ1, -houseX, 3, true);
					this.addStructure(new GOTStructureYiTiTownHouse(false), -houseZ1, houseX, 3, true);
					this.addStructure(new GOTStructureYiTiTownHouse(false), houseZ1, -houseX, 1, true);
					this.addStructure(new GOTStructureYiTiTownHouse(false), houseZ1, houseX, 1, true);
				}
				if (l == 1) {
					this.addStructure(new GOTStructureYiTiVillageFarm.Tree(false), -houseX, -houseZ2, 2, true);
					this.addStructure(new GOTStructureYiTiVillageFarm.Tree(false), houseX, -houseZ2, 2, true);
					this.addStructure(new GOTStructureYiTiVillageFarm.Tree(false), -houseX, houseZ2, 0, true);
					this.addStructure(new GOTStructureYiTiVillageFarm.Tree(false), houseX, houseZ2, 0, true);
					this.addStructure(new GOTStructureYiTiVillageFarm.Tree(false), -houseZ2, -houseX, 1, true);
					this.addStructure(new GOTStructureYiTiVillageFarm.Tree(false), -houseZ2, houseX, 1, true);
					this.addStructure(new GOTStructureYiTiVillageFarm.Tree(false), houseZ2, -houseX, 3, true);
					this.addStructure(new GOTStructureYiTiVillageFarm.Tree(false), houseZ2, houseX, 3, true);
					continue;
				}
				this.addStructure(new GOTStructureYiTiTownHouse(false), -houseX, -houseZ2, 2, true);
				this.addStructure(l == 3 ? new GOTStructureYiTiSmithy(false) : new GOTStructureYiTiTownHouse(false), houseX, -houseZ2, 2, true);
				this.addStructure(new GOTStructureYiTiTownHouse(false), -houseX, houseZ2, 0, true);
				this.addStructure(new GOTStructureYiTiTownHouse(false), houseX, houseZ2, 0, true);
				this.addStructure(new GOTStructureYiTiTownHouse(false), -houseZ2, -houseX, 1, true);
				this.addStructure(new GOTStructureYiTiTownHouse(false), -houseZ2, houseX, 1, true);
				this.addStructure(new GOTStructureYiTiTownHouse(false), houseZ2, -houseX, 3, true);
				this.addStructure(new GOTStructureYiTiTownHouse(false), houseZ2, houseX, 3, true);
			}
			int marketX = 4;
			for (int l = 0; l <= 2; ++l) {
				marketZ = 56 - l * 7;
				this.addStructure(GOTStructureYiTiMarketStall.getRandomStall(random, false), -marketX, marketZ, 1, true);
				this.addStructure(GOTStructureYiTiMarketStall.getRandomStall(random, false), marketX, marketZ, 3, true);
			}
			marketX = 14;
			marketZ = 59;
			this.addStructure(GOTStructureYiTiMarketStall.getRandomStall(random, false), -marketX, marketZ, 2, true);
			this.addStructure(GOTStructureYiTiMarketStall.getRandomStall(random, false), marketX, marketZ, 2, true);
			int gardenX = 58;
			this.addStructure(new GOTStructureYiTiVillageFarm.Tree(false), -gardenX + 5, -gardenX, 0, true);
			this.addStructure(new GOTStructureYiTiVillageFarm.Tree(false), gardenX - 5, -gardenX, 0, true);
			this.addStructure(new GOTStructureYiTiVillageFarm.Tree(false), -gardenX + 5, gardenX, 2, true);
			this.addStructure(new GOTStructureYiTiVillageFarm.Tree(false), gardenX - 5, gardenX, 2, true);
			int wellX = 69;
			int wellZ = 63;
			this.addStructure(new GOTStructureYiTiWell(false), -wellX, -wellZ, 1, true);
			this.addStructure(new GOTStructureYiTiWell(false), -wellZ, -wellX, 2, true);
			this.addStructure(new GOTStructureYiTiWell(false), wellX, -wellZ, 3, true);
			this.addStructure(new GOTStructureYiTiWell(false), wellZ, -wellX, 2, true);
			this.addStructure(new GOTStructureYiTiWell(false), -wellX, wellZ, 1, true);
			this.addStructure(new GOTStructureYiTiWell(false), -wellZ, wellX, 0, true);
			this.addStructure(new GOTStructureYiTiWell(false), wellX, wellZ, 3, true);
			this.addStructure(new GOTStructureYiTiWell(false), wellZ, wellX, 0, true);
		}

		public GOTStructureBase getOtherVillageStructure(Random random) {
			if (random.nextBoolean()) {
				return new GOTStructureYiTiStables(false);
			}
			return new GOTStructureYiTiSmithy(false);
		}

		@Override
		public GOTBezierType getPath(Random random, int i, int k) {
			return null;
		}

		public GOTStructureBase getRandomHouse(Random random) {
			return new GOTStructureYiTiHouse(false);
		}

		public GOTStructureBase getRandomVillageFarm(Random random) {
			if (random.nextBoolean()) {
				return new GOTStructureYiTiVillageFarm.Animals(false);
			}
			return new GOTStructureYiTiVillageFarm.Crops(false);
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
			villageType = VillageType.TOWN;
		}
	}

	public enum VillageType {
		TOWN;
	}
}