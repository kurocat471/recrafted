package net.kuro.recrafted.mixin;

import net.kuro.recrafted.structure.block.connectedtextures.api.texture.TextureType;
import net.kuro.recrafted.structure.block.connectedtextures.extensions.TextureAtlasSpriteExtension;
import net.minecraft.client.texture.Sprite;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;


@Mixin(Sprite.class)
public class TextureAtlasSpriteMixin implements TextureAtlasSpriteExtension {

    @Unique
    private TextureType<?> recraftedType;

    @Override
    public void setRecraftedTextureType(TextureType<?> type){
        this.recraftedType = type;
    }

    @Override
    public TextureType<?> getRecraftedTextureType(){
        return this.recraftedType;
    }
}
