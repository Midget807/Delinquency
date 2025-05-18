package net.midget807.trapsntrickery.mixin.seamoon.client;

import com.llamalad7.mixinextras.sugar.Local;
import net.midget807.trapsntrickery.TrapsAndTrickeryMain;
import net.midget807.trapsntrickery.effect.ModEffects;
import net.midget807.trapsntrickery.seamoon.effect.SeamoonEffects;
import net.minecraft.client.render.item.ItemModels;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.PotionItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {
    @Shadow public abstract ItemModels getModels();

    @ModifyVariable(
            method = "renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformationMode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/client/render/model/BakedModel;)V",
            at = @At("HEAD"),
            argsOnly = true
    )
    public BakedModel seamoon$renderItems(BakedModel bakedModel, @Local(argsOnly = true)ItemStack stack, @Local(argsOnly = true)ModelTransformationMode renderMode) {
        if (stack.getItem() instanceof PotionItem) {
            PotionContentsComponent potionContentsComponent = stack.getOrDefault(DataComponentTypes.POTION_CONTENTS, PotionContentsComponent.DEFAULT);
            if (potionContentsComponent.matches(SeamoonEffects.AFFECTIONATE_POTION) ||
                    potionContentsComponent.matches(SeamoonEffects.LONG_AFFECTIONATE_POTION) ||
                    potionContentsComponent.matches(SeamoonEffects.STRONG_AFFECTIONATE_POTION)
            ) {
                if (stack.isOf(Items.POTION)) {
                    return getModels().getModelManager().getModel(ModelIdentifier.ofInventoryVariant(TrapsAndTrickeryMain.seamoonId("seamoon_bottle")));
                } else if (stack.isOf(Items.SPLASH_POTION)) {
                    return getModels().getModelManager().getModel(ModelIdentifier.ofInventoryVariant(TrapsAndTrickeryMain.seamoonId("seamoon_splash_bottle")));
                } else if (stack.isOf(Items.LINGERING_POTION)) {
                    return getModels().getModelManager().getModel(ModelIdentifier.ofInventoryVariant(TrapsAndTrickeryMain.seamoonId("seamoon_lingering_bottle")));
                }
            }
        }
        return bakedModel;
    }

    @ModifyVariable(
            method = "getModel",
            at = @At(value = "STORE"),
            ordinal = 1
    )
    public BakedModel seamoon$getModelMixin(BakedModel value, @Local(argsOnly = true)ItemStack stack) {
        if (stack.getItem() instanceof PotionItem) {
            PotionContentsComponent potionContentsComponent = stack.getOrDefault(DataComponentTypes.POTION_CONTENTS, PotionContentsComponent.DEFAULT);
            if (potionContentsComponent.matches(SeamoonEffects.AFFECTIONATE_POTION) ||
                    potionContentsComponent.matches(SeamoonEffects.LONG_AFFECTIONATE_POTION) ||
                    potionContentsComponent.matches(SeamoonEffects.STRONG_AFFECTIONATE_POTION)
            ) {
                if (stack.isOf(Items.POTION)) {
                    return getModels().getModelManager().getModel(ModelIdentifier.ofInventoryVariant(TrapsAndTrickeryMain.seamoonId("seamoon_bottle")));
                } else if (stack.isOf(Items.SPLASH_POTION)) {
                    return getModels().getModelManager().getModel(ModelIdentifier.ofInventoryVariant(TrapsAndTrickeryMain.seamoonId("seamoon_splash_bottle")));
                } else if (stack.isOf(Items.LINGERING_POTION)) {
                    return getModels().getModelManager().getModel(ModelIdentifier.ofInventoryVariant(TrapsAndTrickeryMain.seamoonId("seamoon_lingering_bottle")));
                }
            }
        }
        return value;
    }
}
