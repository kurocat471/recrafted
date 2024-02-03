package net.kuro.recrafted.mixin;


import net.kuro.recrafted.structure.block.connectedtextures.api.model.ModelInstance;
import net.kuro.recrafted.structure.block.connectedtextures.extensions.BlockModelExtension;
import net.kuro.recrafted.structure.block.connectedtextures.model.RecraftedBlockModel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import java.util.function.Function;
import net.minecraft.client.render.model.UnbakedModel;
import net.minecraft.client.render.model.json.JsonUnbakedModel;
import net.minecraft.util.Identifier;

@Mixin(value = JsonUnbakedModel.class, priority = 900)
public class BlockModelMixin implements BlockModelExtension {

    @Unique
    private ModelInstance<?> recraftedModel;

    @ModifyVariable(
            method = "setParents(Ljava/util/function/Function;)V",
            at = @At("HEAD"),
            ordinal = 0
    )
    private Function<Identifier,UnbakedModel> adjustModelGetter(Function<Identifier,UnbakedModel> modelGetter){
        return location -> {
            UnbakedModel model = modelGetter.apply(location);
            if(model instanceof RecraftedBlockModel)
                return ((RecraftedBlockModel)model).hasVanillaModel() ? ((RecraftedBlockModel)model).getVanillaModel() : RecraftedBlockModel.DUMMY_MODEL;
            return model;
        };
    }

    @Override
    public ModelInstance<?> getRecraftedModel(){
        return this.recraftedModel;
    }

    @Override
    public void setRecraftedModel(ModelInstance<?> recraftedModel){
        this.recraftedModel = recraftedModel;
    }
}
