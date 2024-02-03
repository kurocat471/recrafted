package net.kuro.recrafted.structure.block.connectedtextures.api.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.fabricmc.loader.api.metadata.ModMetadata;
import net.kuro.recrafted.structure.block.connectedtextures.api.model.ModelInstance;
import net.kuro.recrafted.structure.block.connectedtextures.api.model.RecraftedModelTypeRegistry;
import net.minecraft.data.DataProvider;
import net.minecraft.data.DataWriter;
import net.minecraft.util.Identifier;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public abstract class RecraftedModelProvider implements DataProvider {

    private final Map<Identifier, ModelInstance<?>> models = new HashMap<>();
    private final String modName;
    private final FabricDataOutput output;

    /**
     * @param modid modid of the mod which creates the generator
     */
    public RecraftedModelProvider(String modid, FabricDataOutput output){
        this.modName = FabricLoader.getInstance().getModContainer(modid).map(ModContainer::getMetadata).map(ModMetadata::getName).orElse(modid);
        this.output = output;
    }

    @Override
    public final CompletableFuture<?> run(DataWriter cache){
        this.generate();

        List<CompletableFuture<?>> tasks = new ArrayList<>();
        Path output = this.output.getPath();
        for(Map.Entry<Identifier,ModelInstance<?>> entry : this.models.entrySet()){
            Identifier location = entry.getKey();
            ModelInstance<?> model = entry.getValue();
            String extension = location.getPath().lastIndexOf(".") > location.getPath().lastIndexOf("/") ? "" : ".json";
            Path path = Path.of("assets", location.getNamespace(), "models", location.getPath() + extension);
            tasks.add(DataProvider.writeToPath(cache, RecraftedModelTypeRegistry.serializeModelData(model), output.resolve(path)));
        }
        return CompletableFuture.allOf(tasks.toArray(CompletableFuture[]::new));
    }

    /**
     * Adds models which should be generated through {@link #addModel(Identifier, ModelInstance)}.
     */
    protected abstract void generate();

    /**
     * Adds a model to be generated.
     * @param location location of the model
     * @param model    model instance to be serialized
     */
    public final void addModel(Identifier location, ModelInstance<?> model){
        ModelInstance<?> previousValue = this.models.put(location, model);
        if(previousValue != null)
            throw new RuntimeException("Duplicate model for '" + location + "'!");
    }

    @Override
    public String getName(){
        return "Recrafted Model Provider: " + this.modName;
    }
}
