package net.kuro.recrafted.mixin;

import net.kuro.recrafted.structure.block.connectedtextures.api.texture.TextureType;
import net.kuro.recrafted.structure.block.connectedtextures.api.util.Pair;
import net.kuro.recrafted.structure.block.connectedtextures.extensions.SpriteContentsExtension;
import net.kuro.recrafted.structure.block.connectedtextures.extensions.TextureAtlasSpriteExtension;
import net.kuro.recrafted.structure.block.connectedtextures.texture.SpriteCreationContextImpl;
import net.kuro.recrafted.structure.block.connectedtextures.texture.TextureTypeRegistryImpl;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.SpriteLoader;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;

@Mixin(value = SpriteLoader.class, priority = 900)
public class SpriteLoaderMixin {

    @Inject(
            method = "load",
            at = @At("RETURN")
    )
    private void initializeTextures(ResourceManager resourceManager, Identifier atlas, int i, Executor executor, CallbackInfoReturnable<CompletableFuture<SpriteLoader.StitchResult>> ci){
        ci.getReturnValue().thenApply(preparations -> {
            // Replace sprites
            Map<Identifier,Sprite> textures = preparations.regions();
            for(Map.Entry<Identifier,Sprite> entry : textures.entrySet()){
                Identifier identifier = entry.getKey();
                Sprite texture = entry.getValue();
                Pair<TextureType<Object>,Object> textureData = ((SpriteContentsExtension)texture.getContents()).recraftedTextureMetadata();
                if(textureData != null){
                    // Create the sprite
                    Sprite newTexture;
                    try(SpriteCreationContextImpl context = new SpriteCreationContextImpl(preparations, atlas, texture)){
                        newTexture = textureData.left().createSprite(context, textureData.right());
                    }catch(Exception e){
                        throw new RuntimeException("Encountered an exception whilst initialising texture '" + identifier + "' for texture type '" + TextureTypeRegistryImpl.getIdentifier(textureData.left()) + "'!", e);
                    }
                    if(newTexture == null)
                        throw new RuntimeException("Received null texture from texture type '" + TextureTypeRegistryImpl.getIdentifier(textureData.left()) + "' for texture '" + identifier + "'!");
                    ((TextureAtlasSpriteExtension)newTexture).setRecraftedTextureType(textureData.left());
                    // Replace the current texture
                    textures.put(identifier, newTexture);
                    ((SpriteContentsExtension)texture.getContents()).clearRecraftedTextureMetadata();
                }
            }
            return preparations;
        });
    }
}
