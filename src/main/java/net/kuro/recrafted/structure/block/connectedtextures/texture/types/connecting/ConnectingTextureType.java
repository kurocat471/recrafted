package net.kuro.recrafted.structure.block.connectedtextures.texture.types.connecting;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.util.Arrays;
import java.util.Locale;
import net.kuro.recrafted.structure.block.connectedtextures.api.texture.SpriteCreationContext;
import net.kuro.recrafted.structure.block.connectedtextures.api.texture.TextureType;
import net.kuro.recrafted.structure.block.connectedtextures.api.texture.data.ConnectingTextureData;
import net.kuro.recrafted.structure.block.connectedtextures.api.texture.data.ConnectingTextureLayout;
import net.minecraft.client.texture.Sprite;

public class ConnectingTextureType implements TextureType<ConnectingTextureData> {

    @Override
    public ConnectingTextureData deserialize(JsonObject json) throws JsonParseException{
        ConnectingTextureData.Builder builder = ConnectingTextureData.builder();
        if(json.has("layout")){
            if(!json.get("layout").isJsonPrimitive() || !json.getAsJsonPrimitive("layout").isString())
                throw new JsonParseException("Property 'layout' must be a string!");
            String layoutString = json.get("layout").getAsString();
            ConnectingTextureLayout layout;
            try{
                layout = ConnectingTextureLayout.valueOf(layoutString.toUpperCase(Locale.ROOT));
            }catch(IllegalArgumentException e){
                throw new JsonParseException("Property 'layout' must be one of " + Arrays.toString(ConnectingTextureLayout.values()).toLowerCase(Locale.ROOT) + ", not '" + layoutString + "'!");
            }
            builder.layout(layout);
        }
        if(json.has("render_type")){
            if(!json.get("render_type").isJsonPrimitive() || !json.getAsJsonPrimitive("render_type").isString())
                throw new JsonParseException("Property 'render_type' must be a string!");
            String renderTypeString = json.get("render_type").getAsString();
            ConnectingTextureData.RenderType renderType;
            try{
                renderType = ConnectingTextureData.RenderType.valueOf(renderTypeString.toUpperCase(Locale.ROOT));
            }catch(IllegalArgumentException e){
                throw new JsonParseException("Property 'render_type' must be one of " + Arrays.toString(ConnectingTextureData.RenderType.values()).toLowerCase(Locale.ROOT) + ", not '" + renderTypeString + "'!");
            }
            builder.renderType(renderType);
        }
        return builder.build();
    }

    @Override
    public JsonObject serialize(ConnectingTextureData data){
        JsonObject json = new JsonObject();
        if(data.getLayout() != ConnectingTextureLayout.FULL)
            json.addProperty("layout", data.getLayout().name().toLowerCase(Locale.ROOT));
        if(data.getRenderType() != null)
            json.addProperty("render_type", data.getRenderType().name().toLowerCase(Locale.ROOT));
        return json.isEmpty() ? null : json;
    }

    @Override
    public Sprite createSprite(SpriteCreationContext context, ConnectingTextureData data){
        Sprite sprite = context.createOriginalSprite();
        sprite.maxU = sprite.minU + (sprite.maxU - sprite.minU) / ConnectingTextureLayoutHelper.getWidth(data.getLayout());
        sprite.maxV = sprite.minV + (sprite.maxV - sprite.minV) / ConnectingTextureLayoutHelper.getHeight(data.getLayout());
        return new ConnectingTextureSprite(sprite, data.getLayout(), data.getRenderType());
    }
}
