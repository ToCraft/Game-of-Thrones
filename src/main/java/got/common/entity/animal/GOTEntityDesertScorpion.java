package got.common.entity.animal;

import got.common.world.biome.GOTBiome;
import net.minecraft.world.World;

public class GOTEntityDesertScorpion extends GOTEntityScorpion implements GOTBiome.ImmuneToHeat {
	public boolean pyramidSpawned = false;

	public GOTEntityDesertScorpion(World world) {
		super(world);
		isImmuneToFire = true;
	}

	@Override
	public boolean getCanSpawnHere() {
		return super.getCanSpawnHere() && (spawningFromSpawner || pyramidSpawned || posY < 60.0 || rand.nextInt(500) == 0);
	}

	@Override
	public int getRandomScorpionScale() {
		return rand.nextInt(2);
	}

	@Override
	public boolean isValidLightLevel() {
		return spawningFromSpawner || pyramidSpawned || super.isValidLightLevel();
	}
}
