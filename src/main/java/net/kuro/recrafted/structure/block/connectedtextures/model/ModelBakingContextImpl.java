package net.kuro.recrafted.structure.block.connectedtextures.model;

import java.util.function.Function;

import net.kuro.recrafted.structure.block.connectedtextures.api.model.ModelBakingContext;
import net.kuro.recrafted.structure.block.connectedtextures.api.model.ModelInstance;
import net.kuro.recrafted.structure.block.connectedtextures.api.model.SpriteIdentifier;
import net.minecraft.client.render.model.Baker;
import net.minecraft.client.render.model.ModelBakeSettings;
import net.minecraft.client.texture.Sprite;
import net.minecraft.util.Identifier;

public class ModelBakingContextImpl implements ModelBakingContext {

    private final Baker modelBaker;
    private final Function<net.minecraft.client.util.SpriteIdentifier,Sprite> spriteGetter;
    private final ModelBakeSettings modelState;
    private final Identifier modelIdentifier;

    public ModelBakingContextImpl(Baker modelBaker, Function<net.minecraft.client.util.SpriteIdentifier,Sprite> spriteGetter, ModelBakeSettings modelState, Identifier modelIdentifier){
        this.modelBaker = modelBaker;
        this.spriteGetter = spriteGetter;
        this.modelState = modelState;
        this.modelIdentifier = modelIdentifier;
    }


    @Override
    public Baker getModelBaker(){
        return this.modelBaker;
    }

    @Override
    public Sprite getTexture(SpriteIdentifier identifier){
        return this.spriteGetter.apply(identifier.toMaterial());
    }

    @Override
    public Sprite getTexture(Identifier atlas, Identifier texture){
        return this.spriteGetter.apply(new net.minecraft.client.util.SpriteIdentifier(atlas, texture));
    }

    @Override
    public ModelBakeSettings getTransformation(){
        return this.modelState;
    }

    @Override
    public Identifier getModelIdentifier(){
        return this.modelIdentifier;
    }

    @Override
    public ModelInstance<?> getModel(Identifier identifier){
        return RecraftedBlockModel.getModelInstance(this.modelBaker.getOrLoadModel(identifier));
    }
}
