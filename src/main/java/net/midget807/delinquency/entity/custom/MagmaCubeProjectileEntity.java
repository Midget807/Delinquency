package net.midget807.delinquency.entity.custom;

import net.midget807.delinquency.entity.ModEntities;
import net.midget807.delinquency.item.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class MagmaCubeProjectileEntity extends AbstractSlimeCubeProjectileEntity {

    public MagmaCubeProjectileEntity(World world) {
        super(ModEntities.MAGMA_CUBE_PROJECTILE, world);
    }

    public MagmaCubeProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, double d, double e, double f, World world) {
        super(entityType, d, e, f, world);
    }

    public MagmaCubeProjectileEntity(LivingEntity livingEntity, World world) {
        super(ModEntities.MAGMA_CUBE_PROJECTILE, livingEntity, world);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.MAGMA_CUBE_ITEM;
    }
}
