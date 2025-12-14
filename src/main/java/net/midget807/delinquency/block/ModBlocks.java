package net.midget807.delinquency.block;

import net.midget807.delinquency.DelinquencyMain;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModBlocks {

    //public static final Block PIT_COVER = registerBlock("pit_cover", new PitCoverBlock(AbstractBlock.Settings.create().mapColor(MapColor.BLACK).strength(2.0f, 5.0f).sounds(BlockSoundGroup.SCAFFOLDING)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, DelinquencyMain.id(name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, DelinquencyMain.id(name), new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        DelinquencyMain.LOGGER.info("Registering Mod Blocks");
    }

}
