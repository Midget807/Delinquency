package net.midget807.trapsntrickery.seamoon.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.midget807.trapsntrickery.TrapsAndTrickeryMain;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class SeamoonParticleTypes {
    public static final SimpleParticleType SEAMOON_SPLOOGE = register("seamoon_splooge", false);

    private static SimpleParticleType register(String name, boolean alwaysShow) {
        return Registry.register(Registries.PARTICLE_TYPE, TrapsAndTrickeryMain.seamoonId(name), FabricParticleTypes.simple(alwaysShow));
    }

    public static void registerModParticles() {
        TrapsAndTrickeryMain.LOGGER.info("Registering Seamoon Particle");
    }
}
