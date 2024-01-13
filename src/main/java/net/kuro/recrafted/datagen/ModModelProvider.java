package net.kuro.recrafted.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.kuro.recrafted.structure.block.ModBlocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_COPPER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.EXPOSED_CHISELED_COPPER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.WEATHERED_CHISELED_COPPER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.OXIDIZED_CHISELED_COPPER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.WAXED_CHISELED_COPPER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.WAXED_EXPOSED_CHISELED_COPPER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.WAXED_WEATHERED_CHISELED_COPPER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.WAXED_OXIDIZED_CHISELED_COPPER);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }
}
