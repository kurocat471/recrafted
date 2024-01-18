package net.kuro.recrafted.mixin;

import net.kuro.recrafted.Recrafted;
import net.kuro.recrafted.structure.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.poi.PointOfInterestType;
import net.minecraft.world.poi.PointOfInterestTypes;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Slice;

import java.util.Set;

@Mixin(PointOfInterestTypes.class)
public abstract class PointOfInterestTypesMixin {

    @ModifyArg(
            method = {"registerAndGetDefault"},
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/poi/PointOfInterestTypes;register(Lnet/minecraft/registry/Registry;Lnet/minecraft/registry/RegistryKey;Ljava/util/Set;II)Lnet/minecraft/world/poi/PointOfInterestType;"
            ),
            slice = @Slice(
                    from = @At(
                            value = "FIELD",
                            target = "Lnet/minecraft/world/poi/PointOfInterestTypes;LIGHTNING_ROD:Lnet/minecraft/registry/RegistryKey;"
                    )
            ),
            index = 2
    )
    private static Set<BlockState> addLightningRods(Set<BlockState> states) {
        return ModBlocks.LIGHTNING_RODS;
    }
}
