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
        blockStateModelGenerator.registerDoor(ModBlocks.COPPER_DOOR);
        blockStateModelGenerator.registerDoor(ModBlocks.EXPOSED_COPPER_DOOR);
        blockStateModelGenerator.registerDoor(ModBlocks.WEATHERED_COPPER_DOOR);
        blockStateModelGenerator.registerDoor(ModBlocks.OXIDIZED_COPPER_DOOR);
        blockStateModelGenerator.registerDoor(ModBlocks.WAXED_COPPER_DOOR);
        blockStateModelGenerator.registerDoor(ModBlocks.WAXED_EXPOSED_COPPER_DOOR);
        blockStateModelGenerator.registerDoor(ModBlocks.WAXED_WEATHERED_COPPER_DOOR);
        blockStateModelGenerator.registerDoor(ModBlocks.WAXED_OXIDIZED_COPPER_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.COPPER_TRAPDOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.EXPOSED_COPPER_TRAPDOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.WEATHERED_COPPER_TRAPDOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.OXIDIZED_COPPER_TRAPDOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.WAXED_COPPER_TRAPDOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.WAXED_EXPOSED_COPPER_TRAPDOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.WAXED_WEATHERED_COPPER_TRAPDOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.WAXED_OXIDIZED_COPPER_TRAPDOOR);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }
}
