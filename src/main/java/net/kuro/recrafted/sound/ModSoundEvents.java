package net.kuro.recrafted.sound;

import net.kuro.recrafted.Recrafted;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSoundEvents {

    private static final Identifier POTION_EVAPORATES_ID = new Identifier(Recrafted.MOD_ID, "potion_evaporates");
    public static final SoundEvent POTION_EVAPORATES = registerSoundEvent(POTION_EVAPORATES_ID, SoundEvent.of(POTION_EVAPORATES_ID));

    private static final Identifier PATINA_CRUMBLES_ID = new Identifier(Recrafted.MOD_ID, "patina_crumbles");
    public static final SoundEvent PATINA_CRUMBLES = registerSoundEvent(PATINA_CRUMBLES_ID, SoundEvent.of(PATINA_CRUMBLES_ID));

    private static final Identifier ITEM_COOLS_ID = new Identifier(Recrafted.MOD_ID, "item_cools");
    public static final SoundEvent ITEM_COOLS = registerSoundEvent(ITEM_COOLS_ID, SoundEvent.of(ITEM_COOLS_ID));

    private static final Identifier HAMMER_CLANGS_ID = new Identifier(Recrafted.MOD_ID, "hammer_clangs");
    public static final SoundEvent HAMMER_CLANGS = registerSoundEvent(HAMMER_CLANGS_ID, SoundEvent.of(HAMMER_CLANGS_ID));

    private static final Identifier HAMMER_WORKS_ID = new Identifier(Recrafted.MOD_ID, "hammer_works");
    public static final SoundEvent HAMMER_WORKS = registerSoundEvent(HAMMER_WORKS_ID, SoundEvent.of(HAMMER_WORKS_ID));

    private static SoundEvent registerSoundEvent(Identifier id, SoundEvent soundEvent) {
        return Registry.register(Registries.SOUND_EVENT, id, soundEvent);
    }

    public static void registerModSoundEvents() {
        Recrafted.LOGGER.info("Registering Mod Sound Events for " + Recrafted.MOD_ID);
    }
}
