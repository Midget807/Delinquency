package net.midget807.trapsntrickery.seamoon.recipe.custom;

import net.midget807.trapsntrickery.seamoon.block.SeamoonBlocks;
import net.midget807.trapsntrickery.seamoon.effect.SeamoonEffects;
import net.midget807.trapsntrickery.seamoon.recipe.SeamoonRecipes;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.recipe.SpecialRecipeSerializer;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.recipe.input.CraftingRecipeInput;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.World;

import java.util.Objects;

public class SeamoonBlockRecipe extends SpecialCraftingRecipe {
    public SeamoonBlockRecipe(CraftingRecipeCategory category) {
        super(category);
    }

    @Override
    public boolean matches(CraftingRecipeInput input, World world) {
        if (input.getWidth() == 3 && input.getHeight() == 3) {
            for (int i = 0; i < input.getHeight(); i++) {
                for (int j = 0; j < input.getWidth(); j++) {
                    ItemStack itemStack = input.getStackInSlot(j, i);
                    if (itemStack.isEmpty()) {
                        return false;
                    }

                    if (j == 1 && i == 1) {
                        if (!itemStack.isOf(Items.NETHERITE_BLOCK)) {
                            return false;
                        }
                    } else if (!itemStack.isOf(Items.POTION)) {
                        return false;
                    }
                }
            }

            return true;
        } else {
            return false;
        }
    }

    @Override
    public ItemStack craft(CraftingRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        if (input.getHeight() == 3 && input.getWidth() == 3) {
            for (int i = 0; i < input.getHeight(); i++) {
                for (int j = 0; j < input.getWidth(); j++) {
                    ItemStack itemStack = input.getStackInSlot(j, i);
                    if (itemStack.isEmpty()) {
                        return ItemStack.EMPTY;
                    }
                    if (i != 1 && j != 1) {
                        if (itemStack.isOf(Items.POTION) && itemStack.contains(DataComponentTypes.POTION_CONTENTS) && Objects.requireNonNull(itemStack.get(DataComponentTypes.POTION_CONTENTS)).potion().isPresent()) {
                            if (Objects.requireNonNull(itemStack.get(DataComponentTypes.POTION_CONTENTS)).potion().get() == SeamoonEffects.AFFECTIONATE_POTION) {
                                return new ItemStack(SeamoonBlocks.SEAMOON_BLOCK.asItem(), 1);
                            }
                        }
                    }
                }
            }
        }
        return ItemStack.EMPTY;
    }

    @Override
    public boolean fits(int width, int height) {
        return width >= 3 && height >= 3;
    }
    @Override
    public RecipeSerializer<?> getSerializer() {
        return SeamoonRecipes.SEAMOON_BLOCK_RECIPE_SERIALIZER;
    }
}
