package net.kuro.recrafted.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.fabric.impl.datagen.FabricDataGenHelper;
import net.fabricmc.loader.api.FabricLoader;
import net.kuro.recrafted.structure.block.connectedtextures.model.ModelTypeRegistryImpl;
import net.kuro.recrafted.structure.block.connectedtextures.predicate.PredicateRegistryImpl;
import net.kuro.recrafted.structure.block.connectedtextures.texture.TextureTypeRegistryImpl;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SuppressWarnings("UnstableApiUsage")
@Mixin(FabricDataGenHelper.class)
public class FabricDataGenHelperMixin {

    @Inject(
            method = "run()V",
            at = @At("HEAD"),
            remap = false
    )
    private static void run(CallbackInfo ci){
        if(FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT){
            TextureTypeRegistryImpl.finalizeRegistration();
            ModelTypeRegistryImpl.finalizeRegistration();
            PredicateRegistryImpl.finalizeRegistration();
        }
    }
}
