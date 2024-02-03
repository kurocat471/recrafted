package net.kuro.recrafted.structure.block.connectedtextures.model;

import net.kuro.recrafted.structure.block.connectedtextures.api.model.SpriteIdentifier;
import net.minecraft.util.Identifier;

public class SpriteIdentifierImpl implements SpriteIdentifier {

    private final Identifier atlas, texture;
    private net.minecraft.client.util.SpriteIdentifier material;

    public SpriteIdentifierImpl(Identifier atlas, Identifier texture){
        this.atlas = atlas;
        this.texture = texture;
    }

    public SpriteIdentifierImpl(net.minecraft.client.util.SpriteIdentifier material){
        this(material.getAtlasId(), material.getTextureId());
        this.material = material;
    }

    @Override
    public Identifier getAtlas(){
        return this.atlas;
    }

    @Override
    public Identifier getTexture(){
        return this.texture;
    }

    @Override
    public net.minecraft.client.util.SpriteIdentifier toMaterial(){
        return this.material == null ? (this.material = SpriteIdentifier.super.toMaterial()) : this.material;
    }
}