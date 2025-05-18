package net.midget807.trapsntrickery.mixin.seamoon.client;

import net.midget807.trapsntrickery.TrapsAndTrickeryMain;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.render.model.ModelLoader;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(ModelLoader.class)
public abstract class ModelLoaderMixin {
    @Shadow protected abstract void loadItemModel(ModelIdentifier id);

    @Inject(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/model/ModelLoader;loadItemModel(Lnet/minecraft/client/util/ModelIdentifier;)V", ordinal = 1))
    private void seamoon$loadModels(BlockColors blockColors, Profiler profiler, Map jsonUnbakedModels, Map blockStates, CallbackInfo ci) {
        this.loadItemModel(ModelIdentifier.ofInventoryVariant(TrapsAndTrickeryMain.seamoonId("seamoon_bottle")));
        this.loadItemModel(ModelIdentifier.ofInventoryVariant(TrapsAndTrickeryMain.seamoonId("seamoon_splash_bottle")));
        this.loadItemModel(ModelIdentifier.ofInventoryVariant(TrapsAndTrickeryMain.seamoonId("seamoon_lingering_bottle")));
    }
}
