package net.kuro.recrafted.mixin;

import net.kuro.recrafted.structure.block.ModBlocks;
import net.kuro.recrafted.structure.block.custom.patinafire.PatinaFireBlock;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractFireBlock.class)
public class AbstractFireBlockMixin {
    @Inject(method = "getState", at = @At(value = "RETURN"), cancellable = true)
    private static void getStateForPatinaFire(BlockView world, BlockPos pos, CallbackInfoReturnable<BlockState> cir) {
        BlockPos blockPos = pos.down();
        BlockState blockState = world.getBlockState(blockPos);
        if (PatinaFireBlock.isPatinaBase(blockState)) {
            cir.setReturnValue(ModBlocks.PATINA_FIRE.getDefaultState());
        }
    }
}
