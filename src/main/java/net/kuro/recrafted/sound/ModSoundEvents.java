package net.kuro.recrafted.sound;

import net.kuro.recrafted.Recrafted;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
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



    private static final Identifier BLOCK_COPPER_BULB_BREAK_ID = new Identifier(Recrafted.MOD_ID, "block.copper_bulb.break");
    public static final SoundEvent BLOCK_COPPER_BULB_BREAK = registerSoundEvent(BLOCK_COPPER_BULB_BREAK_ID, SoundEvent.of(BLOCK_COPPER_BULB_BREAK_ID));

    private static final Identifier BLOCK_COPPER_BULB_STEP_ID = new Identifier(Recrafted.MOD_ID, "block.copper_bulb.step");
    public static final SoundEvent BLOCK_COPPER_BULB_STEP = registerSoundEvent(BLOCK_COPPER_BULB_STEP_ID, SoundEvent.of(BLOCK_COPPER_BULB_STEP_ID));

    private static final Identifier BLOCK_COPPER_BULB_PLACE_ID = new Identifier(Recrafted.MOD_ID, "block.copper_bulb.place");
    public static final SoundEvent BLOCK_COPPER_BULB_PLACE = registerSoundEvent(BLOCK_COPPER_BULB_PLACE_ID, SoundEvent.of(BLOCK_COPPER_BULB_PLACE_ID));

    private static final Identifier BLOCK_COPPER_BULB_HIT_ID = new Identifier(Recrafted.MOD_ID, "block.copper_bulb.hit");
    public static final SoundEvent BLOCK_COPPER_BULB_HIT = registerSoundEvent(BLOCK_COPPER_BULB_HIT_ID, SoundEvent.of(BLOCK_COPPER_BULB_HIT_ID));

    private static final Identifier BLOCK_COPPER_BULB_FALL_ID = new Identifier(Recrafted.MOD_ID, "block.copper_bulb.fall");
    public static final SoundEvent BLOCK_COPPER_BULB_FALL = registerSoundEvent(BLOCK_COPPER_BULB_FALL_ID, SoundEvent.of(BLOCK_COPPER_BULB_FALL_ID));

    private static final Identifier BLOCK_COPPER_BULB_TURN_ON_ID = new Identifier(Recrafted.MOD_ID, "block.copper_bulb.turn_on");
    public static final SoundEvent BLOCK_COPPER_BULB_TURN_ON = registerSoundEvent(BLOCK_COPPER_BULB_TURN_ON_ID, SoundEvent.of(BLOCK_COPPER_BULB_TURN_ON_ID));

    private static final Identifier BLOCK_COPPER_BULB_TURN_OFF_ID = new Identifier(Recrafted.MOD_ID, "block.copper_bulb.turn_off");
    public static final SoundEvent BLOCK_COPPER_BULB_TURN_OFF = registerSoundEvent(BLOCK_COPPER_BULB_TURN_OFF_ID, SoundEvent.of(BLOCK_COPPER_BULB_TURN_OFF_ID));

    private static final Identifier BLOCK_COPPER_DOOR_CLOSE_ID = new Identifier(Recrafted.MOD_ID, "block.copper_door.close");
    public static final SoundEvent BLOCK_COPPER_DOOR_CLOSE = registerSoundEvent(BLOCK_COPPER_DOOR_CLOSE_ID, SoundEvent.of(BLOCK_COPPER_DOOR_CLOSE_ID));

    private static final Identifier BLOCK_COPPER_DOOR_OPEN_ID = new Identifier(Recrafted.MOD_ID, "block.copper_door.open");
    public static final SoundEvent BLOCK_COPPER_DOOR_OPEN = registerSoundEvent(BLOCK_COPPER_DOOR_OPEN_ID, SoundEvent.of(BLOCK_COPPER_DOOR_OPEN_ID));

    private static final Identifier BLOCK_COPPER_GRATE_BREAK_ID = new Identifier(Recrafted.MOD_ID, "block.copper_grate.break");
    public static final SoundEvent BLOCK_COPPER_GRATE_BREAK = registerSoundEvent(BLOCK_COPPER_GRATE_BREAK_ID, SoundEvent.of(BLOCK_COPPER_GRATE_BREAK_ID));

    private static final Identifier BLOCK_COPPER_GRATE_STEP_ID = new Identifier(Recrafted.MOD_ID, "block.copper_grate.step");
    public static final SoundEvent BLOCK_COPPER_GRATE_STEP = registerSoundEvent(BLOCK_COPPER_GRATE_STEP_ID, SoundEvent.of(BLOCK_COPPER_GRATE_STEP_ID));

    private static final Identifier BLOCK_COPPER_GRATE_PLACE_ID = new Identifier(Recrafted.MOD_ID, "block.copper_grate.place");
    public static final SoundEvent BLOCK_COPPER_GRATE_PLACE = registerSoundEvent(BLOCK_COPPER_GRATE_PLACE_ID, SoundEvent.of(BLOCK_COPPER_GRATE_PLACE_ID));

    private static final Identifier BLOCK_COPPER_GRATE_HIT_ID = new Identifier(Recrafted.MOD_ID, "block.copper_grate.hit");
    public static final SoundEvent BLOCK_COPPER_GRATE_HIT = registerSoundEvent(BLOCK_COPPER_GRATE_HIT_ID, SoundEvent.of(BLOCK_COPPER_GRATE_HIT_ID));

    private static final Identifier BLOCK_COPPER_GRATE_FALL_ID = new Identifier(Recrafted.MOD_ID, "block.copper_grate.fall");
    public static final SoundEvent BLOCK_COPPER_GRATE_FALL = registerSoundEvent(BLOCK_COPPER_GRATE_FALL_ID, SoundEvent.of(BLOCK_COPPER_GRATE_FALL_ID));

    private static final Identifier BLOCK_COPPER_TRAPDOOR_CLOSE_ID = new Identifier(Recrafted.MOD_ID, "block.copper_trapdoor.close");
    public static final SoundEvent BLOCK_COPPER_TRAPDOOR_CLOSE = registerSoundEvent(BLOCK_COPPER_TRAPDOOR_CLOSE_ID, SoundEvent.of(BLOCK_COPPER_TRAPDOOR_CLOSE_ID));

    private static final Identifier BLOCK_COPPER_TRAPDOOR_OPEN_ID = new Identifier(Recrafted.MOD_ID, "block.copper_trapdoor.open");
    public static final SoundEvent BLOCK_COPPER_TRAPDOOR_OPEN = registerSoundEvent(BLOCK_COPPER_TRAPDOOR_OPEN_ID, SoundEvent.of(BLOCK_COPPER_TRAPDOOR_OPEN_ID));






    private static SoundEvent registerSoundEvent(Identifier id, SoundEvent soundEvent) {
        return Registry.register(Registries.SOUND_EVENT, id, soundEvent);
    }

    public static void registerModSoundEvents() {
        Recrafted.LOGGER.info("Registering Mod Sound Events for " + Recrafted.MOD_ID);
    }
}
