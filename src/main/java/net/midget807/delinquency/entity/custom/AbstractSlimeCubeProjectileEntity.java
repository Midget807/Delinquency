package net.midget807.delinquency.entity.custom;

import net.midget807.delinquency.effect.ModEffects;
import net.midget807.delinquency.item.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.SlimeEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class AbstractSlimeCubeProjectileEntity extends ThrownItemEntity {
    public static boolean isMagma;

    public AbstractSlimeCubeProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public AbstractSlimeCubeProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, double d, double e, double f, World world) {
        super(entityType, d, e, f, world);
    }

    public AbstractSlimeCubeProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, LivingEntity livingEntity, World world) {
        super(entityType, livingEntity, world);
    }

    public void initFromStack(ItemStack stack) {
        isMagma = stack.isOf(ModItems.MAGMA_CUBE_ITEM);
        this.setItem(stack);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity target = entityHitResult.getEntity();
        if (!this.getWorld().isClient) {
            if (isMagma) {
                if (target.isFireImmune() || !(target instanceof LivingEntity)) {
                    this.spawnSlime(entityHitResult.getEntity().getBlockPos(), true);
                } else {
                    this.splooge((LivingEntity) target);
                }
            } else {
                if (target.getType() == EntityType.SLIME || !(target instanceof LivingEntity)) {
                    this.spawnSlime(target.getBlockPos(), false);
                } else {
                    this.splooge((LivingEntity) target);
                }
            }
        }
        this.discard();
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
        this.spawnSlime(blockHitResult.getBlockPos().offset(blockHitResult.getSide()), isMagma);
        this.discard();
    }

    public void spawnSlime(BlockPos blockPos, boolean isMagma) {
        SlimeEntity slimeEntity = new SlimeEntity(isMagma ? EntityType.MAGMA_CUBE : EntityType.SLIME, this.getWorld());
        slimeEntity.setSize(1, true);
        slimeEntity.updatePosition(blockPos.getX(), blockPos.getY(), blockPos.getZ());
        slimeEntity.setPos(blockPos.getX(), blockPos.getY(), blockPos.getZ());
        this.getWorld().spawnEntity(slimeEntity);
    }

    public void splooge(LivingEntity target) {
        if (isMagma) {
            target.addStatusEffect(
                    new StatusEffectInstance(
                            ModEffects.MAGMA_SLIMED,
                            5 * 20,
                            0,
                            false,
                            true
                    ),
                    this.getEffectCause()
            );
        } else {
            target.addStatusEffect(
                    new StatusEffectInstance(
                            ModEffects.SLIMED,
                            5 * 20,
                            0,
                            false,
                            true
                    ),
                    this.getEffectCause()
            );
        }
    }
}
