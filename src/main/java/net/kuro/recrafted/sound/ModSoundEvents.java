package net.kuro.recrafted.sound;

import net.kuro.recrafted.Recrafted;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSoundEvents {

    private static final Identifier POTION_EVAPORATES_ID = new Identifier(Recrafted.MOD_ID, "potion_evaporates");
    public static final SoundEvent POTION_EVAPORATES = registerSoundEvent(POTION_EVAPORATES_ID, SoundEvent.of(POTION_EVAPORATES_ID));

    private static SoundEvent registerSoundEvent(Identifier id, SoundEvent soundEvent) {
        return Registry.register(Registries.SOUND_EVENT, id, soundEvent);
    }

    public static void registerModSoundEvents() {
        Recrafted.LOGGER.info("Registering Mod Sound Events for " + Recrafted.MOD_ID);
    }
}
