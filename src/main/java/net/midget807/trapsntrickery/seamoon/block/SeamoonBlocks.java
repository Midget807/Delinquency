package net.midget807.trapsntrickery.seamoon.block;

import net.midget807.trapsntrickery.TrapsAndTrickeryMain;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;

public class SeamoonBlocks {
    public static final Block SEAMOON_BLOCK = registerBlock("seamoon_block", new Block(AbstractBlock.Settings.create().mapColor(MapColor.WHITE).instrument(NoteBlockInstrument.BANJO).strength(50.0f, 3600000.0F).sounds(BlockSoundGroup.SLIME)));
    public static final Block SEAMOON_STAIRS = registerBlock("seamoon_stairs", new StairsBlock(SEAMOON_BLOCK.getDefaultState(), SEAMOON_BLOCK.getSettings()));
    public static final Block SEAMOON_SLABS = registerBlock("seamoon_slabs", new SlabBlock(SEAMOON_BLOCK.getSettings()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, TrapsAndTrickeryMain.seamoonId(name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, TrapsAndTrickeryMain.seamoonId(name), new BlockItem(block, new Item.Settings()));
    }

    public static void registerSeamoonBlocks() {
        TrapsAndTrickeryMain.LOGGER.info("Registering Seamoon Blocks");
    }
}
