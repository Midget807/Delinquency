package net.midget807.trapsntrickery;

import net.fabricmc.api.ModInitializer;

import net.midget807.trapsntrickery.effect.ModEffects;
import net.midget807.trapsntrickery.entity.ModEntities;
import net.midget807.trapsntrickery.item.ModItems;
import net.midget807.trapsntrickery.seamoon.block.SeamoonBlocks;
import net.midget807.trapsntrickery.seamoon.effect.SeamoonEffects;
import net.midget807.trapsntrickery.seamoon.item.SeamoonItems;
import net.midget807.trapsntrickery.seamoon.particle.SeamoonParticleTypes;
import net.midget807.trapsntrickery.seamoon.recipe.SeamoonRecipes;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrapsAndTrickeryMain implements ModInitializer {
	public static final String MOD_ID = "trapsntrickery";
	public static final String SEAMOON_MOD_ID = "seamoon";

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
	public static Identifier seamoonId(String path) {
		return Identifier.of(SEAMOON_MOD_ID, path);
	}

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("17 38");
		LOGGER.info("i say hey, whats up, hello");

		ModItems.registerModItems();
		ModEntities.registerModEntities();
		ModEffects.registerModEffect();

		SeamoonItems.registerModItems();
		SeamoonEffects.registerModEffect();
		SeamoonParticleTypes.registerModParticles();
		SeamoonBlocks.registerSeamoonBlocks();
		SeamoonRecipes.registerSeamoonRecipes();
	}
}