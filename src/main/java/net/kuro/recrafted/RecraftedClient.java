package net.kuro.recrafted;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.kuro.recrafted.block.ModBlocks;
import net.kuro.recrafted.block.entity.ModBlockEntities;
import net.kuro.recrafted.block.entity.renderer.AnvilBlockEntityRenderer;
import net.kuro.recrafted.block.entity.renderer.PotionCauldronBlockEntityRenderer;
import net.kuro.recrafted.networking.ClientNetworking;
import net.kuro.recrafted.networking.ModMessages;
import net.kuro.recrafted.screen.AnvilScreen;
import net.kuro.recrafted.screen.ModScreenHandlers;
import net.minecraft.block.Blocks;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class RecraftedClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlers.ANVIL_SCREEN_HANDLER, AnvilScreen::new);
        ModMessages.registerS2CPackets();
        BlockEntityRendererFactories.register(ModBlockEntities.ANVIL_BE, AnvilBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.POTION_CAULDRON_BE, PotionCauldronBlockEntityRenderer::new);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SPRUCE_WATER_BARREL, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.WATER_CAULDRON, RenderLayer.getTranslucent());

        ClientNetworking.registerEvents();

        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
            if (world == null || pos == null) {
                return -1;
            }
            return BiomeColors.getWaterColor(world, pos);
        }, ModBlocks.SPRUCE_WATER_BARREL);
    }
}
