package net.kuro.recrafted.structure.block.connectedtextures.api.texture.data;

import net.kuro.recrafted.structure.block.connectedtextures.texture.types.connecting.ConnectingTextureDataImpl;
import org.jetbrains.annotations.Nullable;

public interface ConnectingTextureData {

    /**
     * Creates a builder for connecting texture data.
     */
    static Builder builder(){
        return new Builder();
    }

    ConnectingTextureLayout getLayout();

    @Nullable
    RenderType getRenderType();

    final class Builder {

        private ConnectingTextureLayout layout = ConnectingTextureLayout.FULL;
        private RenderType renderType = null;

        private Builder(){
        }

        /**
         * Sets the layout of the texture.
         * @see ConnectingTextureLayout
         */
        public Builder layout(ConnectingTextureLayout layout){
            this.layout = layout;
            return this;
        }

        public Builder renderType(@Nullable RenderType type){
            this.renderType = type;
            return this;
        }

        public ConnectingTextureData build(){
            return new ConnectingTextureDataImpl(this.layout, this.renderType);
        }
    }

    enum RenderType {
        /**
         * Pixels in the texture will be rendered fully opaque.
         */
        OPAQUE,
        /**
         * Every pixel in the texture will be either fully transparent or fully opaque.
         */
        CUTOUT,
        /**
         * Pixels will be rendered with the transparency in the texture.
         */
        TRANSLUCENT
    }
}
