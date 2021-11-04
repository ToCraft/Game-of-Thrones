package got.common.entity.other;

import java.util.*;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.eventhandler.Event;
import got.GOT;
import got.common.*;
import got.common.database.*;
import got.common.faction.GOTFaction;
import got.common.item.other.GOTItemConquestHorn;
import got.common.network.*;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.*;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.event.ForgeEventFactory;

public class GOTEntityInvasionSpawner
extends Entity {
    public float spawnerSpin;
    public float prevSpawnerSpin;
    private int invasionSize;
    public static final int MAX_INVASION_SIZE = 10000;
    private int invasionRemaining;
    private int successiveFailedSpawns = 0;
    private int timeSincePlayerProgress = 0;
    private Map<UUID, Integer> recentPlayerContributors = new HashMap<>();
    private static double INVASION_FOLLOW_RANGE = 40.0;
    public boolean isWarhorn = false;
    public boolean spawnsPersistent = true;
    private List<GOTFaction> bonusFactions = new ArrayList<>();

    public GOTEntityInvasionSpawner(World world) {
        super(world);
        this.setSize(1.5f, 1.5f);
        this.renderDistanceWeight = 4.0;
        this.spawnerSpin = this.rand.nextFloat() * 360.0f;
    }

    public ItemStack getInvasionItem() {
        return this.getInvasionType().getInvasionIcon();
    }

    public void entityInit() {
        this.dataWatcher.addObject(20, (byte)0);
        this.dataWatcher.addObject(21, (short)0);
        this.dataWatcher.addObject(22, (short)0);
    }

    public GOTInvasions getInvasionType() {
        byte i = this.dataWatcher.getWatchableObjectByte(20);
        GOTInvasions type = GOTInvasions.forID(i);
        if (type != null) {
            return type;
        }
        return GOTInvasions.NORTH;
    }

    public void setInvasionType(GOTInvasions type) {
        this.dataWatcher.updateObject(20, ((byte)type.ordinal()));
    }

    private void updateWatchedInvasionValues() {
        if (!this.worldObj.isRemote) {
            this.dataWatcher.updateObject(21, ((short)this.invasionSize));
            this.dataWatcher.updateObject(22, ((short)this.invasionRemaining));
        } else {
            this.invasionSize = this.dataWatcher.getWatchableObjectShort(21);
            this.invasionRemaining = this.dataWatcher.getWatchableObjectShort(22);
        }
    }

    public int getInvasionSize() {
        return this.invasionSize;
    }

    public float getInvasionHealthStatus() {
        return (float)this.invasionRemaining / (float)this.invasionSize;
    }

    public UUID getInvasionID() {
        return this.getUniqueID();
    }

    public boolean canInvasionSpawnHere() {
        if (GOTBannerProtection.isProtected(this.worldObj, this, GOTBannerProtection.forInvasionSpawner(this), false)) {
            return false;
        }
        if (GOTEntityNPCRespawner.isSpawnBlocked(this, this.getInvasionType().invasionFaction)) {
            return false;
        }
        return this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);
    }

    private void playHorn() {
        this.worldObj.playSoundAtEntity(this, "got:item.horn", 4.0f, 0.65f + this.rand.nextFloat() * 0.1f);
    }

    public void startInvasion() {
        this.startInvasion(null);
    }

    public void startInvasion(EntityPlayer announcePlayer) {
        this.startInvasion(announcePlayer, -1);
    }

    public void startInvasion(EntityPlayer announcePlayer, int size) {
        if (size < 0) {
            size = MathHelper.getRandomIntegerInRange(this.rand, 30, 70);
        }
        this.invasionRemaining = this.invasionSize = size;
        this.playHorn();
        double announceRange = INVASION_FOLLOW_RANGE * 2.0;
        List<EntityPlayer> nearbyPlayers = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, this.boundingBox.expand(announceRange, announceRange, announceRange));
        if (announcePlayer != null && !nearbyPlayers.contains(announcePlayer)) {
            nearbyPlayers.add(announcePlayer);
        }
        for (EntityPlayer entityplayer : nearbyPlayers) {
            boolean announce;
            announce = GOTLevelData.getData(entityplayer).getAlignment(this.getInvasionType().invasionFaction) < 0.0f;
            if (entityplayer == announcePlayer) {
                announce = true;
            }
            if (!announce) continue;
            this.announceInvasionTo(entityplayer);
            this.setWatchingInvasion((EntityPlayerMP)entityplayer, false);
        }
    }

    private void announceInvasionTo(EntityPlayer entityplayer) {
        entityplayer.addChatMessage(new ChatComponentTranslation("chat.got.invasion.start", this.getInvasionType().invasionName()));
    }

    public void setWatchingInvasion(EntityPlayerMP entityplayer, boolean overrideAlreadyWatched) {
        GOTPacketInvasionWatch pkt = new GOTPacketInvasionWatch(this, overrideAlreadyWatched);
        GOTPacketHandler.networkWrapper.sendTo(pkt, entityplayer);
    }

    public void selectAppropriateBonusFactions() {
        if (GOTFaction.controlZonesEnabled(this.worldObj)) {
            GOTFaction invasionFaction = this.getInvasionType().invasionFaction;
            for (GOTFaction faction : invasionFaction.getBonusesForKilling()) {
                if (faction.isolationist || !faction.inDefinedControlZone(this.worldObj, this.posX, this.posY, this.posZ, 50)) continue;
                this.bonusFactions.add(faction);
            }
            if (this.bonusFactions.isEmpty()) {
                int nearestRange = 150;
                GOTFaction nearest = null;
                double nearestDist = Double.MAX_VALUE;
                for (GOTFaction faction : invasionFaction.getBonusesForKilling()) {
                    double dist;
                    if (faction.isolationist || ((dist = faction.distanceToNearestControlZoneInRange(this.posX, this.posY, this.posZ, nearestRange)) < 0.0) || nearest != null && (dist >= nearestDist)) continue;
                    nearest = faction;
                    nearestDist = dist;
                }
                if (nearest != null) {
                    this.bonusFactions.add(nearest);
                }
            }
        }
    }

    public void writeEntityToNBT(NBTTagCompound nbt) {
        nbt.setString("InvasionType", this.getInvasionType().codeName());
        nbt.setInteger("InvasionSize", this.invasionSize);
        nbt.setInteger("InvasionRemaining", this.invasionRemaining);
        nbt.setInteger("SuccessiveFailedSpawns", this.successiveFailedSpawns);
        nbt.setInteger("TimeSinceProgress", this.timeSincePlayerProgress);
        if (!this.recentPlayerContributors.isEmpty()) {
            NBTTagList recentTags = new NBTTagList();
            for (Map.Entry<UUID, Integer> e : this.recentPlayerContributors.entrySet()) {
                UUID player = e.getKey();
                int time = e.getValue();
                NBTTagCompound playerData = new NBTTagCompound();
                playerData.setString("Player", player.toString());
                playerData.setShort("Time", (short)time);
                recentTags.appendTag(playerData);
            }
            nbt.setTag("RecentPlayers", recentTags);
        }
        nbt.setBoolean("Warhorn", this.isWarhorn);
        nbt.setBoolean("NPCPersistent", this.spawnsPersistent);
        if (!this.bonusFactions.isEmpty()) {
            NBTTagList bonusTags = new NBTTagList();
            for (GOTFaction f : this.bonusFactions) {
                String fName = f.codeName();
                bonusTags.appendTag(new NBTTagString(fName));
            }
            nbt.setTag("BonusFactions", bonusTags);
        }
    }

    public void readEntityFromNBT(NBTTagCompound nbt) {
        GOTInvasions type = GOTInvasions.forName(nbt.getString("InvasionType"));
        if (type == null && nbt.hasKey("Faction")) {
            String factionName = nbt.getString("Faction");
            type = GOTInvasions.forName(factionName);
        }
        if (type == null || type.invasionMobs.isEmpty()) {
            this.setDead();
        } else {
            int i;
            this.setInvasionType(type);
            if (nbt.hasKey("MobsRemaining")) {
                this.invasionSize = this.invasionRemaining = nbt.getInteger("MobsRemaining");
            } else {
                this.invasionSize = nbt.getInteger("InvasionSize");
                this.invasionRemaining = nbt.hasKey("InvasionRemaining") ? nbt.getInteger("InvasionRemaining") : this.invasionSize;
            }
            this.successiveFailedSpawns = nbt.getInteger("SuccessiveFailedSpawns");
            this.timeSincePlayerProgress = nbt.getInteger("TimeSinceProgress");
            this.recentPlayerContributors.clear();
            if (nbt.hasKey("RecentPlayers")) {
                NBTTagList recentTags = nbt.getTagList("RecentPlayers", 10);
                for (i = 0; i < recentTags.tagCount(); ++i) {
                    NBTTagCompound playerData = recentTags.getCompoundTagAt(i);
                    String playerS = playerData.getString("Player");
                    try {
                        UUID player = UUID.fromString(playerS);
                        if (player == null) continue;
                        short time = playerData.getShort("Time");
                        this.recentPlayerContributors.put(player, (int) time);
                        continue;
                    }
                    catch (IllegalArgumentException e) {
                        FMLLog.warning("GOT: Error loading invasion recent players - %s is not a valid UUID", playerS);
                        e.printStackTrace();
                    }
                }
            }
            if (nbt.hasKey("Warhorn")) {
                this.isWarhorn = nbt.getBoolean("Warhorn");
            }
            if (nbt.hasKey("NPCPersistent")) {
                this.spawnsPersistent = nbt.getBoolean("NPCPersistent");
            }
            if (nbt.hasKey("BonusFactions")) {
                NBTTagList bonusTags = nbt.getTagList("BonusFactions", 8);
                for (i = 0; i < bonusTags.tagCount(); ++i) {
                    String fName = bonusTags.getStringTagAt(i);
                    GOTFaction f = GOTFaction.forName(fName);
                    if (f == null) continue;
                    this.bonusFactions.add(f);
                }
            }
        }
    }

    private void endInvasion(boolean completed) {
        if (completed) {
            GOTFaction invasionFac = this.getInvasionType().invasionFaction;
            HashSet<EntityPlayer> achievementPlayers = new HashSet<>();
            HashSet<EntityPlayer> conqRewardPlayers = new HashSet<>();
            for (UUID player : this.recentPlayerContributors.keySet()) {
                GOTFaction pledged;
                EntityPlayer entityplayer = this.worldObj.func_152378_a(player);
                if (entityplayer == null) continue;
                double range = 100.0;
                if (entityplayer.dimension != this.dimension || (entityplayer.getDistanceSqToEntity(this) >= range * range)) continue;
                GOTPlayerData pd = GOTLevelData.getData(player);
                if (pd.getAlignment(invasionFac) <= 0.0f) {
                    achievementPlayers.add(entityplayer);
                }
                if ((pledged = pd.getPledgeFaction()) == null || !pledged.isBadRelation(invasionFac)) continue;
                conqRewardPlayers.add(entityplayer);
            }
            for (EntityPlayer entityplayer : achievementPlayers) {
                GOTPlayerData pd = GOTLevelData.getData(entityplayer);
                pd.addAchievement(GOTAchievement.DEFEAT_INVASION);
            }
            if (!conqRewardPlayers.isEmpty()) {
                float boostPerPlayer = 50.0f / conqRewardPlayers.size();
                for (EntityPlayer entityplayer : conqRewardPlayers) {
                    GOTPlayerData pd = GOTLevelData.getData(entityplayer);
                    pd.givePureConquestBonus(entityplayer, pd.getPledgeFaction(), this.getInvasionType().invasionFaction, boostPerPlayer, "got.alignment.invasionDefeat", this.posX, this.posY, this.posZ);
                }
            }
        }
        this.worldObj.createExplosion(this, this.posX, this.posY + this.height / 2.0, this.posZ, 0.0f, false);
        this.setDead();
    }

    public void onUpdate() {
        if (!this.worldObj.isRemote && this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
            this.endInvasion(false);
            return;
        }
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.prevSpawnerSpin = this.spawnerSpin;
        this.spawnerSpin += 6.0f;
        this.prevSpawnerSpin = MathHelper.wrapAngleTo180_float(this.prevSpawnerSpin);
        this.spawnerSpin = MathHelper.wrapAngleTo180_float(this.spawnerSpin);
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        if (!this.worldObj.isRemote) {
            if (this.invasionRemaining > 0) {
                ++this.timeSincePlayerProgress;
                if (this.timeSincePlayerProgress >= 6000 && !this.isWarhorn && this.timeSincePlayerProgress % 1200 == 0) {
                    ++this.invasionRemaining;
                    this.invasionRemaining = Math.min(this.invasionRemaining, this.invasionSize);
                }
                if (!this.recentPlayerContributors.isEmpty()) {
                    HashSet<UUID> removes = new HashSet<>();
                    for (Map.Entry<UUID, Integer> e : this.recentPlayerContributors.entrySet()) {
                        UUID player = e.getKey();
                        int time = e.getValue();
                        e.setValue(--time);
                        if (time > 0) continue;
                        removes.add(player);
                    }
                    for (UUID player : removes) {
                        this.recentPlayerContributors.remove(player);
                    }
                }
            } else {
                this.endInvasion(true);
            }
        }
        if (!this.worldObj.isRemote && GOT.canSpawnMobs(this.worldObj)) {
            double nearbySearch;
            GOTInvasions invasionType = this.getInvasionType();
            EntityPlayer closePlayer = this.worldObj.getClosestPlayer(this.posX, this.posY, this.posZ, 80.0);
            if (closePlayer != null && this.invasionRemaining > 0 && (this.worldObj.selectEntitiesWithinAABB(GOTEntityNPC.class, this.boundingBox.expand(nearbySearch = INVASION_FOLLOW_RANGE * 2.0, nearbySearch, nearbySearch), this.selectThisInvasionMobs())).size() < 16 && this.rand.nextInt(160) == 0) {
                int spawnAttempts = MathHelper.getRandomIntegerInRange(this.rand, 1, 6);
                spawnAttempts = Math.min(spawnAttempts, this.invasionRemaining);
                boolean spawnedAnyMobs = false;
                for (int l = 0; l < spawnAttempts; ++l) {
                    GOTInvasions.InvasionSpawnEntry entry = (GOTInvasions.InvasionSpawnEntry)WeightedRandom.getRandomItem(this.rand, invasionType.invasionMobs);
                    Class entityClass = entry.getEntityClass();
                    String entityName = GOTEntityRegistry.getStringFromClass(entityClass);
                    GOTEntityNPC npc = (GOTEntityNPC)EntityList.createEntityByName(entityName, this.worldObj);
                    if (!this.attemptSpawnMob(npc)) continue;
                    spawnedAnyMobs = true;
                }
                if (spawnedAnyMobs) {
                    this.successiveFailedSpawns = 0;
                    this.playHorn();
                } else {
                    ++this.successiveFailedSpawns;
                    if (this.successiveFailedSpawns >= 16) {
                        this.endInvasion(false);
                    }
                }
            }
        } else {
            String particle = this.rand.nextBoolean() ? "smoke" : "flame";
            this.worldObj.spawnParticle(particle, this.posX + (this.rand.nextDouble() - 0.5) * this.width, this.posY + this.rand.nextDouble() * this.height, this.posZ + (this.rand.nextDouble() - 0.5) * this.width, 0.0, 0.0, 0.0);
        }
        this.updateWatchedInvasionValues();
    }

    private boolean attemptSpawnMob(GOTEntityNPC npc) {
        for (int at = 0; at < 40; ++at) {
            int i = MathHelper.floor_double(this.posX) + MathHelper.getRandomIntegerInRange(this.rand, -6, 6);
            int k = MathHelper.floor_double(this.posZ) + MathHelper.getRandomIntegerInRange(this.rand, -6, 6);
            int j = MathHelper.floor_double(this.posY) + MathHelper.getRandomIntegerInRange(this.rand, -8, 4);
            if (!this.worldObj.getBlock(i, j - 1, k).isSideSolid(this.worldObj, i, j - 1, k, ForgeDirection.UP)) continue;
            npc.setLocationAndAngles(i + 0.5, j, k + 0.5, this.rand.nextFloat() * 360.0f, 0.0f);
            npc.liftSpawnRestrictions = true;
            Event.Result canSpawn = ForgeEventFactory.canEntitySpawn(npc, this.worldObj, ((float)npc.posX), ((float)npc.posY), ((float)npc.posZ));
            if (canSpawn != Event.Result.ALLOW && (canSpawn != Event.Result.DEFAULT || !npc.getCanSpawnHere())) continue;
            npc.liftSpawnRestrictions = false;
            npc.onSpawnWithEgg(null);
            npc.isNPCPersistent = false;
            if (this.spawnsPersistent) {
                npc.isNPCPersistent = true;
            }
            npc.setInvasionID(this.getInvasionID());
            npc.killBonusFactions.addAll(this.bonusFactions);
            this.worldObj.spawnEntityInWorld(npc);
            IAttributeInstance followRangeAttrib = npc.getEntityAttribute(SharedMonsterAttributes.followRange);
            double followRange = followRangeAttrib.getBaseValue();
            followRange = Math.max(followRange, INVASION_FOLLOW_RANGE);
            followRangeAttrib.setBaseValue(followRange);
            return true;
        }
        return false;
    }

    private IEntitySelector selectThisInvasionMobs() {
        return new IEntitySelector(){

            public boolean isEntityApplicable(Entity entity) {
                if (entity.isEntityAlive() && entity instanceof GOTEntityNPC) {
                    GOTEntityNPC npc = (GOTEntityNPC)entity;
                    return npc.isInvasionSpawned() && npc.getInvasionID().equals(GOTEntityInvasionSpawner.this.getInvasionID());
                }
                return false;
            }
        };
    }

    public void addPlayerKill(EntityPlayer entityplayer) {
        --this.invasionRemaining;
        this.timeSincePlayerProgress = 0;
        this.recentPlayerContributors.put(entityplayer.getUniqueID(), 2400);
    }

    public boolean canBeCollidedWith() {
        return true;
    }

    public void applyEntityCollision(Entity entity) {
    }

    public boolean hitByEntity(Entity entity) {
        if (entity instanceof EntityPlayer) {
            return this.attackEntityFrom(DamageSource.causePlayerDamage(((EntityPlayer)entity)), 0.0f);
        }
        return false;
    }

    public boolean attackEntityFrom(DamageSource damagesource, float f) {
        Entity entity = damagesource.getEntity();
        if (entity instanceof EntityPlayer && ((EntityPlayer)entity).capabilities.isCreativeMode) {
            if (!this.worldObj.isRemote) {
                this.endInvasion(false);
            }
            return true;
        }
        return false;
    }

    public boolean interactFirst(EntityPlayer entityplayer) {
        if (!this.worldObj.isRemote && entityplayer.capabilities.isCreativeMode && !this.bonusFactions.isEmpty()) {
            ChatComponentText message = new ChatComponentText("");
            for (GOTFaction f : this.bonusFactions) {
                if (!message.getSiblings().isEmpty()) {
                    message.appendSibling(new ChatComponentText(", "));
                }
                message.appendSibling(new ChatComponentTranslation(f.factionName()));
            }
            entityplayer.addChatMessage(message);
            return true;
        }
        return false;
    }

    public ItemStack getPickedResult(MovingObjectPosition target) {
        GOTInvasions invasionType = this.getInvasionType();
        if (invasionType != null) {
            return GOTItemConquestHorn.createHorn(invasionType);
        }
        return null;
    }

    public static GOTEntityInvasionSpawner locateInvasionNearby(Entity seeker, final UUID id) {
        World world = seeker.worldObj;
        double search = 256.0;
        List invasions = world.selectEntitiesWithinAABB(GOTEntityInvasionSpawner.class, seeker.boundingBox.expand(search, search, search), new IEntitySelector(){

            public boolean isEntityApplicable(Entity e) {
                return e.getUniqueID().equals(id);
            }
        });
        if (!invasions.isEmpty()) {
            return (GOTEntityInvasionSpawner)(invasions.get(0));
        }
        return null;
    }

}