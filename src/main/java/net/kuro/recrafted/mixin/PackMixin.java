package net.kuro.recrafted.mixin;

import net.kuro.recrafted.Recrafted;
import net.kuro.recrafted.structure.block.connectedtextures.extensions.PackResourcesExtension;
import net.kuro.recrafted.structure.block.connectedtextures.resources.RecraftedPackMetadataSection;
import net.minecraft.resource.ResourcePack;
import net.minecraft.resource.ResourcePackProfile;
import net.minecraft.resource.ResourcePackSource;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ResourcePackProfile.class)
public class PackMixin {

    @Unique
    private String overridesFolder;

    @Inject(
            method = "<init>",
            at = @At("RETURN")
    )
    private void init(String identifier, boolean required, ResourcePackProfile.PackFactory resourcesSupplier, Text title, ResourcePackProfile.Metadata info, ResourcePackProfile.InsertionPosition position, boolean fixedPosition, ResourcePackSource packSource, CallbackInfo ci){
        try(ResourcePack resources = resourcesSupplier.open(identifier)){
            this.overridesFolder = resources.parseMetadata(RecraftedPackMetadataSection.INSTANCE);
        }catch(Exception e){
            Recrafted.LOGGER.error("Encountered an exception whilst reading mod metadata for pack '" + identifier + "':", e);
        }
    }

    @Inject(
            method = "createResourcePack",
            at = @At("RETURN")
    )
    private void open(CallbackInfoReturnable<ResourcePack> ci){
        ResourcePack resources = ci.getReturnValue();
        if(this.overridesFolder != null && resources instanceof PackResourcesExtension)
            ((PackResourcesExtension)resources).setRecraftedOverridesFolder(this.overridesFolder);
    }
}
