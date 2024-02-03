package net.kuro.recrafted.structure.block.connectedtextures.predicate;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import net.kuro.recrafted.structure.block.connectedtextures.api.predicate.ConnectionDirection;
import net.kuro.recrafted.structure.block.connectedtextures.api.predicate.ConnectionPredicate;
import net.kuro.recrafted.structure.block.connectedtextures.api.util.Serializer;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

public class IsSameStateConnectionPredicate implements ConnectionPredicate {

    public static final Serializer<IsSameStateConnectionPredicate> SERIALIZER = new Serializer<>() {
        @Override
        public IsSameStateConnectionPredicate deserialize(JsonObject json) throws JsonParseException{
            return new IsSameStateConnectionPredicate();
        }

        @Override
        public JsonObject serialize(IsSameStateConnectionPredicate value){
            return null;
        }
    };

    @Override
    public boolean shouldConnect(Direction side, @Nullable BlockState ownState, BlockState otherState, BlockState blockInFront, ConnectionDirection direction){
        return otherState.getBlock() != Blocks.AIR && ownState == otherState;
    }

    @Override
    public Serializer<? extends ConnectionPredicate> getSerializer(){
        return SERIALIZER;
    }
}
