package net.kuro.recrafted.structure.block.connectedtextures.extensions;

import net.kuro.recrafted.structure.block.connectedtextures.api.texture.TextureType;

public interface TextureAtlasSpriteExtension {

    void setRecraftedTextureType(TextureType<?> type);

    TextureType<?> getRecraftedTextureType();
}
