package net.kuro.recrafted.mixin;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import net.kuro.recrafted.Recrafted;
import net.kuro.recrafted.structure.block.ModBlocks;
import net.kuro.recrafted.structure.item.ModItemGroups;
import net.kuro.recrafted.util.ModRegistries;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.poi.PointOfInterestType;
import net.minecraft.world.poi.PointOfInterestTypes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Set;

@Mixin(PointOfInterestTypes.class)
public class PointOfInterestTypesMixin {
    public PointOfInterestTypesMixin() {
    }

    @Invoker("register")
    public static PointOfInterestType invokeRegister(Registry<PointOfInterestType> registry, RegistryKey<PointOfInterestType> key, Set<BlockState> states, int ticketCount, int searchDistance) {
        throw new AssertionError();
    }

    @Redirect(
            method = {"registerAndGetDefault"},
            at = @At(
                    value = "INVOKE",
                    ordinal = 19,
                    target = "Lnet/minecraft/world/poi/PointOfInterestTypes;register(Lnet/minecraft/registry/Registry;Lnet/minecraft/registry/RegistryKey;Ljava/util/Set;II)Lnet/minecraft/world/poi/PointOfInterestType;"
            )
    )
    private static PointOfInterestType overrideLightningRods(Registry<PointOfInterestType> registry, RegistryKey<PointOfInterestType> key, Set<BlockState> states, int ticketCount, int searchDistance) {
        return invokeRegister(registry, key, ModBlocks.LIGHTNING_RODS, ticketCount, searchDistance);
    }
}
