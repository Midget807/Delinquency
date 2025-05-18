package net.midget807.trapsntrickery.seamoon.effect;

import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.midget807.trapsntrickery.TrapsAndTrickeryMain;
import net.midget807.trapsntrickery.seamoon.effect.custom.AffectionateEffect;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class SeamoonEffects {

    public static final RegistryEntry<StatusEffect> AFFECTIONATE = registerStatusEffect("affectionate",
            new AffectionateEffect(StatusEffectCategory.NEUTRAL, 0xFFFFFF, ParticleTypes.HEART)
    );

    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, TrapsAndTrickeryMain.seamoonId(name), statusEffect);
    }


    public static final RegistryEntry<Potion> AFFECTIONATE_POTION = registerPotion(
            "affectionate",
            new Potion(new StatusEffectInstance(SeamoonEffects.AFFECTIONATE, 600, 0))
    );
    public static final RegistryEntry<Potion> LONG_AFFECTIONATE_POTION = registerPotion(
            "long_affectionate",
            new Potion("affectionate", new StatusEffectInstance(SeamoonEffects.AFFECTIONATE, 1800, 0))
    );
    public static final RegistryEntry<Potion> STRONG_AFFECTIONATE_POTION = registerPotion(
            "strong_affectionate",
            new Potion("affectionate", new StatusEffectInstance(SeamoonEffects.AFFECTIONATE, 300, 1))
    );
    private static RegistryEntry<Potion> registerPotion(String name, Potion potion) {
        return Registry.registerReference(Registries.POTION, TrapsAndTrickeryMain.seamoonId(name), potion);
    }

    public static void registerModEffect() {
        TrapsAndTrickeryMain.LOGGER.info("Registering Seamoon Effects");
        registerRecipes();
    }

    private static void registerRecipes() {
        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            builder.registerPotionRecipe(
                    SeamoonEffects.AFFECTIONATE_POTION,
                    Items.REDSTONE,
                    SeamoonEffects.LONG_AFFECTIONATE_POTION
            );
            builder.registerPotionRecipe(
                    SeamoonEffects.AFFECTIONATE_POTION,
                    Items.GLOWSTONE,
                    SeamoonEffects.STRONG_AFFECTIONATE_POTION
            );
        });
    }
}
