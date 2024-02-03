package net.kuro.recrafted.structure.block.connectedtextures.api.model.data;

import java.util.Map;
import net.kuro.recrafted.structure.block.connectedtextures.api.predicate.ConnectionPredicate;
import net.minecraft.client.render.model.json.JsonUnbakedModel;

public interface ConnectingModelData {

    static ConnectingModelDataBuilder builder(){
        return ConnectingModelDataBuilder.builder();
    }

    JsonUnbakedModel getVanillaModel();

    ConnectionPredicate getConnectionPredicate(String texture);

    ConnectionPredicate getDefaultConnectionPredicate();

    Map<String,ConnectionPredicate> getAllConnectionPredicates();
}
