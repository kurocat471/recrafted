package net.kuro.recrafted.structure.block.connectedtextures.api.provider;

import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.fabricmc.loader.api.metadata.ModMetadata;
import net.kuro.recrafted.structure.block.connectedtextures.api.texture.RecraftedTextureTypeRegistry;
import net.kuro.recrafted.structure.block.connectedtextures.api.texture.TextureType;
import net.kuro.recrafted.structure.block.connectedtextures.api.util.Pair;
import net.minecraft.data.DataProvider;
import net.minecraft.data.DataWriter;
import net.minecraft.util.Identifier;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public abstract class RecraftedTextureMetadataProvider implements DataProvider {

    private final Map<Identifier,Pair<TextureType<Object>,Object>> metadata = new HashMap<>();
    private final String modName;
    private final FabricDataOutput output;

    /**
     * @param modid modid of the mod which creates the generator
     */
    public RecraftedTextureMetadataProvider(String modid, FabricDataOutput output){
        this.modName = FabricLoader.getInstance().getModContainer(modid).map(ModContainer::getMetadata).map(ModMetadata::getName).orElse(modid);
        this.output = output;
    }

    @Override
    public final CompletableFuture<?> run(DataWriter cache){
        this.generate();

        List<CompletableFuture<?>> tasks = new ArrayList<>();
        Path output = this.output.getPath();
        for(Map.Entry<Identifier, Pair<TextureType<Object>,Object>> entry : this.metadata.entrySet()){
            Identifier location = entry.getKey();
            Pair<TextureType<Object>,Object> metadata = entry.getValue();
            String extension = location.getPath().endsWith(".mcmeta") ? "" : location.getPath().lastIndexOf('.') > location.getPath().lastIndexOf('/') ? ".mcmeta" : ".png.mcmeta";
            Path path = Path.of("assets", location.getNamespace(), "textures", location.getPath() + extension);
            JsonObject json = new JsonObject();
            json.add("mc-recrafted", RecraftedTextureTypeRegistry.serializeTextureData(metadata.left(), metadata.right()));
            tasks.add(DataProvider.writeToPath(cache, json, output.resolve(path)));
        }
        return CompletableFuture.allOf(tasks.toArray(CompletableFuture[]::new));
    }

    /**
     * Adds texture metadata which should be generated through {@link #addTextureMetadata(Identifier, TextureType, Object)}.
     */
    protected abstract void generate();

    /**
     * Adds texture metadata to be generated.
     * @param location    location of the texture
     * @param textureType type of the texture
     * @param data        metadata to be serialized
     */
    public final <T> void addTextureMetadata(Identifier location, TextureType<T> textureType, T data){
        //noinspection unchecked
        Pair<TextureType<Object>,Object> previousValue = this.metadata.put(location, Pair.of((TextureType<Object>)textureType, (Object)data));
        if(previousValue != null)
            throw new RuntimeException("Duplicate texture metadata for '" + location + "'!");
    }

    @Override
    public String getName(){
        return "Recrafted Texture Metadata Provider: " + this.modName;
    }
}
