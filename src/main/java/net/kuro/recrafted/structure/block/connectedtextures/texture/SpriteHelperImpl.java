package net.kuro.recrafted.structure.block.connectedtextures.texture;

import net.kuro.recrafted.structure.block.connectedtextures.api.texture.DefaultTextureTypes;
import net.kuro.recrafted.structure.block.connectedtextures.api.texture.TextureType;
import net.kuro.recrafted.structure.block.connectedtextures.extensions.TextureAtlasSpriteExtension;
import net.minecraft.client.texture.Sprite;

public class SpriteHelperImpl {

    public static TextureType<?> getTextureType(Sprite sprite){
        TextureType<?> textureType = ((TextureAtlasSpriteExtension)sprite).getRecraftedTextureType();
        if(textureType == null){
            ((TextureAtlasSpriteExtension)sprite).setRecraftedTextureType(DefaultTextureTypes.VANILLA);
            return DefaultTextureTypes.VANILLA;
        }
        return textureType;
    }
}
