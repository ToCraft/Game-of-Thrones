package got.common.world.structure.other;

import java.util.*;

import net.minecraft.world.ChunkCoordIntPair;

public class GOTVillagePositionCache {
	public static int MAX_SIZE = 20000;
	public Map<ChunkCoordIntPair, GOTLocationInfo> cacheMap = new HashMap<>();

	public void clearCache() {
		cacheMap.clear();
	}

	public ChunkCoordIntPair getChunkKey(int chunkX, int chunkZ) {
		return new ChunkCoordIntPair(chunkX, chunkZ);
	}

	public GOTLocationInfo getLocationAt(int chunkX, int chunkZ) {
		GOTLocationInfo loc = cacheMap.get(getChunkKey(chunkX, chunkZ));
		return loc;
	}

	public GOTLocationInfo markResult(int chunkX, int chunkZ, GOTLocationInfo result) {
		if (cacheMap.size() >= 20000) {
			clearCache();
		}
		cacheMap.put(getChunkKey(chunkX, chunkZ), result);
		return result;
	}
}
