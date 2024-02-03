package net.kuro.recrafted.structure.block.connectedtextures.predicate;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import net.kuro.recrafted.structure.block.connectedtextures.api.predicate.ConnectionDirection;
import net.kuro.recrafted.structure.block.connectedtextures.api.predicate.ConnectionPredicate;
import net.kuro.recrafted.structure.block.connectedtextures.api.predicate.RecraftedPredicateRegistry;
import net.kuro.recrafted.structure.block.connectedtextures.api.util.Serializer;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

public class NotConnectionPredicate implements ConnectionPredicate {

    public static final Serializer<NotConnectionPredicate> SERIALIZER = new Serializer<>() {
        @Override
        public NotConnectionPredicate deserialize(JsonObject json) throws JsonParseException{
            if(!json.has("predicate") || !json.get("predicate").isJsonObject())
                throw new JsonParseException("Not-predicate must have object property 'predicate'!");
            // Deserialize the predicate
            JsonArray array = json.getAsJsonArray("predicates");
            ConnectionPredicate predicate = RecraftedPredicateRegistry.deserializeConnectionPredicate(json.getAsJsonObject("predicate"));
            return new NotConnectionPredicate(predicate);
        }

        @Override
        public JsonObject serialize(NotConnectionPredicate value){
            JsonObject json = new JsonObject();
            json.add("predicates", RecraftedPredicateRegistry.serializeConnectionPredicate(value.predicate));
            return json;
        }
    };

    private final ConnectionPredicate predicate;

    public <T extends ConnectionPredicate> NotConnectionPredicate(T predicate){
        this.predicate = predicate;
    }

    @Override
    public boolean shouldConnect(Direction side, @Nullable BlockState ownState, BlockState otherState, BlockState blockInFront, ConnectionDirection direction){
        return !this.predicate.shouldConnect(side, ownState, otherState, blockInFront, direction);
    }

    @Override
    public Serializer<? extends ConnectionPredicate> getSerializer(){
        return SERIALIZER;
    }
}
