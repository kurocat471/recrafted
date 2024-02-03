package net.kuro.recrafted.structure.block.connectedtextures.model.types.connecting;

import com.google.common.collect.ImmutableMap;
import java.util.Map;

import net.kuro.recrafted.structure.block.connectedtextures.api.model.data.ConnectingModelData;
import net.kuro.recrafted.structure.block.connectedtextures.api.predicate.ConnectionPredicate;
import net.minecraft.client.render.model.json.JsonUnbakedModel;

public class ConnectingModelDataImpl implements ConnectingModelData {

    private final JsonUnbakedModel model;
    private final Map<String, ConnectionPredicate> predicates;

    public ConnectingModelDataImpl(JsonUnbakedModel model, Map<String,ConnectionPredicate> predicates){
        this.model = model;
        this.predicates = ImmutableMap.copyOf(predicates);
    }

    @Override
    public JsonUnbakedModel getVanillaModel(){
        return this.model;
    }

    @Override
    public ConnectionPredicate getConnectionPredicate(String texture){
        return this.predicates.get(texture);
    }

    @Override
    public ConnectionPredicate getDefaultConnectionPredicate(){
        return this.getConnectionPredicate("default");
    }

    @Override
    public Map<String,ConnectionPredicate> getAllConnectionPredicates(){
        return this.predicates;
    }
}
