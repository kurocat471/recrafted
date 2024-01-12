package net.kuro.recrafted.util;

import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.kuro.recrafted.structure.block.ModBlocks;

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
    }
}
