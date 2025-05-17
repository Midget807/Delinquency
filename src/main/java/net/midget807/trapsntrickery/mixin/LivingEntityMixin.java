package net.midget807.trapsntrickery.mixin;

import net.midget807.trapsntrickery.effect.ModEffects;
import net.midget807.trapsntrickery.entity.custom.interfaces.Slimeable;
import net.minecraft.entity.Attackable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.crash.CrashException;
import net.minecraft.util.crash.CrashReport;
import net.minecraft.util.crash.CrashReportSection;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity implements Attackable, Slimeable {

    @Unique
    private static final TrackedData<Integer> SLIMED_TICKS = DataTracker.registerData(LivingEntity.class, TrackedDataHandlerRegistry.INTEGER);
    @Unique
    private static final TrackedData<Integer> MAGMA_SLIMED_TICKS = DataTracker.registerData(LivingEntity.class, TrackedDataHandlerRegistry.INTEGER);
    @Unique
    private boolean isSlimed;
    @Unique
    private boolean isMagmaSlimed;

    @Shadow public abstract void setOnFireForTicks(int ticks);

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method = "initDataTracker", at = @At("HEAD"))
    private void trapsntrickery$addData(DataTracker.Builder builder, CallbackInfo ci) {
        builder.add(SLIMED_TICKS, 0);
        builder.add(MAGMA_SLIMED_TICKS, 0);
    }

    @Override
    public int getSlimedTicks() {
        return this.dataTracker.get(SLIMED_TICKS);
    }

    @Override
    public void setSlimedTicks(int ticks) {
        this.dataTracker.set(SLIMED_TICKS, ticks);
    }

    @Override
    public int getMinSlimedTicks() {
        return 10;
    }

    @Override
    public float getSlimedScale() {
        int i = this.getMinSlimedTicks();
        return (float) Math.min(this.getSlimedTicks(), i) / i;
    }

    @Override
    public int getMagmaSlimedTicks() {
        return this.dataTracker.get(MAGMA_SLIMED_TICKS);
    }

    @Override
    public void setMagmaSlimedTicks(int ticks) {
        this.dataTracker.set(MAGMA_SLIMED_TICKS, ticks);
    }

    @Override
    public int getMinMagmaSlimedTicks() {
        return 10;
    }

    @Override
    public float getMagmaSlimedScale() {
        int i = this.getMinMagmaSlimedTicks();
        return (float) Math.min(this.getMagmaSlimedTicks(), i) / i;
    }

    @Override
    public boolean isSlimed() {
        return ((LivingEntity)((Object)this)).hasStatusEffect(ModEffects.SLIMED) ||
                this.isSlimed;
    }

    @Override
    public void setIsSlimed(boolean bl) {
        this.isSlimed = bl;
    }

    @Override
    public boolean isMagmaSlimed() {
        return ((LivingEntity)((Object)this)).hasStatusEffect(ModEffects.MAGMA_SLIMED) ||
                isMagmaSlimed;
    }

    @Override
    public void setIsMagmaSlimed(boolean bl) {
        this.isMagmaSlimed = bl;
    }

    @Inject(method = "baseTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;baseTick()V"))
    private void trapsntrickery$baseSlimedTicks(CallbackInfo ci) {
        this.isSlimed= false;
        this.isMagmaSlimed= false;
    }

    @Inject(method = "tick", at = @At("TAIL"))
    private void trapsntrickery$slimedTicks(CallbackInfo ci) {
        if (((LivingEntity)((Object)this)).hasStatusEffect(ModEffects.MAGMA_SLIMED)) {
            this.setOnFireForTicks(1);
        }
        if (((LivingEntity)((Object)this)).isWet()) {
            ((LivingEntity)((Object)this)).removeStatusEffect(ModEffects.SLIMED);
            ((LivingEntity)((Object)this)).removeStatusEffect(ModEffects.MAGMA_SLIMED);
        }
        if (!this.getWorld().isClient && !((LivingEntity)((Object)this)).isDead()) {
            int i = this.getSlimedTicks();
            if (this.isSlimed()) {
                this.setSlimedTicks(Math.min(this.getMinSlimedTicks(), i + 1));
            } else {
                this.setSlimedTicks(Math.max(0, i - 2));
            }
            int j = this.getMagmaSlimedTicks();
            if (this.isMagmaSlimed()) {
                this.setMagmaSlimedTicks(Math.min(this.getMinMagmaSlimedTicks(), j + 1));
            } else {
                this.setMagmaSlimedTicks(Math.max(0, j - 2));
            }
        }
        if (((LivingEntity)((Object)this)) instanceof PlayerEntity player) {
            player.sendMessage(Text.literal("SLimed: " + this.isSlimed()), true);
        }
    }

    @Override
    public NbtCompound writeNbt(NbtCompound nbt) {
        NbtCompound nbtCompound = super.writeNbt(nbt);
        if (this.getSlimedTicks() > 0) {
            nbtCompound.putInt("SlimedTicks", this.getSlimedTicks());
        }
        if (this.getMagmaSlimedTicks() > 0) {
            nbtCompound.putInt("MagmaSlimedTicks", this.getMagmaSlimedTicks());
        }
        return nbtCompound;
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        try {
            this.setSlimedTicks(nbt.getInt("SlimedTicks"));
            this.setMagmaSlimedTicks(nbt.getInt("MagmaSlimedTicks"));
        } catch (Throwable var17) {
            CrashReport crashReport = CrashReport.create(var17, "Loading entity NBT");
            CrashReportSection crashReportSection = crashReport.addElement("Entity being loaded");
            this.populateCrashReport(crashReportSection);
            throw new CrashException(crashReport);
        }
    }
}
