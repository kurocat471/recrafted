package net.kuro.recrafted.structure.block.connectedtextures.api.model;


import net.kuro.recrafted.structure.block.connectedtextures.model.SpriteIdentifierImpl;
import net.kuro.recrafted.structure.block.connectedtextures.util.TextureAtlases;
import net.minecraft.client.texture.MissingSprite;
import net.minecraft.util.Identifier;

public interface SpriteIdentifier {

    static SpriteIdentifier of(Identifier atlas, Identifier texture){
        return new SpriteIdentifierImpl(atlas, texture);
    }

    static SpriteIdentifier of(net.minecraft.client.util.SpriteIdentifier material){
        return new SpriteIdentifierImpl(material);
    }

    /**
     * @return the identifier for the missing texture sprite in the block atlas
     */
    static SpriteIdentifier missing(){
        return of(TextureAtlases.getBlocks(), MissingSprite.getMissingSpriteId());
    }

    Identifier getAtlas();

    Identifier getTexture();

    default net.minecraft.client.util.SpriteIdentifier toMaterial(){
        return new net.minecraft.client.util.SpriteIdentifier(this.getAtlas(), this.getTexture());
    }
}
