package net.midget807.trapsntrickery.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class LensItem extends Item {
    private final boolean description;
    public LensItem(Settings settings, boolean description) {
        super(settings);
        this.description = description;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        if (this.description) {
            tooltip.add(Text.translatable(this.getTranslationKey() + ".desc").formatted(Formatting.GRAY));
        }
    }
}
