package net.kuro.recrafted.mixin;

import net.kuro.recrafted.structure.block.custom.potioncauldron.PotionCauldronBehavior;
import net.minecraft.block.BlockState;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CauldronBehavior.class)
public interface CauldronBehaviorMixin {
    @Inject(method = "method_32222", at = @At("HEAD"), cancellable = true)
    private static void handleEmptyCauldronAndPotionInteraction(BlockState blockState, World level, BlockPos blockPos, PlayerEntity player, Hand interactionHand, ItemStack itemStack, CallbackInfoReturnable<ActionResult> cir)
    {
        if (PotionUtil.getPotion(itemStack) != Potions.WATER)
        {
            ActionResult result = PotionCauldronBehavior.fillEmptyCauldronWithPotion(blockState, level, blockPos, player, interactionHand, itemStack);
            cir.setReturnValue(result);
        }
    }
}
