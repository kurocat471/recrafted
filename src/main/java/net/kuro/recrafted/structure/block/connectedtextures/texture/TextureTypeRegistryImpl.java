package net.kuro.recrafted.structure.block.connectedtextures.texture;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.util.HashMap;
import java.util.Map;

import net.kuro.recrafted.structure.block.connectedtextures.api.texture.TextureType;
import net.kuro.recrafted.structure.block.connectedtextures.api.util.Pair;
import net.kuro.recrafted.structure.block.connectedtextures.util.IdentifierUtil;
import net.minecraft.util.Identifier;

public class TextureTypeRegistryImpl {

    private static final Map<Identifier, TextureType<?>> IDENTIFIER_TO_TEXTURE_TYPE = new HashMap<>();
    private static final Map<TextureType<?>,Identifier> TEXTURE_TYPE_TO_IDENTIFIER = new HashMap<>();
    private static boolean finalized = false;

    public static synchronized void registerTextureType(Identifier identifier, TextureType<?> textureType){
        if(finalized)
            throw new RuntimeException("Texture types must be registered before textures get loaded!");
        if(IDENTIFIER_TO_TEXTURE_TYPE.containsKey(identifier))
            throw new RuntimeException("Duplicate texture type registration for identifier '" + identifier + "'!");
        if(TEXTURE_TYPE_TO_IDENTIFIER.containsKey(textureType))
            throw new RuntimeException("Texture type has already been registered!");

        IDENTIFIER_TO_TEXTURE_TYPE.put(identifier, textureType);
        TEXTURE_TYPE_TO_IDENTIFIER.put(textureType, identifier);
    }

    public static <T> JsonObject serializeTextureData(TextureType<T> textureType, T textureData){
        if(!finalized)
            throw new RuntimeException("Can only serialize texture data after registration has completed!");
        Identifier identifier = TEXTURE_TYPE_TO_IDENTIFIER.get(textureType);
        if(identifier == null)
            throw new RuntimeException("Cannot use unregistered texture type '" + textureType + "'!");

        // Serialize the texture data
        JsonObject json;
        try{
            json = textureType.serialize(textureData);
            if(json == null)
                json = new JsonObject();
        }catch(Exception e){
            throw new RuntimeException("Encountered an exception whilst serializing data for texture type '" + identifier + "'!", e);
        }

        // Add the identifier
        json.addProperty("type", identifier.toString());
        return json;
    }

    public static <T> Pair<TextureType<T>,T> deserializeTextureData(JsonObject json){
        if(!finalized)
            throw new RuntimeException("Can only deserialize texture data after registration has completed!");
        JsonElement typeJson = json.getAsJsonObject().get("type");
        if(typeJson == null || !typeJson.isJsonPrimitive() || !typeJson.getAsJsonPrimitive().isString())
            throw new JsonParseException("Connected textures texture must have string property 'type'!");
        if(!IdentifierUtil.isValidIdentifier(typeJson.getAsString()))
            throw new JsonParseException("Property 'type' must be a valid identifier!");
        Identifier identifier = IdentifierUtil.withRecraftedNamespace(typeJson.getAsString());
        //noinspection unchecked
        TextureType<T> textureType = (TextureType<T>)IDENTIFIER_TO_TEXTURE_TYPE.get(identifier);
        if(textureType == null)
            throw new JsonParseException("Unknown texture type '" + identifier + "'!");

        // Deserialize the texture data
        T textureData;
        try{
            textureData = textureType.deserialize(json);
        }catch(Exception e){
            throw new RuntimeException("Encountered an exception whilst deserializing data for texture type '" + identifier + "'!", e);
        }
        return Pair.of(textureType, textureData);
    }

    public static Identifier getIdentifier(TextureType<?> textureType){
        return TEXTURE_TYPE_TO_IDENTIFIER.get(textureType);
    }

    public static void finalizeRegistration(){
        if(!finalized){
            synchronized(TextureTypeRegistryImpl.class){
                finalized = true;
            }
        }
    }
}
