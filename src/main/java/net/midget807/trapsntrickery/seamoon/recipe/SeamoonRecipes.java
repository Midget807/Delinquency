package net.midget807.trapsntrickery.seamoon.recipe;

import net.midget807.trapsntrickery.TrapsAndTrickeryMain;
import net.midget807.trapsntrickery.seamoon.recipe.custom.SeamoonBlockRecipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialRecipeSerializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class SeamoonRecipes {

    public static final RecipeSerializer<SeamoonBlockRecipe> SEAMOON_BLOCK_RECIPE_SERIALIZER = Registry.register(
            Registries.RECIPE_SERIALIZER, TrapsAndTrickeryMain.seamoonId("seamoon_block_recipe"),
            new SpecialRecipeSerializer<>(SeamoonBlockRecipe::new)
    );

    public static void registerSeamoonRecipes() {
        TrapsAndTrickeryMain.LOGGER.info("Registering Seamoon Recipes");
    }
}
