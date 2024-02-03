package net.kuro.recrafted.structure.block.connectedtextures.api.model;

import net.kuro.recrafted.structure.block.connectedtextures.util.TextureAtlases;
import net.minecraft.client.render.model.Baker;
import net.minecraft.client.render.model.ModelBakeSettings;
import net.minecraft.client.texture.Sprite;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

public interface ModelBakingContext {

    /**
     * @return the model baker
     */
    Baker getModelBaker();

    /**
     * Gets the sprite for the given material.
     * @param identifier identifier for the sprite
     */
    Sprite getTexture(SpriteIdentifier identifier);

    /**
     * Gets the sprite for the given atlas and texture.
     * @param atlas   atlas which the texture is stitched to
     * @param texture texture identifier
     */
    default Sprite getTexture(Identifier atlas, Identifier texture){
        return this.getTexture(SpriteIdentifier.of(atlas, texture));
    }

    /**
     * Gets the sprite for the given texture on the block atlas.
     * @param texture texture identifier
     */
    default Sprite getBlockTexture(Identifier texture){
        return this.getTexture(TextureAtlases.getBlocks(), texture);
    }

    /**
     * @return the transformations which should be applied to the model
     */
    ModelBakeSettings getTransformation();

    /**
     * @return the identifier of the model.
     */
    Identifier getModelIdentifier();

    /**
     * Gets the model corresponding to the given identifier.
     * Only models which were returned from {@link ModelType#getModelDependencies(Object)} may be requested.
     * @param identifier identifier for the model
     */
    @Nullable
    ModelInstance<?> getModel(Identifier identifier);
}
