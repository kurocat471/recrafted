package net.kuro.recrafted.sound;

import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import net.minecraft.block.BlockSetType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;

import java.util.Set;
import java.util.stream.Stream;

public class ModBlockSetType {
    private static final Set<BlockSetType> VALUES = new ObjectArraySet<BlockSetType>();

    public static final BlockSetType COPPER = ModBlockSetType.register(new BlockSetType("copper", true, BlockSoundGroup.COPPER, ModSoundEvents.BLOCK_COPPER_DOOR_CLOSE, ModSoundEvents.BLOCK_COPPER_DOOR_OPEN, ModSoundEvents.BLOCK_COPPER_TRAPDOOR_CLOSE, ModSoundEvents.BLOCK_COPPER_TRAPDOOR_OPEN, SoundEvents.BLOCK_METAL_PRESSURE_PLATE_CLICK_OFF, SoundEvents.BLOCK_METAL_PRESSURE_PLATE_CLICK_ON, SoundEvents.BLOCK_STONE_BUTTON_CLICK_OFF, SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON));

    private static BlockSetType register(BlockSetType blockSetType) {
        VALUES.add(blockSetType);
        return blockSetType;
    }

    public static Stream<BlockSetType> stream() {
        return VALUES.stream();
    }
}
