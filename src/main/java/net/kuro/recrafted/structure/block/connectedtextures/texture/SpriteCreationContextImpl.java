package net.kuro.recrafted.structure.block.connectedtextures.texture;

import net.kuro.recrafted.structure.block.connectedtextures.api.texture.SpriteCreationContext;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.texture.SpriteLoader;
import net.minecraft.util.Identifier;

public class SpriteCreationContextImpl implements SpriteCreationContext, AutoCloseable {

    private final Sprite original;
    private final int textureWidth, textureHeight;
    private final Identifier identifier;
    private final NativeImage[] images;
    private final int atlasWidth, atlasHeight;
    private final SpriteAtlasTexture atlas;
    private final int spriteX, spriteY, spriteWidth, spriteHeight;
    private final int mipmapLevels;
    private boolean imagesRequested = false;

    public SpriteCreationContextImpl(SpriteLoader.StitchResult preparations, Identifier atlas, Sprite original){
        this.original = original;
        this.textureWidth = original.getContents().image.getWidth();
        this.textureHeight = original.getContents().image.getHeight();
        this.identifier = original.getContents().getId();
        this.images = original.getContents().mipmapLevelsImages;
        this.atlasWidth = preparations.width();
        this.atlasHeight = preparations.height();
        this.atlas = (SpriteAtlasTexture)MinecraftClient.getInstance().getTextureManager().getOrDefault(atlas, null);
        this.spriteX = original.getX();
        this.spriteY = original.getY();
        this.spriteWidth = original.getContents().getWidth();
        this.spriteHeight = original.getContents().getHeight();
        this.mipmapLevels = preparations.mipLevel();
    }

    private void closeUnusedResources(){
        if(!this.imagesRequested)
            this.original.getContents().close();
    }

    @Override
    public Sprite createOriginalSprite(){
        this.imagesRequested = true;
        return this.original;
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
    public Identifier getTextureIdentifier(){
        return this.identifier;
    }

    @Override
    public NativeImage[] getTextureBuffers(){
        this.imagesRequested = true;
        return this.images;
    }

    @Override
    public int getAtlasWidth(){
        return this.atlasWidth;
    }

    @Override
    public int getAtlasHeight(){
        return this.atlasHeight;
    }

    @Override
    public SpriteAtlasTexture getAtlas(){
        return this.atlas;
    }

    @Override
    public int getSpritePositionX(){
        return this.spriteX;
    }

    @Override
    public int getSpritePositionY(){
        return this.spriteY;
    }

    @Override
    public int getSpriteWidth(){
        return this.spriteWidth;
    }

    @Override
    public int getSpriteHeight(){
        return this.spriteHeight;
    }

    @Override
    public int getMipmapLevels(){
        return this.mipmapLevels;
    }

    @Override
    public void close(){
        this.closeUnusedResources();
    }
}
