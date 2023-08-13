package net.kuro.recrafted.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kuro.recrafted.Recrafted;
import net.kuro.recrafted.block.ModBlocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item COBALT_INGOT = registerItem("cobalt_ingot",
            new Item(new FabricItemSettings()));
    public static final Item COBALTITE = registerItem("cobaltite",
            new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Recrafted.MOD_ID, name), item);
    }

    private static void itemGroupIngredients(FabricItemGroupEntries entries) {
        entries.add(COBALT_INGOT);
        entries.add(COBALTITE);

        entries.add(ModBlocks.COBALT_BLOCK);
        entries.add(ModBlocks.COBALTITE_BLOCK);
    }

    public static void registerModItems() {
        Recrafted.LOGGER.info("Registering Mod Items for" + Recrafted.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::itemGroupIngredients);
    }
}
