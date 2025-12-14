package net.midget807.delinquency;

import net.fabricmc.api.ModInitializer;

import net.midget807.delinquency.block.ModBlocks;
import net.midget807.delinquency.effect.ModEffects;
import net.midget807.delinquency.entity.ModEntities;
import net.midget807.delinquency.item.ModItems;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DelinquencyMain implements ModInitializer {
	public static final String MOD_ID = "delinquency";

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("17 38");

		ModItems.registerModItems();
		ModEntities.registerModEntities();
		ModEffects.registerModEffect();
		ModBlocks.registerModBlocks();
	}
}