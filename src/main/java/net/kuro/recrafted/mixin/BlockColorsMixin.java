package net.kuro.recrafted.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.client.color.block.BlockColors;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Arrays;

@Mixin(BlockColors.class)
public class BlockColorsMixin {
    @ModifyArg(
            method = "create",
            index = 1,
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/color/block/BlockColors;registerColorProvider(Lnet/minecraft/client/color/block/BlockColorProvider;[Lnet/minecraft/block/Block;)V"
            )
    )
    private static Block[] modifyRegisterColorProviderArgs(Block[] blocks) {
        // Your modification logic here
        Block[] newBlocks = Arrays.stream(blocks)
                .filter(block -> block != Blocks.WATER_CAULDRON)
                .toArray(Block[]::new);

        return newBlocks;
    }
}
