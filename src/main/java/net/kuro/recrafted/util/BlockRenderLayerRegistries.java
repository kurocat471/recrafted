package net.kuro.recrafted.util;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.kuro.recrafted.structure.block.ModBlocks;
import net.minecraft.client.render.RenderLayer;

public class BlockRenderLayerRegistries {
    public static void registerBlockRenderLayers() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
                ModBlocks.COPPER_GRATE,
                ModBlocks.EXPOSED_COPPER_GRATE,
                ModBlocks.WEATHERED_COPPER_GRATE,
                ModBlocks.OXIDIZED_COPPER_GRATE,
                ModBlocks.WAXED_COPPER_GRATE,
                ModBlocks.WAXED_EXPOSED_COPPER_GRATE,
                ModBlocks.WAXED_WEATHERED_COPPER_GRATE,
                ModBlocks.WAXED_OXIDIZED_COPPER_GRATE
        );
    }
}
