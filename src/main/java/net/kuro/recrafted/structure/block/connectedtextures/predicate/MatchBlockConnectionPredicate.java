package net.kuro.recrafted.structure.block.connectedtextures.predicate;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import net.kuro.recrafted.structure.block.connectedtextures.api.predicate.ConnectionDirection;
import net.kuro.recrafted.structure.block.connectedtextures.api.predicate.ConnectionPredicate;
import net.kuro.recrafted.structure.block.connectedtextures.api.util.Serializer;
import net.kuro.recrafted.structure.block.connectedtextures.util.IdentifierUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

public class MatchBlockConnectionPredicate implements ConnectionPredicate {

    public static final Serializer<MatchBlockConnectionPredicate> SERIALIZER = new Serializer<>() {
        @Override
        public MatchBlockConnectionPredicate deserialize(JsonObject json) throws JsonParseException{
            if(!json.has("block") || !json.get("block").isJsonPrimitive() || !json.getAsJsonPrimitive("block").isString())
                throw new JsonParseException("Match block predicate must have string property 'block'!");
            if(!IdentifierUtil.isValidIdentifier(json.get("block").getAsString()))
                throw new JsonParseException("Property 'block' must be a valid identifier!");
            Identifier identifier = new Identifier(json.get("block").getAsString());
            if(!Registries.BLOCK.containsId(identifier))
                throw new JsonParseException("Unknown block '" + identifier + "'!");
            Block block = Registries.BLOCK.get(identifier);
            return new MatchBlockConnectionPredicate(block);
        }

        @Override
        public JsonObject serialize(MatchBlockConnectionPredicate value){
            JsonObject json = new JsonObject();
            json.addProperty("block", Registries.BLOCK.getId(value.block).toString());
            return json;
        }
    };

    private final Block block;

    public MatchBlockConnectionPredicate(Block block){
        this.block = block;
    }

    @Override
    public boolean shouldConnect(Direction side, @Nullable BlockState ownState, BlockState otherState, BlockState blockInFront, ConnectionDirection direction){
        return otherState.getBlock() == this.block;
    }

    @Override
    public Serializer<? extends ConnectionPredicate> getSerializer(){
        return SERIALIZER;
    }
}
