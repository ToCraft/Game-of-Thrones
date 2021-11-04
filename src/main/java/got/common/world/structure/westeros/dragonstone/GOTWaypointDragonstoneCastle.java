package got.common.world.structure.westeros.dragonstone;

import java.util.Random;

import got.common.entity.other.GOTEntityNPCRespawner;
import got.common.entity.westeros.dragonstone.GOTEntityDragonstoneSoldier;
import got.common.world.biome.GOTBiome;
import got.common.world.map.GOTBezierType;
import got.common.world.structure.other.*;
import got.common.world.structure.westeros.common.*;
import net.minecraft.world.World;

public class GOTWaypointDragonstoneCastle extends GOTVillageGen {
	public GOTWaypointDragonstoneCastle(GOTBiome biome, float f) {
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

		public Instance(GOTWaypointDragonstoneCastle village, World world, int i, int k, Random random, GOTLocationInfo loc) {
			super(village, world, i, k, random, loc);
		}

		@Override
		public void addStructure(GOTStructureBase structure, int x, int z, int r, boolean force) {
			super.addStructure(structure, x, z, r, force);
		}

		@Override
		public void addVillageStructures(Random random) {
			this.addStructure(new GOTStructureNPCRespawner(false) {

				@Override
				public void setupRespawner(GOTEntityNPCRespawner spawner) {
					spawner.setSpawnClass(GOTEntityDragonstoneSoldier.class);
					spawner.setCheckRanges(50, -12, 12, 16);
					spawner.setSpawnRanges(30, -6, 6, 40);
					spawner.setBlockEnemySpawnRange(60);
				}
			}, 0, 0, 0);
			for (int i1 : new int[] { -20, 20 }) {
				for (int k1 : new int[] { -20, 20 }) {
					this.addStructure(new GOTStructureNPCRespawner(false) {

						@Override
						public void setupRespawner(GOTEntityNPCRespawner spawner) {
							spawner.setSpawnClass(GOTEntityDragonstoneSoldier.class);
							spawner.setCheckRanges(20, -12, 12, 16);
							spawner.setSpawnRanges(20, -6, 6, 40);
							spawner.setBlockEnemySpawnRange(40);
						}
					}, i1, k1, 0);
				}
			}
			this.addStructure(new GOTStructureDragonstoneFortress(false), 0, 12, 2, true);
			this.addStructure(new GOTStructureWesterosFortGate(false), 0, -37, 0, true);
			this.addStructure(new GOTStructureWesterosFortWall.Right(false), -11, -37, 0, true);
			this.addStructure(new GOTStructureWesterosFortWall.Left(false), 11, -37, 0, true);
			this.addStructure(new GOTStructureDragonstoneWatchtower(false), -23, -33, 2, true);
			this.addStructure(new GOTStructureDragonstoneWatchtower(false), 23, -33, 2, true);
			this.addStructure(new GOTStructureWesterosFortGate(false), -37, 0, 3, true);
			this.addStructure(new GOTStructureWesterosFortWall.Left(false), -37, -11, 3, true);
			this.addStructure(new GOTStructureWesterosFortWall.Right(false), -37, 11, 3, true);
			this.addStructure(new GOTStructureDragonstoneWatchtower(false), -33, -23, 1, true);
			this.addStructure(new GOTStructureDragonstoneWatchtower(false), -33, 23, 1, true);
			this.addStructure(new GOTStructureWesterosFortGate(false), 0, 37, 2, true);
			this.addStructure(new GOTStructureWesterosFortWall.Left(false), -11, 37, 2, true);
			this.addStructure(new GOTStructureWesterosFortWall.Right(false), 11, 37, 2, true);
			this.addStructure(new GOTStructureDragonstoneWatchtower(false), -23, 33, 0, true);
			this.addStructure(new GOTStructureDragonstoneWatchtower(false), 23, 33, 0, true);
			this.addStructure(new GOTStructureWesterosFortGate(false), 37, 0, 1, true);
			this.addStructure(new GOTStructureWesterosFortWall.Right(false), 37, -11, 1, true);
			this.addStructure(new GOTStructureWesterosFortWall.Left(false), 37, 11, 1, true);
			this.addStructure(new GOTStructureDragonstoneWatchtower(false), 33, -23, 3, true);
			this.addStructure(new GOTStructureDragonstoneWatchtower(false), 33, 23, 3, true);
			this.addStructure(new GOTStructureWesterosFortWallCorner(false), -30, -30, 3);
			this.addStructure(new GOTStructureWesterosFortWallCorner(false), -30, 30, 2);
			this.addStructure(new GOTStructureWesterosFortWallCorner(false), 30, 30, 1);
			this.addStructure(new GOTStructureWesterosFortWallCorner(false), 30, -30, 2);
			this.addStructure(new GOTStructureDragonstoneStables(false), -24, 2, 0);
			this.addStructure(new GOTStructureDragonstoneStables(false), -24, -2, 2);
			this.addStructure(new GOTStructureDragonstoneSmithy(false), 24, 1, 0);
			this.addStructure(new GOTStructureDragonstoneSmithy(false), 24, -1, 2);
			this.addStructure(new GOTStructureDragonstoneStoneHouse(false), -3, -25, 1);
			this.addStructure(new GOTStructureDragonstoneStoneHouse(false), 3, -25, 3);
			this.addStructure(new GOTStructureDragonstoneVillageFarm.Crops(false), -18, -21, 1);
			this.addStructure(new GOTStructureDragonstoneVillageFarm.Crops(false), 18, -21, 3);
			this.addStructure(new GOTStructureWesterosWell(false), -12, 27, 1);
			this.addStructure(new GOTStructureWesterosWell(false), 12, 27, 3);
		}

		@Override
		public GOTBezierType getPath(Random random, int i, int k) {
			int i1 = Math.abs(i);
			int k1 = Math.abs(k);
			if (villageType == VillageType.FORT) {
				if (i1 <= 1 && (k >= 13 || k <= -12) && k1 <= 36) {
					return GOTBezierType.WESTEROS_PATH;
				}
				if (k1 <= 1 && i1 >= 12 && i1 <= 36) {
					return GOTBezierType.WESTEROS_PATH;
				}
				if (k >= 26 && k <= 28 && i1 <= 12) {
					return GOTBezierType.WESTEROS_PATH;
				}
			}
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
			villageType = VillageType.FORT;
		}
	}

	public enum VillageType {
		FORT;
	}
}