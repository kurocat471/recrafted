package net.kuro.recrafted;

import net.fabricmc.api.ClientModInitializer;
import net.kuro.recrafted.block.entity.ModBlockEntities;
import net.kuro.recrafted.block.entity.renderer.AnvilBlockEntityRenderer;
import net.kuro.recrafted.networking.ModMessages;
import net.kuro.recrafted.screen.AnvilScreen;
import net.kuro.recrafted.screen.ModScreenHandlers;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class RecraftedClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlers.ANVIL_SCREEN_HANDLER, AnvilScreen::new);

        ModMessages.registerS2CPackets();

        BlockEntityRendererFactories.register(ModBlockEntities.ANVIL_BE, AnvilBlockEntityRenderer::new);
    }
}
