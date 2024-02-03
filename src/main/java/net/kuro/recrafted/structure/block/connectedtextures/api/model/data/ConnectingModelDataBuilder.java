package net.kuro.recrafted.structure.block.connectedtextures.api.model.data;

import net.kuro.recrafted.structure.block.connectedtextures.api.predicate.DefaultConnectionPredicates;
import net.kuro.recrafted.structure.block.connectedtextures.api.predicate.ConnectionPredicate;
import net.kuro.recrafted.structure.block.connectedtextures.model.types.connecting.ConnectingModelDataBuilderImpl;

public interface ConnectingModelDataBuilder extends VanillaModelDataBuilder<ConnectingModelDataBuilder,ConnectingModelData> {

    static ConnectingModelDataBuilder builder(){
        return new ConnectingModelDataBuilderImpl();
    }

    /**
     * Adds a new connection predicate. Of the added predicates, only one needs to be satisfied to form a connection.
     * In case multiple predicates should be satisfied, use {@link DefaultConnectionPredicates#and(ConnectionPredicate...)}.
     */
    ConnectingModelDataBuilder connection(ConnectionPredicate predicate);

    /**
     * Adds a new connection predicate for the given texture. Of the added predicates, only one needs to be satisfied to form a connection.
     * In case multiple predicates should be satisfied, use {@link DefaultConnectionPredicates#and(ConnectionPredicate...)}.
     */
    ConnectingModelDataBuilder connection(String texture, ConnectionPredicate predicate);
}
