package net.kuro.recrafted.structure.block.connectedtextures.api.model;

import net.minecraft.util.Identifier;

public interface GatherTexturesContext {

    /**
     * Gets the model for the given identifier.
     * @return a pair containing the model type and the model's data
     * @throws IllegalArgumentException when the requested model was not in {@link ModelType#getModelDependencies(Object)}
     */
    ModelInstance<?> getModel(Identifier identifier);
}
