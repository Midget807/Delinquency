package net.midget807.trapsntrickery.effect.custom;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.particle.ParticleEffect;

public class SlimedEffect extends StatusEffect {
    public SlimedEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    public SlimedEffect(StatusEffectCategory category, int color, ParticleEffect particleEffect) {
        super(category, color, particleEffect);
    }
}
