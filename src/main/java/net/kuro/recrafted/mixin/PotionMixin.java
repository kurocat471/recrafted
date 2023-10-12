package net.kuro.recrafted.mixin;

import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Potion.class)
public class PotionMixin {
    @Inject(method = "finishTranslationKey", at = @At("HEAD"), cancellable = true)
    public void finishTranslationKey(String prefix, CallbackInfoReturnable<String> cir) {
        String result = prefix + Registries.POTION.getId((Potion) (Object) this).getPath();
        cir.setReturnValue(result);
    }
}
