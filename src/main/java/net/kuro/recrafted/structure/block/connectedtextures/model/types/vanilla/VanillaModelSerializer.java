package net.kuro.recrafted.structure.block.connectedtextures.model.types.vanilla;

import com.google.gson.*;
import java.lang.reflect.Type;
import java.util.Locale;
import net.minecraft.client.render.model.json.JsonUnbakedModel;

public class VanillaModelSerializer implements JsonSerializer<JsonUnbakedModel> {

    public static final Gson GSON = new GsonBuilder().registerTypeAdapter(JsonUnbakedModel.class, new VanillaModelSerializer()).disableHtmlEscaping().setPrettyPrinting().create();

    private VanillaModelSerializer(){
    }

    @Override
    public JsonElement serialize(JsonUnbakedModel src, Type typeOfSrc, JsonSerializationContext context){
        JsonObject json = new JsonObject();
        if(src.parentId != null)
            json.addProperty("parent", src.parentId.toString());
        if(!src.textureMap.isEmpty()){
            JsonObject textures = new JsonObject();
            src.textureMap.forEach((key, texture) -> textures.addProperty(key, texture.<String>map(m -> m.getTextureId().toString(), s -> s)));
            json.add("textures", textures);
        }
        if(src.parentId == null && !src.ambientOcclusion)
            json.addProperty("ambientocclusion", false);
        if(src.guiLight != null)
            json.addProperty("gui_light", src.guiLight.name().toLowerCase(Locale.ROOT));
        return json;
    }
}
