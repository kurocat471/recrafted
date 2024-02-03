package net.kuro.recrafted.structure.block.connectedtextures.texture.types.connecting;

import net.kuro.recrafted.structure.block.connectedtextures.api.texture.data.ConnectingTextureData;
import net.kuro.recrafted.structure.block.connectedtextures.api.texture.data.ConnectingTextureLayout;
import org.jetbrains.annotations.Nullable;

public class ConnectingTextureDataImpl implements ConnectingTextureData {

    private final ConnectingTextureLayout layout;
    private final RenderType renderType;

    public ConnectingTextureDataImpl(ConnectingTextureLayout layout, RenderType renderType){
        this.layout = layout;
        this.renderType = renderType;
    }

    @Override
    public ConnectingTextureLayout getLayout(){
        return this.layout;
    }

    @Override
    public @Nullable RenderType getRenderType(){
        return this.renderType;
    }

}
