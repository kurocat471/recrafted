package net.kuro.recrafted.structure.block.connectedtextures.model.types.vanilla;

import com.mojang.datafixers.util.Either;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import net.kuro.recrafted.structure.block.connectedtextures.api.model.data.VanillaModelDataBuilder;
import net.kuro.recrafted.structure.block.connectedtextures.api.util.Pair;
import net.kuro.recrafted.structure.block.connectedtextures.util.TextureAtlases;
import net.minecraft.client.render.model.json.JsonUnbakedModel;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;

public class VanillaModelDataBuilderImpl implements VanillaModelDataBuilder<VanillaModelDataBuilderImpl,JsonUnbakedModel> {

    private final Map<String,String> textures = new HashMap<>();
    private Identifier parent;

    @Override
    public VanillaModelDataBuilderImpl parent(Identifier parent){
        this.parent = parent;
        return this;
    }

    @Override
    public VanillaModelDataBuilderImpl texture(String key, String reference){
        if(!key.matches("[a-zA-Z_]*"))
            throw new IllegalArgumentException("Texture reference must only contain characters [a-zA-Z_]!");

        // Prepend '#' character
        if(reference.charAt(0) != '#')
            reference = '#' + reference;
        if(this.textures.containsKey(key))
            throw new RuntimeException("Duplicate texture entry for key '" + key + "': '" + this.textures.get(key) + "' and '" + reference + "'!");

        this.textures.put(key, reference);
        return this;
    }

    @Override
    public VanillaModelDataBuilderImpl texture(String key, Identifier texture){
        if(!key.matches("[a-zA-Z_]*"))
            throw new IllegalArgumentException("Texture reference must only contain characters [a-zA-Z_]!");
        if(this.textures.containsKey(key))
            throw new RuntimeException("Duplicate texture entry for key '" + key + "': '" + this.textures.get(key) + "' and '" + texture + "'!");

        this.textures.put(key, texture.toString());
        return this;
    }

    @Override
    public JsonUnbakedModel build(){
        Map<String,Either<SpriteIdentifier,String>> textures = this.textures.entrySet().stream()
                .map(entry -> Pair.of(entry.getKey(), entry.getValue()))
                .map(pair -> pair.<Either<SpriteIdentifier,String>>mapRight(s -> s.charAt(0) == '#' ? Either.right(s) : Either.left(new SpriteIdentifier(TextureAtlases.getBlocks(), new Identifier(s)))))
                .collect(Collectors.toMap(Pair::left, Pair::right));
        return new JsonUnbakedModel(this.parent, Collections.emptyList(), textures, null, null, ModelTransformation.NONE, Collections.emptyList());
    }
}
