package net.kuro.recrafted.structure.block.connectedtextures.model;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.util.HashMap;
import java.util.Map;

import net.kuro.recrafted.structure.block.connectedtextures.api.model.ModelInstance;
import net.kuro.recrafted.structure.block.connectedtextures.api.model.ModelType;
import net.kuro.recrafted.structure.block.connectedtextures.util.IdentifierUtil;
import net.minecraft.util.Identifier;

public class ModelTypeRegistryImpl {

    private static final Map<Identifier, ModelType<?>> IDENTIFIER_TO_MODEL_TYPE = new HashMap<>();
    private static final Map<ModelType<?>,Identifier> MODEL_TYPE_TO_IDENTIFIER = new HashMap<>();
    private static boolean finalized = false;

    public static synchronized void registerModelType(Identifier identifier, ModelType<?> modelType){
        if(finalized)
            throw new RuntimeException("Model types must be registered before models get loaded!");
        if(IDENTIFIER_TO_MODEL_TYPE.containsKey(identifier))
            throw new RuntimeException("Duplicate model type registration for identifier '" + identifier + "'!");
        if(MODEL_TYPE_TO_IDENTIFIER.containsKey(modelType))
            throw new RuntimeException("Model type has already been registered!");

        IDENTIFIER_TO_MODEL_TYPE.put(identifier, modelType);
        MODEL_TYPE_TO_IDENTIFIER.put(modelType, identifier);
    }

    public static JsonObject serializeModelData(ModelInstance<?> model){
        if(!finalized)
            throw new RuntimeException("Can only serialize model data after registration has completed!");
        Identifier identifier = MODEL_TYPE_TO_IDENTIFIER.get(model.getModelType());
        if(identifier == null)
            throw new RuntimeException("Cannot use unregistered model type '" + model.getModelType() + "'!");

        // Serialize the model data
        JsonObject json;
        try{
            //noinspection unchecked
            json = ((ModelType<Object>)model.getModelType()).serialize(model.getModelData());
            if(json == null)
                json = new JsonObject();
        }catch(Exception e){
            throw new RuntimeException("Encountered an exception whilst serializing data for model type '" + identifier + "'!", e);
        }

        // Add the identifier
        json.addProperty("loader", "mc-recrafted:model");
        json.addProperty("type", identifier.toString());
        return json;
    }

    public static ModelInstance<?> deserializeModelData(JsonObject json){
        if(!finalized)
            throw new RuntimeException("Can only deserialize model data after registration has completed!");
        JsonElement typeJson = json.getAsJsonObject().get("type");
        if(typeJson == null || !typeJson.isJsonPrimitive() || !typeJson.getAsJsonPrimitive().isString())
            throw new JsonParseException("Connected textures model must have string property 'type'!");
        if(!IdentifierUtil.isValidIdentifier(typeJson.getAsString()))
            throw new JsonParseException("Property 'type' must be a valid identifier!");
        Identifier identifier = IdentifierUtil.withRecraftedNamespace(typeJson.getAsString());
        //noinspection unchecked
        ModelType<Object> modelType = (ModelType<Object>)IDENTIFIER_TO_MODEL_TYPE.get(identifier);
        if(modelType == null)
            throw new JsonParseException("Unknown model type '" + identifier + "'!");

        // Deserialize the model data
        json.remove("loader");
        Object modelData;
        try{
            modelData = modelType.deserialize(json);
        }catch(JsonParseException e){
            throw new JsonParseException("Invalid json for model type '" + identifier + "'!", e);
        }catch(Exception e){
            throw new RuntimeException("Encountered an exception whilst deserializing data for model type '" + identifier + "'!", e);
        }finally{
            json.add("loader", typeJson);
        }
        return ModelInstance.of(modelType, modelData);
    }

    public static Identifier getIdentifier(ModelType<?> modelType){
        if(!finalized){
            synchronized(ModelTypeRegistryImpl.class){
                return MODEL_TYPE_TO_IDENTIFIER.get(modelType);
            }
        }
        return MODEL_TYPE_TO_IDENTIFIER.get(modelType);
    }

    public static void finalizeRegistration(){
        if(!finalized){
            synchronized(ModelTypeRegistryImpl.class){
                finalized = true;
            }
        }
    }
}
