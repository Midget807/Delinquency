package net.midget807.delinquency.effect;

import net.midget807.delinquency.DelinquencyMain;
import net.midget807.delinquency.effect.custom.EggedEffect;
import net.midget807.delinquency.effect.custom.MagmaSlimedEffect;
import net.midget807.delinquency.effect.custom.SlimedEffect;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;

public class ModEffects {
    public static final RegistryEntry<StatusEffect> EGGED = registerStatusEffect("egged",
            new EggedEffect(StatusEffectCategory.HARMFUL, 0xFEFEFE)
    );
    public static final RegistryEntry<StatusEffect> SLIMED = registerStatusEffect("slimed",
            new SlimedEffect(StatusEffectCategory.HARMFUL, 0x36EBAB)
                    .addAttributeModifier(
                            EntityAttributes.GENERIC_MOVEMENT_SPEED,
                            DelinquencyMain.id("slimed"),
                            -0.25f,
                            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL
                    )
    );
    public static final RegistryEntry<StatusEffect> MAGMA_SLIMED = registerStatusEffect("magma_slimed",
            new MagmaSlimedEffect(StatusEffectCategory.HARMFUL, 0xFF9900)
                    .addAttributeModifier(
                            EntityAttributes.GENERIC_MOVEMENT_SPEED,
                            DelinquencyMain.id("magma_slimed"),
                            -0.25f,
                            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL
                    )
    );

    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, DelinquencyMain.id(name), statusEffect);
    }

    public static void registerModEffect() {
        DelinquencyMain.LOGGER.info("Registering Mod Effects");
    }
}
