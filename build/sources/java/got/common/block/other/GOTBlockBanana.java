package got.common.block.other;

import java.util.Random;

import cpw.mods.fml.relauncher.*;
import got.common.GOTLevelData;
import got.common.database.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.*;

public class GOTBlockBanana extends GOTBlockHangingFruit {
	@SideOnly(value = Side.CLIENT)
	@Override
	public Item getItem(World world, int i, int j, int k) {
		return GOTRegistry.banana;
	}

	@Override
	public Item getItemDropped(int i, Random random, int j) {
		return GOTRegistry.banana;
	}

	@Override
	public boolean removedByPlayer(World world, EntityPlayer entityplayer, int i, int j, int k, boolean willHarvest) {
		boolean flag = super.removedByPlayer(world, entityplayer, i, j, k, willHarvest);
		if (flag && !world.isRemote) {
			GOTLevelData.getData(entityplayer).addAchievement(GOTAchievement.OBAMA);
		}
		return flag;
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int i, int j, int k) {
		int dir = world.getBlockMetadata(i, j, k);
		switch (dir) {
		case 0: {
			setBlockBounds(0.375f, 0.1875f, 0.0f, 0.625f, 0.9375f, 0.25f);
			break;
		}
		case 1: {
			setBlockBounds(0.375f, 0.1875f, 0.75f, 0.625f, 0.9375f, 1.0f);
			break;
		}
		case 2: {
			setBlockBounds(0.0f, 0.1875f, 0.375f, 0.25f, 0.9375f, 0.625f);
			break;
		}
		case 3: {
			setBlockBounds(0.75f, 0.1875f, 0.375f, 1.0f, 0.9375f, 0.625f);
		}
		}
	}
}
