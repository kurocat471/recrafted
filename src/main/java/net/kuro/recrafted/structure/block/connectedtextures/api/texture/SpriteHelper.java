package net.kuro.recrafted.structure.block.connectedtextures.api.texture;

import net.kuro.recrafted.structure.block.connectedtextures.texture.SpriteHelperImpl;
import net.minecraft.client.texture.Sprite;

public final class SpriteHelper {

    /**
     * Returns the texture type of a given sprite.
     */
    public static TextureType<?> getTextureType(Sprite sprite){
        return SpriteHelperImpl.getTextureType(sprite);
    }
}
