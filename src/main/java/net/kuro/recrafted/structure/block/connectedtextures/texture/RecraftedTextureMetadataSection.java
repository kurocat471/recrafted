package net.kuro.recrafted.structure.block.connectedtextures.texture;

import com.google.gson.JsonObject;
import net.kuro.recrafted.structure.block.connectedtextures.api.texture.TextureType;
import net.kuro.recrafted.structure.block.connectedtextures.api.util.Pair;
import net.minecraft.resource.metadata.ResourceMetadataReader;

public class RecraftedTextureMetadataSection implements ResourceMetadataReader<Pair<TextureType<Object>,Object>> {

    public static final RecraftedTextureMetadataSection INSTANCE = new RecraftedTextureMetadataSection();

    @Override
    public String getKey(){
        return "mc-recrafted";
    }

    @Override
    public Pair<TextureType<Object>,Object> fromJson(JsonObject json){
        // Finalize the registry
        TextureTypeRegistryImpl.finalizeRegistration();
        // Get the texture type
        return TextureTypeRegistryImpl.deserializeTextureData(json);
    }
}
