package net.midget807.delinquency;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.midget807.delinquency.entity.ModEntities;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class DelinquencyClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.SLIME_CUBE_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.MAGMA_CUBE_PROJECTILE, FlyingItemEntityRenderer::new);

    }
}
