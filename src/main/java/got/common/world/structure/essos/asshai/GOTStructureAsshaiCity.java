package got.common.world.structure.essos.asshai;

import java.util.Random;

import com.google.common.math.IntMath;

import got.common.entity.essos.asshai.*;
import got.common.entity.other.GOTEntityNPCRespawner;
import got.common.world.biome.GOTBiome;
import got.common.world.map.GOTBezierType;
import got.common.world.structure.other.*;
import net.minecraft.world.World;

public class GOTStructureAsshaiCity extends GOTVillageGen {
	public GOTStructureAsshaiCity(GOTBiome biome, float f) {
		super(biome);
		gridScale = 16;
		gridRandomDisplace = 2;
		spawnChance = f;
		villageChunkSize = 5;
	}

	@Override
	public GOTVillageGen.AbstractInstance createVillageInstance(World world, int i, int k, Random random, GOTLocationInfo loc) {
		return new Instance(this, world, i, k, random, loc);
	}

	public class Instance extends GOTVillageGen.AbstractInstance {
		public VillageType villageType;

		public Instance(GOTStructureAsshaiCity village, World world, int i, int k, Random random, GOTLocationInfo loc) {
			super(village, world, i, k, random, loc);
		}

		@Override
		public void addStructure(GOTStructureBase structure, int x, int z, int r, boolean force) {
			super.addStructure(structure, x, z, r, force);
		}

		@Override
		public void addVillageStructures(Random random) {
			int k1;
			int houseZ;
			boolean outerTavern = random.nextBoolean();
			this.addStructure(new GOTStructureNPCRespawner(false) {

				@Override
				public void setupRespawner(GOTEntityNPCRespawner spawner) {
					spawner.setSpawnClass(GOTEntityAsshaiMan.class);
					spawner.setCheckRanges(80, -12, 12, 100);
					spawner.setSpawnRanges(60, -6, 6, 64);
					spawner.setBlockEnemySpawnRange(60);
				}
			}, 0, 0, 0);
			for (int i1 : new int[] { -40, 40 }) {
				for (int k12 : new int[] { -40, 40 }) {
					this.addStructure(new GOTStructureNPCRespawner(false) {

						@Override
						public void setupRespawner(GOTEntityNPCRespawner spawner) {
							spawner.setSpawnClass(GOTEntityAsshaiGuard.class);
							spawner.setCheckRanges(40, -12, 12, 16);
							spawner.setSpawnRanges(20, -6, 6, 64);
							spawner.setBlockEnemySpawnRange(60);
						}
					}, i1, k12, 0);
				}
			}
			this.addStructure(new GOTStructureAsshaiFort(false), 5, -20, 0, true);
			this.addStructure(new GOTStructureAsshaiTower(false), -27, 24, 0, true);
			this.addStructure(new GOTStructureAsshaiTower(false), 27, 24, 0, true);
			this.addStructure(new GOTStructureAsshaiTower(false), -27, -34, 0, true);
			this.addStructure(new GOTStructureAsshaiTower(false), 27, -34, 0, true);
			int houseX = 24;
			for (k1 = -1; k1 <= 1; ++k1) {
				houseZ = k1 * 12;
				if (k1 == 1) {
					this.addStructure(new GOTStructureAsshaiHouse(false), -houseX, houseZ, 1, true);
					this.addStructure(new GOTStructureAsshaiHouse(false), houseX, houseZ, 3, true);
				}
				if (k1 == 0) {
					continue;
				}
				this.addStructure(new GOTStructureAsshaiHouse(false), houseZ, houseX, 0, true);
				this.addStructure(new GOTStructureAsshaiHouse(false), houseZ, -houseX, 2, true);
			}
			this.addStructure(new GOTStructureAsshaiLaboratory(false), 0, -26, 2, true);
			this.addStructure(new GOTStructureAsshaiTavern(false), -houseX, -5, 1, true);
			this.addStructure(new GOTStructureAsshaiOblivionAltar(false), houseX + 2, -6, 3, true);
			houseX = 54;
			for (k1 = -2; k1 <= 2; ++k1) {
				houseZ = k1 * 12;
				if (k1 <= -2 || k1 >= 1) {
					this.addStructure(new GOTStructureAsshaiHouse(false), -houseX, houseZ, 3, true);
					this.addStructure(new GOTStructureAsshaiHouse(false), houseX, houseZ, 1, true);
				}
				this.addStructure(new GOTStructureAsshaiHouse(false), houseZ, houseX, 2, true);
				this.addStructure(new GOTStructureAsshaiHouse(false), houseZ, -houseX, 0, true);
			}
			houseX = 64;
			for (int k13 = -4; k13 <= 4; ++k13) {
				int houseZ2 = k13 * 12;
				boolean treepiece = IntMath.mod(k13, 2) == 1;
				if (treepiece) {
					this.addStructure(new GOTStructureAsshaiHouse(false), -houseX - 2, houseZ2, 1, true);
					this.addStructure(new GOTStructureAsshaiHouse(false), houseX + 2, houseZ2, 3, true);
				} else {
					this.addStructure(new GOTStructureAsshaiHouse(false), -houseX, houseZ2, 1, true);
					this.addStructure(new GOTStructureAsshaiHouse(false), houseX, houseZ2, 3, true);
				}
				if (treepiece) {
					this.addStructure(new GOTStructureAsshaiHouse(false), houseZ2, -houseX - 2, 2, true);
				} else {
					this.addStructure(new GOTStructureAsshaiHouse(false), houseZ2, -houseX, 2, true);
				}
				if (Math.abs(k13) < 2 || outerTavern && k13 > 2) {
					continue;
				}
				if (treepiece) {
					this.addStructure(new GOTStructureAsshaiHouse(false), houseZ2, houseX + 2, 0, true);
					continue;
				}
				this.addStructure(new GOTStructureAsshaiHouse(false), houseZ2, houseX, 0, true);
			}
			if (outerTavern) {
				this.addStructure(new GOTStructureAsshaiTavern(false), 44, houseX, 0, true);
			}
			int gardenX = 42;
			int gardenZ = 48;
			this.addStructure(new GOTStructureAsshaiHouse(false), -gardenX, -gardenZ, 1, true);
			this.addStructure(new GOTStructureAsshaiHouse(false), -gardenX, gardenZ, 1, true);
			this.addStructure(new GOTStructureAsshaiHouse(false), gardenX, -gardenZ, 3, true);
			this.addStructure(new GOTStructureAsshaiHouse(false), gardenX, gardenZ, 3, true);
		}

		@Override
		public GOTBezierType getPath(Random random, int i, int k) {
			return null;
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
