package net.kuro.recrafted.structure.block.connectedtextures.api.texture;

import net.kuro.recrafted.structure.block.connectedtextures.api.util.Pair;
import net.kuro.recrafted.structure.block.connectedtextures.api.util.Serializer;
import net.minecraft.client.texture.Sprite;

public interface TextureType<T> extends Serializer<T> {

    /**
     * Gets the size of a single frame. The returned size will be allocated in the relevant atlas.
     * @param context context for calculating the frame size
     * @param data    custom texture data
     * @return the size to allocate to this sprite in the atlas
     * @see SpritePreparationContext
     */
    default Pair<Integer,Integer> getFrameSize(SpritePreparationContext context, T data){
        return context.getOriginalFrameSize();
    }

    /**
     * Creates the sprite from the custom texture data.
     * @param context context for creating the sprite
     * @param data    custom texture data
     * @see SpriteCreationContext
     */
    Sprite createSprite(SpriteCreationContext context, T data);
}
