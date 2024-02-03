package net.kuro.recrafted.mixin;

import com.google.common.collect.Sets;
import net.kuro.recrafted.structure.block.connectedtextures.extensions.PackResourcesExtension;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;
import net.minecraft.resource.DirectoryResourcePack;
import net.minecraft.resource.InputSupplier;
import net.minecraft.resource.ResourcePack;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;
import net.minecraft.util.PathUtil;

@Mixin(DirectoryResourcePack.class)
public class PathPackResourcesMixin implements PackResourcesExtension {

    @Final
    @Shadow
    private Path root;
    @Unique
    private Path overridesFolderRoot;

    @Override
    public void setRecraftedOverridesFolder(String folder){
        this.overridesFolderRoot = this.root.resolve(folder);
    }

    @Inject(
            method = "open(Lnet/minecraft/resource/ResourceType;Lnet/minecraft/util/Identifier;)Lnet/minecraft/resource/InputSupplier;",
            at = @At("HEAD"),
            cancellable = true
    )
    private void getResource(ResourceType type, Identifier location, CallbackInfoReturnable<InputSupplier<InputStream>> ci){
        if(this.overridesFolderRoot == null)
            return;

        // Check if the overrides folder contains the requested file
        Path namespaceFolder = this.overridesFolderRoot.resolve(type.getDirectory()).resolve(location.getNamespace());
        InputSupplier<InputStream> supplier = PathUtil.split(location.getPath()).get().map(list -> {
            Path path = PathUtil.getPath(namespaceFolder, list);
            return DirectoryResourcePack.open(path);
        }, o -> null);
        if(supplier != null)
            ci.setReturnValue(supplier);
    }

    @Inject(
            method = "getNamespaces",
            at = @At("RETURN"),
            cancellable = true
    )
    private void getNamespaces(ResourceType type, CallbackInfoReturnable<Set<String>> ci){
        if(this.overridesFolderRoot == null)
            return;

        // Add namespaces from the overrides folder
        HashSet<String> namespaces = Sets.newHashSet(ci.getReturnValue());
        Path typeFolder = this.overridesFolderRoot.resolve(type.getDirectory());
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(typeFolder)){
            for(Path directory : stream){
                String location = directory.getFileName().toString();
                if(Identifier.isNamespaceValid(location)){
                    namespaces.add(location);
                    continue;
                }
                DirectoryResourcePack.LOGGER.warn("Ignored non-lowercase namespace: {} in {}", location, this.root);
            }
        }catch(NoSuchFileException ignored){
        }catch(IOException e){
            DirectoryResourcePack.LOGGER.error("Failed to list path {}", typeFolder, e);
        }
        ci.setReturnValue(namespaces);
    }

    @ModifyVariable(
            method = "findResources(Lnet/minecraft/resource/ResourceType;Ljava/lang/String;Ljava/lang/String;Lnet/minecraft/resource/ResourcePack$ResultConsumer;)V",
            at = @At("HEAD"),
            ordinal = 0
    )
    private ResourcePack.ResultConsumer modifyListResources(ResourcePack.ResultConsumer output, ResourceType type, String namespace, String path){
        if(this.overridesFolderRoot == null)
            return output;

        // First send all override folder entries, then ignore regular entries which were overridden
        Set<Identifier> overriddenLocations = new HashSet<>();
        PathUtil.split(path).get().ifLeft(list -> {
            Path namespaceFolder = this.overridesFolderRoot.resolve(type.getDirectory()).resolve(namespace);
            DirectoryResourcePack.findResources(namespace, namespaceFolder, list, (location, streamSupplier) -> {
                overriddenLocations.add(location);
                output.accept(location, streamSupplier);
            });
        }).ifRight(partialResult -> DirectoryResourcePack.LOGGER.error("Invalid path {}: {}", path, partialResult.message()));

        // Filter all output resources
        return (location, streamSupplier) -> {
            if(!overriddenLocations.contains(location))
                output.accept(location, streamSupplier);
        };
    }
}
