package got.common.world.biome.essos;

import got.common.database.GOTSpawnList;
import got.common.world.map.GOTWaypoint;
import got.common.world.spawning.GOTBiomeSpawnList;
import got.common.world.spawning.GOTBiomeSpawnList.SpawnListContainer;
import got.common.world.structure.essos.yiti.GOTWaypointYiTiTown;

public class GOTBiomeYiTiFlat extends GOTBiomeYiTi {
	public GOTBiomeYiTiFlat(int i, boolean major) {
		super(i, major);
		clearBiomeVariants();
		decorator.clearVillages();
		decorator.treesPerChunk = -1;

		SpawnListContainer[] container = new SpawnListContainer[4];
		container[0] = GOTBiomeSpawnList.entry(GOTSpawnList.YITI_CIVILIAN, 10).setSpawnChance(500);
		container[1] = GOTBiomeSpawnList.entry(GOTSpawnList.YITI_MILITARY, 4).setSpawnChance(500);
		container[2] = GOTBiomeSpawnList.entry(GOTSpawnList.YITI_SAMURAI, 2).setSpawnChance(500);
		container[3] = GOTBiomeSpawnList.entry(GOTSpawnList.YITI_BOMBARDIER, 1).setSpawnChance(500);
		npcSpawnList.newFactionList(100).add(container);

		SpawnListContainer[] container1 = new SpawnListContainer[1];
		container1[0] = GOTBiomeSpawnList.entry(GOTSpawnList.JOGOS_MILITARY, 10);
		npcSpawnList.newFactionList(0).add(container1);

        SpawnListContainer[] containerLSR = new SpawnListContainer[1];
        containerLSR[0] = GOTBiomeSpawnList.entry(GOTSpawnList.UNRELIABLE, 10).setSpawnChance(500);
        this.npcSpawnList.newFactionList(5).add(containerLSR);

		GOTWaypointYiTiTown town = new GOTWaypointYiTiTown(this, 0.0f);
		town.affix(GOTWaypoint.TraderTown, 0, -1);
		town.affix(GOTWaypoint.SiQo, 1, 0);
		town.affix(GOTWaypoint.Tiqui, -1, -1);
		town.affix(GOTWaypoint.Asabhad, -1, 0);
		town.affix(GOTWaypoint.Yin, 0, 1);
		town.affix(GOTWaypoint.Jinqi, -1, 0);
		town.affix(GOTWaypoint.Huiji);
		town.affix(GOTWaypoint.Vaibei);
		town.affix(GOTWaypoint.Manjin);
		town.affix(GOTWaypoint.Lizhao);
		town.affix(GOTWaypoint.Baoji);
		town.affix(GOTWaypoint.Yibin);
		town.affix(GOTWaypoint.Yunnan);
		town.affix(GOTWaypoint.Eijiang);
		town.affix(GOTWaypoint.LesserMoraq);
		town.affix(GOTWaypoint.PortMoraq);
		town.affix(GOTWaypoint.Vahar);
		town.affix(GOTWaypoint.Faros);
		town.affix(GOTWaypoint.Zabhad);
		town.affix(GOTWaypoint.Marahai);
		town.affix(GOTWaypoint.Turrani);
		town.affix(GOTWaypoint.LengYi);
		town.affix(GOTWaypoint.LengMa);
		decorator.addVillage(town);
	}

	@Override
	public boolean getEnableRiver() {
		return false;
	}
}