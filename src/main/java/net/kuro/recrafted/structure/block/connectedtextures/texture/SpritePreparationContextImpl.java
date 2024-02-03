package net.kuro.recrafted.structure.block.connectedtextures.texture;

import net.kuro.recrafted.structure.block.connectedtextures.api.texture.SpritePreparationContext;
import net.minecraft.util.Identifier;

public class SpritePreparationContextImpl implements SpritePreparationContext {

    private final int originalWidth, originalHeight;
    private final int textureWidth, textureHeight;
    private final Identifier identifier;

    public SpritePreparationContextImpl(int originalWidth, int originalHeight, int textureWidth, int textureHeight, Identifier identifier){
        this.originalWidth = originalWidth;
        this.originalHeight = originalHeight;
        this.textureWidth = textureWidth;
        this.textureHeight = textureHeight;
        this.identifier = identifier;
    }

    @Override
    public int getOriginalFrameWith(){
        return this.originalWidth;
    }

    @Override
    public int getOriginalFrameHeight(){
        return this.originalHeight;
    }

    @Override
    public int getTextureWidth(){
        return this.textureWidth;
    }

    @Override
    public int getTextureHeight(){
        return this.textureHeight;
    }

    @Override
    public Identifier getIdentifier(){
        return this.identifier;
    }
}
