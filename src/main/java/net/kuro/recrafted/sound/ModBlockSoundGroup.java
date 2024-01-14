package net.kuro.recrafted.sound;

import net.minecraft.sound.BlockSoundGroup;

public class ModBlockSoundGroup {

    public static final BlockSoundGroup COPPER_BULB = new BlockSoundGroup(1f, 1f,
            ModSoundEvents.BLOCK_COPPER_BULB_BREAK, ModSoundEvents.BLOCK_COPPER_BULB_STEP,
            ModSoundEvents.BLOCK_COPPER_BULB_PLACE, ModSoundEvents.BLOCK_COPPER_BULB_HIT,
            ModSoundEvents.BLOCK_COPPER_BULB_FALL);

    public static final BlockSoundGroup COPPER_GRATE = new BlockSoundGroup(1f, 1f,
            ModSoundEvents.BLOCK_COPPER_GRATE_BREAK, ModSoundEvents.BLOCK_COPPER_GRATE_STEP,
            ModSoundEvents.BLOCK_COPPER_GRATE_PLACE, ModSoundEvents.BLOCK_COPPER_GRATE_HIT,
            ModSoundEvents.BLOCK_COPPER_GRATE_FALL);

}
