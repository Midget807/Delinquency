package net.midget807.delinquency.mixin;

import net.minecraft.item.Item;
import net.minecraft.item.SpyglassItem;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(SpyglassItem.class)
public class SpyglassMixin extends Item {
    public SpyglassMixin(Settings settings) {
        super(settings);
    }

}
