package net.midget807.trapsntrickery.seamoon.effect.custom;

import net.midget807.trapsntrickery.seamoon.entity.interfaces.Extractable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.particle.ParticleEffect;

public class AffectionateEffect extends StatusEffect {
    public AffectionateEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    public AffectionateEffect(StatusEffectCategory category, int color, ParticleEffect particleEffect) {
        super(category, color, particleEffect);
    }

    @Override
    public void onApplied(LivingEntity entity, int amplifier) {
        super.onApplied(entity, amplifier);
        ((Extractable)entity).setMaxExtractionProgress(20 / ((amplifier + 1) * 2));
    }
}
