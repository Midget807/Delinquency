package net.midget807.trapsntrickery.mixin.seamoon;

import net.midget807.trapsntrickery.seamoon.effect.SeamoonEffects;
import net.midget807.trapsntrickery.seamoon.entity.interfaces.Extractable;
import net.midget807.trapsntrickery.seamoon.particle.SeamoonParticleTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.entity.Attackable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.SlimeEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity implements Attackable, Extractable {
    @Shadow public abstract boolean hasStatusEffect(RegistryEntry<StatusEffect> effect);

    @Shadow @Nullable public abstract StatusEffectInstance getStatusEffect(RegistryEntry<StatusEffect> effect);

    @Unique
    private int extractionProgress = 0;
    @Unique
    private int maxExtraction = 20;
    @Unique
    private int extractionDecrementTicks = 0;

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Override
    public int getExtractionProgress() {
        return this.extractionProgress;
    }

    @Override
    public void setExtractionProgress(int progress) {
        this.extractionProgress = progress;
    }

    @Override
    public int getMaxExtraction() {
        return this.maxExtraction;
    }

    @Override
    public void setMaxExtractionProgress(int max) {
        this.maxExtraction = max;
    }

    @Override
    public ActionResult interact(PlayerEntity player, Hand hand) {
        if (((LivingEntity)((Object)this)) instanceof SlimeEntity slimeEntity) {
            if (slimeEntity.getSize() == 1) {
                return super.interact(player, hand);
            }
        }
        if (player.isSneaking()) {
            if (this.getExtractionProgress() < this.getMaxExtraction()) {
                if (!this.getWorld().isClient && player.getStackInHand(hand).isEmpty()) {
                    this.setExtractionProgress(this.getExtractionProgress() + 1);
                    player.sendMessage(Text.literal("Progress: " + this.getExtractionProgress()), true);
                }
            } else if (this.getExtractionProgress() >= this.getMaxExtraction()) {
                if (!this.getWorld().isClient && player.getStackInHand(hand).isOf(Items.GLASS_BOTTLE)) {
                    player.giveItemStack(PotionContentsComponent.createStack(Items.POTION, SeamoonEffects.AFFECTIONATE_POTION));
                    this.setExtractionProgress(0);
                    if (this.getWorld() instanceof ServerWorld serverWorld) {
                        serverWorld.spawnParticles((ServerPlayerEntity) player, SeamoonParticleTypes.SEAMOON_SPLOOGE, true, this.getX(), this.getY() + 0.5, this.getZ(), 75, 0.01f, 0.01f, 0.01f, 0.5f);
                    }
                    player.sendMessage(Text.literal("Progress: " + this.getExtractionProgress()), true);
                }
            }
            return ActionResult.success(true);
        }
        return super.interact(player, hand);
    }
    @Inject(method = "tick", at = @At("TAIL"))
    private void seamoon$decrementExtractionProgress(CallbackInfo ci) {
        if (this.getExtractionProgress() > 0) {
            if (!this.getWorld().isClient) {
                this.extractionDecrementTicks++;
                if (this.extractionDecrementTicks % 20 == 0) {
                    this.setExtractionProgress(this.getExtractionProgress() - 1);
                }
            }
        } else if (this.extractionDecrementTicks > 0 && this.getExtractionProgress() <= 0) {
            this.extractionDecrementTicks = 0;
        }
        if (!this.hasStatusEffect(SeamoonEffects.AFFECTIONATE) && this.getMaxExtraction() != 20) {
            this.setMaxExtractionProgress(20);
        }
    }

}
