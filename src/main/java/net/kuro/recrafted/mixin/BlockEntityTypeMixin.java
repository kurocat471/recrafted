package net.kuro.recrafted.mixin;

import net.kuro.recrafted.Recrafted;
import net.kuro.recrafted.structure.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Slice;

import java.util.Arrays;

@Mixin(BlockEntityType.class)
public class BlockEntityTypeMixin {
    @ModifyArg(
            method = "<clinit>",
            slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=campfire")),
            at = @At(value = "INVOKE", target = "Lnet/minecraft/block/entity/BlockEntityType$Builder;create(Lnet/minecraft/block/entity/BlockEntityType$BlockEntityFactory;[Lnet/minecraft/block/Block;)Lnet/minecraft/block/entity/BlockEntityType$Builder;", ordinal = 0)
    )
    private static Block[] addCampfireBlocks(Block[] original) {
        Block[] campfireBlocks = ModBlocks.CAMPFIRE_BLOCKS;
        Block[] newBlocks = Arrays.copyOf(original, original.length + campfireBlocks.length);
        for (int i = 0; i < campfireBlocks.length; i++) {
            newBlocks[i + original.length] = campfireBlocks[i];
        };
        return newBlocks;
    }
}
