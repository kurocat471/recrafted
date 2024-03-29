package net.kuro.recrafted.structure.item;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.kuro.recrafted.Recrafted;
import net.kuro.recrafted.structure.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.poi.PointOfInterestTypes;

import java.util.Set;

public class ModItemGroups {
    public static final ItemGroup RECRAFTED_GROUP;

    static {
        RECRAFTED_GROUP = Registry.register(Registries.ITEM_GROUP,
                new Identifier(Recrafted.MOD_ID, "recrafted_group"),
                FabricItemGroup.builder().displayName(Text.translatable("itemgroup.recrafted_group"))
                        .icon(() -> new ItemStack(ModItems.COBALT_INGOT)).entries((displayContext, entries) -> {
                            entries.add(ModBlocks.RHYOLITE);

                            entries.add(ModItems.COPPER_INGOT);
                            entries.add(ModItems.SUPERHEATED_COPPER_INGOT);
                            entries.add(ModItems.COPPER_NUGGET);
                            entries.add(ModItems.NATIVE_COPPER);
                            entries.add(ModItems.MALACHITE);
                            entries.add(ModItems.TETRAHEDRITE);
                            entries.add(ModItems.PATINA);

                            entries.add(ModBlocks.COPPER_BLOCK);
                            entries.add(ModBlocks.EXPOSED_COPPER_BLOCK);
                            entries.add(ModBlocks.WEATHERED_COPPER_BLOCK);
                            entries.add(ModBlocks.OXIDIZED_COPPER_BLOCK);
                            entries.add(ModBlocks.WAXED_COPPER_BLOCK);
                            entries.add(ModBlocks.WAXED_EXPOSED_COPPER_BLOCK);
                            entries.add(ModBlocks.WAXED_WEATHERED_COPPER_BLOCK);
                            entries.add(ModBlocks.WAXED_OXIDIZED_COPPER_BLOCK);

                            entries.add(ModBlocks.COPPER_GRATE);
                            entries.add(ModBlocks.EXPOSED_COPPER_GRATE);
                            entries.add(ModBlocks.WEATHERED_COPPER_GRATE);
                            entries.add(ModBlocks.OXIDIZED_COPPER_GRATE);
                            entries.add(ModBlocks.WAXED_COPPER_GRATE);
                            entries.add(ModBlocks.WAXED_EXPOSED_COPPER_GRATE);
                            entries.add(ModBlocks.WAXED_WEATHERED_COPPER_GRATE);
                            entries.add(ModBlocks.WAXED_OXIDIZED_COPPER_GRATE);

                            entries.add(ModBlocks.CHISELED_COPPER);
                            entries.add(ModBlocks.EXPOSED_CHISELED_COPPER);
                            entries.add(ModBlocks.WEATHERED_CHISELED_COPPER);
                            entries.add(ModBlocks.OXIDIZED_CHISELED_COPPER);
                            entries.add(ModBlocks.WAXED_CHISELED_COPPER);
                            entries.add(ModBlocks.WAXED_EXPOSED_CHISELED_COPPER);
                            entries.add(ModBlocks.WAXED_WEATHERED_CHISELED_COPPER);
                            entries.add(ModBlocks.WAXED_OXIDIZED_CHISELED_COPPER);

                            entries.add(ModBlocks.CUT_COPPER);
                            entries.add(ModBlocks.EXPOSED_CUT_COPPER);
                            entries.add(ModBlocks.WEATHERED_CUT_COPPER);
                            entries.add(ModBlocks.OXIDIZED_CUT_COPPER);
                            entries.add(ModBlocks.WAXED_CUT_COPPER);
                            entries.add(ModBlocks.WAXED_EXPOSED_CUT_COPPER);
                            entries.add(ModBlocks.WAXED_WEATHERED_CUT_COPPER);
                            entries.add(ModBlocks.WAXED_OXIDIZED_CUT_COPPER);

                            entries.add(ModBlocks.CUT_COPPER_STAIRS);
                            entries.add(ModBlocks.EXPOSED_CUT_COPPER_STAIRS);
                            entries.add(ModBlocks.WEATHERED_CUT_COPPER_STAIRS);
                            entries.add(ModBlocks.OXIDIZED_CUT_COPPER_STAIRS);
                            entries.add(ModBlocks.WAXED_CUT_COPPER_STAIRS);
                            entries.add(ModBlocks.WAXED_EXPOSED_CUT_COPPER_STAIRS);
                            entries.add(ModBlocks.WAXED_WEATHERED_CUT_COPPER_STAIRS);
                            entries.add(ModBlocks.WAXED_OXIDIZED_CUT_COPPER_STAIRS);

                            entries.add(ModBlocks.CUT_COPPER_SLAB);
                            entries.add(ModBlocks.EXPOSED_CUT_COPPER_SLAB);
                            entries.add(ModBlocks.WEATHERED_CUT_COPPER_SLAB);
                            entries.add(ModBlocks.OXIDIZED_CUT_COPPER_SLAB);
                            entries.add(ModBlocks.WAXED_CUT_COPPER_SLAB);
                            entries.add(ModBlocks.WAXED_EXPOSED_CUT_COPPER_SLAB);
                            entries.add(ModBlocks.WAXED_WEATHERED_CUT_COPPER_SLAB);
                            entries.add(ModBlocks.WAXED_OXIDIZED_CUT_COPPER_SLAB);

                            entries.add(ModBlocks.COPPER_DOOR);
                            entries.add(ModBlocks.EXPOSED_COPPER_DOOR);
                            entries.add(ModBlocks.WEATHERED_COPPER_DOOR);
                            entries.add(ModBlocks.OXIDIZED_COPPER_DOOR);
                            entries.add(ModBlocks.WAXED_COPPER_DOOR);
                            entries.add(ModBlocks.WAXED_EXPOSED_COPPER_DOOR);
                            entries.add(ModBlocks.WAXED_WEATHERED_COPPER_DOOR);
                            entries.add(ModBlocks.WAXED_OXIDIZED_COPPER_DOOR);

                            entries.add(ModBlocks.COPPER_TRAPDOOR);
                            entries.add(ModBlocks.EXPOSED_COPPER_TRAPDOOR);
                            entries.add(ModBlocks.WEATHERED_COPPER_TRAPDOOR);
                            entries.add(ModBlocks.OXIDIZED_COPPER_TRAPDOOR);
                            entries.add(ModBlocks.WAXED_COPPER_TRAPDOOR);
                            entries.add(ModBlocks.WAXED_EXPOSED_COPPER_TRAPDOOR);
                            entries.add(ModBlocks.WAXED_WEATHERED_COPPER_TRAPDOOR);
                            entries.add(ModBlocks.WAXED_OXIDIZED_COPPER_TRAPDOOR);

                            entries.add(ModBlocks.COPPER_BULB);
                            entries.add(ModBlocks.EXPOSED_COPPER_BULB);
                            entries.add(ModBlocks.WEATHERED_COPPER_BULB);
                            entries.add(ModBlocks.OXIDIZED_COPPER_BULB);
                            entries.add(ModBlocks.WAXED_COPPER_BULB);
                            entries.add(ModBlocks.WAXED_EXPOSED_COPPER_BULB);
                            entries.add(ModBlocks.WAXED_WEATHERED_COPPER_BULB);
                            entries.add(ModBlocks.WAXED_OXIDIZED_COPPER_BULB);

                            entries.add(ModBlocks.COPPER_LIGHTNING_ROD);
                            entries.add(ModBlocks.EXPOSED_COPPER_LIGHTNING_ROD);
                            entries.add(ModBlocks.WEATHERED_COPPER_LIGHTNING_ROD);
                            entries.add(ModBlocks.OXIDIZED_COPPER_LIGHTNING_ROD);
                            entries.add(ModBlocks.WAXED_COPPER_LIGHTNING_ROD);
                            entries.add(ModBlocks.WAXED_EXPOSED_COPPER_LIGHTNING_ROD);
                            entries.add(ModBlocks.WAXED_WEATHERED_COPPER_LIGHTNING_ROD);
                            entries.add(ModBlocks.WAXED_OXIDIZED_COPPER_LIGHTNING_ROD);

                            entries.add(ModBlocks.COPPER_ANVIL);
                            entries.add(ModBlocks.EXPOSED_COPPER_ANVIL);
                            entries.add(ModBlocks.WEATHERED_COPPER_ANVIL);
                            entries.add(ModBlocks.OXIDIZED_COPPER_ANVIL);
                            entries.add(ModBlocks.WAXED_COPPER_ANVIL);
                            entries.add(ModBlocks.WAXED_EXPOSED_COPPER_ANVIL);
                            entries.add(ModBlocks.WAXED_WEATHERED_COPPER_ANVIL);
                            entries.add(ModBlocks.WAXED_OXIDIZED_COPPER_ANVIL);

                            entries.add(ModBlocks.RESISTOR);
                            entries.add(ModBlocks.EXPOSED_RESISTOR);
                            entries.add(ModBlocks.WEATHERED_RESISTOR);
                            entries.add(ModBlocks.OXIDIZED_RESISTOR);
                            entries.add(ModBlocks.WAXED_RESISTOR);
                            entries.add(ModBlocks.WAXED_EXPOSED_RESISTOR);
                            entries.add(ModBlocks.WAXED_WEATHERED_RESISTOR);
                            entries.add(ModBlocks.WAXED_OXIDIZED_RESISTOR);

                            entries.add(ModBlocks.COPPER_PANEL);

                            entries.add(ModBlocks.PATINA_BLOCK);

                            entries.add(ModItems.PATINA_TORCH);
                            entries.add(ModBlocks.PATINA_LANTERN);
                            entries.add(ModBlocks.PATINA_CAMPFIRE);

                            entries.add(ModBlocks.NATIVE_COPPER_BLOCK);
                            entries.add(ModBlocks.MALACHITE_BLOCK);
                            entries.add(ModBlocks.TETRAHEDRITE_BLOCK);

                            entries.add(ModItems.TIN_INGOT);
                            entries.add(ModItems.SUPERHEATED_TIN_INGOT);
                            entries.add(ModItems.TIN_NUGGET);
                            entries.add(ModItems.CASSITERITE);
                            entries.add(ModBlocks.TIN_BLOCK);
                            entries.add(ModBlocks.CASSITERITE_BLOCK);
                            entries.add(ModItems.ZINC_INGOT);
                            entries.add(ModItems.SUPERHEATED_ZINC_INGOT);
                            entries.add(ModItems.ZINC_NUGGET);
                            entries.add(ModItems.SPHALERITE);
                            entries.add(ModBlocks.ZINC_BLOCK);
                            entries.add(ModBlocks.SPHALERITE_BLOCK);
                            entries.add(ModItems.ALUMINIUM_INGOT);
                            entries.add(ModItems.SUPERHEATED_ALUMINIUM_INGOT);
                            entries.add(ModItems.ALUMINIUM_NUGGET);
                            entries.add(ModItems.BAUXITE);
                            entries.add(ModBlocks.ALUMINIUM_BLOCK);
                            entries.add(ModBlocks.BAUXITE_BLOCK);
                            entries.add(ModItems.BISMUTH_INGOT);
                            entries.add(ModItems.SUPERHEATED_BISMUTH_INGOT);
                            entries.add(ModItems.BISMUTH_NUGGET);
                            entries.add(ModItems.BISMUTHINITE);
                            entries.add(ModBlocks.BISMUTH_BLOCK);
                            entries.add(ModBlocks.BISMUTHINITE_BLOCK);
                            entries.add(ModItems.NICKEL_INGOT);
                            entries.add(ModItems.SUPERHEATED_NICKEL_INGOT);
                            entries.add(ModItems.NICKEL_NUGGET);
                            entries.add(ModItems.SERPENTINITE);
                            entries.add(ModItems.GARNIERITE);
                            entries.add(ModBlocks.NICKEL_BLOCK);
                            entries.add(ModBlocks.SERPENTINITE_BLOCK);
                            entries.add(ModBlocks.GARNIERITE_BLOCK);
                            entries.add(ModItems.SILVER_INGOT);
                            entries.add(ModItems.SUPERHEATED_SILVER_INGOT);
                            entries.add(ModItems.SILVER_NUGGET);
                            entries.add(ModItems.NATIVE_SILVER);
                            entries.add(ModItems.ARGENTITE);
                            entries.add(ModBlocks.SILVER_BLOCK);
                            entries.add(ModBlocks.NATIVE_SILVER_BLOCK);
                            entries.add(ModBlocks.ARGENTITE_BLOCK);
                            entries.add(ModItems.GOLD_INGOT);
                            entries.add(ModItems.SUPERHEATED_GOLD_INGOT);
                            entries.add(ModItems.GOLD_NUGGET);
                            entries.add(ModItems.NATIVE_GOLD);
                            entries.add(ModBlocks.GOLD_BLOCK);
                            entries.add(ModBlocks.NATIVE_GOLD_BLOCK);
                            entries.add(ModItems.LEAD_INGOT);
                            entries.add(ModItems.SUPERHEATED_LEAD_INGOT);
                            entries.add(ModItems.LEAD_NUGGET);
                            entries.add(ModItems.GALENA);
                            entries.add(ModBlocks.LEAD_BLOCK);
                            entries.add(ModBlocks.GALENA_BLOCK);
                            entries.add(ModItems.IRON_INGOT);
                            entries.add(ModItems.SUPERHEATED_IRON_INGOT);
                            entries.add(ModItems.IRON_NUGGET);
                            entries.add(ModItems.HEMATITE);
                            entries.add(ModItems.MAGNETITE);
                            entries.add(ModItems.LIMONITE);
                            entries.add(ModBlocks.IRON_BLOCK);
                            entries.add(ModBlocks.HEMATITE_BLOCK);
                            entries.add(ModBlocks.MAGNETITE_BLOCK);
                            entries.add(ModBlocks.LIMONITE_BLOCK);
                            entries.add(ModItems.COBALT_INGOT);
                            entries.add(ModItems.SUPERHEATED_COBALT_INGOT);
                            entries.add(ModItems.COBALT_NUGGET);
                            entries.add(ModItems.COBALTITE);
                            entries.add(ModBlocks.COBALT_BLOCK);
                            entries.add(ModBlocks.COBALTITE_BLOCK);
                            entries.add(ModItems.PLATINUM_INGOT);
                            entries.add(ModItems.SUPERHEATED_PLATINUM_INGOT);
                            entries.add(ModItems.PLATINUM_NUGGET);
                            entries.add(ModItems.NATIVE_PLATINUM);
                            entries.add(ModBlocks.PLATINUM_BLOCK);
                            entries.add(ModBlocks.NATIVE_PLATINUM_BLOCK);
                            entries.add(ModItems.TITANIUM_INGOT);
                            entries.add(ModItems.SUPERHEATED_TITANIUM_INGOT);
                            entries.add(ModItems.TITANIUM_NUGGET);
                            entries.add(ModItems.ILMENITE);
                            entries.add(ModItems.RUTILE);
                            entries.add(ModBlocks.TITANIUM_BLOCK);
                            entries.add(ModBlocks.ILMENITE_BLOCK);
                            entries.add(ModBlocks.RUTILE_BLOCK);
                            entries.add(ModItems.BRONZE_INGOT);
                            entries.add(ModItems.SUPERHEATED_BRONZE_INGOT);
                            entries.add(ModBlocks.BRONZE_BLOCK);
                            entries.add(ModItems.BISMUTH_BRONZE_INGOT);
                            entries.add(ModItems.SUPERHEATED_BISMUTH_BRONZE_INGOT);
                            entries.add(ModBlocks.BISMUTH_BRONZE_BLOCK);
                            entries.add(ModItems.BLACK_BRONZE_INGOT);
                            entries.add(ModItems.SUPERHEATED_BLACK_BRONZE_INGOT);
                            entries.add(ModBlocks.BLACK_BRONZE_BLOCK);
                            entries.add(ModItems.WHITE_BRONZE_INGOT);
                            entries.add(ModItems.SUPERHEATED_WHITE_BRONZE_INGOT);
                            entries.add(ModBlocks.WHITE_BRONZE_BLOCK);
                            entries.add(ModItems.BRASS_INGOT);
                            entries.add(ModItems.SUPERHEATED_BRASS_INGOT);
                            entries.add(ModBlocks.BRASS_BLOCK);
                            entries.add(ModItems.ELECTRUM_INGOT);
                            entries.add(ModItems.SUPERHEATED_ELECTRUM_INGOT);
                            entries.add(ModBlocks.ELECTRUM_BLOCK);
                            entries.add(ModItems.STERLING_SILVER_INGOT);
                            entries.add(ModItems.SUPERHEATED_STERLING_SILVER_INGOT);
                            entries.add(ModBlocks.STERLING_SILVER_BLOCK);
                            entries.add(ModItems.ROSE_GOLD_INGOT);
                            entries.add(ModItems.SUPERHEATED_ROSE_GOLD_INGOT);
                            entries.add(ModBlocks.ROSE_GOLD_BLOCK);
                            entries.add(ModItems.GUNMETAL_INGOT);
                            entries.add(ModItems.SUPERHEATED_GUNMETAL_INGOT);
                            entries.add(ModBlocks.GUNMETAL_BLOCK);
                            entries.add(ModItems.PEWTER_INGOT);
                            entries.add(ModItems.SUPERHEATED_PEWTER_INGOT);
                            entries.add(ModBlocks.PEWTER_BLOCK);
                            entries.add(ModItems.STEEL_INGOT);
                            entries.add(ModItems.SUPERHEATED_STEEL_INGOT);
                            entries.add(ModBlocks.STEEL_BLOCK);

                            entries.add(ModItems.ROUGH_OPAL);
                            entries.add(ModItems.OPAL);
                            entries.add(ModBlocks.OPAL_BLOCK);

                            entries.add(ModItems.SUPERHEATED_COPPER_PICKAXE_HEAD);
                            entries.add(ModItems.SUPERHEATED_COPPER_AXE_HEAD);
                            entries.add(ModItems.SUPERHEATED_COPPER_SHOVEL_HEAD);
                            entries.add(ModItems.SUPERHEATED_COPPER_HOE_HEAD);
                            entries.add(ModItems.SUPERHEATED_COPPER_BROADSWORD_BLADE);

                            entries.add(ModItems.COPPER_PICKAXE_HEAD);
                            entries.add(ModItems.COPPER_AXE_HEAD);
                            entries.add(ModItems.COPPER_SHOVEL_HEAD);
                            entries.add(ModItems.COPPER_HOE_HEAD);
                            entries.add(ModItems.COPPER_BROADSWORD_BLADE);

                            entries.add(ModItems.COPPER_PICKAXE);
                            entries.add(ModItems.COPPER_AXE);
                            entries.add(ModItems.COPPER_SHOVEL);
                            entries.add(ModItems.COPPER_HOE);
                            entries.add(ModItems.COPPER_BROADSWORD);

                            entries.add(ModItems.COPPER_HAMMER);
                            entries.add(ModItems.BRONZE_HAMMER);
                            entries.add(ModItems.BISMUTH_BRONZE_HAMMER);
                            entries.add(ModItems.BLACK_BRONZE_HAMMER);
                            entries.add(ModItems.WHITE_BRONZE_HAMMER);
                            entries.add(ModItems.IRON_HAMMER);
                            entries.add(ModItems.STEEL_HAMMER);

                            entries.add(ModBlocks.BRONZE_ANVIL);
                            entries.add(ModBlocks.BISMUTH_BRONZE_ANVIL);
                            entries.add(ModBlocks.BLACK_BRONZE_ANVIL);
                            entries.add(ModBlocks.WHITE_BRONZE_ANVIL);
                            entries.add(ModBlocks.IRON_ANVIL);
                            entries.add(ModBlocks.STEEL_ANVIL);

                            entries.add(ModItems.SPRUCE_BARREL);
                            entries.add(ModItems.BIRCH_BARREL);

                        }).build());

    }

    public static void registerItemGroups() {
        Recrafted.LOGGER.info("Registering Item Groups for " + Recrafted.MOD_ID);
    }
}
