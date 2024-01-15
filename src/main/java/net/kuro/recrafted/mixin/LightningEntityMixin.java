package net.kuro.recrafted.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.kuro.recrafted.Recrafted;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LightningEntity.class)
public abstract class LightningEntityMixin {
    @Shadow protected abstract BlockPos getAffectedBlockPos();

    public LightningEntityMixin(EntityType<? extends LightningEntity> type, World world) {
        super();
    }


    @Inject(at = @At("HEAD"), method = "powerLightningRod")
    public void powerLightningRod(CallbackInfo ci) {
        BlockPos blockPos = getAffectedBlockPos();
        BlockState blockState = ((LightningEntity)((Object)this)).getWorld().getBlockState(blockPos);
        Block block = blockState.getBlock();
        if (block instanceof LightningRodBlock && !blockState.isOf(Blocks.LIGHTNING_ROD)) {
            ((LightningRodBlock)blockState.getBlock()).setPowered(blockState, ((LightningEntity)((Object)this)).getWorld(), blockPos);
        }
    }

    @WrapOperation(
            method = "cleanOxidation",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z")
    )
    private static boolean lightningRodCheck(BlockState state, Block block, Operation<Boolean> original) {
        if ((original.call(state, block)) || (state.getBlock() instanceof LightningRodBlock)) {
            return true;
        } else {
            return original.call(state, block);
        }
    }

    @Inject(
            method = "cleanOxidation",
            at = @At(value = "TAIL")
    )
    private static void rePowerLightningRods(World world, BlockPos pos, CallbackInfo ci) {
        BlockState blockState = world.getBlockState(pos);
        Block block = blockState.getBlock();
        if (block instanceof LightningRodBlock) {
            ((LightningRodBlock)blockState.getBlock()).setPowered(blockState, world, pos);
        }
    }

    @Inject(
            method = "cleanOxidation",
            at = @At(value = "HEAD")
    )
    private static void cleanOxidizableLightningRods(World world, BlockPos pos, CallbackInfo ci) {
        BlockState blockState2;
        BlockPos blockPos;
        BlockState blockState = world.getBlockState(pos);
        Block block = blockState.getBlock();
        if (block instanceof LightningRodBlock && block instanceof Oxidizable) {
            blockPos = pos.offset(blockState.get(LightningRodBlock.FACING).getOpposite());
            blockState2 = world.getBlockState(blockPos);
            if ((blockState2.getBlock() instanceof Oxidizable)) {
                return;
            }
            int i = world.random.nextInt(2) + 2;
            if (world.random.nextDouble() > 0.5) {
                i = i - 1;
            }
            BlockState newState = blockState;
            for (int j = 0; j < i; ++j) {
                Oxidizable.getDecreasedOxidationState(newState).ifPresent(state -> world.setBlockState(pos, (BlockState) state));
                world.syncWorldEvent(WorldEvents.ELECTRICITY_SPARKS, pos, -1);
                newState = world.getBlockState(pos);
                ((LightningRodBlock) newState.getBlock()).setPowered(newState, world, pos);
                int r = world.random.nextInt(2);
            }
        }
    }

}
