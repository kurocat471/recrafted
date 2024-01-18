package net.kuro.recrafted.util;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.kuro.recrafted.Recrafted;
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
                ModBlocks.WAXED_OXIDIZED_COPPER_GRATE,
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
                ModBlocks.RESISTOR,
                ModBlocks.EXPOSED_RESISTOR,
                ModBlocks.WEATHERED_RESISTOR,
                ModBlocks.OXIDIZED_RESISTOR,
                ModBlocks.WAXED_RESISTOR,
                ModBlocks.WAXED_EXPOSED_RESISTOR,
                ModBlocks.WAXED_WEATHERED_RESISTOR,
                ModBlocks.WAXED_OXIDIZED_RESISTOR,
                ModBlocks.PATINA_FIRE,
                ModBlocks.PATINA_TORCH,
                ModBlocks.PATINA_WALL_TORCH,
                Recrafted.PATINA_CAMPFIRE,
                ModBlocks.PATINA_LANTERN
        );
    }
}
