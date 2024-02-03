package net.kuro.recrafted.structure.block.connectedtextures.model.types.vanilla;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import org.jetbrains.annotations.Nullable;
import net.kuro.recrafted.structure.block.connectedtextures.api.model.*;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.ModelLoader;
import net.minecraft.client.render.model.json.JsonUnbakedModel;
import net.minecraft.util.Identifier;

public class VanillaModelType implements ModelType<JsonUnbakedModel> {

    @Override
    public Collection<Identifier> getModelDependencies(JsonUnbakedModel data){
        return data.getModelDependencies();
    }

    @Override
    public BakedModel bake(ModelBakingContext context, JsonUnbakedModel data){
        if(data.parentId != null && data.parent == null){
            ModelInstance<?> model = context.getModel(data.parentId);
            if(model != null)
                data.parent = model.getAsVanillaModel();
        }
        return data.bake(context.getModelBaker(), material -> context.getTexture(SpriteIdentifier.of(material)), context.getTransformation(), context.getModelIdentifier());
    }

    @Nullable
    @Override
    public JsonUnbakedModel getAsVanillaModel(JsonUnbakedModel data){
        return data;
    }

    @Override
    public JsonUnbakedModel deserialize(JsonObject json) throws JsonParseException{
        return JsonUnbakedModel.GSON.fromJson(json, JsonUnbakedModel.class);
    }

    @Override
    public JsonObject serialize(JsonUnbakedModel value){
        return (JsonObject)VanillaModelSerializer.GSON.toJsonTree(value);
    }

    private static void resolveParents(GatherTexturesContext context, JsonUnbakedModel model){
        Set<JsonUnbakedModel> passedModels = new LinkedHashSet<>();
        while(model.parentId != null && model.parent == null){
            passedModels.add(model);
            ModelInstance<?> modelInstance = context.getModel(model.parentId);
            JsonUnbakedModel parent = modelInstance.getAsVanillaModel();
            if(parent == null)
                JsonUnbakedModel.LOGGER.warn("Vanilla model {} cannot have parent with model type {} for {}!", model, modelInstance.getModelType(), model.parentId);
            if(passedModels.contains(parent)){
                JsonUnbakedModel.LOGGER.warn("Found 'parent' loop while loading model '{}' in chain: {} -> {}", model, passedModels.stream().map(Object::toString).collect(Collectors.joining(" -> ")), model.parentId);
                parent = null;
            }
            if(parent == null){
                model.parentId = ModelLoader.MISSING_ID;
                parent = context.getModel(model.parentId).getAsVanillaModel();
                if(parent == null)
                    throw new RuntimeException("Got null for missing model request!");
            }
            model.parent = parent;
            model = parent;
        }
    }
}
