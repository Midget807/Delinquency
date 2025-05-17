package net.midget807.trapsntrickery.entity.custom;

import net.midget807.trapsntrickery.entity.ModEntities;
import net.midget807.trapsntrickery.item.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class SlimeCubeProjectileEntity extends AbstractSlimeCubeProjectileEntity {

    public SlimeCubeProjectileEntity(World world) {
        super(ModEntities.SLIME_CUBE_PROJECTILE, world);
    }

    public SlimeCubeProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, double d, double e, double f, World world) {
        super(entityType, d, e, f, world);
    }

    public SlimeCubeProjectileEntity(LivingEntity livingEntity, World world) {
        super(ModEntities.SLIME_CUBE_PROJECTILE, livingEntity, world);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.SLIME_CUBE_ITEM;
    }
}
