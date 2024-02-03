package net.kuro.recrafted.structure.block.connectedtextures.model.types;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.util.Collection;

import net.kuro.recrafted.structure.block.connectedtextures.api.model.ModelBakingContext;
import net.kuro.recrafted.structure.block.connectedtextures.api.model.ModelType;
import net.kuro.recrafted.structure.block.connectedtextures.api.model.SpriteIdentifier;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.UnbakedModel;
import net.minecraft.util.Identifier;

public class UnknownModelType implements ModelType<UnbakedModel> {

    @Override
    public UnbakedModel deserialize(JsonObject json) throws JsonParseException{
        throw new UnsupportedOperationException("Cannot deserialize unknown model type!");
    }

    @Override
    public JsonObject serialize(UnbakedModel value){
        throw new UnsupportedOperationException("Cannot serialize unknown model type!");
    }

    @Override
    public Collection<Identifier> getModelDependencies(UnbakedModel data){
        return data.getModelDependencies();
    }

    @Override
    public BakedModel bake(ModelBakingContext context, UnbakedModel data){
        return data.bake(context.getModelBaker(), material -> context.getTexture(SpriteIdentifier.of(material)), context.getTransformation(), context.getModelIdentifier());
    }
}
