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
        BlockStateModelGenerator.BlockTexturePool cutCopperTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CUT_COPPER);
        cutCopperTexturePool.stairs(ModBlocks.CUT_COPPER_STAIRS);
        cutCopperTexturePool.slab(ModBlocks.CUT_COPPER_SLAB);
        BlockStateModelGenerator.BlockTexturePool exposedCutCopperTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.EXPOSED_CUT_COPPER);
        exposedCutCopperTexturePool.stairs(ModBlocks.EXPOSED_CUT_COPPER_STAIRS);
        exposedCutCopperTexturePool.slab(ModBlocks.EXPOSED_CUT_COPPER_SLAB);
        BlockStateModelGenerator.BlockTexturePool weatheredCutCopperTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.WEATHERED_CUT_COPPER);
        weatheredCutCopperTexturePool.stairs(ModBlocks.WEATHERED_CUT_COPPER_STAIRS);
        weatheredCutCopperTexturePool.slab(ModBlocks.WEATHERED_CUT_COPPER_SLAB);
        BlockStateModelGenerator.BlockTexturePool oxidizedCutCopperTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.OXIDIZED_CUT_COPPER);
        oxidizedCutCopperTexturePool.stairs(ModBlocks.OXIDIZED_CUT_COPPER_STAIRS);
        oxidizedCutCopperTexturePool.slab(ModBlocks.OXIDIZED_CUT_COPPER_SLAB);
        BlockStateModelGenerator.BlockTexturePool waxedCutCopperTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.WAXED_CUT_COPPER);
        waxedCutCopperTexturePool.stairs(ModBlocks.WAXED_CUT_COPPER_STAIRS);
        waxedCutCopperTexturePool.slab(ModBlocks.WAXED_CUT_COPPER_SLAB);
        BlockStateModelGenerator.BlockTexturePool waxedExposedCutCopperTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.WAXED_EXPOSED_CUT_COPPER);
        waxedExposedCutCopperTexturePool.stairs(ModBlocks.WAXED_EXPOSED_CUT_COPPER_STAIRS);
        waxedExposedCutCopperTexturePool.slab(ModBlocks.WAXED_EXPOSED_CUT_COPPER_SLAB);
        BlockStateModelGenerator.BlockTexturePool waxedWeatheredCutCopperTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.WAXED_WEATHERED_CUT_COPPER);
        waxedWeatheredCutCopperTexturePool.stairs(ModBlocks.WAXED_WEATHERED_CUT_COPPER_STAIRS);
        waxedWeatheredCutCopperTexturePool.slab(ModBlocks.WAXED_WEATHERED_CUT_COPPER_SLAB);
        BlockStateModelGenerator.BlockTexturePool waxedOxidizedCutCopperTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.WAXED_OXIDIZED_CUT_COPPER);
        waxedOxidizedCutCopperTexturePool.stairs(ModBlocks.WAXED_OXIDIZED_CUT_COPPER_STAIRS);
        waxedOxidizedCutCopperTexturePool.slab(ModBlocks.WAXED_OXIDIZED_CUT_COPPER_SLAB);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }
}
