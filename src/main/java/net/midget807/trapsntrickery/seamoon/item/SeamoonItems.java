package net.midget807.trapsntrickery.seamoon.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.midget807.trapsntrickery.TrapsAndTrickeryMain;
import net.midget807.trapsntrickery.seamoon.effect.SeamoonEffects;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class SeamoonItems {

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, TrapsAndTrickeryMain.seamoonId(name), item);
    }

    public static void registerModItems() {
        TrapsAndTrickeryMain.LOGGER.info("Registering Seamoon Items");
    }
}
