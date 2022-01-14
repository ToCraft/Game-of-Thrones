package got.common.faction;

import java.awt.Color;
import java.util.*;

import got.GOT;
import got.common.*;
import got.common.GOTDimension.DimensionRegion;
import got.common.database.GOTAchievement;
import got.common.entity.other.GOTNPCSelectForInfluence;
import got.common.faction.GOTFactionRank.GOTAchievementRank;
import got.common.item.other.GOTItemBanner;
import got.common.world.GOTWorldProvider;
import got.common.world.map.GOTWaypoint;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.*;
import net.minecraft.world.World;

public enum GOTFaction {
	WHITE_WALKER(0x8ddaf8, DimensionRegion.WESTEROS, new GOTMapRegion(550, 550, 500)), WILDLING(0x749987, DimensionRegion.WESTEROS, new GOTMapRegion(615, 520, 200)), NIGHT_WATCH(0x282728, DimensionRegion.WESTEROS, new GOTMapRegion(750, 670, 150)), NORTH(0xc6cfd0, DimensionRegion.WESTEROS, new GOTMapRegion(670, 930, 400)), IRONBORN(0x4b483a, DimensionRegion.WESTEROS, new GOTMapRegion(349, 1323, 129)), WESTERLANDS(0x7c0a02, DimensionRegion.WESTEROS, new GOTMapRegion(485, 1540, 200)), RIVERLANDS(0x146f69, DimensionRegion.WESTEROS, new GOTMapRegion(675, 1437, 215)), HILL_TRIBES(0x4D3C36, DimensionRegion.WESTEROS, new GOTMapRegion(842, 1329, 176)), ARRYN(3511475, DimensionRegion.WESTEROS, new GOTMapRegion(842, 1329, 176)), DRAGONSTONE(0x555555, DimensionRegion.WESTEROS, new GOTMapRegion(923, 1549, 40)), TARGARYEN(0x790C06, DimensionRegion.WESTEROS, new GOTMapRegion(771, 1631, 100)), CROWNLANDS(0x593800, DimensionRegion.WESTEROS, new GOTMapRegion(876, 1566, 168)), STORMLANDS(0x4f666a, DimensionRegion.WESTEROS, new GOTMapRegion(820, 1865, 218)), REACH(0x288f28, DimensionRegion.WESTEROS, new GOTMapRegion(500, 1820, 293)), DORNE(0xbe8130, DimensionRegion.WESTEROS, new GOTMapRegion(717, 2011, 300)), BRAAVOS(0x7a4440, DimensionRegion.WEST_ESSOS, new GOTMapRegion(1221, 1351, 137)), VOLANTIS(0x672F81, DimensionRegion.WEST_ESSOS, new GOTMapRegion(1553, 1928, 210)), PENTOS(0xafb170, DimensionRegion.WEST_ESSOS, new GOTMapRegion(1234, 1566, 172)), NORVOS(0x8E5B5E, DimensionRegion.WEST_ESSOS, new GOTMapRegion(1437, 1468, 201)), LORATH(0x498874, DimensionRegion.WEST_ESSOS, new GOTMapRegion(1379, 1354, 119)), QOHOR(0xceac64, DimensionRegion.WEST_ESSOS, new GOTMapRegion(1590, 1594, 214)), LYS(0x43C182, DimensionRegion.WEST_ESSOS, new GOTMapRegion(1204, 2053, 65)), MYR(7250085, DimensionRegion.WEST_ESSOS, new GOTMapRegion(1325, 1797, 223)), TYROSH(0x6678A4, DimensionRegion.WEST_ESSOS, new GOTMapRegion(1110, 1876, 52)), GHISCAR(0xC1963A, DimensionRegion.WEST_ESSOS, new GOTMapRegion(2115, 2180, 347)), QARTH(8536951, DimensionRegion.WEST_ESSOS, new GOTMapRegion(2750, 2277, 221)), LHAZAR(0xB5AA46, DimensionRegion.WEST_ESSOS, new GOTMapRegion(2510, 1910, 175)), DOTHRAKI(0x814b23, DimensionRegion.WEST_ESSOS, new GOTMapRegion(2270, 1670, 600)), IBBEN(0x326322, DimensionRegion.EAST_ESSOS, new GOTMapRegion(2761, 1052, 252)), JOGOS(0x748234, DimensionRegion.EAST_ESSOS, new GOTMapRegion(3369, 1651, 460)), MOSSOVY(0x4d6851, DimensionRegion.EAST_ESSOS, new GOTMapRegion(4056, 1480, 400)), YI_TI(0xBF8F00, DimensionRegion.EAST_ESSOS, new GOTMapRegion(3350, 2200, 350)), ASSHAI(0x28222e, DimensionRegion.EAST_ESSOS, new GOTMapRegion(4098, 2331, 644)), SOTHORYOS(0x6f723b, DimensionRegion.OTHER, new GOTMapRegion(2375, 3540, 1084)), SUMMER_ISLANDS(0x933C3C, DimensionRegion.OTHER, new GOTMapRegion(1228, 2716, 310)), ULTHOS(0x2B3F19, DimensionRegion.OTHER, new GOTMapRegion(4800, 3011, 2000)), HOSTILE(true, -1), UNALIGNED(false, 0);

	public static Random factionRand;
	public static int CONTROL_ZONE_EXTRA_RANGE = 50;
	static {
		factionRand = new Random();
	}
	public GOTDimension factionDimension;
	public GOTDimension.DimensionRegion factionRegion;
	public Color factionColor;
	public Map<Float, float[]> facRGBCache = new HashMap<>();
	public List<GOTItemBanner.BannerType> factionBanners = new ArrayList<>();
	public boolean allowPlayer;
	public boolean allowEntityRegistry;
	public boolean hasFixedAlignment;
	public int fixedAlignment;
	public List<GOTFactionRank> ranksSortedDescending = new ArrayList<>();
	public GOTFactionRank pledgeRank;
	public GOTAchievement.Category achieveCategory;
	public GOTMapRegion factionMapInfo;
	public List<GOTControlZone> controlZones = new ArrayList<>();
	public boolean isolationist = false;
	public int eggColor;

	public boolean isViolent = true;

	public List<String> legacyAliases = new ArrayList<>();

	GOTFaction(boolean registry, int alignment) {
		this(0, null, null, false, registry, alignment, null);
	}

	GOTFaction(int color, GOTDimension dim, GOTDimension.DimensionRegion region, boolean player, boolean registry, int alignment, GOTMapRegion mapInfo) {
		allowPlayer = player;
		eggColor = color;
		allowEntityRegistry = registry;
		factionColor = new Color(color);
		factionDimension = dim;
		if (factionDimension != null) {
			factionDimension.factionList.add(this);
		}
		factionRegion = region;
		if (factionRegion != null) {
			factionRegion.factionList.add(this);
			if (factionRegion.getDimension() != factionDimension) {
				throw new IllegalArgumentException("Faction dimension region must agree with faction dimension!");
			}
		}
		if (alignment != Integer.MIN_VALUE) {
			setFixedAlignment(alignment);
		}
		if (mapInfo != null) {
			factionMapInfo = mapInfo;
		}
	}

	GOTFaction(int color, GOTDimension dim, GOTDimension.DimensionRegion region, GOTMapRegion mapInfo) {
		this(color, dim, region, true, true, Integer.MIN_VALUE, mapInfo);
	}

	GOTFaction(int color, GOTDimension dim, int alignment) {
		this(color, dim, dim.dimensionRegions.get(0), true, true, alignment, null);
	}

	GOTFaction(int color, GOTDimension.DimensionRegion region, GOTMapRegion mapInfo) {
		this(color, GOTDimension.GAME_OF_THRONES, region, mapInfo);
	}

	public void addControlZone(GOTControlZone zone) {
		controlZones.add(zone);
	}

	public void addLegacyAlias(String s) {
		legacyAliases.add(s);
	}

	public GOTFactionRank addRank(float alignment, String name) {
		return this.addRank(alignment, name, false);
	}

	public GOTFactionRank addRank(float alignment, String name, boolean gendered) {
		GOTFactionRank rank = new GOTFactionRank(this, alignment, name);
		ranksSortedDescending.add(rank);
		Collections.sort(ranksSortedDescending);
		return rank;
	}

	public int[] calculateFullControlZoneWorldBorders() {
		int xMin = 0;
		int xMax = 0;
		int zMin = 0;
		int zMax = 0;
		boolean first = true;
		for (GOTControlZone zone : controlZones) {
			int cxMin = zone.xCoord - zone.radiusCoord;
			int cxMax = zone.xCoord + zone.radiusCoord;
			int czMin = zone.zCoord - zone.radiusCoord;
			int czMax = zone.zCoord + zone.radiusCoord;
			if (first) {
				xMin = cxMin;
				xMax = cxMax;
				zMin = czMin;
				zMax = czMax;
				first = false;
				continue;
			}
			xMin = Math.min(xMin, cxMin);
			xMax = Math.max(xMax, cxMax);
			zMin = Math.min(zMin, czMin);
			zMax = Math.max(zMax, czMax);
		}
		return new int[] { xMin, xMax, zMin, zMax };
	}

	public void checkAlignmentAchievements(EntityPlayer entityplayer, float alignment) {
		GOTPlayerData playerData = GOTLevelData.getData(entityplayer);
		for (GOTFactionRank rank : ranksSortedDescending) {
			GOTAchievementRank rankAch = rank.getRankAchievement();
			if (rankAch == null || !rankAch.isPlayerRequiredRank(entityplayer)) {
				continue;
			}
			playerData.addAchievement(rankAch);
		}
	}

	public String codeName() {
		return name();
	}

	public double distanceToNearestControlZoneInRange(World world, double d, double d1, double d2, int mapRange) {
		double closestDist = -1.0;
		if (isFactionDimension(world)) {
			int coordRange = GOTWaypoint.mapToWorldR(mapRange);
			for (GOTControlZone zone : controlZones) {
				double dx = d - zone.xCoord;
				double dz = d2 - zone.zCoord;
				double dSq = dx * dx + dz * dz;
				double dToEdge = Math.sqrt(dSq) - zone.radiusCoord;
				if ((dToEdge > coordRange) || (closestDist >= 0.0) && (dToEdge >= closestDist)) {
					continue;
				}
				closestDist = dToEdge;
			}
		}
		return closestDist;
	}

	public String factionEntityName() {
		return StatCollector.translateToLocal("got.faction." + codeName() + ".entity");
	}

	public String factionName() {
		return StatCollector.translateToLocal(untranslatedFactionName());
	}

	public String factionSubtitle() {
		return StatCollector.translateToLocal("got.faction." + codeName() + ".subtitle");
	}

	public GOTAchievement.Category getAchieveCategory() {
		return achieveCategory;
	}

	public List<GOTFaction> getBonusesForKilling() {
		ArrayList<GOTFaction> list = new ArrayList<>();
		for (GOTFaction f : GOTFaction.values()) {
			if (f == this || !isBadRelation(f)) {
				continue;
			}
			list.add(f);
		}
		return list;
	}

	public List<GOTFaction> getConquestBoostRelations() {
		ArrayList<GOTFaction> list = new ArrayList<>();
		for (GOTFaction f : GOTFaction.values()) {
			if (f == this || !f.isPlayableAlignmentFaction() || GOTFactionRelations.getRelations(this, f) != GOTFactionRelations.Relation.ALLY) {
				continue;
			}
			list.add(f);
		}
		return list;
	}

	public float getControlZoneAlignmentMultiplier(EntityPlayer entityplayer) {
		int reducedRange;
		double dist;
		if (this.inControlZone(entityplayer)) {
			return 1.0f;
		}
		if (isFactionDimension(entityplayer.worldObj) && (dist = distanceToNearestControlZoneInRange(entityplayer.worldObj, entityplayer.posX, entityplayer.boundingBox.minY, entityplayer.posZ, reducedRange = getControlZoneReducedRange())) >= 0.0) {
			double mapDist = GOTWaypoint.worldToMapR(dist);
			float frac = (float) mapDist / reducedRange;
			float mplier = 1.0f - frac;
			return MathHelper.clamp_float(mplier, 0.0f, 1.0f);
		}
		return 0.0f;
	}

	public int getControlZoneReducedRange() {
		return isolationist ? 0 : 50;
	}

	public List<GOTControlZone> getControlZones() {
		return controlZones;
	}

	public int getFactionColor() {
		return factionColor.getRGB();
	}

	public float[] getFactionRGB() {
		return getFactionRGB_MinBrightness(0.0f);
	}

	public float[] getFactionRGB_MinBrightness(float minBrightness) {
		float[] rgb = facRGBCache.get(Float.valueOf(minBrightness));
		if (rgb == null) {
			float[] hsb = Color.RGBtoHSB(factionColor.getRed(), factionColor.getGreen(), factionColor.getBlue(), null);
			hsb[2] = Math.max(hsb[2], minBrightness);
			int alteredColor = Color.HSBtoRGB(hsb[0], hsb[1], hsb[2]);
			rgb = new Color(alteredColor).getColorComponents(null);
			facRGBCache.put(minBrightness, rgb);
		}
		return rgb;
	}

	public GOTFactionRank getFirstRank() {
		if (ranksSortedDescending.isEmpty()) {
			return GOTFactionRank.RANK_NEUTRAL;
		}
		return ranksSortedDescending.get(ranksSortedDescending.size() - 1);
	}

	public List<GOTFaction> getOthersOfRelation(GOTFactionRelations.Relation rel) {
		ArrayList<GOTFaction> list = new ArrayList<>();
		for (GOTFaction f : GOTFaction.values()) {
			if (f == this || !f.isPlayableAlignmentFaction() || GOTFactionRelations.getRelations(this, f) != rel) {
				continue;
			}
			list.add(f);
		}
		return list;
	}

	public List<GOTFaction> getPenaltiesForKilling() {
		ArrayList<GOTFaction> list = new ArrayList<>();
		list.add(this);
		for (GOTFaction f : GOTFaction.values()) {
			if (f == this || !isGoodRelation(f)) {
				continue;
			}
			list.add(f);
		}
		return list;
	}

	public float getPledgeAlignment() {
		if (pledgeRank != null) {
			return pledgeRank.alignment;
		}
		return 0.0f;
	}

	public GOTFactionRank getPledgeRank() {
		return pledgeRank;
	}

	public GOTFactionRank getRank(EntityPlayer entityplayer) {
		return this.getRank(GOTLevelData.getData(entityplayer));
	}

	public GOTFactionRank getRank(float alignment) {
		for (GOTFactionRank rank : ranksSortedDescending) {
			if (rank.isDummyRank() || (alignment < rank.alignment)) {
				continue;
			}
			return rank;
		}
		if (alignment >= 0.0f) {
			return GOTFactionRank.RANK_NEUTRAL;
		}
		return GOTFactionRank.RANK_ENEMY;
	}

	public GOTFactionRank getRank(GOTPlayerData pd) {
		float alignment = pd.getAlignment(this);
		return this.getRank(alignment);
	}

	public GOTFactionRank getRankAbove(GOTFactionRank curRank) {
		return getRankNAbove(curRank, 1);
	}

	public GOTFactionRank getRankBelow(GOTFactionRank curRank) {
		return getRankNAbove(curRank, -1);
	}

	public GOTFactionRank getRankNAbove(GOTFactionRank curRank, int n) {
		if (ranksSortedDescending.isEmpty() || curRank == null) {
			return GOTFactionRank.RANK_NEUTRAL;
		}
		int index = -1;
		if (curRank.isDummyRank()) {
			index = ranksSortedDescending.size();
		} else if (ranksSortedDescending.contains(curRank)) {
			index = ranksSortedDescending.indexOf(curRank);
		}
		if (index >= 0) {
			if ((index -= n) < 0) {
				return ranksSortedDescending.get(0);
			}
			if (index > ranksSortedDescending.size() - 1) {
				return GOTFactionRank.RANK_NEUTRAL;
			}
			return ranksSortedDescending.get(index);
		}
		return GOTFactionRank.RANK_NEUTRAL;
	}

	public boolean inControlZone(EntityPlayer entityplayer) {
		return this.inControlZone(entityplayer.worldObj, entityplayer.posX, entityplayer.boundingBox.minY, entityplayer.posZ);
	}

	public boolean inControlZone(World world, double d, double d1, double d2) {
		if (this.inDefinedControlZone(world, d, d1, d2)) {
			return true;
		}
		double nearbyRange = 24.0;
		AxisAlignedBB aabb = AxisAlignedBB.getBoundingBox(d, d1, d2, d, d1, d2).expand(nearbyRange, nearbyRange, nearbyRange);
		List nearbyNPCs = world.selectEntitiesWithinAABB(EntityLivingBase.class, aabb, new GOTNPCSelectForInfluence(this));
		return !nearbyNPCs.isEmpty();
	}

	public boolean inDefinedControlZone(EntityPlayer entityplayer) {
		return this.inDefinedControlZone(entityplayer, 0);
	}

	public boolean inDefinedControlZone(EntityPlayer entityplayer, int extraMapRange) {
		return this.inDefinedControlZone(entityplayer.worldObj, entityplayer.posX, entityplayer.boundingBox.minY, entityplayer.posZ, extraMapRange);
	}

	public boolean inDefinedControlZone(World world, double d, double d1, double d2) {
		return this.inDefinedControlZone(world, d, d1, d2, 0);
	}

	public boolean inDefinedControlZone(World world, double d, double d1, double d2, int extraMapRange) {
		if (isFactionDimension(world)) {
			if (!GOTFaction.controlZonesEnabled(world)) {
				return true;
			}
			for (GOTControlZone zone : controlZones) {
				if (!zone.inZone(d, d1, d2, extraMapRange)) {
					continue;
				}
				return true;
			}
		}
		return false;
	}

	public boolean isAlly(GOTFaction other) {
		GOTFactionRelations.Relation rel = GOTFactionRelations.getRelations(this, other);
		return rel == GOTFactionRelations.Relation.ALLY;
	}

	public boolean isBadRelation(GOTFaction other) {
		GOTFactionRelations.Relation rel = GOTFactionRelations.getRelations(this, other);
		return rel == GOTFactionRelations.Relation.ENEMY || rel == GOTFactionRelations.Relation.MORTAL_ENEMY;
	}

	public boolean isFactionDimension(World world) {
		return world.provider instanceof GOTWorldProvider && ((GOTWorldProvider) world.provider).getGOTDimension() == factionDimension;
	}

	public boolean isGoodRelation(GOTFaction other) {
		GOTFactionRelations.Relation rel = GOTFactionRelations.getRelations(this, other);
		return rel == GOTFactionRelations.Relation.ALLY || rel == GOTFactionRelations.Relation.FRIEND;
	}

	public boolean isMortalEnemy(GOTFaction other) {
		GOTFactionRelations.Relation rel = GOTFactionRelations.getRelations(this, other);
		return rel == GOTFactionRelations.Relation.MORTAL_ENEMY;
	}

	public boolean isNeutral(GOTFaction other) {
		return GOTFactionRelations.getRelations(this, other) == GOTFactionRelations.Relation.NEUTRAL;
	}

	public boolean isPlayableAlignmentFaction() {
		return allowPlayer && !hasFixedAlignment;
	}

	public List<String> listAliases() {
		return new ArrayList<>(legacyAliases);
	}

	public boolean matchesNameOrAlias(String name) {
		if (codeName().equals(name)) {
			return true;
		}
		for (String alias : legacyAliases) {
			if (!alias.equals(name)) {
				continue;
			}
			return true;
		}
		return false;
	}

	public void setAchieveCategory(GOTAchievement.Category cat) {
		achieveCategory = cat;
	}

	public void setFixedAlignment(int alignment) {
		hasFixedAlignment = true;
		fixedAlignment = alignment;
	}

	public void setPledgeRank(GOTFactionRank rank) {
		if (rank.fac != this) {
			throw new IllegalArgumentException("Incompatible faction!");
		}
		if (pledgeRank != null) {
			throw new IllegalArgumentException("Faction already has a pledge rank!");
		}
		pledgeRank = rank;
	}

	public boolean sharesControlZoneWith(GOTFaction other) {
		return this.sharesControlZoneWith(other, 0);
	}

	public boolean sharesControlZoneWith(GOTFaction other, int extraMapRadius) {
		if (other.factionDimension == factionDimension) {
			for (GOTControlZone zone : controlZones) {
				for (GOTControlZone otherZone : other.controlZones) {
					if (!zone.intersectsWith(otherZone, extraMapRadius)) {
						continue;
					}
					return true;
				}
			}
		}
		return false;
	}

	public String untranslatedFactionName() {
		return "got.faction." + codeName() + ".name";
	}

	public static boolean controlZonesEnabled(World world) {
		return GOTLevelData.enableAlignmentZones() && world.getWorldInfo().getTerrainType() != GOT.worldTypeGOTClassic;
	}

	public static GOTFaction forID(int ID) {
		for (GOTFaction f : GOTFaction.values()) {
			if (f.ordinal() != ID) {
				continue;
			}
			return f;
		}
		return null;
	}

	public static GOTFaction forName(String name) {
		for (GOTFaction f : GOTFaction.values()) {
			if (!f.matchesNameOrAlias(name)) {
				continue;
			}
			return f;
		}
		return null;
	}

	public static List<GOTFaction> getAllRegional(GOTDimension.DimensionRegion region) {
		ArrayList<GOTFaction> factions = new ArrayList<>();
		for (GOTFaction f : GOTFaction.values()) {
			if (f.factionRegion != region) {
				continue;
			}
			factions.add(f);
		}
		return factions;
	}

	public static List<String> getPlayableAlignmentFactionNames() {
		List<GOTFaction> factions = GOTFaction.getPlayableAlignmentFactions();
		ArrayList<String> names = new ArrayList<>();
		for (GOTFaction f : factions) {
			names.add(f.codeName());
		}
		return names;
	}

	public static List<GOTFaction> getPlayableAlignmentFactions() {
		ArrayList<GOTFaction> factions = new ArrayList<>();
		for (GOTFaction f : GOTFaction.values()) {
			if (!f.isPlayableAlignmentFaction()) {
				continue;
			}
			factions.add(f);
		}
		return factions;
	}

	public static void onInit() {
		for (GOTFaction f : GOTFaction.values()) {
			if (!f.allowPlayer || f == WHITE_WALKER) {
				continue;
			}
			GOTFactionRelations.setRelations(f, WHITE_WALKER, GOTFactionRelations.Relation.MORTAL_ENEMY);
		}
		GOTFactionRelations.setRelations(SUMMER_ISLANDS, VOLANTIS, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(TARGARYEN, GOTFaction.PENTOS, GOTFactionRelations.Relation.FRIEND);
		GOTFactionRelations.setRelations(TARGARYEN, GOTFaction.ARRYN, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(TARGARYEN, GOTFaction.NORTH, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(TARGARYEN, GOTFaction.WESTERLANDS, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(TARGARYEN, GOTFaction.RIVERLANDS, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(TARGARYEN, GOTFaction.IRONBORN, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(TARGARYEN, GOTFaction.STORMLANDS, GOTFactionRelations.Relation.MORTAL_ENEMY);
		GOTFactionRelations.setRelations(TYROSH, LYS, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(ARRYN, CROWNLANDS, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(ARRYN, IBBEN, GOTFactionRelations.Relation.FRIEND);
		GOTFactionRelations.setRelations(ARRYN, RIVERLANDS, GOTFactionRelations.Relation.FRIEND);
		GOTFactionRelations.setRelations(ARRYN, WESTERLANDS, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(ASSHAI, YI_TI, GOTFactionRelations.Relation.FRIEND);
		GOTFactionRelations.setRelations(BRAAVOS, IBBEN, GOTFactionRelations.Relation.FRIEND);
		GOTFactionRelations.setRelations(BRAAVOS, LORATH, GOTFactionRelations.Relation.ALLY);
		GOTFactionRelations.setRelations(BRAAVOS, PENTOS, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(CROWNLANDS, WESTERLANDS, GOTFactionRelations.Relation.ALLY);
		GOTFactionRelations.setRelations(DORNE, CROWNLANDS, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(DORNE, WESTERLANDS, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(DOTHRAKI, GHISCAR, GOTFactionRelations.Relation.FRIEND);
		GOTFactionRelations.setRelations(DOTHRAKI, IBBEN, GOTFactionRelations.Relation.MORTAL_ENEMY);
		GOTFactionRelations.setRelations(DOTHRAKI, LHAZAR, GOTFactionRelations.Relation.MORTAL_ENEMY);
		GOTFactionRelations.setRelations(DOTHRAKI, MYR, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(DOTHRAKI, NORVOS, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(DOTHRAKI, QOHOR, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(DOTHRAKI, QARTH, GOTFactionRelations.Relation.FRIEND);
		GOTFactionRelations.setRelations(DOTHRAKI, VOLANTIS, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(DRAGONSTONE, ASSHAI, GOTFactionRelations.Relation.FRIEND);
		GOTFactionRelations.setRelations(DRAGONSTONE, CROWNLANDS, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(DRAGONSTONE, LYS, GOTFactionRelations.Relation.FRIEND);
		GOTFactionRelations.setRelations(DRAGONSTONE, NIGHT_WATCH, GOTFactionRelations.Relation.FRIEND);
		GOTFactionRelations.setRelations(DRAGONSTONE, REACH, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(DRAGONSTONE, WESTERLANDS, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(DRAGONSTONE, WILDLING, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(GHISCAR, LHAZAR, GOTFactionRelations.Relation.FRIEND);
		GOTFactionRelations.setRelations(GHISCAR, SOTHORYOS, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(HILL_TRIBES, ARRYN, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(HILL_TRIBES, NORTH, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(HILL_TRIBES, RIVERLANDS, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(HILL_TRIBES, WESTERLANDS, GOTFactionRelations.Relation.ALLY);
		GOTFactionRelations.setRelations(HILL_TRIBES, WILDLING, GOTFactionRelations.Relation.FRIEND);
		GOTFactionRelations.setRelations(IBBEN, WILDLING, GOTFactionRelations.Relation.FRIEND);
		GOTFactionRelations.setRelations(IRONBORN, CROWNLANDS, GOTFactionRelations.Relation.FRIEND);
		GOTFactionRelations.setRelations(IRONBORN, DORNE, GOTFactionRelations.Relation.MORTAL_ENEMY);
		GOTFactionRelations.setRelations(IRONBORN, IBBEN, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(IRONBORN, REACH, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(IRONBORN, RIVERLANDS, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(IRONBORN, WESTERLANDS, GOTFactionRelations.Relation.FRIEND);
		GOTFactionRelations.setRelations(JOGOS, IBBEN, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(JOGOS, YI_TI, GOTFactionRelations.Relation.MORTAL_ENEMY);
		GOTFactionRelations.setRelations(LORATH, IBBEN, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(LYS, SOTHORYOS, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(MOSSOVY, ASSHAI, GOTFactionRelations.Relation.MORTAL_ENEMY);
		GOTFactionRelations.setRelations(MOSSOVY, IBBEN, GOTFactionRelations.Relation.FRIEND);
		GOTFactionRelations.setRelations(MOSSOVY, JOGOS, GOTFactionRelations.Relation.FRIEND);
		GOTFactionRelations.setRelations(MOSSOVY, YI_TI, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(MYR, LYS, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(MYR, SOTHORYOS, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(MYR, TYROSH, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(NIGHT_WATCH, WILDLING, GOTFactionRelations.Relation.MORTAL_ENEMY);
		GOTFactionRelations.setRelations(NORTH, ARRYN, GOTFactionRelations.Relation.FRIEND);
		GOTFactionRelations.setRelations(NORTH, CROWNLANDS, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(NORTH, DRAGONSTONE, GOTFactionRelations.Relation.FRIEND);
		GOTFactionRelations.setRelations(NORTH, IBBEN, GOTFactionRelations.Relation.FRIEND);
		GOTFactionRelations.setRelations(NORTH, IRONBORN, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(NORTH, NIGHT_WATCH, GOTFactionRelations.Relation.ALLY);
		GOTFactionRelations.setRelations(NORTH, RIVERLANDS, GOTFactionRelations.Relation.ALLY);
		GOTFactionRelations.setRelations(NORTH, STORMLANDS, GOTFactionRelations.Relation.FRIEND);
		GOTFactionRelations.setRelations(NORTH, WESTERLANDS, GOTFactionRelations.Relation.MORTAL_ENEMY);
		GOTFactionRelations.setRelations(NORTH, WILDLING, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(NORVOS, BRAAVOS, GOTFactionRelations.Relation.FRIEND);
		GOTFactionRelations.setRelations(NORVOS, LORATH, GOTFactionRelations.Relation.FRIEND);
		GOTFactionRelations.setRelations(NORVOS, QOHOR, GOTFactionRelations.Relation.FRIEND);
		GOTFactionRelations.setRelations(QARTH, ASSHAI, GOTFactionRelations.Relation.FRIEND);
		GOTFactionRelations.setRelations(QARTH, CROWNLANDS, GOTFactionRelations.Relation.FRIEND);
		GOTFactionRelations.setRelations(QARTH, GHISCAR, GOTFactionRelations.Relation.FRIEND);
		GOTFactionRelations.setRelations(QARTH, SOTHORYOS, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(QARTH, WESTERLANDS, GOTFactionRelations.Relation.FRIEND);
		GOTFactionRelations.setRelations(QARTH, YI_TI, GOTFactionRelations.Relation.FRIEND);
		GOTFactionRelations.setRelations(RIVERLANDS, CROWNLANDS, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(RIVERLANDS, WESTERLANDS, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(STORMLANDS, CROWNLANDS, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(STORMLANDS, DRAGONSTONE, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(STORMLANDS, REACH, GOTFactionRelations.Relation.ALLY);
		GOTFactionRelations.setRelations(WESTERLANDS, REACH, GOTFactionRelations.Relation.FRIEND);
		GOTFactionRelations.setRelations(CROWNLANDS, REACH, GOTFactionRelations.Relation.FRIEND);
		GOTFactionRelations.setRelations(STORMLANDS, WESTERLANDS, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(SUMMER_ISLANDS, CROWNLANDS, GOTFactionRelations.Relation.FRIEND);
		GOTFactionRelations.setRelations(SUMMER_ISLANDS, DORNE, GOTFactionRelations.Relation.FRIEND);
		GOTFactionRelations.setRelations(SUMMER_ISLANDS, GHISCAR, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(SUMMER_ISLANDS, LYS, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(SUMMER_ISLANDS, MYR, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(SUMMER_ISLANDS, QARTH, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(SUMMER_ISLANDS, SOTHORYOS, GOTFactionRelations.Relation.FRIEND);
		GOTFactionRelations.setRelations(SUMMER_ISLANDS, TYROSH, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(SUMMER_ISLANDS, VOLANTIS, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(TYROSH, LYS, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(TYROSH, SOTHORYOS, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(ULTHOS, ASSHAI, GOTFactionRelations.Relation.FRIEND);
		GOTFactionRelations.setRelations(ULTHOS, SOTHORYOS, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(VOLANTIS, BRAAVOS, GOTFactionRelations.Relation.MORTAL_ENEMY);
		GOTFactionRelations.setRelations(VOLANTIS, GHISCAR, GOTFactionRelations.Relation.FRIEND);
		GOTFactionRelations.setRelations(VOLANTIS, LYS, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(VOLANTIS, MYR, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(VOLANTIS, NORVOS, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(VOLANTIS, PENTOS, GOTFactionRelations.Relation.FRIEND);
		GOTFactionRelations.setRelations(VOLANTIS, SOTHORYOS, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(VOLANTIS, TYROSH, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(VOLANTIS, DORNE, GOTFactionRelations.Relation.ENEMY);
		GOTFactionRelations.setRelations(YI_TI, IBBEN, GOTFactionRelations.Relation.FRIEND);
		TARGARYEN.addControlZone(new GOTControlZone(GOTWaypoint.KingsLanding, 500));
		TARGARYEN.addRank(10.0f, "guest").makeTitle();
		TARGARYEN.addRank(50.0f, "friend").makeTitle();
		TARGARYEN.addRank(150.0f, "warrior").makeTitle().setPledgeRank();
		TARGARYEN.addRank(200.0f, "leutenant").makeTitle();
		TARGARYEN.addRank(500.0f, "kingsguard").makeTitle();
		TARGARYEN.addRank(1000.0f, "commander").makeTitle();
		TARGARYEN.addRank(2000.0f, "general").makeTitle();
		TARGARYEN.isViolent = true;
		ARRYN.addControlZone(new GOTControlZone(851, 1335, 191));
		ARRYN.addRank(10.0f, "guest").makeTitle().makeAchievement();
		ARRYN.addRank(100.0f, "warrior").setPledgeRank().makeTitle().makeAchievement();
		ARRYN.addRank(1000.0f, "commander").makeTitle().makeAchievement();
		ARRYN.addRank(200.0f, "leutenant").makeTitle().makeAchievement();
		ARRYN.addRank(2000.0f, "general").makeTitle().makeAchievement();
		ARRYN.addRank(50.0f, "friend").makeTitle().makeAchievement();
		ARRYN.addRank(500.0f, "kingsguard").makeTitle().makeAchievement();
		ARRYN.isViolent = false;
		ASSHAI.addControlZone(new GOTControlZone(3264, 2433, 611));
		ASSHAI.addControlZone(new GOTControlZone(4550, 2102, 1122));
		ASSHAI.addRank(10.0f, "guest").makeTitle().makeAchievement();
		ASSHAI.addRank(100.0f, "guard").setPledgeRank().makeTitle().makeAchievement();
		ASSHAI.addRank(1000.0f, "commander").makeTitle().makeAchievement();
		ASSHAI.addRank(50.0f, "friend").makeTitle().makeAchievement();
		ASSHAI.addRank(500.0f, "shadowbinder").makeTitle().makeAchievement();
		ASSHAI.isViolent = true;
		BRAAVOS.addControlZone(new GOTControlZone(1297, 1708, 543));
		BRAAVOS.addRank(10.0f, "guest").makeTitle().makeAchievement();
		BRAAVOS.addRank(100.0f, "warrior").setPledgeRank().makeTitle().makeAchievement();
		BRAAVOS.addRank(1000.0f, "commander").makeTitle().makeAchievement();
		BRAAVOS.addRank(200.0f, "leutenant").makeTitle().makeAchievement();
		BRAAVOS.addRank(2000.0f, "general").makeTitle().makeAchievement();
		BRAAVOS.addRank(50.0f, "friend").makeTitle().makeAchievement();
		BRAAVOS.addRank(500.0f, "kingsguard").makeTitle().makeAchievement();
		BRAAVOS.isViolent = false;
		CROWNLANDS.addControlZone(new GOTControlZone(876, 1566, 168));
		CROWNLANDS.addRank(10.0f, "guest").makeTitle().makeAchievement();
		CROWNLANDS.addRank(100.0f, "warrior").setPledgeRank().makeTitle().makeAchievement();
		CROWNLANDS.addRank(1000.0f, "commander").makeTitle().makeAchievement();
		CROWNLANDS.addRank(200.0f, "leutenant").makeTitle().makeAchievement();
		CROWNLANDS.addRank(2000.0f, "general").makeTitle().makeAchievement();
		CROWNLANDS.addRank(50.0f, "friend").makeTitle().makeAchievement();
		CROWNLANDS.addRank(500.0f, "kingsguard").makeTitle().makeAchievement();
		CROWNLANDS.isViolent = true;
		DORNE.addControlZone(new GOTControlZone(718, 1867, 334));
		DORNE.addRank(10.0f, "guest").makeTitle().makeAchievement();
		DORNE.addRank(100.0f, "warrior").setPledgeRank().makeTitle().makeAchievement();
		DORNE.addRank(1000.0f, "commander").makeTitle().makeAchievement();
		DORNE.addRank(200.0f, "leutenant").makeTitle().makeAchievement();
		DORNE.addRank(2000.0f, "general").makeTitle().makeAchievement();
		DORNE.addRank(50.0f, "friend").makeTitle().makeAchievement();
		DORNE.addRank(500.0f, "kingsguard").makeTitle().makeAchievement();
		DORNE.isViolent = false;
		DOTHRAKI.addControlZone(new GOTControlZone(1828, 1694, 454));
		DOTHRAKI.addControlZone(new GOTControlZone(2177, 1661, 394));
		DOTHRAKI.addControlZone(new GOTControlZone(2642, 1995, 325));
		DOTHRAKI.addControlZone(new GOTControlZone(2648, 1586, 429));
		DOTHRAKI.addRank(100.0f, "khal").setPledgeRank().makeTitle().makeAchievement();
		DOTHRAKI.isViolent = true;
		DRAGONSTONE.addControlZone(new GOTControlZone(764, 608, 133));
		DRAGONSTONE.addControlZone(new GOTControlZone(876, 1566, 168));
		DRAGONSTONE.addRank(10.0f, "guest").makeTitle().makeAchievement();
		DRAGONSTONE.addRank(100.0f, "warrior").setPledgeRank().makeTitle().makeAchievement();
		DRAGONSTONE.addRank(1000.0f, "commander").makeTitle().makeAchievement();
		DRAGONSTONE.addRank(200.0f, "leutenant").makeTitle().makeAchievement();
		DRAGONSTONE.addRank(2000.0f, "general").makeTitle().makeAchievement();
		DRAGONSTONE.addRank(50.0f, "friend").makeTitle().makeAchievement();
		DRAGONSTONE.addRank(500.0f, "kingsguard").makeTitle().makeAchievement();
		DRAGONSTONE.isViolent = true;
		GHISCAR.addControlZone(new GOTControlZone(1069, 1952, 94));
		GHISCAR.addControlZone(new GOTControlZone(2144, 2375, 533));
		GHISCAR.addRank(10.0f, "guest").makeTitle().makeAchievement();
		GHISCAR.addRank(100.0f, "warrior").setPledgeRank().makeTitle().makeAchievement();
		GHISCAR.addRank(1000.0f, "commander").makeTitle().makeAchievement();
		GHISCAR.addRank(200.0f, "leutenant").makeTitle().makeAchievement();
		GHISCAR.addRank(2000.0f, "general").makeTitle().makeAchievement();
		GHISCAR.addRank(50.0f, "friend").makeTitle().makeAchievement();
		GHISCAR.addRank(500.0f, "kingsguard").makeTitle().makeAchievement();
		GHISCAR.isViolent = true;
		HILL_TRIBES.addControlZone(new GOTControlZone(851, 1335, 191));
		HILL_TRIBES.addRank(10.0f, "guest").makeTitle().makeAchievement();
		HILL_TRIBES.addRank(100.0f, "warrior").setPledgeRank().makeTitle().makeAchievement();
		HILL_TRIBES.addRank(1000.0f, "warlord").makeTitle().makeAchievement();
		HILL_TRIBES.addRank(200.0f, "bearer").makeTitle().makeAchievement();
		HILL_TRIBES.addRank(2000.0f, "chieftain").makeTitle().makeAchievement();
		HILL_TRIBES.addRank(50.0f, "kinsman").makeTitle().makeAchievement();
		HILL_TRIBES.addRank(500.0f, "avenger").makeTitle().makeAchievement();
		HILL_TRIBES.isViolent = true;
		IBBEN.addControlZone(new GOTControlZone(2728, 1123, 304));
		IBBEN.addRank(10.0f, "guest").makeTitle().makeAchievement();
		IBBEN.addRank(100.0f, "warrior").setPledgeRank().makeTitle().makeAchievement();
		IBBEN.addRank(1000.0f, "commander").makeTitle().makeAchievement();
		IBBEN.addRank(200.0f, "leutenant").makeTitle().makeAchievement();
		IBBEN.addRank(2000.0f, "general").makeTitle().makeAchievement();
		IBBEN.addRank(50.0f, "friend").makeTitle().makeAchievement();
		IBBEN.addRank(500.0f, "kingsguard").makeTitle().makeAchievement();
		IBBEN.isViolent = false;
		IRONBORN.addControlZone(new GOTControlZone(1069, 1952, 94));
		IRONBORN.addControlZone(new GOTControlZone(513, 1102, 348));
		IRONBORN.addControlZone(new GOTControlZone(623, 1519, 280));
		IRONBORN.addRank(10.0f, "guest").makeTitle().makeAchievement();
		IRONBORN.addRank(100.0f, "warrior").setPledgeRank().makeTitle().makeAchievement();
		IRONBORN.addRank(1000.0f, "commander").makeTitle().makeAchievement();
		IRONBORN.addRank(200.0f, "leutenant").makeTitle().makeAchievement();
		IRONBORN.addRank(2000.0f, "general").makeTitle().makeAchievement();
		IRONBORN.addRank(50.0f, "friend").makeTitle().makeAchievement();
		IRONBORN.addRank(500.0f, "kingsguard").makeTitle().makeAchievement();
		IRONBORN.isViolent = true;
		JOGOS.addControlZone(new GOTControlZone(3088, 2508, 430));
		JOGOS.addControlZone(new GOTControlZone(3809, 1955, 1005));
		JOGOS.addRank(100.0f, "chief").setPledgeRank().makeTitle().makeAchievement();
		JOGOS.isViolent = true;
		LHAZAR.addControlZone(new GOTControlZone(2507, 2002, 269));
		LHAZAR.addRank(10.0f, "guest").makeTitle().makeAchievement();
		LHAZAR.addRank(100.0f, "kinsman").setPledgeRank().makeTitle().makeAchievement();
		LHAZAR.addRank(1000.0f, "chief").makeTitle().makeAchievement();
		LHAZAR.addRank(250.0f, "hunter").makeTitle().makeAchievement();
		LHAZAR.addRank(3000.0f, "greatchief").makeTitle().makeAchievement();
		LHAZAR.addRank(50.0f, "friend").makeTitle().makeAchievement();
		LHAZAR.addRank(500.0f, "warrior").makeTitle().makeAchievement();
		LHAZAR.isViolent = false;
		LORATH.addControlZone(new GOTControlZone(1297, 1708, 543));
		LORATH.addControlZone(new GOTControlZone(1905, 1307, 112));
		LORATH.addRank(10.0f, "guest").makeTitle().makeAchievement();
		LORATH.addRank(100.0f, "warrior").setPledgeRank().makeTitle().makeAchievement();
		LORATH.addRank(1000.0f, "commander").makeTitle().makeAchievement();
		LORATH.addRank(200.0f, "leutenant").makeTitle().makeAchievement();
		LORATH.addRank(2000.0f, "general").makeTitle().makeAchievement();
		LORATH.addRank(50.0f, "friend").makeTitle().makeAchievement();
		LORATH.addRank(500.0f, "kingsguard").makeTitle().makeAchievement();
		LORATH.isViolent = false;
		LYS.addControlZone(new GOTControlZone(1297, 1708, 543));
		LYS.addRank(10.0f, "guest").makeTitle().makeAchievement();
		LYS.addRank(100.0f, "warrior").setPledgeRank().makeTitle().makeAchievement();
		LYS.addRank(1000.0f, "commander").makeTitle().makeAchievement();
		LYS.addRank(200.0f, "leutenant").makeTitle().makeAchievement();
		LYS.addRank(2000.0f, "general").makeTitle().makeAchievement();
		LYS.addRank(50.0f, "friend").makeTitle().makeAchievement();
		LYS.addRank(500.0f, "kingsguard").makeTitle().makeAchievement();
		LYS.isViolent = false;
		MOSSOVY.addControlZone(new GOTControlZone(5025, 1442, 308));
		MOSSOVY.addControlZone(new GOTControlZone(4604, 2283, 210));
		MOSSOVY.addControlZone(new GOTControlZone(4466, 1677, 660));
		MOSSOVY.addControlZone(new GOTControlZone(3914, 2135, 765));
		MOSSOVY.addRank(10.0f, "guest").makeTitle().makeAchievement();
		MOSSOVY.addRank(100.0f, "warrior").setPledgeRank().makeTitle().makeAchievement();
		MOSSOVY.addRank(50.0f, "friend").makeTitle().makeAchievement();
		MOSSOVY.addRank(500.0f, "hunter").makeTitle().makeAchievement();
		MOSSOVY.isViolent = true;
		MYR.addControlZone(new GOTControlZone(1297, 1708, 543));
		MYR.addRank(10.0f, "guest").makeTitle().makeAchievement();
		MYR.addRank(100.0f, "warrior").setPledgeRank().makeTitle().makeAchievement();
		MYR.addRank(1000.0f, "commander").makeTitle().makeAchievement();
		MYR.addRank(200.0f, "leutenant").makeTitle().makeAchievement();
		MYR.addRank(2000.0f, "general").makeTitle().makeAchievement();
		MYR.addRank(50.0f, "friend").makeTitle().makeAchievement();
		MYR.addRank(500.0f, "kingsguard").makeTitle().makeAchievement();
		MYR.isViolent = false;
		NIGHT_WATCH.addControlZone(new GOTControlZone(757, 573, 267));
		NIGHT_WATCH.addRank(10.0f, "friend").makeTitle().makeAchievement();
		NIGHT_WATCH.addRank(100.0f, "ranger").setPledgeRank().makeTitle().makeAchievement();
		NIGHT_WATCH.addRank(1000.0f, "champion").makeTitle().makeAchievement();
		NIGHT_WATCH.addRank(200.0f, "ohtar").makeTitle().makeAchievement();
		NIGHT_WATCH.addRank(2000.0f, "captain").makeTitle().makeAchievement();
		NIGHT_WATCH.addRank(50.0f, "warden").makeTitle().makeAchievement();
		NIGHT_WATCH.addRank(500.0f, "roquen").makeTitle().makeAchievement();
		NIGHT_WATCH.isViolent = false;
		NORTH.addControlZone(new GOTControlZone(749, 1111, 605));
		NORTH.addRank(10.0f, "guest").makeTitle().makeAchievement();
		NORTH.addRank(100.0f, "atarms").setPledgeRank().makeTitle().makeAchievement();
		NORTH.addRank(1000.0f, "champion").makeTitle().makeAchievement();
		NORTH.addRank(1500.0f, "captain").makeTitle().makeAchievement();
		NORTH.addRank(200.0f, "soldier").makeTitle().makeAchievement();
		NORTH.addRank(3000.0f, "lord").makeTitle().makeAchievement();
		NORTH.addRank(50.0f, "friend").makeTitle().makeAchievement();
		NORTH.addRank(500.0f, "knight").makeTitle().makeAchievement();
		NORTH.isViolent = false;
		NORVOS.addControlZone(new GOTControlZone(1297, 1708, 543));
		NORVOS.addRank(10.0f, "guest").makeTitle().makeAchievement();
		NORVOS.addRank(100.0f, "warrior").setPledgeRank().makeTitle().makeAchievement();
		NORVOS.addRank(1000.0f, "commander").makeTitle().makeAchievement();
		NORVOS.addRank(200.0f, "leutenant").makeTitle().makeAchievement();
		NORVOS.addRank(2000.0f, "general").makeTitle().makeAchievement();
		NORVOS.addRank(50.0f, "friend").makeTitle().makeAchievement();
		NORVOS.addRank(500.0f, "kingsguard").makeTitle().makeAchievement();
		NORVOS.isViolent = false;
		PENTOS.addControlZone(new GOTControlZone(1297, 1708, 543));
		PENTOS.addRank(10.0f, "guest").makeTitle().makeAchievement();
		PENTOS.addRank(100.0f, "warrior").setPledgeRank().makeTitle().makeAchievement();
		PENTOS.addRank(1000.0f, "commander").makeTitle().makeAchievement();
		PENTOS.addRank(200.0f, "leutenant").makeTitle().makeAchievement();
		PENTOS.addRank(2000.0f, "general").makeTitle().makeAchievement();
		PENTOS.addRank(50.0f, "friend").makeTitle().makeAchievement();
		PENTOS.addRank(500.0f, "kingsguard").makeTitle().makeAchievement();
		PENTOS.isViolent = false;
		QARTH.addControlZone(new GOTControlZone(2742, 2232, 248));
		QARTH.addRank(10.0f, "guest").makeTitle().makeAchievement();
		QARTH.addRank(100.0f, "warrior").setPledgeRank().makeTitle().makeAchievement();
		QARTH.addRank(1000.0f, "commander").makeTitle().makeAchievement();
		QARTH.addRank(200.0f, "leutenant").makeTitle().makeAchievement();
		QARTH.addRank(2000.0f, "general").makeTitle().makeAchievement();
		QARTH.addRank(50.0f, "friend").makeTitle().makeAchievement();
		QARTH.addRank(500.0f, "kingsguard").makeTitle().makeAchievement();
		QARTH.isViolent = false;
		QOHOR.addControlZone(new GOTControlZone(1297, 1708, 543));
		QOHOR.addRank(10.0f, "guest").makeTitle().makeAchievement();
		QOHOR.addRank(100.0f, "warrior").setPledgeRank().makeTitle().makeAchievement();
		QOHOR.addRank(1000.0f, "commander").makeTitle().makeAchievement();
		QOHOR.addRank(200.0f, "leutenant").makeTitle().makeAchievement();
		QOHOR.addRank(2000.0f, "general").makeTitle().makeAchievement();
		QOHOR.addRank(50.0f, "friend").makeTitle().makeAchievement();
		QOHOR.addRank(500.0f, "kingsguard").makeTitle().makeAchievement();
		QOHOR.isViolent = false;
		REACH.addControlZone(new GOTControlZone(401, 1939, 183));
		REACH.addControlZone(new GOTControlZone(619, 1624, 300));
		REACH.addRank(10.0f, "guest").makeTitle().makeAchievement();
		REACH.addRank(100.0f, "warrior").setPledgeRank().makeTitle().makeAchievement();
		REACH.addRank(1000.0f, "commander").makeTitle().makeAchievement();
		REACH.addRank(200.0f, "leutenant").makeTitle().makeAchievement();
		REACH.addRank(2000.0f, "general").makeTitle().makeAchievement();
		REACH.addRank(50.0f, "friend").makeTitle().makeAchievement();
		REACH.addRank(500.0f, "kingsguard").makeTitle().makeAchievement();
		REACH.isViolent = false;
		RIVERLANDS.addControlZone(new GOTControlZone(703, 1441, 245));
		RIVERLANDS.addRank(10.0f, "guest").makeTitle().makeAchievement();
		RIVERLANDS.addRank(100.0f, "warrior").setPledgeRank().makeTitle().makeAchievement();
		RIVERLANDS.addRank(1000.0f, "commander").makeTitle().makeAchievement();
		RIVERLANDS.addRank(200.0f, "leutenant").makeTitle().makeAchievement();
		RIVERLANDS.addRank(2000.0f, "general").makeTitle().makeAchievement();
		RIVERLANDS.addRank(50.0f, "friend").makeTitle().makeAchievement();
		RIVERLANDS.addRank(500.0f, "kingsguard").makeTitle().makeAchievement();
		RIVERLANDS.isViolent = false;
		SOTHORYOS.addControlZone(new GOTControlZone(2264, 3542, 1050));
		SOTHORYOS.addRank(10.0f, "guest").makeTitle().makeAchievement();
		SOTHORYOS.addRank(100.0f, "forestman").setPledgeRank().makeTitle().makeAchievement();
		SOTHORYOS.addRank(1000.0f, "warlord").makeTitle().makeAchievement();
		SOTHORYOS.addRank(200.0f, "warrior").makeTitle().makeAchievement();
		SOTHORYOS.addRank(3000.0f, "splendour").makeTitle().makeAchievement();
		SOTHORYOS.addRank(50.0f, "friend").makeTitle().makeAchievement();
		SOTHORYOS.addRank(500.0f, "champion").makeTitle().makeAchievement();
		SOTHORYOS.isViolent = false;
		STORMLANDS.addControlZone(new GOTControlZone(770, 1718, 270));
		STORMLANDS.addRank(10.0f, "guest").makeTitle().makeAchievement();
		STORMLANDS.addRank(100.0f, "warrior").setPledgeRank().makeTitle().makeAchievement();
		STORMLANDS.addRank(1000.0f, "commander").makeTitle().makeAchievement();
		STORMLANDS.addRank(200.0f, "leutenant").makeTitle().makeAchievement();
		STORMLANDS.addRank(2000.0f, "general").makeTitle().makeAchievement();
		STORMLANDS.addRank(50.0f, "friend").makeTitle().makeAchievement();
		STORMLANDS.addRank(500.0f, "kingsguard").makeTitle().makeAchievement();
		STORMLANDS.isViolent = false;
		SUMMER_ISLANDS.addControlZone(new GOTControlZone(1714, 2516, 777));
		SUMMER_ISLANDS.addRank(10.0f, "guest").makeTitle().makeAchievement();
		SUMMER_ISLANDS.addRank(100.0f, "warrior").setPledgeRank().makeTitle().makeAchievement();
		SUMMER_ISLANDS.addRank(1000.0f, "commander").makeTitle().makeAchievement();
		SUMMER_ISLANDS.addRank(200.0f, "leutenant").makeTitle().makeAchievement();
		SUMMER_ISLANDS.addRank(2000.0f, "general").makeTitle().makeAchievement();
		SUMMER_ISLANDS.addRank(50.0f, "friend").makeTitle().makeAchievement();
		SUMMER_ISLANDS.addRank(500.0f, "kingsguard").makeTitle().makeAchievement();
		SUMMER_ISLANDS.isViolent = false;
		TYROSH.addControlZone(new GOTControlZone(1297, 1708, 543));
		TYROSH.addRank(10.0f, "guest").makeTitle().makeAchievement();
		TYROSH.addRank(100.0f, "warrior").setPledgeRank().makeTitle().makeAchievement();
		TYROSH.addRank(1000.0f, "commander").makeTitle().makeAchievement();
		TYROSH.addRank(200.0f, "leutenant").makeTitle().makeAchievement();
		TYROSH.addRank(2000.0f, "general").makeTitle().makeAchievement();
		TYROSH.addRank(50.0f, "friend").makeTitle().makeAchievement();
		TYROSH.addRank(500.0f, "kingsguard").makeTitle().makeAchievement();
		TYROSH.isViolent = false;
		ULTHOS.addControlZone(new GOTControlZone(3766, 3335, 729));
		ULTHOS.addControlZone(new GOTControlZone(4609, 2902, 756));
		ULTHOS.addControlZone(new GOTControlZone(5800, 3085, 1056));
		ULTHOS.addControlZone(new GOTControlZone(6490, 2224, 333));
		ULTHOS.addControlZone(new GOTControlZone(6641, 3759, 231));
		ULTHOS.isViolent = true;
		VOLANTIS.addControlZone(new GOTControlZone(1297, 1708, 543));
		VOLANTIS.addControlZone(new GOTControlZone(1904, 2146, 554));
		VOLANTIS.addRank(10.0f, "guest").makeTitle().makeAchievement();
		VOLANTIS.addRank(100.0f, "warrior").setPledgeRank().makeTitle().makeAchievement();
		VOLANTIS.addRank(1000.0f, "commander").makeTitle().makeAchievement();
		VOLANTIS.addRank(200.0f, "leutenant").makeTitle().makeAchievement();
		VOLANTIS.addRank(2000.0f, "general").makeTitle().makeAchievement();
		VOLANTIS.addRank(50.0f, "friend").makeTitle().makeAchievement();
		VOLANTIS.addRank(500.0f, "kingsguard").makeTitle().makeAchievement();
		VOLANTIS.isViolent = true;
		WESTERLANDS.addControlZone(new GOTControlZone(703, 1416, 550));
		WESTERLANDS.addRank(10.0f, "guest").makeTitle().makeAchievement();
		WESTERLANDS.addRank(100.0f, "warrior").setPledgeRank().makeTitle().makeAchievement();
		WESTERLANDS.addRank(1000.0f, "commander").makeTitle().makeAchievement();
		WESTERLANDS.addRank(200.0f, "leutenant").makeTitle().makeAchievement();
		WESTERLANDS.addRank(2000.0f, "general").makeTitle().makeAchievement();
		WESTERLANDS.addRank(50.0f, "friend").makeTitle().makeAchievement();
		WESTERLANDS.addRank(500.0f, "kingsguard").makeTitle().makeAchievement();
		WESTERLANDS.isViolent = true;
		WHITE_WALKER.addControlZone(new GOTControlZone(360, 297, 290));
		WHITE_WALKER.addControlZone(new GOTControlZone(494, 551, 206));
		WHITE_WALKER.addControlZone(new GOTControlZone(546, 245, 241));
		WHITE_WALKER.addControlZone(new GOTControlZone(667, 239, 236));
		WHITE_WALKER.addControlZone(new GOTControlZone(667, 239, 236));
		WHITE_WALKER.addControlZone(new GOTControlZone(696, 504, 207));
		WHITE_WALKER.addRank(1000.0f, "king").setPledgeRank().makeTitle().makeAchievement();
		WHITE_WALKER.isViolent = true;
		WILDLING.addControlZone(new GOTControlZone(757, 573, 267));
		WILDLING.addRank(10.0f, "thrall").makeTitle().makeAchievement();
		WILDLING.addRank(100.0f, "kinsman").setPledgeRank().makeTitle().makeAchievement();
		WILDLING.addRank(1000.0f, "warlord").makeTitle().makeAchievement();
		WILDLING.addRank(200.0f, "warrior").makeTitle().makeAchievement();
		WILDLING.addRank(2000.0f, "chieftain").makeTitle().makeAchievement();
		WILDLING.addRank(50.0f, "servant").makeTitle().makeAchievement();
		WILDLING.addRank(500.0f, "champion").makeTitle().makeAchievement();
		WILDLING.isViolent = true;
		YI_TI.addControlZone(new GOTControlZone(3088, 2508, 430));
		YI_TI.addControlZone(new GOTControlZone(3809, 1955, 1005));
		YI_TI.addRank(10.0f, "bondsman").makeTitle().makeAchievement();
		YI_TI.addRank(100.0f, "clansman").setPledgeRank().makeTitle().makeAchievement();
		YI_TI.addRank(1000.0f, "golden").makeTitle().makeAchievement();
		YI_TI.addRank(1500.0f, "warlord").makeTitle().makeAchievement();
		YI_TI.addRank(200.0f, "warrior").makeTitle().makeAchievement();
		YI_TI.addRank(3000.0f, "chieftain").makeTitle().makeAchievement();
		YI_TI.addRank(50.0f, "levyman").makeTitle().makeAchievement();
		YI_TI.addRank(500.0f, "champion").makeTitle().makeAchievement();
		YI_TI.isViolent = true;
	}
}