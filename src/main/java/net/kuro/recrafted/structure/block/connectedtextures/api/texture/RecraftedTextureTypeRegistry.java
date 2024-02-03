package net.kuro.recrafted.structure.block.connectedtextures.api.texture;

import com.google.gson.JsonObject;
import net.kuro.recrafted.structure.block.connectedtextures.texture.TextureTypeRegistryImpl;
import net.minecraft.util.Identifier;

public final class RecraftedTextureTypeRegistry {

    /**
     * Registers the given texture type.
     * @param identifier  identifier for the texture type
     * @param textureType handler for custom texture data and creating the sprite
     */
    public static void registerTextureType(Identifier identifier, TextureType<?> textureType){
        TextureTypeRegistryImpl.registerTextureType(identifier, textureType);
    }

    /**
     * Serializes the given texture data.
     * @param textureType type of the texture
     * @param textureData texture data to serialize
     */
    public static <T> JsonObject serializeTextureData(TextureType<T> textureType, T textureData){
        return TextureTypeRegistryImpl.serializeTextureData(textureType, textureData);
    }
}
