package net.kuro.recrafted.structure.block.connectedtextures.api.predicate;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import net.kuro.recrafted.structure.block.connectedtextures.api.util.Serializer;
import net.kuro.recrafted.structure.block.connectedtextures.predicate.PredicateRegistryImpl;
import net.minecraft.util.Identifier;

public final class RecraftedPredicateRegistry {

    /**
     * Registers a new connection predicate type.
     * @param identifier identifier for the predicate type
     * @param serializer serializer used to save the predicates to and load the predicates from json
     * @see ConnectionPredicate
     */
    public static void registerConnectionPredicate(Identifier identifier, Serializer<? extends ConnectionPredicate> serializer){
        PredicateRegistryImpl.registerConnectionPredicate(identifier, serializer);
    }

    /**
     * Serializes the given predicate.
     */
    public static JsonObject serializeConnectionPredicate(ConnectionPredicate predicate){
        return PredicateRegistryImpl.serializeConnectionPredicate(predicate);
    }

    /**
     * Loads a connection predicate from json.
     * @throws JsonParseException if the given json does not match the expected format
     */
    public static ConnectionPredicate deserializeConnectionPredicate(JsonObject json) throws JsonParseException{
        return PredicateRegistryImpl.deserializeConnectionPredicate(json);
    }
}
