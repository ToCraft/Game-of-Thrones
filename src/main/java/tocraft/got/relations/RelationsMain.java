package tocraft.got.relations;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

@Mod(modid = "gotrelations", name = RelationsMain.NAME, version = RelationsMain.VERSION, dependencies = "required-after:Forge@[10.13.4.1558,)")

public class RelationsMain {
	@Mod.Instance(value = "rel")
	public static RelationsMain instance;
	public static final String NAME = "RelationsAddon for GoT - 17.5";
	public static final String VERSION = "Version 1.0";

	public RelationsMain() {
		instance = this;
	}
	
	@Mod.EventHandler
	public void onServerStarting(FMLServerStartingEvent event) {
		event.registerServerCommand(new RelCommand());
	}
	
	@Mod.EventHandler
	public void preload(FMLPreInitializationEvent event) {
		RelConfig.setupAndLoad(event);
	}
}
