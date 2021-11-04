package got.common.network;

import java.util.Random;

import cpw.mods.fml.common.network.simpleimpl.*;
import got.GOT;
import got.client.effect.GOTEntitySwordCommandMarker;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class GOTPacketLocationFX implements IMessage {
  private Type type;
  
  private double posX;
  
  private double posY;
  
  private double posZ;
  
  public enum Type {
    SWORD_COMMAND;
  }
  
  public GOTPacketLocationFX() {}
  
  public GOTPacketLocationFX(Type t, double x, double y, double z) {
    this.type = t;
    this.posX = x;
    this.posY = y;
    this.posZ = z;
  }
  
  public void toBytes(ByteBuf data) {
    data.writeByte(this.type.ordinal());
    data.writeDouble(this.posX);
    data.writeDouble(this.posY);
    data.writeDouble(this.posZ);
  }
  
  public void fromBytes(ByteBuf data) {
    int typeID = data.readByte();
    this.type = Type.values()[typeID];
    this.posX = data.readDouble();
    this.posY = data.readDouble();
    this.posZ = data.readDouble();
  }
  
  public static class Handler implements IMessageHandler<GOTPacketLocationFX, IMessage> {
    public IMessage onMessage(GOTPacketLocationFX packet, MessageContext context) {
      World world = GOT.proxy.getClientWorld();
      double x = packet.posX;
      double y = packet.posY;
      double z = packet.posZ;
      Random rand = world.rand;
      if (packet.type == GOTPacketLocationFX.Type.SWORD_COMMAND) {
        GOTEntitySwordCommandMarker marker = new GOTEntitySwordCommandMarker(world, x, y + 6.0D, z);
        world.spawnEntityInWorld((Entity)marker);
      } 
      return null;
    }
  }
}