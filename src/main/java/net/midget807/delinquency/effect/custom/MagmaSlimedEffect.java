package net.midget807.delinquency.effect.custom;

import net.midget807.delinquency.entity.custom.interfaces.Slimeable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.particle.ParticleEffect;

public class MagmaSlimedEffect extends StatusEffect {
    public MagmaSlimedEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    public MagmaSlimedEffect(StatusEffectCategory category, int color, ParticleEffect particleEffect) {
        super(category, color, particleEffect);
    }

    @Override
    public void onApplied(LivingEntity entity, int amplifier) {
        ((Slimeable)entity).setIsMagmaSlimed(true);
    }
}
