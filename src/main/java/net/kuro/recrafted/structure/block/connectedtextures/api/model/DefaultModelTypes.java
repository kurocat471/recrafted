package net.kuro.recrafted.structure.block.connectedtextures.api.model;

import net.kuro.recrafted.structure.block.connectedtextures.api.texture.DefaultTextureTypes;
import net.kuro.recrafted.structure.block.connectedtextures.api.model.data.ConnectingModelDataBuilder;
import net.kuro.recrafted.structure.block.connectedtextures.api.model.data.ConnectingModelData;
import net.kuro.recrafted.structure.block.connectedtextures.model.types.UnknownModelType;
import net.kuro.recrafted.structure.block.connectedtextures.model.types.vanilla.VanillaModelType;
import net.kuro.recrafted.structure.block.connectedtextures.model.types.connecting.ConnectingModelType;
import net.minecraft.client.render.model.UnbakedModel;
import net.minecraft.client.render.model.json.JsonUnbakedModel;

public class DefaultModelTypes {

    /**
     * Model type used for vanilla {@link JsonUnbakedModel} instances.
     */
    public static final ModelType<JsonUnbakedModel> VANILLA = new VanillaModelType();
    /**
     * Model type used for any unknown models added by other mods.
     */
    public static final ModelType<UnbakedModel> UNKNOWN = new UnknownModelType();
    /**
     * Model type which allows for connecting textures.
     * @see DefaultTextureTypes#CONNECTING
     * @see ConnectingModelDataBuilder
     */
    public static final ModelType<ConnectingModelData> CONNECTING = new ConnectingModelType();
}
