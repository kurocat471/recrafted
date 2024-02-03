package net.kuro.recrafted.structure.block.connectedtextures.resources;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.resource.metadata.ResourceMetadataReader;

public class RecraftedPackMetadataSection implements ResourceMetadataReader<String> {

    public static final RecraftedPackMetadataSection INSTANCE = new RecraftedPackMetadataSection();

    @Override
    public String getKey(){
        return "mc-recrafted";
    }

    @Override
    public String fromJson(JsonObject json){
        String overridesFolder = null;
        if(json.has("overrides_folder")){
            JsonElement element = json.get("overrides_folder");
            if(!element.isJsonPrimitive() || !element.getAsJsonPrimitive().isString())
                throw new RuntimeException("'overrides_folder' must be a string!");

            overridesFolder = element.getAsString().trim();
            if(!overridesFolder.matches("[a-z0-9/._-]+"))
                throw new RuntimeException("'overrides_folder' must be a valid path!");

            if(!overridesFolder.endsWith("/"))
                overridesFolder += "/";

            if(overridesFolder.startsWith("assets/"))
                throw new RuntimeException("'overrides_folder' cannot be inside 'assets'!");
            if(overridesFolder.startsWith("data/"))
                throw new RuntimeException("'overrides_folder' cannot be inside 'data'!");
        }
        return overridesFolder;
    }
}
