package net.kuro.recrafted.util;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.kuro.recrafted.Recrafted;
import net.kuro.recrafted.structure.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;

import java.util.Set;

public class ModRegistries {

    public static void registerModRegistries() {
        registerOxidizables();
    }

    private static void registerOxidizables() {
        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModBlocks.COPPER_BLOCK, ModBlocks.EXPOSED_COPPER_BLOCK);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModBlocks.EXPOSED_COPPER_BLOCK, ModBlocks.WEATHERED_COPPER_BLOCK);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModBlocks.WEATHERED_COPPER_BLOCK, ModBlocks.OXIDIZED_COPPER_BLOCK);

        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.COPPER_BLOCK, ModBlocks.WAXED_COPPER_BLOCK);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.EXPOSED_COPPER_BLOCK, ModBlocks.WAXED_EXPOSED_COPPER_BLOCK);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.WEATHERED_COPPER_BLOCK, ModBlocks.WAXED_WEATHERED_COPPER_BLOCK);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.OXIDIZED_COPPER_BLOCK, ModBlocks.WAXED_OXIDIZED_COPPER_BLOCK);

        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModBlocks.COPPER_GRATE, ModBlocks.EXPOSED_COPPER_GRATE);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModBlocks.EXPOSED_COPPER_GRATE, ModBlocks.WEATHERED_COPPER_GRATE);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModBlocks.WEATHERED_COPPER_GRATE, ModBlocks.OXIDIZED_COPPER_GRATE);

        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.COPPER_GRATE, ModBlocks.WAXED_COPPER_GRATE);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.EXPOSED_COPPER_GRATE, ModBlocks.WAXED_EXPOSED_COPPER_GRATE);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.WEATHERED_COPPER_GRATE, ModBlocks.WAXED_WEATHERED_COPPER_GRATE);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.OXIDIZED_COPPER_GRATE, ModBlocks.WAXED_OXIDIZED_COPPER_GRATE);

        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModBlocks.CHISELED_COPPER, ModBlocks.EXPOSED_CHISELED_COPPER);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModBlocks.EXPOSED_CHISELED_COPPER, ModBlocks.WEATHERED_CHISELED_COPPER);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModBlocks.WEATHERED_CHISELED_COPPER, ModBlocks.OXIDIZED_CHISELED_COPPER);

        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.CHISELED_COPPER, ModBlocks.WAXED_CHISELED_COPPER);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.EXPOSED_CHISELED_COPPER, ModBlocks.WAXED_EXPOSED_CHISELED_COPPER);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.WEATHERED_CHISELED_COPPER, ModBlocks.WAXED_WEATHERED_CHISELED_COPPER);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.OXIDIZED_CHISELED_COPPER, ModBlocks.WAXED_OXIDIZED_CHISELED_COPPER);

        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModBlocks.CUT_COPPER, ModBlocks.EXPOSED_CUT_COPPER);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModBlocks.EXPOSED_CUT_COPPER, ModBlocks.WEATHERED_CUT_COPPER);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModBlocks.WEATHERED_CUT_COPPER, ModBlocks.OXIDIZED_CUT_COPPER);

        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.CUT_COPPER, ModBlocks.WAXED_CUT_COPPER);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.EXPOSED_CUT_COPPER, ModBlocks.WAXED_EXPOSED_CUT_COPPER);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.WEATHERED_CUT_COPPER, ModBlocks.WAXED_WEATHERED_CUT_COPPER);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.OXIDIZED_CUT_COPPER, ModBlocks.WAXED_OXIDIZED_CUT_COPPER);

        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModBlocks.CUT_COPPER_STAIRS, ModBlocks.EXPOSED_CUT_COPPER_STAIRS);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModBlocks.EXPOSED_CUT_COPPER_STAIRS, ModBlocks.WEATHERED_CUT_COPPER_STAIRS);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModBlocks.WEATHERED_CUT_COPPER_STAIRS, ModBlocks.OXIDIZED_CUT_COPPER_STAIRS);

        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.CUT_COPPER_STAIRS, ModBlocks.WAXED_CUT_COPPER_STAIRS);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.EXPOSED_CUT_COPPER_STAIRS, ModBlocks.WAXED_EXPOSED_CUT_COPPER_STAIRS);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.WEATHERED_CUT_COPPER_STAIRS, ModBlocks.WAXED_WEATHERED_CUT_COPPER_STAIRS);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.OXIDIZED_CUT_COPPER_STAIRS, ModBlocks.WAXED_OXIDIZED_CUT_COPPER_STAIRS);

        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModBlocks.CUT_COPPER_SLAB, ModBlocks.EXPOSED_CUT_COPPER_SLAB);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModBlocks.EXPOSED_CUT_COPPER_SLAB, ModBlocks.WEATHERED_CUT_COPPER_SLAB);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModBlocks.WEATHERED_CUT_COPPER_SLAB, ModBlocks.OXIDIZED_CUT_COPPER_SLAB);

        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.CUT_COPPER_SLAB, ModBlocks.WAXED_CUT_COPPER_SLAB);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.EXPOSED_CUT_COPPER_SLAB, ModBlocks.WAXED_EXPOSED_CUT_COPPER_SLAB);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.WEATHERED_CUT_COPPER_SLAB, ModBlocks.WAXED_WEATHERED_CUT_COPPER_SLAB);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.OXIDIZED_CUT_COPPER_SLAB, ModBlocks.WAXED_OXIDIZED_CUT_COPPER_SLAB);

        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModBlocks.COPPER_DOOR, ModBlocks.EXPOSED_COPPER_DOOR);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModBlocks.EXPOSED_COPPER_DOOR, ModBlocks.WEATHERED_COPPER_DOOR);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModBlocks.WEATHERED_COPPER_DOOR, ModBlocks.OXIDIZED_COPPER_DOOR);

        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.COPPER_DOOR, ModBlocks.WAXED_COPPER_DOOR);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.EXPOSED_COPPER_DOOR, ModBlocks.WAXED_EXPOSED_COPPER_DOOR);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.WEATHERED_COPPER_DOOR, ModBlocks.WAXED_WEATHERED_COPPER_DOOR);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.OXIDIZED_COPPER_DOOR, ModBlocks.WAXED_OXIDIZED_COPPER_DOOR);

        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModBlocks.COPPER_TRAPDOOR, ModBlocks.EXPOSED_COPPER_TRAPDOOR);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModBlocks.EXPOSED_COPPER_TRAPDOOR, ModBlocks.WEATHERED_COPPER_TRAPDOOR);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModBlocks.WEATHERED_COPPER_TRAPDOOR, ModBlocks.OXIDIZED_COPPER_TRAPDOOR);

        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.COPPER_TRAPDOOR, ModBlocks.WAXED_COPPER_TRAPDOOR);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.EXPOSED_COPPER_TRAPDOOR, ModBlocks.WAXED_EXPOSED_COPPER_TRAPDOOR);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.WEATHERED_COPPER_TRAPDOOR, ModBlocks.WAXED_WEATHERED_COPPER_TRAPDOOR);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.OXIDIZED_COPPER_TRAPDOOR, ModBlocks.WAXED_OXIDIZED_COPPER_TRAPDOOR);

        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModBlocks.COPPER_BULB, ModBlocks.EXPOSED_COPPER_BULB);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModBlocks.EXPOSED_COPPER_BULB, ModBlocks.WEATHERED_COPPER_BULB);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModBlocks.WEATHERED_COPPER_BULB, ModBlocks.OXIDIZED_COPPER_BULB);

        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.COPPER_BULB, ModBlocks.WAXED_COPPER_BULB);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.EXPOSED_COPPER_BULB, ModBlocks.WAXED_EXPOSED_COPPER_BULB);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.WEATHERED_COPPER_BULB, ModBlocks.WAXED_WEATHERED_COPPER_BULB);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.OXIDIZED_COPPER_BULB, ModBlocks.WAXED_OXIDIZED_COPPER_BULB);

        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModBlocks.COPPER_LIGHTNING_ROD, ModBlocks.EXPOSED_COPPER_LIGHTNING_ROD);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModBlocks.EXPOSED_COPPER_LIGHTNING_ROD, ModBlocks.WEATHERED_COPPER_LIGHTNING_ROD);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModBlocks.WEATHERED_COPPER_LIGHTNING_ROD, ModBlocks.OXIDIZED_COPPER_LIGHTNING_ROD);

        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.COPPER_LIGHTNING_ROD, ModBlocks.WAXED_COPPER_LIGHTNING_ROD);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.EXPOSED_COPPER_LIGHTNING_ROD, ModBlocks.WAXED_EXPOSED_COPPER_LIGHTNING_ROD);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.WEATHERED_COPPER_LIGHTNING_ROD, ModBlocks.WAXED_WEATHERED_COPPER_LIGHTNING_ROD);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.OXIDIZED_COPPER_LIGHTNING_ROD, ModBlocks.WAXED_OXIDIZED_COPPER_LIGHTNING_ROD);

        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModBlocks.COPPER_ANVIL, ModBlocks.EXPOSED_COPPER_ANVIL);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModBlocks.EXPOSED_COPPER_ANVIL, ModBlocks.WEATHERED_COPPER_ANVIL);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModBlocks.WEATHERED_COPPER_ANVIL, ModBlocks.OXIDIZED_COPPER_ANVIL);

        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.COPPER_ANVIL, ModBlocks.WAXED_COPPER_ANVIL);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.EXPOSED_COPPER_ANVIL, ModBlocks.WAXED_EXPOSED_COPPER_ANVIL);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.WEATHERED_COPPER_ANVIL, ModBlocks.WAXED_WEATHERED_COPPER_ANVIL);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.OXIDIZED_COPPER_ANVIL, ModBlocks.WAXED_OXIDIZED_COPPER_ANVIL);

        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModBlocks.RESISTOR, ModBlocks.EXPOSED_RESISTOR);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModBlocks.EXPOSED_RESISTOR, ModBlocks.WEATHERED_RESISTOR);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModBlocks.WEATHERED_RESISTOR, ModBlocks.OXIDIZED_RESISTOR);

        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.RESISTOR, ModBlocks.WAXED_RESISTOR);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.EXPOSED_RESISTOR, ModBlocks.WAXED_EXPOSED_RESISTOR);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.WEATHERED_RESISTOR, ModBlocks.WAXED_WEATHERED_RESISTOR);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.OXIDIZED_RESISTOR, ModBlocks.WAXED_OXIDIZED_RESISTOR);
    }
}
