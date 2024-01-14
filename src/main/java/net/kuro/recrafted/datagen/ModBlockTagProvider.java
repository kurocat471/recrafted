package net.kuro.recrafted.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.kuro.recrafted.Recrafted;
import net.kuro.recrafted.structure.block.ModBlocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
            .add(
                Recrafted.COPPER_LIGHTNING_ROD,
                Recrafted.EXPOSED_COPPER_LIGHTNING_ROD,
                Recrafted.WEATHERED_COPPER_LIGHTNING_ROD,
                Recrafted.OXIDIZED_COPPER_LIGHTNING_ROD,
                Recrafted.WAXED_COPPER_LIGHTNING_ROD,
                Recrafted.WAXED_EXPOSED_COPPER_LIGHTNING_ROD,
                Recrafted.WAXED_WEATHERED_COPPER_LIGHTNING_ROD,
                Recrafted.WAXED_OXIDIZED_COPPER_LIGHTNING_ROD
            );
        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
            .add(
                Recrafted.COPPER_LIGHTNING_ROD,
                Recrafted.EXPOSED_COPPER_LIGHTNING_ROD,
                Recrafted.WEATHERED_COPPER_LIGHTNING_ROD,
                Recrafted.OXIDIZED_COPPER_LIGHTNING_ROD,
                Recrafted.WAXED_COPPER_LIGHTNING_ROD,
                Recrafted.WAXED_EXPOSED_COPPER_LIGHTNING_ROD,
                Recrafted.WAXED_WEATHERED_COPPER_LIGHTNING_ROD,
                Recrafted.WAXED_OXIDIZED_COPPER_LIGHTNING_ROD
            );
    }
}
