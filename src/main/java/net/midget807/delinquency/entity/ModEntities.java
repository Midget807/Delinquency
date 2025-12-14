package net.midget807.delinquency.entity;

import net.midget807.delinquency.DelinquencyMain;
import net.midget807.delinquency.entity.custom.MagmaCubeProjectileEntity;
import net.midget807.delinquency.entity.custom.SlimeCubeProjectileEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.world.World;

public class ModEntities {
    public static final EntityType<SlimeCubeProjectileEntity> SLIME_CUBE_PROJECTILE = Registry.register(
            Registries.ENTITY_TYPE, DelinquencyMain.id("slime_cube_projectile"),
            EntityType.Builder.create((EntityType<SlimeCubeProjectileEntity> entityType, World world) -> new SlimeCubeProjectileEntity(world), SpawnGroup.MISC)
                    .dimensions(0.25f, 0.25f)
                    .build()
    );
    public static final EntityType<MagmaCubeProjectileEntity> MAGMA_CUBE_PROJECTILE = Registry.register(
            Registries.ENTITY_TYPE, DelinquencyMain.id("magma_cube_projectile"),
            EntityType.Builder.create((EntityType<MagmaCubeProjectileEntity> entityType, World world) -> new MagmaCubeProjectileEntity(world), SpawnGroup.MISC)
                    .dimensions(0.25f, 0.25f)
                    .build()
    );

    public static void registerModEntities() {
        DelinquencyMain.LOGGER.info("Registering Mod Entities");
    }
}
