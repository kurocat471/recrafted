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
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import net.minecraft.resource.InputSupplier;
import net.minecraft.resource.ResourcePack;
import net.minecraft.resource.ResourceType;
import net.minecraft.resource.ZipResourcePack;
import net.minecraft.util.Identifier;

@Mixin(ZipResourcePack.class)
public class FilePackResourcesMixin implements PackResourcesExtension {

    @Final
    @Shadow
    private ZipResourcePack.ZipFileWrapper zipFile;

    @Unique
    private String overridesFolder;

    @Override
    public void setRecraftedOverridesFolder(String folder){
        this.overridesFolder = folder;
    }

    @Shadow
    private String appendOverlayPrefix(String string){
        throw new AssertionError();
    }

    @Inject(
            method = "openFile(Ljava/lang/String;)Lnet/minecraft/resource/InputSupplier;",
            at = @At("HEAD"),
            cancellable = true
    )
    private void getResource(String path, CallbackInfoReturnable<InputSupplier<InputStream>> ci){
        if(this.overridesFolder == null)
            return;

        // Check if the overrides folder contains the requested file
        path = this.overridesFolder + path;
        ZipFile zipFile = this.zipFile.open();
        if(zipFile != null){
            ZipEntry zipEntry = zipFile.getEntry(this.appendOverlayPrefix(path));
            if(zipEntry != null)
                ci.setReturnValue(InputSupplier.create(zipFile, zipEntry));
        }
    }

    @Inject(
            method = "getNamespaces",
            at = @At("RETURN"),
            cancellable = true
    )
    private void getNamespaces(ResourceType type, CallbackInfoReturnable<Set<String>> ci){
        if(this.overridesFolder == null)
            return;

        // Add namespaces from the overrides folder
        ZipFile zipFile = this.zipFile.open();
        if(zipFile == null)
            return;
        Enumeration<? extends ZipEntry> enumeration = zipFile.entries();
        Set<String> namespaces = Sets.newHashSet(ci.getReturnValue());
        String typePath = this.appendOverlayPrefix(this.overridesFolder + type.getDirectory() + "/");
        while(enumeration.hasMoreElements()){
            ArrayList<String> list;
            ZipEntry zipEntry = enumeration.nextElement();
            String name = zipEntry.getName();
            String namespace = ZipResourcePack.getNamespace(typePath, name);
            if(namespace.isEmpty())
                continue;
            if(Identifier.isNamespaceValid(namespace)){
                namespaces.add(namespace);
                continue;
            }
            ZipResourcePack.LOGGER.warn("Non [a-z0-9_.-] character in namespace {} in pack {}, ignoring", namespace, this.zipFile.file);
        }
        ci.setReturnValue(namespaces);
    }

    @ModifyVariable(
            method = "findResources",
            at = @At("HEAD"),
            ordinal = 0
    )
    private ResourcePack.ResultConsumer modifyListResources(ResourcePack.ResultConsumer output, ResourceType type, String namespace, String path){
        if(this.overridesFolder == null)
            return output;

        // First send all override folder entries, then ignore regular entries which were overridden
        ZipFile zipFile = this.zipFile.open();
        if(zipFile == null)
            return output;
        Set<Identifier> overriddenLocations = new HashSet<>();
        Enumeration<? extends ZipEntry> enumeration = zipFile.entries();
        String namespaceDirectory = this.appendOverlayPrefix(this.overridesFolder + type.getDirectory() + "/" + namespace + "/");
        String pathDirectory = namespaceDirectory + path + "/";
        while(enumeration.hasMoreElements()){
            String name;
            ZipEntry zipEntry = enumeration.nextElement();
            if(zipEntry.isDirectory() || !(name = zipEntry.getName()).startsWith(pathDirectory)) continue;
            String identifier = name.substring(namespaceDirectory.length());
            Identifier location = Identifier.of(namespace, identifier);
            if(location != null){
                overriddenLocations.add(location);
                output.accept(location, InputSupplier.create(zipFile, zipEntry));
                continue;
            }
            ZipResourcePack.LOGGER.warn("Invalid path in datapack: {}:{}, ignoring", namespace, identifier);
        }

        // Filter all output resources
        return (location, streamSupplier) -> {
            if(!overriddenLocations.contains(location))
                output.accept(location, streamSupplier);
        };
    }
}
