package net.kuro.recrafted;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.kuro.recrafted.structure.block.entity.ModBlockEntities;
import net.kuro.recrafted.structure.block.entity.renderer.AnvilBlockEntityRenderer;
import net.kuro.recrafted.structure.block.entity.renderer.PotionCauldronBlockEntityRenderer;
import net.kuro.recrafted.structure.block.entity.renderer.WaterBarrelBlockEntityRenderer;
import net.kuro.recrafted.structure.block.entity.renderer.WaterCauldronBlockEntityRenderer;
import net.kuro.recrafted.networking.ClientNetworking;
import net.kuro.recrafted.networking.ModMessages;
import net.kuro.recrafted.structure.particle.ModParticleTypes;
import net.kuro.recrafted.structure.screen.AnvilScreen;
import net.kuro.recrafted.structure.screen.ModScreenHandlers;
import net.kuro.recrafted.util.BlockRenderLayerRegistries;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.block.entity.CampfireBlockEntityRenderer;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;

public class RecraftedClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlers.ANVIL_SCREEN_HANDLER, AnvilScreen::new);
        BlockEntityRendererFactories.register(ModBlockEntities.ANVIL_BE, AnvilBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.POTION_CAULDRON_BE, PotionCauldronBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.WATER_CAULDRON_BE, WaterCauldronBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.WATER_BARREL_BE, WaterBarrelBlockEntityRenderer::new);
        BlockRenderLayerRegistries.registerBlockRenderLayers();
        ModMessages.registerS2CPackets();
        ClientNetworking.registerEvents();
        ModParticleTypes.registerParticleTypesClientSide();
    }
}
