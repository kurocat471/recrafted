package net.kuro.recrafted.mixin;

import net.kuro.recrafted.Recrafted;
import net.kuro.recrafted.structure.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LightningRodBlock;
import net.minecraft.block.Oxidizable;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(LightningEntity.class)
public abstract class LightningEntityMixin {
    public LightningEntityMixin(EntityType<? extends LightningEntity> type, World world) {
        super();
    }

    @Inject(at = @At("HEAD"), method = "powerLightningRod")
    public void powerLightningRod(CallbackInfo ci) {
        BlockPos blockPos = this.getAffectedBlockPos();
        BlockState blockState = ((LightningEntity)((Object)this)).getWorld().getBlockState(blockPos);
        if (blockState.isOf(Recrafted.COPPER_LIGHTNING_ROD) ||
                blockState.isOf(Recrafted.EXPOSED_COPPER_LIGHTNING_ROD) ||
                blockState.isOf(Recrafted.WEATHERED_COPPER_LIGHTNING_ROD) ||
                blockState.isOf(Recrafted.OXIDIZED_COPPER_LIGHTNING_ROD) ||
                blockState.isOf(Recrafted.WAXED_COPPER_LIGHTNING_ROD) ||
                blockState.isOf(Recrafted.WAXED_EXPOSED_COPPER_LIGHTNING_ROD) ||
                blockState.isOf(Recrafted.WAXED_WEATHERED_COPPER_LIGHTNING_ROD) ||
                blockState.isOf(Recrafted.WAXED_OXIDIZED_COPPER_LIGHTNING_ROD)) {
            ((LightningRodBlock)blockState.getBlock()).setPowered(blockState, ((LightningEntity)((Object)this)).getWorld(), blockPos);
        }

    }

    private BlockPos getAffectedBlockPos() {
        Vec3d vec3d = ((LightningEntity)((Object)this)).getPos();
        return BlockPos.ofFloored(vec3d.x, vec3d.y - 1.0E-6, vec3d.z);
    }

}
