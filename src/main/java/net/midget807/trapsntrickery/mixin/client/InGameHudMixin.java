package net.midget807.trapsntrickery.mixin.client;

import net.midget807.trapsntrickery.effect.ModEffects;
import net.midget807.trapsntrickery.entity.custom.interfaces.Slimeable;
import net.midget807.trapsntrickery.util.ModTextureIds;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public abstract class InGameHudMixin {
    @Shadow @Final private MinecraftClient client;

    @Shadow protected abstract void renderOverlay(DrawContext context, Identifier texture, float opacity);

    @Inject(method = "renderMiscOverlays", at = @At("TAIL"))
    private void trapsntrickery$renderSlimed(DrawContext context, RenderTickCounter tickCounter, CallbackInfo ci) {
        if (((Slimeable)this.client.player).getSlimedTicks() > 0) {
            this.renderOverlay(context, ModTextureIds.SLIMED_OVERLAY, ((Slimeable)this.client.player).getSlimedScale());
        }
        if (((Slimeable)this.client.player).getMinSlimedTicks() > 0) {
            this.renderOverlay(context, ModTextureIds.MAGMA_SLIMED_OVERLAY, ((Slimeable)this.client.player).getMagmaSlimedScale());
        }
    }
}
