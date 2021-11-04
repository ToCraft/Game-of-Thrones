package got.common.world.map;

import java.util.*;

import org.apache.commons.lang3.tuple.Pair;

import cpw.mods.fml.common.FMLLog;

public class GOTRoads {
	public static List<GOTRoads> allRoads = new ArrayList<>();
	public static RoadPointDatabase roadPointDatabase = new RoadPointDatabase();
	public RoadPoint[] roadPoints;
	public List<RoadPoint> endpoints = new ArrayList<>();
	public String roadName;

	public GOTRoads(String name, RoadPoint... ends) {
		roadName = name;
		Collections.addAll(endpoints, ends);
	}

	public String getDisplayName() {
		return null;
	}

	public static boolean isRoadAt(int x, int z) {
		return GOTRoads.isRoadNear(x, z, 4) >= 0.0f;
	}

	public static float isRoadNear(int x, int z, int width) {
		double widthSq = width * width;
		float leastSqRatio = -1.0f;
		List<RoadPoint> points = roadPointDatabase.getPointsForCoords(x, z);
		for (RoadPoint point : points) {
			double dx = point.x - x;
			double dz = point.z - z;
			double distSq = dx * dx + dz * dz;
			if (distSq >= widthSq) {
				continue;
			}
			float f = (float) (distSq / widthSq);
			if (leastSqRatio == -1.0f) {
				leastSqRatio = f;
				continue;
			}
			if (f >= leastSqRatio) {
				continue;
			}
			leastSqRatio = f;
		}
		return leastSqRatio;
	}

	public static void onInit() {
		FMLLog.info("Hummel009: Loading bezier curvs");
		long time = System.nanoTime();
		allRoads.clear();
		roadPointDatabase = new RoadPointDatabase();
		GOTRoads.registerRoad("Road", GOTWaypoint.GateOfTheMoon, new int[] { 825, 1377 });
		GOTRoads.registerRoad("Road", GOTWaypoint.Highgarden, new int[] { 495, 1815 });
		GOTRoads.registerRoad("Road", GOTWaypoint.DarkDell, new int[] { 521, 1784 });
		GOTRoads.registerRoad("Road", GOTWaypoint.Bitterbridge, new int[] { 652, 1708 });
		GOTRoads.registerRoad("Road", new int[] { 572, 1742 }, new int[] { 572, 1743 });
		GOTRoads.registerRoad("Road", GOTWaypoint.OldOak, new int[] { 374, 1756 });
		GOTRoads.registerRoad("Road", GOTWaypoint.CasterlyRock, new int[] { 374, 1570 });
		GOTRoads.registerRoad("Road", GOTWaypoint.Sarsfield, new int[] { 443, 1523 });
		GOTRoads.registerRoad("Road", GOTWaypoint.GoldenTooth, new int[] { 493, 1492 });
		GOTRoads.registerRoad("Road", GOTWaypoint.Crakehall, new int[] { 350, 1666 });
		GOTRoads.registerRoad("Road", new int[] { 574, 1321 }, new int[] { 574, 1323 });
		GOTRoads.registerRoad("Road", GOTWaypoint.Darry, new int[] { 749, 1453 });
		GOTRoads.registerRoad("Road", GOTWaypoint.CastleBlack, GOTWaypoint.Muletown);
		GOTRoads.registerRoad("Road", GOTWaypoint.Muletown, new int[] { 747, 742 }, new int[] { 711, 783 }, new int[] { 672, 826 }, new int[] { 649, 871 });
		GOTRoads.registerRoad("Road", new int[] { 649, 871 }, new int[] { 649, 873 });
		GOTRoads.registerRoad("Road", new int[] { 649, 873 }, GOTWaypoint.ServinsCastle, new int[] { 628, 973 }, new int[] { 647, 1108 });
		GOTRoads.registerRoad("Road", new int[] { 647, 1108 }, new int[] { 647, 1110 });
		GOTRoads.registerRoad("Road", new int[] { 647, 1110 }, new int[] { 656, 1217 }, new int[] { 647, 1270 }, GOTWaypoint.TwinsRight);
		GOTRoads.registerRoad("Road", GOTWaypoint.Jinqi, new int[] { 3753, 2449 }, new int[] { 3810, 2630 }, GOTWaypoint.Asshai);
		GOTRoads.registerRoad("Road", GOTWaypoint.ServinsCastle, new int[] { 813, 871 });
		GOTRoads.registerRoad("Road", GOTWaypoint.ServinsCastle, new int[] { 637, 910 });
		GOTRoads.registerRoad("Road", new int[] { 813, 871 }, new int[] { 815, 871 });
		GOTRoads.registerRoad("Road", new int[] { 815, 871 }, new int[] { 879, 840 }, GOTWaypoint.Karhold);
		GOTRoads.registerRoad("Road", GOTWaypoint.TorhensSquare, new int[] { 682, 990 });
		GOTRoads.registerRoad("Road", new int[] { 682, 990 }, new int[] { 684, 990 });
		GOTRoads.registerRoad("Road", new int[] { 684, 990 }, new int[] { 856, 1037 });
		GOTRoads.registerRoad("Road", new int[] { 856, 1037 }, GOTWaypoint.RamsGate);
		GOTRoads.registerRoad("Road", GOTWaypoint.RillwaterCrossing, new int[] { 411, 985 });
		GOTRoads.registerRoad("Road", new int[] { 411, 985 }, GOTWaypoint.RisvellsCastle, GOTWaypoint.Barrowtown);
		GOTRoads.registerRoad("Road", GOTWaypoint.Barrowtown, GOTWaypoint.Goldgrass);
		GOTRoads.registerRoad("Road", GOTWaypoint.Goldgrass, new int[] { 646, 1109 });
		GOTRoads.registerRoad("Road", GOTWaypoint.Goldgrass, new int[] { 531, 1067 });
		GOTRoads.registerRoad("Road", GOTWaypoint.RisvellsCastle, new int[] { 431, 1044 });
		GOTRoads.registerRoad("Road", new int[] { 646, 1109 }, new int[] { 648, 1109 });
		GOTRoads.registerRoad("Road", new int[] { 648, 1109 }, new int[] { 685, 1110 }, new int[] { 714, 1071 });
		GOTRoads.registerRoad("Road", new int[] { 714, 1071 }, GOTWaypoint.WhiteHarbour);
		GOTRoads.registerRoad("Road", GOTWaypoint.TwinsRight, GOTWaypoint.TwinsLeft);
		GOTRoads.registerRoad("Road", GOTWaypoint.TwinsLeft, GOTWaypoint.Seagard);
		GOTRoads.registerRoad("Road", new int[] { 647, 1270 }, new int[] { 655, 1331 }, GOTWaypoint.CrossroadsInn);
		GOTRoads.registerRoad("Road", GOTWaypoint.CrossroadsInn, GOTWaypoint.Darry);
		GOTRoads.registerRoad("Road", GOTWaypoint.Darry, GOTWaypoint.WhiteWalls, GOTWaypoint.Hayford);
		GOTRoads.registerRoad("Road", GOTWaypoint.Hayford, GOTWaypoint.KingsLanding);
		GOTRoads.registerRoad("Road", GOTWaypoint.TheEyrie, GOTWaypoint.GateOfTheMoon, GOTWaypoint.BloodyGate, GOTWaypoint.CrossroadsInn);
		GOTRoads.registerRoad("Road", GOTWaypoint.CrossroadsInn, GOTWaypoint.Harroway);
		GOTRoads.registerRoad("Road", GOTWaypoint.FairMarket, new int[] { 637, 1374 });
		GOTRoads.registerRoad("Road", GOTWaypoint.StoneHedge, new int[] { 629, 1429 });
		GOTRoads.registerRoad("Road", GOTWaypoint.Tumbleton, GOTWaypoint.Smithyton);
		GOTRoads.registerRoad("Road", GOTWaypoint.Riverrun, new int[] { 586, 1434 });
		GOTRoads.registerRoad("Road", new int[] { 812, 1501 }, new int[] { 814, 1501 });
		GOTRoads.registerRoad("Road", GOTWaypoint.Harroway, GOTWaypoint.CastleLychester, GOTWaypoint.StoneHedge, GOTWaypoint.Riverrun, GOTWaypoint.GoldenTooth, GOTWaypoint.Sarsfield, GOTWaypoint.Oxcross, GOTWaypoint.CasterlyRock);
		GOTRoads.registerRoad("Road", GOTWaypoint.CasterlyRock, GOTWaypoint.Lannisport);
		GOTRoads.registerRoad("Road", GOTWaypoint.Lannisport, new int[] { 477, 1572 }, new int[] { 526, 1598 }, new int[] { 570, 1625 }, new int[] { 656, 1606 }, new int[] { 710, 1633 }, GOTWaypoint.KingsLanding);
		GOTRoads.registerRoad("Road", GOTWaypoint.Hayford, GOTWaypoint.Rosby, GOTWaypoint.Duskendale, GOTWaypoint.HollardCastle, GOTWaypoint.RooksRest);
		GOTRoads.registerRoad("Road", GOTWaypoint.Maidenpool, GOTWaypoint.Duskendale);
		GOTRoads.registerRoad("Road", GOTWaypoint.KingsLanding, new int[] { 776, 1659 });
		GOTRoads.registerRoad("Road", GOTWaypoint.StormsEnd, new int[] { 897, 1783 });
		GOTRoads.registerRoad("Road", new int[] { 897, 1783 }, GOTWaypoint.Bronzegate, GOTWaypoint.Felwood, new int[] { 776, 1659 });
		GOTRoads.registerRoad("Road", new int[] { 776, 1659 }, GOTWaypoint.Smithyton, GOTWaypoint.Bitterbridge, GOTWaypoint.Appleton, GOTWaypoint.DarkDell, GOTWaypoint.Highgarden);
		GOTRoads.registerRoad("Road", GOTWaypoint.Highgarden, GOTWaypoint.Whitegrove, GOTWaypoint.Oldtown);
		GOTRoads.registerRoad("Road", GOTWaypoint.Whitegrove, new int[] { 479, 1860 });
		GOTRoads.registerRoad("Road", GOTWaypoint.SunHouse, new int[] { 417, 2059 });
		GOTRoads.registerRoad("Road", GOTWaypoint.ThreeTowers, new int[] { 350, 1998 });
		GOTRoads.registerRoad("Road", GOTWaypoint.GarnetGrove, new int[] { 353, 2013 });
		GOTRoads.registerRoad("Road", GOTWaypoint.Whitegrove, new int[] { 464, 1893 });
		GOTRoads.registerRoad("Road", GOTWaypoint.HornHill, new int[] { 464, 1893 });
		GOTRoads.registerRoad("Road", GOTWaypoint.Oldtown, new int[] { 393, 1966 }, new int[] { 377, 1988 }, GOTWaypoint.ThreeTowers);
		GOTRoads.registerRoad("Road", GOTWaypoint.ThreeTowers, new int[] { 353, 2005 }, GOTWaypoint.GarnetGrove);
		GOTRoads.registerRoad("Road", GOTWaypoint.GarnetGrove, new int[] { 379, 2023 }, new int[] { 397, 2045 }, GOTWaypoint.SunHouse);
		GOTRoads.registerRoad("Road", GOTWaypoint.RooksRest, new int[] { 863, 1531 });
		GOTRoads.registerRoad("Road", GOTWaypoint.Rosby, new int[] { 804, 1604 });
		GOTRoads.registerRoad("Road", GOTWaypoint.Hayford, new int[] { 760, 1618 });
		GOTRoads.registerRoad("Road", GOTWaypoint.Duskendale, new int[] { 831, 1577 });
		GOTRoads.registerRoad("Road", GOTWaypoint.Blackhaven, new int[] { 724, 1875 });
		GOTRoads.registerRoad("Road", GOTWaypoint.Bronzegate, new int[] { 880, 1751 });
		GOTRoads.registerRoad("Road", GOTWaypoint.Felwood, new int[] { 832, 1726 });
		GOTRoads.registerRoad("Road", GOTWaypoint.Nightsong, new int[] { 588, 1876 });
		GOTRoads.registerRoad("Road", GOTWaypoint.SunHouse, new int[] { 450, 2033 }, new int[] { 471, 2025 }, GOTWaypoint.Starfall);
		GOTRoads.registerRoad("Road", GOTWaypoint.Highgarden, GOTWaypoint.Nightsong, GOTWaypoint.TowerOfJoy, GOTWaypoint.Kingsgrave, GOTWaypoint.SkyReach);
		GOTRoads.registerRoad("Road", GOTWaypoint.Lannisport, new int[] { 371, 1622 }, GOTWaypoint.Crakehall);
		GOTRoads.registerRoad("Road", GOTWaypoint.Crakehall, GOTWaypoint.OldOak);
		GOTRoads.registerRoad("Road", GOTWaypoint.OldOak, new int[] { 438, 1773 }, GOTWaypoint.Highgarden);
		GOTRoads.registerRoad("Road", GOTWaypoint.Kingsgrave, new int[] { 606, 1935 });
		GOTRoads.registerRoad("Road", GOTWaypoint.SkyReach, new int[] { 616, 1961 });
		GOTRoads.registerRoad("Road", GOTWaypoint.Yronwood, new int[] { 694, 1964 });
		GOTRoads.registerRoad("Road", GOTWaypoint.Wyl, new int[] { 732, 1900 });
		GOTRoads.registerRoad("Road", GOTWaypoint.Starfall, new int[] { 503, 1998 });
		GOTRoads.registerRoad("Road", GOTWaypoint.Yronwood, new int[] { 680, 1953 }, GOTWaypoint.Wyl, GOTWaypoint.Blackhaven, GOTWaypoint.Summerhall, GOTWaypoint.Bronzegate);
		GOTRoads.registerRoad("Road", GOTWaypoint.Pentos, GOTWaypoint.GhoyanDrohe, GOTWaypoint.Norvos, GOTWaypoint.Qohor, GOTWaypoint.VaesKhadokh, GOTWaypoint.VaesGorqoyi, GOTWaypoint.VaesKhewo, GOTWaypoint.VojjorSamvi, GOTWaypoint.Sathar, GOTWaypoint.VaesLeqse, GOTWaypoint.VaesAthjikhari, new int[] { 2025, 1475 }, GOTWaypoint.VaesGraddakh, GOTWaypoint.Saath);
		GOTRoads.registerRoad("Road", GOTWaypoint.VaesKhadokh, GOTWaypoint.Saath);
		GOTRoads.registerRoad("Road", GOTWaypoint.VaesGorqoyi, GOTWaypoint.Rathylar, GOTWaypoint.Hornoth, GOTWaypoint.Kyth);
		GOTRoads.registerRoad("Road", GOTWaypoint.GhoyanDrohe, GOTWaypoint.NySar, GOTWaypoint.ArNoy, GOTWaypoint.Qohor);
		GOTRoads.registerRoad("Road", GOTWaypoint.NySar, GOTWaypoint.Chroyane);
		GOTRoads.registerRoad("Road", GOTWaypoint.ArNoy, GOTWaypoint.Chroyane);
		GOTRoads.registerRoad("Road", GOTWaypoint.Myr, GOTWaypoint.Chroyane);
		GOTRoads.registerRoad("Road", GOTWaypoint.Chroyane, GOTWaypoint.Selhorys, GOTWaypoint.Valysar, GOTWaypoint.VolonTherys);
		GOTRoads.registerRoad("Road", GOTWaypoint.Braavos, GOTWaypoint.GhoyanDrohe);
		GOTRoads.registerRoad("Road", GOTWaypoint.VolonTherys, GOTWaypoint.SarMell);
		GOTRoads.registerRoad("Road", GOTWaypoint.LittleValyria, GOTWaypoint.ValyrianRoad);
		GOTRoads.registerRoad("Road", GOTWaypoint.SarMell, new int[] { 1559, 2045 }, GOTWaypoint.Volantis);
		GOTRoads.registerRoad("Road", GOTWaypoint.Volantis, GOTWaypoint.LittleValyria, GOTWaypoint.Anogaria, GOTWaypoint.Mantarys, GOTWaypoint.Bhorash, new int[] { 2154, 1935 }, GOTWaypoint.Meereen);
		GOTRoads.registerRoad("Road", GOTWaypoint.Mantarys, new int[] { 1831, 2092 }, GOTWaypoint.Oros);
		GOTRoads.registerRoad("Road", GOTWaypoint.Rhyos, GOTWaypoint.Oros);
		GOTRoads.registerRoad("Road", GOTWaypoint.VaesLeqse, GOTWaypoint.VaesDothrak, GOTWaypoint.Kayakayanaya, new int[] { 3378, 1862 });
		GOTRoads.registerRoad("Road", GOTWaypoint.Meereen, GOTWaypoint.KrazaajHas);
		GOTRoads.registerRoad("Road", GOTWaypoint.KrazaajHas, GOTWaypoint.VaesMejhah);
		GOTRoads.registerRoad("Road", GOTWaypoint.VaesMejhah, GOTWaypoint.VaesJini, GOTWaypoint.Samyriana, new int[] { 3378, 1862 });
		GOTRoads.registerRoad("Road", new int[] { 3378, 1862 }, GOTWaypoint.TraderTown);
		GOTRoads.registerRoad("Road", GOTWaypoint.TraderTown, GOTWaypoint.FiveForts1);
		GOTRoads.registerRoad("Road", GOTWaypoint.Meereen, GOTWaypoint.Hesh, GOTWaypoint.Kosrak, GOTWaypoint.Adakhakileki);
		GOTRoads.registerRoad("Road", GOTWaypoint.PortYhos, GOTWaypoint.VaesOrvik);
		GOTRoads.registerRoad("Road", GOTWaypoint.VaesJini, GOTWaypoint.Adakhakileki);
		GOTRoads.registerRoad("Road", GOTWaypoint.Hesh, GOTWaypoint.Lhazosh, new int[] { 2447, 2138 }, GOTWaypoint.VaesOrvik);
		GOTRoads.registerRoad("Road", GOTWaypoint.VaesOrvik, GOTWaypoint.VaesShirosi, GOTWaypoint.VaesQosar, GOTWaypoint.Bayasabhad, GOTWaypoint.Tiqui);
		GOTRoads.registerRoad("Road", GOTWaypoint.Tiqui, new int[] { 3580, 2134 }, new int[] { 3726, 2260 });
		GOTRoads.registerRoad("Road", GOTWaypoint.VaesQosar, GOTWaypoint.Qarth);
		GOTRoads.registerRoad("Road", GOTWaypoint.TraderTown, GOTWaypoint.Tiqui, GOTWaypoint.SiQo, GOTWaypoint.Yin);
		GOTRoads.registerRoad("Road", GOTWaypoint.Asabhad, GOTWaypoint.SiQo);
		GOTRoads.registerRoad("Road", GOTWaypoint.Jinqi, new int[] { 3726, 2260 }, GOTWaypoint.FiveForts5);
		GOTRoads.registerRoad("Road", GOTWaypoint.FiveForts1, GOTWaypoint.FiveForts2);
		GOTRoads.registerRoad("Road", GOTWaypoint.FiveForts2, GOTWaypoint.FiveForts3);
		GOTRoads.registerRoad("Road", GOTWaypoint.FiveForts3, GOTWaypoint.FiveForts4);
		GOTRoads.registerRoad("Road", GOTWaypoint.FiveForts4, GOTWaypoint.FiveForts5);
		GOTRoads.registerRoad("Road", GOTWaypoint.FiveForts1, GOTWaypoint.FiveForts2);
		GOTRoads.registerRoad("Road", GOTWaypoint.Zamettar, new int[] { 2150, 2793 }, GOTWaypoint.Yeen);
		GOTRoads.registerRoad("Road", GOTWaypoint.Meereen, new int[] { 2246, 2005 }, new int[] { 2219, 2124 }, GOTWaypoint.Astapor);
		GOTRoads.registerRoad("Road", GOTWaypoint.Yunkai, new int[] { 2246, 2005 });
		long newTime = System.nanoTime();
		int roads = allRoads.size();
		for (Map.Entry e : GOTRoads.roadPointDatabase.pointMap.entrySet()) {
			((List) e.getValue()).size();
		}
		FMLLog.info("Hummel009: Created " + roads + " roads in " + (newTime - time) / 1.0E9 + "s");
	}

	public static void registerRoad(String name, Object... waypoints) {
		ArrayList<RoadPoint> points = new ArrayList<>();
		for (Object obj : waypoints) {
			if (obj instanceof GOTWaypoint) {
				GOTWaypoint wp = (GOTWaypoint) obj;
				points.add(new RoadPoint(wp.getXCoord(), wp.getZCoord(), true));
				continue;
			}
			if (obj instanceof int[]) {
				int[] coords = (int[]) obj;
				if (coords.length == 2) {
					points.add(new RoadPoint(GOTWaypoint.mapToWorldX(coords[0]), GOTWaypoint.mapToWorldZ(coords[1]), false));
					continue;
				}
				throw new IllegalArgumentException("Coords length must be 2!");
			}
			throw new IllegalArgumentException("Wrong road parameter!");
		}
		RoadPoint[] array = points.toArray(new RoadPoint[0]);
		GOTRoads[] roads = BezierCurves.getSplines(name, array);
		allRoads.addAll(Arrays.asList(roads));
	}

	public static class BezierCurves {
		public static int roadLengthFactor = 1;

		public static RoadPoint bezier(RoadPoint a, RoadPoint b, RoadPoint c, RoadPoint d, double t) {
			RoadPoint ab = BezierCurves.lerp(a, b, t);
			RoadPoint bc = BezierCurves.lerp(b, c, t);
			RoadPoint cd = BezierCurves.lerp(c, d, t);
			RoadPoint abbc = BezierCurves.lerp(ab, bc, t);
			RoadPoint bccd = BezierCurves.lerp(bc, cd, t);
			return BezierCurves.lerp(abbc, bccd, t);
		}

		public static double[][] getControlPoints(double[] src) {
			int i;
			int length = src.length - 1;
			double[] p1 = new double[length];
			double[] p2 = new double[length];
			double[] a = new double[length];
			double[] b = new double[length];
			double[] c = new double[length];
			double[] r = new double[length];
			a[0] = 0.0;
			b[0] = 2.0;
			c[0] = 1.0;
			r[0] = src[0] + 2.0 * src[1];
			for (i = 1; i < length - 1; ++i) {
				a[i] = 1.0;
				b[i] = 4.0;
				c[i] = 1.0;
				r[i] = 4.0 * src[i] + 2.0 * src[i + 1];
			}
			a[length - 1] = 2.0;
			b[length - 1] = 7.0;
			c[length - 1] = 0.0;
			r[length - 1] = 8.0 * src[length - 1] + src[length];
			for (i = 1; i < length; ++i) {
				double m = a[i] / b[i - 1];
				b[i] = b[i] - m * c[i - 1];
				r[i] = r[i] - m * r[i - 1];
			}
			p1[length - 1] = r[length - 1] / b[length - 1];
			for (i = length - 2; i >= 0; --i) {
				p1[i] = (r[i] - c[i] * p1[i + 1]) / b[i];
			}
			for (i = 0; i < length - 1; ++i) {
				p2[i] = 2.0 * src[i + 1] - p1[i + 1];
			}
			p2[length - 1] = 0.5 * (src[length] + p1[length - 1]);
			return new double[][] { p1, p2 };
		}

		public static GOTRoads[] getSplines(String name, RoadPoint[] waypoints) {
			if (waypoints.length == 2) {
				RoadPoint p1 = waypoints[0];
				RoadPoint p2 = waypoints[1];
				GOTRoads road = new GOTRoads(name, p1, p2);
				double dx = p2.x - p1.x;
				double dz = p2.z - p1.z;
				int roadLength = (int) Math.round(Math.sqrt(dx * dx + dz * dz));
				int points = roadLength * roadLengthFactor;
				road.roadPoints = new RoadPoint[points];
				for (int l = 0; l < points; ++l) {
					RoadPoint point;
					double t = (double) l / (double) points;
					road.roadPoints[l] = point = new RoadPoint(p1.x + dx * t, p1.z + dz * t, false);
					roadPointDatabase.add(point);
				}
				return new GOTRoads[] { road };
			}
			int length = waypoints.length;
			double[] x = new double[length];
			double[] z = new double[length];
			for (int i = 0; i < length; ++i) {
				x[i] = waypoints[i].x;
				z[i] = waypoints[i].z;
			}
			double[][] controlX = BezierCurves.getControlPoints(x);
			double[][] controlZ = BezierCurves.getControlPoints(z);
			int controlPoints = controlX[0].length;
			RoadPoint[] controlPoints1 = new RoadPoint[controlPoints];
			RoadPoint[] controlPoints2 = new RoadPoint[controlPoints];
			for (int i = 0; i < controlPoints; ++i) {
				RoadPoint p1 = new RoadPoint(controlX[0][i], controlZ[0][i], false);
				RoadPoint p2 = new RoadPoint(controlX[1][i], controlZ[1][i], false);
				controlPoints1[i] = p1;
				controlPoints2[i] = p2;
			}
			GOTRoads[] roads = new GOTRoads[length - 1];
			for (int i = 0; i < roads.length; ++i) {
				GOTRoads road;
				RoadPoint p1 = waypoints[i];
				RoadPoint p2 = waypoints[i + 1];
				RoadPoint cp1 = controlPoints1[i];
				RoadPoint cp2 = controlPoints2[i];
				roads[i] = road = new GOTRoads(name, p1, p2);
				double dx = p2.x - p1.x;
				double dz = p2.z - p1.z;
				int roadLength = (int) Math.round(Math.sqrt(dx * dx + dz * dz));
				int points = roadLength * roadLengthFactor;
				road.roadPoints = new RoadPoint[points];
				for (int l = 0; l < points; ++l) {
					RoadPoint point;
					double t = (double) l / (double) points;
					road.roadPoints[l] = point = BezierCurves.bezier(p1, cp1, cp2, p2, t);
					roadPointDatabase.add(point);
				}
			}
			return roads;
		}

		public static RoadPoint lerp(RoadPoint a, RoadPoint b, double t) {
			double x = a.x + (b.x - a.x) * t;
			double z = a.z + (b.z - a.z) * t;
			return new RoadPoint(x, z, false);
		}
	}

	public static class RoadPoint {
		public double x;
		public double z;
		public boolean isWaypoint;

		public RoadPoint(double i, double j, boolean flag) {
			x = i;
			z = j;
			isWaypoint = flag;
		}
	}

	public static class RoadPointDatabase {
		public static int COORD_LOOKUP_SIZE = 1000;
		public Map<Pair<Integer, Integer>, List<RoadPoint>> pointMap = new HashMap<>();

		public void add(RoadPoint point) {
			int x = (int) Math.round(point.x / 1000.0);
			int z = (int) Math.round(point.z / 1000.0);
			int overlap = 1;
			for (int i = -overlap; i <= overlap; ++i) {
				for (int k = -overlap; k <= overlap; ++k) {
					int xKey = x + i;
					int zKey = z + k;
					getRoadList(xKey, zKey, true).add(point);
				}
			}
		}

		public List<RoadPoint> getPointsForCoords(int x, int z) {
			int x1 = x / 1000;
			int z1 = z / 1000;
			return getRoadList(x1, z1, false);
		}

		public List<RoadPoint> getRoadList(int xKey, int zKey, boolean addToMap) {
			Pair key = Pair.of((Object) xKey, (Object) zKey);
			List<RoadPoint> list = pointMap.get(key);
			if (list == null) {
				list = new ArrayList<>();
				if (addToMap) {
					pointMap.put(key, list);
				}
			}
			return list;
		}
	}

}
