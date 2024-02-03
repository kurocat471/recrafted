package net.kuro.recrafted.structure.block.connectedtextures.texture.types.connecting;

import net.kuro.recrafted.structure.block.connectedtextures.api.texture.data.ConnectingTextureData;
import net.kuro.recrafted.structure.block.connectedtextures.api.texture.data.ConnectingTextureLayout;
import net.minecraft.client.texture.Sprite;

public class ConnectingTextureSprite extends Sprite {

    private final ConnectingTextureLayout layout;
    private final ConnectingTextureData.RenderType renderType;

    protected ConnectingTextureSprite(Sprite original, ConnectingTextureLayout layout, ConnectingTextureData.RenderType renderType){
        super(
                original.getAtlasId(),
                original.getContents(),
                1,
                1,
                original.getX(),
                original.getY()
        );
        this.layout = layout;
        this.renderType = renderType;
        this.minU = original.minU;
        this.maxU = original.maxU;
        this.minV = original.minV;
        this.maxV = original.maxV;
    }

    public ConnectingTextureLayout getLayout(){
        return this.layout;
    }

    public ConnectingTextureData.RenderType getRenderType(){
        return this.renderType;
    }
}
