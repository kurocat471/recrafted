package net.kuro.recrafted.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.client.color.block.BlockColors;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Slice;

import java.util.Arrays;

@Mixin(BlockColors.class)
public class BlockColorsMixin {
    @Redirect(
            method = "create",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/color/block/BlockColors;registerColorProvider(Lnet/minecraft/client/color/block/BlockColorProvider;[Lnet/minecraft/block/Block;)V"
            )
    )
    private static void redirectRegisterColorProvider(BlockColors blockColors, BlockColorProvider provider, Block[] blocks) {
        // Create a new array of blocks without Blocks.WATER_CAULDRON
        Block[] newBlocks = Arrays.stream(blocks)
                .filter(block -> block != Blocks.WATER_CAULDRON)
                .toArray(Block[]::new);

        // Call the original method with the modified array
        blockColors.registerColorProvider(provider, newBlocks);
    }
}
