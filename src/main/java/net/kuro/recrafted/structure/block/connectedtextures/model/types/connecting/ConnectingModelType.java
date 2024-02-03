package net.kuro.recrafted.structure.block.connectedtextures.model.types.connecting;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import net.kuro.recrafted.structure.block.connectedtextures.api.model.DefaultModelTypes;
import net.kuro.recrafted.structure.block.connectedtextures.api.model.ModelBakingContext;
import net.kuro.recrafted.structure.block.connectedtextures.api.model.ModelType;
import net.kuro.recrafted.structure.block.connectedtextures.api.model.data.ConnectingModelData;
import net.kuro.recrafted.structure.block.connectedtextures.api.predicate.ConnectionPredicate;
import net.kuro.recrafted.structure.block.connectedtextures.api.predicate.DefaultConnectionPredicates;
import net.kuro.recrafted.structure.block.connectedtextures.api.predicate.RecraftedPredicateRegistry;
import net.kuro.recrafted.structure.block.connectedtextures.api.util.Pair;
import org.jetbrains.annotations.Nullable;
import java.util.*;
import java.util.stream.Collectors;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.JsonUnbakedModel;
import net.minecraft.client.texture.MissingSprite;
import net.minecraft.util.Identifier;

public class ConnectingModelType implements ModelType<ConnectingModelData> {

    public static final Identifier DEFAULT_CONNECTION_KEY = new Identifier("mc-recrafted", "default");

    @Override
    public Collection<Identifier> getModelDependencies(ConnectingModelData data){
        return DefaultModelTypes.VANILLA.getModelDependencies(data.getVanillaModel());
    }

    @Override
    @Nullable
    public JsonUnbakedModel getAsVanillaModel(ConnectingModelData data){
        return DefaultModelTypes.VANILLA.getAsVanillaModel(data.getVanillaModel());
    }

    @Override
    public BakedModel bake(ModelBakingContext context, ConnectingModelData data){
        BakedModel model = DefaultModelTypes.VANILLA.bake(context, data.getVanillaModel());
        Map<Identifier, ConnectionPredicate> predicates = data.getAllConnectionPredicates().entrySet().stream()
                .map(entry -> Pair.of(entry.getKey().equals("default") ? DEFAULT_CONNECTION_KEY : data.getVanillaModel().resolveSprite(entry.getKey()).getTextureId(), entry.getValue()))
                .filter(pair -> !pair.left().equals(MissingSprite.getMissingSpriteId()))
                .collect(Collectors.toUnmodifiableMap(
                        Pair::left,
                        Pair::right,
                        DefaultConnectionPredicates::or
                ));
        return new ConnectingBakedModel(model, context.getTransformation().getRotation(), predicates);
    }

    @Override
    public ConnectingModelData deserialize(JsonObject json) throws JsonParseException{
        // Deserialize the vanilla model
        JsonUnbakedModel model = DefaultModelTypes.VANILLA.deserialize(json);
        // Deserialize all the predicates from the 'connections' array
        Map<String,ConnectionPredicate> predicates = new HashMap<>();
        predicates.put("default", DefaultConnectionPredicates.isSameState());
        if(json.has("connections")){
            JsonElement connectionsElement = json.get("connections");
            if(connectionsElement.isJsonArray() || (connectionsElement.isJsonObject() && connectionsElement.getAsJsonObject().has("type"))) // Legacy array
                predicates.put("default", loadPredicate(connectionsElement, "connections"));
            else if(connectionsElement.isJsonObject()){ // Load predicates per texture
                JsonObject object = connectionsElement.getAsJsonObject();
                if(object.isEmpty())
                    throw new JsonParseException("Property 'connections' must have a 'type' key or keys per texture!");
                for(String texture : object.keySet())
                    predicates.put(texture, loadPredicate(object.get(texture), texture));
            }else
                throw new JsonParseException("Property 'connections' must be an array!");
        }

        return new ConnectingModelDataImpl(model, predicates);
    }

    @Override
    public JsonObject serialize(ConnectingModelData value){
        JsonObject json = DefaultModelTypes.VANILLA.serialize(value.getVanillaModel());
        // Create an array with all the serialized predicates
        Map<String,ConnectionPredicate> predicates = value.getAllConnectionPredicates();
        if(predicates.size() == 1 && predicates.containsKey("default"))
            json.add("connections", RecraftedPredicateRegistry.serializeConnectionPredicate(predicates.get("default")));
        else if(!predicates.isEmpty()){
            JsonObject connectionsJson = new JsonObject();
            predicates.forEach((texture, predicate) -> connectionsJson.add(texture, RecraftedPredicateRegistry.serializeConnectionPredicate(predicate)));
            json.add("connections", connectionsJson);
        }
        return json.isEmpty() ? null : json;
    }

    private static ConnectionPredicate loadPredicate(JsonElement element, String key){
        if(element.isJsonArray()){
            JsonArray array = element.getAsJsonArray();
            List<ConnectionPredicate> subPredicates = new ArrayList<>();
            for(JsonElement predicateElements : array){
                if(!predicateElements.isJsonObject())
                    throw new JsonParseException("Predicate '" + key + "' must only contain objects!");
                ConnectionPredicate predicate = RecraftedPredicateRegistry.deserializeConnectionPredicate(predicateElements.getAsJsonObject());
                subPredicates.add(predicate);
            }
            return DefaultConnectionPredicates.or(subPredicates.toArray(ConnectionPredicate[]::new));
        }
        if(element.isJsonObject())
            return RecraftedPredicateRegistry.deserializeConnectionPredicate(element.getAsJsonObject());
        throw new JsonParseException("Predicate '" + key + "' must be an object or an array!");
    }
}
