package net.kuro.recrafted.structure.block.connectedtextures.model;

import net.kuro.recrafted.structure.block.connectedtextures.api.model.DefaultModelTypes;
import net.kuro.recrafted.structure.block.connectedtextures.api.model.ModelBakingContext;
import net.kuro.recrafted.structure.block.connectedtextures.api.model.ModelInstance;
import net.kuro.recrafted.structure.block.connectedtextures.extensions.BlockModelExtension;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.Baker;
import net.minecraft.client.render.model.ModelBakeSettings;
import net.minecraft.client.render.model.UnbakedModel;
import net.minecraft.client.render.model.json.JsonUnbakedModel;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.model.*;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import java.util.Collection;
import java.util.Collections;
import java.util.function.Function;

public class RecraftedBlockModel extends JsonUnbakedModel {

    public static final UnbakedModel DUMMY_MODEL = new UnbakedModel() {
        @Override
        public Collection<Identifier> getModelDependencies(){
            return Collections.emptyList();
        }

        @Override
        public void setParents(Function<Identifier,UnbakedModel> function){
        }

        @Nullable
        @Override
        public BakedModel bake(Baker modelBaker, Function<SpriteIdentifier,Sprite> function, ModelBakeSettings modelState, Identifier resourceLocation){
            return null;
        }
    };

    private final ModelInstance<?> model;
    private final JsonUnbakedModel vanillaModel;
    private Collection<Identifier> dependencies;

    public RecraftedBlockModel(ModelInstance<?> model){
        super(null, Collections.emptyList(), Collections.emptyMap(), false, null, ModelTransformation.NONE, Collections.emptyList());
        this.model = model;
        this.vanillaModel = model.getAsVanillaModel();
    }

    @Override
    public BakedModel bake(Baker baker, JsonUnbakedModel someOtherModel, Function<SpriteIdentifier,Sprite> spriteGetter, ModelBakeSettings modelTransform, Identifier modelLocation, boolean gui3d){
        // Let the custom model handle the actual baking
        ModelBakingContext context = new ModelBakingContextImpl(baker, spriteGetter, modelTransform, modelLocation);
        return this.model.bake(context);
    }

    @Override
    public Collection<Identifier> getModelDependencies(){
        if(this.dependencies != null)
            return this.dependencies;
        try{
            this.dependencies = this.model.getModelDependencies();
        }catch(Exception e){
            throw new RuntimeException("Encountered an exception whilst requesting dependencies from model type '" + ModelTypeRegistryImpl.getIdentifier(this.model.getModelType()) + "' for  '" + this.id + "'!", e);
        }
        if(this.dependencies == null)
            throw new RuntimeException("Model type '" + ModelTypeRegistryImpl.getIdentifier(this.model.getModelType()) + "' returned null when requesting dependencies '" + this.id + "'!");
        return this.dependencies;
    }

    @Override
    public void setParents(Function<Identifier,UnbakedModel> function){
        JsonUnbakedModel vanillaModel = this.model.getAsVanillaModel();
        if(vanillaModel != null)
            vanillaModel.setParents(function);
    }

    public boolean hasVanillaModel(){
        return this.vanillaModel != null;
    }

    public JsonUnbakedModel getVanillaModel(){
        return this.vanillaModel;
    }

    public static ModelInstance<?> getModelInstance(UnbakedModel model){
        if(model instanceof RecraftedBlockModel)
            return ((RecraftedBlockModel)model).model;
        if(model instanceof JsonUnbakedModel){
            ModelInstance<?> modelInstance = ((BlockModelExtension)model).getRecraftedModel();
            if(modelInstance == null){
                modelInstance = new ModelInstanceImpl<>(DefaultModelTypes.VANILLA, (JsonUnbakedModel)model);
                ((BlockModelExtension)model).setRecraftedModel(modelInstance);
            }
            return modelInstance;
        }
        return new ModelInstanceImpl<>(DefaultModelTypes.UNKNOWN, model);
    }
}
