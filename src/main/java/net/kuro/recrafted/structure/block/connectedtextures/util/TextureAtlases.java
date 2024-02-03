package net.kuro.recrafted.structure.block.connectedtextures.util;

import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.util.Identifier;

public class TextureAtlases {

    @SuppressWarnings("deprecation")
    private static final Identifier BLOCKS = SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE;

    public static Identifier getBlocks(){
        return BLOCKS;
    }
}