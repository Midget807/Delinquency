package net.midget807.trapsntrickery;

import net.fabricmc.api.ModInitializer;

import net.midget807.trapsntrickery.effect.ModEffects;
import net.midget807.trapsntrickery.entity.ModEntities;
import net.midget807.trapsntrickery.item.ModItems;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrapsAndTrickeryMain implements ModInitializer {
	public static final String MOD_ID = "trapsntrickery";

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("17 38");
		LOGGER.info("i say hey, whats up, hello");

		ModItems.registerModItems();
		ModEntities.registerModEntities();
		ModEffects.registerModEffect();
	}
}