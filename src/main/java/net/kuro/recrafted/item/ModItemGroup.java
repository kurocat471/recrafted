package net.kuro.recrafted.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.kuro.recrafted.Recrafted;
import net.kuro.recrafted.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup METALS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Recrafted.MOD_ID, "metals_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.metals_group"))
                    .icon(() -> new ItemStack(ModItems.COBALT_INGOT)).entries((displayContext, entries) -> {
                        entries.add(ModItems.COBALT_INGOT);
                        entries.add(ModItems.COBALTITE);

                        entries.add(ModBlocks.COBALT_BLOCK);
                        entries.add(ModBlocks.COBALTITE_BLOCK);

                    }).build());

    public static final ItemGroup STONES_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Recrafted.MOD_ID, "stones_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.stones_group"))
                    .icon(() -> new ItemStack(ModItems.COBALT_INGOT)).entries((displayContext, entries) -> {
                        entries.add(ModItems.COBALT_INGOT);
                        entries.add(ModItems.COBALTITE);

                        entries.add(ModBlocks.COBALT_BLOCK);
                        entries.add(ModBlocks.COBALTITE_BLOCK);

                    }).build());


    public static void registerItemGroups() {

    }
}
