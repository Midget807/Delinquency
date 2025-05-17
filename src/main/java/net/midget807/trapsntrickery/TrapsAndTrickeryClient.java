package net.midget807.trapsntrickery;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.midget807.trapsntrickery.entity.ModEntities;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class TrapsAndTrickeryClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.SLIME_CUBE_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.MAGMA_CUBE_PROJECTILE, FlyingItemEntityRenderer::new);
    }
}
