package got.common.entity.animal;

import net.minecraft.world.World;

public class GOTEntityJungleScorpion extends GOTEntityScorpion {
	public GOTEntityJungleScorpion(World world) {
		super(world);
	}

	@Override
	public boolean getCanSpawnHere() {
		return super.getCanSpawnHere() && (spawningFromSpawner || posY < 60.0 || rand.nextInt(100) == 0);
	}
}
