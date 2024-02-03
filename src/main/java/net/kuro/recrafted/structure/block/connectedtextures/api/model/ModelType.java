package net.kuro.recrafted.structure.block.connectedtextures.api.model;

import net.kuro.recrafted.structure.block.connectedtextures.api.util.Serializer;
import org.jetbrains.annotations.Nullable;
import java.util.Collection;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.JsonUnbakedModel;
import net.minecraft.util.Identifier;

public interface ModelType<T> extends Serializer<T> {

    /**
     * Gets all the dependencies on other model files.
     * @param data custom model data
     */
    Collection<Identifier> getModelDependencies(T data);

    /**
     * Converts the model data into a baked model.
     * @param context context for baking the model
     * @param data    custom model data
     * @return a baked model
     * @see ModelBakingContext
     */
    BakedModel bake(ModelBakingContext context, T data);

    /**
     * Represents the model as a vanilla {@link JsonUnbakedModel} instance. May be used gather info from other models, such as with the vanilla 'parent' property.
     * If the model cannot be represented as a {@link JsonUnbakedModel} instance, this method should return {@code null}.
     * @param data custom model data
     * @return a representation of the model as a vanilla {@link JsonUnbakedModel} instance, or {@code null} if such a representation is not available
     */
    @Nullable
    default JsonUnbakedModel getAsVanillaModel(T data){
        return null;
    }
}
