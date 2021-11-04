package got.common.world.structure.westeros.targaryen;

import java.util.Random;

import com.google.common.math.IntMath;

import got.common.entity.other.GOTEntityNPCRespawner;
import got.common.entity.westeros.targaryen.*;
import got.common.world.biome.GOTBiome;
import got.common.world.map.GOTBezierType;
import got.common.world.structure.other.*;
import got.common.world.structure.westeros.common.*;
import net.minecraft.world.World;

public class GOTWaypointTargaryenTown extends GOTVillageGen {
	public GOTWaypointTargaryenTown(GOTBiome biome, float f) {
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

		public Instance(GOTWaypointTargaryenTown village, World world, int i, int k, Random random, GOTLocationInfo loc) {
			super(village, world, i, k, random, loc);
		}

		@Override
		public void addStructure(GOTStructureBase structure, int x, int z, int r, boolean force) {
			super.addStructure(structure, x, z, r, force);
		}

		@Override
		public void addVillageStructures(Random random) {
			boolean outerTavern = random.nextBoolean();
			this.addStructure(new GOTStructureNPCRespawner(false) {

				@Override
				public void setupRespawner(GOTEntityNPCRespawner spawner) {
					spawner.setSpawnClass(GOTEntityTargaryenMan.class);
					spawner.setCheckRanges(80, -12, 12, 100);
					spawner.setSpawnRanges(60, -6, 6, 64);
					spawner.setBlockEnemySpawnRange(60);
				}
			}, 0, 0, 0);
			for (int i1 : new int[] { -40, 40 }) {
				int[] arrn = new int[] { -40, 40 };
				int n = arrn.length;
				for (int i = 0; i < n; ++i) {
					int k1 = arrn[i];
					this.addStructure(new GOTStructureNPCRespawner(false) {

						@Override
						public void setupRespawner(GOTEntityNPCRespawner spawner) {
							spawner.setSpawnClass(GOTEntityTargaryenSoldier.class);
							spawner.setCheckRanges(40, -12, 12, 16);
							spawner.setSpawnRanges(20, -6, 6, 64);
							spawner.setBlockEnemySpawnRange(60);
						}
					}, i1, k1, 0);
				}
			}
			this.addStructure(new GOTStructureWesterosWell(false), 0, -4, 0, true);
			int stallPos = 12;
			for (int k1 = -1; k1 <= 1; ++k1) {
				int k2 = k1 * stallPos;
				if (random.nextInt(3) != 0) {
					this.addStructure(GOTStructureTargaryenMarketStall.getRandomStall(random, false), -stallPos + 3, k2, 1, true);
				}
				if (random.nextInt(3) == 0) {
					continue;
				}
				this.addStructure(GOTStructureTargaryenMarketStall.getRandomStall(random, false), stallPos - 3, k2, 3, true);
			}
			if (random.nextInt(3) != 0) {
				this.addStructure(GOTStructureTargaryenMarketStall.getRandomStall(random, false), 0, stallPos - 3, 0, true);
			}
			if (random.nextInt(3) != 0) {
				this.addStructure(GOTStructureTargaryenMarketStall.getRandomStall(random, false), 0, -stallPos + 3, 2, true);
			}
			int flowerX = 12;
			int flowerZ = 18;
			for (int i1 : new int[] { -flowerX, flowerX }) {
				this.addStructure(new GOTStructureWesterosTownGarden(false), i1, flowerZ, 0, true);
				this.addStructure(new GOTStructureWesterosTownGarden(false), i1, -flowerZ, 2, true);
				this.addStructure(new GOTStructureWesterosTownGarden(false), -flowerZ, i1, 1, true);
				this.addStructure(new GOTStructureWesterosTownGarden(false), flowerZ, i1, 3, true);
			}
			int lampZ = 21;
			for (int i1 : new int[] { -1, 1 }) {
				int lampX = i1 * 6;
				this.addStructure(new GOTStructureWesterosLampPost(false), lampX, lampZ, 0, true);
				this.addStructure(new GOTStructureWesterosLampPost(false), lampX, -lampZ, 2, true);
				if (i1 != -1) {
					this.addStructure(new GOTStructureWesterosLampPost(false), -lampZ, lampX, 1, true);
				}
				this.addStructure(new GOTStructureWesterosLampPost(false), lampZ, lampX, 3, true);
			}
			int houseX = 24;
			for (int k1 = -1; k1 <= 1; ++k1) {
				int houseZ = k1 * 12;
				if (k1 == 1) {
					this.addStructure(new GOTStructureTargaryenStoneHouse(false), -houseX, houseZ, 1, true);
					this.addStructure(new GOTStructureTargaryenStoneHouse(false), houseX, houseZ, 3, true);
				}
				if (k1 == 0) {
					continue;
				}
				this.addStructure(new GOTStructureTargaryenStoneHouse(false), houseZ, houseX, 0, true);
				this.addStructure(new GOTStructureTargaryenStoneHouse(false), houseZ, -houseX, 2, true);
			}
			this.addStructure(new GOTStructureTargaryenSmithy(false), 0, -26, 2, true);
			this.addStructure(new GOTStructureWesterosObelisk(false), 0, 27, 0, true);
			this.addStructure(new GOTStructureTargaryenTavern(false), -houseX, -5, 1, true);
			this.addStructure(new GOTStructureWesterosTownTrees(false), -47, -13, 2, true);
			this.addStructure(new GOTStructureWesterosTownTrees(false), -47, 1, 0, true);
			for (int i1 : new int[] { -43, -51 }) {
				this.addStructure(new GOTStructureWesterosTownBench(false), i1, -9, 2, true);
				this.addStructure(new GOTStructureWesterosTownBench(false), i1, -3, 0, true);
			}
			this.addStructure(new GOTStructureTargaryenBath(false), houseX + 2, -6, 3, true);
			this.addStructure(new GOTStructureWesterosTownGarden(false), 51, -13, 2, true);
			this.addStructure(new GOTStructureWesterosTownGarden(false), 51, 1, 0, true);
			this.addStructure(new GOTStructureWesterosTownGarden(false), 52, -6, 3, true);
			int wellX = 22;
			int wellZ = 31;
			for (int i1 : new int[] { -wellX, wellX }) {
				this.addStructure(new GOTStructureWesterosWell(false), i1, -wellZ, 2, true);
				this.addStructure(new GOTStructureWesterosWell(false), i1, wellZ, 0, true);
				this.addStructure(new GOTStructureWesterosWell(false), -wellZ, i1, 1, true);
				this.addStructure(new GOTStructureWesterosWell(false), wellZ, i1, 3, true);
			}
			houseX = 54;
			for (int k1 = -2; k1 <= 2; ++k1) {
				int houseZ = k1 * 12;
				if (k1 <= -2 || k1 >= 1) {
					this.addStructure(new GOTStructureTargaryenStoneHouse(false), -houseX, houseZ, 3, true);
					this.addStructure(new GOTStructureTargaryenStoneHouse(false), houseX, houseZ, 1, true);
				}
				this.addStructure(new GOTStructureTargaryenStoneHouse(false), houseZ, houseX, 2, true);
				this.addStructure(new GOTStructureTargaryenStoneHouse(false), houseZ, -houseX, 0, true);
			}
			int treeX = 47;
			int treeZ = 35;
			for (int i1 : new int[] { -treeX, treeX }) {
				this.addStructure(new GOTStructureWesterosTownTrees(false), i1, -treeZ, 0, true);
				this.addStructure(new GOTStructureWesterosTownTrees(false), i1, treeZ, 2, true);
				this.addStructure(new GOTStructureWesterosTownTrees(false), -treeZ, i1, 3, true);
				this.addStructure(new GOTStructureWesterosTownTrees(false), treeZ, i1, 1, true);
			}
			houseX = 64;
			int lampX = 59;
			for (int k1 = -4; k1 <= 4; ++k1) {
				boolean treepiece;
				int houseZ = k1 * 12;
				treepiece = IntMath.mod(k1, 2) == 1;
				if (treepiece) {
					this.addStructure(new GOTStructureTargaryenVillageFarm.Tree(false), -houseX - 2, houseZ, 1, true);
					this.addStructure(new GOTStructureTargaryenVillageFarm.Tree(false), houseX + 2, houseZ, 3, true);
				} else {
					this.addStructure(new GOTStructureTargaryenStoneHouse(false), -houseX, houseZ, 1, true);
					this.addStructure(new GOTStructureTargaryenStoneHouse(false), houseX, houseZ, 3, true);
				}
				if (treepiece) {
					this.addStructure(new GOTStructureTargaryenVillageFarm.Tree(false), houseZ, -houseX - 2, 2, true);
				} else {
					this.addStructure(new GOTStructureTargaryenStoneHouse(false), houseZ, -houseX, 2, true);
				}
				if (Math.abs(k1) >= 2 && (!outerTavern || k1 <= 2)) {
					if (treepiece) {
						this.addStructure(new GOTStructureTargaryenVillageFarm.Tree(false), houseZ, houseX + 2, 0, true);
					} else {
						this.addStructure(new GOTStructureTargaryenStoneHouse(false), houseZ, houseX, 0, true);
					}
				}
				this.addStructure(new GOTStructureWesterosLampPost(false), -lampX, houseZ, 1, true);
				this.addStructure(new GOTStructureWesterosLampPost(false), lampX, houseZ, 3, true);
				this.addStructure(new GOTStructureWesterosLampPost(false), houseZ, lampX, 0, true);
				this.addStructure(new GOTStructureWesterosLampPost(false), houseZ, -lampX, 2, true);
			}
			if (outerTavern) {
				this.addStructure(new GOTStructureTargaryenTavern(false), 44, houseX, 0, true);
			}
			int gardenX = 42;
			int gardenZ = 48;
			this.addStructure(new GOTStructureTargaryenVillageFarm.Tree(false), -gardenX, -gardenZ, 1, true);
			this.addStructure(new GOTStructureTargaryenVillageFarm.Tree(false), -gardenX, gardenZ, 1, true);
			this.addStructure(new GOTStructureTargaryenVillageFarm.Tree(false), gardenX, -gardenZ, 3, true);
			this.addStructure(new GOTStructureTargaryenVillageFarm.Tree(false), gardenX, gardenZ, 3, true);
			int obeliskX = 62;
			int obeliskZ = 66;
			this.addStructure(new GOTStructureWesterosObelisk(false), -obeliskX, -obeliskZ, 1, true);
			this.addStructure(new GOTStructureWesterosObelisk(false), -obeliskX, obeliskZ, 1, true);
			this.addStructure(new GOTStructureWesterosObelisk(false), obeliskX, -obeliskZ, 3, true);
			this.addStructure(new GOTStructureWesterosObelisk(false), obeliskX, obeliskZ, 3, true);
			wellX = 64;
			wellZ = 57;
			this.addStructure(new GOTStructureWesterosWell(false), -wellX, -wellZ, 1, true);
			this.addStructure(new GOTStructureWesterosWell(false), -wellX, wellZ, 1, true);
			this.addStructure(new GOTStructureWesterosWell(false), wellX, -wellZ, 3, true);
			this.addStructure(new GOTStructureWesterosWell(false), wellX, wellZ, 3, true);
			this.addStructure(new GOTStructureWesterosWell(false), -wellZ, -wellX, 2, true);
			this.addStructure(new GOTStructureWesterosWell(false), wellZ, -wellX, 2, true);
			this.addStructure(new GOTStructureWesterosWell(false), -wellZ, wellX, 0, true);
			this.addStructure(new GOTStructureWesterosWell(false), wellZ, wellX, 0, true);
			treeX = 75;
			treeZ = 61;
			this.addStructure(new GOTStructureWesterosTownTrees(false), -treeX, -treeZ, 1, true);
			this.addStructure(new GOTStructureWesterosTownTrees(false), -treeX, treeZ, 1, true);
			this.addStructure(new GOTStructureWesterosTownTrees(false), treeX, -treeZ, 3, true);
			this.addStructure(new GOTStructureWesterosTownTrees(false), treeX, treeZ, 3, true);
			this.addStructure(new GOTStructureWesterosTownTrees(false), -treeZ, -treeX, 2, true);
			this.addStructure(new GOTStructureWesterosTownTrees(false), treeZ, -treeX, 2, true);
			this.addStructure(new GOTStructureWesterosTownTrees(false), -treeZ, treeX, 0, true);
			this.addStructure(new GOTStructureWesterosTownTrees(false), treeZ, treeX, 0, true);
			this.addStructure(new GOTStructureWesterosTownTrees(false), -14, 71, 1, true);
			this.addStructure(new GOTStructureWesterosTownTrees(false), 14, 71, 3, true);
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