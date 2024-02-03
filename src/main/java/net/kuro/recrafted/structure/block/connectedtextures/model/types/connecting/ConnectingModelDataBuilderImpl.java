package net.kuro.recrafted.structure.block.connectedtextures.model.types.connecting;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import net.kuro.recrafted.structure.block.connectedtextures.api.model.data.ConnectingModelDataBuilder;
import net.kuro.recrafted.structure.block.connectedtextures.api.predicate.DefaultConnectionPredicates;
import net.kuro.recrafted.structure.block.connectedtextures.api.model.data.ConnectingModelData;
import net.kuro.recrafted.structure.block.connectedtextures.api.model.data.VanillaModelDataBuilder;
import net.kuro.recrafted.structure.block.connectedtextures.api.predicate.ConnectionPredicate;
import net.kuro.recrafted.structure.block.connectedtextures.api.util.Pair;
import net.minecraft.client.render.model.json.JsonUnbakedModel;
import net.minecraft.util.Identifier;

public class ConnectingModelDataBuilderImpl implements ConnectingModelDataBuilder {

    private final VanillaModelDataBuilder<?,JsonUnbakedModel> vanillaModel = VanillaModelDataBuilder.builder();
    private final Map<String,List<ConnectionPredicate>> predicates = new HashMap<>();

    @Override
    public ConnectingModelDataBuilderImpl connection(ConnectionPredicate predicate){
        return this.connection("default", predicate);
    }

    @Override
    public ConnectingModelDataBuilderImpl connection(String texture, ConnectionPredicate predicate){
        this.predicates.computeIfAbsent("default", s -> new ArrayList<>()).add(predicate);
        return this;
    }

    @Override
    public ConnectingModelDataBuilderImpl parent(Identifier parent){
        this.vanillaModel.parent(parent);
        return this;
    }

    @Override
    public ConnectingModelDataBuilderImpl texture(String key, String reference){
        this.vanillaModel.texture(key, reference);
        return this;
    }

    @Override
    public ConnectingModelDataBuilderImpl texture(String key, Identifier texture){
        this.vanillaModel.texture(key, texture);
        return this;
    }

    @Override
    public ConnectingModelData build(){
        JsonUnbakedModel model = this.vanillaModel.build();
        Map<String,ConnectionPredicate> predicates = this.predicates.entrySet().stream()
                .map(entry -> Pair.of(entry.getKey(), DefaultConnectionPredicates.or(entry.getValue().toArray(ConnectionPredicate[]::new))))
                .collect(Collectors.toUnmodifiableMap(Pair::left, Pair::right));
        return new ConnectingModelDataImpl(model, predicates);
    }
}
