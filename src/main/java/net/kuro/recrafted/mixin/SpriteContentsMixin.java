package net.kuro.recrafted.mixin;

import net.kuro.recrafted.structure.block.connectedtextures.api.texture.TextureType;
import net.kuro.recrafted.structure.block.connectedtextures.api.util.Pair;
import net.kuro.recrafted.structure.block.connectedtextures.extensions.SpriteContentsExtension;
import net.kuro.recrafted.structure.block.connectedtextures.texture.RecraftedTextureMetadataSection;
import net.kuro.recrafted.structure.block.connectedtextures.texture.SpritePreparationContextImpl;
import net.kuro.recrafted.structure.block.connectedtextures.texture.TextureTypeRegistryImpl;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.SpriteContents;
import net.minecraft.client.texture.SpriteDimensions;
import net.minecraft.resource.metadata.ResourceMetadata;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(SpriteContents.class)
public class SpriteContentsMixin implements SpriteContentsExtension {

    @Unique
    private Pair<TextureType<Object>,Object> recraftedTextureMetadata;

    @Override
    public Pair<TextureType<Object>,Object> recraftedTextureMetadata(){
        return this.recraftedTextureMetadata;
    }

    @Override
    public void clearRecraftedTextureMetadata(){
        this.recraftedTextureMetadata = null;
    }

    @ModifyVariable(
            method = "<init>",
            at = @At(
                    value = "INVOKE",
                    target = "Ljava/lang/Object;<init>()V",
                    shift = At.Shift.AFTER
            ),
            ordinal = 0
    )
    private SpriteDimensions initMetadata(SpriteDimensions originalSize, Identifier identifier, SpriteDimensions ignore, NativeImage image, ResourceMetadata resourceMetadata){
        // Get the recrafted metadata
        Pair<TextureType<Object>,Object> metadata = resourceMetadata.decode(RecraftedTextureMetadataSection.INSTANCE).orElse(null);
        if(metadata != null){
            this.recraftedTextureMetadata = metadata;
            // Adjust the frame size
            Pair<Integer,Integer> newSize;
            try{
                newSize = metadata.left().getFrameSize(new SpritePreparationContextImpl(originalSize.width(), originalSize.height(), image.getWidth(), image.getHeight(), identifier), metadata.right());
            }catch(Exception e){
                throw new RuntimeException("Encountered an exception whilst getting frame size from texture type '" + TextureTypeRegistryImpl.getIdentifier(metadata.left()) + "' for texture '" + identifier + "'!", e);
            }
            if(newSize == null)
                throw new RuntimeException("Received null frame size from texture type '" + TextureTypeRegistryImpl.getIdentifier(metadata.left()) + "' for texture '" + identifier + "'!");
            // Replace the current size
            return new SpriteDimensions(newSize.left(), newSize.right());
        }
        return originalSize;
    }
}
