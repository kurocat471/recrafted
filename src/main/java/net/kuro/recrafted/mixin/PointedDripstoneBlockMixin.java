package net.kuro.recrafted.mixin;

import net.kuro.recrafted.Recrafted;
import net.kuro.recrafted.block.custom.AbstractBarrelBlock;
import net.minecraft.block.AbstractCauldronBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.PointedDripstoneBlock;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

@Mixin(PointedDripstoneBlock.class)
public abstract class PointedDripstoneBlockMixin {

    @Invoker("canDripThrough")
    public static boolean invokeCanDripThrough(BlockView world, BlockPos pos, BlockState state) {
        throw new AssertionError();
    }

    @Invoker("searchInDirection")
    public static Optional<BlockPos> invokeSearchInDirection(WorldAccess world, BlockPos pos, Direction.AxisDirection direction, BiPredicate<BlockPos, BlockState> continuePredicate, Predicate<BlockState> stopPredicate, int range) {
        throw new AssertionError();
    }

    @Inject(method = "getCauldronPos", at = @At("HEAD"), cancellable = true)
    private static void getCauldronOrBarrelPos(World world, BlockPos pos, Fluid fluid, CallbackInfoReturnable<BlockPos> cir) {
        Predicate<BlockState> predicate = state -> {
            if (state.getBlock() instanceof AbstractCauldronBlock) {
                return state.getBlock() instanceof AbstractCauldronBlock && ((AbstractCauldronBlockInvoker) state.getBlock()).invokeCanBeFilledByDripstone(fluid);
            } else if (state.getBlock() instanceof AbstractBarrelBlock) {
                return state.getBlock() instanceof AbstractBarrelBlock && ((AbstractBarrelBlock) state.getBlock()).canBeFilledByDripstone(fluid);
            }
            return false;
        };
        BiPredicate<BlockPos, BlockState> biPredicate = (posx, state) -> invokeCanDripThrough(world, posx, state);
        BlockPos result = invokeSearchInDirection(world, pos, Direction.DOWN.getDirection(), biPredicate, predicate, 11).orElse(null);
        cir.setReturnValue(result);
    }
}
