package net.midget807.delinquency.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        /*
        itemModelGenerator.register(SeamoonItems.SEAMOON_BUCKET, Models.GENERATED);

        itemModelGenerator.register(SeamoonItems.GLAZED_APPLE, Models.GENERATED);
        itemModelGenerator.register(SeamoonItems.GLAZED_BAKED_POTATO, Models.GENERATED);
        itemModelGenerator.register(SeamoonItems.GLAZED_BEEF, Models.GENERATED);
        itemModelGenerator.register(SeamoonItems.GLAZED_BEETROOT, Models.GENERATED);
        itemModelGenerator.register(SeamoonItems.GLAZED_BEETROOT_SOUP, Models.GENERATED);
        itemModelGenerator.register(SeamoonItems.GLAZED_BREAD, Models.GENERATED);
        itemModelGenerator.register(SeamoonItems.GLAZED_CARROT, Models.GENERATED);
        itemModelGenerator.register(SeamoonItems.GLAZED_CHICKEN, Models.GENERATED);
        itemModelGenerator.register(SeamoonItems.GLAZED_CHORUS_FRUIT, Models.GENERATED);
        itemModelGenerator.register(SeamoonItems.GLAZED_COD, Models.GENERATED);
        itemModelGenerator.register(SeamoonItems.GLAZED_COOKED_BEEF, Models.GENERATED);
        itemModelGenerator.register(SeamoonItems.GLAZED_COOKED_CHICKEN, Models.GENERATED);
        itemModelGenerator.register(SeamoonItems.GLAZED_COOKED_COD, Models.GENERATED);
        itemModelGenerator.register(SeamoonItems.GLAZED_COOKED_MUTTON, Models.GENERATED);
        itemModelGenerator.register(SeamoonItems.GLAZED_COOKED_PORKCHOP, Models.GENERATED);
        itemModelGenerator.register(SeamoonItems.GLAZED_COOKED_RABBIT, Models.GENERATED);
        itemModelGenerator.register(SeamoonItems.GLAZED_COOKED_SALMON, Models.GENERATED);
        itemModelGenerator.register(SeamoonItems.GLAZED_COOKIE, Models.GENERATED);
        itemModelGenerator.register(SeamoonItems.GLAZED_DRIED_KELP, Models.GENERATED);
        itemModelGenerator.register(SeamoonItems.GLAZED_ENCHANTED_GOLDEN_APPLE, Models.GENERATED);
        itemModelGenerator.register(SeamoonItems.GLAZED_GOLDEN_APPLE, Models.GENERATED);
        itemModelGenerator.register(SeamoonItems.GLAZED_GOLDEN_CARROT, Models.GENERATED);
        itemModelGenerator.register(SeamoonItems.GLAZED_HONEY_BOTTLE, Models.GENERATED);
        itemModelGenerator.register(SeamoonItems.GLAZED_MELON_SLICE, Models.GENERATED);
        itemModelGenerator.register(SeamoonItems.GLAZED_MUSHROOM_STEW, Models.GENERATED);
        itemModelGenerator.register(SeamoonItems.GLAZED_MUTTON, Models.GENERATED);
        itemModelGenerator.register(SeamoonItems.GLAZED_POISONOUS_POTATO, Models.GENERATED);
        itemModelGenerator.register(SeamoonItems.GLAZED_PORKCHOP, Models.GENERATED);
        itemModelGenerator.register(SeamoonItems.GLAZED_POTATO, Models.GENERATED);
        itemModelGenerator.register(SeamoonItems.GLAZED_PUFFERFISH, Models.GENERATED);
        itemModelGenerator.register(SeamoonItems.GLAZED_PUMPKIN_PIE, Models.GENERATED);
        itemModelGenerator.register(SeamoonItems.GLAZED_RABBIT, Models.GENERATED);
        itemModelGenerator.register(SeamoonItems.GLAZED_RABBIT_STEW, Models.GENERATED);
        itemModelGenerator.register(SeamoonItems.GLAZED_ROTTEN_FLESH, Models.GENERATED);
        itemModelGenerator.register(SeamoonItems.GLAZED_SALMON, Models.GENERATED);
        itemModelGenerator.register(SeamoonItems.GLAZED_SPIDER_EYE, Models.GENERATED);
        itemModelGenerator.register(SeamoonItems.GLAZED_SUSPICIOUS_STEW, Models.GENERATED);
        itemModelGenerator.register(SeamoonItems.GLAZED_SWEET_BERRIES, Models.GENERATED);
        itemModelGenerator.register(SeamoonItems.GLAZED_GLOW_BERRIES, Models.GENERATED);
        itemModelGenerator.register(SeamoonItems.GLAZED_TROPICAL_FISH, Models.GENERATED);
        itemModelGenerator.register(SeamoonItems.STICKY_BICKY, Models.GENERATED);
        itemModelGenerator.register(SeamoonItems.SOGGY_SEAWEED, Models.GENERATED);
        itemModelGenerator.register(SeamoonItems.CREAM_PIE, Models.GENERATED);
         */
    }
}
