package net.midget807.delinquency.block;

import net.midget807.delinquency.DelinquencyMain;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModBlockEntities {

    //public static final BlockEntityType<PitCoverBlockEntity> PIT_COVER_BLOCK_ENTITY = registerBlockEntity("pit_cover", PitCoverBlockEntity::new, ModBlocks.PIT_COVER);

    private static <T extends BlockEntity> BlockEntityType<T> registerBlockEntity(String name, BlockEntityType.BlockEntityFactory<? extends T> entityFactory, Block... blocks) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, DelinquencyMain.id(name), BlockEntityType.Builder.<T>create(entityFactory, blocks).build());
    }
}
