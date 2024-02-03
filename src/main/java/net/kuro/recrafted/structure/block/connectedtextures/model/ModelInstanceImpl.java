package net.kuro.recrafted.structure.block.connectedtextures.model;


import net.kuro.recrafted.structure.block.connectedtextures.api.model.ModelBakingContext;
import net.kuro.recrafted.structure.block.connectedtextures.api.model.ModelInstance;
import net.kuro.recrafted.structure.block.connectedtextures.api.model.ModelType;
import org.jetbrains.annotations.Nullable;
import java.util.Collection;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.JsonUnbakedModel;
import net.minecraft.util.Identifier;

public class ModelInstanceImpl<T> implements ModelInstance<T> {

    private final ModelType<T> modelType;
    private final T modelData;

    public ModelInstanceImpl(ModelType<T> modelType, T modelData){
        this.modelType = modelType;
        this.modelData = modelData;
    }

    @Override
    public ModelType<T> getModelType(){
        return this.modelType;
    }

    @Override
    public T getModelData(){
        return this.modelData;
    }

    @Override
    public Collection<Identifier> getModelDependencies(){
        return this.modelType.getModelDependencies(this.modelData);
    }

    @Override
    public @Nullable JsonUnbakedModel getAsVanillaModel(){
        return this.modelType.getAsVanillaModel(this.modelData);
    }

    @Override
    public BakedModel bake(ModelBakingContext context){
        return this.modelType.bake(context, this.modelData);
    }
}
