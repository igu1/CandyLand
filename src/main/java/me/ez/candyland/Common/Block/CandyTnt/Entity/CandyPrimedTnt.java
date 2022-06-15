package me.ez.candyland.Common.Block.CandyTnt.Entity;

import me.ez.candyland.Init.EntityInit;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class CandyPrimedTnt extends Entity {

    private static final EntityDataAccessor<Integer> DATA_FUSE_ID = SynchedEntityData.defineId(CandyPrimedTnt.class, EntityDataSerializers.INT);
    private static final int DEFAULT_FUSE_TIME = 80;
    @Nullable
    private LivingEntity owner;

    public CandyPrimedTnt(Level level, double x, double y, double z, @Nullable LivingEntity entity) {
        this(EntityInit.CANDY_TNT.get(), level);
        this.setPos(x, y, z);
        double d0 = level.random.nextDouble() * (double)((float)Math.PI * 2F);
        this.setDeltaMovement(-Math.sin(d0) * 0.02D, (double)0.2F, -Math.cos(d0) * 0.02D);
        this.setFuse(DEFAULT_FUSE_TIME);
        this.xo = x;
        this.yo = y;
        this.zo = z;
        this.owner = entity;
    }

    public CandyPrimedTnt(EntityType<? extends CandyPrimedTnt> entityType, Level level) {
        super(entityType, level);
        this.blocksBuilding = true;
    }

    protected void defineSynchedData() {
        this.entityData.define(DATA_FUSE_ID, DEFAULT_FUSE_TIME);
    }

    protected Entity.MovementEmission getMovementEmission() {
        return Entity.MovementEmission.NONE;
    }

    public boolean isPickable() {
        return !this.isRemoved();
    }

    public void tick() {
        if (!this.isNoGravity()) {
            this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.04D, 0.0D));
        }

        this.move(MoverType.SELF, this.getDeltaMovement());
        this.setDeltaMovement(this.getDeltaMovement().scale(0.98D));
        if (this.onGround) {
            this.setDeltaMovement(this.getDeltaMovement().multiply(0.7D, -0.5D, 0.7D));
        }

        int i = this.getFuse() - 1;
        this.setFuse(i);
        if (i <= 0) {
            this.discard();
            if (!this.level.isClientSide) {
                this.explode();
            }
        } else {
            this.updateInWaterStateAndDoFluidPushing();
            if (this.level.isClientSide) {
                this.level.addParticle(ParticleTypes.SMOKE, this.getX(), this.getY() + 0.5D, this.getZ(), 0.0D, 0.0D, 0.0D);
            }
        }

    }

    protected void explode() {
        float f = 4.0F;
        this.level.explode(this, this.getX(), this.getY(0.0625D), this.getZ(), f, Explosion.BlockInteraction.BREAK);
    }

    protected void addAdditionalSaveData(CompoundTag compoundTag) {
        compoundTag.putShort("Fuse", (short)this.getFuse());
    }

    protected void readAdditionalSaveData(CompoundTag compoundTag) {
        this.setFuse(compoundTag.getShort("Fuse"));
    }

    @Nullable
    public LivingEntity getOwner() {
        return this.owner;
    }

    protected float getEyeHeight(Pose pose, EntityDimensions dimensions) {
        return 0.15F;
    }

    public void setFuse(int i) {
        this.entityData.set(DATA_FUSE_ID, i);
    }

    public int getFuse() {
        return this.entityData.get(DATA_FUSE_ID);
    }

    public Packet<?> getAddEntityPacket() {
        return new ClientboundAddEntityPacket(this);
    }
}
