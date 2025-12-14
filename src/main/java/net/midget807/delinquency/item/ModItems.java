package net.midget807.delinquency.item;

import net.midget807.delinquency.DelinquencyMain;
import net.midget807.delinquency.item.custom.LensItem;
import net.midget807.delinquency.item.custom.SlimeCubeItem;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModItems {
    public static final Item SLIME_CUBE_ITEM = registerItem("slime_cube", new SlimeCubeItem(new Item.Settings().maxCount(1), EntityType.SLIME));
    public static final Item MAGMA_CUBE_ITEM = registerItem("magma_cube", new SlimeCubeItem(new Item.Settings().maxCount(1), EntityType.MAGMA_CUBE));
    public static final Item REVEALING_LENS = registerItem("lens_reveal", new LensItem(new Item.Settings().maxCount(1), true));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, DelinquencyMain.id(name), item);
    }

    public static void registerModItems() {
        DelinquencyMain.LOGGER.info("Registering Mod Items");
    }
}
