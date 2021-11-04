package got.common.database;

import java.util.*;

import got.common.entity.animal.GOTEntityUlthosSpider;
import got.common.entity.essos.*;
import got.common.entity.essos.braavos.*;
import got.common.entity.essos.dothraki.*;
import got.common.entity.essos.ghiscar.*;
import got.common.entity.essos.ibben.*;
import got.common.entity.essos.jogos.*;
import got.common.entity.essos.lhazar.GOTEntityLhazarMan;
import got.common.entity.essos.lorath.*;
import got.common.entity.essos.lys.*;
import got.common.entity.essos.mossovy.*;
import got.common.entity.essos.myr.*;
import got.common.entity.essos.norvos.*;
import got.common.entity.essos.pentos.*;
import got.common.entity.essos.qarth.*;
import got.common.entity.essos.qohor.*;
import got.common.entity.essos.tyrosh.*;
import got.common.entity.essos.volantis.*;
import got.common.entity.essos.yiti.*;
import got.common.entity.other.*;
import got.common.entity.sothoryos.sothoryos.*;
import got.common.entity.sothoryos.summer.*;
import got.common.entity.westeros.arryn.*;
import got.common.entity.westeros.crownlands.*;
import got.common.entity.westeros.dorne.*;
import got.common.entity.westeros.dragonstone.*;
import got.common.entity.westeros.gift.*;
import got.common.entity.westeros.hillmen.*;
import got.common.entity.westeros.ice.*;
import got.common.entity.westeros.ironborn.*;
import got.common.entity.westeros.north.*;
import got.common.entity.westeros.north.hillmen.*;
import got.common.entity.westeros.reach.*;
import got.common.entity.westeros.riverlands.*;
import got.common.entity.westeros.stormlands.*;
import got.common.entity.westeros.targaryen.*;
import got.common.entity.westeros.westerlands.*;
import got.common.entity.westeros.wildling.*;
import got.common.entity.westeros.wildling.thenn.*;
import got.common.faction.GOTFaction;
import got.common.world.spawning.GOTSpawnEntry;
import net.minecraft.util.WeightedRandom;
import net.minecraft.world.World;

public class GOTSpawnList {
	public static GOTSpawnList UNRELIABLE = new GOTSpawnList(new GOTSpawnEntry(GOTEntityThief.class, 5, 1, 2), new GOTSpawnEntry(GOTEntityScrapTrader.class, 5, 1, 2));
    public static GOTSpawnList ARRYN_CIVILIAN = new GOTSpawnList(new GOTSpawnEntry(GOTEntityArrynMan.class, 10, 2, 4));
	public static GOTSpawnList ARRYN_GUARDIAN = new GOTSpawnList(new GOTSpawnEntry(GOTEntityArrynGuard.class, 10, 1, 3));
	public static GOTSpawnList ARRYN_MILITARY = new GOTSpawnList(new GOTSpawnEntry(GOTEntityArrynLevyman.class, 10, 1, 3), new GOTSpawnEntry(GOTEntityArrynLevymanArcher.class, 5, 1, 3));
	public static GOTSpawnList BRAAVOS_CIVILIAN = new GOTSpawnList(new GOTSpawnEntry(GOTEntityBraavosMan.class, 10, 2, 4));
	public static GOTSpawnList BRAAVOS_MILITARY = new GOTSpawnList(new GOTSpawnEntry(GOTEntityBraavosWarrior.class, 10, 1, 3), new GOTSpawnEntry(GOTEntityBraavosArcher.class, 5, 1, 3));
	public static GOTSpawnList CROWNLANDS_CIVILIAN = new GOTSpawnList(new GOTSpawnEntry(GOTEntityCrownlandsMan.class, 10, 2, 4));
	public static GOTSpawnList CROWNLANDS_GUARDIAN = new GOTSpawnList(new GOTSpawnEntry(GOTEntityCrownlandsGuard.class, 10, 1, 3));
	public static GOTSpawnList CROWNLANDS_MILITARY = new GOTSpawnList(new GOTSpawnEntry(GOTEntityCrownlandsLevyman.class, 10, 1, 3), new GOTSpawnEntry(GOTEntityCrownlandsLevymanArcher.class, 5, 1, 3));
	public static GOTSpawnList DORNE_CIVILIAN = new GOTSpawnList(new GOTSpawnEntry(GOTEntityDorneMan.class, 10, 2, 4));
	public static GOTSpawnList DORNE_CONQUEST = new GOTSpawnList(new GOTSpawnEntry(GOTEntityDorneSoldier.class, 10, 1, 3), new GOTSpawnEntry(GOTEntityDorneSoldierArcher.class, 5, 1, 3));
	public static GOTSpawnList DORNE_MILITARY = new GOTSpawnList(new GOTSpawnEntry(GOTEntityDorneLevyman.class, 10, 1, 3), new GOTSpawnEntry(GOTEntityDorneLevymanArcher.class, 5, 1, 3));
	public static GOTSpawnList DOTHRAKI_CIVILIAN = new GOTSpawnList(new GOTSpawnEntry(GOTEntityDothraki.class, 10, 2, 4), new GOTSpawnEntry(GOTEntityDothrakiKhalin.class, 1, 1, 2));
	public static GOTSpawnList DOTHRAKI_MILITARY = new GOTSpawnList(new GOTSpawnEntry(GOTEntityDothraki.class, 10, 2, 4), new GOTSpawnEntry(GOTEntityDothrakiArcher.class, 5, 1, 3));
	public static GOTSpawnList DRAGONSTONE_CIVILIAN = new GOTSpawnList(new GOTSpawnEntry(GOTEntityDragonstoneMan.class, 10, 2, 4));
	public static GOTSpawnList DRAGONSTONE_CONQUEST = new GOTSpawnList(new GOTSpawnEntry(GOTEntityDragonstoneSoldier.class, 10, 1, 3), new GOTSpawnEntry(GOTEntityDragonstoneSoldierArcher.class, 5, 1, 3));
	public static GOTSpawnList DRAGONSTONE_MILITARY = new GOTSpawnList(new GOTSpawnEntry(GOTEntityDragonstoneLevyman.class, 10, 1, 3), new GOTSpawnEntry(GOTEntityDragonstoneLevymanArcher.class, 5, 1, 3));
	public static GOTSpawnList GHISCAR_CIVILIAN = new GOTSpawnList(new GOTSpawnEntry(GOTEntityGhiscarMan.class, 10, 2, 4));
	public static GOTSpawnList GHISCAR_CORSAIR = new GOTSpawnList(new GOTSpawnEntry(GOTEntityGhiscarCorsair.class, 10, 1, 3));
	public static GOTSpawnList GHISCAR_GUARDIAN = new GOTSpawnList(new GOTSpawnEntry(GOTEntityGhiscarGuard.class, 10, 1, 3));
	public static GOTSpawnList GHISCAR_HARPY = new GOTSpawnList(new GOTSpawnEntry(GOTEntityGhiscarHarpy.class, 10, 1, 3));
	public static GOTSpawnList GHISCAR_MILITARY = new GOTSpawnList(new GOTSpawnEntry(GOTEntityGhiscarLevyman.class, 10, 1, 3), new GOTSpawnEntry(GOTEntityGhiscarArcher.class, 5, 1, 3));
	public static GOTSpawnList GHISCAR_UNSULLIED = new GOTSpawnList(new GOTSpawnEntry(GOTEntityGhiscarUnsullied.class, 10, 1, 3));
	public static GOTSpawnList GIFT_CIVILIAN = new GOTSpawnList(new GOTSpawnEntry(GOTEntityGiftMan.class, 10, 1, 3));
	public static GOTSpawnList GIFT_GUARDIAN = new GOTSpawnList(new GOTSpawnEntry(GOTEntityGiftGuard.class, 10, 1, 3));
	public static GOTSpawnList HILL_TRIBES_CIVILIAN = new GOTSpawnList(new GOTSpawnEntry(GOTEntityHillman.class, 10, 2, 4));
	public static GOTSpawnList HILL_TRIBES_MILITARY = new GOTSpawnList(new GOTSpawnEntry(GOTEntityHillmanWarrior.class, 10, 1, 3), new GOTSpawnEntry(GOTEntityHillmanArcher.class, 5, 1, 3), new GOTSpawnEntry(GOTEntityHillmanAxeThrower.class, 3, 1, 2), new GOTSpawnEntry(GOTEntityHillmanBerserker.class, 3, 1, 2));
	public static GOTSpawnList IBBEN_CIVILIAN = new GOTSpawnList(new GOTSpawnEntry(GOTEntityIbbenMan.class, 10, 2, 4));
	public static GOTSpawnList IBBEN_CONQUEST = new GOTSpawnList(new GOTSpawnEntry(GOTEntityIbbenWarrior.class, 10, 1, 3), new GOTSpawnEntry(GOTEntityIbbenArcher.class, 5, 1, 2));
	public static GOTSpawnList IFEKEVRON = new GOTSpawnList(new GOTSpawnEntry(GOTEntityIfekevron.class, 10, 1, 3));
	public static GOTSpawnList IRONBORN_CIVILIAN = new GOTSpawnList(new GOTSpawnEntry(GOTEntityIronbornMan.class, 10, 2, 4));
	public static GOTSpawnList IRONBORN_CONQUEST = new GOTSpawnList(new GOTSpawnEntry(GOTEntityIronbornSoldier.class, 10, 1, 3), new GOTSpawnEntry(GOTEntityIronbornSoldierArcher.class, 5, 1, 3));
	public static GOTSpawnList IRONBORN_CORSAIR = new GOTSpawnList(new GOTSpawnEntry(GOTEntityIronbornCorsair.class, 10, 1, 3));
	public static GOTSpawnList IRONBORN_MILITARY = new GOTSpawnList(new GOTSpawnEntry(GOTEntityIronbornLevyman.class, 10, 1, 3), new GOTSpawnEntry(GOTEntityIronbornLevymanArcher.class, 5, 1, 3));
	public static GOTSpawnList JOGOS_MILITARY = new GOTSpawnList(new GOTSpawnEntry(GOTEntityJogos.class, 10, 1, 3), new GOTSpawnEntry(GOTEntityJogosArcher.class, 5, 1, 3));
	public static GOTSpawnList LHAZAR_CIVILIAN = new GOTSpawnList(new GOTSpawnEntry(GOTEntityLhazarMan.class, 10, 2, 4));
	public static GOTSpawnList LORATH_CIVILIAN = new GOTSpawnList(new GOTSpawnEntry(GOTEntityLorathMan.class, 10, 2, 4));
	public static GOTSpawnList LORATH_MILITARY = new GOTSpawnList(new GOTSpawnEntry(GOTEntityLorathWarrior.class, 10, 1, 3), new GOTSpawnEntry(GOTEntityLorathArcher.class, 5, 1, 3));
	public static GOTSpawnList LYS_CIVILIAN = new GOTSpawnList(new GOTSpawnEntry(GOTEntityLysMan.class, 10, 2, 4));
	public static GOTSpawnList LYS_MILITARY = new GOTSpawnList(new GOTSpawnEntry(GOTEntityLysWarrior.class, 10, 1, 3), new GOTSpawnEntry(GOTEntityLysArcher.class, 5, 1, 3));
	public static GOTSpawnList MOSSOVY_WEREWOLF = new GOTSpawnList(new GOTSpawnEntry(GOTEntityMossovyWerewolf.class, 10, 1, 2));
	public static GOTSpawnList MOSSOVY_WITCHER = new GOTSpawnList(new GOTSpawnEntry(GOTEntityMossovyWitcher.class, 10, 1, 1));
	public static GOTSpawnList MYR_CIVILIAN = new GOTSpawnList(new GOTSpawnEntry(GOTEntityMyrMan.class, 10, 2, 4));
	public static GOTSpawnList MYR_MILITARY = new GOTSpawnList(new GOTSpawnEntry(GOTEntityMyrWarrior.class, 10, 1, 3), new GOTSpawnEntry(GOTEntityMyrArcher.class, 5, 1, 3));
	public static GOTSpawnList NORTH_CIVILIAN = new GOTSpawnList(new GOTSpawnEntry(GOTEntityNorthMan.class, 10, 2, 4));
	public static GOTSpawnList NORTH_CONQUEST = new GOTSpawnList(new GOTSpawnEntry(GOTEntityNorthSoldier.class, 10, 1, 3), new GOTSpawnEntry(GOTEntityNorthSoldierArcher.class, 5, 1, 3));
	public static GOTSpawnList NORTH_GUARDIAN = new GOTSpawnList(new GOTSpawnEntry(GOTEntityNorthGuard.class, 10, 1, 3));
	public static GOTSpawnList NORTH_HILLMEN = new GOTSpawnList(new GOTSpawnEntry(GOTEntityNorthHillman.class, 10, 2, 4), new GOTSpawnEntry(GOTEntityNorthHillmanCannibal.class, 5, 1, 2), new GOTSpawnEntry(GOTEntityNorthHillmanMercenary.class, 5, 1, 2), new GOTSpawnEntry(GOTEntityNorthHillmanArcher.class, 5, 1, 3), new GOTSpawnEntry(GOTEntityNorthHillmanWarrior.class, 5, 1, 3));
	public static GOTSpawnList NORTH_MILITARY = new GOTSpawnList(new GOTSpawnEntry(GOTEntityNorthLevyman.class, 10, 1, 3), new GOTSpawnEntry(GOTEntityNorthLevymanArcher.class, 5, 1, 3));
	public static GOTSpawnList NORVOS_CIVILIAN = new GOTSpawnList(new GOTSpawnEntry(GOTEntityNorvosMan.class, 10, 2, 4));
	public static GOTSpawnList NORVOS_MILITARY = new GOTSpawnList(new GOTSpawnEntry(GOTEntityNorvosWarrior.class, 10, 1, 3), new GOTSpawnEntry(GOTEntityNorvosArcher.class, 5, 1, 3));
	public static GOTSpawnList PENTOS_CIVILIAN = new GOTSpawnList(new GOTSpawnEntry(GOTEntityPentosMan.class, 10, 2, 4));
	public static GOTSpawnList PENTOS_MILITARY = new GOTSpawnList(new GOTSpawnEntry(GOTEntityPentosLevyman.class, 10, 1, 3), new GOTSpawnEntry(GOTEntityPentosArcher.class, 5, 1, 3));
	public static GOTSpawnList QARTH_CIVILIAN = new GOTSpawnList(new GOTSpawnEntry(GOTEntityQarthMan.class, 10, 2, 4));
	public static GOTSpawnList QARTH_MILITARY = new GOTSpawnList(new GOTSpawnEntry(GOTEntityQarthWarrior.class, 10, 1, 3), new GOTSpawnEntry(GOTEntityQarthArcher.class, 5, 1, 3));
	public static GOTSpawnList QOHOR_CIVILIAN = new GOTSpawnList(new GOTSpawnEntry(GOTEntityQohorMan.class, 10, 2, 4));
	public static GOTSpawnList QOHOR_MILITARY = new GOTSpawnList(new GOTSpawnEntry(GOTEntityQohorUnsullied.class, 10, 1, 3), new GOTSpawnEntry(GOTEntityQohorArcher.class, 5, 1, 3));
	public static GOTSpawnList REACH_CIVILIAN = new GOTSpawnList(new GOTSpawnEntry(GOTEntityReachMan.class, 10, 2, 4));
	public static GOTSpawnList REACH_CONQUEST = new GOTSpawnList(new GOTSpawnEntry(GOTEntityReachSoldier.class, 10, 1, 3), new GOTSpawnEntry(GOTEntityReachSoldierArcher.class, 5, 1, 3));
	public static GOTSpawnList REACH_GUARDIAN = new GOTSpawnList(new GOTSpawnEntry(GOTEntityReachGuard.class, 10, 1, 3));
	public static GOTSpawnList REACH_MILITARY = new GOTSpawnList(new GOTSpawnEntry(GOTEntityReachLevyman.class, 10, 1, 3), new GOTSpawnEntry(GOTEntityReachLevymanArcher.class, 5, 1, 3));
	public static GOTSpawnList RIVERLANDS_CIVILIAN = new GOTSpawnList(new GOTSpawnEntry(GOTEntityRiverlandsMan.class, 10, 2, 4));
	public static GOTSpawnList RIVERLANDS_CONQUEST = new GOTSpawnList(new GOTSpawnEntry(GOTEntityRiverlandsSoldier.class, 10, 1, 3), new GOTSpawnEntry(GOTEntityRiverlandsSoldierArcher.class, 5, 1, 3));
	public static GOTSpawnList RIVERLANDS_MILITARY = new GOTSpawnList(new GOTSpawnEntry(GOTEntityRiverlandsLevyman.class, 10, 1, 3), new GOTSpawnEntry(GOTEntityRiverlandsLevymanArcher.class, 5, 1, 3));
	public static GOTSpawnList SOTHORYOS_CIVILIAN = new GOTSpawnList(new GOTSpawnEntry(GOTEntitySothoryosMan.class, 10, 2, 4));
	public static GOTSpawnList SOTHORYOS_MILITARY = new GOTSpawnList(new GOTSpawnEntry(GOTEntitySothoryosWarrior.class, 10, 2, 4), new GOTSpawnEntry(GOTEntitySothoryosBlowgunner.class, 5, 1, 3));
	public static GOTSpawnList STORMLANDS_CIVILIAN = new GOTSpawnList(new GOTSpawnEntry(GOTEntityStormlandsMan.class, 10, 2, 4));
	public static GOTSpawnList STORMLANDS_CONQUEST = new GOTSpawnList(new GOTSpawnEntry(GOTEntityStormlandsSoldier.class, 10, 1, 3), new GOTSpawnEntry(GOTEntityStormlandsSoldierArcher.class, 5, 1, 3));
	public static GOTSpawnList STORMLANDS_MILITARY = new GOTSpawnList(new GOTSpawnEntry(GOTEntityStormlandsLevyman.class, 10, 1, 3), new GOTSpawnEntry(GOTEntityStormlandsLevymanArcher.class, 5, 1, 3));
	public static GOTSpawnList SUMMER_CIVILIAN = new GOTSpawnList(new GOTSpawnEntry(GOTEntitySummerMan.class, 10, 2, 4));
	public static GOTSpawnList SUMMER_MILITARY = new GOTSpawnList(new GOTSpawnEntry(GOTEntitySummerWarrior.class, 10, 1, 3), new GOTSpawnEntry(GOTEntitySummerArcher.class, 5, 1, 3));
	public static GOTSpawnList TARGARYEN_CIVILIAN = new GOTSpawnList(new GOTSpawnEntry(GOTEntityTargaryenMan.class, 10, 2, 4));
	public static GOTSpawnList TARGARYEN_CONQUEST = new GOTSpawnList(new GOTSpawnEntry(GOTEntityTargaryenSoldier.class, 10, 1, 3), new GOTSpawnEntry(GOTEntityTargaryenSoldierArcher.class, 5, 1, 3));
	public static GOTSpawnList TARGARYEN_MILITARY = new GOTSpawnList(new GOTSpawnEntry(GOTEntityTargaryenLevyman.class, 10, 1, 3), new GOTSpawnEntry(GOTEntityTargaryenLevymanArcher.class, 5, 1, 3));
	public static GOTSpawnList TYROSH_CIVILIAN = new GOTSpawnList(new GOTSpawnEntry(GOTEntityTyroshMan.class, 10, 2, 4));
	public static GOTSpawnList TYROSH_MILITARY = new GOTSpawnList(new GOTSpawnEntry(GOTEntityTyroshWarrior.class, 10, 1, 3), new GOTSpawnEntry(GOTEntityTyroshArcher.class, 5, 1, 3));
	public static GOTSpawnList ULTHOS = new GOTSpawnList(new GOTSpawnEntry(GOTEntityUlthosSpider.class, 10, 2, 4));
	public static GOTSpawnList VALYRIA = new GOTSpawnList(new GOTSpawnEntry(GOTEntityStoneman.class, 10, 1, 2));
	public static GOTSpawnList VOLANTIS_CIVILIAN = new GOTSpawnList(new GOTSpawnEntry(GOTEntityVolantisMan.class, 10, 2, 4));
	public static GOTSpawnList VOLANTIS_MILITARY = new GOTSpawnList(new GOTSpawnEntry(GOTEntityVolantisWarrior.class, 10, 1, 3), new GOTSpawnEntry(GOTEntityVolantisArcher.class, 5, 1, 3));
	public static GOTSpawnList WALKERS_CONQUEST = new GOTSpawnList(new GOTSpawnEntry(GOTEntityWhiteWalker.class, 10, 1, 1), new GOTSpawnEntry(GOTEntityIceSpider.class, 10, 1, 1));
	public static GOTSpawnList WALKERS_MILITARY = new GOTSpawnList(new GOTSpawnEntry(GOTEntityWhiteWalker.class, 10, 1, 1));
	public static GOTSpawnList WESTERLANDS_CIVILIAN = new GOTSpawnList(new GOTSpawnEntry(GOTEntityWesterlandsMan.class, 10, 2, 4));
	public static GOTSpawnList WESTERLANDS_CONQUEST = new GOTSpawnList(new GOTSpawnEntry(GOTEntityWesterlandsSoldier.class, 10, 1, 3), new GOTSpawnEntry(GOTEntityWesterlandsSoldierArcher.class, 5, 1, 3));
	public static GOTSpawnList WESTERLANDS_GUARDIAN = new GOTSpawnList(new GOTSpawnEntry(GOTEntityWesterlandsGuard.class, 10, 1, 3));
	public static GOTSpawnList WESTERLANDS_MILITARY = new GOTSpawnList(new GOTSpawnEntry(GOTEntityWesterlandsLevyman.class, 10, 1, 3), new GOTSpawnEntry(GOTEntityWesterlandsLevymanArcher.class, 5, 1, 3));
	public static GOTSpawnList WILDING_GIANT = new GOTSpawnList(new GOTSpawnEntry(GOTEntityGiant.class, 10, 1, 1));
	public static GOTSpawnList WILDING_MILITARY = new GOTSpawnList(new GOTSpawnEntry(GOTEntityWildling.class, 10, 2, 4), new GOTSpawnEntry(GOTEntityWildlingArcher.class, 5, 1, 3));
	public static GOTSpawnList WILDING_THENN = new GOTSpawnList(new GOTSpawnEntry(GOTEntityThenn.class, 10, 2, 4), new GOTSpawnEntry(GOTEntityThennBerserker.class, 10, 2, 4), new GOTSpawnEntry(GOTEntityThennArcher.class, 5, 1, 3));
	public static GOTSpawnList YITI_BOMBARDIER = new GOTSpawnList(new GOTSpawnEntry(GOTEntityYiTiBombardier.class, 10, 1, 1));
	public static GOTSpawnList YITI_CIVILIAN = new GOTSpawnList(new GOTSpawnEntry(GOTEntityYiTiMan.class, 10, 1, 3));
	public static GOTSpawnList YITI_MILITARY = new GOTSpawnList(new GOTSpawnEntry(GOTEntityYiTiLevyman.class, 10, 1, 3), new GOTSpawnEntry(GOTEntityYiTiWarrior.class, 10, 2, 4), new GOTSpawnEntry(GOTEntityYiTiArcher.class, 5, 1, 3), new GOTSpawnEntry(GOTEntityYiTiFireThrower.class, 2, 1, 3));
	public static GOTSpawnList YITI_SAMURAI = new GOTSpawnList(new GOTSpawnEntry(GOTEntityYiTiSamurai.class, 10, 2, 4));
	public List<GOTSpawnEntry> spawnList;
	public GOTFaction discoveredFaction;

	public GOTSpawnList(GOTSpawnEntry... entries) {
		spawnList = Arrays.asList(entries);
	}

	public GOTFaction getListCommonFaction(World world) {
		if (discoveredFaction != null) {
			return discoveredFaction;
		}
		GOTFaction commonFaction = null;
		for (GOTSpawnEntry entry : spawnList) {
			Class entityClass = entry.entityClass;
			if (GOTEntityNPC.class.isAssignableFrom(entityClass)) {
				try {
					GOTEntityNPC npc = (GOTEntityNPC) GOTEntityRegistry.createEntityByClass(entityClass, world);
					GOTFaction fac = npc.getFaction();
					if (commonFaction == null) {
						commonFaction = fac;
						continue;
					}
					if (commonFaction == fac) {
						continue;
					}
					throw new IllegalArgumentException("Spawn lists must contain only one faction! Mismatched entity class: " + entityClass.getName());
				} catch (Exception e) {
					e.printStackTrace();
					continue;
				}
			}
			throw new IllegalArgumentException("Spawn list must contain only NPCs - invalid " + entityClass.getName());
		}
		if (commonFaction != null) {
			discoveredFaction = commonFaction;
			return discoveredFaction;
		}
		throw new IllegalArgumentException("Failed to discover faction for spawn list");
	}

	public GOTSpawnEntry getRandomSpawnEntry(Random rand) {
		return (GOTSpawnEntry) WeightedRandom.getRandomItem(rand, spawnList);
	}

	public List<GOTSpawnEntry> getReadOnlyList() {
		return new ArrayList<>(spawnList);
	}
}
