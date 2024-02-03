package net.kuro.recrafted.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.kuro.recrafted.Recrafted;
import net.kuro.recrafted.structure.block.connectedtextures.api.provider.RecraftedTextureMetadataProvider;
import net.kuro.recrafted.structure.block.connectedtextures.api.texture.DefaultTextureTypes;
import net.kuro.recrafted.structure.block.connectedtextures.api.texture.TextureType;
import net.kuro.recrafted.structure.block.connectedtextures.api.texture.data.ConnectingTextureData;
import net.kuro.recrafted.structure.block.connectedtextures.api.texture.data.ConnectingTextureLayout;
import net.kuro.recrafted.structure.block.connectedtextures.api.texture.data.ScrollingTextureData;
import net.minecraft.util.Identifier;

public class ConnectedTexturesTextureProvider extends RecraftedTextureMetadataProvider {
    /**
     * @param modid  modid of the mod which creates the generator
     * @param output
     */
    public ConnectedTexturesTextureProvider(String modid, FabricDataOutput output) {
        super(modid, output);
    }

    @Override
    protected void generate() {

        var textureData = ConnectingTextureData.builder()
                .layout(ConnectingTextureLayout.FULL)
                .build();
        this.addTextureMetadata(
                new Identifier(Recrafted.MOD_ID,"block/copper_panel"),
                DefaultTextureTypes.CONNECTING,
                textureData
        );

    }
}
