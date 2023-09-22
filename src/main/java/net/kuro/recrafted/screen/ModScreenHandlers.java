package net.kuro.recrafted.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.kuro.recrafted.Recrafted;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static final ScreenHandlerType<AnvilScreenHandler> ANVIL_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(Recrafted.MOD_ID, "anvil_screen_handler"),
                    new ExtendedScreenHandlerType<>(AnvilScreenHandler::new));


    public static void registerScreenHandler() {
        Recrafted.LOGGER.info("Registering Screen Handlers for " + Recrafted.MOD_ID);
    }
}
