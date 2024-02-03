package net.kuro.recrafted.structure.block.connectedtextures.extensions;

import net.kuro.recrafted.structure.block.connectedtextures.api.model.ModelInstance;

public interface BlockModelExtension {

    ModelInstance<?> getRecraftedModel();

    void setRecraftedModel(ModelInstance<?> model);
}
