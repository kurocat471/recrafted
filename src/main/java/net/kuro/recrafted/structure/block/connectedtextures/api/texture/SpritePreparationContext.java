package net.kuro.recrafted.structure.block.connectedtextures.api.texture;

import net.kuro.recrafted.structure.block.connectedtextures.api.util.Pair;
import net.minecraft.util.Identifier;

public interface SpritePreparationContext {

    /**
     * Gets the original frame width as calculated by vanilla.
     */
    int getOriginalFrameWith();

    /**
     * Gets the original frame height as calculated by vanilla.
     */
    int getOriginalFrameHeight();

    /**
     * Gets the original frame size as calculated by vanilla.
     */
    default Pair<Integer,Integer> getOriginalFrameSize(){
        return Pair.of(this.getOriginalFrameWith(), this.getOriginalFrameHeight());
    }

    /**
     * Gets the width of the texture.
     */
    int getTextureWidth();

    /**
     * Gets the height of the texture.
     */
    int getTextureHeight();

    /**
     * Gets the identifier of the texture.
     */
    Identifier getIdentifier();
}
