package net.kuro.recrafted.structure.block.connectedtextures.extensions;

import net.kuro.recrafted.structure.block.connectedtextures.api.texture.TextureType;
import net.kuro.recrafted.structure.block.connectedtextures.api.util.Pair;

public interface SpriteContentsExtension {

    Pair<TextureType<Object>,Object> recraftedTextureMetadata();

    void clearRecraftedTextureMetadata();
}
