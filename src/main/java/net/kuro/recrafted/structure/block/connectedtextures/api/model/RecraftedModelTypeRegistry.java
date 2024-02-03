package net.kuro.recrafted.structure.block.connectedtextures.api.model;

import com.google.gson.JsonObject;
import net.kuro.recrafted.structure.block.connectedtextures.model.ModelTypeRegistryImpl;
import net.minecraft.util.Identifier;

public class RecraftedModelTypeRegistry {

    /**
     * Registers the given model type.
     * @param identifier identifier for the model type
     * @param modelType  handler for the custom model
     */
    public static void registerModelType(Identifier identifier, ModelType<?> modelType){
        ModelTypeRegistryImpl.registerModelType(identifier, modelType);
    }

    /**
     * Serializes the given model.
     * @param model model to be serialized
     */
    public static JsonObject serializeModelData(ModelInstance<?> model){
        return ModelTypeRegistryImpl.serializeModelData(model);
    }
}