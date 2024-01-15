package net.kuro.recrafted.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.kuro.recrafted.structure.block.custom.barrel.AbstractBarrelBlock;
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
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

@Mixin(PointedDripstoneBlock.class)
public abstract class PointedDripstoneBlockMixin {

    @ModifyVariable(method = "getCauldronPos", at = @At("STORE"))
    private static Predicate<BlockState> getCauldronOrBarrelPos(Predicate<BlockState> predicate, World world, BlockPos pos, Fluid fluid) {
        return predicate.or(state -> state.getBlock() instanceof AbstractBarrelBlock && ((AbstractBarrelBlock) state.getBlock()).canBeFilledByDripstone(fluid));
    }
}
