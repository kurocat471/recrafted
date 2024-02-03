package net.kuro.recrafted.structure.block.connectedtextures.api.model;

import net.kuro.recrafted.structure.block.connectedtextures.model.ModelInstanceImpl;
import org.jetbrains.annotations.Nullable;
import java.util.Collection;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.JsonUnbakedModel;
import net.minecraft.util.Identifier;

public interface ModelInstance<T> {

    static <T> ModelInstance<T> of(ModelType<T> modelType, T modelData){
        return new ModelInstanceImpl<>(modelType, modelData);
    }

    ModelType<T> getModelType();

    T getModelData();

    /**
     * Gets all the dependencies on other model files.
     */
    Collection<Identifier> getModelDependencies();

    /**
     * Converts the model data into a baked model.
     * @param context context for baking the model
     * @return a baked model
     * @see ModelBakingContext
     */
    BakedModel bake(ModelBakingContext context);

    /**
     * Represents the model as a vanilla {@link JsonUnbakedModel} instance. May be used gather info from other models, such as with the vanilla 'parent' property.
     * @return a representation of the model as a vanilla {@link JsonUnbakedModel} instance, or {@code null} if such a representation is not available
     */
    @Nullable JsonUnbakedModel getAsVanillaModel();
}
