package net.kuro.recrafted.structure.block.connectedtextures.predicate;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import net.kuro.recrafted.structure.block.connectedtextures.api.predicate.ConnectionDirection;
import net.kuro.recrafted.structure.block.connectedtextures.api.predicate.ConnectionPredicate;
import net.kuro.recrafted.structure.block.connectedtextures.api.predicate.RecraftedPredicateRegistry;
import net.kuro.recrafted.structure.block.connectedtextures.api.util.Serializer;
import org.jetbrains.annotations.Nullable;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.Direction;

public class OrConnectionPredicate implements ConnectionPredicate {

    public static final Serializer<OrConnectionPredicate> SERIALIZER = new Serializer<>() {
        @Override
        public OrConnectionPredicate deserialize(JsonObject json) throws JsonParseException{
            if(!json.has("predicates") || !json.get("predicates").isJsonArray())
                throw new JsonParseException("Or-predicate must have array property 'predicates'!");
            List<ConnectionPredicate> predicates = new ArrayList<>();
            // Deserialize all the predicates from the 'predicates' array
            JsonArray array = json.getAsJsonArray("predicates");
            for(JsonElement element : array){
                if(!element.isJsonObject())
                    throw new JsonParseException("Property 'predicates' must only contain objects!");
                ConnectionPredicate predicate = RecraftedPredicateRegistry.deserializeConnectionPredicate(element.getAsJsonObject());
                predicates.add(predicate);
            }
            return new OrConnectionPredicate(predicates);
        }

        @Override
        public JsonObject serialize(OrConnectionPredicate value){
            JsonObject json = new JsonObject();
            // Create an array with all the serialized predicates
            JsonArray predicatesJson = new JsonArray();
            for(ConnectionPredicate predicate : value.predicates)
                predicatesJson.add(RecraftedPredicateRegistry.serializeConnectionPredicate(predicate));
            json.add("predicates", predicatesJson);
            return json;
        }
    };

    private final List<ConnectionPredicate> predicates;

    public OrConnectionPredicate(List<ConnectionPredicate> predicates){
        this.predicates = predicates;
    }

    @Override
    public boolean shouldConnect(Direction side, @Nullable BlockState ownState, BlockState otherState, BlockState blockInFront, ConnectionDirection direction){
        return this.predicates.stream().anyMatch(predicate -> predicate.shouldConnect(side, ownState, otherState, blockInFront, direction));
    }

    @Override
    public Serializer<? extends ConnectionPredicate> getSerializer(){
        return SERIALIZER;
    }
}
