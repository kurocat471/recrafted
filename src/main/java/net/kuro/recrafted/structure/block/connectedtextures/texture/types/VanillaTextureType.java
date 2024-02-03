package net.kuro.recrafted.structure.block.connectedtextures.texture.types;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import net.kuro.recrafted.structure.block.connectedtextures.api.texture.SpriteCreationContext;
import net.kuro.recrafted.structure.block.connectedtextures.api.texture.SpritePreparationContext;
import net.kuro.recrafted.structure.block.connectedtextures.api.texture.TextureType;
import net.kuro.recrafted.structure.block.connectedtextures.api.util.Pair;
import net.minecraft.client.texture.Sprite;

public class VanillaTextureType implements TextureType<Void> {

    @Override
    public Pair<Integer,Integer> getFrameSize(SpritePreparationContext context, Void data){
        return context.getOriginalFrameSize();
    }

    @Override
    public Sprite createSprite(SpriteCreationContext context, Void data){
        return context.createOriginalSprite();
    }

    @Override
    public Void deserialize(JsonObject json) throws JsonParseException{
        return null;
    }

    @Override
    public JsonObject serialize(Void value){
        return null;
    }
}
