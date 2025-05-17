package net.midget807.trapsntrickery.effect.custom;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.particle.ParticleEffect;

public class EggedEffect extends StatusEffect {
    public EggedEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    public EggedEffect(StatusEffectCategory category, int color, ParticleEffect particleEffect) {
        super(category, color, particleEffect);
    }
}
