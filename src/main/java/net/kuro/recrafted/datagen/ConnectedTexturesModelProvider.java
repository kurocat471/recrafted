package net.kuro.recrafted.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.kuro.recrafted.Recrafted;
import net.kuro.recrafted.structure.block.connectedtextures.api.model.DefaultModelTypes;
import net.kuro.recrafted.structure.block.connectedtextures.api.model.ModelInstance;
import net.kuro.recrafted.structure.block.connectedtextures.api.model.data.ConnectingModelDataBuilder;
import net.kuro.recrafted.structure.block.connectedtextures.api.predicate.DefaultConnectionPredicates;
import net.kuro.recrafted.structure.block.connectedtextures.api.provider.RecraftedModelProvider;
import net.minecraft.util.Identifier;

public class ConnectedTexturesModelProvider extends RecraftedModelProvider {
    /**
     * @param modid  modid of the mod which creates the generator
     * @param output
     */
    public ConnectedTexturesModelProvider(String modid, FabricDataOutput output) {
        super(modid, output);
    }

    @Override
    protected void generate() {
        var modelData = ConnectingModelDataBuilder.builder()
                .parent(new Identifier("minecraft", "block/cube_all"))
                .texture("all", new Identifier(Recrafted.MOD_ID, "block/copper_panel"))
                .connection(DefaultConnectionPredicates.isSameBlock())
                .build();
        var modelInstance = ModelInstance.of(DefaultModelTypes.CONNECTING, modelData);

        this.addModel(new Identifier(Recrafted.MOD_ID, "block/copper_panel"), modelInstance);

    }
}
