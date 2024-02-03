package net.kuro.recrafted.structure.block.connectedtextures.api.model.data;

import net.kuro.recrafted.structure.block.connectedtextures.model.types.vanilla.VanillaModelDataBuilderImpl;
import net.minecraft.client.render.model.json.JsonUnbakedModel;
import net.minecraft.util.Identifier;

public interface VanillaModelDataBuilder<T extends VanillaModelDataBuilder<T,S>, S> {

    static VanillaModelDataBuilder<?,JsonUnbakedModel> builder(){
        return new VanillaModelDataBuilderImpl();
    }

    /**
     * Sets the parent model.
     */
    T parent(Identifier parent);

    /**
     * Puts the given reference under the given key. These keys may be used when on faces for elements of this model or its parent's.
     */
    T texture(String key, String reference);

    /**
     * Puts the given texture under the given key. These keys may be used when on faces for elements of this model or its parent's.
     */
    T texture(String key, Identifier texture);

    S build();
}
