package net.kuro.recrafted.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
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
                ModBlocks.COPPER_BLOCK,
                ModBlocks.EXPOSED_COPPER_BLOCK,
                ModBlocks.WEATHERED_COPPER_BLOCK,
                ModBlocks.OXIDIZED_COPPER_BLOCK,
                ModBlocks.WAXED_COPPER_BLOCK,
                ModBlocks.WAXED_EXPOSED_COPPER_BLOCK,
                ModBlocks.WAXED_WEATHERED_COPPER_BLOCK,
                ModBlocks.WAXED_OXIDIZED_COPPER_BLOCK,

                ModBlocks.COPPER_GRATE,
                ModBlocks.EXPOSED_COPPER_GRATE,
                ModBlocks.WEATHERED_COPPER_GRATE,
                ModBlocks.OXIDIZED_COPPER_GRATE,
                ModBlocks.WAXED_COPPER_GRATE,
                ModBlocks.WAXED_EXPOSED_COPPER_GRATE,
                ModBlocks.WAXED_WEATHERED_COPPER_GRATE,
                ModBlocks.WAXED_OXIDIZED_COPPER_GRATE,

                ModBlocks.CHISELED_COPPER,
                ModBlocks.EXPOSED_CHISELED_COPPER,
                ModBlocks.WEATHERED_CHISELED_COPPER,
                ModBlocks.OXIDIZED_CHISELED_COPPER,
                ModBlocks.WAXED_CHISELED_COPPER,
                ModBlocks.WAXED_EXPOSED_CHISELED_COPPER,
                ModBlocks.WAXED_WEATHERED_CHISELED_COPPER,
                ModBlocks.WAXED_OXIDIZED_CHISELED_COPPER,

                ModBlocks.CUT_COPPER,
                ModBlocks.EXPOSED_CUT_COPPER,
                ModBlocks.WEATHERED_CUT_COPPER,
                ModBlocks.OXIDIZED_CUT_COPPER,
                ModBlocks.WAXED_CUT_COPPER,
                ModBlocks.WAXED_EXPOSED_CUT_COPPER,
                ModBlocks.WAXED_WEATHERED_CUT_COPPER,
                ModBlocks.WAXED_OXIDIZED_CUT_COPPER,

                ModBlocks.CUT_COPPER_STAIRS,
                ModBlocks.EXPOSED_CUT_COPPER_STAIRS,
                ModBlocks.WEATHERED_CUT_COPPER_STAIRS,
                ModBlocks.OXIDIZED_CUT_COPPER_STAIRS,
                ModBlocks.WAXED_CUT_COPPER_STAIRS,
                ModBlocks.WAXED_EXPOSED_CUT_COPPER_STAIRS,
                ModBlocks.WAXED_WEATHERED_CUT_COPPER_STAIRS,
                ModBlocks.WAXED_OXIDIZED_CUT_COPPER_STAIRS,

                ModBlocks.CUT_COPPER_SLAB,
                ModBlocks.EXPOSED_CUT_COPPER_SLAB,
                ModBlocks.WEATHERED_CUT_COPPER_SLAB,
                ModBlocks.OXIDIZED_CUT_COPPER_SLAB,
                ModBlocks.WAXED_CUT_COPPER_SLAB,
                ModBlocks.WAXED_EXPOSED_CUT_COPPER_SLAB,
                ModBlocks.WAXED_WEATHERED_CUT_COPPER_SLAB,
                ModBlocks.WAXED_OXIDIZED_CUT_COPPER_SLAB,

                ModBlocks.COPPER_DOOR,
                ModBlocks.EXPOSED_COPPER_DOOR,
                ModBlocks.WEATHERED_COPPER_DOOR,
                ModBlocks.OXIDIZED_COPPER_DOOR,
                ModBlocks.WAXED_COPPER_DOOR,
                ModBlocks.WAXED_EXPOSED_COPPER_DOOR,
                ModBlocks.WAXED_WEATHERED_COPPER_DOOR,
                ModBlocks.WAXED_OXIDIZED_COPPER_DOOR,

                ModBlocks.COPPER_TRAPDOOR,
                ModBlocks.EXPOSED_COPPER_TRAPDOOR,
                ModBlocks.WEATHERED_COPPER_TRAPDOOR,
                ModBlocks.OXIDIZED_COPPER_TRAPDOOR,
                ModBlocks.WAXED_COPPER_TRAPDOOR,
                ModBlocks.WAXED_EXPOSED_COPPER_TRAPDOOR,
                ModBlocks.WAXED_WEATHERED_COPPER_TRAPDOOR,
                ModBlocks.WAXED_OXIDIZED_COPPER_TRAPDOOR,

                ModBlocks.COPPER_BULB,
                ModBlocks.EXPOSED_COPPER_BULB,
                ModBlocks.WEATHERED_COPPER_BULB,
                ModBlocks.OXIDIZED_COPPER_BULB,
                ModBlocks.WAXED_COPPER_BULB,
                ModBlocks.WAXED_EXPOSED_COPPER_BULB,
                ModBlocks.WAXED_WEATHERED_COPPER_BULB,
                ModBlocks.WAXED_OXIDIZED_COPPER_BULB
            );
        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
            .add(
                ModBlocks.COPPER_BLOCK,
                ModBlocks.EXPOSED_COPPER_BLOCK,
                ModBlocks.WEATHERED_COPPER_BLOCK,
                ModBlocks.OXIDIZED_COPPER_BLOCK,
                ModBlocks.WAXED_COPPER_BLOCK,
                ModBlocks.WAXED_EXPOSED_COPPER_BLOCK,
                ModBlocks.WAXED_WEATHERED_COPPER_BLOCK,
                ModBlocks.WAXED_OXIDIZED_COPPER_BLOCK,

                ModBlocks.COPPER_GRATE,
                ModBlocks.EXPOSED_COPPER_GRATE,
                ModBlocks.WEATHERED_COPPER_GRATE,
                ModBlocks.OXIDIZED_COPPER_GRATE,
                ModBlocks.WAXED_COPPER_GRATE,
                ModBlocks.WAXED_EXPOSED_COPPER_GRATE,
                ModBlocks.WAXED_WEATHERED_COPPER_GRATE,
                ModBlocks.WAXED_OXIDIZED_COPPER_GRATE,

                ModBlocks.CHISELED_COPPER,
                ModBlocks.EXPOSED_CHISELED_COPPER,
                ModBlocks.WEATHERED_CHISELED_COPPER,
                ModBlocks.OXIDIZED_CHISELED_COPPER,
                ModBlocks.WAXED_CHISELED_COPPER,
                ModBlocks.WAXED_EXPOSED_CHISELED_COPPER,
                ModBlocks.WAXED_WEATHERED_CHISELED_COPPER,
                ModBlocks.WAXED_OXIDIZED_CHISELED_COPPER,

                ModBlocks.CUT_COPPER,
                ModBlocks.EXPOSED_CUT_COPPER,
                ModBlocks.WEATHERED_CUT_COPPER,
                ModBlocks.OXIDIZED_CUT_COPPER,
                ModBlocks.WAXED_CUT_COPPER,
                ModBlocks.WAXED_EXPOSED_CUT_COPPER,
                ModBlocks.WAXED_WEATHERED_CUT_COPPER,
                ModBlocks.WAXED_OXIDIZED_CUT_COPPER,

                ModBlocks.CUT_COPPER_STAIRS,
                ModBlocks.EXPOSED_CUT_COPPER_STAIRS,
                ModBlocks.WEATHERED_CUT_COPPER_STAIRS,
                ModBlocks.OXIDIZED_CUT_COPPER_STAIRS,
                ModBlocks.WAXED_CUT_COPPER_STAIRS,
                ModBlocks.WAXED_EXPOSED_CUT_COPPER_STAIRS,
                ModBlocks.WAXED_WEATHERED_CUT_COPPER_STAIRS,
                ModBlocks.WAXED_OXIDIZED_CUT_COPPER_STAIRS,

                ModBlocks.CUT_COPPER_SLAB,
                ModBlocks.EXPOSED_CUT_COPPER_SLAB,
                ModBlocks.WEATHERED_CUT_COPPER_SLAB,
                ModBlocks.OXIDIZED_CUT_COPPER_SLAB,
                ModBlocks.WAXED_CUT_COPPER_SLAB,
                ModBlocks.WAXED_EXPOSED_CUT_COPPER_SLAB,
                ModBlocks.WAXED_WEATHERED_CUT_COPPER_SLAB,
                ModBlocks.WAXED_OXIDIZED_CUT_COPPER_SLAB,

                ModBlocks.COPPER_DOOR,
                ModBlocks.EXPOSED_COPPER_DOOR,
                ModBlocks.WEATHERED_COPPER_DOOR,
                ModBlocks.OXIDIZED_COPPER_DOOR,
                ModBlocks.WAXED_COPPER_DOOR,
                ModBlocks.WAXED_EXPOSED_COPPER_DOOR,
                ModBlocks.WAXED_WEATHERED_COPPER_DOOR,
                ModBlocks.WAXED_OXIDIZED_COPPER_DOOR,

                ModBlocks.COPPER_TRAPDOOR,
                ModBlocks.EXPOSED_COPPER_TRAPDOOR,
                ModBlocks.WEATHERED_COPPER_TRAPDOOR,
                ModBlocks.OXIDIZED_COPPER_TRAPDOOR,
                ModBlocks.WAXED_COPPER_TRAPDOOR,
                ModBlocks.WAXED_EXPOSED_COPPER_TRAPDOOR,
                ModBlocks.WAXED_WEATHERED_COPPER_TRAPDOOR,
                ModBlocks.WAXED_OXIDIZED_COPPER_TRAPDOOR,

                ModBlocks.COPPER_BULB,
                ModBlocks.EXPOSED_COPPER_BULB,
                ModBlocks.WEATHERED_COPPER_BULB,
                ModBlocks.OXIDIZED_COPPER_BULB,
                ModBlocks.WAXED_COPPER_BULB,
                ModBlocks.WAXED_EXPOSED_COPPER_BULB,
                ModBlocks.WAXED_WEATHERED_COPPER_BULB,
                ModBlocks.WAXED_OXIDIZED_COPPER_BULB
            );
    }
}
