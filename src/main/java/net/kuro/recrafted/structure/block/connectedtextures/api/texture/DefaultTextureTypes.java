package net.kuro.recrafted.structure.block.connectedtextures.api.texture;

import net.kuro.recrafted.structure.block.connectedtextures.api.model.DefaultModelTypes;
import net.kuro.recrafted.structure.block.connectedtextures.api.texture.data.ConnectingTextureData;
import net.kuro.recrafted.structure.block.connectedtextures.api.texture.data.ScrollingTextureData;
import net.kuro.recrafted.structure.block.connectedtextures.texture.types.VanillaTextureType;
import net.kuro.recrafted.structure.block.connectedtextures.texture.types.connecting.ConnectingTextureType;
import net.kuro.recrafted.structure.block.connectedtextures.texture.types.scrolling.ScrollingTextureType;

public final class DefaultTextureTypes {

    /**
     * Model type used for vanilla textures.
     */
    public static final TextureType<Void> VANILLA = new VanillaTextureType();
    /**
     * Texture type with a connected texture layout. Should be used in conjunction with {@link DefaultModelTypes#CONNECTING} model type.
     * @see ConnectingTextureData#builder()
     * @see DefaultModelTypes#CONNECTING
     */
    public static final TextureType<ConnectingTextureData> CONNECTING = new ConnectingTextureType();
    /**
     * Texture type with an animated sprite which scrolls over the texture.
     * @see ScrollingTextureData#builder()
     */
    public static final TextureType<ScrollingTextureData> SCROLLING = new ScrollingTextureType();
}
