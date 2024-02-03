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

public class IsSameBlockConnectionPredicate implements ConnectionPredicate {

    public static final Serializer<IsSameBlockConnectionPredicate> SERIALIZER = new Serializer<>() {
        @Override
        public IsSameBlockConnectionPredicate deserialize(JsonObject json) throws JsonParseException{
            return new IsSameBlockConnectionPredicate();
        }

        @Override
        public JsonObject serialize(IsSameBlockConnectionPredicate value){
            return null;
        }
    };

    @Override
    public boolean shouldConnect(Direction side, @Nullable BlockState ownState, BlockState otherState, BlockState blockInFront, ConnectionDirection direction){
        return ownState != null && otherState.getBlock() != Blocks.AIR && ownState.getBlock() == otherState.getBlock();
    }

    @Override
    public Serializer<? extends ConnectionPredicate> getSerializer(){
        return SERIALIZER;
    }
}
